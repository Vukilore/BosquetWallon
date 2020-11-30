package be.ddo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import be.ddo.POJO.Booking;
import be.ddo.POJO.Command;

public class CommandDAO extends DAO<Command> {

	public CommandDAO(Connection conn) {
		super(conn);
	}
	@Override
	public boolean create(Command obj) {
		try {
			System.out.println("ICI APPEL");
			PreparedStatement statement = this.connect
					.prepareStatement("INSERT INTO Command(IdUser, shippingMethod, paymentMode, totalCost) VALUES(?, ?, ?, ?)");

			statement.setInt(1, obj.getIdUser());
			statement.setString(2, obj.getShippingMethod());
			statement.setString(3, obj.getPaymentMode());
			statement.setInt(4, obj.getTotalCost());
			statement.executeUpdate();
			ResultSet rs = statement.getGeneratedKeys();
            if(rs.next())
            {
                obj.setId(rs.getInt(1));
            }
			statement.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(Command obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Command obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Command> getAll() {
		ArrayList<Command> listCommand = new ArrayList<Command>();
		try {
			
			String request = "SELECT * FROM Command";
			PreparedStatement preparedRequest = this.connect.prepareStatement(request);
			ResultSet result = preparedRequest.executeQuery();
			preparedRequest.close();
			
			while(result.next()) {
				 listCommand.add(new Command(result));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listCommand;
	}

	@Override
	public Command find(int id) {
		Command command = null;
		try {
			
			String request = "SELECT * FROM Command Where idCommand = ?";
			PreparedStatement preparedRequest = this.connect.prepareStatement(request);
			preparedRequest.setInt(1, id);
			ResultSet result = preparedRequest.executeQuery();
			preparedRequest.close();
			
			if(result.first()) {
				 command = new Command(result);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return command;
	}

	@Override
	public Command find(String string) {
		// TODO Auto-generated method stub
		return null;
	}

}
