package Main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Main.appointmentPage.BackgroundPanel;

import java.awt.BorderLayout;
import javax.swing.JSplitPane;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Toolkit;

public class appointment extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					appointment frame = new appointment();
					frame.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public appointment() {
		setTitle("Appointment");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\AcerN\\eclipse-workspace\\Main\\src\\Main\\Logo.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1380, 468);
		setSize(1440,1024);
		getContentPane().setLayout(new BorderLayout());
		contentPane = new JPanel();
		contentPane.setBackground(new Color(47, 79, 79));
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel Header = new JPanel();
		Header.setBounds(0, 0, 1453, 107);
		Header.setBackground(new  Color(5,59,67));
		contentPane.add(Header);
		Header.setLayout(null);
		
		JButton contactUsBtn = new JButton("Contacts");
		contactUsBtn.setBounds(1240, 0, 185, 107);
		Header.add(contactUsBtn);
		
		JButton productsBtn = new JButton("Products");
		productsBtn.setBounds(1055, 0, 185, 107);
		Header.add(productsBtn);
		
		JButton appointmentBtn = new JButton("Appointment");
		appointmentBtn.setBounds(872, 0, 185, 107);
		Header.add(appointmentBtn);
		
		JButton servicesBtn = new JButton("Services");
		servicesBtn.setBounds(687, 0, 185, 107);
		Header.add(servicesBtn);
		
		JButton aboutUsBtn = new JButton("About");
		aboutUsBtn.setBounds(504, 0, 185, 107);
		Header.add(aboutUsBtn);
		
		JButton homeBtn = new JButton("Home");
		homeBtn.setBounds(320, -2, 185, 109);
		Header.add(homeBtn);
		// style buttons
        appointmentBtn.setFont(new Font("Arial", Font.BOLD, 16));
        appointmentBtn.setBackground(Color.WHITE);
        appointmentBtn.setForeground(new Color(2, 79, 90));
        appointmentBtn.setFocusable(false);
        appointmentBtn.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        setButtonStyles(homeBtn);
        setButtonStyles(servicesBtn);
        setButtonStyles(aboutUsBtn);
        setButtonStyles(productsBtn);
        setButtonStyles(contactUsBtn);
        
        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setBounds(10, 10, 281, 155);
        Header.add(lblNewLabel_1);
        lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\AcerN\\eclipse-workspace\\Main\\src\\Main\\haederLogo.png"));
        

		
		JPanel panel = new JPanel();
		panel.setBounds(43, 155, 619, 585);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("BOOK AN APPOINTMENT");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 48));
		lblNewLabel.setBounds(27, 10, 549, 36);
		panel.add(lblNewLabel);
		
		JLabel lblWeAreDelighted = new JLabel("We are delighted to welcome");
		lblWeAreDelighted.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblWeAreDelighted.setBounds(27, 56, 477, 36);
		panel.add(lblWeAreDelighted);
		
		JLabel lblAnyoneWithDental = new JLabel("anyone with dental needs and");
		lblAnyoneWithDental.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblAnyoneWithDental.setBounds(27, 95, 458, 36);
		panel.add(lblAnyoneWithDental);
		
		JLabel lblInquiriesToOur = new JLabel("inquiries to our practice. Our team");
		lblInquiriesToOur.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblInquiriesToOur.setBounds(27, 141, 517, 36);
		panel.add(lblInquiriesToOur);
		
		JLabel lblOfExperiencedProfessionals = new JLabel("of experienced professionals is");
		lblOfExperiencedProfessionals.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblOfExperiencedProfessionals.setBounds(27, 187, 517, 36);
		panel.add(lblOfExperiencedProfessionals);
		
		JLabel lblCommittedToProviding = new JLabel("committed to providing the highest");
		lblCommittedToProviding.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblCommittedToProviding.setBounds(27, 237, 532, 36);
		panel.add(lblCommittedToProviding);
		
		JLabel lblQualityOfCare = new JLabel("quality of care for all your oral ");
		lblQualityOfCare.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblQualityOfCare.setBounds(27, 283, 532, 36);
		panel.add(lblQualityOfCare);
		
		JLabel lblHealthNeeds = new JLabel("health needs.");
		lblHealthNeeds.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblHealthNeeds.setBounds(27, 326, 316, 36);
		panel.add(lblHealthNeeds);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(861, 155, 528, 585);
		contentPane.add(panel_1);
		
		JLabel background = new JLabel("New label");
		background.setIcon(new ImageIcon("C:\\Users\\AcerN\\eclipse-workspace\\Main\\src\\Main\\Background (2).png"));
		background.setBounds(0, 0, 45, 13);
		contentPane.add(background);
		
		
	}
	
    private void setButtonStyles(JButton button) 
    {
        button.setFont(new Font("Arial", Font.BOLD, 16));
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(5, 59, 67));
        button.setFocusable(false);
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        button.addActionListener(this);
    }


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
} 