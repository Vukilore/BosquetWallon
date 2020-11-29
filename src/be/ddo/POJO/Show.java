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
import java.util.Objects;

import be.ddo.DAO.AbstractDAOFactory;
import be.ddo.DAO.DAO;

public class Show {
	

	private int id;
	private String title;
	private ArrayList<Artist> listArtist;
	private ArrayList<Performance> listPerformance;
	private int perUserMaxSeat;
	private Configuration configuration;
	private int IdRoomPlanning;
		
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
	
	public ArrayList<Performance> getListPerformance() { return listPerformance; }
	public void setListPerformance(ArrayList<Performance> listPerformance) { this.listPerformance = listPerformance; }
	
	public Configuration getConfiguration() { return configuration; }
	public void setConfiguration(Configuration configuration) { this.configuration = configuration; }
	
	public int getIdRoomPlanning() { return IdRoomPlanning; }
	public void setIdRoomPlanning(int idRoomPlanning) { IdRoomPlanning = idRoomPlanning; }
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
	public Show(int id) { this.id = id;	}
	
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
	// Surcharge de méthode
	//
	@Override
	public int hashCode() {
		return Objects.hash(IdRoomPlanning, configuration, id, listArtist, listPerformance, perUserMaxSeat, title);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Show))
			return false;
		Show other = (Show) obj;
		return Objects.equals(title, other.title);
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
	
	public Show find() {
		AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
		DAO<Show> showDAO = adf.getShowDAO();
		return showDAO.find(id);
	}
	
}
