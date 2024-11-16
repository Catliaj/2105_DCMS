package Main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class product extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					product frame = new product();
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
	public product() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1300, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1284, 711);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("PREVENTIVE PRODUCT");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 35));
		lblNewLabel_1.setBounds(47, 11, 398, 50);
		panel.add(lblNewLabel_1);
		
		JPanel panelPRD1 = new JPanel();
		panelPRD1.setBounds(94, 120, 176, 236);
		panel.add(panelPRD1);
		panelPRD1.setLayout(null);
		
		JLabel lblPRD1 = new JLabel("");
		lblPRD1.setBounds(10, 5, 156, 127);
		panelPRD1.add(lblPRD1);
		
		JTextArea textAreaPRDname1 = new JTextArea();
		textAreaPRDname1.setBounds(10, 158, 156, 22);
		panelPRD1.add(textAreaPRDname1);
		
		JTextArea textAreaPrice1 = new JTextArea();
		textAreaPrice1.setBounds(10, 191, 156, 22);
		panelPRD1.add(textAreaPrice1);
		
		JPanel panelPRD2 = new JPanel();
		panelPRD2.setBounds(363, 120, 176, 236);
		panel.add(panelPRD2);
		panelPRD2.setLayout(null);
		
		JLabel lblPRD2 = new JLabel("");
		lblPRD2.setBounds(10, 11, 156, 127);
		panelPRD2.add(lblPRD2);
		
		JTextArea textAreaPrice2 = new JTextArea();
		textAreaPrice2.setBounds(10, 191, 156, 22);
		panelPRD2.add(textAreaPrice2);
		
		JTextArea textAreaPRDname2 = new JTextArea();
		textAreaPRDname2.setBounds(10, 158, 156, 22);
		panelPRD2.add(textAreaPRDname2);
		
		JPanel panelPRD3 = new JPanel();
		panelPRD3.setLayout(null);
		panelPRD3.setBounds(654, 120, 176, 236);
		panel.add(panelPRD3);
		
		JLabel lblPRD3 = new JLabel("");
		lblPRD3.setBounds(10, 11, 156, 127);
		panelPRD3.add(lblPRD3);
		
		JTextArea textAreaPrice3 = new JTextArea();
		textAreaPrice3.setBounds(10, 192, 156, 22);
		panelPRD3.add(textAreaPrice3);
		
		JTextArea textAreaPRDname3 = new JTextArea();
		textAreaPRDname3.setBounds(10, 159, 156, 22);
		panelPRD3.add(textAreaPRDname3);
		
		JPanel panelPRD4 = new JPanel();
		panelPRD4.setLayout(null);
		panelPRD4.setBounds(936, 120, 176, 236);
		panel.add(panelPRD4);
		
		JLabel lblPRD4 = new JLabel("");
		lblPRD4.setBounds(10, 11, 156, 127);
		panelPRD4.add(lblPRD4);
		
		JTextArea textAreaPrice4 = new JTextArea();
		textAreaPrice4.setBounds(10, 192, 156, 22);
		panelPRD4.add(textAreaPrice4);
		
		JTextArea textAreaPRDname4 = new JTextArea();
		textAreaPRDname4.setBounds(10, 161, 156, 22);
		panelPRD4.add(textAreaPRDname4);
		
		JPanel panelPRD5 = new JPanel();
		panelPRD5.setLayout(null);
		panelPRD5.setBounds(94, 406, 176, 236);
		panel.add(panelPRD5);
		
		JLabel lblPRD5 = new JLabel("");
		lblPRD5.setBounds(10, 11, 156, 127);
		panelPRD5.add(lblPRD5);
		
		JTextArea textAreaPRDname5 = new JTextArea();
		textAreaPRDname5.setBounds(10, 159, 156, 22);
		panelPRD5.add(textAreaPRDname5);
		
		JTextArea textAreaPrice5 = new JTextArea();
		textAreaPrice5.setBounds(10, 192, 156, 22);
		panelPRD5.add(textAreaPrice5);
		
		JPanel panelPRD6 = new JPanel();
		panelPRD6.setLayout(null);
		panelPRD6.setBounds(363, 406, 176, 236);
		panel.add(panelPRD6);
		
		JLabel lblPRD6 = new JLabel("");
		lblPRD6.setBounds(10, 11, 156, 127);
		panelPRD6.add(lblPRD6);
		
		JTextArea textAreaPRDname6 = new JTextArea();
		textAreaPRDname6.setBounds(10, 153, 156, 22);
		panelPRD6.add(textAreaPRDname6);
		
		JTextArea textAreaPrice6 = new JTextArea();
		textAreaPrice6.setBounds(10, 186, 156, 22);
		panelPRD6.add(textAreaPrice6);
		
		JPanel panelPRD7 = new JPanel();
		panelPRD7.setLayout(null);
		panelPRD7.setBounds(654, 406, 176, 236);
		panel.add(panelPRD7);
		
		JLabel lblPRD7 = new JLabel("");
		lblPRD7.setBounds(10, 11, 156, 127);
		panelPRD7.add(lblPRD7);
		
		JTextArea textAreaPRDname7 = new JTextArea();
		textAreaPRDname7.setBounds(10, 149, 156, 22);
		panelPRD7.add(textAreaPRDname7);
		
		JTextArea textAreaPrice7 = new JTextArea();
		textAreaPrice7.setBounds(10, 182, 156, 22);
		panelPRD7.add(textAreaPrice7);
		
		JPanel panelPRD8 = new JPanel();
		panelPRD8.setLayout(null);
		panelPRD8.setBounds(936, 406, 176, 236);
		panel.add(panelPRD8);
		
		JLabel lblPRD8 = new JLabel("");
		lblPRD8.setBounds(10, 11, 156, 127);
		panelPRD8.add(lblPRD8);
		
		JTextArea textAreaPRDname8 = new JTextArea();
		textAreaPRDname8.setBounds(10, 149, 156, 22);
		panelPRD8.add(textAreaPRDname8);
		
		JTextArea textAreaPrice8 = new JTextArea();
		textAreaPrice8.setBounds(10, 182, 156, 22);
		panelPRD8.add(textAreaPrice8);
		
		JButton btnBack = new JButton("BACK");
		btnBack.setFont(new Font("Segoe UI", Font.BOLD, 23));
		btnBack.setBounds(1160, 652, 114, 48);
		panel.add(btnBack);
		
		JLabel lblNewLabel = new JLabel("PREVENTIVE PRODUCT");
		lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 35));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\desuy\\Downloads\\Background.png"));
		lblNewLabel.setBounds(0, 0, 1284, 711);
		panel.add(lblNewLabel);
	}
}
