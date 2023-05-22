import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Component;

public class DisplayUser {

	JFrame frame;
	private PCVS pcvs1;
	JTable table;
	JTable table2;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					DisplayUser window = new DisplayUser(pcvs1);
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
	public DisplayUser(PCVS pcvs) {
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
		
		JLabel backgroundLbl = new JLabel("New label");
		backgroundLbl.setIcon(new ImageIcon("C:\\Users\\USER\\eclipse-workspace\\assignment2\\img\\background.jpg"));
		backgroundLbl.setBounds(0, 0, 797, 569);
		layeredPane.add(backgroundLbl);
		
		table = new JTable();

		DefaultTableModel daDefaultTableModel = new DefaultTableModel(0, 0);

		String[] columnNames = new String[] {"Name", "Username", "Email", "StaffID", "Healthcare"};

		daDefaultTableModel.setColumnIdentifiers(columnNames);
		 for (int i = 0; i < pcvs1.getListOfAdministrator().size(); i++) {
			 daDefaultTableModel.addRow(new Object[] {
					 	pcvs1.getListOfAdministrator().get(i).getFullName(),
	                    pcvs1.getListOfAdministrator().get(i).getUsername(),
	                    pcvs1.getListOfAdministrator().get(i).getEmail(),
	                    pcvs1.getListOfAdministrator().get(i).getStaffID(),
	                    pcvs1.getHcOfAdmin(pcvs1.getListOfAdministrator().get(i).getUsername()).getCentreName()
	            });
	        } 
		//*Dummy data for Table
//		daDefaultTableModel.addRow(new Object[] {"Test1","Test2","Test3"});
//		daDefaultTableModel.addRow(new Object[] {"Test2","Test2","Test3"});
//		daDefaultTableModel.addRow(new Object[] {"Test3","Test2","Test3"});

		table.setModel(daDefaultTableModel);

		JScrollPane scrollPane = new JScrollPane(table);
		layeredPane.setLayer(scrollPane, 1);
		scrollPane.setBounds(28, 99, 737, 199);
		//frame.getContentPane().add(scrollPane);
		layeredPane.add(scrollPane);
		
		JLabel titleLbl = new JLabel("Display All User");
		titleLbl.setHorizontalAlignment(SwingConstants.CENTER);
		layeredPane.setLayer(titleLbl, 1);
		titleLbl.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 17));
		titleLbl.setBounds(279, 9, 235, 48);
		layeredPane.add(titleLbl);
		
		table2 = new JTable();

		DefaultTableModel daDefaultTableModel2 = new DefaultTableModel(0, 0);
		
		String[] columnNames2 = new String[] {"Name", "Username", "Email", "ICPassport"};

		daDefaultTableModel2.setColumnIdentifiers(columnNames2);
		 for (int i = 0; i < pcvs1.getListOfPatient().size(); i++) {
			 daDefaultTableModel2.addRow(new Object[] {
					 	pcvs1.getListOfPatient().get(i).getFullName(),
	                    pcvs1.getListOfPatient().get(i).getUsername(),
	                    pcvs1.getListOfPatient().get(i).getEmail(),
	                    pcvs1.getListOfPatient().get(i).getICPassport()
	            });
	        } 
		//*Dummy data for Table
//		daDefaultTableModel.addRow(new Object[] {"Test1","Test2","Test3"});
//		daDefaultTableModel.addRow(new Object[] {"Test2","Test2","Test3"});
//		daDefaultTableModel.addRow(new Object[] {"Test3","Test2","Test3"});

		table2.setModel(daDefaultTableModel2);
		
		JScrollPane scrollPane_1 = new JScrollPane(table2);
		layeredPane.setLayer(scrollPane_1, 1);
		scrollPane_1.setBounds(28, 354, 737, 199);
		layeredPane.add(scrollPane_1);
		
		JLabel lblAdministator = new JLabel("Administator");
		layeredPane.setLayer(lblAdministator, 1);
		lblAdministator.setHorizontalAlignment(SwingConstants.LEFT);
		lblAdministator.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 14));
		lblAdministator.setBounds(28, 51, 204, 38);
		layeredPane.add(lblAdministator);
		
		JLabel lblPatient = new JLabel("Patient");
		layeredPane.setLayer(lblPatient, 1);
		lblPatient.setHorizontalAlignment(SwingConstants.LEFT);
		lblPatient.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 14));
		lblPatient.setBounds(28, 308, 204, 38);
		layeredPane.add(lblPatient);
	}
}
