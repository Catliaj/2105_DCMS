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
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import java.text.SimpleDateFormat;
import com.jgoodies.common.format.EmptyDateFormat;
import java.text.DateFormat;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import DCMS_DB_CONNECTION.DB_DCMSConnection;
import backend.ApointmentForm_backend;
import backend.newPatient_Backend;

import java.sql.*;

public class AppointmentRecord extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField NameTxtField;
	private JTextField EmailTxtField;
	private JTextField CotactTxtField;
	private JDateChooser dateChooser;
	private JComboBox<String> hourComboBox;
	private JComboBox<String> minuteComboBox;
	private JComboBox<String> amPmComboBox;
	private JComboBox<String> ReasoncomboBox;
	private JComboBox<String> StatusBox;
	private JButton btnUpdate;
	 private String appointmentID;
	private JButton btnDeleteButton;
	private JButton addbuton;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppointmentRecord frame = new AppointmentRecord();
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
	ApointmentForm_backend backend =new ApointmentForm_backend();
    public AppointmentRecord(String appointmentID, String name, String date, String time, 
            String reason, String phone, String email, String status) {
    	this(); // Call default constructor to set up UI
	this.appointmentID = appointmentID; // Set appointment ID
	populateAppointmentDetails(name, date, time, reason, phone, email, status);
}
	
	public AppointmentRecord() {
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 576);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setVisible(true);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(194, 192, 192));
		panel.setBounds(0, 0, 436, 539);
		contentPane.add(panel);
		panel.setLayout(null);
		
	    addbuton = new JButton("ADD");
		addbuton.setForeground(new Color(194, 192, 192));
		addbuton.setFont(new Font("Segoe UI", Font.BOLD, 15));
		addbuton.setBackground(new Color(5, 59, 67));
		addbuton.setBounds(301, 489, 125, 40);
		addbuton.addActionListener(this);
		
		JLabel lblStatus = new JLabel("STATUS:");
		lblStatus.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblStatus.setBounds(51, 424, 327, 13);
		panel.add(lblStatus);
		panel.add(addbuton);
		
		JLabel ApptFormLabel = new JLabel("APPOINTMENT ");
		ApptFormLabel.setFont(new Font("Segoe UI", Font.BOLD, 30));
		ApptFormLabel.setBounds(113, 26, 251, 46);
		panel.add(ApptFormLabel);
		
		NameTxtField = new JTextField();
		NameTxtField.setBounds(51, 114, 333, 27);
		panel.add(NameTxtField);
		NameTxtField.setColumns(10);
		
		JLabel NameLabel = new JLabel("NAME");
		NameLabel.setFont(new Font("Segoe UI", Font.BOLD, 15));
		NameLabel.setBounds(51, 91, 45, 13);
		panel.add(NameLabel);
		
		EmailTxtField = new JTextField();
		EmailTxtField.setColumns(10);
		EmailTxtField.setBounds(51, 187, 333, 27);
		panel.add(EmailTxtField);
		
		
		
		JLabel EmailLabel = new JLabel("EMAIL");
		EmailLabel.setFont(new Font("Segoe UI", Font.BOLD, 15));
		EmailLabel.setBounds(51, 164, 85, 13);
		panel.add(EmailLabel);
		
		CotactTxtField = new JTextField();
		CotactTxtField.setColumns(10);
		CotactTxtField.setBounds(119, 257, 213, 27);
		panel.add(CotactTxtField);
		
		JLabel ContactLabel = new JLabel("CONTACT NO.");
		ContactLabel.setFont(new Font("Segoe UI", Font.BOLD, 15));
		ContactLabel.setBounds(119, 234, 102, 13);
		panel.add(ContactLabel);
		
	    dateChooser = new JDateChooser();
		dateChooser.setBounds(29, 329, 157, 27);
		panel.add(dateChooser);
		
		JLabel DateLabel = new JLabel("DATE");
		DateLabel.setFont(new Font("Segoe UI", Font.BOLD, 15));
		DateLabel.setBounds(29, 304, 102, 13);
		panel.add(DateLabel);
		
		// Time dropdowns
		JLabel TimeLabel = new JLabel("TIME");
		TimeLabel.setFont(new Font("Segoe UI", Font.BOLD, 15));
		TimeLabel.setBounds(227, 304, 102, 13);
		panel.add(TimeLabel);
		
		// Hour dropdown (1 to 12)
		String[] hours = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
		hourComboBox = new JComboBox<>(hours);
		hourComboBox.setFont(new Font("Segoe UI", Font.BOLD, 10));
		hourComboBox.setBounds(227, 329, 50, 27);
		panel.add(hourComboBox);
		
		// Minute dropdown (00 to 59)
		String[] minutes = {"00","01","02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
							"21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40",
							"41", "42", "43", "44","45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59","00"};
		minuteComboBox = new JComboBox<>(minutes);
		minuteComboBox.setFont(new Font("Segoe UI", Font.BOLD, 10));
		minuteComboBox.setBounds(287, 329, 50, 27);
		panel.add(minuteComboBox);
		
		// AM/PM dropdown
		String[] amPm = {"AM", "PM"};
		amPmComboBox = new JComboBox<>(amPm);
		amPmComboBox.setFont(new Font("Segoe UI", Font.BOLD, 10));
		amPmComboBox.setBounds(347, 329, 60, 27);
		panel.add(amPmComboBox);
		
		//Reason of Booking dropdown
		String[] Reason = {"Consultation", "Braces", "Crowns", "Bridges", "Cleaning", "Dentures", "Extraction", "Fillings", "Implants", "Root Canal", "Teeth Whitening", "Veneers", "X-Ray", "Pediatric Dentistry"};
	    ReasoncomboBox = new JComboBox<>(Reason);
		ReasoncomboBox.setFont(new Font("Segoe UI", Font.BOLD, 15));
		ReasoncomboBox.setBounds(51, 387, 333, 27);
		panel.add(ReasoncomboBox);
		
		
		String[] Status = {"In Progress", "Done", "Cancelled"};
		StatusBox = new JComboBox<>(Status);
		StatusBox.setFont(new Font("Segoe UI", Font.BOLD, 15));
		StatusBox.setBounds(51, 441, 333, 27);
		panel.add(StatusBox);
		
		JLabel RsnBookingLabel = new JLabel("REASON OF YOUR BOOKING:");
		RsnBookingLabel.setFont(new Font("Segoe UI", Font.BOLD, 15));
		RsnBookingLabel.setBounds(51, 366, 327, 13);
		panel.add(RsnBookingLabel);
		
	    btnDeleteButton = new JButton("DELETE");
	    btnDeleteButton.setForeground(new Color(194, 192, 192));
	    btnDeleteButton.setBackground(new Color(5, 59, 67));
	    btnDeleteButton.setFont(new Font("Segoe UI", Font.BOLD, 15));
	    btnDeleteButton.setBounds(11, 489, 125, 40);
	    btnDeleteButton.addActionListener(this);
		panel.add(btnDeleteButton);
		
	    btnUpdate = new JButton("UPDATE");
		btnUpdate.setForeground(new Color(194, 192, 192));
		btnUpdate.setBackground(new Color(5, 59, 67));
		btnUpdate.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnUpdate.setBounds(152, 489, 125, 40);
		btnUpdate.addActionListener(this);
		panel.add(btnUpdate);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(AppointmentForm.class.getResource("/Resources/PopupBackg.png")));
		lblNewLabel.setBounds(0, 0, 436, 539);
		panel.add(lblNewLabel);
	}
	

		@Override
		public void actionPerformed(ActionEvent e) {
		    if (e.getSource() == addbuton) {
		        // Collect data from the form
		        String fullName = NameTxtField.getText().trim();
		        String[] nameParts = fullName.split(" "); // Split the name based on spaces

		        String firstName = nameParts[0];  // First Name
		        String middleInitial = nameParts.length > 1 ? nameParts[1] : "";  // Middle Initial
		        String lastName = nameParts.length > 2 ? nameParts[2] : "";  // Last Name

		        String email = EmailTxtField.getText().trim();
		        String phone = CotactTxtField.getText().trim();
		        String reason = (String) ReasoncomboBox.getSelectedItem();
		        String status = (String) StatusBox.getSelectedItem();
		        // Format the date
		        SimpleDateFormat dateFormat = new SimpleDateFormat("yy,MM,dd");
		        String date = (dateChooser.getDate() != null) ? dateFormat.format(dateChooser.getDate()) : "Not Selected";

		        // Format time
		        String hour = (String) hourComboBox.getSelectedItem();
		        String minute = (String) minuteComboBox.getSelectedItem();
		        String amPm = (String) amPmComboBox.getSelectedItem();
		        String time = hour + ":" + minute + " " + amPm;

		        // Confirm before saving the data
		        int confirm = JOptionPane.showConfirmDialog(null, "Do you want to book this appointment?", "Confirm Appointment", JOptionPane.YES_NO_OPTION);

		        if (confirm == JOptionPane.YES_OPTION) {
		            // Check if the patient already exists based on phone number or email
		            newPatient_Backend patientBackend = new newPatient_Backend();
		            String patientID = patientBackend.getPatientIDByContact(phone); // Or use email for lookup

		            // If the patient doesn't exist, add a new patient
		            if (patientID == null) {
		                patientID = patientBackend.addNewPatient(firstName, middleInitial, lastName, email, phone);  // Save full patient data
		            }

		            // Add the appointment
		            ApointmentForm_backend backend = new ApointmentForm_backend();
		            boolean appointmentAdded = backend.addNewAppointment(patientID, date, time, reason,status);

		            if (appointmentAdded) {
		                JOptionPane.showMessageDialog(null, "Appointment booked successfully!");
		            } else {
		                JOptionPane.showMessageDialog(null, "Failed to book the appointment. Please try again.");
		            }
		        }
		    }
		    // Handle update and delete
		    else if (e.getSource() == btnUpdate) {
		        updateAppointmentDetails();
		    }
		    else if (e.getSource() == btnDeleteButton) {
		        deleteAppointment(appointmentID);
		    }
		}


	 

	
		private void populateAppointmentDetails(String name, String date, String time, 
	             String reason, String phone, String email, String status) {
	    try {
	        NameTxtField.setText(name); // This will be in the form "FirstName MiddleInitial LastName"
	        EmailTxtField.setText(email);
	        CotactTxtField.setText(phone);

	        if (date != null && !date.isEmpty()) {
	            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // Adjust format as needed
	            dateChooser.setDate(dateFormat.parse(date));
	        } else {
	            dateChooser.setDate(null); // Clear the field if date is empty
	        }

	        // Parse and set the time
	        if (time != null && !time.isEmpty()) {
	            String[] timeParts = time.split(" ");
	            String[] hourMinute = timeParts[0].split(":");
	            hourComboBox.setSelectedItem(hourMinute[0]); // Hour
	            minuteComboBox.setSelectedItem(hourMinute[1]); // Minute
	            amPmComboBox.setSelectedItem(timeParts[1]); // AM/PM
	        }

	        ReasoncomboBox.setSelectedItem(reason);
	        StatusBox.setSelectedItem(status);
	    } catch (Exception e) {
	        JOptionPane.showMessageDialog(this, "Error parsing appointment details: " + e.getMessage());
	    }
	}

	
	private void updateAppointmentDetails() {
	    // Get updated data from fields
	    String name = NameTxtField.getText().trim();
	    String email = EmailTxtField.getText().trim();
	    String phoneNumber = CotactTxtField.getText().trim();
	    String reason = (String) ReasoncomboBox.getSelectedItem();
	    String status = (String) StatusBox.getSelectedItem();
	    
	    // Format date
	    String date = "";
	    try {
	        SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM dd, yyyy");
	        date = dateFormat.format(dateChooser.getDate());
	    } catch (Exception e) {
	        JOptionPane.showMessageDialog(this, "Please select a valid date.");
	        return;
	    }

	    // Format time
	    String hour = (String) hourComboBox.getSelectedItem();
	    String minute = (String) minuteComboBox.getSelectedItem();
	    String amPm = (String) amPmComboBox.getSelectedItem();
	    String time = hour + ":" + minute + " " + amPm;

	    // Validate input fields
	    if (name.isEmpty() || email.isEmpty() || phoneNumber.isEmpty() || reason.isEmpty() || date.isEmpty() || time.isEmpty() || status.isEmpty()) {
	        JOptionPane.showMessageDialog(this, "All fields are required.");
	        return;
	    }

	    // Update in the backend
	    ApointmentForm_backend backend = new ApointmentForm_backend();
	    
	    
     boolean isUpdated = backend.updateAppointment(appointmentID, name, email, phoneNumber, date, time, reason,status);

	    if (isUpdated) {
	        JOptionPane.showMessageDialog(this, "Appointment updated successfully!");
	        dispose(); // Close the form
	    } else {
	        JOptionPane.showMessageDialog(this, "Failed to update appointment. Please try again.");
	    }
	}

	private void deleteAppointment(String appointmentID) {
	    ApointmentForm_backend backend = new ApointmentForm_backend();
	    boolean isDeleted = backend.deleteAppointment(appointmentID);

	    if (isDeleted) {
	        JOptionPane.showMessageDialog(this, "Appointment deleted successfully!");
	        dispose(); // Close the form after successful deletion
	    } else {
	        JOptionPane.showMessageDialog(this, "Failed to delete appointment. Please try again.");
	    }
	}
}
