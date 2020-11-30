package be.ddo.DAO;

import java.sql.Connection;

import be.ddo.POJO.Booking;
import be.ddo.POJO.Category;
import be.ddo.POJO.Command;
import be.ddo.POJO.Configuration;
import be.ddo.POJO.Performance;
import be.ddo.POJO.RoomPlanning;
import be.ddo.POJO.Seat;
import be.ddo.POJO.Show;
import be.ddo.POJO.User;

public class DAOFactory extends AbstractDAOFactory {
	protected static final Connection conn = BosquetConnection.getInstance();

	public DAO<Show> getShowDAO() { return new ShowDAO(conn); }
	public DAO<User> getUserDAO() { return new UserDAO(conn); }
	public DAO<Configuration> getConfigurationDAO() { return new ConfigurationDAO(conn); }
	public DAO<Performance> getPerformanceDAO() { return new PerformanceDAO(conn); }
	public DAO<RoomPlanning> getRoomPlanningDAO() { return new RoomPlanningDAO(conn); }
	public DAO<Booking> getBookingDAO() { return new BookingDAO(conn); }
	public DAO<Category> getCategoryDAO() { return new CategoryDAO(conn); }
	public DAO<Command> getCommandDAO() { return new CommandDAO(conn); }
	public DAO<Seat> getSeatDAO() { return new SeatDAO(conn); }
}