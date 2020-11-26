/*
* POGO
*
* (c) Copyright 2020, Projet Java - Bosquet Wallon
*
* Name : RoomPlanning.java
* Description : Classe RoomPlanning
* Author : Donovan Dagnely
* Created : 01/11/2020
* Version : 0.0.1
*
*/


package be.ddo.POJO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import be.ddo.DAO.AbstractDAOFactory;
import be.ddo.DAO.DAO;

public class RoomPlanning {
	private int id;
	private Date beginDate;
	private Date endDate;
	private Show show;
	private int idUser;
	
	public RoomPlanning(Date endDate, Date beginDate) {
		this.endDate = endDate;
		this.beginDate = beginDate;
	}

	public RoomPlanning(Show show, Date beginDate, Date endDate) {
		this.beginDate = beginDate;
		this.endDate = endDate;
	}

	public RoomPlanning(ResultSet result) throws SQLException {
		this.id = result.getInt("id");
		this.beginDate = result.getDate("beginDate");
		this.endDate = result.getDate("endDate");
		this.idUser = result.getInt("IdUser");
	}

	public Date getEndDate() { return endDate; }
	public void setEndDate(Date endDate) { this.endDate = endDate; }

	public Show getShow() { return show; }
	public void setShow(Show show) { this.show = show; }

	public Date getBeginDate() { return beginDate; }
	public void setBeginDate(Date beginDate) { this.beginDate = beginDate; }

	public int getId() { return id; }
	public void setId(int id) { this.id = id; }

	public int getIdUser() { return idUser; }
	public void setIdUser(int idUser) { this.idUser = idUser; }
	
	public static ArrayList<RoomPlanning> getAll() {
		AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
		DAO<RoomPlanning> planningDAO = adf.getRoomPlanningDAO();
		return planningDAO.getAll();
	}
	
	@Override
	public String toString() {
		return "Réservé pour [" + beginDate + " jusqu'au " + endDate + "]("+id+")";
	}
}
