package Main;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import backend.ApointmentForm_backend;
import backend.newPatient_Backend;

import javax.swing.border.BevelBorder;

public class PatientRecord extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable PatientHistorytable;
	private JTextPane DOBtextPane;
	private	JTextPane AGEtextPane;
	private	JTextPane EmailtextPane;
	private	JTextPane Gendertxtpane;
	private	JTextPane Contacttxtpane;
	private	JTextPane Addresstxtpane;
	private	JTextPane PIDtxtpane;
	private	JTextPane Nametxtpane;
	private JButton Deletebtn;
	

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
		panelinfo.setBounds(289, 63, 537, 260);
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
		
	    DOBtextPane = new JTextPane();
	    DOBtextPane.setFont(new Font("Segoe UI", Font.BOLD, 15));
		DOBtextPane.setBounds(42, 53, 286, 26);
		panelinfo.add(DOBtextPane);
		
	    AGEtextPane = new JTextPane();
	    AGEtextPane.setFont(new Font("Segoe UI", Font.BOLD, 15));
		AGEtextPane.setBounds(358, 53, 52, 26);
		panelinfo.add(AGEtextPane);
		
	    EmailtextPane = new JTextPane();
	    EmailtextPane.setFont(new Font("Segoe UI", Font.BOLD, 15));
		EmailtextPane.setBounds(42, 120, 286, 26);
		panelinfo.add(EmailtextPane);
		
	    Gendertxtpane = new JTextPane();
	    Gendertxtpane.setFont(new Font("Segoe UI", Font.BOLD, 15));
		Gendertxtpane.setBounds(358, 120, 81, 26);
		panelinfo.add(Gendertxtpane);
		
	    Contacttxtpane = new JTextPane();
	    Contacttxtpane.setFont(new Font("Segoe UI", Font.BOLD, 15));
		Contacttxtpane.setBounds(359, 196, 147, 26);
		panelinfo.add(Contacttxtpane);
		
	    Addresstxtpane = new JTextPane();
	    Addresstxtpane.setFont(new Font("Segoe UI", Font.BOLD, 15));
		Addresstxtpane.setBounds(42, 196, 286, 26);
		panelinfo.add(Addresstxtpane);
		
		JLabel GenInfolbl = new JLabel("GENERAL INFORMATION");
		GenInfolbl.setBounds(289, 40, 210, 13);
		GenInfolbl.setFont(new Font("Segoe UI", Font.BOLD, 15));
		panel.add(GenInfolbl);
		
	    Deletebtn = new JButton("DELETE");
		Deletebtn.setForeground(new Color(194, 192, 192));
		Deletebtn.setFont(new Font("Segoe UI", Font.BOLD, 20));
		Deletebtn.setBackground(new Color(5, 59, 67));
		Deletebtn.setBounds(17, 242, 117, 34);
		Deletebtn.addActionListener(this);
		panel.add(Deletebtn);
		
	    PIDtxtpane = new JTextPane();
	    PIDtxtpane.setBackground(new Color(255, 255, 255));
	    PIDtxtpane.setFont(new Font("Segoe UI", Font.BOLD, 15));
		PIDtxtpane.setBounds(132, 184, 25, 26);
		panel.add(PIDtxtpane);
		
	    Nametxtpane = new JTextPane();
	    Nametxtpane.setBackground(new Color(255, 255, 255));
	    Nametxtpane.setFont(new Font("Segoe UI", Font.BOLD, 20));
		Nametxtpane.setBounds(25, 123, 238, 34);
		panel.add(Nametxtpane);
		
		JButton Updatebtn = new JButton("UPDATE");
		Updatebtn.setForeground(new Color(194, 192, 192));
		Updatebtn.setBackground(new Color(5, 59, 67));
		Updatebtn.setFont(new Font("Segoe UI", Font.BOLD, 20));
		Updatebtn.setBounds(144, 242, 119, 34);
		panel.add(Updatebtn);
		
		JScrollPane HistoryscrollPane = new JScrollPane();
		HistoryscrollPane.setBounds(17, 373, 802, 251);
		panel.add(HistoryscrollPane);
		
		PatientHistorytable = new JTable();
		PatientHistorytable.setBackground(new Color(226, 224, 224));
		PatientHistorytable.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		PatientHistorytable.setModel(new DefaultTableModel(
			new Object[][] {
			},
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
		PatientHistorylbl.setBounds(17, 337, 244, 26);
		panel.add(PatientHistorylbl);
		
		JLabel lblName = new JLabel("NAME");
		lblName.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblName.setBounds(25, 102, 178, 21);
		panel.add(lblName);
		
		JLabel lblPatientId = new JLabel("PATIENT ID");
		lblPatientId.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblPatientId.setBounds(106, 163, 178, 21);
		panel.add(lblPatientId);
		
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
		    
		    int confirm = JOptionPane.showConfirmDialog(null, "Do you want to Update this patient?", "Confirm Update", JOptionPane.YES_NO_OPTION);

		    if (confirm == JOptionPane.YES_OPTION) {
		    	 boolean isUpdated = backend.updatePatientData(patientID, firstName, middleInitial, lastName, dob, age, gender, email, address, contactNumber);
				    if (isUpdated) {
				        JOptionPane.showMessageDialog(this, "Patient details updated successfully!");
				    } else {
				        JOptionPane.showMessageDialog(this, "Failed to update patient details. Please try again.");
				    }
		    }
		});


	}
	
	
	public PatientRecord(String patientID) {
	    this(); // Call the default constructor to set up the UI

	    if (patientID != null && !patientID.isEmpty()) {
	        populatePatientDetails(patientID); // Populate fields with patient data
	    } else {
	        JOptionPane.showMessageDialog(this, "Invalid Patient ID provided.");
	    }
	}

	// Method to populate fields based on patient ID
	private void populatePatientDetails(String patientID) {
	    newPatient_Backend backend = new newPatient_Backend();
	    String[] patientDetails = backend.getPatientByID(patientID);

	    if (patientDetails != null) {
	        PIDtxtpane.setText(patientDetails[0]);      
	        Nametxtpane.setText(patientDetails[1] + " " + patientDetails[2] + " " + patientDetails[3]); 
	        DOBtextPane.setText(patientDetails[4]);     
	        AGEtextPane.setText(patientDetails[5]);     
	        Gendertxtpane.setText(patientDetails[6]);  
	        EmailtextPane.setText(patientDetails[7]);   
	        Addresstxtpane.setText(patientDetails[8]);  
	        Contacttxtpane.setText(patientDetails[9]);  
	    } else {
	        JOptionPane.showMessageDialog(this, "No patient data found for ID: " + patientID);
	    }
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	    if (e.getSource() == Deletebtn) {
	        // Get patient ID from the form
	        String patientID = PIDtxtpane.getText().trim();

	        if (patientID.isEmpty()) {
	            JOptionPane.showMessageDialog(this, "Patient ID is required for deletion.");
	            return;
	        }

	        // Ask for confirmation before deleting
	        int confirm = JOptionPane.showConfirmDialog(this, 
	            "Are you sure you want to delete this patient?", 
	            "Confirm Deletion", 
	            JOptionPane.YES_NO_OPTION);

	        if (confirm == JOptionPane.YES_OPTION) {
	            // Call deletePatient method to remove the patient from the database
	            deletePatient(patientID);
	        }
	    }
	}

	private void deletePatient(String patientID) {
	    newPatient_Backend backend = new newPatient_Backend();
	    boolean isDeleted = backend.deletePatientByID(patientID); // Call the backend method

	    if (isDeleted) {
	        JOptionPane.showMessageDialog(this, "Patient deleted successfully!");
	        dispose(); // Close the form after successful deletion
	    } else {
	        JOptionPane.showMessageDialog(this, "Failed to delete patient. Please try again.");
	    }
	}


	
}






