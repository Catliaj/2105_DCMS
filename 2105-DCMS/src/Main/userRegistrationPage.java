package Main;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.HashMap;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class userRegistrationPage  implements ActionListener 
{
	
    HashMap<String, String> userData = new HashMap<String, String>();
    private String Username, userPassword;


	// Constructor to store key-value pair
    userRegistrationPage() 
    {
        userData.put("Admin", "Admin");
    }

    protected HashMap userLoginInfo() 
    {
        return userData;
    }
    

    // Creating frame and components
    JFrame registrationFrame = new JFrame("Registration Page");
    JButton signUpButton = new JButton("Sign up");
    JOptionPane Message = new JOptionPane();
    JTextField userFirstNameField = new JTextField();
    JTextField userLastNameField = new JTextField();
    JTextField userAgeField = new JTextField();
    JTextField userContactNumberField = new JTextField();
    JTextField userEmailField = new JTextField();
    JTextField userIdField = new JTextField();
    JPasswordField UserpasswordField = new JPasswordField();

    JButton ResetButton = new JButton("Reset");
    JLabel userFirstNameLabel = new JLabel("First Name");
    JLabel userLastNameLabel = new JLabel("Last Name");
    JLabel userAgeLabel = new JLabel("Age");
    JLabel userContactNumberLabel = new JLabel("Contact No.");
    JLabel userEmailLabel = new JLabel("Email");
    JLabel userIdLabel = new JLabel("Username");
    JLabel userPasswordLabel = new JLabel("Password");
    JLabel MessageLabel = new JLabel();

    // Logo Label
    JLabel logoLabel = new JLabel(new ImageIcon("C:\\Users\\AcerN\\eclipse-workspace\\Main\\src\\Main\\background.png")); // replace with your logo path

    userRegistrationPage(HashMap<String, String> userDataOriginal) 
    {
        userData = userDataOriginal;
        
        // Setting logo on the left side
        logoLabel.setBounds(-220, 0, 1000, 1000); // Adjust size and position
        registrationFrame.add(logoLabel);

        // Labels
        userFirstNameLabel.setBounds(799, 100, 214, 38);
        userFirstNameLabel.setFont(new Font("Arial", Font.BOLD, 18));
        userFirstNameLabel.setForeground(Color.WHITE);

        userLastNameLabel.setBounds(799, 190, 214, 38);
        userLastNameLabel.setFont(new Font("Arial", Font.BOLD, 18));
        userLastNameLabel.setForeground(Color.WHITE);

        userAgeLabel.setBounds(799, 275, 214, 38);
        userAgeLabel.setFont(new Font("Arial", Font.BOLD, 18));
        userAgeLabel.setForeground(Color.WHITE);

        userContactNumberLabel.setBounds(799, 360, 214, 38);
        userContactNumberLabel.setFont(new Font("Arial", Font.BOLD, 18));
        userContactNumberLabel.setForeground(Color.WHITE);

        userEmailLabel.setBounds(799, 440, 214, 38);
        userEmailLabel.setFont(new Font("Arial", Font.BOLD, 18));
        userEmailLabel.setForeground(Color.WHITE);

        userIdLabel.setBounds(799, 515, 214, 38);
        userIdLabel.setFont(new Font("Arial", Font.BOLD, 18));
        userIdLabel.setForeground(Color.WHITE);

        userPasswordLabel.setBounds(799, 600, 214, 38);
        userPasswordLabel.setFont(new Font("Arial", Font.BOLD, 18));
        userPasswordLabel.setForeground(Color.WHITE);

        // Input Fields
        userFirstNameField.setBounds(799, 140, 406, 50); // x y w h
        userFirstNameField.setFont(new Font("Arial", Font.PLAIN, 18));
        userFirstNameField.setBackground(Color.LIGHT_GRAY);
        userFirstNameField.setBorder(null);

        userLastNameField.setBounds(799, 230, 406, 50);
        userLastNameField.setFont(new Font("Arial", Font.PLAIN, 18));
        userLastNameField.setBackground(Color.LIGHT_GRAY);
        userLastNameField.setBorder(null);

        userAgeField.setBounds(799, 310, 406, 50);
        userAgeField.setFont(new Font("Arial", Font.PLAIN, 18));
        userAgeField.setBackground(Color.LIGHT_GRAY);
        userAgeField.setBorder(null);

        userContactNumberField.setBounds(799, 390, 406, 50);
        userContactNumberField.setFont(new Font("Arial", Font.PLAIN, 18));
        userContactNumberField.setBackground(Color.LIGHT_GRAY);
        userContactNumberField.setBorder(null);

        userEmailField.setBounds(799, 470, 406, 50);
        userEmailField.setFont(new Font("Arial", Font.PLAIN, 18));
        userEmailField.setBackground(Color.LIGHT_GRAY);
        userEmailField.setBorder(null);

        userIdField.setBounds(799, 550, 406, 50);
        userIdField.setFont(new Font("Arial", Font.PLAIN, 18));
        userIdField.setBackground(Color.LIGHT_GRAY);
        userIdField.setBorder(null);

        UserpasswordField.setBounds(799, 630, 406, 50);
        UserpasswordField.setFont(new Font("Arial", Font.PLAIN, 18));
        UserpasswordField.setBackground(Color.LIGHT_GRAY);
        UserpasswordField.setBorder(null);
        
        signUpButton.setBounds(799, 700, 404, 62);
        signUpButton.setFocusable(false);
        signUpButton.setFont(new Font("Arial", Font.BOLD, 18));
        signUpButton.setForeground(Color.WHITE);
        signUpButton.setBackground(Color.BLACK); // Black button with white text
        signUpButton.addActionListener(this);
        
        // Message Label
        MessageLabel.setBounds(799, 50, 406, 50);
        MessageLabel.setFont(new Font("Arial", Font.ITALIC, 20));
        MessageLabel.setForeground(Color.WHITE);

        // Adding components to the frame
        registrationFrame.add(userFirstNameLabel);
        registrationFrame.add(userFirstNameField);
        registrationFrame.add(userLastNameLabel);
        registrationFrame.add(userLastNameField);
        registrationFrame.add(userAgeLabel);
        registrationFrame.add(userAgeField);
        registrationFrame.add(userContactNumberLabel);
        registrationFrame.add(userContactNumberField);
        registrationFrame.add(userEmailLabel);
        registrationFrame.add(userEmailField);
        registrationFrame.add(userIdLabel);
        registrationFrame.add(userIdField);
        registrationFrame.add(userPasswordLabel);
        registrationFrame.add(UserpasswordField);
        registrationFrame.add(MessageLabel);
        registrationFrame.add(signUpButton);
        registrationFrame.add(ResetButton);

        // Frame settings
        ImageIcon image = new ImageIcon("C:\\Users\\AcerN\\eclipse-workspace\\Main\\src\\Main\\Logo.jpg");
        registrationFrame.setIconImage(image.getImage());
        registrationFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        registrationFrame.getContentPane().setBackground(new Color(2, 79, 90)); // Teal background matching the image
        registrationFrame.setSize(1440, 900); // Adjust size
        registrationFrame.setLayout(null); // Absolute positioning
        registrationFrame.setVisible(true); // Make frame visible
    }

    @Override
    public void actionPerformed(ActionEvent action) 
    {
        if (action.getSource() == ResetButton) 
        {
            // Clear all input fields
            userFirstNameField.setText("");
            userLastNameField.setText("");
            userAgeField.setText("");
            userContactNumberField.setText("");
            userEmailField.setText("");
            userIdField.setText("");
            UserpasswordField.setText("");
            MessageLabel.setText("");
        }
        if (action.getSource() == signUpButton) {
            // Gather form data
            String firstName = userFirstNameField.getText();
            String lastName = userLastNameField.getText();
            String age = userAgeField.getText();
            String contactNumber = userContactNumberField.getText();
            String email = userEmailField.getText();
            String username = userIdField.getText();
            String password = String.valueOf(UserpasswordField.getPassword());           
            String Address = "Lian"; 

            // Simulate saving user information (for simplicity, we just print it)
            if (!firstName.isEmpty() && !lastName.isEmpty() && !age.isEmpty() && !contactNumber.isEmpty() && !email.isEmpty() && !username.isEmpty() && !password.isEmpty()) 
            {
                // Database connection
               userData.put(username, password);         	
            	try {               	
                    Class.forName("com.mysql.cj.jdbc.Driver");

                    // Specify the correct connection string with username and password
                    Connection con = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/dcfdentalclinicdb", 
                        "admin", 
                        "admin"
                    );
                    PreparedStatement ps = con.prepareStatement("INSERT INTO userdata (FirstName, LastName, age, Address, ContactNumber, Email, userName, Password) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");

                    ps.setString(1, firstName);
                    ps.setString(2, lastName);
                    ps.setInt(3, Integer.parseInt(age)); 
                    ps.setString(4, Address);  // Adjust this if you add the address field in the form
                    ps.setString(5, contactNumber);
                    ps.setString(6, email);
                    ps.setString(7, username);
                    ps.setString(8, password);
                            
                    int rowsAffected = ps.executeUpdate();

                    if (rowsAffected > 0) 
                    {
                    	JOptionPane.showMessageDialog(null, "Registration successful!");
                        registrationFrame.dispose();              
                    } 
                    else 
                    {
                        MessageLabel.setText("Registration failed. Please try again.");
                    }

                } 
            	catch (Exception ex) 
            	{
                        ex.printStackTrace(); // Prints detailed error in the console
                        JOptionPane.showMessageDialog(null, "Error while connecting to the database: " + ex.getMessage());
                }
            } 
            else 
            {
                MessageLabel.setText("Please fill in all fields.");
            }
        }
    }
}

