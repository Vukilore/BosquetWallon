package be.ddo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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
			PreparedStatement statement = this.connect
					.prepareStatement("INSERT INTO Performance(beginDate, endDate, openDate, IdShow) VALUES(?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);

			statement.setString(1, String.valueOf(obj.getBeginDate().getTime()));
			statement.setString(2, String.valueOf(obj.getEndDate().getTime()));
			statement.setString(3, String.valueOf(obj.getOpenDate().getTime()));
			statement.setInt(4, obj.getShow().getId());
			statement.executeUpdate();
			return true;
		} catch (SQLException e) {
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
		Performance performance = null;
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery("SELECT * FROM Performance WHERE idPerformance = " + id);
			if (result.first()) {} 
				performance = new Performance(result);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return performance;
	}
	
	public Performance find(String date) {
		Performance performance = null;
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery("SELECT * FROM Performance WHERE beginDate LIKE '" + date + "'");
			if (result.first())
			{
				performance = new Performance(result);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return performance;
	}
}