package Main;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.HashMap;
import backend.userRegistrationPage_backend;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class userRegistrationPage implements ActionListener 
{
	userRegistrationPage_backend backend = new userRegistrationPage_backend();




	// Constructor to store key-value pair

    

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
    JTextField userAddressField = new JTextField(); // Added address field

    JButton ResetButton = new JButton("Reset");
    JLabel userFirstNameLabel = new JLabel("First Name");
    JLabel userLastNameLabel = new JLabel("Last Name");
    JLabel userAgeLabel = new JLabel("Age");
    JLabel userContactNumberLabel = new JLabel("Contact No.");
    JLabel userEmailLabel = new JLabel("Email");
    JLabel userIdLabel = new JLabel("Username");
    JLabel userPasswordLabel = new JLabel("Password");
    JLabel userAddressLabel = new JLabel("Address"); // Added address label
    JLabel MessageLabel = new JLabel();

    // Logo Label
    JLabel logoLabel = new JLabel(new ImageIcon(getClass().getResource("/Resources/background.png"))); // replace with your logo path

    userRegistrationPage() 
    {
      
        
        // Setting logo on the left side
        logoLabel.setBounds(-220, 0, 1000, 1000); // Adjust size and position
        registrationFrame.add(logoLabel);

        // Labels (above text fields)
        userFirstNameLabel.setBounds(799, 30, 200, 30); // Adjusted position above text field
        userFirstNameLabel.setFont(new Font("Arial", Font.BOLD, 16));
        userFirstNameLabel.setForeground(Color.WHITE);

        userLastNameLabel.setBounds(799, 100, 200, 30); // Adjusted position above text field
        userLastNameLabel.setFont(new Font("Arial", Font.BOLD, 16));
        userLastNameLabel.setForeground(Color.WHITE);
        
        userAddressLabel.setBounds(799, 175, 200, 30); // Adjusted position above address text field
        userAddressLabel.setFont(new Font("Arial", Font.BOLD, 16));
        userAddressLabel.setForeground(Color.WHITE);


        userAgeLabel.setBounds(799, 240, 200, 30); // Adjusted position above text field
        userAgeLabel.setFont(new Font("Arial", Font.BOLD, 16));
        userAgeLabel.setForeground(Color.WHITE);

        userContactNumberLabel.setBounds(799, 310, 200, 30); // Adjusted position above text field
        userContactNumberLabel.setFont(new Font("Arial", Font.BOLD, 16));
        userContactNumberLabel.setForeground(Color.WHITE);

        userEmailLabel.setBounds(799, 380, 200, 30); // Adjusted position above text field
        userEmailLabel.setFont(new Font("Arial", Font.BOLD, 16));
        userEmailLabel.setForeground(Color.WHITE);

        userIdLabel.setBounds(799, 450, 200, 30); // Adjusted position above text field
        userIdLabel.setFont(new Font("Arial", Font.BOLD, 16));
        userIdLabel.setForeground(Color.WHITE);

        userPasswordLabel.setBounds(799, 525, 200, 30); // Adjusted position above text field
        userPasswordLabel.setFont(new Font("Arial", Font.BOLD, 16));
        userPasswordLabel.setForeground(Color.WHITE);

      
        // Input Fields (below the labels)
        userFirstNameField.setBounds(799, 60, 406, 40); // Adjusted position below label
        userFirstNameField.setFont(new Font("Arial", Font.PLAIN, 16));
        userFirstNameField.setBackground(Color.LIGHT_GRAY);
        userFirstNameField.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        userLastNameField.setBounds(799, 130, 406, 40); // Adjusted position below label
        userLastNameField.setFont(new Font("Arial", Font.PLAIN, 16));
        userLastNameField.setBackground(Color.LIGHT_GRAY);
        userLastNameField.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        userAgeField.setBounds(799, 270, 406, 40); // Adjusted position below label
        userAgeField.setFont(new Font("Arial", Font.PLAIN, 16));
        userAgeField.setBackground(Color.LIGHT_GRAY);
        userAgeField.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        userAddressField.setBounds(799, 200, 406, 40); // Adjusted position below label
        userAddressField.setFont(new Font("Arial", Font.PLAIN, 16));
        userAddressField.setBackground(Color.LIGHT_GRAY);
        userAddressField.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        userContactNumberField.setBounds(799, 340, 406, 40); // Adjusted position below label
        userContactNumberField.setFont(new Font("Arial", Font.PLAIN, 16));
        userContactNumberField.setBackground(Color.LIGHT_GRAY);
        userContactNumberField.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        userEmailField.setBounds(799, 410, 406, 40); // Adjusted position below label
        userEmailField.setFont(new Font("Arial", Font.PLAIN, 16));
        userEmailField.setBackground(Color.LIGHT_GRAY);
        userEmailField.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        userIdField.setBounds(799, 480, 406, 40); // Adjusted position below label
        userIdField.setFont(new Font("Arial", Font.PLAIN, 16));
        userIdField.setBackground(Color.LIGHT_GRAY);
        userIdField.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        UserpasswordField.setBounds(799, 550, 406, 40); // Adjusted position below label
        UserpasswordField.setFont(new Font("Arial", Font.PLAIN, 16));
        UserpasswordField.setBackground(Color.LIGHT_GRAY);
        UserpasswordField.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        
        signUpButton.setBounds(799, 600, 404, 62); // Adjusted position
        signUpButton.setFocusable(false);
        signUpButton.setFont(new Font("Arial", Font.BOLD, 18));
        signUpButton.setForeground(Color.WHITE);
        signUpButton.setBackground(new Color(0, 122, 204)); // Blue button with white text
        signUpButton.addActionListener(this);
        
        // Message Label
        MessageLabel.setBounds(899, 20, 406, 50); // Adjusted position
        MessageLabel.setFont(new Font("Arial", Font.ITALIC, 20));
        MessageLabel.setForeground(Color.WHITE);

        // Adding components to the frame
        registrationFrame.add(userFirstNameLabel);
        registrationFrame.add(userFirstNameField);
        registrationFrame.add(userLastNameLabel);
        registrationFrame.add(userLastNameField);
        registrationFrame.add(userAgeLabel);
        registrationFrame.add(userAgeField);
        registrationFrame.add(userAddressLabel); // Added address label
        registrationFrame.add(userAddressField); // Added address field
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
        ImageIcon image = new ImageIcon(getClass().getResource("/Resources/Logo.jpg"));
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
            
            backend.setFirstName(userFirstNameField.getText());
            backend.setLastName(userLastNameField.getText());
            backend.setAge(userAgeField.getText());
            backend.setAddress(userAddressField.getText());
            backend.setContactNumber(userContactNumberField.getText());
            backend.setEmail(userEmailField.getText());
            backend.setUsername(userIdField.getText());
            backend.setPassword(String.valueOf(UserpasswordField.getPassword()));
            

        
            
            // Simulate saving user information (for simplicity, we just print it)
            if (!backend.getFirstName().isEmpty() && !backend.getLastName().isEmpty() && !backend.getAge().isEmpty() && !backend.getContactNumber().isEmpty() && !backend.getEmail().isEmpty() && !backend.getAddress().isEmpty()&& !backend.getUsername().isEmpty() && !backend.getPassword().isEmpty()) 
            {
                // Database connection
             	
            	try {               	
                    Class.forName("com.mysql.cj.jdbc.Driver");

                    // Specify the correct connection string with username and password
                    Connection con = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/dcfdentalclinicdb", 
                        "admin", 
                        "admin"
                    );
                    PreparedStatement ps = con.prepareStatement("INSERT INTO userdata (FirstName, LastName, age, Address, ContactNumber, Email, userName, Password) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");

                    ps.setString(1, backend.getFirstName());
                    ps.setString(2, backend.getLastName());
                    ps.setString(3, backend.getAge());
                    ps.setString(4, backend.getAddress());  // Adjust this if you add the address field in the form
                    ps.setString(5, backend.getContactNumber());
                    ps.setString(6, backend.getEmail());
                    ps.setString(7, backend.getUsername());
                    ps.setString(8, backend.getPassword());
                       
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
                
                JOptionPane.showMessageDialog(null,"Please Fill in all field!!");
            }
        }
    }
}

