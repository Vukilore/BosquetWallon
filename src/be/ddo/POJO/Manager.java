/*
* POGO
*
* (c) Copyright 2020, Projet Java - Bosquet Wallon
*
* Name : Manager.java
* Description : Classe Manager
* Author : Donovan Dagnely
* Created : 01/11/2020
* Version : 0.0.1
*
*/

package be.ddo.POJO;

public class Manager extends User {
	public Manager(User user) {
		super(user);
	}
	public Manager(String name, String firstName, String email, String password, String cityAddress, String streetAddress, String numberAddress, String postalCodeAddress) {
		super(name, firstName, email, password, cityAddress, streetAddress, numberAddress, postalCodeAddress);
	}
	private static final long serialVersionUID = 6177578679763491932L;

}
