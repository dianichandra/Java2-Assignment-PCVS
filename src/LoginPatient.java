

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginPatient {

	private PCVS pcvs1;
	//JFrame loginFrame;
	JFrame frame;
	private JTextField unameTextField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					LoginPatient window = new LoginPatient();
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
	public LoginPatient(PCVS pcvs) {
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
		
		JLabel titleLbl = new JLabel("Login As Patient");
		titleLbl.setHorizontalAlignment(SwingConstants.CENTER);
		titleLbl.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 23));
		titleLbl.setBounds(316, 74, 173, 48);
		//frame.getContentPane().add(lblLoginAsPatient);
		layeredPane.add(titleLbl);
		
		JLabel unameLbl = new JLabel("Username");
		unameLbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		unameLbl.setBounds(302, 168, 84, 28);
		//frame.getContentPane().add(unameLbl);
		layeredPane.add(unameLbl);
		
		unameTextField = new JTextField();
		unameTextField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		unameTextField.setToolTipText("");
		unameTextField.setHorizontalAlignment(SwingConstants.LEFT);
		unameTextField.setColumns(10);
		unameTextField.setBounds(302, 195, 201, 37);
		//frame.getContentPane().add(unameTextField);
		layeredPane.add(unameTextField);
		
		JLabel passLbl = new JLabel("Password");
		passLbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		passLbl.setBounds(302, 264, 84, 28);
		//frame.getContentPane().add(passLbl);
		layeredPane.add(passLbl);
		
		passwordField = new JPasswordField();
		layeredPane.setLayer(passwordField, 1);
		passwordField.setBounds(302, 293, 201, 37);
		layeredPane.add(passwordField);
		
		JButton loginBtn = new JButton("LOG IN");
		loginBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(unameTextField.getText().isEmpty() || passwordField.getPassword().length == 0) {
					JOptionPane.showMessageDialog(null, "Fill all the blank field!");
				}
				else {
					String uname = unameTextField.getText();
					String password = String.valueOf(passwordField.getPassword());
					if(pcvs1.checkPatientLogin(uname, password)) {
						MenuPatient goToMenu = new MenuPatient(pcvs1, uname, password);
						goToMenu.frame.setVisible(true);
						frame.dispose();
					}
					else {
						JOptionPane.showMessageDialog(null, "Account not found!");
					}
				}
			}
			
		});
		loginBtn.setBackground(new Color(135, 206, 250));
		loginBtn.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 16));
		loginBtn.setBounds(302, 389, 201, 48);
		//frame.getContentPane().add(loginBtn);
		layeredPane.add(loginBtn);
		
		JLabel backgroundLbl = new JLabel("");
		backgroundLbl.setIcon(new ImageIcon("C:\\Users\\USER\\eclipse-workspace\\assignment2\\img\\background.jpg"));
		backgroundLbl.setBounds(0, 0, 797, 569);
		layeredPane.add(backgroundLbl);
		
		
	}

}
