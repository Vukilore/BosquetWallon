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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import com.toedter.calendar.JDateChooser;

import be.ddo.POJO.Artist;
import be.ddo.POJO.Category;
import be.ddo.POJO.Manager;
import be.ddo.POJO.Performance;
import be.ddo.POJO.RoomPlanning;
import be.ddo.POJO.Show;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JMonthChooser;
import javax.swing.SwingConstants;
import javax.swing.JProgressBar;
import javax.swing.JDesktopPane;

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

	@SuppressWarnings("unchecked")
	public CreatePlanning(Manager manager, ArrayList<Show> listShow, ArrayList<RoomPlanning> listPlanning) {
		setTitle("Cr\u00E9ation d'un \u00E9venement");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 688, 457);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_CreateShow = new JPanel();
		panel_CreateShow.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Choix du spectacle", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_CreateShow.setBounds(16, 19, 257, 164);
		contentPane.add(panel_CreateShow);
		panel_CreateShow.setLayout(null);

		JPanel panel_Configuration = new JPanel();
		panel_Configuration.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Configuration de la salle", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_Configuration.setBounds(17, 186, 256, 212);
		contentPane.add(panel_Configuration);
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

		JLabel lblShow_Choice = new JLabel("Choix du spectacle :");
		lblShow_Choice.setBounds(18, 21, 157, 14);
		panel_CreateShow.add(lblShow_Choice);

		JScrollPane sPane_ListArtist = new JScrollPane();
		sPane_ListArtist.setBounds(18, 38, 190, 68);
		panel_CreateShow.add(sPane_ListArtist);

		JList list = new JList();
		list.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		list.setVisibleRowCount(3);
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

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Choix de la date", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(336, 19, 302, 164);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblRoom_Date = new JLabel("Date de la r\u00E9servation :");
		lblRoom_Date.setBounds(6, 19, 133, 14);
		panel.add(lblRoom_Date);

		JLabel lvlRoomDuration = new JLabel("Dur\u00E9e de la s\u00E9ance (heure) :");
		lvlRoomDuration.setBounds(6, 48, 143, 14);
		panel.add(lvlRoomDuration);

		JSpinner spin_RoomDuration = new JSpinner();
		spin_RoomDuration.setBounds(159, 45, 133, 20);
		panel.add(spin_RoomDuration);
		spin_RoomDuration.setModel(new SpinnerNumberModel(12, 1, 24, 1));

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

		JLabel lblNewLabel = new JLabel("Heure du commencement :");
		lblNewLabel.setBounds(6, 73, 153, 14);
		panel.add(lblNewLabel);

		JComboBox cBox_BeginHour = new JComboBox();
		cBox_BeginHour.setModel(new DefaultComboBoxModel(
				new String[] { "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));
		cBox_BeginHour.setBounds(159, 69, 50, 22);
		panel.add(cBox_BeginHour);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(16, 98, 257, 55);
		panel.add(scrollPane);

		JList listDate = new JList();
		listDate.setEnabled(false);
		scrollPane.setViewportView(listDate);

		JButton btnBooking = new JButton("R\u00E9server");
		btnBooking.setBounds(563, 340, 89, 23);
		contentPane.add(btnBooking);
		
		JLabel lblWarning = new JLabel("<html><b>Attention :</b> la salle doit \u00EAtre remise en ordre et op\u00E9rationnelle pour le lendemain 12h.</html>");
		lblWarning.setBounds(346, 186, 302, 28);
		contentPane.add(lblWarning);

		// =================================================================================
		// OnClick List
		// =================================================================================
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Show show;
				show = (Show) list.getSelectedValue();
				lblShow_PerClientMaxSeat.setText("Place maximum par client : " + show.getPerUserMaxSeat());
				lblShow_Type.setText("Type de spectacle : " + show.getConfiguration().getConfigurationType());

				ArrayList<Category> listCategory = new ArrayList<Category>();
				listCategory.addAll(show.getConfiguration().getCategoryList());

				int gold = 0, silver = 0, bronze = 0, diamant = 0, debout = 0;

				for (Category c : listCategory) {
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
				// Récupération du show
				Show show;
				show = (Show) list.getSelectedValue();
				
				// Récupération des dates
				Date reservingDate = dateChooser.getDate();
				Date beginDate = reservingDate;
				Date endDate = reservingDate;

				reservingDate.setHours(12);
				
				
				// Récupération de l'heure du début 
				int beginHour = (int) cBox_BeginHour.getSelectedItem();
				beginDate.setHours(beginHour);
				
				// Récupération du temps de la séance
				int duration = (int) spin_RoomDuration.getValue();
				DateUtils.addHours(endDate, duration);
				
				Performance perform = new Performance(show, beginDate, endDate);
				
				DateUtils.addHours(endDate, 1);
				RoomPlanning room = new RoomPlanning(show, reservingDate, endDate);
			
				
			}
		});
		// =================================================================================
		// Onchange : dateChooser
		// =================================================================================
		dateChooser.addPropertyChangeListener(new PropertyChangeListener() {

			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				System.out.println("Calendrier changé pour : " + dateChooser.getDate());
				Date date = dateChooser.getDate();
				date.setHours(12);
				System.out.println("Calendrier changé pour : " + date);
			}
		});
	}
}
