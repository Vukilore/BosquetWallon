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

public class Organizer extends User {
	private static final long serialVersionUID = -3879113998006029020L;
	
	public Organizer(String name, String firstName, String email, String password, String cityAddress, String streetAddress, String numberAddress, String postalCodeAddress)
	{
		super(name, firstName, email, password, cityAddress, streetAddress, numberAddress, postalCodeAddress);		
	}

	public Organizer(User user) { super(user);	}
}
