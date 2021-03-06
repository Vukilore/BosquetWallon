package be.ddo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import be.ddo.POJO.Artist;
import be.ddo.POJO.Booking;
import be.ddo.POJO.Client;
import be.ddo.POJO.Manager;
import be.ddo.POJO.Organizer;
import be.ddo.POJO.User;

public class BookingDAO extends DAO<Booking> {
	public BookingDAO(Connection conn) {
		super(conn);
	}

	public boolean create(Booking obj) {
		try {
			this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeUpdate(
					"INSERT INTO Booking(deposit,solde,statut, price, idRoomPlanning, IdUser) VALUES('"
							+ obj.getDeposit() + "','" + obj.getSolde() + "','" + obj.getStatut() + "','"
							+ obj.getPrice() + "','" + obj.getRoomPlanning().getId() + "',"+obj.getOrganizer().getId()+")");
			System.out.println("Cr�ation du booking : " + obj);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean delete(Booking obj) {
		return false;
	}

	public boolean update(Booking obj) {
		return false;
	}

	public ArrayList<Booking> getAll() {
		ArrayList<Booking> listBooking = new ArrayList<Booking>();
		try {
			
			String request = "SELECT * FROM Booking";
			PreparedStatement preparedRequest = this.connect.prepareStatement(request);
			ResultSet result = preparedRequest.executeQuery();
			preparedRequest.close();
			while(result.next()) {
				 listBooking.add(new Booking(result));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listBooking;
	}

	public Booking find(int id) {
		Booking booking = null;
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery("SELECT * FROM User WHERE idUser = " + id);
			if (result.first()) {
				 
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return booking;
	}

	public Booking find(String email) {
		Booking user = null;
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery("SELECT * FROM User WHERE email LIKE '" + email + "'");
			if (result.first()) {
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
}
