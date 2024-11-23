package Main;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.sql.*;

public class product extends JFrame {

    private JPanel contentPane;

    // Database connection variables
    private static final String DB_URL = "jdbc:mysql://localhost:3306/dcfdentalclinicdb"; // Replace with your DB URL
    private static final String DB_USER = "root"; // Replace with your DB username
    private static final String DB_PASS = ""; // Replace with your DB password

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                product frame = new product();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    // Custom panel to handle background drawing
    class BackgroundPanel extends JPanel {
        private Image backgroundImage;

        public BackgroundPanel(Image backgroundImage) {
            this.backgroundImage = backgroundImage;
            setLayout(null); // Use absolute positioning for child components
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (backgroundImage != null) {
                // Draw the background image, scaled to fit the panel's size
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        }
    }

    public product() {
    	setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1300, 750);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Load background image
        ImageIcon bgIcon = new ImageIcon(product.class.getResource("/Resources/background (2).png"));
        Image bgImage = bgIcon.getImage();

        // Custom panel with background
        BackgroundPanel panel = new BackgroundPanel(bgImage);
        panel.setBounds(0, 0, 1284, 711);
        panel.setLayout(null);
        contentPane.add(panel);

        JLabel lblTitle = new JLabel("PREVENTIVE PRODUCTS");
        lblTitle.setForeground(Color.WHITE);
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 35));
        lblTitle.setBounds(47, 11, 500, 50);
        panel.add(lblTitle);

        // Panel to hold product panels
        JPanel productContainer = new JPanel();
        productContainer.setLayout(null); // Absolute layout for custom positioning
        productContainer.setPreferredSize(new Dimension(1200, 3000)); // Set a large preferred size for scrolling

        // Add JScrollPane to the panel
     // Add JScrollPane to the panel
     // Add JScrollPane to the panel
        JScrollPane scrollPane = new JScrollPane(productContainer);
        scrollPane.setBounds(50, 80, 1184, 600); // Position and size of the scroll pane
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

        // Set the viewport's background to transparent
        scrollPane.getViewport().setOpaque(false);

        // Make the product container background transparent
        productContainer.setOpaque(false);

        // Set the JScrollPane's background to transparent as well
        scrollPane.setOpaque(false);

        // Add the scroll pane to the panel
        panel.add(scrollPane);

        // Panels for products
        JPanel[] productPanels = new JPanel[100];
        JLabel[] productImages = new JLabel[100];
        JLabel[] productNames = new JLabel[100];
        JLabel[] productPrices = new JLabel[100];

        int x = 94, y = 20;
        for (int i = 0; i < 100; i++) {
            productPanels[i] = new JPanel();
            productPanels[i].setLayout(null);
            productPanels[i].setBounds(x, y, 176, 236);
            productPanels[i].setBackground(Color.LIGHT_GRAY); // Set background color to light gray
            productPanels[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
            productContainer.add(productPanels[i]);

            productImages[i] = new JLabel("");
            productImages[i].setBounds(10, 5, 156, 127);
            productImages[i].setBackground(Color.WHITE); // Set image background to white
            productImages[i].setOpaque(true); // Make label opaque to apply background color
            productImages[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
            productPanels[i].add(productImages[i]);

            productNames[i] = new JLabel("");
            productNames[i].setBounds(5, 151, 166, 26); // Adjust width to accommodate long names
            productNames[i].setHorizontalAlignment(SwingConstants.CENTER);
            productNames[i].setBackground(Color.WHITE); // Set product name background to white
            productNames[i].setOpaque(true); // Make label opaque to apply background color
            productNames[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
            productNames[i].setFont(new Font("Arial", Font.BOLD, 10));
            productPanels[i].add(productNames[i]);

            productPrices[i] = new JLabel("");
            productPrices[i].setBounds(35, 188, 106, 26);
            productPrices[i].setHorizontalAlignment(SwingConstants.CENTER);
            productPrices[i].setBackground(Color.WHITE); // Set product price background to white
            productPrices[i].setOpaque(true); // Make label opaque to apply background color
            productPrices[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
            productPanels[i].add(productPrices[i]);

            x += 269;
            if ((i + 1) % 4 == 0) {
                x = 94;
                y += 286;
            }
        }

        JButton btnBack = new JButton("BACK");
        btnBack.addActionListener(e -> {
            dispose();
            new homePage();
        });
        btnBack.setFont(new Font("Segoe UI", Font.BOLD, 23));
        btnBack.setBounds(1130, 20, 114, 48);
        panel.add(btnBack);

        // Load product data from the database
        loadProductData(productPanels, productImages, productNames, productPrices);
    }

    private void loadProductData(JPanel[] productPanels, JLabel[] productImages, JLabel[] productNames, JLabel[] productPrices) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
            String query = "SELECT ProductName, Price, Image FROM products";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            int index = 0;
            while (resultSet.next()) {
                // Retrieve product name and price
                String name = resultSet.getString("ProductName");
                String price = resultSet.getString("Price");

                // Retrieve the image as a byte array from the BLOB field
                byte[] imageBytes = resultSet.getBytes("Image");

                // Set product name and price
                productNames[index].setText(name);
                productPrices[index].setText("₱" + price);

                // Set product image
                if (imageBytes != null) {
                    ImageIcon icon = new ImageIcon(imageBytes);
                    Image scaledImage = icon.getImage().getScaledInstance(156, 127, Image.SCALE_SMOOTH);
                    productImages[index].setIcon(new ImageIcon(scaledImage));
                } else {
                    productImages[index].setText("No Image");
                }

                // Make the current panel visible
                productPanels[index].setVisible(true);
                index++; 
            }

            // Hide unused panels
            for (int i = index; i < productPanels.length; i++) {
                productPanels[i].setVisible(false);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error fetching product data: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
}
