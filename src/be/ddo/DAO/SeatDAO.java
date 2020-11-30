package be.ddo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import be.ddo.POJO.Booking;
import be.ddo.POJO.Command;
import be.ddo.POJO.Seat;

public class SeatDAO extends DAO<Seat> {

	public SeatDAO(Connection conn) {
		super(conn);
	}
	@Override
	public boolean create(Seat obj) {
		try {
			PreparedStatement statement = this.connect
					.prepareStatement("INSERT INTO Seat(numSeat, price, IdPerformance, IdCommand, categoryType) VALUES(?, ?, ?, ?, ?)");

			statement.setInt(1, obj.getNumSeat());
			statement.setInt(2, obj.getPrice());
			statement.setInt(3, obj.getPerformance().getId());
			statement.setInt(4, obj.getIdCommand());
			statement.setString(5, obj.getCategoryType());
			statement.executeUpdate();
			statement.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(Seat obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Seat obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Seat> getAll() {
		ArrayList<Seat> listSeat = new ArrayList<Seat>();
		try {
			
			String request = "SELECT * FROM Command";
			PreparedStatement preparedRequest = this.connect.prepareStatement(request);
			ResultSet result = preparedRequest.executeQuery();
			preparedRequest.close();
			
			while(result.next()) {
				listSeat.add(new Seat(result));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listSeat;
	}

	@Override
	public Seat find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Seat find(String email) {
		// TODO Auto-generated method stub
		return null;
	}

}
