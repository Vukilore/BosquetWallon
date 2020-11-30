/*
* POGO
*
* (c) Copyright 2020, Projet Java - Bosquet Wallon
*
* Name : Organizer.java
* Description : Classe Organizer dérivée de User
* Author : Donovan Dagnely
* Created : 01/11/2020
* Version : 0.0.1
*
*/

package be.ddo.POJO;

import java.util.ArrayList;

import be.ddo.DAO.AbstractDAOFactory;
import be.ddo.DAO.DAO;

public class Organizer extends User {
	private static final long serialVersionUID = -3879113998006029020L;
	private ArrayList<Booking> listBooking = new ArrayList<Booking>();

	public ArrayList<Booking> getListBooking() { return listBooking; }
	public void setListBooking(ArrayList<Booking> listBooking) { this.listBooking = listBooking; }

	
	public Organizer(String name, String firstName, String email, String password, String cityAddress, String streetAddress, String numberAddress, String postalCodeAddress) {
		super(name, firstName, email, password, cityAddress, streetAddress, numberAddress, postalCodeAddress);

	}

	// Constructeur de loading
	public Organizer(User user) {
		super(user);
	}
	
	public Organizer(int id) { this.id = id; }

	public void getAllBookings() {
		ArrayList<Booking> tmplistOfBooking = new ArrayList<Booking>();
		ArrayList<Booking> listOfBooking = Booking.getAll();
		if(listOfBooking.size() > 0) {
			for (Booking b : listOfBooking)  {
				if (b.getOrganizer().getId() == this.id) {
					System.out.println(b + "EST APPELE");
					listBooking.add(b);
					b.setOrganizer(this);
				}
			}
		}	
		System.out.println(listBooking);
	}
	
	public Organizer find() {
		AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
		DAO<User> userDAO = adf.getUserDAO();
		return (Organizer) userDAO.find(this.id);
	}
}
