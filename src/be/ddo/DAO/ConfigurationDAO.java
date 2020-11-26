package be.ddo.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import be.ddo.POJO.Artist;
import be.ddo.POJO.Category;
import be.ddo.POJO.Client;
import be.ddo.POJO.Configuration;
import be.ddo.POJO.Manager;
import be.ddo.POJO.Organizer;
import be.ddo.POJO.User;

public class ConfigurationDAO extends DAO<Configuration> {
	public ConfigurationDAO(Connection conn) {
		super(conn);
	}

	public boolean create(Configuration obj) {
		try {
			// Sauvegarde de la configuration
			Statement stmt = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			stmt.executeUpdate("INSERT INTO Configuration(type, IdShow) VALUES('" + obj.getConfigurationType() + "','"
					+ obj.getIdShow() + "')", Statement.RETURN_GENERATED_KEYS);
			System.out.println("Création de la configuration : " + obj);
			ResultSet rs = stmt.getGeneratedKeys();
			int lastId = -1;
			if (rs.next())
				lastId = rs.getInt(1);

			// Création des catégories
			for(Category cat : obj.getCategoryList()) {
				cat.setIdConfiguration(lastId);
				cat.create();
			}
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean delete(Configuration obj) {
		try {
			// D'abord delete les category
			for(Category cat : obj.getCategoryList())
				cat.destroy();
			
			// Ensuite la configuration
			this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
			.executeUpdate("DELETE FROM Configuration WHERE IdConfiguration =" + obj.getId() + "')");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean update(Configuration obj) {
		return false;
	}

	public ArrayList<Configuration> getAll() {
		return null;
	}

	public Configuration find(int id) {
		Configuration configuration = null;
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery("SELECT * FROM Configuration WHERE idShow = " + id);
			if (result.first()) 
				configuration = new Configuration(result);
			
			configuration.getAllCategories();		
		}catch(SQLException e)
		{
			e.printStackTrace();
		}return configuration;
	}

	public Configuration find(String config) {
		return null;
	}

}
