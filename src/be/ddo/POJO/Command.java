/*
* POGO
*
* (c) Copyright 2020, Projet Java - Bosquet Wallon
*
* Name : Command.java
* Description : Classe Command
* Author : Donovan Dagnely
* Created : 01/11/2020
* Version : 0.0.1
*
*/


package be.ddo.POJO;

import java.util.ArrayList;

public class Command {
	private String paymentMode;
	private String shippingMethod;
	private int totalCost;
	private int idUser;
	private ArrayList<Seat> listSeat;
	
	public String getPaymentMode() { return paymentMode; }
	public void setPaymentMode(String paymentMode) { this.paymentMode = paymentMode; }
	
	public String getShippingMethod() { return shippingMethod; }
	public void setShippingMethod(String shippingMethod) { this.shippingMethod = shippingMethod; }
	
	public int getTotalCost() { return totalCost; }
	public void setTotalCost(int totalCost) { this.totalCost = totalCost; }
	
	public int getIdUser() { return idUser; }
	public void setIdUser(int idUser) { this.idUser = idUser; }
	
	public ArrayList<Seat> getListSeat() { return listSeat; }
	public void setListSeat(ArrayList<Seat> listSeat) { this.listSeat = listSeat; }
	
	public Command() {}
	
}
