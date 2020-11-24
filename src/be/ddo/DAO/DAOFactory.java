package be.ddo.DAO;

import java.sql.Connection;

import be.ddo.POJO.RoomPlanning;
import be.ddo.POJO.Show;
import be.ddo.POJO.User;

public class DAOFactory extends AbstractDAOFactory {
	protected static final Connection conn = BosquetConnection.getInstance();

	/*public DAO<Classe> getClasseDAO() {
		return new ClasseDAO(conn);
	}

	public DAO<Professeur> getProfesseurDAO() {
		return new ProfesseurDAO(conn);
	}

	public DAO<Eleve> getEleveDAO() {
		return new EleveDAO(conn);
	}

	public DAO<Matiere> getMatiereDAO() {
		return new MatiereDAO(conn);
	}
*/
	public DAO<Show> getShowDAO() { return new ShowDAO(conn); }
	public DAO<User> getUserDAO() { return new UserDAO(conn); }
	public DAO<RoomPlanning> getRoomPlanningDAO() { return new RoomPlanningDAO(conn); }
	
}