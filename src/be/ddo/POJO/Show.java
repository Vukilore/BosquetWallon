/*
* POGO
*
* (c) Copyright 2020, Projet Java - Bosquet Wallon
*
* Name : Show.java
* Description : Classe Show
* Author : Donovan Dagnely
* Created : 01/11/2020
* Version : 0.0.1
*
*/


package be.ddo.POJO;

import java.util.ArrayList;

import be.ddo.DAO.AbstractDAOFactory;
import be.ddo.DAO.DAO;

public class Show {
	private int id;
	private String title;
	private ArrayList<Artist> listArtist;
	private int perUserMaxSeat;
	private Configuration configuration;
		
	//
	//	GET/SET
	//
	public int getId() { return id; }
	public void setId(int id) { this.id = id; }
	
	public String getTitle() { return title; }
	public void setTitle(String title) { this.title = title; }

	public int getPerUserMaxSeat() { return perUserMaxSeat; }
	public void setPerUserMaxSeat(int perUserMaxSeat) { this.perUserMaxSeat = perUserMaxSeat; }

	public ArrayList<Artist> getListArtist() { return listArtist; }
	public void setListArtist(ArrayList<Artist> listArtist) { this.listArtist = listArtist;	}
	
	public Configuration getConfiguration() { return configuration; }
	public void setConfiguration(Configuration configuration) { this.configuration = configuration; }
	
	@Override
	public String toString() { return "("+id+") ["+ title + "]"; }
	
	//
	// Constructeur
	//
	
	public Show(String title, ArrayList<Artist> listArtist, int perUserMaxSeat, Configuration configuration) {
		super();
		this.title = title;
		this.listArtist = listArtist;
		this.perUserMaxSeat = perUserMaxSeat;
		this.configuration = configuration;
	}
	public Show() {	}
	
	public Show(int id, String title, int perUserMaxSeat, Configuration configuration) {
		this.id = id;
		this.title = title;
		this.perUserMaxSeat = perUserMaxSeat;
		this.configuration = configuration;
	}
	
	public Show(int id, String title, int perUserMaxSeat) {
		super();
		this.id = id;
		this.title = title;
		this.perUserMaxSeat = perUserMaxSeat;
	}
	//
	// Fonction
	//
	public void create() {
		AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
		DAO<Show> showDAO = adf.getShowDAO();
		showDAO.create(this);
	}
	
	public static ArrayList<Show> getAll() {
		AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
		DAO<Show> showDAO = adf.getShowDAO();
		return showDAO.getAll();
	}
	
	public static Show find(int id) {
		AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
		DAO<Show> showDAO = adf.getShowDAO();
		return showDAO.find(id);
	}
}
