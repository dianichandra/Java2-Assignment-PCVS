import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ReqVacAppointment {

	JFrame frame;
	String username;
	String password;
	private PCVS pcvs1;
	private JTextField quantityTextField;
	private JTextField expDateTextField;
	private JTextField dateTextField;
	private JTextField yearTextField;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ReqVacAppointment window = new ReqVacAppointment(pcvs1);
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
	public ReqVacAppointment(PCVS pcvs, String uname, String pass) {
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
		
		JLayeredPane layeredPane = new JLayeredPane();
		frame.getContentPane().add(layeredPane, BorderLayout.CENTER);
		
		JLabel lblBatchNumber = new JLabel("Batch Number:");
		lblBatchNumber.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBatchNumber.setBounds(174, 281, 71, 13);
		layeredPane.add(lblBatchNumber);
		
		JLabel lblQuantityAvailable = new JLabel("Quantity Available:");
		lblQuantityAvailable.setHorizontalAlignment(SwingConstants.RIGHT);
		layeredPane.setLayer(lblQuantityAvailable, 1);
		lblQuantityAvailable.setBounds(151, 329, 94, 13);
		layeredPane.add(lblQuantityAvailable);
		
		quantityTextField = new JTextField();
		layeredPane.setLayer(quantityTextField, 1);
		quantityTextField.setToolTipText("");
		quantityTextField.setHorizontalAlignment(SwingConstants.LEFT);
		quantityTextField.setColumns(10);
		quantityTextField.setBounds(261, 319, 235, 33);
		layeredPane.add(quantityTextField);
		
		JLabel icpLbl = new JLabel("Expiry Date:");
		icpLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		icpLbl.setBounds(185, 381, 60, 13);
		layeredPane.add(icpLbl);
		
		expDateTextField = new JTextField();
		expDateTextField.setToolTipText("");
		expDateTextField.setHorizontalAlignment(SwingConstants.LEFT);
		expDateTextField.setColumns(10);
		expDateTextField.setBounds(261, 371, 330, 33);
		layeredPane.add(expDateTextField);
		
		JLabel backgroundLbl = new JLabel("");
		backgroundLbl.setIcon(new ImageIcon("C:\\Users\\USER\\eclipse-workspace\\assignment2\\img\\background.jpg"));
		backgroundLbl.setBounds(0, 0, 797, 569);
		layeredPane.add(backgroundLbl);
		
		
		JLabel titleLbl = new JLabel("Request Vaccination Appointment");
		titleLbl.setHorizontalAlignment(SwingConstants.CENTER);
		layeredPane.setLayer(titleLbl, 1);
		titleLbl.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 17));
		titleLbl.setBounds(301, 30, 235, 48);
		layeredPane.add(titleLbl);
		
		JLabel hcLbl = new JLabel("Vaccine ID Available: ");
		layeredPane.setLayer(hcLbl, 1);
		hcLbl.setBounds(261, 101, 149, 13);
		layeredPane.add(hcLbl);
		
		
		
