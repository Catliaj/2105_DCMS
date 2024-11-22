package Main;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.event.ActionEvent;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;

public class ProductAdmin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldProdName;
	private JTextField textFieldPrice;
	private JTextField textFieldProdID;
	private JTextField textField_4;
	private String imagePath = "null";
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
		setLocationRelativeTo(null);
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
		lblNewLabel_1.setBounds(80, 265, 169, 31);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Product ID");
		lblNewLabel_1_1.setFont(new Font("Segoe UI", Font.BOLD, 22));
		lblNewLabel_1_1.setBounds(101, 223, 129, 31);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Price");
		lblNewLabel_1_2.setFont(new Font("Segoe UI", Font.BOLD, 22));
		lblNewLabel_1_2.setBounds(146, 307, 72, 31);
		panel_1.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("QTY");
		lblNewLabel_1_3.setToolTipText("");
		lblNewLabel_1_3.setFont(new Font("Segoe UI", Font.BOLD, 22));
		lblNewLabel_1_3.setBounds(146, 350, 72, 31);
		panel_1.add(lblNewLabel_1_3);
		
		JPanel panelImage = new JPanel();
		panelImage.setBounds(260, 78, 151, 119);
		panel_1.add(panelImage);
		panelImage.setLayout(null);
		
		JLabel lblIMAGE = new JLabel("");
		lblIMAGE.setBounds(0, 0, 151, 119);
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

		            // Convert the image to byte array
		            try {
		                FileInputStream fis = new FileInputStream(f);  // Open the file for reading
		                byte[] imageBytes = new byte[(int) f.length()]; // Create a byte array to hold the image data
		                fis.read(imageBytes); // Read the file data into the byte array
		                fis.close(); // Close the file input stream
		                
		                // Save the byte[] for database insertion (you can use this in your SQL insert statement)
		                System.out.println("Image converted to byte array, ready for insertion.");

		                // Debugging: Check byte array length
		                System.out.println("Image byte array size: " + imageBytes.length);

		                // Now you can use the `imageBytes` in your database insertion query.
		                // Example: preparedStatement.setBytes(4, imageBytes); // Assuming 4 is the parameter for image field
		                
		            } catch (IOException ex) {
		                ex.printStackTrace();
		                JOptionPane.showMessageDialog(null, "Error reading the image file: " + ex.getMessage());
		            }
		            
		        } else {
		            JOptionPane.showMessageDialog(null, "No file selected!");
		        }
		    }
		});





		btnUpload.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnUpload.setBounds(141, 175, 89, 23);
		panel_1.add(btnUpload);
		
		
		
	
		JButton btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // Get the input data
		        String productName = textFieldProdName.getText();
		        String price = textFieldPrice.getText();
		        String quantity = textField_4.getText();
		        ImageIcon imageIcon = (ImageIcon) lblIMAGE.getIcon();  // Get the ImageIcon from the JLabel
		        
		        // Input validation
		        if (productName.isEmpty() || price.isEmpty() || quantity.isEmpty() || imageIcon == null) {
		            JOptionPane.showMessageDialog(null, "Please fill all fields and upload an image!");
		            return;
		        }

		        // Convert the ImageIcon to byte array
		        byte[] imageBytes = null;
		        try {
		            if (imageIcon != null) {
		                // Convert the ImageIcon to byte array
		                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		                Image image = imageIcon.getImage();  // Get the Image from the ImageIcon
		                BufferedImage bufferedImage = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_ARGB);
		                Graphics2D g = bufferedImage.createGraphics();
		                g.drawImage(image, 0, 0, null);
		                g.dispose();

		                // Write the image to the byte array output stream in JPEG format (or any other format like PNG)
		                ImageIO.write(bufferedImage, "jpg", byteArrayOutputStream);
		                imageBytes = byteArrayOutputStream.toByteArray();
		            }
		        } catch (IOException ex) {
		            ex.printStackTrace();
		            JOptionPane.showMessageDialog(null, "Error converting image to byte array: " + ex.getMessage());
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
		            preparedStatement.setBytes(4, imageBytes);  // Insert the image as byte array

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
		textFieldProdName.setBounds(260, 265, 151, 31);
		panel_1.add(textFieldProdName);
		
		textFieldPrice = new JTextField();
		textFieldPrice.setColumns(10);
		textFieldPrice.setBounds(260, 307, 151, 29);
		panel_1.add(textFieldPrice);
		
		textFieldProdID = new JTextField();
		textFieldProdID.setColumns(10);
		textFieldProdID.setBounds(260, 223, 151, 29);
		panel_1.add(textFieldProdID);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(260, 350, 151, 29);
		panel_1.add(textField_4);
		
		JButton btnBACK = new JButton("BACK");
		btnBACK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Dashboard();
			}
		});
		btnBACK.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnBACK.setBounds(349, 462, 117, 58);
		panel_1.add(btnBACK);
		
		JPanel paneltbl = new JPanel();
		paneltbl.setLayout(null); // Explicitly set null layout for manual positioning
		paneltbl.setBounds(547, 68, 462, 428);
		panel_1.add(paneltbl);

	
		 JTable table = new JTable();
	        table.setBounds(10, 10, 356, 408);
	        JScrollPane scrollPane = new JScrollPane(table);
	        scrollPane.setBounds(10, 10, 442, 408);
	        paneltbl.add(scrollPane);

	        loadTableData(table);
	        
	        JButton btnREFRESH = new JButton("REFRESH");
	        btnREFRESH.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		 loadTableData(table);
	        	        JOptionPane.showMessageDialog(null, "Table refreshed successfully!");
	        	}
	        });
	        
	        
	        btnREFRESH.setFont(new Font("Segoe UI", Font.BOLD, 9));
	        btnREFRESH.setBounds(937, 26, 72, 31);
	        panel_1.add(btnREFRESH);
	        
	}
	private void loadTableData(JTable table) {
	    String url = "jdbc:mysql://localhost:3306/dcfdentalclinicdb";
	    String username = "root";
	    String password = "";

	    try (Connection connection = DriverManager.getConnection(url, username, password);
	         Statement statement = connection.createStatement();
	         ResultSet resultSet = statement.executeQuery("SELECT * FROM products")) {

	        ResultSetMetaData metaData = resultSet.getMetaData();
	        int columnCount = metaData.getColumnCount();

	        Vector<String> columnNames = new Vector<>();
	        for (int i = 1; i <= columnCount; i++) {
	            columnNames.add(metaData.getColumnName(i));
	        }

	        Vector<Vector<Object>> data = new Vector<>();
	        while (resultSet.next()) {
	            Vector<Object> row = new Vector<>();
	            for (int i = 1; i <= columnCount; i++) {
	                if (i == columnCount) { // Assuming the last column is the image
	                    byte[] imgData = resultSet.getBytes("Image");
	                    if (imgData != null) {
	                        ImageIcon icon = new ImageIcon(new ImageIcon(imgData).getImage()
	                            .getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH));
	                        row.add(icon);
	                    } else {
	                        row.add(null);
	                    }
	                } else {
	                    row.add(resultSet.getObject(i));
	                }
	            }
	            data.add(row);
	        }

	        DefaultTableModel model = new DefaultTableModel(data, columnNames);
	        table.setModel(model);

	        // Set custom renderer for the image column
	        table.getColumnModel().getColumn(columnCount - 1).setCellRenderer(new DefaultTableCellRenderer() {
	            @Override
	            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
	                    boolean hasFocus, int row, int column) {
	                if (value instanceof ImageIcon) {
	                    return new JLabel((ImageIcon) value);
	                }
	                return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
	            }
	        });
	    } catch (Exception ex) {
	        ex.printStackTrace();
	        JOptionPane.showMessageDialog(null, "Error loading table data: " + ex.getMessage());
	    }
	}

}