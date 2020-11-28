package be.ddo.FRAMES;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.AbstractListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import be.ddo.POJO.Category;
import be.ddo.POJO.Client;
import be.ddo.POJO.Performance;
import be.ddo.POJO.Planning;
import be.ddo.POJO.RoomPlanning;
import be.ddo.POJO.Show;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.JButton;

public class CommandTicket extends JFrame {

	private JPanel contentPane;
	private JTextField txtFConfiguration_Cirque_Gold;
	private JTextField txtFConfiguration_Debout;
	private JTextField txtFConfiguration_Cirque_Silver;
	private JTextField txtFConfiguration_Cirque_Bronze;
	private JTextField txtFConfiguration_Concert_Gold;
	private JTextField txtFConfiguration_Concert_Silver;
	private JTextField txtFConfiguration_Concert_Bronze;
	private JTextField txtFConfiguration_Cirque_Diamant;
	int totalCost = 0;

	@SuppressWarnings("unchecked")
	public CommandTicket(Client client, ArrayList<Show> listOfShow) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 740, 468);
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

		JPanel panel_Configuration = new JPanel();
		panel_Configuration.setBounds(42, 152, 308, 212);
		contentPane.add(panel_Configuration);
		panel_Configuration.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Configuration de la salle", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_Configuration.setLayout(null);

		JPanel panel_Debout = new JPanel();
		panel_Debout.setLayout(null);
		panel_Debout.setBounds(6, 91, 292, 110);
		panel_Configuration.add(panel_Debout);

		JLabel lblConfiguration_MaxSeat_Debout = new JLabel("Debout (8000 places)");
		lblConfiguration_MaxSeat_Debout.setBounds(10, 33, 120, 14);
		panel_Debout.add(lblConfiguration_MaxSeat_Debout);

		txtFConfiguration_Debout = new JTextField();
		txtFConfiguration_Debout.setEditable(false);
		txtFConfiguration_Debout.setEnabled(false);
		txtFConfiguration_Debout.setColumns(10);
		txtFConfiguration_Debout.setBounds(140, 30, 37, 20);
		panel_Debout.add(txtFConfiguration_Debout);

		JLabel lblConfiguration_Symbol_1 = new JLabel("\u20AC");
		lblConfiguration_Symbol_1.setBounds(179, 33, 21, 14);
		panel_Debout.add(lblConfiguration_Symbol_1);

		JSpinner spin_Debout = new JSpinner();
		spin_Debout.setBounds(210, 30, 49, 20);
		panel_Debout.add(spin_Debout);

		panel_Debout.setVisible(true);

		JPanel panel_Cirque = new JPanel();
		panel_Cirque.setBounds(6, 91, 292, 110);
		panel_Configuration.add(panel_Cirque);
		panel_Cirque.setLayout(null);

		JLabel lblConfiguration_MaxSeat_Cirque_Gold = new JLabel("Cat. Or : (2000 places)");
		lblConfiguration_MaxSeat_Cirque_Gold.setBounds(10, 35, 149, 14);
		panel_Cirque.add(lblConfiguration_MaxSeat_Cirque_Gold);

		txtFConfiguration_Cirque_Gold = new JTextField();
		txtFConfiguration_Cirque_Gold.setEditable(false);
		txtFConfiguration_Cirque_Gold.setEnabled(false);
		txtFConfiguration_Cirque_Gold.setBounds(181, 32, 37, 20);
		panel_Cirque.add(txtFConfiguration_Cirque_Gold);
		txtFConfiguration_Cirque_Gold.setColumns(10);

		JLabel lblConfiguration_Symbol = new JLabel("\u20AC");
		lblConfiguration_Symbol.setBounds(218, 35, 31, 14);
		panel_Cirque.add(lblConfiguration_Symbol);

		JLabel lblConfiguration_MaxSeat_Cirque_Silver = new JLabel("Cat. Argent : (1500 places)");
		lblConfiguration_MaxSeat_Cirque_Silver.setBounds(10, 60, 165, 14);
		panel_Cirque.add(lblConfiguration_MaxSeat_Cirque_Silver);

		txtFConfiguration_Cirque_Silver = new JTextField();
		txtFConfiguration_Cirque_Silver.setEnabled(false);
		txtFConfiguration_Cirque_Silver.setEditable(false);
		txtFConfiguration_Cirque_Silver.setColumns(10);
		txtFConfiguration_Cirque_Silver.setBounds(181, 57, 37, 20);
		panel_Cirque.add(txtFConfiguration_Cirque_Silver);

		JLabel lblConfiguration_Symbol_2 = new JLabel("\u20AC");
		lblConfiguration_Symbol_2.setBounds(218, 59, 21, 17);
		panel_Cirque.add(lblConfiguration_Symbol_2);

		JLabel lblConfiguration_MaxSeat_Cirque_Bronze = new JLabel("Cat. Bronze : (3500 places)");
		lblConfiguration_MaxSeat_Cirque_Bronze.setBounds(10, 85, 165, 14);
		panel_Cirque.add(lblConfiguration_MaxSeat_Cirque_Bronze);

		txtFConfiguration_Cirque_Bronze = new JTextField();
		txtFConfiguration_Cirque_Bronze.setEnabled(false);
		txtFConfiguration_Cirque_Bronze.setEditable(false);
		txtFConfiguration_Cirque_Bronze.setColumns(10);
		txtFConfiguration_Cirque_Bronze.setBounds(181, 82, 37, 20);
		panel_Cirque.add(txtFConfiguration_Cirque_Bronze);

		JLabel lblConfiguration_Symbol_2_1 = new JLabel("\u20AC");
		lblConfiguration_Symbol_2_1.setBounds(218, 84, 21, 17);
		panel_Cirque.add(lblConfiguration_Symbol_2_1);

		JLabel lblConfiguration_MaxSeat_Cirque_Diamant = new JLabel("Cat. Diamant : (1000 places)");
		lblConfiguration_MaxSeat_Cirque_Diamant.setBounds(10, 10, 165, 14);
		panel_Cirque.add(lblConfiguration_MaxSeat_Cirque_Diamant);

		txtFConfiguration_Cirque_Diamant = new JTextField();
		txtFConfiguration_Cirque_Diamant.setEnabled(false);
		txtFConfiguration_Cirque_Diamant.setEditable(false);
		txtFConfiguration_Cirque_Diamant.setColumns(10);
		txtFConfiguration_Cirque_Diamant.setBounds(181, 7, 37, 20);
		panel_Cirque.add(txtFConfiguration_Cirque_Diamant);

		JLabel lblConfiguration_Symbol_4 = new JLabel("\u20AC");
		lblConfiguration_Symbol_4.setBounds(219, 10, 21, 14);
		panel_Cirque.add(lblConfiguration_Symbol_4);

		JSpinner spin_Cirque_Diamant = new JSpinner();
		spin_Cirque_Diamant.setBounds(232, 7, 54, 20);
		panel_Cirque.add(spin_Cirque_Diamant);

		JSpinner spin_Cirque_Gold = new JSpinner();
		spin_Cirque_Gold.setBounds(232, 32, 54, 20);
		panel_Cirque.add(spin_Cirque_Gold);

		JSpinner spin_Cirque_Silver = new JSpinner();
		spin_Cirque_Silver.setBounds(232, 57, 54, 20);
		panel_Cirque.add(spin_Cirque_Silver);

		JSpinner spin_Cirque_Bronze = new JSpinner();
		spin_Cirque_Bronze.setBounds(232, 82, 54, 20);
		panel_Cirque.add(spin_Cirque_Bronze);
		panel_Cirque.setVisible(false);

		JPanel panel_Concert = new JPanel();
		panel_Concert.setLayout(null);
		panel_Concert.setBounds(6, 91, 292, 110);
		panel_Configuration.add(panel_Concert);

		JLabel lblConfiguration_MaxSeat_Concert_Gold = new JLabel("Cat. Or : (500 places)");
		lblConfiguration_MaxSeat_Concert_Gold.setBounds(10, 11, 149, 14);
		panel_Concert.add(lblConfiguration_MaxSeat_Concert_Gold);

		txtFConfiguration_Concert_Gold = new JTextField();
		txtFConfiguration_Concert_Gold.setEnabled(false);
		txtFConfiguration_Concert_Gold.setEditable(false);
		txtFConfiguration_Concert_Gold.setColumns(10);
		txtFConfiguration_Concert_Gold.setBounds(169, 8, 37, 20);
		panel_Concert.add(txtFConfiguration_Concert_Gold);

		JLabel lblConfiguration_Symbol_3 = new JLabel("\u20AC");
		lblConfiguration_Symbol_3.setBounds(209, 11, 21, 14);
		panel_Concert.add(lblConfiguration_Symbol_3);

		JLabel lblConfiguration_MaxSeat_Concert_Silver = new JLabel("Cat. Argent : (1500 places)");
		lblConfiguration_MaxSeat_Concert_Silver.setBounds(10, 39, 165, 14);
		panel_Concert.add(lblConfiguration_MaxSeat_Concert_Silver);

		txtFConfiguration_Concert_Silver = new JTextField();
		txtFConfiguration_Concert_Silver.setEditable(false);
		txtFConfiguration_Concert_Silver.setEnabled(false);
		txtFConfiguration_Concert_Silver.setColumns(10);
		txtFConfiguration_Concert_Silver.setBounds(169, 36, 37, 20);
		panel_Concert.add(txtFConfiguration_Concert_Silver);

		JLabel lblConfiguration_Symbol_2_2 = new JLabel("\u20AC");
		lblConfiguration_Symbol_2_2.setBounds(209, 38, 21, 17);
		panel_Concert.add(lblConfiguration_Symbol_2_2);

		JLabel lblConfiguration_MaxSeat_Concert_Bronze = new JLabel("Cat. Bronze : (3500 places)");
		lblConfiguration_MaxSeat_Concert_Bronze.setBounds(10, 69, 165, 14);
		panel_Concert.add(lblConfiguration_MaxSeat_Concert_Bronze);

		txtFConfiguration_Concert_Bronze = new JTextField();
		txtFConfiguration_Concert_Bronze.setEnabled(false);
		txtFConfiguration_Concert_Bronze.setEditable(false);
		txtFConfiguration_Concert_Bronze.setColumns(10);
		txtFConfiguration_Concert_Bronze.setBounds(169, 66, 37, 20);
		panel_Concert.add(txtFConfiguration_Concert_Bronze);

		JLabel lblConfiguration_Symbol_2_1_1 = new JLabel("\u20AC");
		lblConfiguration_Symbol_2_1_1.setBounds(209, 69, 21, 17);
		panel_Concert.add(lblConfiguration_Symbol_2_1_1);

		JSpinner spin_Concert_Gold = new JSpinner();
		spin_Concert_Gold.setBounds(232, 8, 54, 20);
		panel_Concert.add(spin_Concert_Gold);

		JSpinner spin_Concert_Silver = new JSpinner();
		spin_Concert_Silver.setBounds(232, 36, 54, 20);
		panel_Concert.add(spin_Concert_Silver);

		JSpinner spin_Concert_Bronze = new JSpinner();
		spin_Concert_Bronze.setBounds(232, 66, 54, 20);
		panel_Concert.add(spin_Concert_Bronze);
		panel_Concert.setVisible(false);

		JLabel lblConfiguration_Configuration = new JLabel("Configuration de la salle :");
		lblConfiguration_Configuration.setBounds(21, 23, 152, 14);
		panel_Configuration.add(lblConfiguration_Configuration);

		JScrollPane sPane_Performance = new JScrollPane();
		sPane_Performance.setBounds(387, 39, 216, 88);
		contentPane.add(sPane_Performance);

		JList listPerformance = new JList();
		listPerformance.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		sPane_Performance.setViewportView(listPerformance);

		JLabel lblNewLabel_2 = new JLabel("Dates de(s) repr\u00E9sentation(s) :");
		lblNewLabel_2.setBounds(387, 23, 209, 14);
		contentPane.add(lblNewLabel_2);

		JComboBox cbBoxShippingMethod = new JComboBox();
		cbBoxShippingMethod.setModel(new DefaultComboBoxModel(new String[] { "Sur place le jour m\u00EAme",
				"Livraison avec timbre PRIOR", "Livraison s\u00E9curis\u00E9 (+10\u20AC)" }));
		cbBoxShippingMethod.setBounds(467, 203, 203, 22);
		contentPane.add(cbBoxShippingMethod);

		JLabel lblNewLabel_1 = new JLabel("Comment souhaitez-vous retirer les tickets :");
		lblNewLabel_1.setBounds(400, 185, 270, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_4 = new JLabel("Mode de paiement :");
		lblNewLabel_4.setBounds(400, 242, 270, 14);
		contentPane.add(lblNewLabel_4);

		JRadioButton rdBtnVisa = new JRadioButton("VISA");
		rdBtnVisa.setBounds(391, 263, 109, 23);
		contentPane.add(rdBtnVisa);

		JRadioButton rdBtnPaypal = new JRadioButton("Paypal");
		rdBtnPaypal.setToolTipText("Paypal");
		rdBtnPaypal.setBounds(391, 286, 109, 23);
		contentPane.add(rdBtnPaypal);

		JRadioButton rdBtnSepa = new JRadioButton("Virement SEPA (20 jours avant spectacle)");
		rdBtnSepa.setBounds(391, 310, 270, 23);
		contentPane.add(rdBtnSepa);
		
		JLabel lblTotalCost = new JLabel("Total : 0\u20AC");
		lblTotalCost.setFont(new Font("Arial Black", Font.PLAIN, 15));
		lblTotalCost.setBounds(400, 369, 149, 38);
		contentPane.add(lblTotalCost);
		
		JButton btnCompute = new JButton("Calculer le total");
		btnCompute.setBounds(382, 355, 129, 23);
		contentPane.add(btnCompute);
		
		JButton btnNewButton = new JButton("Commander");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.setBounds(600, 379, 124, 49);
		contentPane.add(btnNewButton);

		//
		//
		//
		
		btnCompute.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(listShow.getSelectedValue() != null) {
					
					// Remise à zero le cout total
					totalCost = 0;
					
					// Récupération du spectacle dans la liste
					Show show = (Show) listShow.getSelectedValue();
					
					// Calcule du coup total (on prend tout en compte en débit de la configuration 
					//parce que flemme de tout séparer il est 3h du mat et j'ai envie de dormir)
					for (Category c : show.getConfiguration().getCategoryList()) {
						switch (c.getType()) {
						case "CONCERT_GOLD", "CIRQUE_GOLD":
							totalCost += (int)spin_Cirque_Gold.getValue() * c.getPrice();
							totalCost += (int)spin_Concert_Gold.getValue() * c.getPrice();
							break;
						case "CONCERT_SILVER", "CIRQUE_SILVER":
							totalCost += (int)spin_Cirque_Silver.getValue() * c.getPrice();
							totalCost += (int)spin_Concert_Silver.getValue() * c.getPrice();
							break;
						case "CONCERT_BRONZE", "CIRQUE_BRONZE":
							totalCost += (int)spin_Cirque_Bronze.getValue() * c.getPrice();
							totalCost += (int)spin_Concert_Bronze.getValue() * c.getPrice();;
							break;
						case "DEBOUT":
							totalCost += (int)spin_Debout.getValue() * c.getPrice();
							break;
						case "CIRQUE_DIAMANT":
							totalCost += (int)spin_Cirque_Diamant.getValue() * c.getPrice();
							break;
						default:
							break;
						}
					}
					if(cbBoxShippingMethod.getSelectedItem().toString().compareTo("Livraison sécurisé (+10€)") == 0)
						totalCost += 10;
					
					// +5 de frais de dossier
					totalCost += 5;
					lblTotalCost.setText("Total : "+totalCost+"");
				}
			}
		});

		// =================================================================================
		// OnClick ListShow
		// =================================================================================
		listShow.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Show show = (Show) listShow.getSelectedValue();

				listPerformance.setModel(new AbstractListModel() {
					ArrayList<Performance> values = show.getListPerformance();

					public int getSize() {
						return values.size();
					}

					public Performance getElementAt(int index) {
						return values.get(index);
					}

				});

				int gold = 0, silver = 0, bronze = 0, diamant = 0, debout = 0, maxSeatDebout = 0, maxSeatDiamant = 0,
						maxSeatGold = 0, maxSeatSilver = 0, maxSeatBronze = 0;

				for (Category c : show.getConfiguration().getCategoryList()) {
					switch (c.getType()) {
					case "CONCERT_GOLD", "CIRQUE_GOLD":
						gold = c.getPrice();
						maxSeatGold = c.getSeatLeft();
						break;
					case "CONCERT_SILVER", "CIRQUE_SILVER":
						silver = c.getPrice();
						maxSeatSilver = c.getSeatLeft();
						break;
					case "CONCERT_BRONZE", "CIRQUE_BRONZE":
						bronze = c.getPrice();
						maxSeatBronze = c.getSeatLeft();
						break;
					case "DEBOUT":
						debout = c.getPrice();
						maxSeatDebout = c.getSeatLeft();
						break;
					case "CIRQUE_DIAMANT":
						diamant = c.getPrice();
						maxSeatDiamant = c.getSeatLeft();
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
					lblConfiguration_MaxSeat_Debout.setText("Debout (" + maxSeatDebout + " places)");
					break;
				case "CIRQUE":
					panel_Debout.setVisible(false);
					panel_Cirque.setVisible(true);
					panel_Concert.setVisible(false);
					txtFConfiguration_Cirque_Diamant.setText(String.valueOf(diamant));
					txtFConfiguration_Cirque_Gold.setText(String.valueOf(gold));
					txtFConfiguration_Cirque_Silver.setText(String.valueOf(silver));
					txtFConfiguration_Cirque_Bronze.setText(String.valueOf(bronze));
					lblConfiguration_MaxSeat_Cirque_Diamant.setText("Cat. Diamant : (" + maxSeatDiamant + " places)");
					lblConfiguration_MaxSeat_Cirque_Gold.setText("Cat. Or : (" + maxSeatGold + " places)");
					lblConfiguration_MaxSeat_Cirque_Silver.setText("Cat. Argent : (" + maxSeatSilver + " places)");
					lblConfiguration_MaxSeat_Cirque_Bronze.setText("Cat. Bronze : (" + maxSeatBronze + " places)");
					break;

				case "CONCERT":
					panel_Debout.setVisible(false);
					panel_Cirque.setVisible(false);
					panel_Concert.setVisible(true);
					lblConfiguration_MaxSeat_Concert_Gold.setText("Cat. Or : (" + maxSeatGold + " places)");
					lblConfiguration_MaxSeat_Concert_Silver.setText("Cat. Argent : (" + maxSeatSilver + " places)");
					lblConfiguration_MaxSeat_Concert_Bronze.setText("Cat. Bronze : (" + maxSeatBronze + " places)");
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
