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
	
	/*public static ArrayList<Performance> getAll() {
		AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
		DAO<Performance> performanceDAO = adf.getPerformanceDAO();
		return performanceDAO.getAll();
	}
	*/
	public void create() {
		AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
		DAO<Performance> performanceDAO = adf.getPerformanceDAO();
		performanceDAO.create(this);
	}
	
	public Performance(Date beginDate, Date openDate, Date endDate, Show show) {
		this.beginDate = beginDate;
		this.openDate = openDate;
		this.endDate = endDate;
		this.show = show;		
	}
	public Performance(ResultSet result) throws SQLException {
		this.id = result.getInt("IdPerformance");
		this.beginDate = new Date(Long.parseLong(result.getString("beginDate")));
		this.endDate = new Date(Long.parseLong(result.getString("endDate")));
		this.openDate = new Date(Long.parseLong(result.getString("openDate")));		
	} 
	public Performance(ResultSet result, Show show) throws SQLException {
		this.id = result.getInt("IdPerformance");
		this.beginDate = new Date(Long.parseLong(result.getString("beginDate")));
		this.endDate = new Date(Long.parseLong(result.getString("endDate")));
		this.openDate = new Date(Long.parseLong(result.getString("openDate")));
		this.show = show;
		System.out.println(endDate);
	} 
	
	@Override
	public String toString() {
		if(openDate != null && endDate != null && beginDate != null)
			return "("+openDate.getDate()+"/"+openDate.getMonth()+")[De " + openDate.getHours() + "h  à " + endDate.getHours() + "h | Début: " + beginDate.getHours() + "h]";
		else return "Date indisponible";
	}
}
