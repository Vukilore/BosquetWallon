package be.ddo.FRAMES;

import java.awt.EventQueue;

import be.ddo.POJO.Manager;
import be.ddo.POJO.Planning;
import be.ddo.POJO.RoomPlanning;

public class Application {
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Planning.getInstance().getPlannings();
					Manager manager = new Manager("Dagnely", "Donovan", "manager@bosquetwallon.be", "azerty", "Marcinelle", "de nalinnes", "437", "6001");
					
					if(!manager.userExist())
						manager.create();
					
					FRAMES frame = new FRAMES();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
