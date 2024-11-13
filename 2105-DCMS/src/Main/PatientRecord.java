package Main;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class PatientRecord extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField txtAravheiylBFelicisimo;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_5;
	private JTextField textField_4;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PatientRecord frame = new PatientRecord();
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
	public PatientRecord() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 870, 680);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(194, 192, 192));
		panel.setBounds(0, 0, 856, 643);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("PATIENT DETAILS:");
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 25));
		lblNewLabel.setBounds(23, 10, 246, 60);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(165, 165, 165));
		panel_1.setBounds(290, 81, 537, 255);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("DATE OF BIRTH");
		lblNewLabel_1_1.setBounds(42, 22, 178, 21);
		lblNewLabel_1_1.setFont(new Font("Segoe UI", Font.BOLD, 15));
		panel_1.add(lblNewLabel_1_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(41, 52, 234, 27);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("AGE");
		lblNewLabel_1_1_1.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblNewLabel_1_1_1.setBounds(359, 22, 178, 21);
		panel_1.add(lblNewLabel_1_1_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(359, 52, 63, 27);
		panel_1.add(textField_2);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("EMAIL");
		lblNewLabel_1_1_2.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblNewLabel_1_1_2.setBounds(42, 89, 178, 21);
		panel_1.add(lblNewLabel_1_1_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(42, 120, 286, 27);
		panel_1.add(textField_3);
		
		JLabel lblNewLabel_1_1_2_1 = new JLabel("ADDRESS");
		lblNewLabel_1_1_2_1.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblNewLabel_1_1_2_1.setBounds(42, 169, 178, 21);
		panel_1.add(lblNewLabel_1_1_2_1);
		
		JLabel lblNewLabel_1_1_2_2 = new JLabel("GENDER");
		lblNewLabel_1_1_2_2.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblNewLabel_1_1_2_2.setBounds(359, 89, 178, 21);
		panel_1.add(lblNewLabel_1_1_2_2);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(359, 120, 123, 27);
		panel_1.add(textField_5);
		
		JLabel lblNewLabel_1_1_2_1_1 = new JLabel("CONTACT NO.");
		lblNewLabel_1_1_2_1_1.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblNewLabel_1_1_2_1_1.setBounds(359, 169, 178, 21);
		panel_1.add(lblNewLabel_1_1_2_1_1);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(41, 196, 287, 27);
		panel_1.add(textField_4);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(359, 196, 138, 27);
		panel_1.add(textField_6);
		
		JLabel lblNewLabel_1 = new JLabel("GENERAL INFORMATION");
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblNewLabel_1.setBounds(290, 57, 210, 13);
		panel.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(108, 167, 96, 19);
		panel.add(textField);
		textField.setColumns(10);
		
		txtAravheiylBFelicisimo = new JTextField();
		txtAravheiylBFelicisimo.setFont(new Font("Segoe UI", Font.BOLD, 20));
		txtAravheiylBFelicisimo.setBackground(new Color(194, 192, 192));
		txtAravheiylBFelicisimo.setText("ARAVHEIYL B. FELICISIMO");
		txtAravheiylBFelicisimo.setBounds(21, 196, 259, 60);
		panel.add(txtAravheiylBFelicisimo);
		txtAravheiylBFelicisimo.setColumns(10);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(69, 294, 101, 34);
		panel.add(btnNewButton);
	}
}
