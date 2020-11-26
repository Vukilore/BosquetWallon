/*
* POGO
*
* (c) Copyright 2020, Projet Java - Bosquet Wallon
*
* Name : Seat.java
* Description : Classe Seat
* Author : Donovan Dagnely
* Created : 01/11/2020
* Version : 0.0.1
*
*/

package be.ddo.POJO;

public class Seat {
	private int idCommand;
	private int numSeat;
	private int price;
	private Performance performance;
	
	
	//
	// GET/SET
	//
	public int getIdCommand() { return idCommand; }
	public void setIdCommand(int idCommand) { this.idCommand = idCommand; }
	
	public int getNumSeat() { return numSeat; }
	public void setNumSeat(int numSeat) { this.numSeat = numSeat; }
	
	public int getPrice() { return price; }
	public void setPrice(int price) { this.price = price; }
	
	public Performance getPerformance() { return performance; }
	public void setPerformance(Performance performance) { this.performance = performance; }
}
