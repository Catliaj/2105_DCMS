package Main;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;

public class User_Admin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User_Admin frame = new User_Admin();
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
	public User_Admin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 836, 589);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(5, 59, 67));
		panel.setBounds(0, 0, 822, 552);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton userbtn = new JButton("");
		userbtn.setBackground(new Color(194, 192, 192));
		userbtn.setVerticalAlignment(SwingConstants.TOP);
		userbtn.setIcon(new ImageIcon("C:\\Users\\ARAVHEIYL FELICISIMO\\Downloads\\Usericon.png"));
		userbtn.setBounds(168, 250, 198, 180);
		panel.add(userbtn);
		
		JButton adminbtn = new JButton("");
		adminbtn.setBackground(new Color(194, 192, 192));
		adminbtn.setVerticalAlignment(SwingConstants.TOP);
		adminbtn.setIcon(new ImageIcon("C:\\Users\\ARAVHEIYL FELICISIMO\\Downloads\\Adminicon.png"));
		adminbtn.setBounds(444, 250, 198, 180);
		panel.add(adminbtn);
		
		JLabel userlbl = new JLabel("USER");
		userlbl.setForeground(new Color(194, 192, 192));
		userlbl.setFont(new Font("Arial", Font.BOLD, 30));
		userlbl.setBounds(224, 430, 96, 42);
		panel.add(userlbl);
		
		JLabel adminlbl = new JLabel("ADMIN");
		adminlbl.setForeground(new Color(194, 192, 192));
		adminlbl.setFont(new Font("Arial", Font.BOLD, 30));
		adminlbl.setBounds(492, 430, 128, 42);
		panel.add(adminlbl);
		
		JLabel contentBackG = new JLabel("");
		contentBackG.setIcon(new ImageIcon("C:\\Users\\ARAVHEIYL FELICISIMO\\Downloads\\UABackG.png"));
		contentBackG.setBounds(0, 0, 822, 552);
		panel.add(contentBackG);
	}

}
