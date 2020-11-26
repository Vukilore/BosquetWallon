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

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sound.sampled.EnumControl.Type;

import be.ddo.DAO.AbstractDAOFactory;
import be.ddo.DAO.DAO;

public class Configuration {
	private int id;
	private String configurationType;
	private String description;
	private ArrayList<Category> categoryList;
	private int idShow;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getConfigurationType() {
		return configurationType;
	}

	public void setConfigurationType(String configurationType) {
		this.configurationType = configurationType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ArrayList<Category> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(ArrayList<Category> categoryList) {
		this.categoryList = categoryList;
	}

	public int getIdShow() {
		return idShow;
	}

	public void setIdShow(int idShow) {
		this.idShow = idShow;
	}

	/*
	 * this.create(int id) adf.getConfDAO confDAO.Create() for(cat :
	 * this.getCategoryList()) cat.create(this.id)
	 * 
	 */
	public Configuration(ConfigurationType configurationType, ArrayList<Category> categoryList) {
		this.configurationType = configurationType.toString();
		switch (configurationType) {
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
		switch (configurationType) {
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

	public Configuration(ResultSet result) throws SQLException {
		this.id = result.getInt("IdConfiguration");
		this.configurationType = result.getString("type");
		this.idShow = result.getInt("IdShow");
		switch (this.configurationType) {
		case "DEBOUT":
			this.description = "8000 places disponible en étant debout.";
			break;
		case "CIRQUE":
			this.description = "6000 places disponible réparti en 4 catégories.";
			break;
		case "CONCERT":
			this.description = "5000 places disponible réparti en 3 catégories.";
			break;
		}
	}

	public void Create() {
		AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
		DAO<Configuration> configDAO = adf.getConfigurationDAO();
		configDAO.create(this);
	}

	public void getAllCategories() {
		// ajout des catégories
		ArrayList<Category> listCategoriesDAO = Category.getAll(); // Récupération de toutes les catégories
		ArrayList<Category> listCategories = new ArrayList<Category>(); // Création d'une liste temporaire
		for (Category cat : listCategoriesDAO) // Parcours de la liste de catégorie
			if (cat.getIdConfiguration() == this.getId()) // Si la catégorie récupérée a bien l'id de la config
																	// actuel
				listCategories.add(cat); // on l'ajoute à la liste temporaire
		this.setCategoryList(listCategories); // On ajoute la liste temporaire à la liste de configuration

	}

	public void destroy() {
		AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
		DAO<Configuration> configDAO = adf.getConfigurationDAO();
		configDAO.delete(this);
	}

}
