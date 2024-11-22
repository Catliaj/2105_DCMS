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
import javax.swing.JTextPane;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PatientRecord extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

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
		setTitle("PATIENT DETAILS");
		setResizable(false);
    	setVisible(true);
    	setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 870, 680);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(194, 192, 192));
		panel.setBounds(0, 0, 856, 643);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("PATIENT DETAILS:");
		lblNewLabel.setBounds(17, 10, 246, 60);
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 25));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(290, 81, 537, 260);
		panel_1.setBackground(new Color(165, 165, 165));
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("DATE OF BIRTH");
		lblNewLabel_1_1.setBounds(42, 22, 178, 21);
		lblNewLabel_1_1.setFont(new Font("Segoe UI", Font.BOLD, 15));
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("AGE");
		lblNewLabel_1_1_1.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblNewLabel_1_1_1.setBounds(359, 22, 178, 21);
		panel_1.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("EMAIL");
		lblNewLabel_1_1_2.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblNewLabel_1_1_2.setBounds(42, 89, 178, 21);
		panel_1.add(lblNewLabel_1_1_2);
		
		JLabel lblNewLabel_1_1_2_1 = new JLabel("ADDRESS");
		lblNewLabel_1_1_2_1.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblNewLabel_1_1_2_1.setBounds(42, 169, 178, 21);
		panel_1.add(lblNewLabel_1_1_2_1);
		
		JLabel lblNewLabel_1_1_2_2 = new JLabel("GENDER");
		lblNewLabel_1_1_2_2.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblNewLabel_1_1_2_2.setBounds(359, 89, 178, 21);
		panel_1.add(lblNewLabel_1_1_2_2);
		
		JLabel lblNewLabel_1_1_2_1_1 = new JLabel("CONTACT NO.");
		lblNewLabel_1_1_2_1_1.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblNewLabel_1_1_2_1_1.setBounds(359, 169, 178, 21);
		panel_1.add(lblNewLabel_1_1_2_1_1);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(42, 53, 286, 26);
		panel_1.add(textPane);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBounds(358, 53, 52, 26);
		panel_1.add(textPane_1);
		
		JTextPane textPane_2 = new JTextPane();
		textPane_2.setBounds(42, 120, 286, 26);
		panel_1.add(textPane_2);
		
		JTextPane textPane_1_1 = new JTextPane();
		textPane_1_1.setBounds(358, 120, 81, 26);
		panel_1.add(textPane_1_1);
		
		JTextPane textPane_1_1_1 = new JTextPane();
		textPane_1_1_1.setBounds(359, 196, 147, 26);
		panel_1.add(textPane_1_1_1);
		
		JTextPane textPane_2_1 = new JTextPane();
		textPane_2_1.setBounds(42, 196, 286, 26);
		panel_1.add(textPane_2_1);
		
		JLabel lblNewLabel_1 = new JLabel("GENERAL INFORMATION");
		lblNewLabel_1.setBounds(290, 57, 210, 13);
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 15));
		panel.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("DELETE");
		btnNewButton.setForeground(new Color(194, 192, 192));
		btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 20));
		btnNewButton.setBackground(new Color(5, 59, 67));
		btnNewButton.setBounds(23, 307, 117, 34);
		panel.add(btnNewButton);
		
		JTextPane textPane_2_1_1 = new JTextPane();
		textPane_2_1_1.setBounds(96, 189, 101, 26);
		panel.add(textPane_2_1_1);
		
		JTextPane textPane_2_1_1_1 = new JTextPane();
		textPane_2_1_1_1.setBounds(23, 225, 240, 72);
		panel.add(textPane_2_1_1_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(80, 78, 137, 101);
		panel.add(panel_2);
		
		JButton btnNewButton_1 = new JButton("SAVE");
		btnNewButton_1.setForeground(new Color(194, 192, 192));
		btnNewButton_1.setBackground(new Color(5, 59, 67));
		btnNewButton_1.setFont(new Font("Segoe UI", Font.BOLD, 20));
		btnNewButton_1.setBounds(161, 307, 101, 34);
		panel.add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 395, 792, 221);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(226, 224, 224));
		table.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"DATE", "TIME", "TREATMENT", "REMARKS"
			}
		));
		
		   // Set row height and column widths
        table.setRowHeight(30); // Set to a larger value as needed
        table.getColumnModel().getColumn(0).setPreferredWidth(100); // Patient ID
        table.getColumnModel().getColumn(1).setPreferredWidth(150); // First Name
        table.getColumnModel().getColumn(2).setPreferredWidth(50);  // M.I
        table.getColumnModel().getColumn(3).setPreferredWidth(150); // Last Name
        
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_2 = new JLabel("PATIENT HISTORY");
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel_2.setBounds(25, 365, 244, 26);
		panel.add(lblNewLabel_2);
	}
}
