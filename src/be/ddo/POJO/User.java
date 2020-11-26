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



package be.ddo.POJO;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

import be.ddo.DAO.AbstractDAOFactory;
import be.ddo.DAO.DAO;


public class User implements Serializable {
	private static final long serialVersionUID = 1556913528679288788L;
	protected int id;
	protected String name;
	protected String firstName;
	protected String password;
	protected String email;
	protected String cityAddress;
	protected String postalCodeAddress;
	protected String streetAddress;	
	protected String numberAddress;
	
	public User() {}
	
	public User(User user) {
		this.id = user.id;
		this.name = user.getName();
		this.firstName = user.getFirstName();
		this.email = user.getEmail();
		this.password = user.getPassword();
		this.cityAddress = user.getCityAddress();
		this.streetAddress = user.getStreetAddress();
		this.numberAddress = user.getNumberAddress();
		this.postalCodeAddress = user.getPostalCodeAddress();
	}
	
	public User(int _id, String _name, String _firstName) {
		id = _id;
		name =_name;
		firstName = _firstName;
		
	}
	
	public User(String name, String firstName, String email, String password, String cityAddress, String streetAddress, String numberAddress, String postalCodeAddress)
	{
		this.name = name;
		this.firstName = firstName;
		this.email = email;
		this.password = password;
		this.cityAddress = cityAddress;
		this.streetAddress = streetAddress;
		this.numberAddress = numberAddress;
		this.postalCodeAddress = postalCodeAddress;		
	}
	
	//
	//	GET/SET
	//
	
	public User(ResultSet result) throws SQLException {
		this.id = result.getInt("idUser");
		this.name = result.getString("name");
		this.firstName = result.getString("firstName");
		this.email = result.getString("email");
		this.password = result.getString("password");
		this.cityAddress = result.getString("cityAddress");
		this.streetAddress = result.getString("streetAddress");
		this.numberAddress = result.getString("numberAddress");
		this.postalCodeAddress = result.getString("postalCodeAddress");	
	}

	public int getId() { return id; }
	public void setId(int id) {	this.id = id; }
	
	public String getName() { return name; }
	public void setName(String nom) { this.name = nom; }
	
	public String getFirstName() { return firstName; }
	public void setFirstName(String prenom) { this.firstName = prenom; }
	
	public String getPassword() { return password; }
	public void setPassword(String password) { this.password = password; }
	
	public String getEmail() { return email; }
	public void setEmail(String email) { this.email = email; }
	
	public String getCityAddress() { return cityAddress; }
	public void setCityAddress(String cityAddress) { this.cityAddress = cityAddress; }
	
	public String getPostalCodeAddress() { return postalCodeAddress; }
	public void setPostalCodeAddress(String postalCodeAddress) { this.postalCodeAddress = postalCodeAddress;}
	
	public String getStreetAddress() { return streetAddress; }
	public void setStreetAddress(String streetAddress) { this.streetAddress = streetAddress; }
	
	public String getNumberAddress() { return numberAddress; }
	public void setNumberAddress(String numberAddress) { this.numberAddress = numberAddress; }
	
	
	//
	// OVERRIDE
	//
	@Override
	public String toString() { return firstName + " " + name; }
	
	//
	// FONCTIONS
	//
	
	// Vérifie la validité d'un email
	public boolean isValidEmail() {
		   String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		   return this.email.matches(regex);
	}
	
	// Vérifie si un attribut est vide ou rempli d'espace
	public boolean blankfField() {
		return this.getName().isBlank() || this.getFirstName().isBlank() || this.getEmail().isBlank() || this.getPassword().isBlank() || 
				this.getCityAddress().isBlank() || this.getStreetAddress().isBlank() || this.getNumberAddress().isBlank() ||
				this.getPostalCodeAddress().isBlank();
	}
	
	public boolean userExist() {
		AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
		DAO<User> userDAO = adf.getUserDAO();
		return userDAO.find(this.email) != null;
	}

	public void create() {
		AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
		DAO<User> userDAO = adf.getUserDAO();
		userDAO.create(this);
	}
	
	public static User find(String email) {
		AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
		DAO<User> userDAO = adf.getUserDAO();
		return userDAO.find(email);
	}
	

	
}
