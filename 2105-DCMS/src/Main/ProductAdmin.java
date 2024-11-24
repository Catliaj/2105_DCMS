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
import javax.swing.border.BevelBorder;

public class ProductAdmin extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
  
  
    private JButton Dashboardbtn;
    private JButton Patientsbtn;
    private JButton Appointmentsbtn;
    private JButton Billingbtn;
    private JButton Logoutbtn;
    private JButton ProductSalesbtn;
	
	private JTextField textFieldProdName;
	private JTextField textFieldPrice;
	private JTextField textFieldProdID;
	private JTextField textField_4;
	private JLabel lblIMAGE;
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
		setVisible(true);
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
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(239, 193, 441, 496);
		panel_1.setBackground(new Color(5, 59, 67));
		
		
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Product Name");
		lblNewLabel_1.setForeground(new Color(194, 192, 192));
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 22));
		lblNewLabel_1.setBounds(40, 268, 169, 31);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Product ID");
		lblNewLabel_1_1.setForeground(new Color(194, 192, 192));
		lblNewLabel_1_1.setFont(new Font("Segoe UI", Font.BOLD, 22));
		lblNewLabel_1_1.setBounds(40, 227, 129, 31);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Price");
		lblNewLabel_1_2.setForeground(new Color(194, 192, 192));
		lblNewLabel_1_2.setFont(new Font("Segoe UI", Font.BOLD, 22));
		lblNewLabel_1_2.setBounds(40, 309, 72, 31);
		panel_1.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Quantity");
		lblNewLabel_1_3.setForeground(new Color(194, 192, 192));
		lblNewLabel_1_3.setToolTipText("");
		lblNewLabel_1_3.setFont(new Font("Segoe UI", Font.BOLD, 22));
		lblNewLabel_1_3.setBounds(40, 351, 129, 31);
		panel_1.add(lblNewLabel_1_3);
		
		JPanel panelImage = new JPanel();
		panelImage.setBounds(147, 21, 151, 119);
		panel_1.add(panelImage);
		panelImage.setLayout(null);
		
		lblIMAGE = new JLabel("");
		lblIMAGE.setBounds(0, 0, 151, 119);
		panelImage.add(lblIMAGE);
		
		
		JButton btnUpload = new JButton("UPLOAD");
		btnUpload.setBackground(new Color(194, 192, 192));
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
		btnUpload.setBounds(163, 150, 117, 31);
		panel_1.add(btnUpload);
		
		textFieldProdName = new JTextField();
		textFieldProdName.setColumns(10);
		textFieldProdName.setBounds(220, 268, 151, 31);
		panel_1.add(textFieldProdName);
		
		textFieldPrice = new JTextField();
		textFieldPrice.setColumns(10);
		textFieldPrice.setBounds(220, 310, 151, 29);
		panel_1.add(textFieldPrice);
		
		textFieldProdID = new JTextField();
		textFieldProdID.setColumns(10);
		textFieldProdID.setBounds(220, 226, 151, 29);
		panel_1.add(textFieldProdID);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(220, 353, 151, 29);
		panel_1.add(textField_4);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_6.setBackground(new Color(3, 45, 50));
		panel_6.setBounds(10, 417, 134, 51);
		panel_1.add(panel_6);
		panel_6.setLayout(null);
		
		
		
	
		JButton btnAdd = new JButton("ADD");
		btnAdd.setBounds(8, 10, 117, 31);
		panel_6.add(btnAdd);
		btnAdd.setBackground(new Color(203, 201, 201));
		btnAdd.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // Get input data
		        String productName = textFieldProdName.getText();
		        String price = textFieldPrice.getText();
		        String quantity = textField_4.getText();

		        // Validate input fields
		        if (productName.isEmpty() || price.isEmpty() || quantity.isEmpty() || lblIMAGE.getIcon() == null) {
		            JOptionPane.showMessageDialog(null, "Please fill all fields and upload an image!");
		            return;
		        }

		        // Convert ImageIcon to byte array
		        byte[] imageBytes = null;
		        try {
		            Image image = ((ImageIcon) lblIMAGE.getIcon()).getImage();
		            BufferedImage bufferedImage = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_RGB);
		            Graphics2D g2d = bufferedImage.createGraphics();
		            g2d.drawImage(image, 0, 0, null);
		            g2d.dispose();

		            ByteArrayOutputStream baos = new ByteArrayOutputStream();
		            ImageIO.write(bufferedImage, "jpg", baos);
		            imageBytes = baos.toByteArray();
		        } catch (IOException ex) {
		            ex.printStackTrace();
		            JOptionPane.showMessageDialog(null, "Error converting image: " + ex.getMessage());
		            return;
		        }

		        // Insert into the database
		        String query = "INSERT INTO products (ProductName, Price, Quantity, Image) VALUES (?, ?, ?, ?)";
		        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dcfdentalclinicdb", "root", "");
		             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

		            preparedStatement.setString(1, productName);
		            preparedStatement.setDouble(2, Double.parseDouble(price));
		            preparedStatement.setInt(3, Integer.parseInt(quantity));
		            preparedStatement.setBytes(4, imageBytes);

		            int rowsInserted = preparedStatement.executeUpdate();
		            if (rowsInserted > 0) {
		                JOptionPane.showMessageDialog(null, "Product added successfully!");
		                textFieldProdName.setText("");
		                textFieldPrice.setText("");
		                textField_4.setText("");
		                lblIMAGE.setIcon(null);
		            } else {
		                JOptionPane.showMessageDialog(null, "Error adding the product.");
		            }
		        } catch (Exception ex) {
		            ex.printStackTrace();
		            JOptionPane.showMessageDialog(null, "Database error: " + ex.getMessage());
		        }
		    }
		});
		
		
		
		
		
				btnAdd.setFont(new Font("Segoe UI", Font.BOLD, 13));
				
				JPanel panel_6_1 = new JPanel();
				panel_6_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
				panel_6_1.setBackground(new Color(3, 45, 50));
				panel_6_1.setLayout(null);
				panel_6_1.setBounds(154, 417, 134, 51);
				panel_1.add(panel_6_1);
				
				JButton btnUpdate = new JButton("UPDATE");
				btnUpdate.setBounds(8, 10, 117, 31);
				panel_6_1.add(btnUpdate);
				btnUpdate.setBackground(new Color(203, 201, 201));
				btnUpdate.addActionListener(new ActionListener() {
				    public void actionPerformed(ActionEvent e) {
				        String productId = textFieldProdID.getText().trim();
				        String productName = textFieldProdName.getText().trim();
				        String price = textFieldPrice.getText().trim();
				        String quantity = textField_4.getText().trim();

				        if (productId.isEmpty()) {
				            JOptionPane.showMessageDialog(null, "Please provide the Product ID to update.");
				            return;
				        }

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
				        if (lblIMAGE.getIcon() != null) {
				            queryBuilder.append("Image = ?, ");
				            hasUpdates = true;
				        }

				        if (!hasUpdates) {
				            JOptionPane.showMessageDialog(null, "No updates provided. Please fill at least one field.");
				            return;
				        }

				        queryBuilder.setLength(queryBuilder.length() - 2); // Remove trailing comma
				        queryBuilder.append(" WHERE ProductID = ?");

				        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dcfdentalclinicdb", "root", "");
				             PreparedStatement preparedStatement = connection.prepareStatement(queryBuilder.toString())) {

				            int index = 1;
				            if (!productName.isEmpty()) preparedStatement.setString(index++, productName);
				            if (!price.isEmpty()) preparedStatement.setDouble(index++, Double.parseDouble(price));
				            if (!quantity.isEmpty()) preparedStatement.setInt(index++, Integer.parseInt(quantity));
				            if (lblIMAGE.getIcon() != null) {
				                Image image = ((ImageIcon) lblIMAGE.getIcon()).getImage();
				                BufferedImage bufferedImage = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_RGB);
				                Graphics2D g2d = bufferedImage.createGraphics();
				                g2d.drawImage(image, 0, 0, null);
				                g2d.dispose();

				                ByteArrayOutputStream baos = new ByteArrayOutputStream();
				                ImageIO.write(bufferedImage, "jpg", baos);
				                preparedStatement.setBytes(index++, baos.toByteArray());
				            }

				            preparedStatement.setString(index, productId);

				            int rowsUpdated = preparedStatement.executeUpdate();
				            if (rowsUpdated > 0) {
				                JOptionPane.showMessageDialog(null, "Product updated successfully!");
				            } else {
				                JOptionPane.showMessageDialog(null, "Product not found.");
				            }
				        } catch (Exception ex) {
				            ex.printStackTrace();
				            JOptionPane.showMessageDialog(null, "Database error: " + ex.getMessage());
				        }
				    }
				});
				
				
						btnUpdate.setFont(new Font("Segoe UI", Font.BOLD, 13));
						
						JPanel panel_6_1_1 = new JPanel();
						panel_6_1_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
						panel_6_1_1.setBackground(new Color(3, 45, 50));
						panel_6_1_1.setLayout(null);
						panel_6_1_1.setBounds(297, 417, 134, 51);
						panel_1.add(panel_6_1_1);
						
						JButton btnDelete = new JButton("DELETE");
						btnDelete.setBounds(8, 10, 117, 31);
						panel_6_1_1.add(btnDelete);
						btnDelete.setBackground(new Color(203, 201, 201));
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
	        
	        JPanel paneltbl = new JPanel();
	        paneltbl.setBounds(690, 193, 584, 416);
	        panel.add(paneltbl);
	        paneltbl.setLayout(null);
	        
	        	
	        		 JTable table = new JTable();
	        		 table.setBounds(10, 10, 356, 408);
	        		 JScrollPane scrollPane = new JScrollPane(table);
	        		 scrollPane.setBounds(10, 10, 564, 396);
	        		 paneltbl.add(scrollPane);
	        		 
	        		 	        loadTableData(table);
	        		 	        
	        		 	        JPanel panel_2 = new JPanel();
	        		 	        panel_2.setBackground(new Color(5, 59, 67));
	        		 	        panel_2.setBounds(0, 0, 1284, 107);
	        		 	        panel.add(panel_2);
	        		 	        panel_2.setLayout(null);
	        		 	        
	        		 	        JLabel lblNewLabel_5 = new JLabel("");
	        		 	        lblNewLabel_5.setIcon(new ImageIcon(ProductAdmin.class.getResource("/Resources/ClinicLogo.png")));
	        		 	        lblNewLabel_5.setBounds(395, 22, 475, 64);
	        		 	        panel_2.add(lblNewLabel_5);
	        		 	        
	        		 	        JLabel lblNewLabel_3 = new JLabel("");
	        		 	        lblNewLabel_3.setIcon(new ImageIcon(ProductAdmin.class.getResource("/Resources/HeaderPanelBG.png")));
	        		 	        lblNewLabel_3.setBounds(0, 0, 1284, 107);
	        		 	        panel_2.add(lblNewLabel_3);
	        		 	        
	        		 	        JPanel panel_3 = new JPanel();
	        		 	        panel_3.setBackground(new Color(203, 201, 201));
	        		 	        panel_3.setBounds(0, 106, 1284, 15);
	        		 	        panel.add(panel_3);
	        		 	        
	        		 	        JPanel panel_4 = new JPanel();
	        		 	        panel_4.setBackground(new Color(5, 59, 67));
	        		 	        panel_4.setBounds(0, 117, 229, 605);
	        		 	        panel.add(panel_4);
	        		 	        panel_4.setLayout(null);
	        		 	        
	        		 	        JButton btnNewButton = new JButton("DASHBOARD");
	        		 	        btnNewButton.addActionListener(new ActionListener() {
	        		 	        	public void actionPerformed(ActionEvent e) {
	        		 	        		dispose();
	        		 	        		new Dashboard();
	        		 	        	}
	        		 	        });
	        		 	        btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 25));
	        		 	        btnNewButton.setBackground(new Color(194, 192, 192));
	        		 	        btnNewButton.setBounds(0, 85, 228, 57);
	        		 	        panel_4.add(btnNewButton);
	        		 	        
	        		 	        JButton btnPatients = new JButton("PATIENTS");
	        		 	        btnPatients.addActionListener(new ActionListener() {
	        		 	        	public void actionPerformed(ActionEvent e) {
	        		 	        		dispose();
	        		 	        		new Patients();
	        		 	        	}
	        		 	        });
	        		 	        btnPatients.setBackground(new Color(194, 192, 192));
	        		 	        btnPatients.setFont(new Font("Segoe UI", Font.BOLD, 25));
	        		 	        btnPatients.setBounds(0, 145, 228, 57);
	        		 	        panel_4.add(btnPatients);
	        		 	        
	        		 	        JButton btnLogOut = new JButton("LOG OUT");
	        		 	        btnLogOut.setFont(new Font("Segoe UI", Font.BOLD, 25));
	        		 	        btnLogOut.setBackground(new Color(194, 192, 192));
	        		 	        btnLogOut.setBounds(1, 538, 228, 57);
	        		 	        panel_4.add(btnLogOut);
	        		 	        
	        		 	        JButton btnAppointments = new JButton("APPOINTMENTS");
	        		 	        btnAppointments.addActionListener(new ActionListener() {
	        		 	        	public void actionPerformed(ActionEvent e) {
	        		 	        		dispose();
	        		 	        		new Appointments();
	        		 	        	}
	        		 	        });
	        		 	        btnAppointments.setFont(new Font("Segoe UI", Font.BOLD, 25));
	        		 	        btnAppointments.setBackground(new Color(194, 192, 192));
	        		 	        btnAppointments.setBounds(0, 205, 228, 57);
	        		 	        panel_4.add(btnAppointments);
	        		 	        
	        		 	        JButton btnProduct = new JButton("PRODUCT");
	        		 	        btnProduct.setFont(new Font("Segoe UI", Font.BOLD, 25));
	        		 	        btnProduct.setBackground(new Color(194, 192, 192));
	        		 	        btnProduct.setBounds(1, 265, 228, 57);
	        		 	        panel_4.add(btnProduct);
	        		 	        
	        		 	        JButton btnAppointments_1_1 = new JButton("SALES");
	        		 	        btnAppointments_1_1.addActionListener(new ActionListener() {
	        		 	        	public void actionPerformed(ActionEvent e) {
	        		 	        		dispose();
	        		 	        		new SALES();
	        		 	        	}
	        		 	        });
	        		 	        btnAppointments_1_1.setFont(new Font("Segoe UI", Font.BOLD, 25));
	        		 	        btnAppointments_1_1.setBackground(new Color(194, 192, 192));
	        		 	        btnAppointments_1_1.setBounds(0, 325, 228, 57);
	        		 	        panel_4.add(btnAppointments_1_1);
	        		 	        
	        		 	        JButton btnAppointments_1_1_1 = new JButton("POS");
	        		 	        btnAppointments_1_1_1.addActionListener(new ActionListener() {
	        		 	        	public void actionPerformed(ActionEvent e) {
	        		 	        		dispose();
	        		 	        		new POS();
	        		 	        	}
	        		 	        });
	        		 	        btnAppointments_1_1_1.setFont(new Font("Segoe UI", Font.BOLD, 25));
	        		 	        btnAppointments_1_1_1.setBackground(new Color(194, 192, 192));
	        		 	        btnAppointments_1_1_1.setBounds(0, 385, 228, 57);
	        		 	        panel_4.add(btnAppointments_1_1_1);
	        		 	        
	        		 	        JLabel lblNewLabel_4 = new JLabel("");
	        		 	        lblNewLabel_4.setIcon(new ImageIcon(ProductAdmin.class.getResource("/Resources/SidePanelBG.png")));
	        		 	        lblNewLabel_4.setBounds(0, 0, 229, 613);
	        		 	        panel_4.add(lblNewLabel_4);
	        		 	        
	        		 	        JPanel panel_5_1 = new JPanel();
	        		 	        panel_5_1.setBounds(923, 634, 145, 55);
	        		 	        panel.add(panel_5_1);
	        		 	        panel_5_1.setLayout(null);
	        		 	        panel_5_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
	        		 	        panel_5_1.setBackground(new Color(5, 59, 67));
	        		 	        
	        		 	        JButton btnREFRESH = new JButton("REFRESH");
	        		 	        btnREFRESH.setBackground(new Color(203, 201, 201));
	        		 	        btnREFRESH.setBounds(10, 10, 125, 35);
	        		 	        panel_5_1.add(btnREFRESH);
	        		 	        btnREFRESH.addActionListener(new ActionListener() {
	        		 	        	public void actionPerformed(ActionEvent e) {
	        		 	        		 loadTableData(table);
	        		 	        	        JOptionPane.showMessageDialog(null, "Table refreshed successfully!");
	        		 	        	}
	        		 	        });
	        		 	        
	        		 	        
	        		 	        btnREFRESH.setFont(new Font("Segoe UI", Font.BOLD, 20));
	        		 	        
	        		 	        JPanel panel_7 = new JPanel();
	        		 	        panel_7.setBackground(new Color(5, 59, 67));
	        		 	        panel_7.setBounds(552, 121, 485, 48);
	        		 	        panel.add(panel_7);
	        		 	        panel_7.setLayout(null);
	        		 	        
	        		 	        JLabel lblNewLabel = new JLabel("PRODUCT INFORMATION");
	        		 	        lblNewLabel.setBounds(91, 6, 467, 37);
	        		 	        panel_7.add(lblNewLabel);
	        		 	        lblNewLabel.setForeground(new Color(203, 201, 201));
	        		 	        lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 25));
	        		 	        
	        		 	        JLabel lblNewLabel_2 = new JLabel("");
	        		 	        lblNewLabel_2.setBackground(new Color(5, 59, 67));
	        		 	        lblNewLabel_2.setIcon(new ImageIcon(ProductAdmin.class.getResource("/Resources/Background (2).png")));
	        		 	        lblNewLabel_2.setBounds(0, 0, 1284, 712);
	        		 	        panel.add(lblNewLabel_2);
	        
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
	                                .getScaledInstance(50, 50, Image.SCALE_SMOOTH));
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

	        DefaultTableModel model = new DefaultTableModel(data, columnNames) {
	            @Override
	            public Class<?> getColumnClass(int column) {
	                if (column == columnCount - 1) return ImageIcon.class; // Set the image column
	                return Object.class;
	            }
	        };
	        table.setModel(model);

	        // Add MouseListener to the table
	        table.addMouseListener(new java.awt.event.MouseAdapter() {
	            public void mouseClicked(java.awt.event.MouseEvent evt) {
	                int selectedRow = table.getSelectedRow();
	                if (selectedRow != -1) {
	                    // Populate text fields with table data
	                    textFieldProdID.setText(table.getValueAt(selectedRow, 0).toString());
	                    textFieldProdName.setText(table.getValueAt(selectedRow, 1).toString());
	                    textFieldPrice.setText(table.getValueAt(selectedRow, 2).toString());
	                    textField_4.setText(table.getValueAt(selectedRow, 3).toString());

	                    // Handle image
	                    Object imageIcon = table.getValueAt(selectedRow, 4);
	                    if (imageIcon instanceof ImageIcon) {
	                        ImageIcon icon = (ImageIcon) imageIcon;
	                        // Scale the image to fit the label's size
	                        Image image = icon.getImage().getScaledInstance(lblIMAGE.getWidth(), lblIMAGE.getHeight(), Image.SCALE_SMOOTH);
	                        lblIMAGE.setIcon(new ImageIcon(image));
	                    } else {
	                        lblIMAGE.setIcon(null);
	                    }
	                }
	            }
	        });
	    } catch (Exception ex) {
	        ex.printStackTrace();
	        JOptionPane.showMessageDialog(null, "Error loading table data: " + ex.getMessage());
	    }
	}

}