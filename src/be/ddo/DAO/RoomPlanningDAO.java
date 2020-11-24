package be.ddo.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import be.ddo.POJO.Artist;
import be.ddo.POJO.Client;
import be.ddo.POJO.Organizer;
import be.ddo.POJO.RoomPlanning;
import be.ddo.POJO.User;

public class RoomPlanningDAO extends DAO<RoomPlanning> {
	public RoomPlanningDAO(Connection conn) {
		super(conn);
	}

	public boolean create(RoomPlanning obj) {
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

	public boolean delete(RoomPlanning obj) {
		return false;
	}

	public boolean update(RoomPlanning obj) {
		return false;
	}
	
	public ArrayList<RoomPlanning> getAll() {
		ArrayList<RoomPlanning> listPlanning = new ArrayList<RoomPlanning>();
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery("SELECT * FROM RoomPlanning");
			while(result.next()) {
				listPlanning.add(new RoomPlanning(result));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listPlanning;
	}

	
	public RoomPlanning find(int id) {
		RoomPlanning user = new RoomPlanning();
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
	
	public RoomPlanning find(String email) {
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
