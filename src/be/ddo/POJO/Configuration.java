/*
* POGO
*
* (c) Copyright 2020, Projet Java - Bosquet Wallon
*
* Name : Configuration.java
* Description : Classe Configuration
* Author : Donovan Dagnely
* Created : 01/11/2020
* Version : 0.0.1
*
*/

package be.ddo.POJO;

import java.util.ArrayList;

import javax.sound.sampled.EnumControl.Type;

public class Configuration {
	private int id;
	private String configurationType;
	private String description;
	private ArrayList<Category> categoryList;
	
	public int getId() { return id; }
	public void setId(int id) { this.id = id; }
	
	public String getConfigurationType() { return configurationType; }
	public void setConfigurationType(String configurationType) { this.configurationType = configurationType; }
	
	public String getDescription() { return description; }
	public void setDescription(String description) { this.description = description; }

	public ArrayList<Category> getCategoryList() { return categoryList; }
	public void setCategoryList(ArrayList<Category> categoryList) { this.categoryList = categoryList; }
	
	public Configuration(ConfigurationType configurationType, ArrayList<Category> categoryList) {
		this.configurationType = configurationType.toString();
		switch(configurationType) {
			case DEBOUT: 
				this.description = "8000 places disponible en étant debout.";
				break;
			case CIRQUE:
				this.description = "6000 places disponible réparti en 4 catégories.";
				break;
			case CONCERT:
				this.description = "5000 places disponible réparti en 3 catégories.";
				break;
		}
		this.categoryList = categoryList;
	}	
	
	public Configuration(int id, ConfigurationType configurationType) {
		this.id = id;
		this.configurationType = configurationType.toString();
		switch(configurationType) {
			case DEBOUT: 
				this.description = "8000 places disponible en étant debout.";
				break;
			case CIRQUE:
				this.description = "6000 places disponible réparti en 4 catégories.";
				break;
			case CONCERT:
				this.description = "5000 places disponible réparti en 3 catégories.";
				break;
		}
	}
	
}
