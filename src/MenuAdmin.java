

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextArea;

public class MenuAdmin {

	private PCVS pcvs1;
	JFrame frame;
	String username;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					MenuAdmin window = new MenuAdmin();
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
	public MenuAdmin(PCVS pcvs, String uname) {
		username = uname;
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
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 807, 600);
		frame.getContentPane().add(layeredPane);
		layeredPane.setLayout(null);
		
		HealthcareCentre healthcare1 = pcvs1.getHcOfAdmin(username);
		
		JLabel backgroundLbl = new JLabel("");
		backgroundLbl.setIcon(new ImageIcon("C:\\Users\\USER\\eclipse-workspace\\assignment2\\img\\background.jpg"));
		backgroundLbl.setBounds(0, 0, 797, 569);
		frame.getContentPane().add(backgroundLbl);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\USER\\eclipse-workspace\\assignment2\\img\\vaccine pic.png"));
		layeredPane.setLayer(lblNewLabel, 1);
		lblNewLabel.setBackground(Color.PINK);
		lblNewLabel.setBounds(37, 123, 167, 151);
		layeredPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Record New Vaccine Batch");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RecordVacBatch goToRecordVac = new RecordVacBatch(pcvs1, username);
				goToRecordVac.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 9));
		btnNewButton.setBounds(37, 284, 167, 21);
		layeredPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\USER\\eclipse-workspace\\assignment2\\img\\medical list pic.jpg"));
		lblNewLabel_1.setBackground(Color.PINK);
		lblNewLabel_1.setBounds(312, 123, 167, 151);
		layeredPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		layeredPane.setLayer(lblNewLabel_2, 1);
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\USER\\eclipse-workspace\\assignment2\\img\\confirm pic.png"));
		lblNewLabel_2.setBackground(Color.PINK);
		lblNewLabel_2.setBounds(573, 123, 167, 151);
		layeredPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		layeredPane.setLayer(lblNewLabel_3, 1);
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\USER\\eclipse-workspace\\assignment2\\img\\medical record pic.png"));
		lblNewLabel_3.setBackground(Color.PINK);
		lblNewLabel_3.setBounds(179, 353, 167, 151);
		layeredPane.add(lblNewLabel_3);
		
		JButton btnViewVaccineBatch = new JButton("View Vaccine Batch Information");
		btnViewVaccineBatch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ViewVacBatchInfo goToViewBatchInfo = new ViewVacBatchInfo(pcvs1, username);
				goToViewBatchInfo.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnViewVaccineBatch.setFont(new Font("Tahoma", Font.BOLD, 8));
		btnViewVaccineBatch.setBounds(312, 284, 167, 21);
		layeredPane.add(btnViewVaccineBatch);
		
		JButton btnConfirmVaccinationAppointment = new JButton("Confirm Vac Appointment");
		btnConfirmVaccinationAppointment.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ConfirmVac goToConfirm = new ConfirmVac(pcvs1, username);
				goToConfirm.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnConfirmVaccinationAppointment.setFont(new Font("Tahoma", Font.BOLD, 9));
		btnConfirmVaccinationAppointment.setBounds(573, 284, 167, 21);
		layeredPane.add(btnConfirmVaccinationAppointment);
		
		JLabel whiteBgLbl = new JLabel("");
		whiteBgLbl.setIcon(new ImageIcon("C:\\Users\\USER\\eclipse-workspace\\assignment2\\img\\white bg.jpg"));
		whiteBgLbl.setBackground(Color.PINK);
		whiteBgLbl.setBounds(37, 123, 167, 151);
		layeredPane.add(whiteBgLbl);
		
		JLabel whiteBgLbl2 = new JLabel("");
		whiteBgLbl2.setIcon(new ImageIcon("C:\\Users\\USER\\eclipse-workspace\\assignment2\\img\\white bg.jpg"));
		whiteBgLbl2.setBackground(Color.PINK);
		whiteBgLbl2.setBounds(573, 123, 167, 151);
		layeredPane.add(whiteBgLbl2);
		
		JButton btnRecordVacAdministered = new JButton("Record Vac Administered");
		btnRecordVacAdministered.setFont(new Font("Tahoma", Font.BOLD, 9));
		btnRecordVacAdministered.setBounds(179, 514, 167, 21);
		layeredPane.add(btnRecordVacAdministered);
		
		JLabel whiteBgLbl3 = new JLabel("");
		whiteBgLbl3.setIcon(new ImageIcon("C:\\Users\\USER\\eclipse-workspace\\assignment2\\img\\white bg.jpg"));
		whiteBgLbl3.setBackground(Color.PINK);
		whiteBgLbl3.setBounds(179, 353, 167, 151);
		layeredPane.add(whiteBgLbl3);
		
		JLabel logoutLbl = new JLabel("");
		layeredPane.setLayer(logoutLbl, 1);
		logoutLbl.setIcon(new ImageIcon("C:\\Users\\USER\\eclipse-workspace\\assignment2\\img\\logout pic.png"));
		logoutLbl.setBackground(Color.PINK);
		logoutLbl.setBounds(451, 353, 167, 151);
		layeredPane.add(logoutLbl);
		
		JLabel whiteBgLbl4 = new JLabel("");
		whiteBgLbl4.setIcon(new ImageIcon("C:\\Users\\USER\\eclipse-workspace\\assignment2\\img\\white bg.jpg"));
		whiteBgLbl4.setBackground(Color.PINK);
		whiteBgLbl4.setBounds(451, 353, 167, 151);
		layeredPane.add(whiteBgLbl4);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PCVSGUI goToHome = new PCVSGUI(pcvs1);
				goToHome.frame.setVisible(true);
				frame.dispose();
				
			}
		});
		btnLogOut.setFont(new Font("Tahoma", Font.BOLD, 9));
		btnLogOut.setBounds(451, 514, 167, 21);
		layeredPane.add(btnLogOut);
		
		JTextArea textArea = new JTextArea();
		textArea.setText("Welcome, Admin " + username + "\nHealthcare Centre: " + healthcare1.getCentreName());
		textArea.setEditable(false);
		layeredPane.setLayer(textArea, 1);
		textArea.setBounds(10, 10, 295, 72);
		layeredPane.add(textArea);
	}
}
