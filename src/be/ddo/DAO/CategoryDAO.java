package be.ddo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import be.ddo.POJO.Category;

public class CategoryDAO extends DAO<Category> {

	public CategoryDAO(Connection conn) {
		super(conn);
	}

	@Override
	public boolean create(Category obj) {
		try {
			this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
			.executeUpdate("INSERT INTO Category(IdConfiguration, type, seatLeft, price) VALUES('" + obj.getIdConfiguration()
					+ "','" + obj.getType() + "','" + obj.getSeatLeft() +"','" + obj.getPrice() +"')");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(Category obj) {
		try {
			this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
			.executeUpdate("DELETE FROM Category WHERE IdCategory =" + obj.getId() + "')");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(Category obj) {
		try {
			String request = "UPDATE Category SET seatLeft = ? WHERE IdCategory = ?";
			PreparedStatement preparedReq = this.connect.prepareStatement(request);
			preparedReq.setInt(1, obj.getSeatLeft());
			preparedReq.setInt(2, obj.getId());
			preparedReq.executeUpdate();
			preparedReq.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public ArrayList<Category> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Category find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Category find(String email) {
		// TODO Auto-generated method stub
		return null;
	}

}
