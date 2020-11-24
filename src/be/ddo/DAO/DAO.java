package be.ddo.DAO;

import java.sql.*;
import java.util.ArrayList;

public abstract class DAO<T> {
	
protected Connection connect = null;
	
	public DAO(Connection conn){
		this.connect = conn;
	}
	
	public abstract boolean create(T obj);
	
	public abstract boolean delete(T obj);
	
	public abstract boolean update(T obj);
	
	public abstract ArrayList<T> getAll();
	
	public abstract T find(int id);
	
	public abstract T find(String email);
	
}
