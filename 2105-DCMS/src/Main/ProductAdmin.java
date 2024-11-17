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
		lblNewLabel_1.setBounds(80, 107, 169, 31);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Product ID");
		lblNewLabel_1_1.setFont(new Font("Segoe UI", Font.BOLD, 22));
		lblNewLabel_1_1.setBounds(101, 237, 129, 31);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Price");
		lblNewLabel_1_2.setFont(new Font("Segoe UI", Font.BOLD, 22));
		lblNewLabel_1_2.setBounds(146, 149, 72, 31);
		panel_1.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("QTY");
		lblNewLabel_1_3.setToolTipText("");
		lblNewLabel_1_3.setFont(new Font("Segoe UI", Font.BOLD, 22));
		lblNewLabel_1_3.setBounds(146, 192, 72, 31);
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
			}
		});
		btnUpload.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnUpload.setBounds(676, 245, 89, 23);
		panel_1.add(btnUpload);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAdd.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnAdd.setBounds(80, 392, 117, 58);
		panel_1.add(btnAdd);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnUpdate.setBounds(218, 393, 113, 57);
		panel_1.add(btnUpdate);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnDelete.setBounds(349, 393, 117, 58);
		panel_1.add(btnDelete);
		
		textFieldProdName = new JTextField();
		textFieldProdName.setColumns(10);
		textFieldProdName.setBounds(260, 107, 151, 31);
		panel_1.add(textFieldProdName);
		
		textFieldPrice = new JTextField();
		textFieldPrice.setColumns(10);
		textFieldPrice.setBounds(260, 149, 151, 29);
		panel_1.add(textFieldPrice);
		
		textFieldProdID = new JTextField();
		textFieldProdID.setColumns(10);
		textFieldProdID.setBounds(260, 237, 151, 29);
		panel_1.add(textFieldProdID);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(260, 192, 151, 29);
		panel_1.add(textField_4);
		
		JButton btnBACK = new JButton("BACK");
		btnBACK.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnBACK.setBounds(849, 392, 117, 58);
		panel_1.add(btnBACK);
	}
}
