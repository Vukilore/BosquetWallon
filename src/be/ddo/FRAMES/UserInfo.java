package be.ddo.FRAMES;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import be.ddo.POJO.User;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserInfo extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtFirstName;
	private JTextField txtCityAddress;
	private JTextField txtStreetAddress;
	private JTextField txtNumberAddress;
	private JTextField txtPostalCodeAddress;
	private JLabel lblEmail;
	private JTextField txtEmail;
	private JLabel lblTypeofUser;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		/*EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserInfo frame = new UserInfo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	
	public UserInfo(User userInfo, Boolean editable) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 287, 386);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtName = new JTextField();
		txtName.setEnabled(false);
		txtName.setEditable(false);
		txtName.setBounds(87, 38, 179, 20);
		txtName.setText(userInfo.getName());
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		JLabel lblName = new JLabel("Nom :");
		lblName.setBounds(10, 41, 95, 14);
		contentPane.add(lblName);
		
		JLabel lblFirstName = new JLabel("Pr\u00E9nom :");
		lblFirstName.setBounds(10, 72, 95, 14);
		contentPane.add(lblFirstName);
		
		txtFirstName = new JTextField();
		txtFirstName.setEnabled(false);
		txtFirstName.setEditable(false);
		txtFirstName.setColumns(10);
		txtFirstName.setBounds(87, 69, 179, 20);
		txtFirstName.setText(userInfo.getFirstName());
		contentPane.add(txtFirstName);
		
		JLabel lblCityAddress = new JLabel("Ville :");
		lblCityAddress.setBounds(10, 103, 95, 14);
		contentPane.add(lblCityAddress);
		
		txtCityAddress = new JTextField();
		txtCityAddress.setEnabled(false);
		txtCityAddress.setEditable(false);
		txtCityAddress.setColumns(10);
		txtCityAddress.setBounds(87, 100, 179, 20);
		txtCityAddress.setText(userInfo.getCityAddress());
		contentPane.add(txtCityAddress);
		
		JLabel lblStreetAddress = new JLabel("Rue :");
		lblStreetAddress.setBounds(10, 134, 95, 14);
		contentPane.add(lblStreetAddress);
		
		txtStreetAddress = new JTextField();
		txtStreetAddress.setEnabled(false);
		txtStreetAddress.setEditable(false);
		txtStreetAddress.setColumns(10);
		txtStreetAddress.setBounds(87, 131, 179, 20);
		txtStreetAddress.setText(userInfo.getStreetAddress());
		contentPane.add(txtStreetAddress);
		
		JLabel lblNumberAddress = new JLabel("Numero :");
		lblNumberAddress.setBounds(10, 165, 95, 14);
		contentPane.add(lblNumberAddress);
		
		txtNumberAddress = new JTextField();
		txtNumberAddress.setEnabled(false);
		txtNumberAddress.setEditable(false);
		txtNumberAddress.setColumns(10);
		txtNumberAddress.setBounds(87, 162, 179, 20);
		txtNumberAddress.setText(userInfo.getNumberAddress());
		contentPane.add(txtNumberAddress);
		
		JLabel lblPostalCodeAddress = new JLabel("Code postale :");
		lblPostalCodeAddress.setBounds(10, 200, 95, 14);
		contentPane.add(lblPostalCodeAddress);
		
		txtPostalCodeAddress = new JTextField();
		txtPostalCodeAddress.setEnabled(false);
		txtPostalCodeAddress.setEditable(false);
		txtPostalCodeAddress.setColumns(10);
		txtPostalCodeAddress.setBounds(87, 197, 179, 20);
		txtPostalCodeAddress.setText(userInfo.getPostalCodeAddress());
		contentPane.add(txtPostalCodeAddress);
		
		lblEmail = new JLabel("Email :");
		lblEmail.setBounds(10, 11, 95, 14);
		contentPane.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setEditable(false);
		txtEmail.setEnabled(false);
		txtEmail.setColumns(10);
		txtEmail.setBounds(87, 8, 179, 20);
		txtEmail.setText(userInfo.getEmail());
		contentPane.add(txtEmail);
		
		String userType = null;
		switch(userInfo.getClass().getSimpleName())
		{
			case "Organizer" : userType = "Organisateur";
			case "Client" : userType = "Client";
		}
		lblTypeofUser = new JLabel(userType);
		lblTypeofUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblTypeofUser.setFont(new Font("Sylfaen", Font.BOLD, 23));
		lblTypeofUser.setBounds(60, 243, 132, 42);
		contentPane.add(lblTypeofUser);
		
		JButton btnValidate = new JButton("Valider");
		btnValidate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnValidate.setBounds(35, 305, 89, 23);
		contentPane.add(btnValidate);
		
		JButton btnEdit = new JButton("Editer");
		btnEdit.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(editable == true) {
					txtName.setEnabled(!txtName.isEnabled());
					txtName.setEditable(!txtName.isEditable());
					txtFirstName.setEnabled(!txtFirstName.isEnabled());
					txtFirstName.setEditable(!txtFirstName.isEditable());
					txtEmail.setEnabled(!txtEmail.isEnabled());
					txtEmail.setEditable(!txtEmail.isEditable());
					txtCityAddress.setEnabled(!txtCityAddress.isEnabled());
					txtCityAddress.setEditable(!txtCityAddress.isEditable());
					txtStreetAddress.setEnabled(!txtStreetAddress.isEnabled());
					txtStreetAddress.setEditable(!txtStreetAddress.isEditable());
					txtNumberAddress.setEnabled(!txtNumberAddress.isEnabled());
					txtNumberAddress.setEditable(!txtNumberAddress.isEditable());
					txtPostalCodeAddress.setEnabled(!txtPostalCodeAddress.isEnabled());
					txtPostalCodeAddress.setEditable(!txtPostalCodeAddress.isEditable());
				}
		}
		});
		btnEdit.setEnabled(editable);
		btnEdit.setIcon(new ImageIcon(UserInfo.class.getResource("/be/ddo/FRAMES/res/image/edit.png")));
		btnEdit.setBounds(153, 305, 89, 23);
		contentPane.add(btnEdit);
	}
}
