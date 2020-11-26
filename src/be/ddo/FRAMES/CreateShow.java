package be.ddo.FRAMES;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import be.ddo.POJO.Artist;
import be.ddo.POJO.Category;
import be.ddo.POJO.CategoryType;
import be.ddo.POJO.Configuration;
import be.ddo.POJO.ConfigurationType;
import be.ddo.POJO.Show;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.AbstractListModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CreateShow extends JFrame {

	private static final long serialVersionUID = 2967800489532772299L;
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

	public static boolean isNumeric(String str) {
		for (char c : str.toCharArray()) {
			if (!Character.isDigit(c))
				return false;
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	public CreateShow(ArrayList<Artist> listOfArtist) {
		setTitle("Cr\u00E9ation d'un spectacle");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 621, 362);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTitle = new JLabel("Titre du spectacle :");
		lblTitle.setBounds(25, 30, 133, 14);
		contentPane.add(lblTitle);

		txtFShow_Title = new JTextField();
		txtFShow_Title.setBounds(135, 27, 142, 20);
		contentPane.add(txtFShow_Title);
		txtFShow_Title.setColumns(10);

		JScrollPane sPaneListArtist = new JScrollPane();
		sPaneListArtist.setBounds(25, 94, 225, 109);
		contentPane.add(sPaneListArtist);

		JList listArtist = new JList();
		listArtist.setModel(new AbstractListModel() {
			ArrayList<Artist> values = listOfArtist;

			public int getSize() {
				return values.size();
			}

			public Artist getElementAt(int index) {
				return values.get(index);
			}
		});
		sPaneListArtist.setViewportView(listArtist);

		JPanel panel_Configuration = new JPanel();
		panel_Configuration.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Configuration de la salle", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_Configuration.setBounds(340, 30, 256, 212);
		contentPane.add(panel_Configuration);
		panel_Configuration.setLayout(null);

		JPanel panel_Cirque = new JPanel();
		panel_Cirque.setBounds(6, 91, 240, 110);
		panel_Configuration.add(panel_Cirque);
		panel_Cirque.setLayout(null);

		JLabel lblConfiguration_MaxSeat_Cirque = new JLabel("Cat. Or : (2000 places)");
		lblConfiguration_MaxSeat_Cirque.setBounds(10, 35, 149, 14);
		panel_Cirque.add(lblConfiguration_MaxSeat_Cirque);

		txtFConfiguration_Cirque_Gold = new JTextField();
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

		JComboBox cbox_Configuration = new JComboBox();
		cbox_Configuration.setBounds(21, 44, 152, 22);
		panel_Configuration.add(cbox_Configuration);
		cbox_Configuration.setModel(
				new DefaultComboBoxModel(new String[] { "Debout", "Assis version concert", "Assis version cirque" }));

		JPanel panel_Debout = new JPanel();
		panel_Debout.setLayout(null);
		panel_Debout.setBounds(6, 91, 240, 110);
		panel_Configuration.add(panel_Debout);

		JLabel lblConfiguration_Debout_Price_1 = new JLabel("Prix de la place :");
		lblConfiguration_Debout_Price_1.setBounds(10, 33, 120, 14);
		panel_Debout.add(lblConfiguration_Debout_Price_1);

		txtFConfiguration_Debout = new JTextField();
		txtFConfiguration_Debout.setColumns(10);
		txtFConfiguration_Debout.setBounds(140, 30, 37, 20);
		panel_Debout.add(txtFConfiguration_Debout);

		JLabel lblConfiguration_Symbol_1 = new JLabel("\u20AC");
		lblConfiguration_Symbol_1.setBounds(179, 33, 21, 14);
		panel_Debout.add(lblConfiguration_Symbol_1);

		panel_Debout.setVisible(true);

		JLabel lblNewLabel_1 = new JLabel("Artiste(s) \u00E0 ajouter :");
		lblNewLabel_1.setBounds(25, 69, 133, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Nombre de place maximum par client :");
		lblNewLabel_2.setBounds(25, 231, 225, 14);
		contentPane.add(lblNewLabel_2);

		JSpinner spinPerClientMaxSeat = new JSpinner();
		spinPerClientMaxSeat.setModel(new SpinnerNumberModel(1, 1, 8000, 1));
		spinPerClientMaxSeat.setBounds(245, 228, 47, 20);
		contentPane.add(spinPerClientMaxSeat);

		JButton btnCreateShow = new JButton("Cr\u00E9er un spectacle");
		btnCreateShow.setBounds(54, 280, 196, 23);
		contentPane.add(btnCreateShow);

		// =================================================================================
		// Combobox Listener
		// =================================================================================
		cbox_Configuration.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (cbox_Configuration.getSelectedItem().toString().equals("Debout")) {
					panel_Debout.setVisible(true);
					panel_Cirque.setVisible(false);
					panel_Concert.setVisible(false);
				} else if (cbox_Configuration.getSelectedItem().toString().equals("Assis version concert")) {
					panel_Debout.setVisible(false);
					panel_Cirque.setVisible(false);
					panel_Concert.setVisible(true);
				} else if (cbox_Configuration.getSelectedItem().toString().equals("Assis version cirque")) {
					panel_Debout.setVisible(false);
					panel_Cirque.setVisible(true);
					panel_Concert.setVisible(false);
				}
			}
		});

		// =================================================================
		// Création du spectacle
		// =================================================================
		btnCreateShow.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				if (!txtFShow_Title.getText().isBlank()) {
					ArrayList<Artist> selectedArtist = new ArrayList<Artist>();
					selectedArtist.addAll(listArtist.getSelectedValuesList());
					if (!selectedArtist.isEmpty()) {
						if (cbox_Configuration.getSelectedItem().toString().equals("Debout")) {
							if (!txtFConfiguration_Debout.getText().isBlank()
									&& isNumeric(txtFConfiguration_Debout.getText())) {
								// Création du show de type DEBOUT :
								// Création de la liste des catégories
								ArrayList<Category> listCategory = new ArrayList<Category>();

								// Définition du prix de la place
								int price = Integer.parseInt(txtFConfiguration_Debout.getText());
								// Ajout des catégories à la liste
								listCategory.add(new Category(CategoryType.DEBOUT, price));

								// Création de la configuration de la salle
								Configuration config = new Configuration(ConfigurationType.DEBOUT, listCategory);

								// Création du spectacle
								Show show = new Show(txtFShow_Title.getText(), selectedArtist,
										(int) spinPerClientMaxSeat.getValue(), config);

								// Sauvegarde du spectacle dans la BDD
								show.create();

							} else
								JOptionPane.showMessageDialog(null, "Veuillez remplir le prix de la place !");
						} else if (cbox_Configuration.getSelectedItem().toString().equals("Assis version concert")) {
							if (!txtFConfiguration_Concert_Gold.getText().isBlank()
									&& isNumeric(txtFConfiguration_Concert_Gold.getText())
									&& !txtFConfiguration_Concert_Silver.getText().isBlank()
									&& isNumeric(txtFConfiguration_Concert_Silver.getText())
									&& !txtFConfiguration_Concert_Bronze.getText().isBlank()
									&& isNumeric(txtFConfiguration_Concert_Bronze.getText())) {
								// Création du show de type Concert :
								// Création de la liste des catégories
								ArrayList<Category> listCategory = new ArrayList<Category>();

								// Définition du prix de la place
								int price = Integer.parseInt(txtFConfiguration_Concert_Gold.getText());
								// Ajout des catégories à la liste
								listCategory.add(new Category(CategoryType.CONCERT_GOLD, price));
								// Définition du prix de la place
								price = Integer.parseInt(txtFConfiguration_Concert_Silver.getText());
								// Ajout des catégories à la liste
								listCategory.add(new Category(CategoryType.CONCERT_SILVER, price));

								// Définition du prix de la place
								price = Integer.parseInt(txtFConfiguration_Concert_Bronze.getText());
								// Ajout des catégories à la liste
								listCategory.add(new Category(CategoryType.CONCERT_BRONZE, price));

								// Création de la configuration de la salle
								Configuration config = new Configuration(ConfigurationType.CONCERT, listCategory);
								// Création du spectacle
								Show show = new Show(txtFShow_Title.getText(), selectedArtist,
										(int) spinPerClientMaxSeat.getValue(), config);
								
								// Sauvegarde du spectacle dans la BDD
								show.create();

							} else
								JOptionPane.showMessageDialog(null, "Veuillez remplir les prix des places !");

						} else if (cbox_Configuration.getSelectedItem().toString().equals("Assis version cirque")) {
							if (!txtFConfiguration_Cirque_Diamant.getText().isBlank()
									&& isNumeric(txtFConfiguration_Cirque_Diamant.getText())
									&& !txtFConfiguration_Cirque_Gold.getText().isBlank()
									&& isNumeric(txtFConfiguration_Cirque_Gold.getText())
									&& !txtFConfiguration_Cirque_Silver.getText().isBlank()
									&& isNumeric(txtFConfiguration_Cirque_Silver.getText())
									&& !txtFConfiguration_Cirque_Bronze.getText().isBlank()
									&& isNumeric(txtFConfiguration_Cirque_Bronze.getText())) {
								// Création du show de type Cirque :
								// Création de la liste des catégories
								ArrayList<Category> listCategory = new ArrayList<Category>();

								// Définition du prix de la place
								int price = Integer.parseInt(txtFConfiguration_Cirque_Gold.getText());
								// Ajout des catégories à la liste
								listCategory.add(new Category(CategoryType.CIRQUE_GOLD, price));
								// Définition du prix de la place
								price = Integer.parseInt(txtFConfiguration_Cirque_Silver.getText());
								// Ajout des catégories à la liste
								listCategory.add(new Category(CategoryType.CIRQUE_SILVER, price));

								// Définition du prix de la place
								price = Integer.parseInt(txtFConfiguration_Cirque_Bronze.getText());
								// Ajout des catégories à la liste
								listCategory.add(new Category(CategoryType.CIRQUE_BRONZE, price));

								// Création de la configuration de la salle
								Configuration config = new Configuration(ConfigurationType.CIRQUE, listCategory);
								// Création du spectacle
								Show show = new Show(txtFShow_Title.getText(), selectedArtist,
										(int) spinPerClientMaxSeat.getValue(), config);
								// Sauvegarde du spectacle dans la BDD
								show.create();
								JOptionPane.showMessageDialog(null,
										"Votre pièce de théatre a bien été créée avec ses configurations.");
								// dispose();

							} else
								JOptionPane.showMessageDialog(null, "Veuillez remplir les prix des places !");
						}
					} else
						JOptionPane.showMessageDialog(null, "Aucun artiste n'a été selectionné !");
				} else
					JOptionPane.showMessageDialog(null, "Veuillez entrer un titre !");

			}
		});
	}
}
