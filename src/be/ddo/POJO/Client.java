/*
* POGO
*
* (c) Copyright 2020, Projet Java - Bosquet Wallon
*
* Name : Client.java
* Description : Classe Client dérivée de User
* Author : Donovan Dagnely
* Created : 01/11/2020
* Version : 0.0.1
*
*/

package be.ddo.POJO;

public class Client extends User {
	private static final long serialVersionUID = -4447211398508175156L;
	
	public Client(String name, String firstName, String email, String password, String cityAddress, String streetAddress, String numberAddress, String postalCodeAddress)
	{
		super(name, firstName, email, password, cityAddress, streetAddress, numberAddress, postalCodeAddress);	
	}
	
	public Client(User user) { super(user); }
}