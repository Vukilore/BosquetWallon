package be.ddo.FRAMES;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import be.ddo.POJO.Artist;
import be.ddo.POJO.Client;
import be.ddo.POJO.Performance;
import be.ddo.POJO.Show;

import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.Component;

import javax.swing.AbstractListModel;
import javax.swing.Box;
import javax.swing.JSeparator;
import javax.swing.JSplitPane;
import javax.swing.border.BevelBorder;

public class ChooseShow extends JFrame {

	private JPanel contentPane;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ChooseShow(Client client, ArrayList<Show> listOfShow) {
		setTitle("Choix du spectacle");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 596, 259);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Choisissez un spectacle :");
		lblNewLabel.setBounds(49, 23, 119, 14);
		contentPane.add(lblNewLabel);
		
		JScrollPane sPaneShow = new JScrollPane();
		sPaneShow.setBounds(49, 48, 217, 130);
		contentPane.add(sPaneShow);
		
		JList listShow = new JList();
		listShow.setModel(new AbstractListModel() {
			ArrayList<Show> values = listOfShow;

			public int getSize() {
				return values.size();
			}

			public Show getElementAt(int index) {
				return values.get(index);
			}
		});
		sPaneShow.setColumnHeaderView(listShow);
		
		JLabel lblNewLabel_1 = new JLabel("Liste des artistes du spectacle :");
		lblNewLabel_1.setBounds(316, 23, 258, 14);
		contentPane.add(lblNewLabel_1);
		
		JScrollPane sPaneArtist = new JScrollPane();
		sPaneArtist.setBounds(316, 48, 157, 72);
		contentPane.add(sPaneArtist);
		
		JList listArtist = new JList();
		listArtist.setEnabled(false);
		sPaneArtist.setViewportView(listArtist);
		
		JButton btnChoose = new JButton("Choisir");
		btnChoose.setBounds(113, 184, 90, 23);
		contentPane.add(btnChoose);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(291, 40, 4, 138);
		contentPane.add(panel);
		
		// =================================================================================
		// OnClick List
		// =================================================================================
		btnChoose.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Show tmpShow = (Show) listShow.getSelectedValue();
				ArrayList<Performance> listPerformance = Performance.getAll();
				
			}
		});
		
		// =================================================================================
		// OnClick List
		// =================================================================================
		listShow.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				listArtist.setModel(new AbstractListModel() {
					Show tmpShow = (Show) listShow.getSelectedValue();
					ArrayList<Artist> values = tmpShow.getListArtist();

					public int getSize() {
						return values.size();
					}

					public Artist getElementAt(int index) {
						return values.get(index);
					}
				});	
			}
		});
	}
}
