package be.ddo.FRAMES;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;

import org.apache.commons.lang3.time.DateUtils;
import java.awt.Color;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import com.toedter.calendar.JDateChooser;

import be.ddo.POJO.Artist;
import be.ddo.POJO.Booking;
import be.ddo.POJO.Category;
import be.ddo.POJO.Manager;
import be.ddo.POJO.Organizer;
import be.ddo.POJO.Performance;
import be.ddo.POJO.Planning;
import be.ddo.POJO.RoomPlanning;
import be.ddo.POJO.Show;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JMonthChooser;
import javax.swing.SwingConstants;
import javax.swing.JProgressBar;
import javax.swing.JDesktopPane;
import com.toedter.components.JSpinField;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class CreatePlanning extends JFrame {

	private JPanel contentPane;
	private JTextField txtFShow_Title;
	private JTextField txtFConfiguration_Cirque_Gold;
	private JTextField txtFConfiguration_Debout;
	private JTextField txtFConfiguration_Cirque_Silver;
	private JTextField txtFConfiguration_Cirque_Bronze;
	private JTextField txtFConfiguration_Concert_Gold;
	private JTextField txtFConfiguration_Concert_Silver;
	private JTextField txtFConfiguration_Concert_Bronze;
	private JTextField txtFConfiguration_Cirque_Diamant;
	private int totalCost;
	private ArrayList<Performance> listOfPerformance = new ArrayList<Performance>();

	@SuppressWarnings("unchecked")
	public CreatePlanning(Organizer organizer, ArrayList<Show> listShow) {
		setTitle("Cr\u00E9ation d'un \u00E9venement");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 688, 613);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_CreateShow = new JPanel();
		panel_CreateShow.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"(1) Choix du spectacle", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_CreateShow.setBounds(16, 19, 280, 398);
		contentPane.add(panel_CreateShow);
		panel_CreateShow.setLayout(null);

		JLabel lblShow_Choice = new JLabel("Choix du spectacle :");
		lblShow_Choice.setBounds(18, 21, 157, 14);
		panel_CreateShow.add(lblShow_Choice);

		JScrollPane sPane_ListArtist = new JScrollPane();
		sPane_ListArtist.setBounds(18, 38, 190, 68);
		panel_CreateShow.add(sPane_ListArtist);

		JList list = new JList();
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setModel(new AbstractListModel() {
			ArrayList<Show> values = listShow;

			public int getSize() {
				return values.size();
			}

			public Show getElementAt(int index) {
				return values.get(index);
			}

		});
		sPane_ListArtist.setViewportView(list);

		JLabel lblShow_PerClientMaxSeat = new JLabel("Place maximum par client :");
		lblShow_PerClientMaxSeat.setBounds(28, 110, 180, 14);
		panel_CreateShow.add(lblShow_PerClientMaxSeat);

		JLabel lblShow_Type = new JLabel("Type de spectacle : ");
		lblShow_Type.setBounds(27, 128, 181, 14);
		panel_CreateShow.add(lblShow_Type);

		JPanel panel_Configuration = new JPanel();
		panel_Configuration.setBounds(10, 153, 256, 212);
		panel_CreateShow.add(panel_Configuration);
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

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"(2) Choix de la date de r\u00E9servation", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		panel.setBounds(336, 19, 302, 199);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblRoom_Date = new JLabel("Date de la r\u00E9servation :");
		lblRoom_Date.setBounds(16, 25, 143, 14);
		panel.add(lblRoom_Date);

		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.HOUR_OF_DAY, 12);
		cal.getTime();
		JCalendar calendar = new JCalendar(GregorianCalendar.getInstance());
		JDateChooser dateChooser = new JDateChooser(calendar, cal.getTime(), "dd.MM.yy", null);

		GregorianCalendar maxCal = (GregorianCalendar) GregorianCalendar.getInstance();
		maxCal.set(2021, 05, 30); // Réservation possible jusqu'au 30 juin 2021
		dateChooser.setBounds(159, 19, 133, 20);
		dateChooser.setSelectableDateRange(cal.getTime(), maxCal.getTime());
		panel.add(dateChooser);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 62, 257, 92);
		panel.add(scrollPane);

		JList listDate = new JList();
		listDate.setEnabled(false);
		listDate.setModel(new AbstractListModel() {
			ArrayList<RoomPlanning> values = Planning.getInstance().getPlannings();

			public int getSize() {
				return values.size();
			}

			public RoomPlanning getElementAt(int index) {
				return values.get(index);
			}

		});
		scrollPane.setViewportView(listDate);

		JLabel lblNewLabel_2 = new JLabel("Date(s) non disponible :");
		lblNewLabel_2.setBounds(31, 44, 165, 14);
		panel.add(lblNewLabel_2);

		JLabel lblWarning = new JLabel(
				"<html><b>Attention :</b> la salle doit \u00EAtre remise en ordre et op\u00E9rationnelle pour le lendemain 12h.</html>");
		lblWarning.setBounds(31, 160, 302, 28);
		panel.add(lblWarning);

		JButton btnBooking = new JButton("R\u00E9server");
		btnBooking.setBounds(414, 538, 104, 35);
		contentPane.add(btnBooking);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"(3) Cr\u00E9ation de repr\u00E9sentations", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		panel_1.setBounds(331, 229, 322, 287);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel = new JLabel("Liste des repr\u00E9sentations du spectacle :");
		lblNewLabel.setBounds(10, 131, 225, 14);
		panel_1.add(lblNewLabel);

		JLabel lblNewLabel_3 = new JLabel("Heure du d\u00E9but :");
		lblNewLabel_3.setBounds(6, 81, 154, 14);
		panel_1.add(lblNewLabel_3);

		JLabel lblNewLabel_3_1 = new JLabel("Heure ouverture des portes :");
		lblNewLabel_3_1.setBounds(6, 56, 154, 14);
		panel_1.add(lblNewLabel_3_1);

		JLabel lblNewLabel_3_1_1 = new JLabel("Heure de fin :");
		lblNewLabel_3_1_1.setBounds(6, 106, 154, 14);
		panel_1.add(lblNewLabel_3_1_1);

		JSpinner spin_BeginDate = new JSpinner();
		spin_BeginDate.setBounds(214, 78, 41, 20);
		panel_1.add(spin_BeginDate);

		JSpinner spin_OpenDate = new JSpinner();
		spin_OpenDate.setBounds(214, 53, 41, 20);
		panel_1.add(spin_OpenDate);

		JSpinner spin_EndDate = new JSpinner();
		spin_EndDate.setBounds(214, 103, 41, 20);
		panel_1.add(spin_EndDate);

		JScrollPane sPane_Performance = new JScrollPane();
		sPane_Performance.setBounds(10, 156, 302, 86);
		panel_1.add(sPane_Performance);

		JList listPerformance = new JList();
		listPerformance.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		sPane_Performance.setViewportView(listPerformance);
		listPerformance.setModel(new AbstractListModel() {
			ArrayList<Performance> values = listOfPerformance;

			public int getSize() {
				return values.size();
			}

			public Performance getElementAt(int index) {
				return values.get(index);
			}

		});

		JButton btnAddPerf = new JButton("+");
		btnAddPerf.setBounds(214, 253, 41, 23);
		panel_1.add(btnAddPerf);

		JButton btnRemovePerf = new JButton("-");
		btnRemovePerf.setBounds(265, 253, 41, 23);
		panel_1.add(btnRemovePerf);

		JLabel lblNewLabel_1 = new JLabel("Jour de repr\u00E9sentation :");
		lblNewLabel_1.setBounds(10, 31, 172, 14);
		panel_1.add(lblNewLabel_1);

		JDateChooser dateChoosen = new JDateChooser();
		dateChoosen.setBounds(178, 25, 119, 20);
		panel_1.add(dateChoosen);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(16, 447, 280, 84);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblTotalCost = new JLabel("Montant \u00E0 payer: 0\u20AC");
		lblTotalCost.setBounds(21, 11, 222, 14);
		panel_2.add(lblTotalCost);

		JLabel lblNewLabel66 = new JLabel("Accompte :");
		lblNewLabel66.setBounds(21, 47, 95, 14);
		panel_2.add(lblNewLabel66);

		JSpinner spinDeposit = new JSpinner();
		spinDeposit.setModel(new SpinnerNumberModel(0, 0, 4500, 1));
		spinDeposit.setBounds(138, 44, 74, 20);
		panel_2.add(spinDeposit);

		JLabel lblNewLabel_4 = new JLabel("\u20AC");
		lblNewLabel_4.setBounds(213, 47, 46, 14);
		panel_2.add(lblNewLabel_4);
		dateChoosen.setSelectableDateRange(maxCal.getTime(), cal.getTime());
		// =================================================================================
		// Onchange : dateChoosen (2)
		// =================================================================================
		dateChoosen.addPropertyChangeListener("date", new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				// HACK : Ignore une erreur de JCalendar qui appelait l'event au moment de
				// l'ouverture/fermeture de la JFrame
				Date newDate = (Date) evt.getNewValue();
				Date oldDate = (Date) evt.getOldValue();
				if (newDate != null && oldDate != null) {
					LocalDate newLD = LocalDate.ofInstant(newDate.toInstant(), ZoneId.systemDefault());
					LocalDate oldLD = LocalDate.ofInstant(oldDate.toInstant(), ZoneId.systemDefault());
					if (newLD.equals(oldLD)) {
						return;
					}
				}
				if (dateChooser.getDate() != null && dateChoosen.getDate() != null) {
					if (dateChoosen.getDate().compareTo(dateChooser.getDate()) == 0) // si le jour J
					{
						spin_OpenDate.setModel(new SpinnerNumberModel(12, 12, 22, 1));
						spin_BeginDate.setModel(new SpinnerNumberModel(13, 13, 23, 1));
						spin_EndDate.setModel(new SpinnerNumberModel(14, 14, 24, 1));
					} else { // Si le jour J+1
						spin_OpenDate.setModel(new SpinnerNumberModel(0, 0, 9, 1));
						spin_BeginDate.setModel(new SpinnerNumberModel(1, 1, 10, 1));
						spin_EndDate.setModel(new SpinnerNumberModel(2, 2, 11, 1));
					}
				}
			}
		});
		// =================================================================================
		// Bouton '-'
		// =================================================================================
		btnRemovePerf.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (listPerformance.getSelectedValue() != null) {
					if (listOfPerformance.size() > 0) {

						// Suppression de la représentation de la liste
						listOfPerformance.remove((Performance) listPerformance.getSelectedValue());

						// Mise à jour la liste du GUI
						listPerformance.setModel(new AbstractListModel() {
							ArrayList<Performance> values = listOfPerformance;

							public int getSize() {
								return values.size();
							}

							public Performance getElementAt(int index) {
								return values.get(index);
							}

						});
					} else
						JOptionPane.showMessageDialog(null, "Erreure innatendue, la liste est déjà vide.");
				} else
					JOptionPane.showMessageDialog(null,
							"Choisissez une représentation dans la liste, avant de l'enlever !");
			}
		});
		// =================================================================================
		// Bouton '+'
		// =================================================================================
		btnAddPerf.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mousePressed(MouseEvent e) {
				if (list.getSelectedValue() != null) {
					if (dateChooser.getDate() != null && dateChoosen.getDate() != null) {
						boolean changedShow = false;
						if (listOfPerformance.size() > 0) {
							for (Performance perf : listOfPerformance)
								if (perf.getShow() != (Show) list.getSelectedValue())
									changedShow = true;

						}
						if (changedShow == false) { // Si il n'a pas changé de spectacle entre temps
							Date datePerformance = dateChoosen.getDate();
							// On met à jour les spinners
							try {
								spin_BeginDate.commitEdit();
								spin_OpenDate.commitEdit();
								spin_EndDate.commitEdit();
							} catch (ParseException e1) {
								e1.printStackTrace();
							}
							int sBeginDate = (int) spin_BeginDate.getValue();
							int sOpenDate = (int) spin_OpenDate.getValue();
							int sEndDate = (int) spin_EndDate.getValue();

							if (sOpenDate < sBeginDate) {
								if (sBeginDate < sEndDate) {
									// Attribution des heures
									Date beginDate = dateChoosen.getDate();
									beginDate.setHours(sBeginDate);
									Date openDate = dateChoosen.getDate();
									openDate.setHours(sOpenDate);
									Date endDate = dateChoosen.getDate();
									endDate.setHours(sEndDate);

									// Vérification des heures si ils sont pas dans la plage de ceux de la liste
									boolean isUsedDate = false;
									if (listOfPerformance.size() > 0)
										for (Performance perf : listOfPerformance)
											if (isDateBetween(openDate, perf.getOpenDate(), perf.getEndDate())
													|| isDateBetween(endDate, perf.getOpenDate(), perf.getEndDate())
													|| openDate.compareTo(perf.getOpenDate()) == 0
													|| endDate.compareTo(perf.getEndDate()) == 0) {
												isUsedDate = true;
												break;
											}
									// Si les heures ne sont pas dans la plage de la liste
									if (isUsedDate == false) {

										// Récupération du spectacle
										Show show = (Show) list.getSelectedValue();

										// Création de l'objet représentation
										Performance perf = new Performance(beginDate, openDate, endDate, show);

										// Ajout à la liste global des représentation pour ce spectacle
										listOfPerformance.add(perf);

										// Mise à jour la liste du GUI
										listPerformance.setModel(new AbstractListModel() {
											ArrayList<Performance> values = listOfPerformance;

											public int getSize() {
												return values.size();
											}

											public Performance getElementAt(int index) {
												return values.get(index);
											}

										});
									} else
										JOptionPane.showMessageDialog(null,
												"Ces heures sont dans la plage d'une autre représentation de votre liste !");
								} else
									JOptionPane.showMessageDialog(null,
											"L'heure du début du spectacle doit être plus petite que celle de fin !");
							} else
								JOptionPane.showMessageDialog(null,
										"L'heure de l'ouverture des portes doit être plus petite que le début du spectacle !");
						} else
							JOptionPane.showMessageDialog(null,
									"Merci de ne pas changer de spectacle ! (Spectacle choisis :"
											+ (Show) list.getSelectedValue() + ")");
					} else
						JOptionPane.showMessageDialog(null, "Ce n'est pas possible de réserver pour aujourd'hui ! ");
				} else
					JOptionPane.showMessageDialog(null, "Veuillez d'abord choisir un spectacle ! ");
			}
		});
		// =================================================================================
		// Onchange : spinOpen
		// =================================================================================
		spin_OpenDate.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				spin_BeginDate.setModel(new SpinnerNumberModel((int) spin_OpenDate.getValue() + 1,
						(int) spin_OpenDate.getValue() + 1, 23, 1));
			}
		});

		// =================================================================================
		// Onchange : spinBegin
		// =================================================================================
		spin_BeginDate.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				spin_EndDate.setModel(new SpinnerNumberModel((int) spin_BeginDate.getValue() + 1,
						(int) spin_BeginDate.getValue() + 1, 24, 1));
			}
		});

		// =================================================================================
		// OnClick ListShow
		// =================================================================================
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Show show;
				show = (Show) list.getSelectedValue();
				lblShow_PerClientMaxSeat.setText("Place maximum par client : " + show.getPerUserMaxSeat());
				lblShow_Type.setText("Type de spectacle : " + show.getConfiguration().getConfigurationType());

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
		// =================================================================================
		// Bouton Reserver
		// =================================================================================
		btnBooking.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (listOfPerformance.size() > 0) {

					Date date = dateChooser.getDate();
					if (isDateAvailableForPlanning(date)) {
						// Récupération du show dans la liste
						Show show = (Show) list.getSelectedValue();
						// Création des représentations:
						for (Performance perf : listOfPerformance)
							perf.create();

						// Ajout des représentation dans le spectacle
						show.setListPerformance(listOfPerformance);

						// Création des dates pour le planning
						GregorianCalendar datePlus = (GregorianCalendar) GregorianCalendar.getInstance();
						datePlus.setTime(date);
						datePlus.set(Calendar.HOUR, 12);
						datePlus.add(Calendar.DATE, 1);

						// Création de l'objet planning
						RoomPlanning rp = new RoomPlanning(organizer.getId(), show, date, datePlus.getTime());
						// Sauvegarde de l'objet planning
						rp.create();

						// Ajout du planning à l'instance
						Planning.getInstance().getPlannings().add(rp);

						// On met à jour le spinner
						try {
							spinDeposit.commitEdit();
						} catch (ParseException e1) {
							e1.printStackTrace();
						}

						// Ajout de la réservation de la salle
						Booking booking = new Booking(rp, organizer, totalCost, (int) spinDeposit.getValue());
						booking.create();

						// Dispose de la fenetre
						JOptionPane.showMessageDialog(null, "Vous avez bien créer un nouveau planning pour la salle.");
						dispose();

					} else
						JOptionPane.showMessageDialog(null,
								"Cette date est déjà reservée ! (voir la liste des dates non disponibles)");
				} else
					JOptionPane.showMessageDialog(null, "Vous n'avez pas encore créé de représentation !");

			}
		});
		// =================================================================================
		// Onchange : dateChooser
		// =================================================================================
		dateChooser.addPropertyChangeListener("date", new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				///////////////////////////////////////////////////////////////////////////////////////////////////////////////
				///////////////////////////////////////////////////////////////////////////////////////////////////////////////
				// HACK : Ignore une erreur de JCalendar qui appelait l'event au moment de
				/////////////////////////////////////////////////////////////////////////////////////////////////////////////// l'ouverture/fermeture
				/////////////////////////////////////////////////////////////////////////////////////////////////////////////// de
				/////////////////////////////////////////////////////////////////////////////////////////////////////////////// la
				/////////////////////////////////////////////////////////////////////////////////////////////////////////////// JFrame
				/* */Date newDate = (Date) evt.getNewValue();
				/* */Date oldDate = (Date) evt.getOldValue();
				/* */if (newDate != null && oldDate != null) {
					/* */ LocalDate newLD = LocalDate.ofInstant(newDate.toInstant(), ZoneId.systemDefault());
					/* */ LocalDate oldLD = LocalDate.ofInstant(oldDate.toInstant(), ZoneId.systemDefault());
					/* */ if (newLD.equals(oldLD)) {
						/* */ return;
						/* */ }
					/* */}
				///////////////////////////////////////////////////////////////////////////////////////////////////////////////
				///////////////////////////////////////////////////////////////////////////////////////////////////////////////

				Date date = dateChooser.getDate();
				if (isDateAvailableForPlanning(date)) {
					GregorianCalendar datePlus = (GregorianCalendar) GregorianCalendar.getInstance();
					GregorianCalendar dateNow = (GregorianCalendar) GregorianCalendar.getInstance();
					dateNow.setTime(date);
					datePlus.setTime(date);
					datePlus.add(Calendar.DATE, 1);
					dateChoosen.setSelectableDateRange(date, datePlus.getTime());
					dateChoosen.setCalendar(dateNow);
					dateChoosen.setEnabled(true);
					switch (dateNow.get(Calendar.DAY_OF_WEEK)) {
					case Calendar.FRIDAY, Calendar.SATURDAY:
						totalCost = 4500;
						break;
					default:
						totalCost = 3000;
						break;
					}
					spinDeposit.setModel(new SpinnerNumberModel(0, 0, totalCost, 1));
					lblTotalCost.setText("Montant à payer : " + totalCost + "€");
				} else {
					JOptionPane.showMessageDialog(null,
							"Cette date est déjà reservée ! (voir la liste des dates non disponibles)");
					dateChoosen.setEnabled(false);
					dateChoosen.setDate(null);
				}
			}

		});

	}

	private static Boolean isDateAvailableForPlanning(Date date) {
		Boolean isAvailable = true;
		for (RoomPlanning rp : Planning.getInstance().getPlannings())
			if (date.compareTo(rp.getBeginDate()) == 0)
				return false;
		return isAvailable;
	}

	private static boolean isDateBetween(Date date, Date dateStart, Date dateEnd) {
		if (date != null && dateStart != null && dateEnd != null)
			if (date.after(dateStart) && date.before(dateEnd))
				return true;
		return false;
	}
}
