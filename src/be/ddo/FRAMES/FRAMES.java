package be.ddo.FRAMES;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import be.ddo.DAO.AbstractDAOFactory;
import be.ddo.DAO.BosquetConnection;
import be.ddo.DAO.DAO;
import be.ddo.DAO.UserDAO;
import be.ddo.POJO.Artist;
import be.ddo.POJO.Client;
import be.ddo.POJO.Manager;
import be.ddo.POJO.Organizer;
import be.ddo.POJO.RoomPlanning;
import be.ddo.POJO.Show;
import be.ddo.POJO.User;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class FRAMES extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtFLogin_Email;
	private JPasswordField txtFLogin_Password;
	private JTextField txtFSignin_Name;
	private JTextField txtFSignin_FirstName;
	private JTextField txtFSignin_CityAddress;
	private JTextField txtFSignin_StreetAddress;
	private JTextField txtFSignin_PostalCodeAddress;
	private JTextField txtFSignin_NumberAddress;
	private JTextField txtFSignin_Email;
	private JTextField txtFSignin_Password;
	private JTextField txtFSignin_Confirm;
	
	private User mainUser;

	public FRAMES() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 548, 543);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// ===================================================================================
		// JFrame : PANEL_ORGANIZER
		// ===================================================================================

		JPanel panel_Organizer = new JPanel();
		panel_Organizer.setLayout(null);
		panel_Organizer.setBounds(239, 0, 303, 514);
		contentPane.add(panel_Organizer);

		JLabel lblOrganizer_Name = new JLabel("Bonjour organisateur");
		lblOrganizer_Name.setHorizontalAlignment(SwingConstants.CENTER);
		lblOrganizer_Name.setFont(new Font("Trebuchet MS", Font.PLAIN, 26));
		lblOrganizer_Name.setBounds(10, 26, 283, 31);
		panel_Organizer.add(lblOrganizer_Name);

		JLabel lblOrganizer_CreateEvent = new JLabel("Cr\u00E9er un \u00E9venement");
		lblOrganizer_CreateEvent.setFont(new Font("Trebuchet MS", Font.PLAIN, 24));
		lblOrganizer_CreateEvent.setIcon(new ImageIcon(FRAMES.class.getResource("/be/ddo/FRAMES/res/image/event.png")));
		lblOrganizer_CreateEvent.setBounds(10, 237, 283, 36);
		panel_Organizer.add(lblOrganizer_CreateEvent);

		JLabel lblOrganizer_ListEvent = new JLabel("Evenements pr\u00E9vus");
		lblOrganizer_ListEvent
				.setIcon(new ImageIcon(FRAMES.class.getResource("/be/ddo/FRAMES/res/image/listEvent.png")));
		lblOrganizer_ListEvent.setFont(new Font("Trebuchet MS", Font.PLAIN, 24));
		lblOrganizer_ListEvent.setBounds(10, 298, 283, 36);
		panel_Organizer.add(lblOrganizer_ListEvent);

		JLabel lblOrganizer_CreateShow = new JLabel("Cr\u00E9er un spectacle");
		lblOrganizer_CreateShow
				.setIcon(new ImageIcon(FRAMES.class.getResource("/be/ddo/FRAMES/res/image/theater.png")));
		lblOrganizer_CreateShow.setFont(new Font("Trebuchet MS", Font.PLAIN, 24));
		lblOrganizer_CreateShow.setBounds(10, 184, 283, 36);
		panel_Organizer.add(lblOrganizer_CreateShow);
		panel_Organizer.setVisible(false);

		// ===================================================================================
		// JFrame : PANEL_FRAME
		// ===================================================================================

		JPanel panel_Frame = new JPanel();
		panel_Frame.setBorder(UIManager.getBorder("DesktopIcon.border"));
		panel_Frame.setBackground(Color.DARK_GRAY);
		panel_Frame.setBounds(0, 0, 240, 514);
		contentPane.add(panel_Frame);
		panel_Frame.setLayout(null);

		JLabel lblLogin = new JLabel("Connexion ");
		lblLogin.setForeground(Color.WHITE);
		lblLogin.setVerticalAlignment(SwingConstants.TOP);
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setFont(new Font("Modern No. 20", Font.BOLD, 28));
		lblLogin.setBounds(20, 291, 200, 39);
		panel_Frame.add(lblLogin);

		JLabel lblLogo = new JLabel("");
		lblLogo.setToolTipText("Vous n'\u00EAtes pas encore connect\u00E9");
		lblLogo.setBounds(20, 31, 200, 200);
		lblLogo.setEnabled(false);
		lblLogo.setIcon(new ImageIcon(FRAMES.class.getResource("/be/ddo/FRAMES/res/image/logo.png")));
		panel_Frame.add(lblLogo);

		JLabel lblSignin = new JLabel("Inscription");
		lblSignin.setVerticalAlignment(SwingConstants.TOP);
		lblSignin.setHorizontalAlignment(SwingConstants.CENTER);
		lblSignin.setForeground(Color.WHITE);
		lblSignin.setFont(new Font("Modern No. 20", Font.BOLD, 28));
		lblSignin.setBounds(20, 362, 200, 39);
		panel_Frame.add(lblSignin);
		lblSignin.setEnabled(false);

		JButton btnDisconnect = new JButton("D\u00E9connexion");
		btnDisconnect.setBounds(111, 480, 119, 23);
		btnDisconnect.setVisible(false);
		panel_Frame.add(btnDisconnect);

		// ===================================================================================
		// JFrame : PANEL_CLIENT
		// ===================================================================================
		JPanel panel_Client = new JPanel();
		panel_Client.setBounds(239, 0, 303, 514);
		contentPane.add(panel_Client);
		panel_Client.setLayout(null);

		JLabel lblClient_Name = new JLabel("Bonjour client");
		lblClient_Name.setHorizontalAlignment(SwingConstants.CENTER);
		lblClient_Name.setFont(new Font("Trebuchet MS", Font.PLAIN, 26));
		lblClient_Name.setBounds(10, 26, 283, 31);
		panel_Client.add(lblClient_Name);

		JLabel lblClient_Booking = new JLabel("    R\u00E9server une place");
		lblClient_Booking.setToolTipText("R\u00E9server une pi\u00E8ce de th\u00E9atre");
		lblClient_Booking.setFont(new Font("Stencil", Font.PLAIN, 18));
		lblClient_Booking.setIcon(new ImageIcon(FRAMES.class.getResource("/be/ddo/FRAMES/res/image/ticket.png")));
		lblClient_Booking.setBounds(10, 224, 267, 31);
		panel_Client.add(lblClient_Booking);

		// ===================================================================================
		// JFrame : PANEL_LOGIN
		// ===================================================================================

		JPanel panel_Login = new JPanel();
		panel_Login.setBounds(239, 0, 303, 514);
		contentPane.add(panel_Login);
		panel_Login.setLayout(null);

		txtFLogin_Email = new JTextField();
		txtFLogin_Email.setHorizontalAlignment(SwingConstants.CENTER);
		txtFLogin_Email.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtFLogin_Email.setText("exemple@email.com");
		txtFLogin_Email.setBounds(31, 195, 240, 38);
		panel_Login.add(txtFLogin_Email);
		txtFLogin_Email.setColumns(10);

		txtFLogin_Password = new JPasswordField();
		txtFLogin_Password.setText("exemple@email.com");
		txtFLogin_Password.setHorizontalAlignment(SwingConstants.CENTER);
		txtFLogin_Password.setColumns(10);
		txtFLogin_Password.setBounds(31, 280, 240, 38);
		panel_Login.add(txtFLogin_Password);

		JLabel lblLogin_Email = new JLabel("Adresse Email :");
		lblLogin_Email.setBounds(33, 171, 122, 14);
		panel_Login.add(lblLogin_Email);

		JLabel lblLogin_Password = new JLabel("Mot de passe :");
		lblLogin_Password.setBounds(31, 260, 85, 14);
		panel_Login.add(lblLogin_Password);

		JButton btnLogin_Login = new JButton("Connexion");
		btnLogin_Login.setBounds(103, 348, 108, 23);
		panel_Login.add(btnLogin_Login);

		// ===================================================================================
		// JFrame : PANEL_SIGNIN
		// ===================================================================================

		JPanel panel_SignIn = new JPanel();
		panel_SignIn.setLayout(null);
		panel_SignIn.setBounds(239, 0, 303, 514);
		contentPane.add(panel_SignIn);

		JLabel lblSignin_Name = new JLabel("Nom :");
		lblSignin_Name.setBounds(10, 44, 86, 14);
		panel_SignIn.add(lblSignin_Name);

		txtFSignin_Name = new JTextField();
		txtFSignin_Name.setBounds(10, 58, 86, 20);
		panel_SignIn.add(txtFSignin_Name);
		txtFSignin_Name.setColumns(10);

		txtFSignin_FirstName = new JTextField();
		txtFSignin_FirstName.setColumns(10);
		txtFSignin_FirstName.setBounds(160, 58, 86, 20);
		panel_SignIn.add(txtFSignin_FirstName);

		JLabel lblSignin_FirstName = new JLabel("Pr\u00E9nom :");
		lblSignin_FirstName.setBounds(160, 44, 125, 14);
		panel_SignIn.add(lblSignin_FirstName);

		txtFSignin_CityAddress = new JTextField();
		txtFSignin_CityAddress.setColumns(10);
		txtFSignin_CityAddress.setBounds(10, 123, 86, 20);
		panel_SignIn.add(txtFSignin_CityAddress);

		JLabel lblSignin_CityAddress = new JLabel("Ville :");
		lblSignin_CityAddress.setBounds(10, 108, 86, 14);
		panel_SignIn.add(lblSignin_CityAddress);

		txtFSignin_StreetAddress = new JTextField();
		txtFSignin_StreetAddress.setColumns(10);
		txtFSignin_StreetAddress.setBounds(160, 123, 86, 20);
		panel_SignIn.add(txtFSignin_StreetAddress);

		JLabel lblSignin_StreetAddress = new JLabel("Rue :");
		lblSignin_StreetAddress.setBounds(160, 108, 86, 14);
		panel_SignIn.add(lblSignin_StreetAddress);

		txtFSignin_PostalCodeAddress = new JTextField();
		txtFSignin_PostalCodeAddress.setColumns(10);
		txtFSignin_PostalCodeAddress.setBounds(10, 193, 86, 20);
		panel_SignIn.add(txtFSignin_PostalCodeAddress);

		JLabel lblSignin_PostalCodeAddress = new JLabel("Code postal :");
		lblSignin_PostalCodeAddress.setBounds(10, 179, 86, 14);
		panel_SignIn.add(lblSignin_PostalCodeAddress);

		JLabel lblSignin_NumberAddress = new JLabel("Numero :");
		lblSignin_NumberAddress.setBounds(160, 179, 86, 14);
		panel_SignIn.add(lblSignin_NumberAddress);

		txtFSignin_NumberAddress = new JTextField();
		txtFSignin_NumberAddress.setColumns(10);
		txtFSignin_NumberAddress.setBounds(160, 193, 86, 20);
		panel_SignIn.add(txtFSignin_NumberAddress);

		txtFSignin_Email = new JTextField();
		txtFSignin_Email.setColumns(10);
		txtFSignin_Email.setBounds(50, 322, 163, 20);
		panel_SignIn.add(txtFSignin_Email);

		JLabel lblSignin_Email = new JLabel("Adresse Email :");
		lblSignin_Email.setBounds(50, 306, 163, 14);
		panel_SignIn.add(lblSignin_Email);

		txtFSignin_Password = new JTextField();
		txtFSignin_Password.setColumns(10);
		txtFSignin_Password.setBounds(31, 371, 86, 20);
		panel_SignIn.add(txtFSignin_Password);

		JLabel lblSignin_Password = new JLabel("Mot de passe :");
		lblSignin_Password.setBounds(31, 353, 86, 14);
		panel_SignIn.add(lblSignin_Password);

		txtFSignin_Confirm = new JTextField();
		txtFSignin_Confirm.setColumns(10);
		txtFSignin_Confirm.setBounds(160, 371, 86, 20);
		panel_SignIn.add(txtFSignin_Confirm);

		JLabel lblSignin_Confirm = new JLabel("Confirmation :");
		lblSignin_Confirm.setBounds(160, 353, 86, 14);
		panel_SignIn.add(lblSignin_Confirm);

		JComboBox cbBoxSignin_Type = new JComboBox();
		cbBoxSignin_Type.setModel(new DefaultComboBoxModel(new String[] { "Client", "Artiste", "Organisateur" }));
		cbBoxSignin_Type.setBounds(10, 273, 133, 22);
		panel_SignIn.add(cbBoxSignin_Type);

		JLabel lblNewLabel = new JLabel("S'enregistrer en tant que :");
		lblNewLabel.setBounds(10, 256, 163, 14);
		panel_SignIn.add(lblNewLabel);

		JButton btnSignin = new JButton("Inscription");
		btnSignin.setBounds(84, 440, 116, 23);
		panel_SignIn.add(btnSignin);

		panel_SignIn.setVisible(false);
		panel_Client.setVisible(false);
		panel_Organizer.setVisible(false);
		panel_Login.setVisible(true);

		//
		//
		//

		// =================================================================================
		// Bouton liste spectacle
		// =================================================================================
		lblOrganizer_ListEvent.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblOrganizer_ListEvent.setFont(new Font("Trebuchet MS", Font.PLAIN, 26));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblOrganizer_ListEvent.setFont(new Font("Trebuchet MS", Font.PLAIN, 24));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO: List show
			}
		});

		// =================================================================================
		// Bouton créer spectacle
		// =================================================================================
		lblOrganizer_CreateShow.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblOrganizer_CreateShow.setFont(new Font("Trebuchet MS", Font.PLAIN, 26));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblOrganizer_CreateShow.setFont(new Font("Trebuchet MS", Font.PLAIN, 24));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				ArrayList<Artist> listOfArtist = Artist.getAll();
				if (listOfArtist.size() > 0) {
					CreateShow cs = new CreateShow(listOfArtist);
					cs.setVisible(true);
				} else
					JOptionPane.showMessageDialog(null, "Aucun artiste n'est inscrit dans votre base de données !");

			}
		});

		// =================================================================================
		// Bouton créer evenement
		// =================================================================================
		lblOrganizer_CreateEvent.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblOrganizer_CreateEvent.setFont(new Font("Trebuchet MS", Font.PLAIN, 26));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblOrganizer_CreateEvent.setFont(new Font("Trebuchet MS", Font.PLAIN, 24));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				ArrayList<Show> listShow = new ArrayList<Show>();
				listShow.addAll(Show.getAll());
				if(listShow.size() > 0)
				{
					ArrayList<RoomPlanning> listPlanning = new ArrayList<RoomPlanning>();
					listPlanning.addAll(RoomPlanning.getAll());
					
					CreatePlanning cp = new CreatePlanning((Organizer)mainUser, listShow, listPlanning);
					cp.setVisible(true);
				}
				else JOptionPane.showMessageDialog(null, "Aucun spectacle n'est inscrit dans votre base de données !");
				
			}
		});

		// =================================================================================
		// Bouton déconnexion
		// =================================================================================
		btnDisconnect.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				panel_SignIn.setVisible(false);
				panel_Client.setVisible(false);
				panel_Organizer.setVisible(false);
				panel_Login.setVisible(true);
				lblLogo.setToolTipText("Vous n'\u00EAtes pas encore connect\u00E9");
				lblLogo.setEnabled(false);
				lblSignin.setVisible(true);
				lblLogin.setVisible(true);
				btnDisconnect.setVisible(false);
			}
		});

		// =================================================================================
		// Bouton Login
		// =================================================================================
		btnLogin_Login.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				// Vérification si l'email existe dans la BDD
				User user = User.find(txtFLogin_Email.getText());
				// Si l'utilisateur existe
				if (user != null) {
					// Si le mot de passe entré correspond à celui de l'utilisateur
					if (user.getPassword().equals(new String(txtFLogin_Password.getPassword()))) {

						// Affichage du GUI
						lblLogo.setEnabled(true);
						lblSignin.setVisible(false);
						lblLogin.setVisible(false);
						btnDisconnect.setVisible(true);
						lblLogo.setToolTipText("Bonjour " + user.getFirstName());

						// Selon le type d'utilisateur
						switch (user.getClass().getSimpleName()) {
						case "Organizer":
							panel_Client.setVisible(false);
							panel_Organizer.setVisible(true);
							panel_Login.setVisible(false);
							mainUser = new Organizer(user);
							break;

						case "Client":
							panel_Client.setVisible(true);
							panel_Organizer.setVisible(false);
							panel_Login.setVisible(false);
							mainUser = new Client(user);
							break;

						case "Artist":
							panel_Client.setVisible(false);
							panel_Organizer.setVisible(false);
							panel_Login.setVisible(false);
							mainUser = new Artist(user);
							break;

						case "Manager":
							panel_Client.setVisible(false);
							panel_Organizer.setVisible(true);
							panel_Login.setVisible(false);
							mainUser = new Manager(user);
							break;
						default:
							JOptionPane.showMessageDialog(null, "Erreur classe :" + user.getClass().getSimpleName());
							break;
						}
					} else
						JOptionPane.showMessageDialog(null, "Mot de passe incorrecte !");
				} else
					JOptionPane.showMessageDialog(null, "Cet utilisateur n'existe pas.");
			}
		});

		// =================================================================================
		// Bouton Inscription
		// =================================================================================
		btnSignin.addActionListener(new ActionListener() {
			// Lorsqu'on appuie sur le bouton inscription
			public void actionPerformed(ActionEvent e) {
				// Vérification du mot de passe
				if (txtFSignin_Password.getText().equals(txtFSignin_Confirm.getText())) {
					// Création de l'utilisateur temporaire
					User tmpUser = new User(txtFSignin_Name.getText(), txtFSignin_FirstName.getText(),
							txtFSignin_Email.getText(), txtFSignin_Password.getText(), txtFSignin_CityAddress.getText(),
							txtFSignin_StreetAddress.getText(), txtFSignin_NumberAddress.getText(),
							txtFSignin_PostalCodeAddress.getText());
					if (!tmpUser.blankfField()) {
						if (tmpUser.isValidEmail()) {
							if (User.find(txtFSignin_Email.getText().toString()) == null) {
								// Création de l'utilisateur final
								User finalUser = null;
								// Selon le type d'utilisateur choisis
								switch (cbBoxSignin_Type.getSelectedItem().toString()) {
								case "Organisateur":
									finalUser = new Organizer(tmpUser);
									break;
								case "Client":
									finalUser = new Client(tmpUser);
									break;
								case "Artiste":
									finalUser = new Artist(tmpUser);
									break;
								default:
									JOptionPane.showMessageDialog(null, "ERREUR INNATENDUE CHOIX DE L USER NON DEFINI");
									break;
								}
								// Si finalUser est bien typé on l'inscrit
								if (finalUser != null) {
									finalUser.create();
									UserInfo userInfo = new UserInfo(finalUser, true);
									userInfo.setVisible(true);
								} else
									JOptionPane.showMessageDialog(null, "ERREUR INNATENDUE : USER NON TYPE");

							} else
								JOptionPane.showMessageDialog(null, "Cette addresse email est déjà enregistrée !");

						} else
							JOptionPane.showMessageDialog(null, "L'adresse email fournie n'est pas valide.");
					} else
						JOptionPane.showMessageDialog(null, "Tous les champs doivent être remplis.");
				} else
					JOptionPane.showMessageDialog(null, "Les mots de passe doivent être identique");
			}
		});

		// =================================================================================
		// Bouton réservation de ticket
		// =================================================================================
		lblClient_Booking.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				ChooseShow cs = new ChooseShow((Client) mainUser, Show.getAll());
				cs.setVisible(true);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblClient_Booking.setFont(new Font("Stencil", Font.PLAIN, 20));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblClient_Booking.setFont(new Font("Stencil", Font.PLAIN, 18));
			}
		});

		// =================================================================================
		// Label Inscription
		// =================================================================================
		lblSignin.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				panel_Login.setVisible(false);
				lblLogin.setEnabled(false);
				panel_SignIn.setVisible(true);
				lblSignin.setEnabled(true);
			}
		});

		// =================================================================================
		// Label Connexion
		// =================================================================================
		lblLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				panel_SignIn.setVisible(false);
				lblSignin.setEnabled(false);
				panel_Login.setVisible(true);
				lblLogin.setEnabled(true);
			}
		});
	}
}
