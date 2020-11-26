package be.ddo.POJO;

import java.util.List;


public final class Planning {
	private static Planning instance = new Planning();
	private static List<RoomPlanning> listRoomPlanning = null;
	
	
	private Planning(){}
	
	public static Planning getInstance(){ return instance; }
	
	
	public List<RoomPlanning> get(){
		if(listRoomPlanning == null){
			this.listRoomPlanning = RoomPlanning.getAll();
		}
		return listRoomPlanning;
	}
}
