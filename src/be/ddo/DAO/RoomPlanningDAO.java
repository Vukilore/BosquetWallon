package be.ddo.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
			this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeUpdate(
                    "INSERT INTO RoomPlanning(beginDate,endDate,IdShow,IdUser) VALUES('"
                            + obj.getBeginDate() + "','" + obj.getEndDate() + "','" + obj.getShow().getId() + "','" + obj.getIdUser() + "')");
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
				rp.setShow(Show.find(result.getInt("IdShow")));
				listPlannings.add(rp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listPlannings;
	}

	public RoomPlanning find(int id) {
		RoomPlanning rp = null;
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery("SELECT * FROM User WHERE idUser = " + id);
			if (result.first()) {}
				rp = new RoomPlanning(result);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rp;
	}
	
	public RoomPlanning find(String date) {
		RoomPlanning rp = null;
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery("SELECT * FROM User WHERE email LIKE '" + date + "'");
			if (result.first())
			{
				 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rp;
	}
}
