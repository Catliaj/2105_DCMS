package Main;
import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import com.toedter.calendar.JDateChooser;

import DCMS_DB_CONNECTION.DB_DCMSConnection;
import backend.newPatient_Backend;
import java.sql.*;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class NewPatient extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField FirstNameTxtField;
    private JTextField LastNameTxtField;
    private JTextField AgeTxtField ;
    private JTextField ContactTxtField;
    private JTextField EmailTxtField;
    private JTextField AddressTxtField;
    private JTextField MITxtField;
    private JDateChooser dateChooser;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    NewPatient frame = new NewPatient();
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
    private String selectedGender = "";
    private JButton CancelBtn;
    private JButton SaveBtn;
	DB_DCMSConnection dcmsConnection = new DB_DCMSConnection();
	newPatient_Backend backend =new newPatient_Backend();
	private Connection connection;

    public NewPatient() 
    {
    	setResizable(false);
    	setLocationRelativeTo(null);
    	setVisible(true);
        setBackground(new Color(128, 128, 128));
        setForeground(new Color(0, 0, 0));
        setTitle("NEW PATIENT");
        setFont(new Font("Arial", Font.BOLD, 12));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 671, 556);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setLocationRelativeTo(null);

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(194, 192, 192));
        panel.setBounds(0, 0, 657, 519);
        contentPane.add(panel);
        panel.setLayout(null);
        
        JLabel NPRLabel = new JLabel("NEW PATIENT RECORD");
        NPRLabel.setForeground(new Color(0, 0, 0));
        NPRLabel.setFont(new Font("Segoe UI", Font.BOLD, 30));
        NPRLabel.setBounds(167, 27, 347, 49);
        panel.add(NPRLabel);
        
        FirstNameTxtField = new JTextField();
        FirstNameTxtField.setBounds(48, 120, 195, 29);
        panel.add(FirstNameTxtField);
        FirstNameTxtField.setColumns(10);
        
        LastNameTxtField = new JTextField();
        LastNameTxtField.setColumns(10);
        LastNameTxtField.setBounds(411, 120, 195, 29);
        panel.add(LastNameTxtField);
        
        AgeTxtField = new JTextField();
        AgeTxtField.setColumns(10);
        AgeTxtField.setBounds(48, 203, 57, 29);
        panel.add(AgeTxtField);
        
        ContactTxtField = new JTextField();
        ContactTxtField.setColumns(10);
        ContactTxtField.setBounds(411, 203, 195, 29);
        panel.add(ContactTxtField);
        
        JLabel AgeLabel = new JLabel("AGE");
        AgeLabel.setFont(new Font("Segoe UI", Font.BOLD, 15));
        AgeLabel.setBounds(48, 180, 97, 13);
        panel.add(AgeLabel);
        
        JLabel LastNameLabel = new JLabel("LAST NAME");
        LastNameLabel.setFont(new Font("Segoe UI", Font.BOLD, 15));
        LastNameLabel.setBounds(411, 99, 128, 13);
        panel.add(LastNameLabel);
        
        JLabel FirstNameLabel = new JLabel("FIRST NAME");
        FirstNameLabel.setFont(new Font("Segoe UI", Font.BOLD, 15));
        FirstNameLabel.setBounds(49, 99, 97, 13);
        panel.add(FirstNameLabel);
        
        JLabel GenderLabel = new JLabel("GENDER");
        GenderLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        GenderLabel.setBounds(167, 181, 97, 13);
        panel.add(GenderLabel);
        
        JLabel ContactLabel = new JLabel("CONTACT NO.");
        ContactLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        ContactLabel.setBounds(429, 181, 108, 13);
        panel.add(ContactLabel);
        
        dateChooser = new JDateChooser();
        dateChooser.getCalendarButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        dateChooser.setBounds(167, 277, 314, 29);
        panel.add(dateChooser);
        
        EmailTxtField = new JTextField();
        EmailTxtField.setColumns(10);
        EmailTxtField.setBounds(92, 339, 480, 29);
        panel.add(EmailTxtField);
        
        AddressTxtField = new JTextField();
        AddressTxtField.setColumns(10);
        AddressTxtField.setBounds(92, 409, 480, 29);
        panel.add(AddressTxtField);
        
        JLabel BirthLabel = new JLabel("DATE OF BIRTH");
        BirthLabel.setFont(new Font("Segoe UI", Font.BOLD, 15));
        BirthLabel.setBounds(167, 254, 128, 13);
        panel.add(BirthLabel);
        
        JLabel EmailLabel = new JLabel("EMAIL");
        EmailLabel.setFont(new Font("Segoe UI", Font.BOLD, 15));
        EmailLabel.setBounds(92, 316, 128, 13);
        panel.add(EmailLabel);
        
        JLabel AddressLabel = new JLabel("ADDRESS");
        AddressLabel.setFont(new Font("Segoe UI", Font.BOLD, 15));
        AddressLabel.setBounds(92, 386, 128, 13);
        panel.add(AddressLabel);
        
        JLabel MILabel = new JLabel("M.I");
        MILabel.setFont(new Font("Segoe UI", Font.BOLD, 15));
        MILabel.setBounds(296, 99, 34, 13);
        panel.add(MILabel);
        
        MITxtField = new JTextField();
        MITxtField.setColumns(10);
        MITxtField.setBounds(295, 120, 49, 29);
        panel.add(MITxtField);
        
        JRadioButton MaleRdBtn = new JRadioButton("MALE");
        MaleRdBtn.setFont(new Font("Segoe UI", Font.BOLD, 15));
        MaleRdBtn.setBounds(167, 200, 79, 29);
        MaleRdBtn.addActionListener(this);
        panel.add(MaleRdBtn);
        
        JRadioButton FemaleRdBtn = new JRadioButton("FEMALE");
        FemaleRdBtn.setFont(new Font("Segoe UI", Font.BOLD, 15));
        FemaleRdBtn.setBounds(264, 200, 97, 29);
        FemaleRdBtn.addActionListener(this);
        panel.add(FemaleRdBtn);
        
        // Group the radio buttons to allow only one selection
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(MaleRdBtn);
        genderGroup.add(FemaleRdBtn);
        
        CancelBtn = new JButton("CANCEL");
        CancelBtn.setForeground(new Color(194, 192, 192));
        CancelBtn.setBackground(new Color(5, 59, 67));
        CancelBtn.setFont(new Font("Segoe UI", Font.BOLD, 20));
        CancelBtn.setBounds(135, 455, 154, 38);
        CancelBtn.addActionListener(this);
        panel.add(CancelBtn);
        
        SaveBtn = new JButton("SAVE");
        SaveBtn.setForeground(new Color(194, 192, 192));
        SaveBtn.setBackground(new Color(5, 59, 67));
        SaveBtn.setFont(new Font("Segoe UI", Font.BOLD, 20));
        SaveBtn.setBounds(361, 455, 154, 38);
        SaveBtn.addActionListener(this);
        panel.add(SaveBtn);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(NewPatient.class.getResource("/Resources/PopupBackg.png")));
        lblNewLabel.setBounds(0, 0, 657, 519);
        panel.add(lblNewLabel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == CancelBtn) {
            dispose();
        } else if (e.getSource() == SaveBtn) {
            // Extract data from the form
            String firstName = FirstNameTxtField.getText();
            String lastName = LastNameTxtField.getText();
            String mi = MITxtField.getText();
            String contact = ContactTxtField.getText();
            String email = EmailTxtField.getText();
            String address = AddressTxtField.getText();
            String ageText = AgeTxtField.getText();
            Integer age = 0;

            
            try {
                age = Integer.parseInt(ageText);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter a valid number for age.", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            
            SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM dd, yyyy");
            String dateOfBirth = (dateChooser.getDate() != null) ? dateFormat.format(dateChooser.getDate()) : "Not Selected";

            
            backend.setFirstName(firstName);
            backend.setMiddleInitial(mi);
            backend.setLastName(lastName);
            backend.setAge(age);
            backend.setGender(selectedGender);
            backend.setContactNumber(contact);
            backend.setEmail(email);
            backend.setAddress(address);

           
            try {
            	connection = dcmsConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(
                    "INSERT INTO patientdata (FirstName, LastName, MiddleInitial, Age, Gender, ContactNumber, Email, Address, DateOfBirth) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)"
                );
                ps.setString(1, backend.getFirstName());
                ps.setString(2, backend.getLastName());
                ps.setString(3, backend.getMiddleInitial());
                ps.setInt(4, backend.getAge());
                ps.setString(5, backend.getGender());
                ps.setString(6, backend.getContactNumber());
                ps.setString(7, backend.getEmail());
                ps.setString(8, backend.getAddress());
                ps.setString(9, dateOfBirth);

                int rowsAffected = ps.executeUpdate();

                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(this, "Patient record saved successfully!");
                    FirstNameTxtField.setText("");
                    LastNameTxtField.setText("");
                    MITxtField.setText("");
                    ContactTxtField.setText("");
                    EmailTxtField.setText("");
                    AddressTxtField.setText("");
                    AgeTxtField.setText("");
                    
                } else {
                    JOptionPane.showMessageDialog(this, "Failed to save patient record. Please try again.");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            }
            
        }
    }
}