//		ArrayList<Vaccine> listVac = pcvs1.getListVaccine();
//		ArrayList<String> listVacCbBox;
//		for(int i = 0; i < listVac.size(); i++){
//			listVacCbBox.add(String.valueOf(listVac.get(i).getVaccineID()));
//		}
		
		JTextArea vacTextArea = new JTextArea();
		layeredPane.setLayer(vacTextArea, 1);
		vacTextArea.setBounds(261, 155, 330, 53);
		layeredPane.add(vacTextArea);
		
		
		JComboBox vacComboBox = new JComboBox(pcvs1.getVaccineID().toArray());
		vacComboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.DESELECTED) //edit: bracket was missing
				   { 
				       vacComboBox.setSelectedItem(e.getItem());
				   }
				   else if(e.getStateChange() == ItemEvent.SELECTED)
				   {
					   vacComboBox.setSelectedItem(e.getItem());
				   }
			}
		});
		
		//pcvs1.getListHcWithVacIdx(vacComboBox.getSelectedIndex()).toArray()
		
		vacComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vacTextArea.setText("Vaccine details \nName: " + pcvs1.getVaccineIdx(vacComboBox.getSelectedIndex()).getVaccineName()
						+ " \nManufacturer: " + pcvs1.getVaccineIdx(vacComboBox.getSelectedIndex()).getManufacturer());
				
			}
		});
		
		layeredPane.setLayer(vacComboBox, 1);
		vacComboBox.setBounds(261, 124, 330, 21);
		layeredPane.add(vacComboBox);
		

		
		//pcvs1.getListHcWithVacIdx(vacComboBox.getSelectedIndex()).toArray()
		
		JComboBox hcComboBox = new JComboBox();
		layeredPane.setLayer(hcComboBox, 1);
		hcComboBox.setBounds(261, 230, 235, 21);
		layeredPane.add(hcComboBox);
		
		
		JLabel lblHealthcareAvailable = new JLabel("Healthcare Available: ");
		lblHealthcareAvailable.setHorizontalAlignment(SwingConstants.RIGHT);
		layeredPane.setLayer(lblHealthcareAvailable, 1);
		lblHealthcareAvailable.setBounds(151, 234, 100, 13);
		layeredPane.add(lblHealthcareAvailable);
		
		
		JComboBox batchComboBox = new JComboBox();
		layeredPane.setLayer(batchComboBox, 1);
		batchComboBox.setBounds(261, 277, 235, 21);
		layeredPane.add(batchComboBox);
	
		
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//for (int i = 0; i < pcvs1.getListHcWithVacIdx(vacComboBox.getSelectedIndex().size(); i++) {
                    //here you can give your combo the number of index
					//vacComboBox.setSelectedIndex(vacComboBox.getSelectedIndex());
					hcComboBox.removeAllItems();
					//hcComboBox.addItem(pcvs1.getListHcWithVacIdx(vacComboBox.getSelectedIndex()));
					if(!pcvs1.checkHcWithVac(vacComboBox.getSelectedIndex())) {
						JOptionPane.showMessageDialog(null, "There's no healthcare");
						batchComboBox.removeAllItems();
						quantityTextField.setText("");
						quantityTextField.setEditable(false);
						
						expDateTextField.setText("");
						expDateTextField.setEditable(false);
						
					}
					else {
						for(int i = 0; i < pcvs1.getListHcWithVacIdx(vacComboBox.getSelectedIndex()).size(); i++) {
							hcComboBox.addItem(pcvs1.getListHcWithVacIdx(vacComboBox.getSelectedIndex()).get(i));
//							if(pcvs1.checkHcWithVac(vacComboBox.getSelectedIndex()) == true) {
//								hcComboBox.addItem(pcvs1.getHcNew(vacComboBox.getSelectedIndex()).get(i));
//							}
						}
						
					}
}
			//}
		});
		layeredPane.setLayer(btnNewButton, 1);
		btnNewButton.setBounds(506, 230, 85, 21);
		layeredPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Search");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				batchComboBox.removeAllItems();
				//if(pcvs1.checkBatch(hcComboBox.getSelectedIndex(), vacComboBox.getSelectedIndex()) == false) {
				if(!pcvs1.checkHcWithVac(vacComboBox.getSelectedIndex())) {
					JOptionPane.showMessageDialog(null, "There's no batch");
				}
				else {
//					for(int j = 0; j < pcvs1.getListVaccine().size(); j++) {
//						for(int k = 0; k < pcvs1.getListVaccine().get(j).getListBatch().size(); k++) {
							pcvs1.getListBatchNo(hcComboBox.getSelectedIndex(), vacComboBox.getSelectedIndex());
							if(pcvs1.getListBatchNo(hcComboBox.getSelectedIndex(), vacComboBox.getSelectedIndex()).size() != 0) {
								for(int i = 0; i < pcvs1.getListBatchNo(hcComboBox.getSelectedIndex(), vacComboBox.getSelectedIndex()).size(); i++) {
									//if(pcvs1.checkExpVaccine(hcComboBox.getSelectedIndex(), vacComboBox.getSelectedIndex())) {
										batchComboBox.addItem(pcvs1.getListBatchNo(hcComboBox.getSelectedIndex(), vacComboBox.getSelectedIndex()).get(i));
										quantityTextField.setText(String.valueOf(pcvs1.getQuantity(hcComboBox.getSelectedIndex(), batchComboBox.getSelectedIndex())));
										quantityTextField.setEditable(false);
										
										expDateTextField.setText(pcvs1.getDate(hcComboBox.getSelectedIndex(), batchComboBox.getSelectedIndex()));
										expDateTextField.setEditable(false);
									//}
								}
							}
							else {
								JOptionPane.showMessageDialog(null, "All batch are expired");
							}
//						}
//					}
				}
			}
			
		});
		layeredPane.setLayer(btnNewButton_1, 1);
		btnNewButton_1.setBounds(506, 277, 85, 21);
		layeredPane.add(btnNewButton_1);
		
		JLabel lblAppointmentDate = new JLabel("Appointment Date:");
		lblAppointmentDate.setHorizontalAlignment(SwingConstants.RIGHT);
		layeredPane.setLayer(lblAppointmentDate, 1);
		lblAppointmentDate.setBounds(137, 433, 108, 13);
		layeredPane.add(lblAppointmentDate);
		
		dateTextField = new JTextField();
		layeredPane.setLayer(dateTextField, 1);
		dateTextField.setToolTipText("");
		dateTextField.setHorizontalAlignment(SwingConstants.LEFT);
		dateTextField.setColumns(10);
		dateTextField.setBounds(261, 423, 45, 33);
		layeredPane.add(dateTextField);
		
		JButton refresh3Btn = new JButton("Saerch");
		refresh3Btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(batchComboBox.getItemCount() != 0) {
					quantityTextField.setText(String.valueOf(pcvs1.getQuantity(hcComboBox.getSelectedIndex(), batchComboBox.getSelectedIndex())));
					quantityTextField.setEditable(false);
					
					expDateTextField.setText(pcvs1.getDate(hcComboBox.getSelectedIndex(), batchComboBox.getSelectedIndex()));
					expDateTextField.setEditable(false);
				}
				else {
					JOptionPane.showMessageDialog(null, "No batch can be selected");
				}
			}
		});
		layeredPane.setLayer(refresh3Btn, 1);
		refresh3Btn.setBounds(506, 325, 85, 21);
		layeredPane.add(refresh3Btn);
		
		String [] listMonth = {" ", "January", "February", "March", "April", "May", "June",
				"July", "August", "September", "October", "November", "December"};
		JComboBox monthComboBox = new JComboBox(listMonth);
		layeredPane.setLayer(monthComboBox, 1);
		monthComboBox.setBounds(316, 423, 180, 33);
		layeredPane.add(monthComboBox);
		
		yearTextField = new JTextField();
		layeredPane.setLayer(yearTextField, 1);
		yearTextField.setToolTipText("");
		yearTextField.setHorizontalAlignment(SwingConstants.LEFT);
		yearTextField.setColumns(10);
		yearTextField.setBounds(506, 423, 85, 33);
		layeredPane.add(yearTextField);
		
		JLabel errorLbl = new JLabel("Incorrect input !");
		errorLbl.setForeground(Color.RED);
		layeredPane.setLayer(errorLbl, 1);
		errorLbl.setBounds(601, 433, 94, 13);
		layeredPane.add(errorLbl);
		errorLbl.setVisible(false);
		
		
