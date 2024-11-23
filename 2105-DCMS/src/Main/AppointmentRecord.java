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
	
	public AppointmentRecord() {
		setResizable(false);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 576);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(194, 192, 192));
		panel.setBounds(0, 0, 436, 539);
		contentPane.add(panel);
		panel.setLayout(null);
		
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
		ReasoncomboBox.setBounds(51, 408, 333, 27);
		panel.add(ReasoncomboBox);
		
		JLabel RsnBookingLabel = new JLabel("REASON OF YOUR BOOKING:");
		RsnBookingLabel.setFont(new Font("Segoe UI", Font.BOLD, 15));
		RsnBookingLabel.setBounds(51, 385, 327, 13);
		panel.add(RsnBookingLabel);
		
		JButton btnNewButton = new JButton("DELETE");
		btnNewButton.setForeground(new Color(194, 192, 192));
		btnNewButton.setBackground(new Color(5, 59, 67));
		btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnNewButton.setBounds(71, 464, 125, 40);
		panel.add(btnNewButton);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.setForeground(new Color(194, 192, 192));
		btnUpdate.setBackground(new Color(5, 59, 67));
		btnUpdate.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnUpdate.setBounds(234, 464, 125, 40);
		panel.add(btnUpdate);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(AppointmentForm.class.getResource("/Resources/PopupBackg.png")));
		lblNewLabel.setBounds(0, 0, 436, 539);
		panel.add(lblNewLabel);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
	    if (e.getActionCommand().equals("BOOK APPOINTMENT")) {
	    	
	    	String name = NameTxtField.getText();
	    	String email = EmailTxtField.getText();
	    	String PhoneNumber = CotactTxtField.getText();
	    	String reason = (String) ReasoncomboBox.getSelectedItem();
	    	SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM dd, yyyy");
	    	String date = (dateChooser.getDate() != null) ? dateFormat.format(dateChooser.getDate()): "Not Selected";
	        String hour = (String) hourComboBox.getSelectedItem();
	        String minute = (String) minuteComboBox.getSelectedItem();
	        String amPm = (String) amPmComboBox.getSelectedItem();
	        String time = hour + ":" + minute + " " + amPm;
	      
		    int confirm = JOptionPane.showConfirmDialog(null, "Do you want to book this patient?", "Confirm Deletion", JOptionPane.YES_NO_OPTION);

		    if (confirm == JOptionPane.YES_OPTION) {
	        new ApointmentForm_backend(name,email,PhoneNumber,date,time,reason);
		    }
	    }
	}

}
