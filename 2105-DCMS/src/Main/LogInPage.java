package Main;

<<<<<<< HEAD
=======
import java.awt.BorderLayout;
>>>>>>> 1af362b800b4da53edba7022ccc17e6d484bc950
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
<<<<<<< HEAD
import java.sql.ResultSet;
import java.util.HashMap;
=======
>>>>>>> 1af362b800b4da53edba7022ccc17e6d484bc950
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
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

<<<<<<< HEAD

public class LogInPage implements ActionListener {
    HashMap<String, String> userLogInfo = new HashMap<>();
=======
public class LogInPage implements ActionListener 
{
    
>>>>>>> 1af362b800b4da53edba7022ccc17e6d484bc950

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
<<<<<<< HEAD
    JLabel logoLabel = new JLabel(new ImageIcon(getClass().getResource("background.png"))); 

    // Constructor with user login info
    public LogInPage(HashMap<String, String> userLogInfoOriginal) {
        userLogInfo = userLogInfoOriginal;
        setupUI();
    }

    // Default constructor
    public LogInPage() {
        setupUI();
    }

    private void setupUI() {
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
=======

    // Constructor with user login info
    newPatient_Backend backend = new newPatient_Backend();
	DB_DCMSConnection dcmsConnection = new DB_DCMSConnection(); 
	private Connection connection;
	private final JLabel lblNewLabel = new JLabel("");
	private final JPanel panel = new JPanel();
	private final JLabel lblNewLabel_1 = new JLabel("LOG IN");
	private final JLabel linetxt = new JLabel("");


    public LogInPage() 
    {
        messageLabel.setBounds(813, 100, 406, 50);
        messageLabel.setFont(new Font("Arial", Font.ITALIC, 20));
        messageLabel.setForeground(Color.WHITE);
        logInFrame.getContentPane().setLayout(null);
        logInFrame.getContentPane().add(messageLabel);

        // Frame settings
        ImageIcon image = new ImageIcon(getClass().getResource("/Resources/Logo.jpg"));
        logInFrame.setIconImage(image.getImage());
        logInFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        logInFrame.getContentPane().setBackground(new Color(2, 79, 90)); 
        logInFrame.setSize(836, 589);
        logInFrame.getContentPane().setLayout(null);
        panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        panel.setBackground(new Color(194, 192, 192));
        panel.setBounds(435, 99, 310, 376);
        
        logInFrame.getContentPane().add(panel);
        panel.setLayout(null);
        lblNewLabel_1.setBounds(20, 21, 136, 25);
        lblNewLabel_1.setForeground(new Color(86, 86, 86));
        lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 30));
        
        panel.add(lblNewLabel_1);
        linetxt.setBounds(20, 43, 375, 13);
        linetxt.setForeground(new Color(137, 137, 137));
        
        panel.add(linetxt);
        signUpButton.setBounds(71, 312, 168, 35);
        panel.add(signUpButton);
>>>>>>> 1af362b800b4da53edba7022ccc17e6d484bc950
        signUpButton.setFocusable(false);
        signUpButton.setFont(new Font("Arial", Font.BOLD, 18));
        signUpButton.setForeground(Color.WHITE);
        signUpButton.setBackground(Color.DARK_GRAY);
<<<<<<< HEAD
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
        ImageIcon image = new ImageIcon(getClass().getResource("Logo.jpg"));
        logInFrame.setIconImage(image.getImage());
        logInFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        logInFrame.getContentPane().setBackground(new Color(2, 79, 90));
        logInFrame.setSize(1440, 1024);
        logInFrame.setLayout(null);
=======
        logInButton.setBounds(71, 228, 167, 32);
        panel.add(logInButton);
        logInButton.setFocusable(false);
        logInButton.setFont(new Font("Arial", Font.BOLD, 18));
        logInButton.setForeground(Color.WHITE);
        logInButton.setBackground(Color.BLACK);
        resetButton.setBounds(72, 270, 167, 32);
        panel.add(resetButton);
        resetButton.setFocusable(false);
        resetButton.setFont(new Font("Arial", Font.BOLD, 18));
        resetButton.setForeground(Color.WHITE);
        resetButton.setBackground(Color.DARK_GRAY);
        userPasswordField.setBounds(38, 169, 240, 32);
        panel.add(userPasswordField);
        userPasswordField.setFont(new Font("Arial", Font.PLAIN, 18));
        userPasswordField.setBackground(new Color(226, 226, 226));
        userPasswordField.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
        userIdField.setBounds(38, 100, 240, 32);
        panel.add(userIdField);
        userIdField.setFont(new Font("Arial", Font.PLAIN, 18));
        userIdField.setBackground(new Color(226, 226, 226));
        userIdField.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
        userPasswordLabel.setBounds(38, 135, 214, 38);
        panel.add(userPasswordLabel);
        userPasswordLabel.setFont(new Font("Arial", Font.BOLD, 18));
        userPasswordLabel.setForeground(new Color(0, 0, 0));
        userIdLabel.setBounds(38, 64, 214, 38);
        panel.add(userIdLabel);
        userIdLabel.setFont(new Font("Arial", Font.BOLD, 18));
        userIdLabel.setForeground(new Color(0, 0, 0));
        resetButton.addActionListener(this);
        logInButton.addActionListener(this);
        signUpButton.addActionListener(this);
        lblNewLabel.setBackground(new Color(194, 192, 192));
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\ARAVHEIYL FELICISIMO\\Downloads\\DCF\\LogInBackG.png"));
        lblNewLabel.setBounds(-20, -28, 910, 622);
        
        logInFrame.getContentPane().add(lblNewLabel);
>>>>>>> 1af362b800b4da53edba7022ccc17e6d484bc950
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
<<<<<<< HEAD
        } else if (action.getSource() == signUpButton) {
            new userRegistrationPage(userLogInfo); // Assuming a userRegistrationPage class exists
        }
=======
        } 
    }
    
    public static void main(String[] args)
    {
    	new LogInPage();
>>>>>>> 1af362b800b4da53edba7022ccc17e6d484bc950
    }
}
