

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuPatient {

	private PCVS pcvs1;
	String username;
	String password;
	JFrame frame;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					MenuPatient window = new MenuPatient();
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
	public MenuPatient(PCVS pcvs, String uname, String pass) {
		username = uname;
		pcvs1 = pcvs;
		password = pass;
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
		layeredPane.setLayout(null);
		layeredPane.setBounds(0, 0, 807, 600);
		frame.getContentPane().add(layeredPane);
		
		JLabel backgroundLbl = new JLabel("");
		backgroundLbl.setIcon(new ImageIcon("C:\\Users\\USER\\eclipse-workspace\\assignment2\\img\\background.jpg"));
		backgroundLbl.setBounds(0, 0, 797, 569);
		layeredPane.add(backgroundLbl);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\USER\\Downloads\\covid-vaccine-icon (1).png"));
		layeredPane.setLayer(lblNewLabel_1, 1);
		lblNewLabel_1.setBackground(Color.PINK);
		lblNewLabel_1.setBounds(25, 200, 216, 185);
		layeredPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\USER\\Downloads\\medical-record-1800529-1529261 (1).png"));
		layeredPane.setLayer(lblNewLabel_2, 1);
		lblNewLabel_2.setBackground(Color.PINK);
		lblNewLabel_2.setBounds(292, 200, 216, 175);
		layeredPane.add(lblNewLabel_2);
		
		JButton btnViewVaccineBatch = new JButton("Request Vaccination Appointment");
		btnViewVaccineBatch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, password);
				ReqVacAppointment goToReqVac = new ReqVacAppointment(pcvs1, username, password);
				goToReqVac.frame.setVisible(true);
				frame.dispose();
			}
		});
		layeredPane.setLayer(btnViewVaccineBatch, 1);
		btnViewVaccineBatch.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnViewVaccineBatch.setBounds(25, 385, 216, 30);
		layeredPane.add(btnViewVaccineBatch);
		
		JButton btnConfirmVaccinationAppointment = new JButton("View Vaccination Appointment");
		layeredPane.setLayer(btnConfirmVaccinationAppointment, 1);
		btnConfirmVaccinationAppointment.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnConfirmVaccinationAppointment.setBounds(292, 385, 216, 30);
		layeredPane.add(btnConfirmVaccinationAppointment);
		
		JTextArea welcomeTextArea = new JTextArea();
		welcomeTextArea.setText("Welcome, " + pcvs1.displayPatientFName(username));
		layeredPane.setLayer(welcomeTextArea, 1);
		welcomeTextArea.setBounds(10, 10, 247, 82);
		layeredPane.add(welcomeTextArea);
		
		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setIcon(new ImageIcon("C:\\Users\\USER\\eclipse-workspace\\assignment2\\img\\logout pic.png"));
		layeredPane.setLayer(lblNewLabel_2_1, 1);
		lblNewLabel_2_1.setBackground(Color.PINK);
		lblNewLabel_2_1.setBounds(554, 200, 215, 175);
		layeredPane.add(lblNewLabel_2_1);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PCVSGUI goToHome = new PCVSGUI(pcvs1);
				goToHome.frame.setVisible(true);
				frame.dispose();
			}
		});
		layeredPane.setLayer(btnLogOut, 1);
		btnLogOut.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnLogOut.setBounds(554, 384, 216, 31);
		layeredPane.add(btnLogOut);
	}
}
