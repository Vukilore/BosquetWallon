/*
* POGO
*
* (c) Copyright 2020, Projet Java - Bosquet Wallon
*
* Name : Command.java
* Description : Classe Command
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

public class Command {
	private int id;
	private String paymentMode;
	private String shippingMethod;
	private int totalCost;
	private int idUser;
	private ArrayList<Seat> listSeat;
	
	public String getPaymentMode() { return paymentMode; }
	public void setPaymentMode(String paymentMode) { this.paymentMode = paymentMode; }
	
	public String getShippingMethod() { return shippingMethod; }
	public void setShippingMethod(String shippingMethod) { this.shippingMethod = shippingMethod; }
	
	public int getTotalCost() { return totalCost; }
	public void setTotalCost(int totalCost) { this.totalCost = totalCost; }
	
	public int getIdUser() { return idUser; }
	public void setIdUser(int idUser) { this.idUser = idUser; }
	
	public ArrayList<Seat> getListSeat() { return listSeat; }
	public void setListSeat(ArrayList<Seat> listSeat) { this.listSeat = listSeat; }
	
	public int getId() { return id; }
	public void setId(int id) { this.id = id; }
	
	public Command(int idUser, CommandType shipping, CommandType payement, int totalCost, ArrayList<Seat> listSeat) {
		this.idUser = idUser;
		this.shippingMethod = shipping.toString();
		this.paymentMode = payement.toString();
		this.totalCost = totalCost;
		this.listSeat = listSeat;
	}
	
	public Command(ResultSet result) throws SQLException {
		this.id = result.getInt("IdCommand");
		this.paymentMode = result.getString("paymentMode");
		this.shippingMethod = result.getString("shippingMethod");
		this.totalCost = result.getInt("totalCost");
		this.idUser = result.getInt("IdUser");
	}
	
	public void create() {
		AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
		DAO<Command> commandDAO = adf.getCommandDAO();
		commandDAO.create(this);		
	}

	public void save() {
		AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
		DAO<Command> commandDAO = adf.getCommandDAO();
		commandDAO.update(this);		
	}
	
	public void getAllSeat() {
		ArrayList<Seat> listOfSeat = Seat.getAll();
		ArrayList<Seat> tmplistOfSeat = new ArrayList<Seat>();
		if(listOfSeat.size() > 0) {
			for (Seat s : listOfSeat)  {
				if (s.getIdCommand() == this.id) {
					tmplistOfSeat.add(s);
				}
			}
			this.setListSeat(tmplistOfSeat);
		}	
	}
	
	
	
	
}
