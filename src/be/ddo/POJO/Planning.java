package be.ddo.POJO;

import java.util.ArrayList;
import java.util.Date;

public final class Planning {
	private static Planning instance = new Planning();
	private static ArrayList<RoomPlanning> listRoomPlanning = null;
	
	
	private Planning(){}
	
	public static Planning getInstance(){ return instance; }
	
	
	public ArrayList<RoomPlanning> getPlannings(){
		if(listRoomPlanning == null){
			this.listRoomPlanning = RoomPlanning.getAll();
		}
		return listRoomPlanning;
	}

}
