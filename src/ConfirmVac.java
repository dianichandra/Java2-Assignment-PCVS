import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class ConfirmVac {

	JFrame frame;
	private PCVS pcvs1;
	private String username;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ConfirmVac window = new ConfirmVac();
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
	public ConfirmVac(PCVS pcvs, String uname) {
		pcvs1 = pcvs;
		username = uname;
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
		frame.getContentPane().add(layeredPane, BorderLayout.CENTER);
		
		JLabel backgroundLbl = new JLabel("");
		backgroundLbl.setIcon(new ImageIcon("C:\\Users\\USER\\eclipse-workspace\\assignment2\\img\\background.jpg"));
		backgroundLbl.setBounds(0, 0, 797, 569);
		layeredPane.add(backgroundLbl);
		
		JLabel titleLbl = new JLabel("Confirm Vaccination Appointment");
		layeredPane.setLayer(titleLbl, 1);
		titleLbl.setHorizontalAlignment(SwingConstants.CENTER);
		titleLbl.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 17));
		titleLbl.setBounds(287, 47, 263, 48);
		layeredPane.add(titleLbl);
		
		JLabel vaccIDLbl = new JLabel("Enter Vaccination ID:");
		layeredPane.setLayer(vaccIDLbl, 1);
		vaccIDLbl.setBounds(185, 131, 117, 13);
		layeredPane.add(vaccIDLbl);
		
		//pcvs1.getHcOfAdmin(username).get
		
		JComboBox comboBox = new JComboBox();
		layeredPane.setLayer(comboBox, 1);
		comboBox.setBounds(319, 127, 210, 21);
		layeredPane.add(comboBox);
		for(int i =0; i < pcvs1.getHcOfAdmin(username).getNewBatch().size(); i++) {
			for(int j = 0; j < pcvs1.getHcOfAdmin(username).getNewBatch().get(i).getNewVaccinations().size(); j++) {
				comboBox.addItem(pcvs1.getHcOfAdmin(username).getNewBatch().get(i).getNewVaccinations().get(j).getVaccinationID());
			}
		}
		
		JLabel lblFullName = new JLabel("Full Name:");
		layeredPane.setLayer(lblFullName, 1);
		lblFullName.setBounds(185, 183, 117, 13);
		layeredPane.add(lblFullName);
		
		JLabel lblIcpassport = new JLabel("IC/Passport: ");
		layeredPane.setLayer(lblIcpassport, 1);
		lblIcpassport.setBounds(185, 227, 117, 13);
		layeredPane.add(lblIcpassport);
		
		JLabel lblBatchNo = new JLabel("Batch No:");
		layeredPane.setLayer(lblBatchNo, 1);
		lblBatchNo.setBounds(185, 263, 117, 13);
		layeredPane.add(lblBatchNo);
		
		JLabel lblExpiryDate = new JLabel("Expiry Date:");
		layeredPane.setLayer(lblExpiryDate, 1);
		lblExpiryDate.setBounds(185, 303, 117, 13);
		layeredPane.add(lblExpiryDate);
		
		JLabel label = new JLabel("New label");
		label.setBounds(321, 315, 45, 13);
		layeredPane.add(label);
		
		JLabel lblManufacturer = new JLabel("Manufacturer:");
		layeredPane.setLayer(lblManufacturer, 1);
		lblManufacturer.setBounds(185, 339, 117, 13);
		layeredPane.add(lblManufacturer);
		
		JLabel lblEmail = new JLabel("Vaccine Name:");
		layeredPane.setLayer(lblEmail, 1);
		lblEmail.setBounds(185, 380, 117, 13);
		layeredPane.add(lblEmail);
		
		JButton btnNewButton = new JButton("Confirm");
		btnNewButton.setBackground(new Color(102, 205, 170));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				for(int i = 0; i < pcvs1.getHcOfAdmin(username).getNewBatch().size(); i++) {
					for(int j =0; j < pcvs1.getHcOfAdmin(username).getNewBatch().get(i).getNewVaccinations().size(); j++) {
						if(String.valueOf(comboBox.getSelectedItem()) == 
								pcvs1.getHcOfAdmin(username).getNewBatch().get(i).getNewVaccinations().get(j).getVaccinationID()) {
							Vaccination vc1 = pcvs1.getHcOfAdmin(username).getNewBatch().get(i).getNewVaccinations().get(j);
							vc1.setStatus("Confirmed");
							vc1.setRemarks("Confirmation email has sent");
						}
					}
				}
				
				JOptionPane.showMessageDialog(null, "Success");
				
				MenuAdmin goToMain = new MenuAdmin(pcvs1, username);
				goToMain.frame.setVisible(true);
				frame.dispose();
				
			}
		});
		layeredPane.setLayer(btnNewButton, 1);
		btnNewButton.setBounds(325, 459, 94, 48);
		layeredPane.add(btnNewButton);
		
		JButton btnReject = new JButton("Reject");
		btnReject.setBackground(new Color(255, 160, 122));
		btnReject.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				for(int i = 0; i < pcvs1.getHcOfAdmin(username).getNewBatch().size(); i++) {
					for(int j =0; j < pcvs1.getHcOfAdmin(username).getNewBatch().get(i).getNewVaccinations().size(); j++) {
						if(String.valueOf(comboBox.getSelectedItem()) == 
								pcvs1.getHcOfAdmin(username).getNewBatch().get(i).getNewVaccinations().get(j).getVaccinationID()) {
							Vaccination vc1 = pcvs1.getHcOfAdmin(username).getNewBatch().get(i).getNewVaccinations().get(j);
							vc1.setStatus("Rejected");
							vc1.setRemarks("Rejection email has sent");
							
						}
					}
				}
				JOptionPane.showMessageDialog(null, "Success");
				
				MenuAdmin goToMain = new MenuAdmin(pcvs1, username);
				goToMain.frame.setVisible(true);
				frame.dispose();
				
			}
		});
		layeredPane.setLayer(btnReject, 1);
		btnReject.setBounds(444, 459, 85, 48);
		layeredPane.add(btnReject);
		
		JButton btnNewButton_1 = new JButton("Search");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		layeredPane.setLayer(btnNewButton_1, 1);
		btnNewButton_1.setBounds(567, 127, 85, 21);
		layeredPane.add(btnNewButton_1);
		
		textField = new JTextField();
		layeredPane.setLayer(textField, 1);
		textField.setColumns(10);
		textField.setBounds(319, 180, 210, 20);
		layeredPane.add(textField);
		
		textField_1 = new JTextField();
		layeredPane.setLayer(textField_1, 1);
		textField_1.setColumns(10);
		textField_1.setBounds(319, 224, 210, 20);
		layeredPane.add(textField_1);
		
		textField_2 = new JTextField();
		layeredPane.setLayer(textField_2, 1);
		textField_2.setColumns(10);
		textField_2.setBounds(319, 260, 210, 20);
		layeredPane.add(textField_2);
		
		textField_3 = new JTextField();
		layeredPane.setLayer(textField_3, 1);
		textField_3.setColumns(10);
		textField_3.setBounds(319, 300, 210, 20);
		layeredPane.add(textField_3);
		
		textField_4 = new JTextField();
		layeredPane.setLayer(textField_4, 1);
		textField_4.setColumns(10);
		textField_4.setBounds(319, 336, 210, 20);
		layeredPane.add(textField_4);
		
		textField_5 = new JTextField();
		layeredPane.setLayer(textField_5, 1);
		textField_5.setColumns(10);
		textField_5.setBounds(319, 377, 210, 20);
		layeredPane.add(textField_5);
		

	}

}
