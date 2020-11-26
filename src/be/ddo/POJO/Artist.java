/*
* POGO
*
* (c) Copyright 2020, Projet Java - Bosquet Wallon
*
* Name : Artist.java
* Description : Classe Artist dérivée de User
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

public class Artist extends User {
	private static final long serialVersionUID = -7017651176353571337L;

	public Artist(String name, String firstName, String email, String password, String cityAddress,
			String streetAddress, String numberAddress, String postalCodeAddress) {
		super(name, firstName, email, password, cityAddress, streetAddress, numberAddress, postalCodeAddress);
	}

	public Artist(User user) {
		super(user);
	}

	public Artist(ResultSet result) throws SQLException {
		super(result);
	}

	public static ArrayList<Artist> getAll() {
		ArrayList<User> listUser = new ArrayList<User>();
		ArrayList<Artist> listArtist = new ArrayList<Artist>();
		AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
		DAO<User> userDAO = adf.getUserDAO();
		listUser = userDAO.getAll();
		for (User user : listUser)
			if (user instanceof Artist)
				listArtist.add((Artist) user);
		return listArtist;
	}
	
	/*public static Artist find(int i) {
		Artist artist;
		AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
		DAO<User> userDAO = adf.getUserDAO();
		artist = new Artist(userDAO.find(i));
		return artist;
	}*/
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	
}
