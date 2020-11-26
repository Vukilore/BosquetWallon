/*
* POGO
*
* (c) Copyright 2020, Projet Java - Bosquet Wallon
*
* Name : Performance.java
* Description : Classe Performance
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

public class Performance {
	

	private int id;
	private Date beginDate;
	private Date endDate;  
	private Date openDate;
	private Show show;
	
	public int getId() { return id; }
	public void setId(int id) { this.id = id; }
	
	public Date getBeginDate() { return beginDate; }
	public void setBeginDate(Date beginDate) { this.beginDate = beginDate; }
	
	public Date getEndDate() { return endDate; }
	public void setEndDate(Date endDate) { this.endDate = endDate; }
	
	public Show getShow() { return show; }
	public void setShow(Show show) { this.show = show; }
	
	public Date getOpenDate() { return openDate; }
	public void setOpenDate(Date openDate) { this.openDate = openDate; }
	
	public Performance(Show show, Date beginDate, Date endDate) {
		this.show = show;
		this.beginDate = beginDate;
		this.endDate = endDate;
	}
	
	public static ArrayList<Performance> getAll() {
		AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
		DAO<Performance> performanceDAO = adf.getPerformanceDAO();
		return performanceDAO.getAll();
	}
	
	public Performance(ResultSet result) throws SQLException {
		this.id = result.getInt("IdPerformance");
		this.beginDate = result.getDate("beginDate");
		this.endDate = result.getDate("endDate");
		this.show = Show.find(result.getInt("IdShow"));
	}	
	
	@Override
	public String toString() {
		return "[" + show.getTitle() + ": \n Date du début :" + beginDate + "\n Date de fin : " + endDate + " \n Date ouverture des portes :" + openDate + "]";
	}
}
