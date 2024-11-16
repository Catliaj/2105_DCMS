package Main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import DCMS_DB_CONNECTION.DB_DCMSConnection;
import java.sql.*;
import backend.ApointmentForm_backend;
import backend.newPatient_Backend;

public class LogInPage implements ActionListener 
{
    

    // Creating frame and components
    JOptionPane Message = new JOptionPane();
    JFrame logInFrame = new JFrame("Login Page");
    JButton logInButton = new JButton("LOG IN");
    JTextField userIdField = new JTextField();
    JPasswordField userPasswordField = new JPasswordField();
    JButton signUpButton = new JButton("Sign Up");
    JButton resetButton = new JButton("Reset");
    JLabel userIdLabel = new JLabel("USERNAME");
    JLabel userPasswordLabel = new JLabel("PASSWORD");
    JLabel messageLabel = new JLabel();
    JLabel logoLabel = new JLabel(new ImageIcon(getClass().getResource("/Resources/background.png"))); // logo

    // Constructor with user login info
    newPatient_Backend backend = new newPatient_Backend();
	DB_DCMSConnection dcmsConnection = new DB_DCMSConnection(); 
	private Connection connection;


    public LogInPage() 
    {
        // Logo settings
        logoLabel.setBounds(-220, 0, 1000, 1000);
        logInFrame.add(logoLabel);

        // Labels
        userIdLabel.setBounds(813, 200, 214, 38);
        userIdLabel.setFont(new Font("Arial", Font.BOLD, 18));
        userIdLabel.setForeground(Color.WHITE);
        userPasswordLabel.setBounds(813, 300, 214, 38);
        userPasswordLabel.setFont(new Font("Arial", Font.BOLD, 18));
        userPasswordLabel.setForeground(Color.WHITE);
        messageLabel.setBounds(813, 100, 406, 50);
        messageLabel.setFont(new Font("Arial", Font.ITALIC, 20));
        messageLabel.setForeground(Color.WHITE);

        // Input Fields
        userIdField.setBounds(812, 250, 406, 50);
        userIdField.setFont(new Font("Arial", Font.PLAIN, 18));
        userIdField.setBackground(Color.LIGHT_GRAY);
        userIdField.setBorder(null);
        userPasswordField.setBounds(812, 350, 406, 50);
        userPasswordField.setFont(new Font("Arial", Font.PLAIN, 18));
        userPasswordField.setBackground(Color.LIGHT_GRAY);
        userPasswordField.setBorder(null);

        // Buttons
        logInButton.setBounds(812, 450, 404, 62);
        logInButton.setFocusable(false);
        logInButton.setFont(new Font("Arial", Font.BOLD, 18));
        logInButton.setForeground(Color.WHITE);
        logInButton.setBackground(Color.BLACK);
        logInButton.addActionListener(this);

        resetButton.setBounds(812, 550, 404, 62);
        resetButton.setFocusable(false);
        resetButton.setFont(new Font("Arial", Font.BOLD, 18));
        resetButton.setForeground(Color.WHITE);
        resetButton.setBackground(Color.DARK_GRAY);
        resetButton.addActionListener(this);

        signUpButton.setBounds(812, 650, 404, 62);
        signUpButton.setFocusable(false);
        signUpButton.setFont(new Font("Arial", Font.BOLD, 18));
        signUpButton.setForeground(Color.WHITE);
        signUpButton.setBackground(Color.DARK_GRAY);
        signUpButton.addActionListener(this);

        // Adding components to the frame
        logInFrame.add(userIdLabel);
        logInFrame.add(userIdField);
        logInFrame.add(userPasswordLabel);
        logInFrame.add(userPasswordField);
        logInFrame.add(messageLabel);
        logInFrame.add(logInButton);
        logInFrame.add(resetButton);
        logInFrame.add(signUpButton);

        // Frame settings
        ImageIcon image = new ImageIcon(getClass().getResource("/Resources/Logo.jpg"));
        logInFrame.setIconImage(image.getImage());
        logInFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        logInFrame.getContentPane().setBackground(new Color(2, 79, 90)); 
        logInFrame.setSize(1440, 1024);
        logInFrame.setLayout(new BorderLayout());
        logInFrame.setLayout(null);
        logInFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent action) {
        if (action.getSource() == resetButton) {
            userIdField.setText("");
            userPasswordField.setText("");
            messageLabel.setText("");
        } else if (action.getSource() == logInButton) {
            String userName = userIdField.getText();
            String userPassword = String.valueOf(userPasswordField.getPassword());
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/dcfdentalclinicdb", 
                    "admin", 
                    "admin"
                );

                String query = "SELECT * FROM userdata WHERE userName = ? AND Password = ?";
                PreparedStatement stmt = con.prepareStatement(query);
                stmt.setString(1, userName);
                stmt.setString(2, userPassword);
                ResultSet rs = stmt.executeQuery();

                if (rs.next()) 
                {
                    JOptionPane.showMessageDialog(null, "Login Successfully");
                    logInFrame.dispose();
                    new homePage(); // Assuming a homePage class exists
                } 
             
                else 
                {
                    JOptionPane.showMessageDialog(null, "Invalid username or password","Try",JOptionPane.YES_OPTION);
                }
                con.close();
            } catch (Exception ex) {
                ex.printStackTrace();
                messageLabel.setText("Error: " + ex.getMessage());
            }
        } 
    }
    
    public static void main(String[] args)
    {
    	new LogInPage();
    }
}
