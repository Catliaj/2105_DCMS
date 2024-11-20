package Main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;

// for button
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
// swing
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


import Main.aboutUs.BackgroundPanel;



public class homePage implements ActionListener
{

    JFrame homepage = new JFrame("DCF Dental Clinic");
    JButton homeBtn = new JButton("HOME");
    JButton aboutUsBtn = new JButton("ABOUT US");
    JButton servicesBtn = new JButton("SERVICES");
    JButton productsBtn = new JButton("PRODUCTS");
    JButton contactUsBtn = new JButton("CONTACT US");
    JButton feedbackBtn = new JButton("FEEDBACK");
    JPanel header = new JPanel();

    JPanel content = new BackgroundPanel("/Resources/Background (2).png"); 
    
    homePage() 
    {

    	
    	//contentLogo
    	ImageIcon logoIcon = new ImageIcon(getClass().getResource("/Resources/DCFlogo.png"));  // Use relative path
        Image scaledLogo = logoIcon.getImage().getScaledInstance(300, 250, Image.SCALE_SMOOTH);  // Scale the image
        JLabel logoLabel = new JLabel(new ImageIcon(scaledLogo));  // Add scaled image to JLabel
          
        
        //header Logo
    	ImageIcon headerLogo = new ImageIcon(getClass().getResource("/Resources/haederLogo.png"));  // Use relative path
        Image scaledHeader = headerLogo.getImage().getScaledInstance(250, 150, Image.SCALE_SMOOTH);  // Scale the image
        JLabel Header = new JLabel(new ImageIcon(scaledHeader));  // Add scaled image to JLabel
        // Set window icon (use a relative path)
        ImageIcon image = new ImageIcon(getClass().getResource("/Resources/Logo.jpg"));  // Corrected relative path
        homepage.setIconImage(image.getImage());

        homepage.getContentPane().setLayout(new BorderLayout());
        homepage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        homepage.setSize(1440, 1024);
        
        
        // Header (Navigation bar)
       
        header.setLayout(new BorderLayout());
        header.setPreferredSize(new Dimension(100, 100));
        header.setBackground(new Color(5,59,67));

  
        
        JPanel logoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        logoPanel.setBackground(new Color(5, 59, 67));
        logoPanel.add(Header); 
       
        header.add(logoPanel, BorderLayout.WEST);

        // Navigation buttons
        JPanel navPanel = new JPanel(new GridLayout(1, 6, 10, 0)); // 1 row, 6 columns, 10px gap
        navPanel.setBackground(new Color(5, 59, 67));
        
        //style for home button
        homeBtn.setFont(new Font("Arial", Font.BOLD, 16));
        homeBtn.setBackground(Color.WHITE);
        homeBtn.setForeground(new Color(5, 59, 67));
        homeBtn.setFocusable(false);
        homeBtn.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        
        setButtonStyles(aboutUsBtn);
        setButtonStyles(servicesBtn);
        setButtonStyles(productsBtn);
        setButtonStyles(contactUsBtn);
        setButtonStyles(feedbackBtn);
        
        navPanel.add(homeBtn);
        navPanel.add(aboutUsBtn);
        navPanel.add(servicesBtn);
        productsBtn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		 homepage.dispose(); // Close the current frame
        	        new product(); // Open the ProductForm
        	}
        });
     

        navPanel.add(productsBtn);
        navPanel.add(contactUsBtn);
        navPanel.add(feedbackBtn);

        header.add(navPanel, BorderLayout.CENTER);
        homepage.getContentPane().add(header, BorderLayout.NORTH);

        // Content area
        content.setLayout(new BorderLayout());
        content.setBackground(new Color(2, 98, 100));

        // Left side content (Main heading)
        JPanel textPanel = new JPanel();
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
        textPanel.setBackground(new Color(5, 59, 67));
        
        // Loading and scaling the logo image (new change)
      
        
        JLabel clinicName = new JLabel("DCF DENTAL CLINIC");
        clinicName.setForeground(Color.WHITE);
        clinicName.setFont(new Font("Arial", Font.BOLD, 52));
        
        JLabel subText = new JLabel("Your Convenient, Accommodating, and Affordable Dental Partner.");
        subText.setForeground(Color.WHITE);
        subText.setFont(new Font("Arial", Font.PLAIN, 25));
        
        textPanel.add(Box.createVerticalStrut(150));  // Spacing
        textPanel.add(logoLabel);  // Add logo label (with new image)
        textPanel.add(Box.createVerticalStrut(30));  // More spacing
        textPanel.add(clinicName);
        textPanel.add(Box.createVerticalStrut(30));  // Spacing before subtext
        textPanel.add(subText);
        textPanel.setBorder(BorderFactory.createEmptyBorder(20, 100, 20, 40));
        
        content.add(textPanel, BorderLayout.WEST);

        // Right side images
        JPanel imagePanel = new JPanel(new GridLayout(2, 1, 10, 10));
        imagePanel.setBackground(new Color(2, 98, 112));

        // Load and scale content images (new change)
        ImageIcon contentImage1 = new ImageIcon(getClass().getResource("/Resources/content1.png")); 
        ImageIcon contentImage2 = new ImageIcon(getClass().getResource("/Resources/content2.png"));  
        
        JLabel image1 = new JLabel(contentImage1);  // Placeholder image 1
        JLabel image2 = new JLabel(contentImage2);  // Placeholder image 2
        
        imagePanel.add(image1);
        imagePanel.add(image2);

        content.add(imagePanel);
        homepage.getContentPane().add(content, BorderLayout.CENTER);

        // Make frame visible
        homepage.setVisible(true);
        textPanel.setOpaque(false);
        clinicName.setOpaque(false);
        subText.setOpaque(false);
        imagePanel.setOpaque(false);

        
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
			homepage.dispose();
			new homePage();
		}
		else if(e.getSource() == aboutUsBtn)
		{
			homepage.dispose();
			new aboutUs();
		}
		else if(e.getSource() == servicesBtn)
		{
			homepage.dispose();
			new BracesPage();
		}
		else if(e.getSource() == contactUsBtn )
		{
			homepage.dispose();
			new ContactUs();
		}
        else if(e.getSource() == feedbackBtn)
        {
        	homepage.dispose();
        	new FeedbackForm();
        }
		
    }
	
	class BackgroundPanel extends JPanel 
	{
	    private Image backgroundImage;

	    public BackgroundPanel(String imagePath) 
	    {
	        // Load the new background image
	        backgroundImage = new ImageIcon(getClass().getResource("/Resources/Background (2).png")).getImage();
	    }

	    @Override
	    protected void paintComponent(Graphics g) 
	    {
	        super.paintComponent(g);
	        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
	    }
	}

	public static void main(String[] args)
	{
		new homePage();
	}
	
}