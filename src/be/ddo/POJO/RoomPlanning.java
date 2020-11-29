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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import be.ddo.DAO.AbstractDAOFactory;
import be.ddo.DAO.DAO;

public class RoomPlanning {
	private int id;
	private Date beginDate;
	private Date endDate;
	private Show show;
	
	public RoomPlanning(Date endDate, Date beginDate) {
		this.endDate = endDate;
		this.beginDate = beginDate;
	}

	public RoomPlanning(int idUser, Show show, Date beginDate, Date endDate) {
		this.beginDate = beginDate;
		this.endDate = endDate;
		this.show = show;
	}

	public RoomPlanning(ResultSet result) throws SQLException {
		this.id = result.getInt("IdRoomPlanning");		
		this.beginDate = result.getDate("beginDate");
		this.endDate = result.getDate("endDate");		
	}

	public RoomPlanning(int id) {
		this.id = id;
	}

	public int getId() { return id; }
	public void setId(int id) { this.id = id; }

	public Date getEndDate() { return endDate; }
	public void setEndDate(Date endDate) { this.endDate = endDate; }

	public Show getShow() { return show; }
	public void setShow(Show show) { this.show = show; }

	public Date getBeginDate() { return beginDate; }
	public void setBeginDate(Date beginDate) { this.beginDate = beginDate; }

	public static ArrayList<RoomPlanning> getAll() {
		AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
		DAO<RoomPlanning> planningDAO = adf.getRoomPlanningDAO();
		return planningDAO.getAll();
	}
	
	public void create() {
		AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
		DAO<RoomPlanning> planningDAO = adf.getRoomPlanningDAO();
		planningDAO.create(this);
	}

	public RoomPlanning find() {
		AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
		DAO<RoomPlanning> planningDAO = adf.getRoomPlanningDAO();
		return planningDAO.find(this.id);
	}

	@Override
	public String toString() {
		return "Réservé pour [" + beginDate.getDate() +"/" + beginDate.getMonth() + " jusqu'au " + endDate.getDate() + "/"+endDate.getMonth()+"]("+id+")";
	}

	
}