//		int date = Integer.parseInt(dateTextField.getText());
//		int month = monthComboBox.getSelectedIndex();
//		int year = Integer.parseInt(yearTextField.getText());
		//String appointmentDate = String.valueOf(dateTextField.getText() + "/" + String.valueOf(monthComboBox.getSelectedIndex()) + "/" + yearTextField.getText());
		
		
//		int date = Integer.parseInt(dateTextField.getText());
//		int year = Integer.parseInt(yearTextField.getText());
//		String appointmentDate = String.valueOf(date) + "/" + String.valueOf(monthComboBox.getSelectedIndex()) + "/" + String.valueOf(year);
		
		JButton signupBtn = new JButton("REQUEST BATCH");
		signupBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String date = dateTextField.getText();
				String month = String.valueOf(monthComboBox.getSelectedIndex());
				String year = yearTextField.getText();
				String aptDate = date + "/" + month + "/" + year;
				
				if( vacComboBox.getSelectedItem() == null || hcComboBox.getSelectedItem() == null || batchComboBox.getSelectedItem() == null || dateTextField.getText() == "" || 
						monthComboBox.getSelectedIndex() == 0 || yearTextField.getText() == "" ) {
					JOptionPane.showMessageDialog(null, "Fill all the blank field correctly !");
				}
				else {
					JOptionPane.showMessageDialog(null, aptDate);
					if(Integer.parseInt(dateTextField.getText()) <= 0 || Integer.parseInt(dateTextField.getText()) > 31 
							|| monthComboBox.getSelectedIndex() == 0 || Integer.parseInt(yearTextField.getText()) <= 0){
							//|| date > 31 || month == 0 || year <= 0) {
						errorLbl.setVisible(true);
						dateTextField.setText("");
						monthComboBox.setSelectedIndex(0);
						yearTextField.setText("");
					}
					else {
						errorLbl.setVisible(false);
						//tambah
						
						if(pcvs1.checkReqDateWithBatch(aptDate, hcComboBox.getSelectedIndex(), 
								Integer.valueOf((String) batchComboBox.getSelectedItem()))){
							JOptionPane.showMessageDialog(null, "The date you requested is after the expired date of the vaccine");
							dateTextField.setText("");
							monthComboBox.setSelectedIndex(0);
							yearTextField.setText("");
						}
						else {
									
							String randVacID = pcvs1.randomVaccinationID();
	                        
	                        //a new vaccination object created to store the object based on the user input
	                        Vaccination vaccination1 = new Vaccination(randVacID,aptDate,"Pending",null);
	
	                        //a new batch object created to store the batch thas has been proceeded by the user before
	                        Batch batchForTheVaccination = pcvs1.getBatchRecordedInHC(hcComboBox.getSelectedIndex(), 
	                        		Integer.valueOf((String) batchComboBox.getSelectedItem()));
	
	                        //a new patient object created to store the patient that logged in just now
	                        Patient patientAccount = pcvs1.getPatient(username,password);
	
	                        //adding the vaccination to the arraylist in the patient and batch class
	                        pcvs1.setVaccination(vaccination1,batchForTheVaccination,patientAccount);
	                        
	                        HealthcareCentre hc1 = pcvs1.getListOfHCIdx(hcComboBox.getSelectedIndex());
	                        
	                        hc1.setNewBatch(batchForTheVaccination);
	                        
	                        
							JOptionPane.showMessageDialog(null, "Succes " + patientAccount.getFullName() + "debug " + patientAccount.getNewVaccinations());
							
							MenuPatient goToMain = new MenuPatient(pcvs1, username, password);
							goToMain.frame.setVisible(true);
							frame.dispose();
						}
					}
				}
			}
		});
		layeredPane.setLayer(signupBtn, 1);
		signupBtn.setForeground(Color.WHITE);
		signupBtn.setFont(new Font("Myriad Hebrew", Font.PLAIN, 16));
		signupBtn.setBackground(new Color(135, 206, 250));
		signupBtn.setBounds(261, 488, 330, 33);
		layeredPane.add(signupBtn);
		
		
	}
}
