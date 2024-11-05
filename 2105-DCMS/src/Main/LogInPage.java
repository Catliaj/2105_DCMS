package Main;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LogInPage implements ActionListener 
{
    HashMap<String, String> userLogInfo = new HashMap<String, String>();

    // Creating frame and components
    JFrame LogInPage = new JFrame("Login Page");
    JButton LogInButton = new JButton("LOG IN");
    JTextField userIdField = new JTextField();
    JPasswordField UserpasswordField = new JPasswordField();
    
    JButton signUpButton = new JButton("Sign Up");
    
    JButton ResetButton = new JButton("Reset");
    JLabel userIdLabel = new JLabel("USERNAME");
    JLabel userPasswordLabel = new JLabel("PASSWORD");
    JLabel MessageLabel = new JLabel();

    // Logo Label
    JLabel logoLabel = new JLabel(new ImageIcon("C:\\Users\\AcerN\\eclipse-workspace\\Main\\src\\Main\\background.png")); // replace with your logo pathGUI\\src\\main\\java\\com\\mycompany

    LogInPage(HashMap<String, String> userLogInfoOriginal) 
    {
        userLogInfo = userLogInfoOriginal;

        // Setting logo on the left side
        logoLabel.setBounds(-220, 0, 1000, 1000); // Adjust size and position
        LogInPage.add(logoLabel);

        // Labels
        userIdLabel.setBounds(813, 200, 214, 38);
        userIdLabel.setFont(new Font("Arial", Font.BOLD, 18)); // Adjust font size to match the design
        userIdLabel.setForeground(Color.WHITE); // White text as per the image

        userPasswordLabel.setBounds(813, 300, 214, 38);
        userPasswordLabel.setFont(new Font("Arial", Font.BOLD, 18));
        userPasswordLabel.setForeground(Color.WHITE);

        // Message Label
        MessageLabel.setBounds(813, 100, 406, 50);
        MessageLabel.setFont(new Font("Arial", Font.ITALIC, 20));
        MessageLabel.setForeground(Color.WHITE);

        // Input Fields
        userIdField.setBounds(812, 250, 406, 50);
        userIdField.setFont(new Font("Arial", Font.PLAIN, 18));
        userIdField.setBackground(Color.LIGHT_GRAY); // Light gray as per design
        userIdField.setBorder(null); // No border for cleaner look

        UserpasswordField.setBounds(812, 350, 406, 50);
        UserpasswordField.setFont(new Font("Arial", Font.PLAIN, 18));
        UserpasswordField.setBackground(Color.LIGHT_GRAY);
        UserpasswordField.setBorder(null);

        // Buttons
        LogInButton.setBounds(812, 450, 404, 62);
        LogInButton.setFocusable(false);
        LogInButton.setFont(new Font("Arial", Font.BOLD, 18));
        LogInButton.setForeground(Color.WHITE);
        LogInButton.setBackground(Color.BLACK); // Black button with white text
        LogInButton.addActionListener(this);

        ResetButton.setBounds(812, 550, 404, 62);
        ResetButton.setFocusable(false);
        ResetButton.setFont(new Font("Arial", Font.BOLD, 18));
        ResetButton.setForeground(Color.WHITE);
        ResetButton.setBackground(Color.DARK_GRAY);
        ResetButton.addActionListener(this);
        
        signUpButton.setBounds(812, 650, 404, 62);
        signUpButton.setFocusable(false);
        signUpButton.setFont(new Font("Arial", Font.BOLD, 18));
        signUpButton.setForeground(Color.WHITE);
        signUpButton.setBackground(Color.DARK_GRAY);
        signUpButton.addActionListener(this);

        // Adding components to the frame
        LogInPage.add(userIdLabel);
        LogInPage.add(userIdField);
        LogInPage.add(userPasswordLabel);
        LogInPage.add(UserpasswordField);
        LogInPage.add(MessageLabel);
        LogInPage.add(LogInButton);
        LogInPage.add(ResetButton);
        LogInPage.add(signUpButton);
        // Frame settings
        ImageIcon image = new ImageIcon("C:\\Users\\AcerN\\eclipse-workspace\\Main\\src\\Main\\Logo.jpg");
        LogInPage.setIconImage(image.getImage());
        LogInPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        LogInPage.getContentPane().setBackground(new Color(2, 79, 90)); // Teal background matching the image
        LogInPage.setSize(1440, 1024); // Adjust size
        LogInPage.setLayout(null); // Absolute positioning
        LogInPage.setVisible(true); // Make frame visible
    }

    LogInPage() 
    {
        // Setting logo on the left side
        logoLabel.setBounds(-220, 0, 1000, 1000); // Adjust size and position
        LogInPage.add(logoLabel);

        // Labels
        userIdLabel.setBounds(813, 200, 214, 38);
        userIdLabel.setFont(new Font("Arial", Font.BOLD, 18)); // Adjust font size to match the design
        userIdLabel.setForeground(Color.WHITE); // White text as per the image

        userPasswordLabel.setBounds(813, 300, 214, 38);
        userPasswordLabel.setFont(new Font("Arial", Font.BOLD, 18));
        userPasswordLabel.setForeground(Color.WHITE);

        // Message Label
        MessageLabel.setBounds(813, 100, 406, 50);
        MessageLabel.setFont(new Font("Arial", Font.ITALIC, 20));
        MessageLabel.setForeground(Color.WHITE);

        // Input Fields
        userIdField.setBounds(812, 250, 406, 50);
        userIdField.setFont(new Font("Arial", Font.PLAIN, 18));
        userIdField.setBackground(Color.LIGHT_GRAY); // Light gray as per design
        userIdField.setBorder(null); // No border for cleaner look

        UserpasswordField.setBounds(812, 350, 406, 50);
        UserpasswordField.setFont(new Font("Arial", Font.PLAIN, 18));
        UserpasswordField.setBackground(Color.LIGHT_GRAY);
        UserpasswordField.setBorder(null);

        // Buttons
        LogInButton.setBounds(812, 450, 404, 62);
        LogInButton.setFocusable(false);
        LogInButton.setFont(new Font("Arial", Font.BOLD, 18));
        LogInButton.setForeground(Color.WHITE);
        LogInButton.setBackground(Color.BLACK); // Black button with white text
        LogInButton.addActionListener(this);

        ResetButton.setBounds(812, 550, 404, 62);
        ResetButton.setFocusable(false);
        ResetButton.setFont(new Font("Arial", Font.BOLD, 18));
        ResetButton.setForeground(Color.WHITE);
        ResetButton.setBackground(Color.DARK_GRAY);
        ResetButton.addActionListener(this);
        
        signUpButton.setBounds(812, 650, 404, 62);
        signUpButton.setFocusable(false);
        signUpButton.setFont(new Font("Arial", Font.BOLD, 18));
        signUpButton.setForeground(Color.WHITE);
        signUpButton.setBackground(Color.DARK_GRAY);
        signUpButton.addActionListener(this);

        // Adding components to the frame   
        LogInPage.add(userIdLabel);
        LogInPage.add(userIdField);
        LogInPage.add(userPasswordLabel);
        LogInPage.add(UserpasswordField);
        LogInPage.add(MessageLabel);
        LogInPage.add(LogInButton);
        LogInPage.add(ResetButton);
        LogInPage.add(signUpButton);
        
        // Frame settings
        ImageIcon image = new ImageIcon("C:\\Users\\AcerN\\eclipse-workspace\\Main\\src\\Main\\Logo.jpg");
        LogInPage.setIconImage(image.getImage());
        LogInPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        LogInPage.getContentPane().setBackground(new Color(2, 79, 90)); // Teal background matching the image
        LogInPage.setSize(1440, 1024); // Adjust size
        LogInPage.setLayout(null); // Absolute positioning
        LogInPage.setVisible(true); // Make frame visible
    }

    @Override
    public void actionPerformed(ActionEvent action) 
    {
        if (action.getSource() == ResetButton) 
        {
            // Clear the input fields
            userIdField.setText("");
            UserpasswordField.setText("");
            MessageLabel.setText("");
        }
        else if (action.getSource() == LogInButton) 
        {
            String userName = userIdField.getText();
            String userPassword = String.valueOf(UserpasswordField.getPassword());
            if (userLogInfo.containsKey(userName)) 
            {
                if (userLogInfo.get(userName).equals(userPassword)) 
                {
                    MessageLabel.setForeground(Color.green);
                    MessageLabel.setText("Login Successfully");
                    // Call home page after successful login
                    LogInPage.dispose();
                    new homePage();
                } 
                
                else 
                {
                    MessageLabel.setForeground(Color.red);
                    MessageLabel.setText("WRONG password");
                }
            }
            else 
            {
                MessageLabel.setForeground(Color.red);
                MessageLabel.setText("User not found");
            }
        }
        else if(action.getSource() == signUpButton)
        {
            new userRegistrationPage(userLogInfo);
        }
    }

}
