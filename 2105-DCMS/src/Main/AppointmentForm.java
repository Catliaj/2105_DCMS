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

public class AppointmentForm extends JFrame implements ActionListener{

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
					AppointmentForm frame = new AppointmentForm();
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
	DB_DCMSConnection dcmsConnection = new DB_DCMSConnection();
	ApointmentForm_backend backend =new ApointmentForm_backend();
	private Connection connection;
	public AppointmentForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 576);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(194, 192, 192));
		panel.setBounds(0, 0, 436, 539);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel ApptFormLabel = new JLabel("APPOINTMENT FORM");
		ApptFormLabel.setFont(new Font("Segoe UI", Font.BOLD, 25));
		ApptFormLabel.setBounds(88, 27, 296, 46);
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
		ReasoncomboBox.setFont(new Font("Segoe UI", Font.BOLD, 12));
		ReasoncomboBox.setBounds(51, 408, 333, 27);
		panel.add(ReasoncomboBox);
		
		JLabel RsnBookingLabel = new JLabel("REASON OF YOUR BOOKING:");
		RsnBookingLabel.setFont(new Font("Segoe UI", Font.BOLD, 15));
		RsnBookingLabel.setBounds(51, 385, 327, 13);
		panel.add(RsnBookingLabel);
		
		JButton BookApptbtn = new JButton("BOOK APPOINTMENT");
		BookApptbtn.setBackground(new Color(5, 59, 67));
		BookApptbtn.setForeground(new Color(194, 192, 192));
		BookApptbtn.setFont(new Font("Segoe UI", Font.BOLD, 20));
		BookApptbtn.setBounds(82, 465, 265, 35);
		BookApptbtn.addActionListener(this);
		panel.add(BookApptbtn);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(AppointmentForm.class.getResource("/Resources/PopupBackg.png")));
		lblNewLabel.setBounds(0, 0, 436, 539);
		panel.add(lblNewLabel);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
	    if (e.getActionCommand().equals("BOOK APPOINTMENT")) {
	    	connection = dcmsConnection.getConnection();
	    	SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM dd, yyyy");
	    	String date = (dateChooser.getDate() != null) ? dateFormat.format(dateChooser.getDate()): "Not Selected";
	        String hour = (String) hourComboBox.getSelectedItem();
	        String minute = (String) minuteComboBox.getSelectedItem();
	        String amPm = (String) amPmComboBox.getSelectedItem();
	        String time = hour + ":" + minute + " " + amPm;
	       
	        backend.setName(NameTxtField.getText());
	        backend.setEmail(EmailTxtField.getText());
	        backend.setPhoneNumber(CotactTxtField.getText());
	        backend.setDate((String)date);
	        backend.setTime((String)time);
	        backend.setReason((String) ReasoncomboBox.getSelectedItem());
            try 
            {               	
                
                PreparedStatement ps = connection.prepareStatement("INSERT INTO appointments (Name, Email, PhoneNumber, Date, Time, Reason) VALUES (?, ?, ?, ?, ?, ?)");
                ps.setString(1, backend.getName());
                ps.setString(2, backend.getEmail());
                ps.setString(3, backend.getPhoneNumber());
                ps.setString(4, backend.getDate());
                ps.setString(5, backend.getTime());
                ps.setString(6, backend.getReason());
                
                int rowsAffected = ps.executeUpdate();

                if (rowsAffected > 0) 
                {
                    JOptionPane.showMessageDialog( null, "Appointment scheduled successfully!");
                } 
                else 
                {
                    JOptionPane.showMessageDialog( null, "Failed to Feedback. Please try again.");
                }

            } 
            catch (Exception ex) 
            {
                ex.printStackTrace(); 
                JOptionPane.showMessageDialog( null,"Error: " + ex.getMessage() );
            }
	    }
	}

}
