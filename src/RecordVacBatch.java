

import java.awt.EventQueue;
import javax.swing.JOptionPane; 

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JPasswordField;
import java.awt.BorderLayout;
import javax.swing.JTextPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RecordVacBatch {

	private PCVS pcvs1;
	private String username;
	JFrame frame;
	private JTextField dateTextField;
	private JTextField quantityTextField;
	private JTextField batchNumTextField;
	private JTextField yearTextField;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					RecordVacBatch window = new RecordVacBatch();
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
	public RecordVacBatch(PCVS pcvs, String uname) {
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
		frame.getContentPane().add(layeredPane, BorderLayout.CENTER);
		
		JLabel backgroundLbl = new JLabel("");
		backgroundLbl.setIcon(new ImageIcon("C:\\Users\\USER\\eclipse-workspace\\assignment2\\img\\background.jpg"));
		backgroundLbl.setBounds(0, 0, 797, 569);
		layeredPane.add(backgroundLbl);
		
		HealthcareCentre healthcare1 = pcvs1.getHcOfAdmin(username);
		
		JLabel signupLabel = new JLabel("Record Vaccine Batch");
		layeredPane.setLayer(signupLabel, 1);
		signupLabel.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 17));
		signupLabel.setBounds(289, 41, 235, 48);
		layeredPane.add(signupLabel);
		
		JLabel batchNumLbl = new JLabel("Batch Number");
		layeredPane.setLayer(batchNumLbl, 1);
		batchNumLbl.setBounds(289, 231, 83, 13);
		layeredPane.add(batchNumLbl);
		
		JLabel expLbl = new JLabel("Expiry Date");
		layeredPane.setLayer(expLbl, 1);
		expLbl.setBounds(289, 306, 83, 13);
		layeredPane.add(expLbl);
		
		dateTextField = new JTextField();
		layeredPane.setLayer(dateTextField, 1);
		dateTextField.setToolTipText("");
		dateTextField.setHorizontalAlignment(SwingConstants.LEFT);
		dateTextField.setColumns(10);
		dateTextField.setBounds(289, 352, 45, 33);
		layeredPane.add(dateTextField);
		
		JLabel quantityLbl = new JLabel("Quantity");
		layeredPane.setLayer(quantityLbl, 1);
		quantityLbl.setBounds(289, 395, 56, 13);
		layeredPane.add(quantityLbl);
		
		JLabel hcLbl = new JLabel("Vaccine ID Available: ");
		layeredPane.setLayer(hcLbl, 1);
		hcLbl.setBounds(289, 99, 149, 13);
		layeredPane.add(hcLbl);
		
		JTextArea vacTextArea = new JTextArea();
		layeredPane.setLayer(vacTextArea, 1);
		vacTextArea.setBounds(289, 168, 235, 53);
		layeredPane.add(vacTextArea);
		
		
		String [] listVacChoice = {" ", "V001", "V002", "V003"};
		JComboBox vacComboBox = new JComboBox(listVacChoice);
		vacComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(vacComboBox.getSelectedIndex() == 1) {
					vacTextArea.setText("Vaccine details \nName: Moderna (mRNA-1273) \nManufacturer: ModernaTX,Inc.");
				}
				else if(vacComboBox.getSelectedIndex() == 2) {
					vacTextArea.setText("Vaccine details \nName: Pfizer (BNT162b2) \nManufacturer: Pfizer,Inc. and BioNTech");
				}
				else if(vacComboBox.getSelectedIndex() == 3) {
					vacTextArea.setText("Vaccine details \nName: AstraZeneca (AZD1222) \nManufacturer: University of Oxford");
				}
			}
		});
		layeredPane.setLayer(vacComboBox, 1);
		vacComboBox.setBounds(289, 122, 235, 21);
		layeredPane.add(vacComboBox);
		
		quantityTextField = new JTextField();
		layeredPane.setLayer(quantityTextField, 1);
		quantityTextField.setToolTipText("");
		quantityTextField.setHorizontalAlignment(SwingConstants.LEFT);
		quantityTextField.setColumns(10);
		quantityTextField.setBounds(289, 418, 235, 33);
		layeredPane.add(quantityTextField);
		
		
		JLabel batchError = new JLabel("Input the correct number !");
		batchError.setFont(new Font("Tahoma", Font.PLAIN, 8));
		batchError.setForeground(Color.RED);
		layeredPane.setLayer(batchError, 1);
		batchError.setBounds(534, 269, 140, 13);
		layeredPane.add(batchError);
		batchError.setVisible(false);
		
		JLabel expError = new JLabel("Input the correct date !");
		expError.setFont(new Font("Tahoma", Font.PLAIN, 8));
		layeredPane.setLayer(expError, 1);
		expError.setForeground(Color.RED);
		expError.setBounds(534, 363, 140, 13);
		layeredPane.add(expError);
		expError.setVisible(false);
		
		JLabel quantityError = new JLabel("Input the correct number !");
		quantityError.setFont(new Font("Tahoma", Font.PLAIN, 8));
		layeredPane.setLayer(quantityError, 1);
		quantityError.setForeground(Color.RED);
		quantityError.setBounds(534, 428, 140, 13);
		layeredPane.add(quantityError);
		quantityError.setVisible(false);

		
		
		batchNumTextField = new JTextField();
		layeredPane.setLayer(batchNumTextField, 1);
		batchNumTextField.setBounds(289, 259, 235, 33);
		layeredPane.add(batchNumTextField);
		
		JLabel dateLbl = new JLabel("Date");
		layeredPane.setLayer(dateLbl, 1);
		dateLbl.setBounds(289, 329, 37, 13);
		layeredPane.add(dateLbl);
		
		String [] listMonth = {" ", "Jan", "Feb", "March", "Apr", "May", "June", "July", "August", "Sept", "Oct", "Nov", "Des"};
		JComboBox monthComboBox = new JComboBox(listMonth);
		layeredPane.setLayer(monthComboBox, 1);
		monthComboBox.setBounds(347, 352, 98, 33);
		layeredPane.add(monthComboBox);
		
		JLabel monthLbl = new JLabel("Month");
		layeredPane.setLayer(monthLbl, 1);
		monthLbl.setBounds(347, 329, 83, 13);
		layeredPane.add(monthLbl);
		
		yearTextField = new JTextField();
		layeredPane.setLayer(yearTextField, 1);
		yearTextField.setToolTipText("");
		yearTextField.setHorizontalAlignment(SwingConstants.LEFT);
		yearTextField.setColumns(10);
		yearTextField.setBounds(455, 352, 69, 33);
		layeredPane.add(yearTextField);
		
		JLabel lblYear = new JLabel("Year");
		layeredPane.setLayer(lblYear, 1);
		lblYear.setBounds(455, 329, 83, 13);
		layeredPane.add(lblYear);
		

		JButton signupBtn = new JButton("REGISTER BATCH");
		signupBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				if( vacComboBox.getSelectedIndex() == 0 || batchNumTextField.getText().isEmpty() || dateTextField.getText().isEmpty() || quantityTextField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Fill all the blank field correctly !");
				}
				else {
					int batch = Integer.parseInt(batchNumTextField.getText());
					int date = Integer.parseInt(dateTextField.getText());
					int year = Integer.parseInt(yearTextField.getText());
					int quantity = Integer.parseInt(quantityTextField.getText());
					int quantityAdministered = 0;
					String expDate = String.valueOf(date) + "/" + String.valueOf(monthComboBox.getSelectedIndex()) + "/" + String.valueOf(year);
					if(batch <= 0) {
						batchError.setVisible(true);
						batchNumTextField.setText("");
					}
					else if(batch >= 0) {
						batchError.setVisible(false);
					}
					
					if(date <= 0 || date > 31 || monthComboBox.getSelectedIndex() == 0 || year <= 0) {
						expError.setVisible(true);
						dateTextField.setText("");
						monthComboBox.setSelectedIndex(0);
						yearTextField.setText("");
					}
					
					else if(date > 0 && date < 31 && monthComboBox.getSelectedIndex() > 1 && year > 0 ) {
						expError.setVisible(false);
					}
					
					if(quantity <= 0) {
						quantityError.setVisible(true);
						quantityTextField.setText("");
					}
					
					else if(quantity > 0) {
						quantityError.setVisible(false);
					}
					
					if(batch >= 0 && date > 0 && date < 31 && monthComboBox.getSelectedIndex() >= 1 && year > 0 
							&& quantity > 0) {
						//new batch object created to store a new batch based on user input
                        Batch batch1 = new Batch(batch,expDate, quantity, quantityAdministered);

                        //adding the new batch to the healthcare
                        pcvs1.setBatchToHC(healthcare1,batch1);
                        
                        //adding the new batch to the vaccine 
                        pcvs1.setBatchToVaccine(vacComboBox.getSelectedIndex() -1,batch1);
                        

                        //adding the healthcare object to the list of healthcare with vaccine
                        if(!pcvs1.getListOfHcWithVaccine().contains(healthcare1)) {
                        	pcvs1.setListOfHcWithVaccine(healthcare1);
                        }
                        for (int j = 0; j < healthcare1.getNewBatch().size(); j++){
                        	JOptionPane.showMessageDialog(null, "Debug: " + healthcare1.getNewBatch().get(j).getBatchNo());
                        }
						MenuAdmin goToMain = new MenuAdmin(pcvs1, username);
						goToMain.frame.setVisible(true);
						frame.dispose();
					}
				}
			}
		});
		layeredPane.setLayer(signupBtn, 1);
		signupBtn.setForeground(Color.WHITE);
		signupBtn.setFont(new Font("Myriad Hebrew", Font.PLAIN, 16));
		signupBtn.setBackground(new Color(135, 206, 250));
		signupBtn.setBounds(289, 475, 235, 33);
		layeredPane.add(signupBtn);
		
	
	}
}
