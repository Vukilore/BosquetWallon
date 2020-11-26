package be.ddo.FRAMES;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import be.ddo.POJO.Client;
import be.ddo.POJO.RoomPlanning;
import be.ddo.POJO.Show;
import com.toedter.calendar.JCalendar;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;

public class BookingShow extends JFrame {

	private JPanel contentPane;

	public BookingShow(Client client, ArrayList<RoomPlanning> listOfPlanning) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 725, 454);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Choisissez une date", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(33, 26, 210, 175);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JCalendar calendar = new JCalendar();
		calendar.setBounds(6, 16, 198, 153);
		panel.add(calendar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(288, 42, 245, 153);
		contentPane.add(scrollPane);
		
		JList list = new JList();
		scrollPane.setViewportView(list);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(288, 26, 46, 14);
		contentPane.add(lblNewLabel);
		
		
	}
}
