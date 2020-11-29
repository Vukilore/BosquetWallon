package be.ddo.FRAMES;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.AbstractListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import be.ddo.POJO.Category;
import be.ddo.POJO.Performance;
import be.ddo.POJO.Show;
import javax.swing.JButton;

public class listPlanning extends JFrame {

	private JPanel contentPane;
	private JTextField txtFConfiguration_Cirque_Gold;
	private JTextField txtFConfiguration_Debout;
	private JTextField txtFConfiguration_Cirque_Silver;
	private JTextField txtFConfiguration_Cirque_Bronze;
	private JTextField txtFConfiguration_Concert_Gold;
	private JTextField txtFConfiguration_Concert_Silver;
	private JTextField txtFConfiguration_Concert_Bronze;
	private JTextField txtFConfiguration_Cirque_Diamant;

	public listPlanning(ArrayList<Show> listOfShow) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 672, 487);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane sPane_Show = new JScrollPane();
		sPane_Show.setBounds(42, 39, 216, 88);
		contentPane.add(sPane_Show);

		JList listShow = new JList();
		listShow.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listShow.setModel(new AbstractListModel() {
			ArrayList<Show> values = listOfShow;

			public int getSize() {
				return values.size();
			}

			public Show getElementAt(int index) {
				return values.get(index);
			}

		});
		sPane_Show.setViewportView(listShow);

		JLabel lblNewLabel = new JLabel("Liste des spectacles pr\u00E9vu :");
		lblNewLabel.setBounds(46, 23, 212, 14);
		contentPane.add(lblNewLabel);

		JScrollPane sPane_Performance = new JScrollPane();
		sPane_Performance.setBounds(387, 39, 216, 88);
		contentPane.add(sPane_Performance);

		JList listPerformance = new JList();
		listPerformance.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		sPane_Performance.setViewportView(listPerformance);

		JLabel lblNewLabel_1 = new JLabel("Liste des repr\u00E9sentations :");
		lblNewLabel_1.setBounds(387, 23, 235, 14);
		contentPane.add(lblNewLabel_1);

		JPanel panel_Configuration = new JPanel();
		panel_Configuration.setBounds(199, 146, 256, 212);
		contentPane.add(panel_Configuration);
		panel_Configuration.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Configuration de la salle", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_Configuration.setLayout(null);

		JPanel panel_Debout = new JPanel();
		panel_Debout.setLayout(null);
		panel_Debout.setBounds(6, 91, 240, 110);
		panel_Configuration.add(panel_Debout);

		JLabel lblConfiguration_Debout_Price_1 = new JLabel("Prix de la place :");
		lblConfiguration_Debout_Price_1.setBounds(10, 33, 120, 14);
		panel_Debout.add(lblConfiguration_Debout_Price_1);

		txtFConfiguration_Debout = new JTextField();
		txtFConfiguration_Debout.setEnabled(false);
		txtFConfiguration_Debout.setColumns(10);
		txtFConfiguration_Debout.setBounds(140, 30, 37, 20);
		panel_Debout.add(txtFConfiguration_Debout);

		JLabel lblConfiguration_Symbol_1 = new JLabel("\u20AC");
		lblConfiguration_Symbol_1.setBounds(179, 33, 21, 14);
		panel_Debout.add(lblConfiguration_Symbol_1);

		panel_Debout.setVisible(true);

		JPanel panel_Cirque = new JPanel();
		panel_Cirque.setBounds(6, 91, 240, 110);
		panel_Configuration.add(panel_Cirque);
		panel_Cirque.setLayout(null);

		JLabel lblConfiguration_MaxSeat_Cirque = new JLabel("Cat. Or : (2000 places)");
		lblConfiguration_MaxSeat_Cirque.setBounds(10, 35, 149, 14);
		panel_Cirque.add(lblConfiguration_MaxSeat_Cirque);

		txtFConfiguration_Cirque_Gold = new JTextField();
		txtFConfiguration_Cirque_Gold.setEditable(false);
		txtFConfiguration_Cirque_Gold.setEnabled(false);
		txtFConfiguration_Cirque_Gold.setBounds(181, 32, 37, 20);
		panel_Cirque.add(txtFConfiguration_Cirque_Gold);
		txtFConfiguration_Cirque_Gold.setColumns(10);

		JLabel lblConfiguration_Symbol = new JLabel("\u20AC");
		lblConfiguration_Symbol.setBounds(218, 35, 31, 14);
		panel_Cirque.add(lblConfiguration_Symbol);

		JLabel lblConfiguration_MaxSeat_Cirque_2 = new JLabel("Cat. Argent : (1500 places)");
		lblConfiguration_MaxSeat_Cirque_2.setBounds(10, 60, 165, 14);
		panel_Cirque.add(lblConfiguration_MaxSeat_Cirque_2);

		txtFConfiguration_Cirque_Silver = new JTextField();
		txtFConfiguration_Cirque_Silver.setEnabled(false);
		txtFConfiguration_Cirque_Silver.setEditable(false);
		txtFConfiguration_Cirque_Silver.setColumns(10);
		txtFConfiguration_Cirque_Silver.setBounds(181, 57, 37, 20);
		panel_Cirque.add(txtFConfiguration_Cirque_Silver);

		JLabel lblConfiguration_Symbol_2 = new JLabel("\u20AC");
		lblConfiguration_Symbol_2.setBounds(218, 59, 21, 17);
		panel_Cirque.add(lblConfiguration_Symbol_2);

		JLabel lblConfiguration_MaxSeat_Cirque_2_1 = new JLabel("Cat. Bronze : (3500 places)");
		lblConfiguration_MaxSeat_Cirque_2_1.setBounds(10, 85, 165, 14);
		panel_Cirque.add(lblConfiguration_MaxSeat_Cirque_2_1);

		txtFConfiguration_Cirque_Bronze = new JTextField();
		txtFConfiguration_Cirque_Bronze.setEnabled(false);
		txtFConfiguration_Cirque_Bronze.setEditable(false);
		txtFConfiguration_Cirque_Bronze.setColumns(10);
		txtFConfiguration_Cirque_Bronze.setBounds(181, 82, 37, 20);
		panel_Cirque.add(txtFConfiguration_Cirque_Bronze);

		JLabel lblConfiguration_Symbol_2_1 = new JLabel("\u20AC");
		lblConfiguration_Symbol_2_1.setBounds(218, 84, 21, 17);
		panel_Cirque.add(lblConfiguration_Symbol_2_1);

		JLabel lblConfiguration_MaxSeat_Cirque_3 = new JLabel("Cat. Diamant : (1000 places)");
		lblConfiguration_MaxSeat_Cirque_3.setBounds(10, 10, 165, 14);
		panel_Cirque.add(lblConfiguration_MaxSeat_Cirque_3);

		txtFConfiguration_Cirque_Diamant = new JTextField();
		txtFConfiguration_Cirque_Diamant.setEnabled(false);
		txtFConfiguration_Cirque_Diamant.setEditable(false);
		txtFConfiguration_Cirque_Diamant.setColumns(10);
		txtFConfiguration_Cirque_Diamant.setBounds(181, 7, 37, 20);
		panel_Cirque.add(txtFConfiguration_Cirque_Diamant);

		JLabel lblConfiguration_Symbol_4 = new JLabel("\u20AC");
		lblConfiguration_Symbol_4.setBounds(219, 10, 21, 14);
		panel_Cirque.add(lblConfiguration_Symbol_4);
		panel_Cirque.setVisible(false);

		JPanel panel_Concert = new JPanel();
		panel_Concert.setLayout(null);
		panel_Concert.setBounds(6, 91, 240, 110);
		panel_Configuration.add(panel_Concert);

		JLabel lblConfiguration_MaxSeat_Concert_1 = new JLabel("Cat. Or : (500 places)");
		lblConfiguration_MaxSeat_Concert_1.setBounds(10, 11, 149, 14);
		panel_Concert.add(lblConfiguration_MaxSeat_Concert_1);

		txtFConfiguration_Concert_Gold = new JTextField();
		txtFConfiguration_Concert_Gold.setEnabled(false);
		txtFConfiguration_Concert_Gold.setEditable(false);
		txtFConfiguration_Concert_Gold.setColumns(10);
		txtFConfiguration_Concert_Gold.setBounds(169, 8, 37, 20);
		panel_Concert.add(txtFConfiguration_Concert_Gold);

		JLabel lblConfiguration_Symbol_3 = new JLabel("\u20AC");
		lblConfiguration_Symbol_3.setBounds(209, 11, 21, 14);
		panel_Concert.add(lblConfiguration_Symbol_3);

		JLabel lblConfiguration_MaxSeat_Concert_2_2 = new JLabel("Cat. Argent : (1500 places)");
		lblConfiguration_MaxSeat_Concert_2_2.setBounds(10, 39, 165, 14);
		panel_Concert.add(lblConfiguration_MaxSeat_Concert_2_2);

		txtFConfiguration_Concert_Silver = new JTextField();
		txtFConfiguration_Concert_Silver.setEditable(false);
		txtFConfiguration_Concert_Silver.setEnabled(false);
		txtFConfiguration_Concert_Silver.setColumns(10);
		txtFConfiguration_Concert_Silver.setBounds(169, 36, 37, 20);
		panel_Concert.add(txtFConfiguration_Concert_Silver);

		JLabel lblConfiguration_Symbol_2_2 = new JLabel("\u20AC");
		lblConfiguration_Symbol_2_2.setBounds(209, 38, 21, 17);
		panel_Concert.add(lblConfiguration_Symbol_2_2);

		JLabel lblConfiguration_MaxSeat_Concert_2_1_1 = new JLabel("Cat. Bronze : (3500 places)");
		lblConfiguration_MaxSeat_Concert_2_1_1.setBounds(10, 69, 165, 14);
		panel_Concert.add(lblConfiguration_MaxSeat_Concert_2_1_1);

		txtFConfiguration_Concert_Bronze = new JTextField();
		txtFConfiguration_Concert_Bronze.setEnabled(false);
		txtFConfiguration_Concert_Bronze.setEditable(false);
		txtFConfiguration_Concert_Bronze.setColumns(10);
		txtFConfiguration_Concert_Bronze.setBounds(169, 66, 37, 20);
		panel_Concert.add(txtFConfiguration_Concert_Bronze);

		JLabel lblConfiguration_Symbol_2_1_1 = new JLabel("\u20AC");
		lblConfiguration_Symbol_2_1_1.setBounds(209, 69, 21, 17);
		panel_Concert.add(lblConfiguration_Symbol_2_1_1);
		panel_Concert.setVisible(false);

		JLabel lblConfiguration_Configuration = new JLabel("Configuration de la salle :");
		lblConfiguration_Configuration.setBounds(21, 23, 152, 14);
		panel_Configuration.add(lblConfiguration_Configuration);

		JButton btnExit = new JButton("OK");
		btnExit.setBounds(276, 396, 89, 23);
		contentPane.add(btnExit);

		// =================================================================================
		// OnClick OK
		// =================================================================================
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				dispose();
			}
		});

		// =================================================================================
		// OnClick ListShow
		// =================================================================================
		listShow.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("unchecked")
			@Override
			public void mousePressed(MouseEvent e) {
				Show show;
				show = (Show) listShow.getSelectedValue();

				listPerformance.setModel(new AbstractListModel() {
					ArrayList<Performance> values = show.getListPerformance();

					public int getSize() {
						return values.size();
					}

					public Performance getElementAt(int index) {
						return values.get(index);
					}

				});

				int gold = 0, silver = 0, bronze = 0, diamant = 0, debout = 0;

				for (Category c : show.getConfiguration().getCategoryList()) {
					switch (c.getType()) {
					case "CONCERT_GOLD", "CIRQUE_GOLD":
						gold = c.getPrice();
						break;
					case "CONCERT_SILVER", "CIRQUE_SILVER":
						silver = c.getPrice();
						break;
					case "CONCERT_BRONZE", "CIRQUE_BRONZE":
						bronze = c.getPrice();
						break;
					case "DEBOUT":
						debout = c.getPrice();
						break;
					case "CIRQUE_DIAMANT":
						diamant = c.getPrice();
						break;
					default:
						break;
					}
				}
				switch (show.getConfiguration().getConfigurationType()) {
				case "DEBOUT":
					panel_Debout.setVisible(true);
					panel_Cirque.setVisible(false);
					panel_Concert.setVisible(false);
					txtFConfiguration_Debout.setText(String.valueOf(debout));
					break;
				case "CIRQUE":
					panel_Debout.setVisible(false);
					panel_Cirque.setVisible(true);
					panel_Concert.setVisible(false);
					txtFConfiguration_Cirque_Diamant.setText(String.valueOf(diamant));
					txtFConfiguration_Cirque_Gold.setText(String.valueOf(gold));
					txtFConfiguration_Cirque_Silver.setText(String.valueOf(silver));
					txtFConfiguration_Cirque_Bronze.setText(String.valueOf(bronze));
					break;

				case "CONCERT":
					panel_Debout.setVisible(false);
					panel_Cirque.setVisible(false);
					panel_Concert.setVisible(true);
					txtFConfiguration_Concert_Gold.setText(String.valueOf(gold));
					txtFConfiguration_Concert_Silver.setText(String.valueOf(silver));
					txtFConfiguration_Concert_Bronze.setText(String.valueOf(bronze));
					break;

				default:
					break;
				}
			}
		});
	}
}
