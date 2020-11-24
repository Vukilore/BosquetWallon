package be.ddo.FRAMES;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import be.ddo.POJO.Client;
import be.ddo.POJO.Performance;
import be.ddo.POJO.Show;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class Booking extends JFrame {

	private JPanel contentPane;

	public Booking(Client client, Show show, ArrayList<Performance> listOfPerformance) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 548, 494);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblShowTitle = new JLabel("TITRE DU SPECTACLE ");
		lblShowTitle.setText(show.getTitle());
		lblShowTitle.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 11));
		lblShowTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblShowTitle.setBounds(85, 11, 363, 14);
		contentPane.add(lblShowTitle);

		JScrollPane sPanePerformance = new JScrollPane();
		sPanePerformance.setBounds(145, 59, 247, 99);
		contentPane.add(sPanePerformance);

		JList listPerformance = new JList();
		sPanePerformance.setViewportView(listPerformance);

		JPanel panel_Configuration = new JPanel();
		panel_Configuration.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Choix des places", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_Configuration.setBounds(10, 169, 257, 159);
		contentPane.add(panel_Configuration);
		panel_Configuration.setLayout(null);

		JPanel panel_Debout = new JPanel();
		panel_Debout.setLayout(null);
		panel_Debout.setBounds(6, 34, 240, 110);
		panel_Configuration.add(panel_Debout);

		JLabel lblConfiguration_Debout_Price_1 = new JLabel("Place : (" + show.getPerUserMaxSeat() +" restante)");
		lblConfiguration_Debout_Price_1.setBounds(10, 33, 157, 14);
		panel_Debout.add(lblConfiguration_Debout_Price_1);

		JSpinner spin_Debout = new JSpinner();
		spin_Debout.setModel(new SpinnerNumberModel(1, 1, show.getPerUserMaxSeat(), 1));
		spin_Debout.setBounds(171, 30, 59, 20);
		panel_Debout.add(spin_Debout);

		JPanel panel_Concert = new JPanel();
		panel_Concert.setLayout(null);
		panel_Concert.setBounds(6, 34, 240, 110);
		panel_Configuration.add(panel_Concert);

		JLabel lblConfiguration_MaxSeat_Concert_1 = new JLabel("Cat. Or : (" + show.getPerUserMaxSeat() +" places)");
		lblConfiguration_MaxSeat_Concert_1.setBounds(10, 11, 149, 14);
		panel_Concert.add(lblConfiguration_MaxSeat_Concert_1);

		JLabel lblConfiguration_MaxSeat_Concert_2_2 = new JLabel("Cat. Argent : (" + show.getPerUserMaxSeat() +" places)");
		lblConfiguration_MaxSeat_Concert_2_2.setBounds(10, 39, 165, 14);
		panel_Concert.add(lblConfiguration_MaxSeat_Concert_2_2);

		JLabel lblConfiguration_MaxSeat_Concert_2_1_1 = new JLabel("Cat. Bronze : (" + show.getPerUserMaxSeat() +" places)");
		lblConfiguration_MaxSeat_Concert_2_1_1.setBounds(10, 69, 165, 14);
		panel_Concert.add(lblConfiguration_MaxSeat_Concert_2_1_1);

		JSpinner spin_Concert_Gold = new JSpinner();
		spin_Concert_Gold.setModel(new SpinnerNumberModel(1, 1, show.getPerUserMaxSeat(), 1));
		spin_Concert_Gold.setBounds(171, 8, 59, 20);
		panel_Concert.add(spin_Concert_Gold);

		JSpinner spin_Concert_Silver = new JSpinner();
		spin_Concert_Silver.setModel(new SpinnerNumberModel(1, 1, show.getPerUserMaxSeat(), 1));
		spin_Concert_Silver.setBounds(171, 36, 59, 20);
		panel_Concert.add(spin_Concert_Silver);

		JSpinner spin_Concert_Bronze = new JSpinner();
		spin_Concert_Bronze.setModel(new SpinnerNumberModel(1, 1, show.getPerUserMaxSeat(), 1));
		spin_Concert_Bronze.setBounds(171, 66, 59, 20);
		panel_Concert.add(spin_Concert_Bronze);
		panel_Concert.setVisible(false);

		JPanel panel_Cirque = new JPanel();
		panel_Cirque.setBounds(6, 34, 240, 110);
		panel_Configuration.add(panel_Cirque);
		panel_Cirque.setLayout(null);

		JLabel lblConfiguration_MaxSeat_Cirque = new JLabel("Cat. Or : (" + show.getPerUserMaxSeat() +" places)");
		lblConfiguration_MaxSeat_Cirque.setBounds(10, 35, 149, 14);
		panel_Cirque.add(lblConfiguration_MaxSeat_Cirque);

		JLabel lblConfiguration_MaxSeat_Cirque_2 = new JLabel("Cat. Argent : (" + show.getPerUserMaxSeat() +" places)");
		lblConfiguration_MaxSeat_Cirque_2.setBounds(10, 60, 165, 14);
		panel_Cirque.add(lblConfiguration_MaxSeat_Cirque_2);

		JLabel lblConfiguration_MaxSeat_Cirque_2_1 = new JLabel("Cat. Bronze : (" + show.getPerUserMaxSeat() +" places)");
		lblConfiguration_MaxSeat_Cirque_2_1.setBounds(10, 85, 165, 14);
		panel_Cirque.add(lblConfiguration_MaxSeat_Cirque_2_1);

		JLabel lblConfiguration_MaxSeat_Cirque_3 = new JLabel("Cat. Diamant : (" + show.getPerUserMaxSeat() +" places)");
		lblConfiguration_MaxSeat_Cirque_3.setBounds(10, 10, 165, 14);
		panel_Cirque.add(lblConfiguration_MaxSeat_Cirque_3);

		JSpinner spin_Cirque_Diamant = new JSpinner();
		spin_Cirque_Diamant.setModel(new SpinnerNumberModel(1, 1, show.getPerUserMaxSeat(), 1));
		spin_Cirque_Diamant.setBounds(171, 7, 59, 20);
		panel_Cirque.add(spin_Cirque_Diamant);

		JSpinner spin_Cirque_Silver = new JSpinner();
		spin_Cirque_Silver.setModel(new SpinnerNumberModel(1, 1, show.getPerUserMaxSeat(), 1));
		spin_Cirque_Silver.setBounds(171, 57, 59, 20);
		panel_Cirque.add(spin_Cirque_Silver);

		JSpinner spin_Cirque_Bronze = new JSpinner();
		spin_Cirque_Bronze.setModel(new SpinnerNumberModel(1, 1, show.getPerUserMaxSeat(), 1));
		spin_Cirque_Bronze.setBounds(171, 82, 59, 20);
		panel_Cirque.add(spin_Cirque_Bronze);

		JSpinner spin_Cirque_Gold = new JSpinner();
		spin_Cirque_Gold.setBounds(171, 32, 59, 20);
		spin_Cirque_Gold.setModel(new SpinnerNumberModel(1, 1, show.getPerUserMaxSeat(), 1));
		panel_Cirque.add(spin_Cirque_Gold);

		JLabel lblPerformance = new JLabel("Choisissez une date de repr\u00E9sentation :");
		lblPerformance.setBounds(148, 36, 264, 14);
		contentPane.add(lblPerformance);
		
		switch(show.getConfiguration().getConfigurationType()) {
			case "DEBOUT" :
				panel_Debout.setVisible(true);
				panel_Cirque.setVisible(false);
				panel_Concert.setVisible(false);
				break;
			case "CONCERT" :
				panel_Debout.setVisible(false);
				panel_Cirque.setVisible(false);
				panel_Concert.setVisible(true);
				break;
			case "CIRQUE" :
				panel_Debout.setVisible(false);
				panel_Cirque.setVisible(true);
				panel_Concert.setVisible(false);
				break;	
		}
	}
}
