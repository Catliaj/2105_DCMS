package Main;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import backend.POS_backend;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class ProductSales extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JButton btnBack;
	private JButton btnRefresh;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductSales frame = new ProductSales();
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
	public ProductSales() {
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1150, 652);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(5, 59, 67));
		panel.setBounds(0, 0, 1136, 615);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(94, 82, 950, 431);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(218, 216, 216));
		table.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"PRODUCT ID ", "PRODUCT NAME", "DATE", "QUANTITY", "PRICE", "TOTAL"
			}
		));
		
	     // Set row height and column widths
        table.setRowHeight(30); // Set to a larger value as needed
        table.getColumnModel().getColumn(0).setPreferredWidth(30); 
        table.getColumnModel().getColumn(1).setPreferredWidth(150); 
        table.getColumnModel().getColumn(2).setPreferredWidth(50);  
        table.getColumnModel().getColumn(3).setPreferredWidth(50); 
        table.getColumnModel().getColumn(4).setPreferredWidth(50); 
        table.getColumnModel().getColumn(5).setPreferredWidth(50);  

        
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("PRODUCT SALES");
		lblNewLabel.setForeground(new Color(194, 192, 192));
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 40));
		lblNewLabel.setBounds(426, 10, 328, 49);
		panel.add(lblNewLabel);
		
	    btnBack= new JButton("BACK");
		btnBack.addActionListener(this);
		btnBack.setBackground(new Color(194, 192, 192));
		btnBack.setFont(new Font("Segoe UI", Font.BOLD, 20));
		btnBack.setBounds(602, 555, 175, 45);
		panel.add(btnBack);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(5, 59, 67));
		panel_1.setBounds(77, 69, 981, 458);
		panel.add(panel_1);
		
		btnRefresh = new JButton("REFRESH");
		btnRefresh.addActionListener(this);
		btnRefresh.setFont(new Font("Segoe UI", Font.BOLD, 20));
		btnRefresh.setBackground(new Color(194, 192, 192));
		btnRefresh.setBounds(365, 555, 175, 45);
		panel.add(btnRefresh);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(ProductSales.class.getResource("/Resources/Background (2).png")));
		lblNewLabel_1.setBounds(0, 0, 1136, 615);
		panel.add(lblNewLabel_1);
		loadProductBillData();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == btnBack)
		{
			dispose();
			new SALES();
		}
		else if (e.getSource() == btnRefresh) {
			dispose();
			new ProductSales();
		}
	}
	private void loadProductBillData() 
	{
		
	    DefaultTableModel model = (DefaultTableModel) table.getModel();
	    model.setRowCount(0); // Clear existing data
	   
	    POS_backend backend = new POS_backend();
	    List<String[]> ProductBillData = backend.getProductBillData();
	    // Check if there is any data to display
	    if (ProductBillData.isEmpty()) {
	        JOptionPane.showMessageDialog(this, "No patient data found.");
	        return;
	    }
	    // Loop through the list and add rows to the table
	    for (String[] row : ProductBillData) {
	        model.addRow(row);
	    }
	}
}
