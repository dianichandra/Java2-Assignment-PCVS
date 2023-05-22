import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class ViewVacBatchInfo {

	JFrame frame;
	private PCVS pcvs1;
	private JTextField hcTextField;
	private JTable table;
	private String username;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ViewVacBatchInfo window = new ViewVacBatchInfo();
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
	public ViewVacBatchInfo(PCVS pcvs, String uname) {
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
		layeredPane.setLayer(backgroundLbl, 0);
		backgroundLbl.setIcon(new ImageIcon("C:\\Users\\USER\\eclipse-workspace\\assignment2\\img\\background.jpg"));
		backgroundLbl.setBounds(0, 0, 797, 569);
		layeredPane.add(backgroundLbl);
		
		JLabel titleLbl = new JLabel("View Vaccine Batch Information");
		layeredPane.setLayer(titleLbl, 1);
		titleLbl.setHorizontalAlignment(SwingConstants.CENTER);
		titleLbl.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 17));
		titleLbl.setBounds(270, 10, 263, 48);
		layeredPane.add(titleLbl);
		
		JLabel hcLbl = new JLabel("Select Batch: ");
		layeredPane.setLayer(hcLbl, 1);
		hcLbl.setBounds(577, 134, 115, 13);
		layeredPane.add(hcLbl);
		
		
		JComboBox batchComboBox = new JComboBox();
		layeredPane.setLayer(batchComboBox, 1);
		batchComboBox.setBounds(577, 157, 169, 21);
		layeredPane.add(batchComboBox);
		
		ArrayList<String> batchNo = new ArrayList<>();
		
		for (int i = 0; i < pcvs1.getListOfHcWithVaccine().size(); i++) {
			batchNo.add(String.valueOf(pcvs1.getHcOfAdmin(username).getNewBatch().get(i).getBatchNo()));
			batchComboBox.addItem(batchNo);
		}
		
		JLabel lblHealthcareCentre = new JLabel("Healthcare Centre:");
		layeredPane.setLayer(lblHealthcareCentre, 1);
		lblHealthcareCentre.setBounds(29, 92, 117, 13);
		layeredPane.add(lblHealthcareCentre);
		
		hcTextField = new JTextField();
		hcTextField.setEditable(false);
		layeredPane.setLayer(hcTextField, 1);
		hcTextField.setBounds(156, 89, 210, 20);
		layeredPane.add(hcTextField);
		hcTextField.setColumns(10);
		hcTextField.setText(pcvs1.getHcOfAdmin(username).getCentreName());
		
		JButton btnNewButton = new JButton("Select");
		layeredPane.setLayer(btnNewButton, 1);
		btnNewButton.setBounds(577, 211, 85, 21);
		layeredPane.add(btnNewButton);
		
		table = new JTable();

		DefaultTableModel daDefaultTableModel = new DefaultTableModel(0, 0);

		String[] columnNames = new String[] {"No of batch", "Vaccine Name", "No of Pending Appointment"};

		daDefaultTableModel.setColumnIdentifiers(columnNames);
		
		HealthcareCentre hc1 = pcvs1.getHcOfAdmin(username);
		
		
		//pcvs1.getHcOfAdmin(null).getNewBatch().size()
		 for (int i = 0; i < pcvs1.getListOfHcWithVaccine().size(); i++) {
			 if(hc1.getCentreName() == pcvs1.getListOfHcWithVaccine().get(i).getCentreName()) {
				 for(int j =0; j < pcvs1.getListOfHcWithVaccine().get(i).getNewBatch().size(); j++) {
					 
			 //for(int j = 0; j < pcvs1.getHcOfAdmin(username).getNewBatch().get(i).getNewVaccinations().size(); j++) {
					 daDefaultTableModel.addRow(new Object[] {
							 
						 pcvs1.getListOfHcWithVaccine().get(i).getNewBatch().get(j).getBatchNo(),
						 " ",
						 pcvs1.getListOfHcWithVaccine().get(i).getNewBatch().get(j).getNewVaccinations().size()
						 //pcvs1.getListVaccine().get(i).getVaccineName()
						 
		            });
				 }
			 }
		 		//}
	      } 
//		daDefaultTableModel.addRow(new Object[] {"Test3","Test2","Test3"});

		table.setModel(daDefaultTableModel);
		
		JScrollPane scrollPane = new JScrollPane(table);
		layeredPane.setLayer(scrollPane, 1);
		scrollPane.setBounds(25, 119, 528, 176);
		layeredPane.add(scrollPane);
		
	}

}
