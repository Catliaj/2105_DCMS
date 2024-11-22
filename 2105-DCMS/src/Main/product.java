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

    public product() {
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1300, 750);
        setLocationRelativeTo(null); 
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 1284, 711);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel lblTitle = new JLabel("PREVENTIVE PRODUCTS");
        lblTitle.setForeground(Color.WHITE);
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 35));
        lblTitle.setBounds(47, 11, 500, 50);
        panel.add(lblTitle);

        // Panels for products
        JPanel[] productPanels = new JPanel[8];
        JLabel[] productImages = new JLabel[8];
        JLabel[] productNames = new JLabel[8];
        JLabel[] productPrices = new JLabel[8];

        int x = 94, y = 120;
        for (int i = 0; i < 8; i++) {
            productPanels[i] = new JPanel();
            productPanels[i].setLayout(null);
            productPanels[i].setBounds(x, y, 176, 236);
            productPanels[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
            panel.add(productPanels[i]);

            productImages[i] = new JLabel("");
            productImages[i].setBounds(10, 5, 156, 127);
            productImages[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
            productPanels[i].add(productImages[i]);

            productNames[i] = new JLabel("");
            productNames[i].setBounds(20, 151, 132, 26);
            productNames[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
            productNames[i].setFont(new Font("Arial", Font.BOLD, 10)); 
            productPanels[i].add(productNames[i]);

            productPrices[i] = new JLabel("");
            productPrices[i].setBounds(30, 188, 112, 26);
            productPrices[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
            productPanels[i].add(productPrices[i]);

            x += 269;
            if ((i + 1) % 4 == 0) { // Move to the next row after every 4 items
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
        btnBack.setBounds(1160, 652, 114, 48);
        panel.add(btnBack);

        JLabel background = new JLabel("");
        background.setIcon(new ImageIcon(product.class.getResource("/Resources/background (2).png")));
        background.setBounds(0, 0, 1284, 711);
        panel.add(background);

        // Load product data from the database
        loadProductData(productImages, productNames, productPrices);
    }

    private void loadProductData(JLabel[] productImages, JLabel[] productNames, JLabel[] productPrices) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
            String query = "SELECT ProductName, Price, Image FROM products LIMIT 8";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            int index = 0;
            while (resultSet.next() && index < productImages.length) {
                // Retrieve product name and price
                String name = resultSet.getString("ProductName");
                String price = resultSet.getString("Price");

                // Debug: Log retrieved name and price
                System.out.println("Product Name: " + name);
                System.out.println("Price: ₱" + price);

                // Retrieve the image as a byte array from the BLOB field
                byte[] imageBytes = resultSet.getBytes("Image");

                // Set product name and price to their respective labels
                productNames[index].setText(name);
                productPrices[index].setText("₱" + price);

                if (imageBytes != null && imageBytes.length > 0) {
                    try {
                        // Convert the byte array to an ImageIcon
                        ImageIcon icon = new ImageIcon(imageBytes);

                        // Validate the image
                        if (icon.getImageLoadStatus() != MediaTracker.COMPLETE) {
                            throw new Exception("Image failed to load");
                        }

                        // Scale the image for display
                        Image scaledImage = icon.getImage().getScaledInstance(156, 127, Image.SCALE_SMOOTH);
                        if (scaledImage == null) {
                            throw new Exception("Scaled image is null");
                        }

                        // Set the scaled image to the JLabel
                        productImages[index].setIcon(new ImageIcon(scaledImage));
                        productImages[index].setText(""); // Clear any placeholder text
                    } catch (Exception e) {
                        System.out.println("Error processing image for product: " + name + " - " + e.getMessage());
                        productImages[index].setIcon(null);
                        productImages[index].setText("Invalid Image");
                    }
                } else {
                    // Handle case where no image is available
                    System.out.println("No image found for product: " + name);
                    productImages[index].setIcon(null);
                    productImages[index].setText("No Image");
                }

                // Ensure proper layout updates
                productImages[index].revalidate();
                productImages[index].repaint();

                index++;
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error fetching product data: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
            e.printStackTrace();
        }
    }



}
