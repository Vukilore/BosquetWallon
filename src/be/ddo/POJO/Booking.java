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

public class Booking {
	private int deposit; // Acompte
	private int solde; 	 // Solde
	private int price;	 // Prix
	private String statut;
	
	public int getDeposit() { return deposit; }
	public void setDeposit(int deposit) { this.deposit = deposit; }
	
	public int getSolde() { return solde; }
	public void setSolde(int solde) { this.solde = solde; }

	
	public int getPrice() {	return price; }
	public void setPrice(int price) { this.price = price; }

	public String getStatut() { return statut; }	
	public void setStatut(String statut) { this.statut = statut; }
	
}