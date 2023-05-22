

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PCVSGUI {

	private PCVS pcvs1;
	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		PCVS pcvs1 = new PCVS();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PCVSGUI window = new PCVSGUI(pcvs1);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PCVSGUI(PCVS pcvs) {
		pcvs1 = pcvs;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 807, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 807, 600);
		frame.getContentPane().add(layeredPane);
		
		JLabel titleLbl = new JLabel("PCVS SYSTEM");
		layeredPane.setLayer(titleLbl, 1);
		titleLbl.setHorizontalAlignment(SwingConstants.CENTER);
		titleLbl.setFont(new Font("Malgun Gothic", Font.BOLD, 20));
		titleLbl.setBounds(297, 10, 216, 50);
		layeredPane.add(titleLbl);
		
		JLabel picAdmin = new JLabel("");
		layeredPane.setLayer(picAdmin, 1);
		picAdmin.setIcon(new ImageIcon("C:\\Users\\USER\\eclipse-workspace\\assignment2\\img\\admin pic home.jpg"));
		picAdmin.setBounds(93, 120, 221, 219);
		layeredPane.add(picAdmin);
		
		JLabel picPatient = new JLabel("");
		layeredPane.setLayer(picPatient, 1);
		picPatient.setIcon(new ImageIcon("C:\\Users\\USER\\eclipse-workspace\\assignment2\\img\\patient pic home.jpg"));
		picPatient.setBounds(479, 120, 221, 219);
		//frame.getContentPane().add(picPatient);
		layeredPane.add(picPatient);
		
		JButton btnPatient = new JButton("PATIENT");
		btnPatient.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SignupPatient goToPatient = new SignupPatient(pcvs1);
				goToPatient.frame.setVisible(true);
				frame.dispose();
			}
		});
		layeredPane.setLayer(btnPatient, 1);
		btnPatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPatient.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		btnPatient.setBackground(new Color(255, 228, 225));
		btnPatient.setBounds(479, 349, 221, 39);
		//frame.getContentPane().add(btnPatient);
		layeredPane.add(btnPatient);
		
		JLabel positionLbl = new JLabel("Select Your Position");
		layeredPane.setLayer(positionLbl, 1);
		positionLbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		positionLbl.setBounds(319, 58, 185, 59);
		//frame.getContentPane().add(positionLbl);
		layeredPane.add(positionLbl);
		
		JButton btnAdministrator = new JButton("ADMINISTRATOR");
		btnAdministrator.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SignUpAdmin goToAdmin = new SignUpAdmin(pcvs1);
				goToAdmin.frame.setVisible(true);
				frame.dispose();
			}
		});
		layeredPane.setLayer(btnAdministrator, 1);
		btnAdministrator.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAdministrator.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		btnAdministrator.setBackground(new Color(173, 216, 230));
		btnAdministrator.setBounds(93, 349, 221, 39);
		//frame.getContentPane().add(btnAdministrator);
		layeredPane.add(btnAdministrator);
		
		JLabel backgroundLbl = new JLabel("");
		backgroundLbl.setIcon(new ImageIcon("C:\\Users\\USER\\eclipse-workspace\\assignment2\\img\\background.jpg"));
		backgroundLbl.setBounds(0, 0, 797, 569);
		layeredPane.add(backgroundLbl);
		
		JButton btnDisplayAllUsers_1 = new JButton("DISPLAY ALL USERS");
		btnDisplayAllUsers_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DisplayUser goToDisplayUser = new DisplayUser(pcvs1);
				goToDisplayUser.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnDisplayAllUsers_1.setVerticalAlignment(SwingConstants.BOTTOM);
		layeredPane.setLayer(btnDisplayAllUsers_1, 1);
		btnDisplayAllUsers_1.setForeground(Color.WHITE);
		btnDisplayAllUsers_1.setFont(new Font("Myriad Hebrew", Font.PLAIN, 16));
		btnDisplayAllUsers_1.setBackground(new Color(117,189,255));
		btnDisplayAllUsers_1.setBounds(93, 425, 607, 33);
		layeredPane.add(btnDisplayAllUsers_1);
		
		JButton btnDisplayAllUsers = new JButton("DISPLAY ALL VACCINATION APPOINTMENT");
		btnDisplayAllUsers.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DisplayVacAppointment goToDisplayVacApt = new DisplayVacAppointment(pcvs1);
				goToDisplayVacApt.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnDisplayAllUsers.setVerticalAlignment(SwingConstants.BOTTOM);
		layeredPane.setLayer(btnDisplayAllUsers, 1);
		btnDisplayAllUsers.setForeground(Color.WHITE);
		btnDisplayAllUsers.setFont(new Font("Myriad Hebrew", Font.PLAIN, 16));
		btnDisplayAllUsers.setBackground(new Color(117,189,255));
		btnDisplayAllUsers.setBounds(93, 487, 607, 33);
		layeredPane.add(btnDisplayAllUsers);
		
	}
}
