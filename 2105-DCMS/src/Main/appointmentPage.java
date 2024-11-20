package Main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class appointmentPage implements ActionListener
{
    JFrame appointmentPage = new JFrame("DCF Dental Clinic");
    JButton homeBtn = new JButton("HOME");
    JButton aboutUsBtn = new JButton("ABOUT US");
    JButton servicesBtn = new JButton("SERVICES");
    JButton appointmentBtn = new JButton("APPOINTMENT");
    JButton productsBtn = new JButton("PRODUCTS");
    JButton contactUsBtn = new JButton("CONTACT US");
    JButton bookBtn = new JButton("Book Now");
    JPanel header = new JPanel();
    JPanel content = new BackgroundPanel("Background (2).png");  // Use custom panel with background

    appointmentPage() {
        // Set window icon
        ImageIcon image = new ImageIcon(getClass().getResource("DCFlogo.png"));
        appointmentPage.setIconImage(image.getImage());

        appointmentPage.setLayout(new BorderLayout());
        appointmentPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        appointmentPage.setSize(1440, 1024);

        // Header setup
        header.setLayout(new BorderLayout());
        header.setPreferredSize(new Dimension(100, 100));
        header.setBackground(new Color(5, 59, 67));

        // Header logo
        ImageIcon headerLogo = new ImageIcon(getClass().getResource("haederLogo.png"));
        Image scaledHeader = headerLogo.getImage().getScaledInstance(250, 150, Image.SCALE_SMOOTH);
        JLabel Header = new JLabel(new ImageIcon(scaledHeader));

        JPanel logoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        logoPanel.setBackground(new Color(5, 59, 67));
        logoPanel.add(Header);
        header.add(logoPanel, BorderLayout.WEST);

        // Navigation buttons
        JPanel navPanel = new JPanel(new GridLayout(1, 6, 10, 0)); 
        navPanel.setBackground(new Color(5, 59, 67));

        // Set styles for buttons
        appointmentBtn.setFont(new Font("Arial", Font.BOLD, 16));
        appointmentBtn.setBackground(Color.WHITE);
        appointmentBtn.setForeground(new Color(2, 79, 90));
        appointmentBtn.setFocusable(false);
        appointmentBtn.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        
        setButtonStyles(homeBtn);
        setButtonStyles(servicesBtn);
        setButtonStyles(aboutUsBtn);
        setButtonStyles(productsBtn);
        setButtonStyles(contactUsBtn);
        
        bookBtn.setFont(new Font("Arial", Font.BOLD, 30));
        bookBtn.setForeground(Color.BLACK);
        bookBtn.setBackground(Color.WHITE);
        bookBtn.setFocusable(false);
        bookBtn.setBorder(BorderFactory.createEmptyBorder(50, 40, 50, 40));  // Adjust padding for better spacing
        bookBtn.addActionListener(this);
      
        
        navPanel.add(homeBtn);
        navPanel.add(aboutUsBtn);
        navPanel.add(servicesBtn);
        navPanel.add(appointmentBtn);
        navPanel.add(productsBtn);
        navPanel.add(contactUsBtn);

        header.add(navPanel, BorderLayout.CENTER);
        appointmentPage.add(header, BorderLayout.NORTH);

        // Content area with background
        content.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 100)); 

        // Left panel setup with title and subtext
        JPanel leftPanel = new JPanel();
        leftPanel.setPreferredSize(new Dimension(661, 500)); 
        leftPanel.setBackground(new Color(5, 59, 67)); 
        leftPanel.setLayout(new BorderLayout()); 

        // Title section for left panel
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new FlowLayout(FlowLayout.LEFT)); 
        titlePanel.setBackground(new Color(5, 59, 67)); 

        ImageIcon originalIcon = new ImageIcon(getClass().getResource("DCFlogo.png"));
        Image scaledImage = originalIcon.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH); 
        JLabel imageLabel = new JLabel(new ImageIcon(scaledImage));
        imageLabel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); 

        JLabel clinicName = new JLabel("BOOK AN APPOINTMENT");
        clinicName.setForeground(Color.WHITE);
        clinicName.setFont(new Font("Arial", Font.BOLD, 40)); 
        clinicName.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 10)); 

        titlePanel.add(imageLabel);  
        titlePanel.add(clinicName);  

        leftPanel.add(titlePanel, BorderLayout.NORTH); 

        // Subtext section
        JLabel subText = new JLabel(
              "<html>" + 
              "<div style='text-align: justify;'>" +
              "We are delighted to welcome,<br>" +
              "anyone with dental needs and<br>" +
              "inquiries to our practice. Our team <br>" +
              "and stress-free atmosphere.<br>" +
              "of experienced professionals is " +
              "committed to providing the highest<br>" +
              "quality of care for all your oral<br>" +
              "health needs.<br> <br>" +
              "We look forward to being able to<br>" +
              "provide you with exceptional service<br>"+ 
              "and an enjoyable experience in a <br>"+ 
              "safe, comfortable environment.<br>"+ 
              "</div></html>"
        );
        subText.setForeground(Color.WHITE);
        subText.setFont(new Font("Arial", Font.PLAIN, 17)); 
        subText.setBorder(BorderFactory.createEmptyBorder(10, 50, 60, 30));  
        
        leftPanel.add(subText, BorderLayout.CENTER); 

        // Right panel setup
        JPanel rightPanel = new JPanel();
        rightPanel.setPreferredSize(new Dimension(661, 500)); 
        rightPanel.setBackground(new Color(5, 59, 67)); 
        rightPanel.setLayout(new BorderLayout()); 

        JPanel titlePanel1 = new JPanel();
        titlePanel1.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20));
        titlePanel1.setBackground(new Color(5, 59, 67)); 

        JLabel imageLabel1 = new JLabel(new ImageIcon(scaledImage));
        imageLabel1.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); 

        JLabel clinicName1 = new JLabel("BOOK YOUR APPOINTMENT REQUEST");
        clinicName1.setForeground(Color.WHITE);
        clinicName1.setFont(new Font("Arial", Font.BOLD, 30)); 
        clinicName1.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10)); 
        
        
        titlePanel1.add(clinicName1);  
        titlePanel1.add(bookBtn);
        
        rightPanel.add(imageLabel1, BorderLayout.NORTH);
        rightPanel.add(titlePanel1,BorderLayout.CENTER); 
        
        content.add(leftPanel);
        content.add(rightPanel);

        appointmentPage.add(content, BorderLayout.CENTER);

        // Make frame visible
        appointmentPage.setVisible(true);
    }

    // Method to set button styles
    private void setButtonStyles(JButton button) {
        button.setFont(new Font("Arial", Font.BOLD, 16));
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(5, 59, 67));
        button.setFocusable(false);
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        button.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        // Handle button actions
		if (e.getSource() == homeBtn) 
		{
			appointmentPage.dispose();
			new homePage();
		}
		else if(e.getSource() == appointmentBtn)
		{
			appointmentPage.dispose();
			new appointmentPage();
		}
		else if(e.getSource() == aboutUsBtn)
		{
			appointmentPage.dispose();
			new aboutUs();
		}
		else if(e.getSource() == servicesBtn)
		{
			appointmentPage.dispose();
			new BracesPage();
		}
		else if(e.getSource() == contactUsBtn )
		{
			appointmentPage.dispose();
			new ContactUs();
		}
		else if(e.getSource() == bookBtn)
		{
			new AppointmentForm();
		}
    }

    // Custom JPanel for Background Image
    class BackgroundPanel extends JPanel {
        private Image backgroundImage;

        public BackgroundPanel(String imagePath) {
            // Load the background image
            backgroundImage = new ImageIcon(getClass().getResource("Background (2).png")).getImage();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            // Draw the background image, scaled to fit the panel size
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }

    public static void main(String[] args) {
        new appointmentPage();
    }
}
