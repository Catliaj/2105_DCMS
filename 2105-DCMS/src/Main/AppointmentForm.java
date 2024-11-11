package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;


public class AppointmentForm implements ActionListener 
{
    JFrame AppointmentForm = new JFrame("DCF Dental Clinic");
    JButton scheduleBtn = new JButton("SCHEDULE APPOINTMENT");
    JPanel content = new BackgroundPanel("/Resources/Background (2).png");

    JButton homeBtn = new JButton("HOME");
    JButton aboutUsBtn = new JButton("ABOUT US");
    JButton servicesBtn = new JButton("SERVICES");
    JButton appointmentBtn = new JButton("APPOINTMENT");
    JButton productsBtn = new JButton("PRODUCTS");
    JButton contactUsBtn = new JButton("CONTACT US");
    JButton logOutBtn = new JButton("LOG OUT");
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
        setButtonStyles(appointmentBtn);
        setButtonStyles(productsBtn);
        setButtonStyles(contactUsBtn);
        setButtonStyles(logOutBtn);

        navPanel.add(homeBtn);
        navPanel.add(aboutUsBtn);
        navPanel.add(servicesBtn);
        navPanel.add(appointmentBtn);
        navPanel.add(productsBtn);
        navPanel.add(contactUsBtn);
        navPanel.add(logOutBtn);

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

        dropdown = new JComboBox<>(options);
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
            String name = nameField.getText();
            String email = emailField.getText();
            String phoneNumber = phoneNumberField.getText();
            String date = (String) monthDropdown.getSelectedItem() + " " + 
                          (String) dayDropdown.getSelectedItem() + ", " + 
                          yearDropdown.getSelectedItem();
            String time = (String) hourDropdown.getSelectedItem() + ":" + 
                          (String) minuteDropdown.getSelectedItem() + " " + 
                          amPmDropdown.getSelectedItem();
            String reason = (String) reasonDropdown.getSelectedItem();

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
                ps.setString(1, name);
                ps.setString(2, email);
                ps.setString(3, phoneNumber);
                ps.setString(4, date);
                ps.setString(5, time);
                ps.setString(6, reason);
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
}
