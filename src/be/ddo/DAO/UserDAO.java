package be.ddo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import be.ddo.POJO.Artist;
import be.ddo.POJO.Client;
import be.ddo.POJO.Manager;
import be.ddo.POJO.Organizer;
import be.ddo.POJO.User;

public class UserDAO extends DAO<User> {
	public UserDAO(Connection conn) {
		super(conn);
	}

	public boolean create(User obj) {
		try {
			PreparedStatement statement = this.connect
					.prepareStatement("INSERT INTO User(name,firstName,streetAddress,numberAddress,postalCodeAddress,cityAddress,Email,Password,Discriminator) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)");

			statement.setString(1, obj.getName());
			statement.setString(2, obj.getFirstName());
			statement.setString(3, obj.getStreetAddress());
			statement.setString(4, obj.getNumberAddress());
			statement.setString(5, obj.getPostalCodeAddress());
			statement.setString(6, obj.getCityAddress());
			statement.setString(7, obj.getEmail());
			statement.setString(8, obj.getPassword());
			statement.setString(9, obj.getClass().getSimpleName().toString());
			statement.executeUpdate();
			System.out.println("Création de l'user : " + obj);
			return true;
		} catch (SQLException e) {
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

	public ArrayList<User> getAll() {
		ArrayList<User> listUser = new ArrayList<User>();
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery("SELECT * FROM User");
			while (result.next()) {
				User user = null;
				User tmpUser = new User(result);
				String discriminator = result.getString("Discriminator");
				switch (discriminator) {
				case "Organizer":
					user = new Organizer(tmpUser);
					((Organizer) user).getAllBookings();
					break;

				case "Client":
					user = new Client(tmpUser);
					break;

				case "Artist":
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
		User user = null;
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery("SELECT * FROM User WHERE idUser = " + id);
			if (result.first()) {
				String discriminator;
				User tmpUser = new User(result);
				discriminator = result.getString("Discriminator");
				switch(discriminator)
				{
					case "Organizer" : 
						user = new Organizer(tmpUser);	
						((Organizer) user).getAllBookings();
						break;
					
					case "Client" : 
						user = new Client(tmpUser);
						break;
						
					case "Artist" : 
						user = new Artist(tmpUser);
						break;
					case "Manager" : 
						user = new Manager(tmpUser);
						break;
					default : user = null;
				}
			}			
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
			if (result.first()) {
				String discriminator;
				User tmpUser = new User(result);
				discriminator = result.getString("Discriminator");
				switch (discriminator) {
				case "Organizer":
					user = new Organizer(tmpUser);
					((Organizer) user).getAllBookings();
					break;
				case "Client":
					user = new Client(tmpUser);
					break;
				case "Artist":
					user = new Artist(tmpUser);
					break;
				case "Manager":
					user = new Manager(tmpUser);
					break;
				default:
					user = null;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
}
