package be.ddo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import be.ddo.POJO.Artist;
import be.ddo.POJO.Client;
import be.ddo.POJO.Organizer;
import be.ddo.POJO.RoomPlanning;
import be.ddo.POJO.Show;
import be.ddo.POJO.User;

public class RoomPlanningDAO extends DAO<RoomPlanning> {
	public RoomPlanningDAO(Connection conn) {
		super(conn);
	}

	public boolean create(RoomPlanning obj) {
		try {
			PreparedStatement statement = this.connect.prepareStatement(
		            "INSERT INTO RoomPlanning(beginDate,endDate,IdShow) VALUES(?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
		    statement.setObject(1, obj.getBeginDate());
		    statement.setObject(2, obj.getEndDate());
		    statement.setInt(3, obj.getShow().getId());
		    statement.executeUpdate();
		    ResultSet rs = statement.getGeneratedKeys();
            if(rs.next())
            {
                obj.setId(rs.getInt(1));
            }
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
		ArrayList<RoomPlanning> listPlannings = new ArrayList<RoomPlanning>();
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery("SELECT * FROM RoomPlanning");
			while(result.next()) {
				RoomPlanning rp = new RoomPlanning(result);
				Show show = new Show(result.getInt("IdShow"));
				rp.setShow(show.find());
				listPlannings.add(rp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listPlannings;
	}
	
	public RoomPlanning find(int id) { return null; }

	public RoomPlanning find(String date) {
		RoomPlanning rp = null;
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery("SELECT * FROM RoomPlanning WHERE beginDate LIKE '" + date + "'");
			if (result.first())
			{
				rp = new RoomPlanning(result);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rp;
	}
}
