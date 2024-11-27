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
import java.util.HashMap;
import java.util.Map;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;
import java.util.ArrayList;
import java.util.List;
import java.awt.Toolkit;
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
	private JComboBox<String> discountComboBox;
	private JTextField Productprice;
	private JSpinner Qtyspinner;

	// Declare lists to store selected products and services
	List<String> selectedProducts = new ArrayList<>();
	List<Integer> productQuantities = new ArrayList<>();
	List<Double> productPrices = new ArrayList<>();
	List<String> selectedServices = new ArrayList<>();
	List<Double> servicePrices = new ArrayList<>();
	private Map<String, Double> productPricesMap = new HashMap<>();
	JComboBox<String> Productcombobox;
	// Declare lists to store prices of products and services
	List<Double> addedProductPrices = new ArrayList<>();
	List<Double> addedServicePrices = new ArrayList<>();
	private JTextField textField_1;
	private JTextField textField_2;

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
		setIconImage(Toolkit.getDefaultToolkit().getImage(POS.class.getResource("/Resources/Adminicon.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1300, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setVisible(true);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1286, 713);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel TopPanel = new JPanel();
		TopPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		TopPanel.setBackground(new Color(5, 59, 67));
		TopPanel.setBounds(27, 34, 810, 76);
		panel.add(TopPanel);
		TopPanel.setLayout(null);
		
		JLabel CustomerNamelbl = new JLabel("CUSTOMER NAME");
		CustomerNamelbl.setForeground(new Color(194, 192, 192));
		CustomerNamelbl.setFont(new Font("Segoe UI", Font.BOLD, 25));
		CustomerNamelbl.setBounds(10, 19, 250, 34);
		TopPanel.add(CustomerNamelbl);
		

		
		JLabel Datelbl = new JLabel("DATE");
		Datelbl.setForeground(new Color(194, 192, 192));
		Datelbl.setFont(new Font("Segoe UI", Font.BOLD, 25));
		Datelbl.setBounds(515, 19, 84, 34);
		TopPanel.add(Datelbl);
		
		
		CustomerNametxtfield = new JTextField();
		CustomerNametxtfield.setFont(new Font("Segoe UI", Font.BOLD, 20));
		CustomerNametxtfield.setColumns(10);
		CustomerNametxtfield.setBounds(243, 15, 231, 45);
		TopPanel.add(CustomerNametxtfield);
		
		JDateChooser Datefield = new JDateChooser();
		Datefield.setBounds(604, 15, 165, 45);
		TopPanel.add(Datefield);
		Datefield.setFont(new Font("Segoe UI", Font.BOLD, 15));
		
		JPanel ProductPanel = new JPanel();
		ProductPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		ProductPanel.setBackground(new Color(5, 59, 67));
		ProductPanel.setBounds(27, 120, 400, 475);
		panel.add(ProductPanel);
		ProductPanel.setLayout(null);
		
		JLabel Productslbl = new JLabel("PRODUCTS");
		Productslbl.setForeground(new Color(194, 192, 192));
		Productslbl.setFont(new Font("Segoe UI", Font.BOLD, 30));
		Productslbl.setBounds(115, 38, 178, 70);
		ProductPanel.add(Productslbl);

		
		Productcombobox = new JComboBox<>();
		Productcombobox.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		Productcombobox.setBounds(61, 154, 276, 40);
		 Productcombobox.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent e) {
		            String selectedProduct = (String) Productcombobox.getSelectedItem();
		            if (selectedProduct != null && productPricesMap.containsKey(selectedProduct)) {
		                Productprice.setText(String.valueOf(productPricesMap.get(selectedProduct)));
		            }
		        }
		    });

		  
		ProductPanel.add(Productcombobox);
		
		
	    Qtyspinner = new JSpinner();
		Qtyspinner.setFont(new Font("Segoe UI", Font.BOLD, 15));
		Qtyspinner.setBounds(61, 285, 101, 40);
		Qtyspinner.setValue(1);  
		ProductPanel.add(Qtyspinner);
		
		JLabel qtylbl = new JLabel("QUANTITY");
		qtylbl.setForeground(new Color(194, 192, 192));
		qtylbl.setFont(new Font("Segoe UI", Font.BOLD, 15));
		qtylbl.setBounds(61, 225, 149, 70);
		ProductPanel.add(qtylbl);
		
		JPanel AddedItemsPanel = new JPanel();
        AddedItemsPanel.setBounds(847, 34, 406, 187);  // You can adjust the size and position
        AddedItemsPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        AddedItemsPanel.setBackground(new Color(5, 59, 67));
        panel.add(AddedItemsPanel);
        AddedItemsPanel.setLayout(null);
        
        // JLabel for "Added Items"
        JLabel AddedItemsLabel = new JLabel("ITEMS");
        AddedItemsLabel.setBounds(171, 5, 150, 30);
        AddedItemsLabel.setForeground(new Color(194, 192, 192));
        AddedItemsLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
        AddedItemsPanel.add(AddedItemsLabel);
        
        // Initialize the JTextArea to display added items
        addedItemsArea = new JTextArea(); // <-- Initialize the instance variable here
        addedItemsArea.setBounds(1, 56, 228, 73);
        addedItemsArea.setEditable(false);
        addedItemsArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        AddedItemsPanel.add(addedItemsArea);
     // Increase the size of the JTextArea and JScrollPane
        addedItemsArea.setBounds(1, 56, 380, 130);  // Increased size for JTextArea

        // Adjust the scroll pane to match the new size
        JScrollPane scrollPane_1 = new JScrollPane(addedItemsArea);
        scrollPane_1.setBounds(10, 40, 380, 130);  // Update scroll pane size
        AddedItemsPanel.add(scrollPane_1);
        	
		JPanel TotalPanel_1_1 = new JPanel();
		TotalPanel_1_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		TotalPanel_1_1.setBackground(new Color(5, 59, 67));
		TotalPanel_1_1.setBounds(88, 374, 205, 59);
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
		        String productPrice = Productprice.getText();
		        int quantity = (Integer) Qtyspinner.getValue();

		        if (!selectedProduct.isEmpty() && !productPrice.isEmpty() && quantity > 0) {
		            try {
		                double price = Double.parseDouble(productPrice);
		                double subtotal = price * quantity;

		                // Append product details to the addedItemsArea
		                addedItemsArea.append(" Product: " + selectedProduct + "\n");
		                addedItemsArea.append(" Price: ₱" + price + "\n");
		                addedItemsArea.append(" Quantity: " + quantity + "\n");
		                addedItemsArea.append(" Subtotal: ₱" + subtotal + "\n");
		                addedItemsArea.append(" ---------------------------------\n");

		                // Update the lists
		                selectedProducts.add(selectedProduct); // Add product name
		                for (int i = 0; i < quantity; i++) {
		                    addedProductPrices.add(price); // Add price multiple times for quantity
		                }

		                
		            } catch (NumberFormatException ex) {
		                JOptionPane.showMessageDialog(null, "Invalid price format!");
		            }
		        } else {
		            JOptionPane.showMessageDialog(null, "Please select a valid product and quantity!");
		        }
		    }
		});




		
		
		JLabel pricelbl_1_1 = new JLabel("PRICE");
		pricelbl_1_1.setForeground(new Color(194, 192, 192));
		pricelbl_1_1.setFont(new Font("Segoe UI", Font.BOLD, 15));
		pricelbl_1_1.setBounds(226, 225, 149, 70);
		ProductPanel.add(pricelbl_1_1);
		
		Productprice = new JTextField();
		Productprice.setFont(new Font("Segoe UI", Font.BOLD, 15));
		Productprice.setColumns(10);
		Productprice.setBounds(226, 284, 110, 40);
		ProductPanel.add(Productprice);
		
		JLabel Servicelbl_1 = new JLabel("PRODUCT");
		Servicelbl_1.setForeground(new Color(194, 192, 192));
		Servicelbl_1.setFont(new Font("Segoe UI", Font.BOLD, 15));
		Servicelbl_1.setBounds(61, 103, 149, 70);
		ProductPanel.add(Servicelbl_1);
	
		
		JPanel ServicePanel = new JPanel();
		ServicePanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		ServicePanel.setBackground(new Color(5, 59, 67));
		ServicePanel.setBounds(437, 120, 400, 475);
		panel.add(ServicePanel);
		ServicePanel.setLayout(null);
		
		JLabel Serviceslbl = new JLabel("SERVICES");
		Serviceslbl.setBounds(131, 37, 149, 70);
		Serviceslbl.setForeground(new Color(194, 192, 192));
		Serviceslbl.setFont(new Font("Segoe UI", Font.BOLD, 30));
		ServicePanel.add(Serviceslbl);
		
		JLabel Servicelbl = new JLabel("SERVICE");
		Servicelbl.setBounds(55, 102, 149, 70);
		Servicelbl.setForeground(new Color(194, 192, 192));
		Servicelbl.setFont(new Font("Segoe UI", Font.BOLD, 15));
		ServicePanel.add(Servicelbl);
		
		JComboBox<String> Servicecombobox = new JComboBox<>(new String[] {
		"", "Consultation", "Braces", "Crowns", "Bridges", "Cleaning", "Dentures", "Extraction", "Fillings", "Implants", "Root Canal", "Teeth Whitening", "Veneers", "X-Ray", "Pediatric Dentistry"});
		Servicecombobox.setBounds(55, 153, 276, 40);
		Servicecombobox.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		ServicePanel.add(Servicecombobox);
		
		textField = new JTextField();
		textField.setBounds(55, 282, 110, 40);
		textField.setFont(new Font("Segoe UI", Font.BOLD, 15));
		textField.setColumns(10);
		ServicePanel.add(textField);
		
		JLabel pricelbl_1 = new JLabel("PRICE");
		pricelbl_1.setBounds(55, 223, 149, 70);
		pricelbl_1.setForeground(new Color(194, 192, 192));
		pricelbl_1.setFont(new Font("Segoe UI", Font.BOLD, 15));
		ServicePanel.add(pricelbl_1);



		
		JPanel TotalPanel_1 = new JPanel();
		TotalPanel_1.setBounds(98, 375, 205, 59);
		TotalPanel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		TotalPanel_1.setBackground(new Color(5, 59, 67));
		ServicePanel.add(TotalPanel_1);
		TotalPanel_1.setLayout(null);
		
		JButton addbtn_1 = new JButton("ADD");
		addbtn_1.setBounds(38, 14, 127, 35);
		TotalPanel_1.add(addbtn_1);
		addbtn_1.setFont(new Font("Segoe UI", Font.BOLD, 20));
		addbtn_1.setBackground(new Color(194, 192, 192));
		addbtn_1.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String selectedService = (String) Servicecombobox.getSelectedItem();
		        String servicePrice = textField.getText();

		        if (!selectedService.isEmpty() && !servicePrice.isEmpty()) {
		            try {
		                double price = Double.parseDouble(servicePrice);

		                // Append service details to the addedItemsArea
		                addedItemsArea.append(" Service: " + selectedService + "\n");
		                addedItemsArea.append(" Price: ₱" + price + "\n");
		                addedItemsArea.append(" ---------------------------------\n");

		                // Update the lists
		                selectedServices.add(selectedService); // Add service name
		                addedServicePrices.add(price); // Add service price

		                
		            } catch (NumberFormatException ex) {
		                JOptionPane.showMessageDialog(null, "Invalid price format!");
		            }
		        } else {
		            JOptionPane.showMessageDialog(null, "Please select a valid service!");
		        }
		    }
		});


		
		JPanel ReceiptPanel = new JPanel();
		ReceiptPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		ReceiptPanel.setBackground(new Color(5, 59, 67));
		ReceiptPanel.setBounds(113, 633, 205, 59);
		panel.add(ReceiptPanel);
		ReceiptPanel.setLayout(null);
		
		
		JButton Receiptbtn = new JButton("RECEIPT");
		Receiptbtn.setBounds(20, 10, 159, 37);
		ReceiptPanel.add(Receiptbtn);
		Receiptbtn.setBackground(new Color(194, 192, 192));
		Receiptbtn.setToolTipText("RECEIPT");
		Receiptbtn.setFont(new Font("Segoe UI", Font.BOLD, 20));
		// ActionListener for Receipt Button
		Receiptbtn.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        try {
		            // Retrieve customer and bill details
		            String customerName = CustomerNametxtfield.getText();
		            String date = new java.text.SimpleDateFormat("MM/dd/yyyy").format(new java.util.Date());
		            String subtotal = subtotaltxtfield.getText().isEmpty() ? "0.00" : subtotaltxtfield.getText();
		            String total = totaltxtfield.getText().isEmpty() ? "0.00" : totaltxtfield.getText();
		            String payment = textField_1.getText().isEmpty() ? "0.00" : textField_1.getText();
		            String change = textField_2.getText().isEmpty() ? "0.00" : textField_2.getText();
		            saveDataToBackend();
		            // Check if the total is calculated
		            if (total.equals("0.00")) {
		                JOptionPane.showMessageDialog(null, "Please calculate the total and process payment before printing the receipt!");
		                return;
		            }

		            // Calculate tax and discount
		            double taxAmount = Double.parseDouble(subtotal) * 0.02;
		            String selectedDiscount = (String) discountComboBox.getSelectedItem();
		            double discountRate = 0.0;
		            if ("PWD (5%)".equals(selectedDiscount)) {
		                discountRate = 0.05;
		            } else if ("Senior Citizen (20%)".equals(selectedDiscount)) {
		                discountRate = 0.20;
		            }
		            double discountAmount = Double.parseDouble(subtotal) * discountRate;

		            // Build the receipt string
		            StringBuilder receipt = new StringBuilder();
		            receipt.append(" ==================================\n");
		            receipt.append("               RECEIPT\n");
		            receipt.append(" ==================================\n");
		            receipt.append(String.format("%-20s : %s\n", " Customer Name", customerName));
		            receipt.append(String.format("%-20s : %s\n", " Date", date)); 
		            receipt.append(" ==================================\n");
		            receipt.append(addedItemsArea.getText());
		            receipt.append(" ==================================\n");
		            receipt.append(String.format("%-20s : ₱%s\n", " Subtotal", subtotal));
		            receipt.append(String.format("%-20s : ₱%.2f\n", " Tax (2%)", taxAmount));
		            receipt.append(String.format("%-20s : ₱%.2f\n", " Discount", discountAmount));
		            receipt.append(String.format("%-20s : ₱%s\n", " Total", total));
		            receipt.append(String.format("%-20s : ₱%s\n", " Payment", payment));
		            receipt.append(String.format("%-20s : ₱%s\n", " Change", change));
		            receipt.append(" ==================================\n");
		            receipt.append("             Thank you!\n");
		            receipt.append(" ==================================\n");

		            // Display the receipt in a JTextArea for preview
		            JTextArea receiptArea = new JTextArea(receipt.toString());
		            receiptArea.setEditable(false);
		            receiptArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
		            JScrollPane scrollPane = new JScrollPane(receiptArea);
		            scrollPane.setPreferredSize(new Dimension(600, 400));
		            JDialog receiptDialog = new JDialog();
		            receiptDialog.setTitle("Receipt");
		            receiptDialog.setSize(350, 450);
		            receiptDialog.setLocationRelativeTo(null);
		            receiptDialog.setModal(true);
		            receiptDialog.getContentPane().add(scrollPane);

		            // Add a "Print" button to the dialog
		            JButton printButton = new JButton("Print");
		            printButton.setFont(new Font("Segoe UI", Font.BOLD, 16));
		            printButton.addActionListener(new ActionListener() {
		                public void actionPerformed(ActionEvent evt) {
		                    try {
		                        // Print the JTextArea content
		                    	
		                        boolean printed = receiptArea.print();
		                        
		                        if (printed) {
		                            JOptionPane.showMessageDialog(null, "Receipt printed successfully!");
		                        } else {
		                            JOptionPane.showMessageDialog(null, "Receipt printing canceled.");
		                        }
		                    } catch (Exception ex) {
		                        JOptionPane.showMessageDialog(null, "Error while printing receipt: " + ex.getMessage());
		                    }
		                }
		            });
		            receiptDialog.getContentPane().add(printButton, "South");

		            
		            receiptDialog.setVisible(true);
		        } catch (NumberFormatException ex) {
		            JOptionPane.showMessageDialog(null, "Invalid numbers detected. Please ensure all inputs are correct!");
		        }
		    }
		});


		
		JPanel ExitPanel = new JPanel();
		ExitPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		ExitPanel.setBackground(new Color(5, 59, 67));
		ExitPanel.setBounds(539, 633, 205, 59);
		panel.add(ExitPanel);
		ExitPanel.setLayout(null);
		
		JButton Exitbtn = new JButton("EXIT");
		Exitbtn.setBounds(24, 10, 159, 37);
		ExitPanel.add(Exitbtn);
		Exitbtn.setBackground(new Color(194, 192, 192));
		Exitbtn.setToolTipText("EXIT");
		Exitbtn.setFont(new Font("Segoe UI", Font.BOLD, 20));
		
		Exitbtn.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        int confirm = JOptionPane.showConfirmDialog(
		            POS.this,
		            "Are you sure you want to exit?",
		            "Exit Confirmation",
		            JOptionPane.YES_NO_OPTION
		        );
		        if (confirm == JOptionPane.YES_OPTION) {
		            dispose();
		            new Dashboard();
		        }
		    }
		});
		
		JPanel MidPanel = new JPanel();
		MidPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		MidPanel.setBackground(new Color(5, 59, 67));
		MidPanel.setBounds(847, 231, 406, 258);
		panel.add(MidPanel);
		MidPanel.setLayout(null);
		
		JLabel subtotallbl = new JLabel("SUB TOTAL");
		subtotallbl.setBounds(46, 21, 186, 34);
		subtotallbl.setForeground(new Color(194, 192, 192));
		subtotallbl.setFont(new Font("Segoe UI", Font.BOLD, 20));
		MidPanel.add(subtotallbl);
		
		JLabel totallbl = new JLabel("TOTAL");
		totallbl.setForeground(new Color(194, 192, 192));
		totallbl.setForeground(new Color(194, 192, 192));
		totallbl.setFont(new Font("Segoe UI", Font.BOLD, 20));
		totallbl.setBounds(46, 134, 186, 34);
		MidPanel.add(totallbl);
		
		totaltxtfield = new JTextField();
		totaltxtfield.setFont(new Font("Segoe UI", Font.BOLD, 20));
		totaltxtfield.setColumns(10);
		totaltxtfield.setBounds(226, 136, 136, 34);
		MidPanel.add(totaltxtfield);
		
		subtotaltxtfield = new JTextField();
		subtotaltxtfield.setFont(new Font("Segoe UI", Font.BOLD, 20));
		subtotaltxtfield.setColumns(10);
		subtotaltxtfield.setBounds(226, 23, 136, 34);
		MidPanel.add(subtotaltxtfield);
		
				
				
				JPanel TotalPanel = new JPanel();
				TotalPanel.setBounds(135, 189, 147, 54);
				MidPanel.add(TotalPanel);
				TotalPanel.setBackground(new Color(5, 59, 67));
				TotalPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
				TotalPanel.setLayout(null);
				
				
				
				JButton Totalbtn = new JButton("TOTAL");
				Totalbtn.setBounds(10, 10, 126, 35);
				TotalPanel.add(Totalbtn);
				Totalbtn.setToolTipText("TOTAL");
				Totalbtn.setBackground(new Color(194, 192, 192));
				Totalbtn.setForeground(new Color(0, 0, 0));
				Totalbtn.setFont(new Font("Segoe UI", Font.BOLD, 20));
				Totalbtn.addActionListener(new ActionListener() {
				    public void actionPerformed(ActionEvent e) {
				        try {
				            double subtotal = 0.0;

				            // Calculate subtotal for products
				            for (double price : addedProductPrices) {
				                subtotal += price;
				            }

				            // Calculate subtotal for services
				            for (double price : addedServicePrices) {
				                subtotal += price;
				            }

				            // Display subtotal
				            subtotaltxtfield.setText(String.format("%.2f", subtotal));

				            // Calculate tax (2%)
				            double tax = subtotal * 0.02;

				            // Get selected discount
				            String selectedDiscount = (String) discountComboBox.getSelectedItem();
				            double discountRate = 0.0;
				            if ("PWD (5%)".equals(selectedDiscount)) {
				                discountRate = 0.05;
				            } else if ("Senior Citizen (20%)".equals(selectedDiscount)) {
				                discountRate = 0.20;
				            }

				            // Apply discount
				            double discount = subtotal * discountRate;

				            // Calculate total
				            double total = subtotal + tax - discount;

				            // Debugging: Print values
				            System.out.println("Subtotal: " + subtotal);
				            System.out.println("Tax: " + tax);
				            System.out.println("Discount Rate: " + discountRate);
				            System.out.println("Discount: " + discount);
				            System.out.println("Total: " + total);

				            // Display total
				            totaltxtfield.setText(String.format("%.2f", total));
				        } catch (NumberFormatException ex) {
				            JOptionPane.showMessageDialog(null, "Please ensure all inputs are valid numbers!");
				        }
				    }
				});
	
				JLabel lblTax = new JLabel("TAX");
				lblTax.setForeground(new Color(194, 192, 192));
				lblTax.setFont(new Font("Segoe UI", Font.BOLD, 20));
				lblTax.setBounds(46, 57, 186, 34);
				MidPanel.add(lblTax);
				
				JLabel lblTax_1 = new JLabel("2%");
				lblTax_1.setForeground(new Color(194, 192, 192));
				lblTax_1.setFont(new Font("Segoe UI", Font.BOLD, 20));
				lblTax_1.setBounds(225, 57, 125, 34);
				MidPanel.add(lblTax_1);
				
				JLabel lblDiscount = new JLabel("DISCOUNT");
				lblDiscount.setForeground(new Color(194, 192, 192));
				lblDiscount.setFont(new Font("Segoe UI", Font.BOLD, 20));
				lblDiscount.setBounds(46, 90, 186, 34);
				MidPanel.add(lblDiscount);
				
				discountComboBox = new JComboBox<>(new String[] {
					    "", "PWD (5%)", "Senior Citizen (20%)"
					});
					discountComboBox.setFont(new Font("Segoe UI", Font.PLAIN, 16));
					discountComboBox.setBounds(226, 92, 136, 34);
					MidPanel.add(discountComboBox);

				
				
				JLabel lblCustomerDetails = new JLabel("CUSTOMER DETAILS:");
				lblCustomerDetails.setForeground(new Color(194, 192, 192));
				lblCustomerDetails.setFont(new Font("Segoe UI", Font.BOLD, 20));
				lblCustomerDetails.setBounds(27, 0, 323, 34);
				panel.add(lblCustomerDetails);
							
							JPanel panel_1 = new JPanel();
							panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
							panel_1.setBackground(new Color(5, 59, 67));
							panel_1.setBounds(847, 499, 406, 193);
							panel.add(panel_1);
							panel_1.setLayout(null);
							
							JLabel lblPayment = new JLabel("PAYMENT");
							lblPayment.setBounds(47, 18, 186, 34);
							panel_1.add(lblPayment);
							lblPayment.setForeground(new Color(194, 192, 192));
							lblPayment.setFont(new Font("Segoe UI", Font.BOLD, 25));
							
							JLabel lblChange = new JLabel("CHANGE");
							lblChange.setBounds(47, 62, 186, 34);
							panel_1.add(lblChange);
							lblChange.setForeground(new Color(194, 192, 192));
							lblChange.setFont(new Font("Segoe UI", Font.BOLD, 25));
							
							textField_2 = new JTextField();
							textField_2.setBounds(227, 64, 136, 34);
							panel_1.add(textField_2);
							textField_2.setFont(new Font("Segoe UI", Font.BOLD, 20));
							textField_2.setColumns(10);
							
							textField_1 = new JTextField();
							textField_1.setBounds(227, 20, 136, 34);
							panel_1.add(textField_1);
							textField_1.setFont(new Font("Segoe UI", Font.BOLD, 20));
							textField_1.setColumns(10);
							
							JPanel TotalPanel_2 = new JPanel();
							TotalPanel_2.setBounds(134, 126, 147, 54);
							panel_1.add(TotalPanel_2);
							TotalPanel_2.setLayout(null);
							TotalPanel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
							TotalPanel_2.setBackground(new Color(5, 59, 67));
							
							JButton btnPay = new JButton("PAY");
							btnPay.setToolTipText("TOTAL");
							btnPay.setForeground(Color.BLACK);
							btnPay.setFont(new Font("Segoe UI", Font.BOLD, 20));
							btnPay.setBackground(new Color(194, 192, 192));
							btnPay.setBounds(10, 10, 126, 35);
							TotalPanel_2.add(btnPay);
							btnPay.addActionListener(new ActionListener() {
							    public void actionPerformed(ActionEvent e) {
							        try {
							            // Parse total amount and payment entered
							            double totalAmount = Double.parseDouble(totaltxtfield.getText());
							            double paymentAmount = Double.parseDouble(textField_1.getText());
							            
							            if (paymentAmount >= totalAmount) {
							                // Calculate change
							                double change = paymentAmount - totalAmount;

							                // Display change in the appropriate text field
							                textField_2.setText(String.format("%.2f", change));
							            } else {
							                // Show error message if payment is insufficient
							                JOptionPane.showMessageDialog(null, "Insufficient payment! Please enter an amount greater than or equal to the total.");
							            }
							        } catch (NumberFormatException ex) {
							            // Show error message if input is invalid
							            JOptionPane.showMessageDialog(null, "Invalid payment or total amount. Please ensure they are valid numbers.");
							        }
							    }
							});

							
																		
										JLabel ContentBackG = new JLabel("");
										ContentBackG.setIcon(new ImageIcon(POS.class.getResource("/Resources/Background (2).png")));
										ContentBackG.setBounds(0, 0, 1286, 713);
										panel.add(ContentBackG);
		
		 Map<String, Double> productPrices = new HashMap<>();
	        productPrices.put("Colgate Optic White", 170.0);
	        productPrices.put("Oral-B Pro Health", 75.0);
	        productPrices.put("Oral-B Toothbrush", 440.0);
	        productPrices.put("Colgate Plax Mouthwash", 135.0);
	        productPrices.put("Oral-B Floss Sticks", 60.0);
	        productPrices.put("Colgate Optic White Teeth Whitening Pen", 1250.0);
	        productPrices.put("Colgate Kids Toothbrush", 80.0);
	        productPrices.put("Oral-B Pro 1000 Electric Toothbrush", 3137.0);

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

	        Productcombobox.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	    	                String selectedProduct = (String) Productcombobox.getSelectedItem();
	    	                if (selectedProduct != null && productPrices.containsKey(selectedProduct)) {
	    	                    Productprice.setText(String.valueOf(productPrices.get(selectedProduct)));
	    	                }
	    	            }
	    	        });
	        // Service ComboBox Listener
	        Servicecombobox.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                String selectedService = (String) Servicecombobox.getSelectedItem();
	                if (selectedService != null && servicePrices.containsKey(selectedService)) {
	                    textField.setText(String.valueOf(servicePrices.get(selectedService)));
	                }
	            }
	        });
	       
	        populateProductComboBox();
	        
	}
	private void saveDataToBackend() {
	    try {
	        // Collect and validate data
	        String customerName = CustomerNametxtfield.getText();
	        if (customerName.isEmpty()) {
	            JOptionPane.showMessageDialog(this, "Customer name is required!");
	            return;
	        }
	        
	        String date = new java.text.SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date());
	        String selectedProductsStr = String.join(", ", selectedProducts); 
	        String selectedServicesStr = String.join(", ", selectedServices);
	        
	        if (selectedProducts.isEmpty() && selectedServices.isEmpty()) {
	            JOptionPane.showMessageDialog(this, "No products or services added!");
	            return;
	        }
	        
	        double productPrice = addedProductPrices.stream().mapToDouble(Double::doubleValue).sum();
	        double servicePrice = addedServicePrices.stream().mapToDouble(Double::doubleValue).sum();
	        double total = Double.parseDouble(totaltxtfield.getText());
	        int quantity = (int) Qtyspinner.getValue();
	        
	        double totalProductPrice = productPrice * quantity;
	        // Save to backend
	        
	        POS_backend backend = new POS_backend(customerName, selectedProductsStr, selectedServicesStr, quantity,productPrice, servicePrice, totalProductPrice, date);
	        
	    } catch (NumberFormatException e) {
	        JOptionPane.showMessageDialog(this, "Invalid number format in total!");
	    } catch (Exception ex) {
	        ex.printStackTrace();
	        JOptionPane.showMessageDialog(this, "Error sending data to backend: " + ex.getMessage());
	    }
	}
	
	private void populateProductComboBox() {
	    POS_backend backend = new POS_backend();
	    List<String[]> products = backend.fetchProducts();

	    for (String[] product : products) {
	        String name = product[0];
	        double price = Double.parseDouble(product[1]);
	        productPricesMap.put(name, price);
	        Productcombobox.addItem(name); // Add product names to the combo box
	    }
	}

	


}

