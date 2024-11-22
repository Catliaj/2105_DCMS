package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;
import DCMS_DB_CONNECTION.DB_DCMSConnection;
import backend.feedback_backend;

public class FeedbackForm implements ActionListener {
	feedback_backend backend =new  feedback_backend();
	DB_DCMSConnection dcmsConnection = new DB_DCMSConnection();
	private Connection connection;
	
	
	JOptionPane message = new JOptionPane();
    JFrame FeedbackForm = new JFrame("DCF Dental Clinic");
    JButton sumbitBtn = new JButton("SUBMIT");
    JPanel content = new BackgroundPanel("/Resources/Background (2).png");

    JButton homeBtn = new JButton("HOME");
    JButton aboutUsBtn = new JButton("ABOUT US");
    JButton servicesBtn = new JButton("SERVICES");
    JButton productsBtn = new JButton("PRODUCTS");
    JButton contactUsBtn = new JButton("CONTACT US");
    JButton feedbackBtn = new JButton("FEEDBACK");
    
    JPanel header = new JPanel();

    JTextField nameField = new JTextField(15);  // Smaller size for name field
    JTextField emailField = new JTextField(15);  // Smaller size for email field
    JTextField phoneNumberField = new JTextField(15);  // Smaller size for phone number field
    JTextArea reasonField = new JTextArea(5, 20);  // Larger message box

    JLabel messageLabel = new JLabel("");  // Declared once here for use below
    JPanel footer = new JPanel();
    JLabel dateTimeLabel = new JLabel();

