package be.ddo.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import be.ddo.POJO.Artist;
import be.ddo.POJO.Category;
import be.ddo.POJO.Client;
import be.ddo.POJO.Configuration;
import be.ddo.POJO.ConfigurationType;
import be.ddo.POJO.Organizer;
import be.ddo.POJO.Show;
import be.ddo.POJO.User;

public class ShowDAO extends DAO<Show> {
	public ShowDAO(Connection conn) {
		super(conn);
	}

	public boolean create(Show obj) {
		try {
			// Sauvegarde de l'objet théatre
			Statement stmt = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				int numero = stmt.executeUpdate("INSERT INTO Show(title, perUserMaxSeat) VALUES('" + obj.getTitle() + "','"
							+ obj.getPerUserMaxSeat() + "')", Statement.RETURN_GENERATED_KEYS);
			ResultSet rs = stmt.getGeneratedKeys();
			int lastId = -1;
			if(rs.next()) 
				lastId = rs.getInt(1);

			// Sauvegarde de la liste d'artiste
			for (User u : obj.getListArtist()) {
				this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
						.executeUpdate("INSERT INTO Show_Artist(IdShow, IdUser) VALUES('" + lastId + "','" + u.getId() + "')");
			}
			// Sauvegarde de la configuration
			stmt = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				numero = stmt.executeUpdate(
							"INSERT INTO Configuration(type, IdShow) VALUES('"
									+ obj.getConfiguration().getConfigurationType() + "','" + lastId + "')",
							Statement.RETURN_GENERATED_KEYS);
				ResultSet rs2 = stmt.getGeneratedKeys();
				int lastId2 = -1;
				if(rs2.next()) 
					lastId2 = rs2.getInt(1);
					
			// Sauvegarde de la liste de catégorie
			for (Category c : obj.getConfiguration().getCategoryList()) {
				this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
						.executeUpdate("INSERT INTO Category(IdConfiguration, type, price) VALUES('" + lastId2
								+ "','" + c.getType() + "','" + c.getPrice() +"')");
			}
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean delete(Show obj) {
		return false;
	}

	public boolean update(Show obj) {
		return false;
	}

	public ArrayList<Show> getAll() {
		ArrayList<Show> listShow = new ArrayList<Show>();
		ArrayList<Integer> listIdShow = new ArrayList<Integer>();
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery("SELECT IdShow FROM Show");
			while (result.next())
				listIdShow.add(result.getInt("IdShow"));
			for (int id : listIdShow) {
				Show show = find(id);
				listShow.add(show);
			}

		} catch (SQLException e) {

		}
		return listShow;
	}

	public Show find(int id) {
		Show show = null;
		try {
			// Chargement de l'objet spectacle
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery("SELECT * FROM Show WHERE IdShow = " + id + "");
			if (result.first()) {
				// Création de l'objet spectacle
				show = new Show(result.getInt("idShow"), result.getString("title"), result.getInt("perUserMaxSeat"));

				// Chargement de la liste des ID des artistes
				ArrayList<Integer> listIdArtist = new ArrayList<Integer>();
				result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
						.executeQuery("SELECT * FROM Show_Artist WHERE IdShow =" + id + "");
				while (result.next())
					listIdArtist.add(result.getInt("IdUser"));

				// Chargement des artistes depuis la liste d'ID
				ArrayList<Artist> listArtist = new ArrayList<Artist>();
				for (int i : listIdArtist) {
					Artist artist = new Artist(Artist.find(i));
					listArtist.add(new Artist(artist));
				}
				// Ajout de la liste d'artiste à l'objet show
				show.setListArtist(listArtist);

				// Chargement de la configuration
				Configuration config = null;
				ResultSet result2 = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
						.executeQuery("SELECT * FROM Configuration WHERE IdShow =" + id + "");
				if (result2.first()) {
					switch(result2.getString("type")) {
					case "DEBOUT" :
						config = new Configuration(result2.getInt("IdConfiguration"), ConfigurationType.DEBOUT);
						break;
					case "CONCERT" :
						config = new Configuration(result2.getInt("IdConfiguration"), ConfigurationType.CONCERT);
						break;
					case "CIRQUE" :
						config = new Configuration(result2.getInt("IdConfiguration"), ConfigurationType.CIRQUE);
						break;
				}
				
				// Chargement des catégorie par la configuration
				ResultSet result3 = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
						.executeQuery("SELECT * FROM Category WHERE IdConfiguration =" + config.getId() + "");
				ArrayList<Category> listCategory = new ArrayList<Category>();
				while (result3.next())
					listCategory.add(new Category(result3));
				
				// Ajout de la liste des catégories à la configuration
				config.setCategoryList(listCategory);
				
				// Ajout de la configuration au spectacle
				show.setConfiguration(config);
				
				// ANDDD...WE'RE DONE :)
				}
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return show;
	}

	public Show find(String name) {
		Show show = null;
		try {
			// Chargement de l'objet spectacle
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery("SELECT * FROM Show WHERE title LIKE '" + name + "'");
			if (result.first()) {
				// Création de l'objet spectacle
				show = new Show(result.getInt("id"), result.getString("title"), result.getInt("perUserMaxSeat"));

				// Chargement de la liste des ID des artistes
				ArrayList<Integer> listIdArtist = new ArrayList<Integer>();
				result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
						.executeQuery("SELECT * FROM Show_Artist WHERE IdShow =" + show.getId() + "");
				while (result.next())
					listIdArtist.add(result.getInt("IdUser"));

				// Chargement des artistes depuis la liste d'ID
				ArrayList<Artist> listArtist = new ArrayList<Artist>();
				for (int i : listIdArtist) {
					Artist artist = new Artist(Artist.find(i));
					listArtist.add(new Artist(artist));
				}
				// Ajout de la liste d'artiste à l'objet show
				show.setListArtist(listArtist);
				
				// Chargement de la configuration
				Configuration config = null;
				ResultSet result2 = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
						.executeQuery("SELECT * FROM Configuration WHERE IdShow =" + show.getId() + "");
				if(result2.first()) {
					switch(result2.getString("type")) {
					case "DEBOUT" :
						config = new Configuration(result2.getInt("IdConfiguration"), ConfigurationType.DEBOUT);
						break;
					case "CONCERT" :
						config = new Configuration(result2.getInt("IdConfiguration"), ConfigurationType.CONCERT);
						break;
					case "CIRQUE" :
						config = new Configuration(result2.getInt("IdConfiguration"), ConfigurationType.CIRQUE);
						break;
				}
				
				// Chargement des catégorie par la configuration
				ResultSet result3 = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
						.executeQuery("SELECT * FROM Category WHERE IdConfiguration =" + config.getId() + "");
				ArrayList<Category> listCategory = new ArrayList<Category>();
				while (result3.next())
					listCategory.add(new Category(result3));
				
				// Ajout de la liste des catégories à la configuration
				config.setCategoryList(listCategory);
				
				// Ajout de la configuration au spectacle
				show.setConfiguration(config);
				
				// ANDDD...WE'RE DONE :)
				}
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return show;
	}
}
