package Main;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import com.jgoodies.common.format.EmptyDateFormat;
import java.text.DateFormat;
import javax.swing.JButton;
import javax.swing.ImageIcon;

<<<<<<< HEAD
public class AppointmentForm extends JFrame {
=======
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;
import backend.ApointmentForm_backend;
>>>>>>> 8849290242e9b16d165e43b87ed0b89541756c44

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField NameTxtField;
	private JTextField EmailTxtField;
	private JTextField CotactTxtField;

<<<<<<< HEAD
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
		
		JDateChooser dateChooser = new JDateChooser();
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
		JComboBox<String> hourComboBox = new JComboBox<>(hours);
		hourComboBox.setFont(new Font("Segoe UI", Font.BOLD, 10));
		hourComboBox.setBounds(227, 329, 50, 27);
		panel.add(hourComboBox);
		
		// Minute dropdown (00 to 59)
		String[] minutes = {"01","02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
							"21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40",
							"41", "42", "43", "44","45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59"};
		JComboBox<String> minuteComboBox = new JComboBox<>(minutes);
		minuteComboBox.setFont(new Font("Segoe UI", Font.BOLD, 10));
		minuteComboBox.setBounds(287, 329, 50, 27);
		panel.add(minuteComboBox);
		
		// AM/PM dropdown
		String[] amPm = {"AM", "PM"};
		JComboBox<String> amPmComboBox = new JComboBox<>(amPm);
		amPmComboBox.setFont(new Font("Segoe UI", Font.BOLD, 10));
		amPmComboBox.setBounds(347, 329, 60, 27);
		panel.add(amPmComboBox);
		
		//Reason of Booking dropdown
		String[] Reason = {"Consultation", "Braces", "Crowns", "Bridges", "Cleaning", "Dentures", "Extraction", "Fillings", "Implants", "Root Canal", "Teeth Whitening", "Veneers", "X-Ray", "Pediatric Dentistry"};
		JComboBox<String> ReasoncomboBox = new JComboBox<>(Reason);
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
		panel.add(BookApptbtn);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\ARAVHEIYL FELICISIMO\\Downloads\\PopupBackg.png"));
		lblNewLabel.setBounds(0, 0, 436, 539);
		panel.add(lblNewLabel);
	}
=======
public class AppointmentForm implements ActionListener 
{
	ApointmentForm_backend backend = new ApointmentForm_backend();
    JFrame AppointmentForm = new JFrame("DCF Dental Clinic");
    JButton scheduleBtn = new JButton("SCHEDULE APPOINTMENT");
    JPanel content = new BackgroundPanel("/Resources/Background (2).png");

    JButton homeBtn = new JButton("HOME");
    JButton aboutUsBtn = new JButton("ABOUT US");
    JButton servicesBtn = new JButton("SERVICES");
    JButton productsBtn = new JButton("PRODUCTS");
    JButton contactUsBtn = new JButton("CONTACT US");
    JButton feedbackBtn = new JButton("FEEDBACK");
    JPanel header = new JPanel();

    JTextField nameField = new JTextField(20);
    JTextField emailField = new JTextField(20);
    JTextField phoneNumberField = new JTextField(20);

    JComboBox<String> monthDropdown, dayDropdown, yearDropdown;

    JComboBox<String> hourDropdown, minuteDropdown, amPmDropdown;
    JComboBox<String> reasonDropdown;

    JLabel messageLabel = new JLabel("");
    JPanel footer = new JPanel();
    JLabel dateTimeLabel = new JLabel();

