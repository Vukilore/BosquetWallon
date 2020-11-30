/*
* POGO
*
* (c) Copyright 2020, Projet Java - Bosquet Wallon
*
* Name : Seat.java
* Description : Classe Seat
* Author : Donovan Dagnely
* Created : 01/11/2020
* Version : 0.0.1
*
*/

package be.ddo.POJO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import be.ddo.DAO.AbstractDAOFactory;
import be.ddo.DAO.DAO;

public class Seat {
	private int id;
	private int idCommand;
	private int price;
	private int numSeat;
	private Performance performance;
	private String categoryType;
	
	//
	// GET/SET
	//
	public int getId() { return id; }
	public void setId(int id) { this.id = id; }
	
	public String getCategoryType() { return categoryType; }
	public void setCategoryType(String categoryType) { this.categoryType = categoryType; }
	
	public int getIdCommand() { return idCommand; }
	public void setIdCommand(int idCommand) { this.idCommand = idCommand; }
	
	public int getPrice() { return price; }
	public void setPrice(int price) { this.price = price; }
	
	public Performance getPerformance() { return performance; }
	public void setPerformance(Performance performance) { this.performance = performance; }
	
	public int getNumSeat() { return numSeat; }
	public void setNumSeat(int numSeat) { this.numSeat = numSeat; }
	
	public Seat(CategoryType categoryType, Performance performance, int numSeat, int price) {
		this.categoryType = categoryType.toString();
		this.performance = performance;
		this.price = price;
		this.setNumSeat(numSeat);
	}
	public Seat(ResultSet result) throws SQLException {
		this.id = result.getInt("idSeat");
		this.idCommand = result.getInt("IdCommand");
		this.price = result.getInt("price");
		this.numSeat = result.getInt("numSeat");
		this.categoryType = result.getString("categoryType");
		Performance perf = new Performance(result.getInt("IdPerformance"));
		this.performance = perf.find();
		
	}
	public static ArrayList<Seat> getAll() {
		AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
		DAO<Seat> seatDAO = adf.getSeatDAO();
		return seatDAO.getAll();
	}
	public void create() {
		AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
		DAO<Seat> seatDAO = adf.getSeatDAO();
		seatDAO.create(this);
	}
	
}
