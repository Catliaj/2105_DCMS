package Main;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.*;

import DCMS_DB_CONNECTION.DB_DCMSConnection;
import backend.newPatient_Backend;

public class LogInPage implements ActionListener {

    // Creating frame and components
    JOptionPane Message = new JOptionPane();
    JFrame logInFrame = new JFrame("Login Page");
    JButton logInButton = new JButton("LOG IN");
    JTextField userIdField = new JTextField();
    JPasswordField userPasswordField = new JPasswordField();
    JLabel userIdLabel = new JLabel("USERNAME");
    JLabel userPasswordLabel = new JLabel("PASSWORD");
    JLabel messageLabel = new JLabel();

    newPatient_Backend backend = new newPatient_Backend();
    DB_DCMSConnection dcmsConnection = new DB_DCMSConnection();
    private final JLabel ContentBackG = new JLabel("");
    private final JPanel panel = new JPanel();
    private final JLabel lblNewLabel_1 = new JLabel("LOG IN");
    private final JLabel linetxt = new JLabel("");

    public LogInPage() {
        messageLabel.setBounds(813, 100, 406, 50);
        messageLabel.setFont(new Font("Arial", Font.ITALIC, 20));
        messageLabel.setForeground(Color.WHITE);
        logInFrame.getContentPane().setLayout(null);
        logInFrame.getContentPane().add(messageLabel);

        // Frame settings
        logInFrame.setResizable(false);
        logInFrame.setTitle("LOG IN");
        logInFrame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\path\\to\\icon.png"));
        logInFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        logInFrame.getContentPane().setBackground(new Color(2, 79, 90));
        logInFrame.setSize(836, 589);
        logInFrame.setLocationRelativeTo(null);
        logInFrame.getContentPane().setLayout(null);
        panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        panel.setBackground(new Color(194, 192, 192));
        panel.setBounds(435, 109, 310, 320);

        logInFrame.getContentPane().add(panel);
        panel.setLayout(null);
        lblNewLabel_1.setBounds(20, 21, 136, 25);
        lblNewLabel_1.setForeground(new Color(86, 86, 86));
        lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 30));
        panel.add(lblNewLabel_1);

        linetxt.setBounds(20, 43, 375, 13);
        linetxt.setForeground(new Color(137, 137, 137));
        panel.add(linetxt);

        logInButton.setBounds(70, 263, 167, 32);
        panel.add(logInButton);
        logInButton.setFocusable(false);
        logInButton.setFont(new Font("Arial", Font.BOLD, 18));
        logInButton.setForeground(Color.WHITE);
        logInButton.setBackground(Color.BLACK);

        userPasswordField.setBounds(38, 176, 240, 32);
        panel.add(userPasswordField);
        userPasswordField.setFont(new Font("Arial", Font.PLAIN, 18));
        userPasswordField.setBackground(new Color(226, 226, 226));
        userPasswordField.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));

        userIdField.setBounds(38, 100, 240, 32);
        panel.add(userIdField);
        userIdField.setFont(new Font("Arial", Font.PLAIN, 18));
        userIdField.setBackground(new Color(226, 226, 226));
        userIdField.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));

        userPasswordLabel.setBounds(38, 142, 214, 38);
        panel.add(userPasswordLabel);
        userPasswordLabel.setFont(new Font("Arial", Font.BOLD, 18));
        userPasswordLabel.setForeground(new Color(0, 0, 0));

        userIdLabel.setBounds(38, 64, 214, 38);
        panel.add(userIdLabel);
        userIdLabel.setFont(new Font("Arial", Font.BOLD, 18));
        userIdLabel.setForeground(new Color(0, 0, 0));

        JCheckBox ShowPasswordCheckbox = new JCheckBox("Show Password");
        ShowPasswordCheckbox.setFont(new Font("Segoe UI", Font.BOLD, 10));
        ShowPasswordCheckbox.setBackground(new Color(194, 192, 192));
        ShowPasswordCheckbox.setBounds(184, 210, 126, 21);
        panel.add(ShowPasswordCheckbox);

        ShowPasswordCheckbox.addActionListener(e -> {
            if (ShowPasswordCheckbox.isSelected()) {
                userPasswordField.setEchoChar((char) 0);
            } else {
                userPasswordField.setEchoChar('•');
            }
        });

        logInButton.addActionListener(this);
        ContentBackG.setHorizontalAlignment(SwingConstants.CENTER);
        ContentBackG.setBackground(new Color(194, 192, 192));
        ContentBackG.setIcon(new ImageIcon("C:\\path\\to\\background.png"));
        ContentBackG.setBounds(-12, -23, 901, 622);
        logInFrame.setLocationRelativeTo(null);
        logInFrame.getContentPane().add(ContentBackG);
        logInFrame.setVisible(true);

        userPasswordField.setEchoChar('•');
    }

    @Override
    public void actionPerformed(ActionEvent action) {
        if (action.getSource() == logInButton) {
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

                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "Login Successfully");
                    logInFrame.dispose();
                    new Dashboard();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password", "Try", JOptionPane.YES_OPTION);
                }
                con.close();
            } catch (Exception ex) {
                ex.printStackTrace();
                messageLabel.setText("Error: " + ex.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        new LogInPage();
    }
}