    FeedbackForm() {
        // Frame setup
    	connection = dcmsConnection.getConnection();
        ImageIcon image = new ImageIcon(getClass().getResource("/Resources/DCFlogo.png"));
        FeedbackForm.setIconImage(image.getImage());
        FeedbackForm.setLayout(new BorderLayout());
        FeedbackForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        FeedbackForm.setSize(1440, 1024);

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
        feedbackBtn.setFont(new Font("Arial", Font.BOLD, 16));
        feedbackBtn.setForeground(Color.BLACK);
        feedbackBtn.setBackground(Color.white); 
        feedbackBtn.setFocusPainted(false);
        feedbackBtn.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        feedbackBtn.addActionListener(this);

        navPanel.add(homeBtn);
        navPanel.add(aboutUsBtn);
        navPanel.add(servicesBtn);
        navPanel.add(productsBtn);
        navPanel.add(contactUsBtn);
        navPanel.add(feedbackBtn);

        header.add(navPanel, BorderLayout.CENTER);
        FeedbackForm.add(header, BorderLayout.NORTH);

        // Content area
        content.setLayout(new GridBagLayout());  
        content.setBackground(new Color(5, 59, 67)); 

        // Form setup
        JPanel formPanel = new JPanel();
        formPanel.setPreferredSize(new Dimension(500, 600));
        formPanel.setBackground(Color.WHITE);  
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));  
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel("FEEDBACK FORM");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        formPanel.add(titleLabel);

        formPanel.add(createFormField("NAME", nameField));  // Smaller field
        formPanel.add(createFormField("EMAIL", emailField));  // Smaller field
        formPanel.add(createFormField("PHONE NUMBER", phoneNumberField));  // Smaller field

        // MESSAGE textarea with larger size
        JPanel messagePanel = new JPanel();
        messagePanel.setLayout(new BorderLayout());
        messagePanel.setBackground(Color.WHITE);  // Ensure background matches form's background

        // MESSAGE/COMMENTS/SUGGESTIONS label at the top of the text area
        JLabel messageTitleLabel = new JLabel("MESSAGE/COMMENTS/SUGGESTIONS");
        messageTitleLabel.setFont(new Font("Arial", Font.BOLD, 14));
        messageTitleLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));  // Add padding below the label
        messagePanel.add(messageTitleLabel, BorderLayout.NORTH);

        reasonField.setPreferredSize(new Dimension(300, 200));  // Make it bigger
        reasonField.setLineWrap(true);  // Allow text to wrap within the text area
        reasonField.setWrapStyleWord(true);  // Wrap words instead of cutting them off
        reasonField.setSelectionColor(Color.WHITE);  // Remove gray highlight from selection

        // Add border to the text area for visibility
        reasonField.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1)); // Add a border outline

        messagePanel.add(reasonField, BorderLayout.CENTER);

        formPanel.add(messagePanel);

        sumbitBtn.setFont(new Font("Arial", Font.BOLD, 18));
        sumbitBtn.setForeground(Color.WHITE);
        sumbitBtn.setBackground(new Color(5, 59, 67));  
        sumbitBtn.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        sumbitBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        sumbitBtn.addActionListener(this);
        formPanel.add(Box.createVerticalStrut(20));  
        formPanel.add(sumbitBtn);

        messageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        formPanel.add(messageLabel);

        content.add(formPanel);
        FeedbackForm.add(content, BorderLayout.CENTER);

        // Footer setup
        footer.setLayout(new BorderLayout());
        footer.setPreferredSize(new Dimension(1440, 50));
        footer.setBackground(new Color(5, 59, 67));

        Timer timer = new Timer(1000, e -> updateDateTime());
        timer.start();

        footer.add(dateTimeLabel, BorderLayout.CENTER);
        dateTimeLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        dateTimeLabel.setForeground(Color.WHITE);
        FeedbackForm.add(footer, BorderLayout.SOUTH);
        FeedbackForm.setVisible(true);
        FeedbackForm.setLocationRelativeTo(null);
        
    }

    private void setButtonStyles(JButton button) {
        button.setFont(new Font("Arial", Font.BOLD, 16));
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(5, 59, 67)); 
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        button.addActionListener(this);
    }

    private void updateDateTime() {
        String dateTime = new SimpleDateFormat("EEEE, MMMM d, yyyy hh:mm:ss a").format(new Date());
        dateTimeLabel.setText(dateTime);
    }

    private JPanel createFormField(String labelText, JTextField textField) {
        JPanel fieldPanel = new JPanel();
        fieldPanel.setLayout(new BorderLayout());
        fieldPanel.setBackground(Color.WHITE);

        JLabel label = new JLabel(labelText);
        label.setFont(new Font("Arial", Font.BOLD, 14));
        label.setForeground(Color.BLACK);

        textField.setPreferredSize(new Dimension(250, 30));  // Adjusted size for smaller fields
        textField.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));

        fieldPanel.add(label, BorderLayout.NORTH);
        fieldPanel.add(textField, BorderLayout.CENTER);
        fieldPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));  

        return fieldPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == sumbitBtn) {
            backend.setName(nameField.getText());
            backend.setEmail(emailField.getText());
            backend.setPhoneNumber(phoneNumberField.getText());
            backend.setFeedback(reasonField.getText());
            new  feedback_backend(backend.getName(),backend.getEmail(),backend.getPhoneNumber(),backend.getFeedback());
            nameField.setText("");
            emailField.setText("");
            phoneNumberField.setText("");
            reasonField.setText("");
        } else if (e.getSource() == homeBtn) {
            FeedbackForm.dispose();
            new homePage();
        } else if (e.getSource() == aboutUsBtn) {
            FeedbackForm.dispose();
            new aboutUs();
        }
		else if(e.getSource() == servicesBtn)
		{
			FeedbackForm.dispose();
			new BracesPage();
		}
		else if(e.getSource() == servicesBtn)
		{
			FeedbackForm.dispose();
			new product();
			}
		else if(e.getSource() == contactUsBtn)
		{
			FeedbackForm.dispose();
			new ContactUs();
		}

        else if(e.getSource() == productsBtn)
        {
        	FeedbackForm.dispose();
        	new product();
        }

    }

    class BackgroundPanel extends JPanel {
        private Image backgroundImage;

        public BackgroundPanel(String imagePath) {
            backgroundImage = new ImageIcon(getClass().getResource(imagePath)).getImage();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
