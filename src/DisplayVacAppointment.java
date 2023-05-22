import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Component;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;

public class DisplayVacAppointment {

	JFrame frame;
	private JTable table;
	private PCVS pcvs1;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					DisplayVacAppointment window = new DisplayVacAppointment();
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
	public DisplayVacAppointment(PCVS pcvs) {
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
		layeredPane.setBounds(0, 0, 793, 563);
		frame.getContentPane().add(layeredPane);
		
		JLabel backgroundLbl = new JLabel("New label");
		backgroundLbl.setIcon(new ImageIcon("C:\\Users\\USER\\eclipse-workspace\\assignment2\\img\\background.jpg"));
		backgroundLbl.setBounds(0, 0, 797, 569);
		layeredPane.add(backgroundLbl);
		
		table = new JTable();

		DefaultTableModel daDefaultTableModel = new DefaultTableModel(0, 0);

		String[] columnNames = new String[] {"VaccinationID", "Appointment Date", "Status", "Remarks"};

		daDefaultTableModel.setColumnIdentifiers(columnNames);
		 for (int i = 0; i < pcvs1.getListOfPatient().size(); i++) {
			 for(int j = 0; j < pcvs1.getListOfPatient().get(i).getNewVaccinations().size(); j++) {
				 daDefaultTableModel.addRow(new Object[] {
						 pcvs1.getListOfPatient().get(i).getNewVaccinations().get(j).getVaccinationID(),
						 	pcvs1.getListOfPatient().get(i).getNewVaccinations().get(j).getAppointmentDate(),
						 	pcvs1.getListOfPatient().get(i).getNewVaccinations().get(j).getStatus(),
						 	pcvs1.getListOfPatient().get(i).getNewVaccinations().get(j).getRemarks()
		            });
			 }
	      } 
		//*Dummy data for Table
//		daDefaultTableModel.addRow(new Object[] {"Test1","Test2","Test3"});
//		daDefaultTableModel.addRow(new Object[] {"Test2","Test2","Test3"});
//		daDefaultTableModel.addRow(new Object[] {"Test3","Test2","Test3"});

		table.setModel(daDefaultTableModel);
		
		JScrollPane scrollPane = new JScrollPane(table);
		layeredPane.setLayer(scrollPane, 1);
		scrollPane.setBounds(28, 99, 737, 416);
		layeredPane.add(scrollPane);
		
		JLabel titleLbl = new JLabel("Display All Vaccination Appointments");
		layeredPane.setLayer(titleLbl, 1);
		titleLbl.setHorizontalAlignment(SwingConstants.CENTER);
		titleLbl.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 17));
		titleLbl.setBounds(251, 23, 290, 48);
		layeredPane.add(titleLbl);
	}
}
