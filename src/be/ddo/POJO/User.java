/*
* POGO
*
* (c) Copyright 2020, Projet Java - Bosquet Wallon
*
* Name : User.java
* Description : Classe Mère User pour les infos de chaque utilisateurs
* Author : Donovan Dagnely
* Created : 01/11/2020
* Version : 0.0.1
*
*/



package be.ddo.POGO;

import java.io.Serializable;

public class User implements Serializable {
	private static final long serialVersionUID = 1556913528679288788L;
	protected String name;
	protected String firstName;
	protected String password;
	protected String email;
	protected String cityAddress;
	protected String postalCodeAddress;
	protected String streetAddress;	
	protected String numberAddress;
}
