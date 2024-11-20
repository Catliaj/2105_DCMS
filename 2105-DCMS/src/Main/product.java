package Main;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
setVisible(true);
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
		lblPRD1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		JLabel lblPRDNAME = new JLabel("");
		lblPRDNAME.setBounds(20, 151, 132, 26);
		panelPRD1.add(lblPRDNAME);
		lblPRDNAME.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		JLabel lblPRDPRICE = new JLabel("");
		lblPRDPRICE.setBounds(30, 188, 112, 26);
		panelPRD1.add(lblPRDPRICE);
		lblPRDPRICE.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		JPanel panelPRD2 = new JPanel();
		panelPRD2.setBounds(363, 120, 176, 236);
		panel.add(panelPRD2);
		panelPRD2.setLayout(null);
		
		JLabel lblPRD2 = new JLabel("");
		lblPRD2.setBounds(10, 11, 156, 127);
		panelPRD2.add(lblPRD2);
		lblPRD2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		
		JLabel lblPRDNAME_1 = new JLabel("");
		lblPRDNAME_1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		lblPRDNAME_1.setBounds(20, 149, 132, 26);
		panelPRD2.add(lblPRDNAME_1);
		
		JLabel lblPRDPRICE_1 = new JLabel("");
		lblPRDPRICE_1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		lblPRDPRICE_1.setBounds(30, 186, 112, 26);
		panelPRD2.add(lblPRDPRICE_1);
		
		JPanel panelPRD3 = new JPanel();
		panelPRD3.setLayout(null);
		panelPRD3.setBounds(654, 120, 176, 236);
		panel.add(panelPRD3);
		
		JLabel lblPRD3 = new JLabel("");
		lblPRD3.setBounds(10, 11, 156, 127);
		panelPRD3.add(lblPRD3);
		lblPRD3.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		JLabel lblPRDPRICE_1_1 = new JLabel("");
		lblPRDPRICE_1_1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		lblPRDPRICE_1_1.setBounds(30, 186, 112, 26);
		panelPRD3.add(lblPRDPRICE_1_1);
		
		JLabel lblPRDNAME_1_1 = new JLabel("");
		lblPRDNAME_1_1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		lblPRDNAME_1_1.setBounds(20, 149, 132, 26);
		panelPRD3.add(lblPRDNAME_1_1);
		
		
		JPanel panelPRD4 = new JPanel();
		panelPRD4.setLayout(null);
		panelPRD4.setBounds(936, 120, 176, 236);
		panel.add(panelPRD4);
		
		JLabel lblPRD4 = new JLabel("");
		lblPRD4.setBounds(10, 11, 156, 127);
		panelPRD4.add(lblPRD4);
		lblPRD4.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		
		JLabel lblPRDPRICE_1_2 = new JLabel("");
		lblPRDPRICE_1_2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		lblPRDPRICE_1_2.setBounds(30, 181, 112, 26);
		panelPRD4.add(lblPRDPRICE_1_2);
		
		JLabel lblPRDNAME_1_2 = new JLabel("");
		lblPRDNAME_1_2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		lblPRDNAME_1_2.setBounds(20, 144, 132, 26);
		panelPRD4.add(lblPRDNAME_1_2);
		
		JPanel panelPRD5 = new JPanel();
		panelPRD5.setLayout(null);
		panelPRD5.setBounds(94, 406, 176, 236);
		panel.add(panelPRD5);
		
		JLabel lblPRD5 = new JLabel("");
		lblPRD5.setBounds(10, 11, 156, 127);
		panelPRD5.add(lblPRD5);
		lblPRD5.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		JLabel lblPRDPRICE_1_3 = new JLabel("");
		lblPRDPRICE_1_3.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		lblPRDPRICE_1_3.setBounds(30, 186, 112, 26);
		panelPRD5.add(lblPRDPRICE_1_3);
		
		JLabel lblPRDNAME_1_3 = new JLabel("");
		lblPRDNAME_1_3.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		lblPRDNAME_1_3.setBounds(20, 149, 132, 26);
		panelPRD5.add(lblPRDNAME_1_3);
		
		JPanel panelPRD6 = new JPanel();
		panelPRD6.setLayout(null);
		panelPRD6.setBounds(363, 406, 176, 236);
		panel.add(panelPRD6);
		
		JLabel lblPRD6 = new JLabel("");
		lblPRD6.setBounds(10, 11, 156, 127);
		panelPRD6.add(lblPRD6);
		lblPRD6.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		JLabel lblPRDPRICE_1_4 = new JLabel("");
		lblPRDPRICE_1_4.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		lblPRDPRICE_1_4.setBounds(30, 182, 112, 26);
		panelPRD6.add(lblPRDPRICE_1_4);
		
		JLabel lblPRDNAME_1_4 = new JLabel("");
		lblPRDNAME_1_4.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		lblPRDNAME_1_4.setBounds(20, 145, 132, 26);
		panelPRD6.add(lblPRDNAME_1_4);
		
		JPanel panelPRD7 = new JPanel();
		panelPRD7.setLayout(null);
		panelPRD7.setBounds(654, 406, 176, 236);
		panel.add(panelPRD7);
		
		JLabel lblPRD7 = new JLabel("");
		lblPRD7.setBounds(10, 11, 156, 127);
		panelPRD7.add(lblPRD7);
		lblPRD7.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		JLabel lblPRDPRICE_1_5 = new JLabel("");
		lblPRDPRICE_1_5.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		lblPRDPRICE_1_5.setBounds(30, 186, 112, 26);
		panelPRD7.add(lblPRDPRICE_1_5);
		
		JLabel lblPRDNAME_1_5 = new JLabel("");
		lblPRDNAME_1_5.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		lblPRDNAME_1_5.setBounds(20, 149, 132, 26);
		panelPRD7.add(lblPRDNAME_1_5);
		
		JPanel panelPRD8 = new JPanel();
		panelPRD8.setLayout(null);
		panelPRD8.setBounds(936, 406, 176, 236);
		panel.add(panelPRD8);
		
		JLabel lblPRD8 = new JLabel("");
		lblPRD8.setBounds(10, 11, 156, 127);
		panelPRD8.add(lblPRD8);
		lblPRD8.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		JLabel lblPRDPRICE_1_6 = new JLabel("");
		lblPRDPRICE_1_6.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		lblPRDPRICE_1_6.setBounds(30, 186, 112, 26);
		panelPRD8.add(lblPRDPRICE_1_6);
		
		JLabel lblPRDNAME_1_6 = new JLabel("");
		lblPRDNAME_1_6.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		lblPRDNAME_1_6.setBounds(20, 149, 132, 26);
		panelPRD8.add(lblPRDNAME_1_6);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new homePage();
				
			}
		});
		btnBack.setFont(new Font("Segoe UI", Font.BOLD, 23));
		btnBack.setBounds(1160, 652, 114, 48);
		panel.add(btnBack);
		
		JLabel lblNewLabel = new JLabel("PREVENTIVE PRODUCT");
		lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 35));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setIcon(new ImageIcon(product.class.getResource("/Resources/background (2).png")));
		lblNewLabel.setBounds(0, 0, 1284, 711);
		panel.add(lblNewLabel);
	}
}
