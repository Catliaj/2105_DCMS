package Main;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import javax.swing.JOptionPane;

public class ProductAdmin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldProdName;
	private JTextField textFieldPrice;
	private JTextField textFieldProdID;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductAdmin frame = new ProductAdmin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ProductAdmin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1300, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1284, 722);
		panel.setBackground(new Color(2, 79, 90));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("PRODUCT INFORMATION");
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 27));
		lblNewLabel.setBounds(471, 43, 333, 42);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(128, 96, 1030, 535);
		panel_1.setBackground(new Color(194, 192, 192));
		
		
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Product Name");
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 22));
		lblNewLabel_1.setBounds(102, 149, 169, 31);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Product ID");
		lblNewLabel_1_1.setFont(new Font("Segoe UI", Font.BOLD, 22));
		lblNewLabel_1_1.setBounds(123, 107, 129, 31);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Price");
		lblNewLabel_1_2.setFont(new Font("Segoe UI", Font.BOLD, 22));
		lblNewLabel_1_2.setBounds(168, 191, 72, 31);
		panel_1.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("QTY");
		lblNewLabel_1_3.setToolTipText("");
		lblNewLabel_1_3.setFont(new Font("Segoe UI", Font.BOLD, 22));
		lblNewLabel_1_3.setBounds(168, 234, 72, 31);
		panel_1.add(lblNewLabel_1_3);
		
		JPanel panelImage = new JPanel();
		panelImage.setBounds(646, 107, 146, 119);
		panel_1.add(panelImage);
		panelImage.setLayout(null);
		
		JLabel lblIMAGE = new JLabel("");
		lblIMAGE.setBounds(0, 0, 146, 119);
		panelImage.add(lblIMAGE);
		
		JButton btnUpload = new JButton("Upload");
		btnUpload.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        JFileChooser fileChooser = new JFileChooser();
		        
		        // Set file filter to allow only PNG, JPG, and JPEG files
		        FileNameExtensionFilter fnwf = new FileNameExtensionFilter("PNG, JPG, and JPEG", "png", "jpeg", "jpg");
		        fileChooser.addChoosableFileFilter(fnwf);
		        
		        // Open file chooser dialog
		        int load = fileChooser.showOpenDialog(null);

		        if (load == JFileChooser.APPROVE_OPTION) {
		            File f = fileChooser.getSelectedFile(); // Get selected file
		            String path = f.getAbsolutePath(); // Get file path
		            
		            // Optional: Display the selected image in a JLabel
		            ImageIcon icon = new ImageIcon(new ImageIcon(path).getImage()
		                    .getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH));
		            lblIMAGE.setIcon(icon); // Assuming lblIMAGE is a JLabel where the image will be displayed
		            
		            // Optional: Save the path or file for future use (like inserting into the database)
		            System.out.println("File Selected: " + path); // Debugging
		        } else {
		            JOptionPane.showMessageDialog(null, "No file selected!");
		        }
		    }
		});

		btnUpload.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnUpload.setBounds(676, 245, 89, 23);
		panel_1.add(btnUpload);
		
		
		
		   JButton btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // Get the input data
		        String productName = textFieldProdName.getText();
		        String price = textFieldPrice.getText();
		        String quantity = textField_4.getText();
		        String imagePath = lblIMAGE.getIcon() != null ? ((ImageIcon) lblIMAGE.getIcon()).toString() : null;

		        // Input validation
		        if (productName.isEmpty() || price.isEmpty() || quantity.isEmpty() || imagePath == null) {
		            JOptionPane.showMessageDialog(null, "Please fill all fields and upload an image!");
		            return;
		        }

		        // Database connection variables
		        String url = "jdbc:mysql://localhost:3306/dcfdentalclinicdb"; // Change to your database name
		        String username = "root"; // Change to your MySQL username
		        String password = ""; // Change to your MySQL password

		        // SQL insert query
		        String query = "INSERT INTO products (ProductName, Price, Quantity, Image) VALUES (?, ?, ?, ?)";

		        try (
		            java.sql.Connection connection = java.sql.DriverManager.getConnection(url, username, password);
		            java.sql.PreparedStatement preparedStatement = connection.prepareStatement(query)
		        ) {
		            // Set query parameters
		            preparedStatement.setString(1, productName);
		            preparedStatement.setDouble(2, Double.parseDouble(price));
		            preparedStatement.setInt(3, Integer.parseInt(quantity));
		            preparedStatement.setString(4, imagePath);

		            // Execute the query
		            int rowsInserted = preparedStatement.executeUpdate();

		            if (rowsInserted > 0) {
		                JOptionPane.showMessageDialog(null, "Product added successfully!");
		                // Optionally, clear the input fields
		                textFieldProdName.setText("");
		                textFieldPrice.setText("");
		                textField_4.setText("");
		                lblIMAGE.setIcon(null);
		            } else {
		                JOptionPane.showMessageDialog(null, "Error adding the product. Try again.");
		            }
		        } catch (Exception ex) {
		            ex.printStackTrace();
		            JOptionPane.showMessageDialog(null, "Database connection error: " + ex.getMessage());
		        }
		    }
		});

		btnAdd.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnAdd.setBounds(80, 392, 117, 58);
		panel_1.add(btnAdd);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // Get the input data
		        String productId = textFieldProdID.getText().trim();
		        String productName = textFieldProdName.getText().trim();
		        String price = textFieldPrice.getText().trim();
		        String quantity = textField_4.getText().trim();
		        String image = lblIMAGE.getIcon() != null ? ((ImageIcon) lblIMAGE.getIcon()).toString() : null;

		        // Check if ProductID is filled
		        if (productId.isEmpty()) {
		            JOptionPane.showMessageDialog(null, "Please fill in the Product ID to update.");
		            return;
		        }

		        // Prepare the SQL query
		        StringBuilder queryBuilder = new StringBuilder("UPDATE products SET ");
		        boolean hasUpdates = false;

		        if (!productName.isEmpty()) {
		            queryBuilder.append("ProductName = ?, ");
		            hasUpdates = true;
		        }
		        if (!price.isEmpty()) {
		            queryBuilder.append("Price = ?, ");
		            hasUpdates = true;
		        }
		        if (!quantity.isEmpty()) {
		            queryBuilder.append("Quantity = ?, ");
		            hasUpdates = true;
		        }
		        if (image != null) {
		            queryBuilder.append("Image = ?, ");
		            hasUpdates = true;
		        }

		        if (!hasUpdates) {
		            JOptionPane.showMessageDialog(null, "No updates provided. Please fill at least one field to update.");
		            return;
		        }

		        // Remove trailing comma and space, and add WHERE clause
		        queryBuilder.setLength(queryBuilder.length() - 2); // Remove last ", "
		        queryBuilder.append(" WHERE ProductID = ?");

		        String query = queryBuilder.toString();

		        // Database connection variables
		        String url = "jdbc:mysql://localhost:3306/dcfdentalclinicdb"; // Change to your database name
		        String username = "root"; // Change to your MySQL username
		        String password = ""; // Change to your MySQL password

		        try (
		            java.sql.Connection connection = java.sql.DriverManager.getConnection(url, username, password);
		            java.sql.PreparedStatement preparedStatement = connection.prepareStatement(query)
		        ) {
		            // Set parameters dynamically
		            int parameterIndex = 1;

		            if (!productName.isEmpty()) {
		                preparedStatement.setString(parameterIndex++, productName);
		            }
		            if (!price.isEmpty()) {
		                preparedStatement.setDouble(parameterIndex++, Double.parseDouble(price));
		            }
		            if (!quantity.isEmpty()) {
		                preparedStatement.setInt(parameterIndex++, Integer.parseInt(quantity));
		            }
		            if (image != null) {
		                preparedStatement.setString(parameterIndex++, image );
		            }
		            preparedStatement.setString(parameterIndex, productId); // Set ProductID as the last parameter

		            // Execute the query
		            int rowsUpdated = preparedStatement.executeUpdate();

		            if (rowsUpdated > 0) {
		                JOptionPane.showMessageDialog(null, "Product updated successfully!");
		                // Optionally, clear the input fields
		                textFieldProdID.setText("");
		                textFieldProdName.setText("");
		                textFieldPrice.setText("");
		                textField_4.setText("");
		                lblIMAGE.setIcon(null);
		            } else {
		                JOptionPane.showMessageDialog(null, "Error updating the product. Product ID not found.");
		            }
		        } catch (Exception ex) {
		            ex.printStackTrace();
		            JOptionPane.showMessageDialog(null, "Database connection error: " + ex.getMessage());
		        }
		    }
		});

		btnUpdate.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnUpdate.setBounds(218, 393, 113, 57);
		panel_1.add(btnUpdate);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // Get the Product ID
		        String productId = textFieldProdID.getText().trim();

		        // Validate Product ID
		        if (productId.isEmpty()) {
		            JOptionPane.showMessageDialog(null, "Please enter the Product ID to delete.");
		            return;
		        }

		        // Database connection variables
		        String url = "jdbc:mysql://localhost:3306/dcfdentalclinicdb"; // Change to your database name
		        String username = "root"; // Change to your MySQL username
		        String password = ""; // Change to your MySQL password

		        // SQL delete query
		        String query = "DELETE FROM products WHERE ProductID = ?";

		        try (
		            java.sql.Connection connection = java.sql.DriverManager.getConnection(url, username, password);
		            java.sql.PreparedStatement preparedStatement = connection.prepareStatement(query)
		        ) {
		            // Set the ProductID parameter
		            preparedStatement.setString(1, productId);

		            // Execute the query
		            int rowsDeleted = preparedStatement.executeUpdate();

		            if (rowsDeleted > 0) {
		                JOptionPane.showMessageDialog(null, "Product deleted successfully!");
		                // Optionally, clear the input fields
		                textFieldProdID.setText("");
		            } else {
		                JOptionPane.showMessageDialog(null, "Product not found. Please check the Product ID.");
		            }
		        } catch (Exception ex) {
		            ex.printStackTrace();
		            JOptionPane.showMessageDialog(null, "Database connection error: " + ex.getMessage());
		        }
		    }
		});

		btnDelete.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnDelete.setBounds(349, 393, 117, 58);
		panel_1.add(btnDelete);
		
		textFieldProdName = new JTextField();
		textFieldProdName.setColumns(10);
		textFieldProdName.setBounds(282, 149, 151, 31);
		panel_1.add(textFieldProdName);
		
		textFieldPrice = new JTextField();
		textFieldPrice.setColumns(10);
		textFieldPrice.setBounds(282, 191, 151, 29);
		panel_1.add(textFieldPrice);
		
		textFieldProdID = new JTextField();
		textFieldProdID.setColumns(10);
		textFieldProdID.setBounds(282, 107, 151, 29);
		panel_1.add(textFieldProdID);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(282, 234, 151, 29);
		panel_1.add(textField_4);
		
		JButton btnBACK = new JButton("BACK");
		btnBACK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Dashboard();
			}
		});
		btnBACK.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnBACK.setBounds(849, 392, 117, 58);
		panel_1.add(btnBACK);
	}
}
