package be.ddo.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import be.ddo.POJO.Artist;
import be.ddo.POJO.Client;
import be.ddo.POJO.Organizer;
import be.ddo.POJO.User;

public class UserDAO extends DAO<User> {
	public UserDAO(Connection conn) {
		super(conn);
	}

	public boolean create(User obj) {
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

	public boolean delete(User obj) {
		return false;
	}

	public boolean update(User obj) {
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
		
	public ArrayList<User> getAll() {
		ArrayList<User> listUser = new ArrayList<User>();
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery("SELECT * FROM User");
			while(result.next()) {
				User user = null;
				User tmpUser = new User(result);
				String discriminator = result.getString("Discriminator");
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
				}
				listUser.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listUser;
	}

	
	public User find(int id) {
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
	
	public User find(String email) {
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