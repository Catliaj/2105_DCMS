package Main;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import backend.newPatient_Backend;
import javax.swing.border.BevelBorder;
import DCMS_DB_CONNECTION.DB_DCMSConnection;
public class PatientRecord extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable PatientHistorytable;
	private JTextField Searchtxtfield;
	DB_DCMSConnection dcmsConnection = new DB_DCMSConnection();
	private Connection connection;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PatientRecord frame = new PatientRecord();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PatientRecord() {
		setTitle("PATIENT DETAILS");
		setResizable(false);
    	setVisible(true);
    	setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 870, 680);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(194, 192, 192));
		panel.setBounds(0, 0, 856, 643);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel PatientDetailslbl = new JLabel("PATIENT DETAILS:");
		PatientDetailslbl.setBounds(17, 10, 246, 60);
		PatientDetailslbl.setFont(new Font("Segoe UI", Font.BOLD, 25));
		panel.add(PatientDetailslbl);
		
		JPanel panelinfo = new JPanel();
		panelinfo.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelinfo.setBounds(290, 102, 537, 260);
		panelinfo.setBackground(new Color(165, 165, 165));
		panel.add(panelinfo);
		panelinfo.setLayout(null);
		
		JLabel DOBlbl = new JLabel("DATE OF BIRTH");
		DOBlbl.setBounds(42, 22, 178, 21);
		DOBlbl.setFont(new Font("Segoe UI", Font.BOLD, 15));
		panelinfo.add(DOBlbl);
		
		JLabel AGElbl = new JLabel("AGE");
		AGElbl.setFont(new Font("Segoe UI", Font.BOLD, 15));
		AGElbl.setBounds(359, 22, 178, 21);
		panelinfo.add(AGElbl);
		
		JLabel Emaillbl = new JLabel("EMAIL");
		Emaillbl.setFont(new Font("Segoe UI", Font.BOLD, 15));
		Emaillbl.setBounds(42, 89, 178, 21);
		panelinfo.add(Emaillbl);
		
		JLabel Addresslbl = new JLabel("ADDRESS");
		Addresslbl.setFont(new Font("Segoe UI", Font.BOLD, 15));
		Addresslbl.setBounds(42, 169, 178, 21);
		panelinfo.add(Addresslbl);
		
		JLabel Genderlbl = new JLabel("GENDER");
		Genderlbl.setFont(new Font("Segoe UI", Font.BOLD, 15));
		Genderlbl.setBounds(359, 89, 178, 21);
		panelinfo.add(Genderlbl);
		
		JLabel Contactlbl = new JLabel("CONTACT NO.");
		Contactlbl.setFont(new Font("Segoe UI", Font.BOLD, 15));
		Contactlbl.setBounds(359, 169, 178, 21);
		panelinfo.add(Contactlbl);
		
		JTextPane DOBtextPane = new JTextPane();
		DOBtextPane.setBounds(42, 53, 286, 26);
		panelinfo.add(DOBtextPane);
		
		JTextPane AGEtextPane = new JTextPane();
		AGEtextPane.setBounds(358, 53, 52, 26);
		panelinfo.add(AGEtextPane);
		
		JTextPane EmailtextPane = new JTextPane();
		EmailtextPane.setBounds(42, 120, 286, 26);
		panelinfo.add(EmailtextPane);
		
		JTextPane Gendertxtpane = new JTextPane();
		Gendertxtpane.setBounds(358, 120, 81, 26);
		panelinfo.add(Gendertxtpane);
		
		JTextPane Contacttxtpane = new JTextPane();
		Contacttxtpane.setBounds(359, 196, 147, 26);
		panelinfo.add(Contacttxtpane);
		
		JTextPane Addresstxtpane = new JTextPane();
		Addresstxtpane.setBounds(42, 196, 286, 26);
		panelinfo.add(Addresstxtpane);
		
		JLabel GenInfolbl = new JLabel("GENERAL INFORMATION");
		GenInfolbl.setBounds(290, 79, 210, 13);
		GenInfolbl.setFont(new Font("Segoe UI", Font.BOLD, 15));
		panel.add(GenInfolbl);
		
		JButton Deletebtn = new JButton("DELETE");
		Deletebtn.setForeground(new Color(194, 192, 192));
		Deletebtn.setFont(new Font("Segoe UI", Font.BOLD, 20));
		Deletebtn.setBackground(new Color(5, 59, 67));
		Deletebtn.setBounds(17, 269, 117, 34);
		panel.add(Deletebtn);
		
		JTextPane PIDtxtpane = new JTextPane();
		PIDtxtpane.setBounds(95, 222, 101, 26);
		panel.add(PIDtxtpane);
		
		JTextPane Nametxtpane = new JTextPane();
		Nametxtpane.setBounds(17, 140, 240, 72);
		panel.add(Nametxtpane);
		
		JButton Updatebtn = new JButton("UPDATE");
		Updatebtn.setForeground(new Color(194, 192, 192));
		Updatebtn.setBackground(new Color(5, 59, 67));
		Updatebtn.setFont(new Font("Segoe UI", Font.BOLD, 20));
		Updatebtn.setBounds(144, 269, 119, 34);
		panel.add(Updatebtn);
		
		JScrollPane HistoryscrollPane = new JScrollPane();
		HistoryscrollPane.setBounds(17, 406, 802, 218);
		panel.add(HistoryscrollPane);
		
		PatientHistorytable = new JTable();
		PatientHistorytable.setBackground(new Color(226, 224, 224));
		PatientHistorytable.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		PatientHistorytable.setModel(new DefaultTableModel(
			new Object[][] {},
			new String[] {
				"DATE", "TIME", "TREATMENT", "REMARKS"
			}
		));
		
		   // Set row height and column widths
        PatientHistorytable.setRowHeight(30); // Set to a larger value as needed
        PatientHistorytable.getColumnModel().getColumn(0).setPreferredWidth(100); // Patient ID
        PatientHistorytable.getColumnModel().getColumn(1).setPreferredWidth(150); // First Name
        PatientHistorytable.getColumnModel().getColumn(2).setPreferredWidth(50);  // M.I
        PatientHistorytable.getColumnModel().getColumn(3).setPreferredWidth(150); // Last Name
        
		HistoryscrollPane.setViewportView(PatientHistorytable);
		
		JLabel PatientHistorylbl = new JLabel("PATIENT HISTORY");
		PatientHistorylbl.setFont(new Font("Segoe UI", Font.BOLD, 20));
		PatientHistorylbl.setBounds(19, 370, 244, 26);
		panel.add(PatientHistorylbl);
		
		JPanel Searchpanel = new JPanel();
		Searchpanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		Searchpanel.setBackground(new Color(149, 149, 149));
		Searchpanel.setBounds(639, 25, 188, 45);
		panel.add(Searchpanel);
		Searchpanel.setLayout(null);
		
		Searchtxtfield = new JTextField();
		Searchtxtfield.setFont(new Font("Segoe UI", Font.BOLD, 12));
		Searchtxtfield.setBackground(new Color(215, 213, 213));
		Searchtxtfield.setBounds(48, 9, 130, 27);
		Searchpanel.add(Searchtxtfield);
		Searchtxtfield.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(10, -33, 45, 110);
		Searchpanel.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(PatientRecord.class.getResource("/Resources/people.png")));
		
		JLabel Searchlbl = new JLabel("SEARCH ID:");
		Searchlbl.setFont(new Font("Segoe UI", Font.BOLD, 15));
		Searchlbl.setBounds(548, 35, 101, 26);
		panel.add(Searchlbl);
		
		Searchtxtfield.addActionListener(e -> {
		    String searchID = Searchtxtfield.getText().trim();
		    if (!searchID.isEmpty()) {
		        newPatient_Backend backend = new newPatient_Backend();
		        String[] patientDetails = backend.getPatientByID(searchID);

		        if (patientDetails != null) {
		            // Populate text panes with retrieved data
		            PIDtxtpane.setText(patientDetails[0]);      
		            Nametxtpane.setText(patientDetails[1] + " " + patientDetails[2] + " " + patientDetails[3]); 
		            DOBtextPane.setText(patientDetails[4]);     
		            AGEtextPane.setText(patientDetails[5]);     
		            Gendertxtpane.setText(patientDetails[6]);  
		            EmailtextPane.setText(patientDetails[7]);   
		            Addresstxtpane.setText(patientDetails[8]);  
		            Contacttxtpane.setText(patientDetails[9]);  
		        } else {
		            JOptionPane.showMessageDialog(this, "No patient found with ID: " + searchID);
		        }
		    } else {
		        JOptionPane.showMessageDialog(this, "Please enter a Patient ID.");
		    }
		});
		
		Updatebtn.addActionListener(e -> {
		    String patientID = PIDtxtpane.getText().trim();
		    String firstName = Nametxtpane.getText().split(" ")[0].trim(); // Assuming the Name field holds full name
		    String middleInitial = Nametxtpane.getText().split(" ").length > 1 ? Nametxtpane.getText().split(" ")[1].trim() : "";
		    String lastName = Nametxtpane.getText().split(" ").length > 2 ? Nametxtpane.getText().split(" ")[2].trim() : "";
		    String dob = DOBtextPane.getText().trim();
		    String age = AGEtextPane.getText().trim();
		    String gender = Gendertxtpane.getText().trim();
		    String email = EmailtextPane.getText().trim();
		    String address = Addresstxtpane.getText().trim();
		    String contactNumber = Contacttxtpane.getText().trim();

		    if (patientID.isEmpty() || firstName.isEmpty() || lastName.isEmpty()) {
		        JOptionPane.showMessageDialog(this, "Patient ID, First Name, and Last Name are required to update!");
		        return;
		    }

		    newPatient_Backend backend = new newPatient_Backend();
		    int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this patient record?", "Confirm Deletion", JOptionPane.YES_NO_OPTION);

		    if (confirm == JOptionPane.YES_OPTION) {
            	boolean isUpdated = backend.updatePatientData(patientID, firstName, middleInitial, lastName, dob, age, gender, email, address, contactNumber);

            	if (isUpdated) {
            		JOptionPane.showMessageDialog(this, "Patient details updated successfully!");
            	} else {
            		JOptionPane.showMessageDialog(this, "Failed to update patient details. Please try again.");
		    }
        	}
		});
		
		Deletebtn.addActionListener(e -> {
		    String patientID = PIDtxtpane.getText().trim();

		    if (patientID.isEmpty()) {
		        JOptionPane.showMessageDialog(this, "Please enter a valid Patient ID to delete.");
		        return;
		    }

		    newPatient_Backend backend = new newPatient_Backend();
		    int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this patient record?", "Confirm Deletion", JOptionPane.YES_NO_OPTION);

		    if (confirm == JOptionPane.YES_OPTION) {
		        boolean isDeleted = backend.deletePatientByID(patientID);

		        if (isDeleted) {
		            JOptionPane.showMessageDialog(this, "Patient record deleted successfully!");
		            // Clear text fields after deletion
		            PIDtxtpane.setText("");
		            Nametxtpane.setText("");
		            DOBtextPane.setText("");
		            AGEtextPane.setText("");
		            Gendertxtpane.setText("");
		            EmailtextPane.setText("");
		            Addresstxtpane.setText("");
		            Contacttxtpane.setText("");
		            // Optionally refresh table or UI
		        } else {
		            JOptionPane.showMessageDialog(this, "Failed to delete patient record. Please try again.");
		        }
		    }
		});


	}

}
