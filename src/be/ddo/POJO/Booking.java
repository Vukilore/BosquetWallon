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

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import be.ddo.DAO.AbstractDAOFactory;
import be.ddo.DAO.DAO;

public class Booking {
	private int deposit; // Acompte
	private int solde; // Solde
	private int price; // Prix
	private Organizer organizer;
	private String statut;
	private RoomPlanning roomPlanning;

	public int getDeposit() { return deposit; }
	public void setDeposit(int deposit) { this.deposit = deposit; }

	public int getSolde() { return solde; }
	public void setSolde(int solde) { this.solde = solde; }

	public int getPrice() { return price; }
	public void setPrice(int price) { this.price = price; }

	public Organizer getOrganizer() { return organizer; }
	public void setOrganizer(Organizer user) { this.organizer = user; }

	public String getStatut() { return statut; }
	public void setStatut(String statut) { this.statut = statut; }
	
	public RoomPlanning getRoomPlanning() { return roomPlanning; }
	public void setRoomPlanning(RoomPlanning roomPlanning) { this.roomPlanning = roomPlanning; }
	
	public Booking(RoomPlanning roomPlanning, Organizer organizer, int price, int deposit) {
		this.roomPlanning = roomPlanning;
		this.organizer = organizer;
		this.price = price;
		this.deposit = deposit;
		int _solde = (price - deposit);
		this.solde = _solde;
		if(_solde == 0)	this.statut = "Payé";
		else this.statut = "Non payé";
	}
	
	public Booking(ResultSet result) throws SQLException {
		RoomPlanning rp = new RoomPlanning(result.getInt("IdRoomPlanning"));
		Organizer organizer = new Organizer(result.getInt("IdUser"));
		
		this.roomPlanning = rp.find();
		this.organizer = organizer;
		this.price = result.getInt("price");
		this.deposit = result.getInt("deposit");
		this.solde = result.getInt("solde");
		this.statut = result.getString("statut");
		
	}
	public static ArrayList<Booking> getAll() {
		AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
		DAO<Booking> bookingDAO = adf.getBookingDAO();
		return bookingDAO.getAll();
	}
	
	public void create() {
		AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
		DAO<Booking> bookingDAO = adf.getBookingDAO();
		bookingDAO.create(this);
	}

	
	@Override
	public String toString() {
		return "Réservation de "+organizer.getFirstName() +" " + organizer.getName() +" : "+statut+" Solde restant :" + solde + "€";
	}
}