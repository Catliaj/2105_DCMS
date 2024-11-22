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

public class ContactUs implements ActionListener {
    JFrame ContactUs = new JFrame("DCF Dental Clinic");
    JButton homeBtn = new JButton("HOME");
    JButton aboutUsBtn = new JButton("ABOUT US");
    JButton servicesBtn = new JButton("SERVICES");
    JButton productsBtn = new JButton("PRODUCTS");
    JButton contactUsBtn = new JButton("CONTACT US");
    JButton feedbackBtn = new JButton("FEEDBACK");
    JPanel header = new JPanel();
    JPanel content = new BackgroundPanel("/Resources/AUBackG.png"); // Use custom panel with background


    ContactUs() {
        // Set window icon
        ImageIcon image = new ImageIcon(getClass().getResource("/Resources/Logo.png"));
        ContactUs.setIconImage(image.getImage());

        ContactUs.setLayout(new BorderLayout());
        ContactUs.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ContactUs.setSize(1440, 1024);

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


        // Set styles for 
        contactUsBtn.setFont(new Font("Arial", Font.BOLD, 16));
        contactUsBtn.setBackground(Color.WHITE);
        contactUsBtn.setForeground(new Color(2, 79, 90));
        contactUsBtn.setFocusable(false);
        contactUsBtn.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        
        setButtonStyles(homeBtn);
        setButtonStyles(aboutUsBtn);
        setButtonStyles(servicesBtn);
        setButtonStyles(productsBtn);
        setButtonStyles(feedbackBtn);

        navPanel.add(homeBtn);
        navPanel.add(aboutUsBtn);
        navPanel.add(servicesBtn);
        navPanel.add(productsBtn);
        navPanel.add(contactUsBtn);
        navPanel.add(feedbackBtn);


        header.add(navPanel, BorderLayout.CENTER);
        ContactUs.add(header, BorderLayout.NORTH);

        // Content area with background
        content.setLayout(new BorderLayout());

        // Create a bottom panel to hold the three small panels
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        bottomPanel.setOpaque(false); // Make the bottom panel transparent

        // Create three smaller colored panels with two subtexts each

        JPanel smallPanel1 = createSmallPanel("/Resources/Contact1.png", "Give Us A Call", "Reach out to us directly.", "0912 345 6789");
        JPanel smallPanel2 = createSmallPanel("/Resources/Contact2.png", "We're On The Map", "Find us easily with our location.", "Malaruhatan, Lian, Batangas");
        JPanel smallPanel3 = createSmallPanel("/Resources/Contact3.png", "Write Us", "Send us a message anytime.", "support@DCFdentalclinic.com");


        // Add the small panels to the bottom panel
        bottomPanel.add(smallPanel1);
        bottomPanel.add(smallPanel2);
        bottomPanel.add(smallPanel3);

        // Central text area
        JLabel centerText = new JLabel("CONTACT US");
        centerText.setForeground(Color.WHITE);
        centerText.setFont(new Font("Arial", Font.BOLD, 70));
        centerText.setHorizontalAlignment(JLabel.CENTER);
        centerText.setVerticalAlignment(JLabel.CENTER);
        content.add(centerText, BorderLayout.CENTER);
        centerText.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 20));


        // Create a separate panel for subtext
        JPanel subTextPanel = new JPanel();
        subTextPanel.setLayout(new BorderLayout());
        subTextPanel.setOpaque(false);  // Make the subTextPanel transparent

        // Subtext below "CONTACT US"
        JLabel subText = new JLabel("Call Us, Write Us, Or Knock Us On Our Door");
        subText.setForeground(Color.WHITE);
        subText.setFont(new Font("Arial", Font.PLAIN, 30));
        subText.setHorizontalAlignment(JLabel.CENTER);
        subTextPanel.add(subText, BorderLayout.NORTH);
        subText.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 20));


        // Create a panel to hold additional text and the new additional text
        JPanel textPanel = new JPanel();
        textPanel.setLayout(new BorderLayout());
        textPanel.setOpaque(false); // Make the panel transparent

        // Additional text below the subText
        JLabel additionalText = new JLabel("WE WOULD BE HAPPY TO MEET YOU!");
        additionalText.setForeground(Color.WHITE);
        additionalText.setFont(new Font("Arial", Font.BOLD, 50));
        additionalText.setHorizontalAlignment(JLabel.CENTER);
        textPanel.add(additionalText, BorderLayout.NORTH);
        additionalText.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 20));


        // New text below "WE WOULD BE HAPPY TO MEET YOU!"
        JLabel newAdditionalText = new JLabel("<html>We’re ready to help to book you in or with any questions you may have about seeing our dental team.");
        newAdditionalText.setForeground(Color.WHITE);
        newAdditionalText.setFont(new Font("Arial", Font.PLAIN, 25));
        newAdditionalText.setHorizontalAlignment(JLabel.CENTER);
        textPanel.add(newAdditionalText, BorderLayout.CENTER);

        newAdditionalText.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Padding for new text


        // Now add the textPanel to the subTextPanel
        subTextPanel.add(textPanel, BorderLayout.CENTER);

        // Finally, add the bottom panel below the text panel
        subTextPanel.add(bottomPanel, BorderLayout.SOUTH);

        // Add subTextPanel to the content area
        content.add(subTextPanel, BorderLayout.SOUTH);

        ContactUs.add(content, BorderLayout.CENTER);

        // Make frame visible
        ContactUs.setVisible(true);
        ContactUs.setLocationRelativeTo(null);
    }

    // Method to create a small panel with an image, main text, and two subtexts
    private JPanel createSmallPanel(String imagePath, String mainText, String subText1, String subText2) {
        JPanel smallPanel = new JPanel();
        smallPanel.setPreferredSize(new Dimension(400, 250));
        smallPanel.setBackground(new Color(5, 59, 67));
        smallPanel.setLayout(new BorderLayout());

        // Add image to small panel
        JLabel panelImage = new JLabel(new ImageIcon(new ImageIcon(getClass().getResource(imagePath))
                .getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
        panelImage.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 20)); // Add padding around the image

        // Add main text to small panel
        JLabel panelText = new JLabel(mainText);
        panelText.setForeground(Color.WHITE);
        panelText.setFont(new Font("Arial", Font.BOLD, 20));
        panelText.setHorizontalAlignment(JLabel.CENTER);
        panelText.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        // Add first subtext to small panel
        JLabel panelSubText1 = new JLabel(subText1);
        panelSubText1.setForeground(Color.WHITE);
        panelSubText1.setFont(new Font("Arial", Font.PLAIN, 16));
        panelSubText1.setHorizontalAlignment(JLabel.CENTER);
        panelSubText1.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 20));

        // Add second subtext to small panel
        JLabel panelSubText2 = new JLabel(subText2);
        panelSubText2.setForeground(Color.WHITE);
        panelSubText2.setFont(new Font("Arial", Font.PLAIN, 18));
        panelSubText2.setHorizontalAlignment(JLabel.CENTER);
        panelSubText2.setBorder(BorderFactory.createEmptyBorder(10, 20, 20, 20));

        // Adding components to the small panel
        smallPanel.add(panelImage, BorderLayout.NORTH);
        smallPanel.add(panelText, BorderLayout.CENTER);

        // Create a panel for subtexts to manage their layout
        JPanel subTextPanel = new JPanel(new GridLayout(2, 1)); // GridLayout for two subtexts
        subTextPanel.setOpaque(false); // Make it transparent
        subTextPanel.add(panelSubText1);
        subTextPanel.add(panelSubText2);

        smallPanel.add(subTextPanel, BorderLayout.SOUTH);

        return smallPanel;
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

    public void actionPerformed(ActionEvent e) 
    {
        // Handle button actions
		if (e.getSource() == homeBtn) 
		{
			ContactUs.dispose();
			new homePage();
		}
		else if(e.getSource() == aboutUsBtn)
		{
			ContactUs.dispose();
			new aboutUs();
		}
		else if(e.getSource() == servicesBtn)
		{
			ContactUs.dispose();
			new BracesPage();
		}
        else if(e.getSource() == feedbackBtn)
        {
        	ContactUs.dispose();
        	new FeedbackForm();
        }
        else if(e.getSource() == productsBtn)
        {
        	ContactUs.dispose();
        	new product();
        }


		
		
    }
    // Custom JPanel for Background Image
    class BackgroundPanel extends JPanel {
        private Image backgroundImage;

        public BackgroundPanel(String imagePath) {
            // Load the background image
            backgroundImage = new ImageIcon(getClass().getResource(imagePath)).getImage();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            // Draw the background image, scaled to fit the panel size
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
