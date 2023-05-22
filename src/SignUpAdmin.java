
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPasswordField;

public class SignUpAdmin {

	private PCVS pcvs1;
	JFrame frame;
	private JTextField unameTextField;
	private JTextField nameTextField;
	private JTextField emailTextField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//	PCVS pcvs1 = new PCVS();
//	
//		
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					SignUpAdmin window = new SignUpAdmin(pcvs1);
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public SignUpAdmin(PCVS pcvs) {
		initialize();
		pcvs1 = pcvs;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(230, 230, 250));
		frame.getContentPane().setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 807, 600);
		frame.getContentPane().add(layeredPane);
		
		JLabel signupLabel = new JLabel("Sign Up As Healthcare Administrator");
		layeredPane.setLayer(signupLabel, 1);
		signupLabel.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 17));
		signupLabel.setBounds(289, 41, 235, 48);
		//frame.getContentPane().add(lblNewLabel);
		layeredPane.add(signupLabel);
		
		JLabel accountLbl = new JLabel("Already have an account?");
		layeredPane.setLayer(accountLbl, 1);
		accountLbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		accountLbl.setBounds(289, 99, 164, 21);
		//frame.getContentPane().add(accountLbl);
		layeredPane.add(accountLbl);
		
		JLabel usernameLbl = new JLabel("Username");
		layeredPane.setLayer(usernameLbl, 1);
		usernameLbl.setBounds(289, 141, 76, 13);
		//frame.getContentPane().add(usernameLbl);
		layeredPane.add(usernameLbl);
		
		unameTextField = new JTextField();
		layeredPane.setLayer(unameTextField, 1);
		unameTextField.setToolTipText("");
		unameTextField.setHorizontalAlignment(SwingConstants.LEFT);
		unameTextField.setColumns(10);
		unameTextField.setBounds(289, 164, 235, 33);
		//frame.getContentPane().add(unameTextField);
		layeredPane.add(unameTextField);
		
		JLabel passLbl = new JLabel("Password");
		layeredPane.setLayer(passLbl, 1);
		passLbl.setBounds(289, 207, 56, 13);
		//frame.getContentPane().add(passLbl);
		layeredPane.add(passLbl);
		
		JLabel nameLbl = new JLabel("Full Name");
		layeredPane.setLayer(nameLbl, 1);
		nameLbl.setBounds(289, 273, 56, 13);
		//frame.getContentPane().add(nameLbl);
		layeredPane.add(nameLbl);
		
		nameTextField = new JTextField();
		layeredPane.setLayer(nameTextField, 1);
		nameTextField.setToolTipText("");
		nameTextField.setHorizontalAlignment(SwingConstants.LEFT);
		nameTextField.setColumns(10);
		nameTextField.setBounds(289, 296, 235, 33);
		//frame.getContentPane().add(nameTextField);
		layeredPane.add(nameTextField);
		
		JLabel emailLbl = new JLabel("Email");
		layeredPane.setLayer(emailLbl, 1);
		emailLbl.setBounds(289, 339, 56, 13);
		//frame.getContentPane().add(emailLbl);
		layeredPane.add(emailLbl);
		
		String[] listHealthcare = {" ", "Udayana University Hospital", "Bali Royal Hospital", "Surya Husada Hospital"};
		JComboBox hcComboBox = new JComboBox(listHealthcare);
		layeredPane.setLayer(hcComboBox, 1);
		hcComboBox.setBounds(289, 428, 235, 21);
		//frame.getContentPane().add(hcComboBox);
		layeredPane.add(hcComboBox);
		
		emailTextField = new JTextField();
		layeredPane.setLayer(emailTextField, 1);
		emailTextField.setToolTipText("");
		emailTextField.setHorizontalAlignment(SwingConstants.LEFT);
		emailTextField.setColumns(10);
		emailTextField.setBounds(289, 362, 235, 33);
		//frame.getContentPane().add(emailTextField);
		layeredPane.add(emailTextField);
		
		JLabel hcLbl = new JLabel("Healthcare Choice");
		layeredPane.setLayer(hcLbl, 1);
		hcLbl.setBounds(289, 405, 149, 13);
		//frame.getContentPane().add(hcLbl);
		layeredPane.add(hcLbl);
		
		
		JLabel loginLbl = new JLabel("Login here");
		layeredPane.setLayer(loginLbl, 1);
		loginLbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				LoginAdministrator goToLogin = new LoginAdministrator(pcvs1);
				goToLogin.frame.setVisible(true);
				frame.dispose();
			}
		});
		loginLbl.setForeground(new Color(0, 0, 255));
		loginLbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		loginLbl.setBounds(458, 99, 287, 21);
		//frame.getContentPane().add(loginLbl);
		layeredPane.add(loginLbl);
		frame.setBounds(100, 100, 807, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel backgroundLbl = new JLabel("");
		backgroundLbl.setIcon(new ImageIcon("C:\\Users\\USER\\eclipse-workspace\\assignment2\\img\\background.jpg"));
		backgroundLbl.setBounds(0, 0, 797, 569);
		layeredPane.add(backgroundLbl);
		
		passwordField = new JPasswordField();
		layeredPane.setLayer(passwordField, 1);
		passwordField.setBounds(289, 230, 235, 33);
		layeredPane.add(passwordField);
		
		JButton signupBtn = new JButton("SIGN UP");
		signupBtn.addMouseListener(new MouseAdapter() {
			@Override
			
			public void mouseClicked(MouseEvent e) {
				if(unameTextField.getText().isEmpty() || nameTextField.getText().isEmpty() || emailTextField.getText().isEmpty()
						 || passwordField.getPassword().length == 0 ) {
					JOptionPane.showMessageDialog(null, "Fill all the blank field correctly !");
				}
				else {
					if(hcComboBox.getSelectedIndex() == 0) {
						JOptionPane.showMessageDialog(null, "Select the healthcare !");
					}
					else {
						String uname = unameTextField.getText();
						String password = String.valueOf(passwordField.getPassword());
						String email = emailTextField.getText();
						String name = nameTextField.getText();
						String randStaffID = pcvs1.randomStaffID();
                        //a new administrator object created based on user input
                        Administrator newAdmin = new Administrator(uname, password, email, name, randStaffID);
                        pcvs1.getListOfCentreIdx(hcComboBox.getSelectedIndex() - 1).setNewAdmin(newAdmin);
                        pcvs1.setListOfAdministrator(newAdmin);
                        
						JOptionPane.showMessageDialog(null, "yay! " + newAdmin.getFullName() + ", id: " + newAdmin.getStaffID());
						
						LoginAdministrator goToLogin = new LoginAdministrator(pcvs1);
						goToLogin.frame.setVisible(true);
						frame.dispose();
					}
				}
			}
		});
		layeredPane.setLayer(signupBtn, 1);
		signupBtn.setForeground(new Color(255, 255, 255));
		signupBtn.setBackground(new Color(135, 206, 250));
		signupBtn.setFont(new Font("Myriad Hebrew", Font.PLAIN, 16));
		signupBtn.setBounds(289, 475, 235, 33);
		//frame.getContentPane().add(signupBtn);
		layeredPane.add(signupBtn);
	}
}
