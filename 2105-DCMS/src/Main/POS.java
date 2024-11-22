package Main;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;
import java.util.ArrayList;
import java.util.List;
import java.awt.Toolkit;
import DCMS_DB_CONNECTION.DB_DCMSConnection;
import backend.POS_backend;



public class POS extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField Productpricetxtfield;
	private JTextField totaltxtfield;
	private JTextField subtotaltxtfield;
	private JTextField CustomerNametxtfield;
	private JTextField textField;
	private JTextArea addedItemsArea;
	DB_DCMSConnection dcmsConnection = new DB_DCMSConnection();
	POS_backend posbackend = new POS_backend();
	private Connection connection;
	// Declare lists to store selected products and services
	List<String> selectedProducts = new ArrayList<>();
	List<Integer> productQuantities = new ArrayList<>();
	List<Double> productPrices = new ArrayList<>();
	List<String> selectedServices = new ArrayList<>();
	List<Double> servicePrices = new ArrayList<>();
	private JTextField pricetxtfield2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					POS frame = new POS();
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
	public POS() {
		setResizable(false);
		setBackground(new Color(5, 59, 67));
		setTitle("POS");
		setIconImage(Toolkit.getDefaultToolkit().getImage("/Resources/Adminiconlogo.png"));
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(150, 50, 1300, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1286, 713);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel TopPanel = new JPanel();
		TopPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		TopPanel.setBackground(new Color(5, 59, 67));
		TopPanel.setBounds(27, 58, 1226, 76);
		panel.add(TopPanel);
		TopPanel.setLayout(null);
		
		JLabel CustomerNamelbl = new JLabel("CUSTOMER NAME");
		CustomerNamelbl.setForeground(new Color(194, 192, 192));
		CustomerNamelbl.setFont(new Font("Segoe UI", Font.BOLD, 25));
		CustomerNamelbl.setBounds(77, 19, 250, 34);
		TopPanel.add(CustomerNamelbl);
				
		JLabel Datelbl = new JLabel("DATE");
		Datelbl.setForeground(new Color(194, 192, 192));
		Datelbl.setFont(new Font("Segoe UI", Font.BOLD, 25));
		Datelbl.setBounds(815, 19, 84, 34);
		TopPanel.add(Datelbl);
				
		CustomerNametxtfield = new JTextField();
		CustomerNametxtfield.setFont(new Font("Segoe UI", Font.BOLD, 20));
		CustomerNametxtfield.setColumns(10);
		CustomerNametxtfield.setBounds(310, 15, 396, 45);
		TopPanel.add(CustomerNametxtfield);
		
		JDateChooser Datefield = new JDateChooser();
		Datefield.setBounds(896, 15, 242, 45);
		TopPanel.add(Datefield);
		Datefield.setFont(new Font("Segoe UI", Font.BOLD, 15));
		
		JPanel ProductPanel = new JPanel();
		ProductPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		ProductPanel.setBackground(new Color(5, 59, 67));
		ProductPanel.setBounds(27, 159, 400, 446);
		panel.add(ProductPanel);
		ProductPanel.setLayout(null);
		
		JLabel Productslbl = new JLabel("PRODUCTS");
		Productslbl.setForeground(new Color(194, 192, 192));
		Productslbl.setFont(new Font("Segoe UI", Font.BOLD, 30));
		Productslbl.setBounds(115, 25, 178, 70);
		ProductPanel.add(Productslbl);
		
		JComboBox<String> Productcombobox = new JComboBox<>(new String[] {
		"", "Colgate Optic White", "Oral-B Pro Health", "Oral-B Toothbrush", "Colgate Plax Mouthwash", "Oral-B Floss Sticks", "Colgate Optic White Teeth Whitening Pen", "Colgate Kids Toothpaste", "Oral-B Pro 1000 Electric Toothbrush"});
		Productcombobox.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		Productcombobox.setBounds(61, 158, 276, 40);
		ProductPanel.add(Productcombobox);
		
		Productpricetxtfield = new JTextField();
		JSpinner Qtyspinner = new JSpinner();
		Qtyspinner.setFont(new Font("Segoe UI", Font.BOLD, 15));
		Qtyspinner.setBounds(61, 268, 101, 40);
		Qtyspinner.setValue(1);  
		ProductPanel.add(Qtyspinner);
		
		JLabel qtylbl = new JLabel("QUANTITY");
		qtylbl.setForeground(new Color(194, 192, 192));
		qtylbl.setFont(new Font("Segoe UI", Font.BOLD, 15));
		qtylbl.setBounds(61, 208, 149, 70);
		ProductPanel.add(qtylbl);
		
		JPanel AddedItemsPanel = new JPanel();
        AddedItemsPanel.setBounds(847, 158, 406, 190);  // You can adjust the size and position
        AddedItemsPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        AddedItemsPanel.setBackground(new Color(5, 59, 67));
        panel.add(AddedItemsPanel);
        AddedItemsPanel.setLayout(null);
        
        // JLabel for "Added Items"
        JLabel AddedItemsLabel = new JLabel("ITEMS");
        AddedItemsLabel.setBounds(171, 0, 150, 30);
        AddedItemsLabel.setForeground(new Color(194, 192, 192));
        AddedItemsLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
        AddedItemsPanel.add(AddedItemsLabel);
        
        // Initialize the JTextArea to display added items
        addedItemsArea = new JTextArea(); // <-- Initialize the instance variable here
        addedItemsArea.setBounds(1, 56, 228, 73);
        addedItemsArea.setEditable(false);
        addedItemsArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        AddedItemsPanel.add(addedItemsArea);
        
        // Scroll pane to make the JTextArea scrollable
        JScrollPane scrollPane_1 = new JScrollPane(addedItemsArea);
        scrollPane_1.setBounds(10, 40, 380, 130);
        AddedItemsPanel.add(scrollPane_1);
				
		JPanel TotalPanel_1_1 = new JPanel();
		TotalPanel_1_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		TotalPanel_1_1.setBackground(new Color(5, 59, 67));
		TotalPanel_1_1.setBounds(88, 365, 205, 59);
		ProductPanel.add(TotalPanel_1_1);
		TotalPanel_1_1.setLayout(null);
		
		JButton addbtn = new JButton("ADD");
		addbtn.setBounds(36, 12, 127, 35);
		TotalPanel_1_1.add(addbtn);
		addbtn.setBackground(new Color(194, 192, 192));
		addbtn.setFont(new Font("Segoe UI", Font.BOLD, 20));
		addbtn.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String selectedProduct = (String) Productcombobox.getSelectedItem();
		        String productPrice = Productpricetxtfield.getText();
		        int quantity = (Integer) Qtyspinner.getValue();

		        if (!selectedProduct.isEmpty() && !productPrice.isEmpty() && quantity > 0) {
		            // Append the selected product details to the added items area
		            addedItemsArea.append("Product: " + selectedProduct + "\n");
		            addedItemsArea.append("Price: $" + productPrice + "\n");
		            addedItemsArea.append("Quantity: " + quantity + "\n");
		            addedItemsArea.append("Subtotal: $" + (Double.parseDouble(productPrice) * quantity) + "\n");
		            addedItemsArea.append("---------------------------------\n");
		        }
		    }
		});
		
		JLabel pricelbl2 = new JLabel("PRICE");
		pricelbl2.setForeground(new Color(194, 192, 192));
		pricelbl2.setFont(new Font("Segoe UI", Font.BOLD, 15));
		pricelbl2.setBounds(227, 208, 149, 70);
		ProductPanel.add(pricelbl2);
		
		pricetxtfield2 = new JTextField();
		pricetxtfield2.setFont(new Font("Segoe UI", Font.BOLD, 15));
		pricetxtfield2.setColumns(10);
		pricetxtfield2.setBounds(227, 268, 110, 40);
		ProductPanel.add(pricetxtfield2);
		addbtn.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String selectedProduct = (String) Productcombobox.getSelectedItem();
		        String productPrice = Productpricetxtfield.getText();
		        int quantity = (Integer) Qtyspinner.getValue();

		        if (!selectedProduct.isEmpty() && !productPrice.isEmpty() && quantity > 0) {
		            // Use the instance variable
		            addedItemsArea.append("Product: " + selectedProduct + "\n");
		            addedItemsArea.append("Price: $" + productPrice + "\n");
		            addedItemsArea.append("Quantity: " + quantity + "\n");
		            addedItemsArea.append("Subtotal: $" + (Double.parseDouble(productPrice) * quantity) + "\n");
		            addedItemsArea.append("---------------------------------\n");
		        }
		    }
		});
		
		JPanel ServicePanel = new JPanel();
		ServicePanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		ServicePanel.setBackground(new Color(5, 59, 67));
		ServicePanel.setBounds(437, 159, 400, 446);
		panel.add(ServicePanel);
		ServicePanel.setLayout(null);
		
		JLabel Serviceslbl = new JLabel("SERVICES");
		Serviceslbl.setForeground(new Color(194, 192, 192));
		Serviceslbl.setFont(new Font("Segoe UI", Font.BOLD, 30));
		Serviceslbl.setBounds(130, 22, 149, 70);
		ServicePanel.add(Serviceslbl);
		
		JLabel Servicelbl = new JLabel("SERVICE");
		Servicelbl.setForeground(new Color(194, 192, 192));
		Servicelbl.setFont(new Font("Segoe UI", Font.BOLD, 15));
		Servicelbl.setBounds(55, 102, 149, 70);
		ServicePanel.add(Servicelbl);
		
		JComboBox<String> Servicecombobox = new JComboBox<>(new String[] {
		"", "Consultation", "Braces", "Crowns", "Bridges", "Cleaning", "Dentures", "Extraction", "Fillings", "Implants", "Root Canal", "Teeth Whitening", "Veneers", "X-Ray", "Pediatric Dentistry"});
		Servicecombobox.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		Servicecombobox.setBounds(55, 155, 276, 40);
		ServicePanel.add(Servicecombobox);
		
		textField = new JTextField();
		textField.setFont(new Font("Segoe UI", Font.BOLD, 15));
		textField.setColumns(10);
		textField.setBounds(55, 264, 110, 40);
		ServicePanel.add(textField);
		
		JLabel pricelbl_1 = new JLabel("PRICE");
		pricelbl_1.setForeground(new Color(194, 192, 192));
		pricelbl_1.setFont(new Font("Segoe UI", Font.BOLD, 15));
		pricelbl_1.setBounds(55, 205, 149, 70);
		ServicePanel.add(pricelbl_1);
		
		JButton addbtn_1 = new JButton("ADD");
		addbtn_1.setFont(new Font("Segoe UI", Font.BOLD, 20));
		addbtn_1.setBackground(new Color(194, 192, 192));
		addbtn_1.setBounds(141, 378, 127, 35);
		ServicePanel.add(addbtn_1);
		addbtn_1.addActionListener(new ActionListener() 
		{
		    public void actionPerformed(ActionEvent e) 
		    {
		        String selectedService = (String) Servicecombobox.getSelectedItem();
		        String servicePrice = textField.getText();
		        if (!selectedService.isEmpty() && !servicePrice.isEmpty()) {
		            // Use the instance variable
		            addedItemsArea.append("Service: " + selectedService + "\n");
		            addedItemsArea.append("Price: $" + servicePrice + "\n");
		            addedItemsArea.append("---------------------------------\n");
		        }
		    }
		});
		
		JPanel TotalPanel_1 = new JPanel();
		TotalPanel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		TotalPanel_1.setBackground(new Color(5, 59, 67));
		TotalPanel_1.setBounds(100, 366, 205, 59);
		ServicePanel.add(TotalPanel_1);
		TotalPanel_1.setLayout(null);
		
		JButton Resetbtn = new JButton("RESET");
		Resetbtn.setBackground(new Color(194, 192, 192));
		Resetbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Resetbtn.setToolTipText("RESET");
		Resetbtn.setFont(new Font("Segoe UI", Font.BOLD, 20));
		Resetbtn.setBounds(136, 644, 159, 37);
		panel.add(Resetbtn);
		
		JButton Receiptbtn = new JButton("RECEIPT");
		Receiptbtn.setBackground(new Color(194, 192, 192));
		Receiptbtn.setToolTipText("RECEIPT");
		Receiptbtn.setFont(new Font("Segoe UI", Font.BOLD, 20));
		Receiptbtn.setBounds(553, 644, 159, 37);
		panel.add(Receiptbtn);
		
		Receiptbtn.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        
		        String productPrice = Productpricetxtfield.getText();
		        double productpriceToInt = Double.parseDouble(productPrice);
		        String servicePrice = textField.getText();
		        double servicepriceToInt = Double.parseDouble(servicePrice);
		        String subtotal = subtotaltxtfield.getText();
		        String total = totaltxtfield.getText();
		        double totalpriceToInt = Double.parseDouble(total);
		        String date = new java.text.SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date());
		        
		        posbackend.setCustomerName(CustomerNametxtfield.getText());
		        posbackend.setProducts( Productcombobox.getSelectedItem().toString());
		        posbackend.setServices(Servicecombobox.getSelectedItem().toString());
		     		        
		        new POS_backend(posbackend.getCustomerName(),posbackend.getProducts(), posbackend.getServices(),productpriceToInt,servicepriceToInt,totalpriceToInt,date);
		        generateReceipt(posbackend.getCustomerName(), posbackend.getProducts(),productPrice , posbackend.getServices(),servicePrice , subtotal, total, date);
		    }
		});

		JPanel ResetPanel = new JPanel();
		ResetPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		ResetPanel.setBackground(new Color(5, 59, 67));
		ResetPanel.setBounds(113, 633, 205, 59);
		panel.add(ResetPanel);
		
		JPanel ReceiptPanel = new JPanel();
		ReceiptPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		ReceiptPanel.setBackground(new Color(5, 59, 67));
		ReceiptPanel.setBounds(533, 633, 205, 59);
		panel.add(ReceiptPanel);
		
		JPanel ExitPanel = new JPanel();
		ExitPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		ExitPanel.setBackground(new Color(5, 59, 67));
		ExitPanel.setBounds(945, 633, 205, 59);
		panel.add(ExitPanel);
		ExitPanel.setLayout(null);
		
		JButton Exitbtn = new JButton("EXIT");
		Exitbtn.setBounds(24, 10, 159, 37);
		ExitPanel.add(Exitbtn);
		Exitbtn.setBackground(new Color(194, 192, 192));
		Exitbtn.setToolTipText("EXIT");
		Exitbtn.setFont(new Font("Segoe UI", Font.BOLD, 20));
		
		// Exit Button ActionListener
		Exitbtn.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // Close the application when the "Exit" button is clicked
		        dispose();
		    }
		});
		
		JPanel MidPanel = new JPanel();
		MidPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		MidPanel.setBackground(new Color(5, 59, 67));
		MidPanel.setBounds(847, 355, 406, 250);
		panel.add(MidPanel);
		MidPanel.setLayout(null);
		
		JLabel subtotallbl = new JLabel("SUB TOTAL");
		subtotallbl.setBounds(40, 23, 186, 34);
		subtotallbl.setForeground(new Color(194, 192, 192));
		subtotallbl.setFont(new Font("Segoe UI", Font.BOLD, 25));
		MidPanel.add(subtotallbl);
		
		JLabel totallbl = new JLabel("TOTAL");
		totallbl.setForeground(new Color(194, 192, 192));
		totallbl.setForeground(new Color(194, 192, 192));
		totallbl.setFont(new Font("Segoe UI", Font.BOLD, 25));
		totallbl.setBounds(40, 121, 186, 34);
		MidPanel.add(totallbl);
		
		totaltxtfield = new JTextField();
		totaltxtfield.setFont(new Font("Segoe UI", Font.BOLD, 20));
		totaltxtfield.setColumns(10);
		totaltxtfield.setBounds(220, 123, 136, 34);
		MidPanel.add(totaltxtfield);
		
		subtotaltxtfield = new JTextField();
		subtotaltxtfield.setFont(new Font("Segoe UI", Font.BOLD, 20));
		subtotaltxtfield.setColumns(10);
		subtotaltxtfield.setBounds(220, 25, 136, 34);
		MidPanel.add(subtotaltxtfield);
		
				
				
				JPanel TotalPanel = new JPanel();
				TotalPanel.setBounds(101, 175, 205, 59);
				MidPanel.add(TotalPanel);
				TotalPanel.setBackground(new Color(5, 59, 67));
				TotalPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
				TotalPanel.setLayout(null);
				
				
				
				JButton Totalbtn = new JButton("TOTAL");
				Totalbtn.setBounds(38, 10, 126, 35);
				TotalPanel.add(Totalbtn);
				Totalbtn.setToolTipText("TOTAL");
				Totalbtn.setBackground(new Color(194, 192, 192));
				Totalbtn.setForeground(new Color(0, 0, 0));
				Totalbtn.setFont(new Font("Segoe UI", Font.BOLD, 20));
				
				JLabel lblTax = new JLabel("TAX");
				lblTax.setForeground(new Color(194, 192, 192));
				lblTax.setFont(new Font("Segoe UI", Font.BOLD, 25));
				lblTax.setBounds(37, 73, 186, 34);
				MidPanel.add(lblTax);
				
				JLabel lblTax_1 = new JLabel("5%");
				lblTax_1.setForeground(new Color(194, 192, 192));
				lblTax_1.setFont(new Font("Segoe UI", Font.BOLD, 25));
				lblTax_1.setBounds(220, 73, 186, 34);
				MidPanel.add(lblTax_1);
				Totalbtn.addActionListener(new ActionListener() {
				    public void actionPerformed(ActionEvent e) {
				        double subtotal = 0.0;

				        // Check if a product is selected and compute the product's subtotal
				        if (!Productpricetxtfield.getText().isEmpty() && Qtyspinner.getValue() != null) {
				            double productPrice = Double.parseDouble(Productpricetxtfield.getText()); // Get product price
				            int productQty = (Integer) Qtyspinner.getValue(); // Get product quantity
				            subtotal += productPrice * productQty; // Add to subtotal
				        }

				        // Check if a service is selected and compute the service's subtotal
				        if (Servicecombobox.getSelectedItem() != null && !Servicecombobox.getSelectedItem().toString().isEmpty()) {
				            // Assuming the service price is stored in the textField (Service price)
				            double servicePrice = Double.parseDouble(textField.getText()); // Get service price
				            subtotal += servicePrice; // Add to subtotal
				        }

				        // Set Subtotal TextField
				        subtotaltxtfield.setText(String.format("%.2f", subtotal)); // Format subtotal to 2 decimal places

				        // Calculate and Set Total with 5% tax
				        double tax = subtotal * 0.05; // Calculate 5% tax
				        double total = subtotal + tax; // Add tax to subtotal
				        totaltxtfield.setText(String.format("%.2f", total)); // Format total to 2 decimal places
				    }
				});
				
				JLabel lblCustomerDetails = new JLabel("CUSTOMER DETAILS:");
				lblCustomerDetails.setForeground(new Color(194, 192, 192));
				lblCustomerDetails.setFont(new Font("Segoe UI", Font.BOLD, 20));
				lblCustomerDetails.setBounds(27, 22, 323, 34);
				panel.add(lblCustomerDetails);
				
															
							JLabel ContentBackG = new JLabel("");
							ContentBackG.setIcon(new ImageIcon(POS.class.getResource("/Resources/background (2).png")));
							ContentBackG.setBounds(0, 0, 1286, 713);
							panel.add(ContentBackG);
		
							// Define product prices in a map
							Map<String, Double> productPrices = new HashMap<>();
							productPrices.put("Colgate Optic White", 170.0);
							productPrices.put("Oral-B Pro Health", 75.0);
							productPrices.put("Oral-B Toothbrush", 440.0);
							productPrices.put("Colgate Plax Mouthwash", 135.0);
							productPrices.put("Oral-B Floss Sticks", 60.0);
							productPrices.put("Colgate Optic White Teeth Whitening Pen", 1250.0);
							productPrices.put("Colgate Kids Toothpaste", 80.0);
							productPrices.put("Oral-B Pro 1000 Electric Toothbrush", 3137.0);

														
							 // Product ComboBox Listener
					        Productcombobox.addActionListener(new ActionListener() {
					            public void actionPerformed(ActionEvent e) {
					                String selectedProduct = (String) Productcombobox.getSelectedItem();
					                if (selectedProduct != null && productPrices.containsKey(selectedProduct)) {
					                    Productpricetxtfield.setText(String.valueOf(productPrices.get(selectedProduct)));
					                }
					            }
					        });
					        
	        Map<String, Double> servicePrices = new HashMap<>();
	        servicePrices.put("Consultation", 500.0);
	        servicePrices.put("Braces", 1500.0);
	        servicePrices.put("Crowns", 300.0);
	        servicePrices.put("Bridges", 350.0);
	        servicePrices.put("Cleaning", 1000.0);
	        servicePrices.put("Dentures", 3500.0);
	        servicePrices.put("Extraction", 1000.0);
	        servicePrices.put("Fillings", 1500.0);
	        servicePrices.put("Implants", 1000.0);
	        servicePrices.put("Root Canal", 350.0);
	        servicePrices.put("Teeth Whitening", 1500.0);
	        servicePrices.put("Veneers", 15000.0);
	        servicePrices.put("X-Ray", 500.0);
	        servicePrices.put("Pediatric Dentistry (Consultation)", 300.0);

	     

	        // Service ComboBox Listener
	        Servicecombobox.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                String selectedService = (String) Servicecombobox.getSelectedItem();
	                if (selectedService != null && servicePrices.containsKey(selectedService)) {
	                    textField.setText(String.valueOf(servicePrices.get(selectedService)));
	                }
	            }
	        });

	     // Reset Button ActionListener
	        Resetbtn.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                // Clear the lists of selected products and services
	                selectedProducts.clear();
	                productQuantities.clear();
	                productPrices.clear();
	                selectedServices.clear();
	                servicePrices.clear();
	                
	                // Clear the text fields
	                CustomerNametxtfield.setText("");
	                subtotaltxtfield.setText("");
	                totaltxtfield.setText("");
	                
	                // Clear the added items area
	                addedItemsArea.setText("");
	                
	                // Reset the combo boxes to the default value
	                Productcombobox.setSelectedIndex(0);
	                Servicecombobox.setSelectedIndex(0);
	                
	                // Reset the quantity spinner to its default value
	                Qtyspinner.setValue(1);
	                
	                // Clear the product price and service price text fields
	                Productpricetxtfield.setText("");
	                textField.setText("");
	            }
	        });
	    }
	public void generateReceipt(String customerName, String productName, String productPrice, String serviceName, String servicePrice, String subtotal, String total, String date) {
	    StringBuilder receipt = new StringBuilder();
	    receipt.append("=================================\n");
	    receipt.append("            RECEIPT\n");
	    receipt.append("=================================\n");
	    receipt.append(String.format("%-20s : %s\n", "Customer Name", customerName));
	    receipt.append(String.format("%-20s : %s\n", "Date", date));
	    receipt.append("=================================\n");
	    receipt.append(String.format("Product: %-10s $%s\n", productName, productPrice));
	    receipt.append(String.format("Service: %-10s $%s\n", serviceName, servicePrice));
	    receipt.append("=================================\n");
	    receipt.append(String.format("%-20s : $%s\n", "Subtotal", subtotal));
	    receipt.append(String.format("%-20s : $%s\n", "Total", total));
	    receipt.append("=================================\n");
	    receipt.append("            Thank you!\n");
	    receipt.append("=================================\n");

	    JTextArea receiptArea = new JTextArea(receipt.toString());
	    receiptArea.setEditable(false);
	    receiptArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
	    JScrollPane scrollPane = new JScrollPane(receiptArea);

	    JDialog receiptDialog = new JDialog();
	    receiptDialog.setTitle("Receipt");
	    receiptDialog.setSize(400, 500);
	    receiptDialog.setLocationRelativeTo(null);
	    receiptDialog.getContentPane().add(scrollPane);
	    receiptDialog.setVisible(true);
	}
	    }