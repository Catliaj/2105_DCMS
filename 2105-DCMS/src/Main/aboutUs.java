package Main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

// Arrah Part

public class aboutUs implements ActionListener {

    JFrame aboutpage = new JFrame("DCF Dental Clinic");
    JButton homeBtn = new JButton("HOME");
    JButton aboutUsBtn = new JButton("ABOUT US");
    JButton servicesBtn = new JButton("SERVICES");
    JButton productsBtn = new JButton("PRODUCTS");
    JButton contactUsBtn = new JButton("CONTACT US");
    JButton feedbackBtn = new JButton("FEEDBACK");


    JPanel header = new JPanel();
    JPanel content = new BackgroundPanel("Background (2).png");  // Use custom panel with background

    aboutUs() {
        // Set window icon
        ImageIcon image = new ImageIcon(getClass().getResource("/Resources/DCFlogo.png"));
        aboutpage.setIconImage(image.getImage());
        aboutpage.setLayout(new BorderLayout());
        aboutpage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        aboutpage.setSize(1440, 1024);

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
        
        // Set styles for buttons
        aboutUsBtn.setFont(new Font("Arial", Font.BOLD, 16));
        aboutUsBtn.setBackground(Color.WHITE);
        aboutUsBtn.setForeground(new Color(2, 79, 90));
        aboutUsBtn.setFocusable(false);
        aboutUsBtn.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        
        setButtonStyles(homeBtn);
        setButtonStyles(servicesBtn);
        setButtonStyles(productsBtn);
        setButtonStyles(contactUsBtn);
        setButtonStyles(feedbackBtn);


        navPanel.add(homeBtn);
        navPanel.add(aboutUsBtn);
        navPanel.add(servicesBtn);
        navPanel.add(productsBtn);
        navPanel.add(contactUsBtn);
        navPanel.add(feedbackBtn);

        header.add(navPanel, BorderLayout.CENTER);
        aboutpage.add(header, BorderLayout.NORTH);

        // Content area with background
        content.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 100)); 

        // Small rectangle panel
        JPanel smallPanel = new JPanel();
        smallPanel.setPreferredSize(new Dimension(900, 500)); 
        smallPanel.setBackground(new Color(5, 59, 67)); 
        smallPanel.setLayout(new BorderLayout()); 

        // Title section
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new FlowLayout(FlowLayout.LEFT)); 
        titlePanel.setBackground(new Color(5, 59, 67)); 

        ImageIcon originalIcon = new ImageIcon(getClass().getResource("/Resources/DCFlogo.png"));
        Image scaledImage = originalIcon.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH); 
        JLabel imageLabel = new JLabel(new ImageIcon(scaledImage));
        imageLabel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); 

        JLabel clinicName = new JLabel("ABOUT US");
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
              "Welcome to DCF Dental Clinic, your trusted dental care provider. We are committed to offering high-quality,<br>" +
              "personalized dental care to ensure your smile is both healthy and radiant. Our clinic is equipped with<br>" +
              "the latest dental technology, allowing us to provide comprehensive and efficient treatments in a relaxing<br>" +
              "and stress-free atmosphere.<br><br>" +
              "At DCF Dental Clinic, our experienced and compassionate team is dedicated to catering to your unique dental<br>" +
              "needs. We offer a wide range of services, including routine dental check-ups, teeth cleanings, teeth fillings,<br>" +
              "root canals, and periodontal treatments. Additionally, we specialize in advanced cosmetic procedures such<br>" +
              "as teeth whitening, veneers, crowns, and smile makeovers, ensuring that your smile not only functions well<br>" +
              "but looks great too.<br><br>" +
              "Come experience our friendly, patient-centered approach and let us help you achieve a beautiful, healthy smile!"+
              "</div></html>"
        );

        subText.setForeground(Color.WHITE);
        subText.setFont(new Font("Arial", Font.PLAIN, 17)); 
        subText.setBorder(BorderFactory.createEmptyBorder(10, 50, 60, 30));  

        smallPanel.add(subText, BorderLayout.CENTER); 

        content.add(smallPanel);

        aboutpage.add(content, BorderLayout.CENTER);

        // Make frame visible
        aboutpage.setVisible(true);
        aboutpage.setLocationRelativeTo(null);
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
			aboutpage.dispose();
			new homePage();
		}
		else if(e.getSource() == servicesBtn)
		{
			aboutpage.dispose();
			new BracesPage();
		}
		else if(e.getSource() == contactUsBtn )
		{
			aboutpage.dispose();
			new ContactUs();
		}
        else if(e.getSource() == feedbackBtn)
        {
        	aboutpage.dispose();
        	new FeedbackForm();
        }
        else if(e.getSource() == productsBtn)
        {
        	aboutpage.dispose();
        	new product();
        }
		
    }

    // Custom JPanel for Background Image
    class BackgroundPanel extends JPanel {
        private Image backgroundImage;

        public BackgroundPanel(String imagePath) {
            // Load the background image
            backgroundImage = new ImageIcon(getClass().getResource("/Resources/Background (2).png")).getImage();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            // Draw the background image, scaled to fit the panel size
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
