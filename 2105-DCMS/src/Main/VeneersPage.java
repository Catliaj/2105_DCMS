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

import Main.CABPage.BackgroundPanel;

public class VeneersPage implements ActionListener {
	 JFrame homepage = new JFrame("DCF Dental Clinic");
	    JButton homeBtn = new JButton("HOME");
	    JButton aboutUsBtn = new JButton("ABOUT US");
	    JButton servicesBtn = new JButton("SERVICES");
	    JButton appointmentBtn = new JButton("APPOINTMENT");
	    JButton productsBtn = new JButton("PRODUCTS");
	    JButton contactUsBtn = new JButton("CONTACT US");

	    // Create a side panel with 13 buttons
	    JPanel sidePanel = new JPanel();
	    JButton[] sideButtons = new JButton[13];

	    // Array of button names
	    String[] buttonNames = {
	        "Braces", "Crowns & Bridges", "Veneers", "Teeth Whitening", "Fillings",
	        "Cleaning", "Extractions", "General Consultation", "Dentures", "Root Canal",
	        "Implants", "Pediatric Dentistry", "Dental X-ray"
	    };

	    JPanel header = new JPanel();
	    JPanel content = new BackgroundPanel("/Resources/AUBackG.png");  // Use custom panel with background

	    VeneersPage() {
	        // Set window icon
	        ImageIcon image = new ImageIcon(getClass().getResource("/Resources/Logo.png"));
	        homepage.setIconImage(image.getImage());

	        homepage.setLayout(new BorderLayout());
	        homepage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        homepage.setSize(1440, 1024);

	        // Create side panel with buttons
	        sidePanel.setLayout(new GridLayout(13, 1, 5, 5)); // 13 buttons in a single column
	        sidePanel.setPreferredSize(new Dimension(200, 0)); // Set width for the side panel
	        sidePanel.setBackground(new Color(5, 59, 67));

	        // Initialize and add buttons to side panel
	        for (int i = 0; i < sideButtons.length; i++) {
	            sideButtons[i] = new JButton(buttonNames[i]); // Set button name from array
	            sideButtons[i].setForeground(Color.WHITE);
	            sideButtons[i].setBackground(new Color(5, 59, 67));
	            sideButtons[i].setFocusable(false);
	            sideButtons[i].setFont(new Font("Arial", Font.BOLD, 14));
	            sideButtons[i].addActionListener(this);
	            // Set border for the button
	            if (i < sideButtons.length - 1) {
	                sideButtons[i].setBorder(BorderFactory.createCompoundBorder(
	                    BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(2, 98, 112)), // Bottom line
	                    BorderFactory.createEmptyBorder(10, 20, 10, 20) // Padding
	                ));
	            } else {
	                sideButtons[i].setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); // No border for the last button
	            }
	            sidePanel.add(sideButtons[i]);
	        }

	        // Header setup
	        header.setLayout(new BorderLayout());
	        header.setPreferredSize(new Dimension(100, 100));
	        header.setBackground(new Color(5, 59, 67));

	        // Header logo
	        ImageIcon headerLogo = new ImageIcon(getClass().getResource("/Resources/haederLogo.png"));
	        Image scaledHeader = headerLogo.getImage().getScaledInstance(250, 150, Image.SCALE_SMOOTH);
	        JLabel Header = new JLabel(new ImageIcon(scaledHeader));

	        JPanel logoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
	        logoPanel.setBackground(new Color(5, 59, 67));
	        logoPanel.add(Header);
	        header.add(logoPanel, BorderLayout.WEST);

	        // Navigation buttons
	        JPanel navPanel = new JPanel(new GridLayout(1, 6, 10, 0));
	        navPanel.setBackground(new Color(5, 59, 67));

	        // Set styles for buttons and add action listeners
	        setButtonStyles(homeBtn);
	        setButtonStyles(aboutUsBtn);
	        setButtonStyles(servicesBtn);
	        setButtonStyles(appointmentBtn);
	        setButtonStyles(productsBtn);
	        setButtonStyles(contactUsBtn);

	        navPanel.add(homeBtn);
	        navPanel.add(aboutUsBtn);
	        navPanel.add(servicesBtn);
	        navPanel.add(appointmentBtn);
	        navPanel.add(productsBtn);
	        navPanel.add(contactUsBtn);

	        header.add(navPanel, BorderLayout.CENTER);
	        homepage.add(header, BorderLayout.NORTH);

	        // Content area with background
	        content.setLayout(new FlowLayout(FlowLayout.RIGHT, 100, 50));  // Aligns components to the right

	        // Small rectangle panel 1
	        JPanel smallPanel = new JPanel();
	        smallPanel.setPreferredSize(new Dimension(620, 430));  // Adjust width and height if needed
	        smallPanel.setBackground(new Color(5, 59, 67)); 
	        smallPanel.setLayout(new BorderLayout()); 
	        smallPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));  // Adjust bottom padding if needed

	        // Title section
	        JPanel titlePanel = new JPanel();
	        titlePanel.setLayout(new FlowLayout(FlowLayout.LEFT)); 
	        titlePanel.setBackground(new Color(5, 59, 67)); 

	        ImageIcon originalIcon = new ImageIcon(getClass().getResource("/Resources/Logo.png"));
	        Image scaledImage = originalIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH); 
	        JLabel imageLabel = new JLabel(new ImageIcon(scaledImage));
	        imageLabel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); 

	        JLabel clinicName = new JLabel("VENEERS");
	        clinicName.setForeground(Color.WHITE);
	        clinicName.setFont(new Font("Arial", Font.BOLD, 50)); 
	        clinicName.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 10)); 

	        titlePanel.add(imageLabel);  
	        titlePanel.add(clinicName);  

	        smallPanel.add(titlePanel, BorderLayout.NORTH); 

	        // Subtext section
	        JLabel subText = new JLabel(
	              "<html>" + 
	              "<div style='text-align: justify;'>" +
	              "Veneers are thin, custom-made shells of tooth-colored<br>" +
	              "material that are bonded to the front of your teeth to<br>" +
	              "improve their appearance. They can correct a variety of<br>"+ 
	              "dental issues, including discoloration, chips, gaps and<br>"+ 
	              "misalignment, offering a natural-looking durable solution<br>"+
	              "for a flawless smile.<br><br><br>"+
	              "Porcelain Veneers: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 10,000 - 20,000 per tooth<br>" +
	              "Composite Veneers:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp 5,000 - 10,000 per tooth" + 
	              "</div></html>"
	        );

	        subText.setForeground(Color.WHITE);
	        subText.setFont(new Font("Arial", Font.PLAIN, 21)); 
	        subText.setBorder(BorderFactory.createEmptyBorder(10, 50, 30, 20));  //top, left, bottom, right

	        smallPanel.add(subText, BorderLayout.CENTER); 

	        // Add smallPanel to content
	        content.add(smallPanel); 

	        // Image panel with smaller images
	        JPanel imagePanel = new JPanel(new GridLayout(2, 1, 10, 50));
	        imagePanel.setBackground(new Color(2, 98, 112));

	        ImageIcon brace1 = new ImageIcon(new ImageIcon(getClass().getResource("/Resources/Veneers1.png")).getImage().getScaledInstance(400, 250, Image.SCALE_SMOOTH));
	        ImageIcon brace2 = new ImageIcon(new ImageIcon(getClass().getResource("/Resources/Veneers2.png")).getImage().getScaledInstance(400, 250, Image.SCALE_SMOOTH));

	        JLabel image1 = new JLabel(brace1);
	        JLabel image2 = new JLabel(brace2);

	        imagePanel.add(image1);
	        imagePanel.add(image2);

	        // Add imagePanel to content
	        content.add(imagePanel); // Add image panel below the first small panel

	        // Add sidePanel to the homepage on the left
	        homepage.add(sidePanel, BorderLayout.WEST);
	        // Add content to homepage
	        homepage.add(content, BorderLayout.CENTER);

	        // Make frame visible
	        homepage.setVisible(true);
	    }

	    // Method to set button styles
	    private void setButtonStyles(JButton button) {
	        button.setFont(new Font("Arial", Font.BOLD, 16));
	        button.setForeground(Color.WHITE);
	        button.setBackground(new Color(5, 59, 67));
	        button.setFocusable(false);
	        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
	        button.addActionListener(this); // Attach action listener to buttons
	    }

	    @Override
	    public void actionPerformed(ActionEvent e) {
	        // Handle button actions
	        if (e.getSource() == homeBtn) {
	        	homepage.dispose();
	        	new homePage();
	            
	        } else if (e.getSource() == aboutUsBtn) {
	        	homepage.dispose();
	            new aboutUs();
	        } else if (e.getSource() == appointmentBtn) {
	        	homepage.dispose();
	        	new appointmentPage();
	            
	            
	        } else if (e.getSource() == productsBtn) {
	        	
	            System.out.println("Products button clicked");
	            
	        } else if (e.getSource() == contactUsBtn) {
	        	homepage.dispose();
	            new  ContactUs();
	          
	        }

	        // Handle side button actions if needed
	        for (int i = 0; i < sideButtons.length; i++) {
	            if (e.getSource() == sideButtons[i]) {
	                handleSideButtonClick(i);  // Use the new method here
	                break;
	            }
	        }
	    }
	    
	    private void handleSideButtonClick(int index) {
	        System.out.println(buttonNames[index] + " button clicked");
	        
	        if (index == 0) { 
	            homepage.dispose();
	            new BracesPage();
	        }
	        else if (index == 1) { 
	            homepage.dispose();
	            new CABPage();
	        }
	        else if (index == 3) { 
	            homepage.dispose();
	            new TWPage();
	        }
	        else if (index == 4)
	        {
	        	homepage.dispose();
	        	new FillingsPage();
	        }
	        else if (index == 5)
	        {
	        	homepage.dispose();
	        	new CleaningPage();
	        }
	        else if (index == 6)
	        {
	        	homepage.dispose();
	        	new ExtractionPage();
	        }
	        else if (index == 7)
	        {
	        	homepage.dispose();
	        	new GCPage();
	        }
	        else if (index == 8)
	        {
	        	homepage.dispose();
	        	new DenturesPage();
	        }
	        else if (index == 9)
	        {
	        	homepage.dispose();
	        	new RCTPage();
	        }
	        else if (index == 10)
	        {
	        	homepage.dispose();
	        	new ImplantsPage();
	        }
	        else if (index == 11)
	        {
	        	homepage.dispose();
	        	new PediatricPage();
	        }
	        else if (index == 12)
	        {
	        	homepage.dispose();
	        	new XrayPage();
	        }
	        
	    }

	    // Background panel class for setting an image as a background
	    static class BackgroundPanel extends JPanel {
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

	    public static void main(String[] args) {
	        new VeneersPage(); // Instantiate homepage
	    }
	}


