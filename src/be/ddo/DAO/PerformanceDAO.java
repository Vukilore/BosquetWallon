package be.ddo.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import be.ddo.POJO.Artist;
import be.ddo.POJO.Client;
import be.ddo.POJO.Organizer;
import be.ddo.POJO.Performance;
import be.ddo.POJO.User;

public class PerformanceDAO extends DAO<Performance> {
	public PerformanceDAO(Connection conn) {
		super(conn);
	}

	public boolean create(Performance obj) {
		try {
			this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeUpdate(
                    "INSERT INTO User(name,firstName,streetAddress,numberAddress,postalCodeAddress,cityAddress,Email,Password,Discriminator) VALUES('"
                            + obj.getName() + "','" + obj.getFirstName() + "','" + obj.getStreetAddress() + "','" + obj.getNumberAddress()
                            + "','" + obj.getPostalCodeAddress() + "','" + obj.getCityAddress() + "','" + obj.getEmail() + "','"
                            + obj.getPassword() + "','" + obj.getClass().getSimpleName().toString() + "')");
			return true;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean delete(Performance obj) {
		return false;
	}

	public boolean update(Performance obj) {
		return false;
	}
	
	/*public ArrayList<Artist> getAll() {
		ArrayList<Artist> listUser = new ArrayList<Artist>();
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery("SELECT * FROM User WHERE discriminator LIKES 'Artist'");
			while(result.next()) {
				Artist tmpUser = new Artist(result);
				listUser.add(tmpUser);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listUser;
	}*/
		
	public ArrayList<Performance> getAll() {
		ArrayList<Performance> listPerformance = new ArrayList<Performance>();
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery("SELECT * FROM Performance");
			while(result.next()) {
				listPerformance.add(new Performance(result));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listPerformance;
	}

	
	public Performance find(int id) {
		User user = new User();
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery("SELECT * FROM User WHERE idUser = " + id);
			if (result.first())
				user = new User(result);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	public Performance find(String email) {
		User user = null;
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery("SELECT * FROM User WHERE email LIKE '" + email + "'");
			if (result.first())
			{
				String discriminator;
				User tmpUser = new User(result);
				discriminator = result.getString("Discriminator");
				switch(discriminator)
				{
					case "Organizer" : 
						user = new Organizer(tmpUser);
						break;
					
					case "Client" : 
						user = new Client(tmpUser);
						break;
						
					case "Artist" : 
						user = new Artist(tmpUser);
						break;
					default : user = null;
				}
				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}