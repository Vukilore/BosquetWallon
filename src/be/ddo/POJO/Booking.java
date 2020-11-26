/*
* POGO
*
* (c) Copyright 2020, Projet Java - Bosquet Wallon
*
* Name : Booking.java
* Description : Classe Booking
* Author : Donovan Dagnely
* Created : 01/11/2020
* Version : 0.0.1
*
*/

package be.ddo.POJO;

import java.util.ArrayList;

import be.ddo.DAO.AbstractDAOFactory;
import be.ddo.DAO.DAO;

public class Booking {
	

	private int deposit; // Acompte
	private int solde; // Solde
	private int price; // Prix
	private int userId;
	private String statut;
	private RoomPlanning roomPlanning;

	public int getDeposit() { return deposit; }
	public void setDeposit(int deposit) { this.deposit = deposit; }

	public int getSolde() { return solde; }
	public void setSolde(int solde) { this.solde = solde; }

	public int getPrice() { return price; }
	public void setPrice(int price) { this.price = price; }

	public int getUserId() { return userId; }
	public void setUserId(int userId) { this.userId = userId; }

	public String getStatut() { return statut; }
	public void setStatut(String statut) { this.statut = statut; }
	
	public RoomPlanning getRoomPlanning() { return roomPlanning; }
	public void setRoomPlanning(RoomPlanning roomPlanning) { this.roomPlanning = roomPlanning; }
	
	public Booking(int deposit, int solde, int price, int userId, String statut) {
		super();
		this.deposit = deposit;
		this.solde = solde;
		this.price = price;
		this.userId = userId;
		this.statut = statut;
	}
	
	public static ArrayList<Booking> getAllFromOrganizer(int id) {
		AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
		DAO<Booking> bookingDAO = adf.getBookingDAO();
		ArrayList<Booking> listBookingDAO = bookingDAO.getAll();
		ArrayList<Booking> listBooking = new ArrayList<Booking>();
		for (Booking b : listBookingDAO) 
			if (b.getUserId() == id)
				listBooking.add(b);
		return listBooking;
	}

}