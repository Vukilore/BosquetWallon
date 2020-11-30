package be.ddo.DAO;

import be.ddo.POJO.Booking;
import be.ddo.POJO.Category;
import be.ddo.POJO.Command;
import be.ddo.POJO.Configuration;
import be.ddo.POJO.Performance;
import be.ddo.POJO.RoomPlanning;
import be.ddo.POJO.Seat;
import be.ddo.POJO.Show;
import be.ddo.POJO.User;

public abstract class AbstractDAOFactory {
	public static final int DAO_FACTORY = 0;
	public static final int XML_DAO_FACTORY = 1;
	

	//public abstract DAO<Professeur> getProfesseurDAO();
	
	public abstract DAO<User> getUserDAO();
	public abstract DAO<Show> getShowDAO();
	public abstract DAO<RoomPlanning> getRoomPlanningDAO();	
	public abstract DAO<Performance> getPerformanceDAO();
	public abstract DAO<Booking> getBookingDAO();
	public abstract DAO<Configuration> getConfigurationDAO();
	public abstract DAO<Category> getCategoryDAO();
	public abstract DAO<Command> getCommandDAO();
	public abstract DAO<Seat> getSeatDAO();
		
	public static AbstractDAOFactory getFactory(int type){
		switch(type){
		case DAO_FACTORY:
			return new DAOFactory();
			default:
				return null;
		}
	}
	
	
	
	
}