    AppointmentForm() 
    {
        // Frame setup
        ImageIcon image = new ImageIcon(getClass().getResource("/Resources/DCFlogo.png"));
        AppointmentForm.setIconImage(image.getImage());
        AppointmentForm.setLayout(new BorderLayout());
        AppointmentForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        AppointmentForm.setSize(1440, 1024);

        // Header setup
        header.setLayout(new BorderLayout());
        header.setPreferredSize(new Dimension(100, 100));
        header.setBackground(new Color(5, 59, 67));

        ImageIcon headerLogo = new ImageIcon(getClass().getResource("/Resources/haederLogo.png"));
        Image scaledHeader = headerLogo.getImage().getScaledInstance(250, 150, Image.SCALE_SMOOTH);
        JLabel Header = new JLabel(new ImageIcon(scaledHeader));

        JPanel logoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        logoPanel.setBackground(new Color(5, 59, 67));
        logoPanel.add(Header);
        header.add(logoPanel, BorderLayout.WEST);

        JPanel navPanel = new JPanel(new GridLayout(1, 6, 10, 0)); 
        navPanel.setBackground(new Color(5, 59, 67));

        setButtonStyles(homeBtn);
        setButtonStyles(aboutUsBtn);
        setButtonStyles(servicesBtn);
        setButtonStyles(productsBtn);
        setButtonStyles(contactUsBtn);
        setButtonStyles(feedbackBtn);

        navPanel.add(homeBtn);
        navPanel.add(aboutUsBtn);
        navPanel.add(servicesBtn);
        navPanel.add(productsBtn);
        navPanel.add(contactUsBtn);
        navPanel.add(feedbackBtn);

        header.add(navPanel, BorderLayout.CENTER);
        AppointmentForm.add(header, BorderLayout.NORTH);

        // Content area
        content.setLayout(new GridBagLayout());  
        content.setBackground(new Color(5, 59, 67)); 

        // Form setup
        JPanel formPanel = new JPanel();
        formPanel.setPreferredSize(new Dimension(500, 600));
        formPanel.setBackground(Color.WHITE);  
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));  
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel("APPOINTMENT REQUEST FORM");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        formPanel.add(titleLabel);

        formPanel.add(createFormField("NAME", nameField));
        formPanel.add(createFormField("EMAIL", emailField));
        formPanel.add(createFormField("PHONE NUMBER", phoneNumberField));
        formPanel.add(createDateDropdown());  // Added Date Dropdown

        formPanel.add(createTimeDropdown());

        String[] reasons = {
            "General Checkup", "Emergency", "Teeth Cleaning", "Orthodontics", "Cosmetic Dentistry", 
            "Root Canal", "Dental Surgery", "Cavity Filling", "Teeth Whitening", "Braces", 
            "Periodontal Care", "Consultation", "Other"
        };
        reasonDropdown = new JComboBox<>(reasons);
        formPanel.add(createDropdownField("REASON", reasonDropdown, reasons));


        scheduleBtn.setFont(new Font("Arial", Font.BOLD, 18));
        scheduleBtn.setForeground(Color.WHITE);
        scheduleBtn.setBackground(new Color(5, 59, 67));  
        scheduleBtn.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        scheduleBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        scheduleBtn.addActionListener(this);
        formPanel.add(Box.createVerticalStrut(20));  
        formPanel.add(scheduleBtn);

        messageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        formPanel.add(messageLabel);

        content.add(formPanel);
        AppointmentForm.add(content, BorderLayout.CENTER);

        // Footer setup
        footer.setLayout(new BorderLayout());
        footer.setPreferredSize(new Dimension(1440, 50));
        footer.setBackground(new Color(5, 59, 67));

        Timer timer = new Timer(1000, e -> updateDateTime());
        timer.start();

        footer.add(dateTimeLabel, BorderLayout.CENTER);
        dateTimeLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        dateTimeLabel.setForeground(Color.WHITE);
        AppointmentForm.add(footer, BorderLayout.SOUTH);

        AppointmentForm.setVisible(true);
    }

    private void setButtonStyles(JButton button) {
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(5, 59, 67)); 
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
    }

    private void updateDateTime() {
        String dateTime = new SimpleDateFormat("EEEE, MMMM d, yyyy hh:mm:ss a").format(new Date());
        dateTimeLabel.setText(dateTime);
    }

    private JPanel createDateDropdown() {
        // Months
        String[] months = {
            "January", "February", "March", "April", "May", "June", 
            "July", "August", "September", "October", "November", "December"
        };
        monthDropdown = new JComboBox<>(months);

        // Days
        String[] days = new String[31];
        for (int i = 1; i <= 31; i++) days[i - 1] = String.format("%02d", i);
        dayDropdown = new JComboBox<>(days);

        // Years (Example range from 2020 to 2030)
        String[] years = new String[11];
        for (int i = 2020; i <= 2030; i++) years[i - 2020] = String.valueOf(i);
        yearDropdown = new JComboBox<>(years);

        JPanel datePanel = new JPanel();
        datePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        datePanel.setBackground(Color.WHITE);
        datePanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));  // Align with other fields

        JLabel dateLabel = new JLabel("DATE");
        dateLabel.setFont(new Font("Arial", Font.BOLD, 14));
        dateLabel.setForeground(Color.BLACK);

        datePanel.add(dateLabel);
        datePanel.add(monthDropdown);
        datePanel.add(new JLabel("/"));
        datePanel.add(dayDropdown);
        datePanel.add(new JLabel("/"));
        datePanel.add(yearDropdown);

        return datePanel;
    }

    private JPanel createTimeDropdown() {
        String[] hours = new String[12];
        for (int i = 1; i <= 12; i++) hours[i - 1] = String.format("%02d", i);

        String[] minutes = new String[60];
        for (int i = 0; i < 60; i++) minutes[i] = String.format("%02d", i);

        String[] amPmOptions = {"AM", "PM"};
        hourDropdown = new JComboBox<>(hours);
        minuteDropdown = new JComboBox<>(minutes);
        amPmDropdown = new JComboBox<>(amPmOptions);

        JPanel timePanel = new JPanel();
        timePanel.setLayout(new FlowLayout(FlowLayout.LEFT));  // Align left
        timePanel.setBackground(Color.WHITE);
        timePanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));  // Align with other fields

        JLabel timeLabel = new JLabel("TIME");
        timeLabel.setFont(new Font("Arial", Font.BOLD, 14));
        timeLabel.setForeground(Color.BLACK);

        timePanel.add(timeLabel);
        timePanel.add(hourDropdown);
        timePanel.add(new JLabel(":"));
        timePanel.add(minuteDropdown);
        timePanel.add(amPmDropdown);

        return timePanel;
    }

    private JPanel createFormField(String labelText, JTextField textField) {
        JPanel fieldPanel = new JPanel();
        fieldPanel.setLayout(new BorderLayout());
        fieldPanel.setBackground(Color.WHITE);

        JLabel label = new JLabel(labelText);
        label.setFont(new Font("Arial", Font.BOLD, 14));
        label.setForeground(Color.BLACK);

        textField.setPreferredSize(new Dimension(300, 30));
        textField.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));

        fieldPanel.add(label, BorderLayout.NORTH);
        fieldPanel.add(textField, BorderLayout.CENTER);
        fieldPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));  

        return fieldPanel;
    }

    private JPanel createDropdownField(String labelText, JComboBox<String> dropdown, String[] options) {
        JPanel fieldPanel = new JPanel();
        fieldPanel.setLayout(new BorderLayout());
        fieldPanel.setBackground(Color.WHITE);

        JLabel label = new JLabel(labelText);
        label.setFont(new Font("Arial", Font.BOLD, 14));
        label.setForeground(Color.BLACK);

        dropdown.setPreferredSize(new Dimension(300, 30));
        dropdown.setBackground(Color.WHITE);
        dropdown.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));

        fieldPanel.add(label, BorderLayout.NORTH);
        fieldPanel.add(dropdown, BorderLayout.CENTER);
        fieldPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));  

        return fieldPanel;
    }
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if (e.getSource() == scheduleBtn) 
        {          
            backend.setName(nameField.getText());
            backend.setEmail(emailField.getText());
            backend.setPhoneNumber(phoneNumberField.getText());
            backend.setDate((String) monthDropdown.getSelectedItem() + " " + 
                    		(String) dayDropdown.getSelectedItem() + ", " + 
                    		yearDropdown.getSelectedItem());
            backend.setTime((String) hourDropdown.getSelectedItem() + ":" + 
                    		(String) minuteDropdown.getSelectedItem() + " " + 
                    		amPmDropdown.getSelectedItem());
            backend.setReason((String) reasonDropdown.getSelectedItem());
            try 
            {               	
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection
                (
                    "jdbc:mysql://localhost:3306/dcfdentalclinicdb", 
                    "admin", 
                    "admin"
                );
                
                PreparedStatement ps = con.prepareStatement("INSERT INTO appointments (Name, Email, PhoneNumber, Date, Time, Reason) VALUES (?, ?, ?, ?, ?, ?)");
                ps.setString(1, backend.getName());
                ps.setString(2, backend.getEmail());
                ps.setString(3, backend.getPhoneNumber());
                ps.setString(4, backend.getDate());
                ps.setString(5, backend.getTime());
                ps.setString(6, backend.getReason());
                int rowsAffected = ps.executeUpdate();

                if (rowsAffected > 0) 
                {
                    messageLabel.setText("Appointment scheduled successfully!");
                    AppointmentForm.dispose();
                } 
                else 
                {
                    messageLabel.setText("Failed to schedule appointment. Please try again.");
                }

            } 
            catch (Exception ex) 
            {
                ex.printStackTrace(); 
                messageLabel.setText("Error: " + ex.getMessage());
            }
        } 
        else if (e.getSource() == homeBtn) 
        {
            AppointmentForm.dispose();
            new homePage();
        } 
        else if (e.getSource() == aboutUsBtn) 
        {
            AppointmentForm.dispose();
            new aboutUs();
        }


    }

    class BackgroundPanel extends JPanel 
    {
        private Image backgroundImage;
        public BackgroundPanel(String imagePath) 
        {
            backgroundImage = new ImageIcon(getClass().getResource(imagePath)).getImage();
        }

        @Override
        protected void paintComponent(Graphics g) 
        {
            super.paintComponent(g);
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
    
    public static void main(String[] args) 
    {
        new AppointmentForm();
    }
>>>>>>> 8849290242e9b16d165e43b87ed0b89541756c44
}
