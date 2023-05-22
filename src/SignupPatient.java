

import java.awt.EventQueue;
import javax.swing.JOptionPane; 

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class SignupPatient {

	private PCVS pcvs1;
	JFrame frame;
	private JTextField unameTextField;
	private JTextField nameTextField;
	private JTextField emailTextField;
	private JTextField icpTextField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					SignupPatient window = new SignupPatient();
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
	public SignupPatient(PCVS pcvs) {
		pcvs1 = pcvs;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(230, 230, 250));
		frame.setBounds(100, 100, 807, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 807, 600);
		frame.getContentPane().add(layeredPane);
		
		JLabel signupLbl = new JLabel("Sign Up As Patient");
		signupLbl.setHorizontalAlignment(SwingConstants.CENTER);
		layeredPane.setLayer(signupLbl, 1);
		signupLbl.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 22));
		signupLbl.setBounds(307, 41, 205, 48);
		//frame.getContentPane().add(lblNewLabel);
		layeredPane.add(signupLbl);
		
		unameTextField = new JTextField();
		layeredPane.setLayer(unameTextField, 1);
		unameTextField.setHorizontalAlignment(SwingConstants.LEFT);
		unameTextField.setToolTipText("");
		unameTextField.setBounds(289, 164, 235, 33);
		//frame.getContentPane().add(unameTextField);
		layeredPane.add(unameTextField);
		unameTextField.setColumns(10);
		
		JLabel unameLbl = new JLabel("Username");
		layeredPane.setLayer(unameLbl, 1);
		unameLbl.setBounds(289, 141, 68, 13);
		//frame.getContentPane().add(unameLbl);
		layeredPane.add(unameLbl);
		
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
		
		emailTextField = new JTextField();
		layeredPane.setLayer(emailTextField, 1);
		emailTextField.setToolTipText("");
		emailTextField.setHorizontalAlignment(SwingConstants.LEFT);
		emailTextField.setColumns(10);
		emailTextField.setBounds(289, 362, 235, 33);
		//frame.getContentPane().add(emailTextField);
		layeredPane.add(emailTextField);
		
		JLabel icpLbl = new JLabel("ICPassport");
		layeredPane.setLayer(icpLbl, 1);
		icpLbl.setBounds(289, 405, 86, 13);
		//frame.getContentPane().add(icpLbl);
		layeredPane.add(icpLbl);
		
		icpTextField = new JTextField();
		layeredPane.setLayer(icpTextField, 1);
		icpTextField.setToolTipText("");
		icpTextField.setHorizontalAlignment(SwingConstants.LEFT);
		icpTextField.setColumns(10);
		icpTextField.setBounds(289, 428, 235, 33);
		//frame.getContentPane().add(icpTextField);
		layeredPane.add(icpTextField);
		
		JLabel accountLbl = new JLabel("Already have an account?");
		layeredPane.setLayer(accountLbl, 1);
		accountLbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		accountLbl.setBounds(289, 99, 164, 21);
		//frame.getContentPane().add(accountLbl);
		layeredPane.add(accountLbl);
		
		
		JLabel backgroundLbl = new JLabel("");
		backgroundLbl.setIcon(new ImageIcon("C:\\Users\\USER\\eclipse-workspace\\assignment2\\img\\background.jpg"));
		backgroundLbl.setBounds(0, 0, 797, 569);
		layeredPane.add(backgroundLbl);
		
		JButton signupBtn = new JButton("SIGN UP");
		signupBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(unameTextField.getText().isEmpty() || nameTextField.getText().isEmpty() || emailTextField.getText().isEmpty()
						|| icpTextField.getText().isEmpty() || passwordField.getPassword().length == 0) {
					JOptionPane.showMessageDialog(null, "Fill all the blank field correctly !");
				}
				else {
					String uname = unameTextField.getText();
					String password = String.valueOf(passwordField.getPassword());
					String email = emailTextField.getText();
					String name = nameTextField.getText();
					String icPass = icpTextField.getText();
					//creating new patient object based on user input
                    Patient newPatient = new Patient(uname, password, email, name, icPass);
                    //adding the new patient object to the arraylist of patient in pcvs
                    pcvs1.setListOfPatient(newPatient);
                    
                    JOptionPane.showMessageDialog(null, "yay! " + newPatient.getFullName() + ", id: " + newPatient.getFullName());
					LoginPatient goToLogin = new LoginPatient(pcvs1);
					goToLogin.frame.setVisible(true);
					frame.dispose();
				}
			}
		});
		layeredPane.setLayer(signupBtn, 1);
		signupBtn.setForeground(Color.WHITE);
		signupBtn.setFont(new Font("Myriad Hebrew", Font.PLAIN, 16));
		signupBtn.setBackground(new Color(135, 206, 250));
		signupBtn.setBounds(289, 488, 235, 33);
		layeredPane.add(signupBtn);
		
		JLabel loginLbl = new JLabel("Login here");
		layeredPane.setLayer(loginLbl, 1);
		loginLbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LoginPatient goToLogin = new LoginPatient(pcvs1);
				goToLogin.frame.setVisible(true);
				frame.dispose();
			}
		});
		loginLbl.setForeground(Color.BLUE);
		loginLbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		loginLbl.setBounds(458, 99, 287, 21);
		//frame.getContentPane().add(loginLbl);
		layeredPane.add(loginLbl);
		
		passwordField = new JPasswordField();
		layeredPane.setLayer(passwordField, 1);
		passwordField.setBounds(289, 231, 235, 33);
		layeredPane.add(passwordField);
	}
}
