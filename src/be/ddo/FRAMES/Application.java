package be.ddo.FRAMES;

import java.awt.EventQueue;

public class Application {
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					// TODO : Cr�ation des 3 configurations possible par SQL
					
					// TODO : Cr�ation du manager par SQL
					
					FRAMES frame = new FRAMES();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
