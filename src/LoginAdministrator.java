

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginAdministrator {

	private PCVS pcvs1;
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
//					LoginAdministrator window = new LoginAdministrator();
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
	public LoginAdministrator(PCVS pcvs) {
		pcvs1 = pcvs;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 807, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 807, 600);
		frame.getContentPane().add(layeredPane);
		
		JLabel lblLoginAsAdministrator = new JLabel("Login As Administrator");
		lblLoginAsAdministrator.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoginAsAdministrator.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 22));
		lblLoginAsAdministrator.setBounds(311, 78, 196, 48);
		layeredPane.add(lblLoginAsAdministrator);
		
		JLabel unameLbl = new JLabel("Username");
		unameLbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		unameLbl.setBounds(306, 167, 84, 28);
		layeredPane.add(unameLbl);
		
		unameTextField = new JTextField();
		unameTextField.setToolTipText("");
		unameTextField.setHorizontalAlignment(SwingConstants.LEFT);
		unameTextField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		unameTextField.setColumns(10);
		unameTextField.setBounds(306, 194, 201, 37);
		layeredPane.add(unameTextField);
		
		JLabel passLbl = new JLabel("Password");
		passLbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		passLbl.setBounds(306, 260, 84, 28);
		layeredPane.add(passLbl);
		
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
					if(pcvs1.checkAdminLogin(uname, password)) {
						MenuAdmin goToMenu = new MenuAdmin(pcvs1, uname);
						goToMenu.frame.setVisible(true);
						frame.dispose();
					}
					else {
						JOptionPane.showMessageDialog(null, "Account not found!");
					}
				}
			}
		});
		loginBtn.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 16));
		loginBtn.setBackground(new Color(135, 206, 250));
		loginBtn.setBounds(306, 389, 201, 48);
		layeredPane.add(loginBtn);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(306, 291, 201, 37);
		layeredPane.add(passwordField);
		
		JLabel backgroundLbl = new JLabel("");
		backgroundLbl.setIcon(new ImageIcon("C:\\Users\\USER\\eclipse-workspace\\assignment2\\img\\background.jpg"));
		backgroundLbl.setBounds(0, 0, 797, 569);
		frame.getContentPane().add(backgroundLbl);
	}
}
