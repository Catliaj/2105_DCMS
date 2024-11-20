package Main;
import java.awt.EventQueue;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Timer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.ImageIcon;

public class Dashboard extends JFrame implements ActionListener{

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel timeLabel;
    private JTextField textField;
    private JTextField textField_1;
    private JButton Dashboardbtn;
    private JButton Patientsbtn;
    private JButton Appointmentsbtn;
    private JButton Productbtn;
    private JButton Billingbtn;
    private JButton Logoutbtn;
    private JButton ProductSalesbtn;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Dashboard frame = new Dashboard();
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
    public Dashboard() {
    	setResizable(false);
    	setVisible(true);
        setTitle("DASHBOARD");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1300, 750);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setLocationRelativeTo(null);

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 1286, 713);
        contentPane.add(panel);
        panel.setLayout(null);

        JPanel HeaderPanel = new JPanel();
        HeaderPanel.setBackground(new Color(5, 59, 67));
        HeaderPanel.setBounds(0, 0, 1286, 107);
        panel.add(HeaderPanel);
        HeaderPanel.setLayout(null);

        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setIcon(new ImageIcon(Dashboard.class.getResource("/Resources/ClinicLogo.png")));
        lblNewLabel_2.setBounds(386, 28, 406, 50);
        HeaderPanel.add(lblNewLabel_2);
        
        JLabel lblNewLabel_5 = new JLabel("");
        lblNewLabel_5.setIcon(new ImageIcon(Dashboard.class.getResource("/Resources/HeaderPanelBG.png")));
        lblNewLabel_5.setBounds(0, 0, 1286, 107);
        HeaderPanel.add(lblNewLabel_5);

        JPanel SidePanel = new JPanel();
        SidePanel.setBackground(new Color(5, 59, 67));
        SidePanel.setBounds(0, 129, 229, 584);
        panel.add(SidePanel);
        SidePanel.setLayout(null);

        Dashboardbtn = new JButton("DASHBOARD");
        Dashboardbtn.setBackground(Color.white);
        Dashboardbtn.setFont(new Font("Segoe UI", Font.BOLD, 25));
        Dashboardbtn.setBounds(0, 85, 228, 57);
        Dashboardbtn.addActionListener(this);
        SidePanel.add(Dashboardbtn);

        Patientsbtn = new JButton("PATIENTS");
        Patientsbtn.setFont(new Font("Segoe UI", Font.BOLD, 25));
        Patientsbtn.setBackground(new Color(194, 192, 192));
        Patientsbtn.setBounds(0, 145, 228, 57);
        Patientsbtn.addActionListener(this);
        SidePanel.add(Patientsbtn);

        Appointmentsbtn = new JButton("APPOINTMENTS");
        Appointmentsbtn.setBackground(new Color(194, 192, 192));
        Appointmentsbtn.setFont(new Font("Segoe UI", Font.BOLD, 25));
        Appointmentsbtn.setBounds(0, 205, 228, 57);
        Appointmentsbtn.addActionListener(this);
        SidePanel.add(Appointmentsbtn);

        Productbtn = new JButton("PRODUCT");
        Productbtn.setFont(new Font("Segoe UI", Font.BOLD, 25));
        Productbtn.setBackground(new Color(194, 192, 192));
        Productbtn.setBounds(0, 265, 228, 57);
        Productbtn.addActionListener(this);
        SidePanel.add(Productbtn);

        Billingbtn = new JButton("POS");
        Billingbtn.setBackground(new Color(194, 192, 192));
        Billingbtn.setFont(new Font("Segoe UI", Font.BOLD, 25));
        Billingbtn.setBounds(0, 386, 228, 57);
        Billingbtn.addActionListener(this);
        SidePanel.add(Billingbtn);

        Logoutbtn = new JButton("LOG OUT");
        Logoutbtn.setFont(new Font("Segoe UI", Font.BOLD, 25));
        Logoutbtn.setBackground(new Color(194, 192, 192));
        Logoutbtn.setBounds(0, 529, 228, 57);
        Logoutbtn.addActionListener(this);
        SidePanel.add(Logoutbtn);

        ProductSalesbtn = new JButton("SALES");
        ProductSalesbtn.setFont(new Font("Segoe UI", Font.BOLD, 25));
        ProductSalesbtn.setBackground(new Color(194, 192, 192));
        ProductSalesbtn.setBounds(0, 325, 228, 57);
        ProductSalesbtn.addActionListener(this);
        SidePanel.add(ProductSalesbtn);
        
        JLabel lblNewLabel_6 = new JLabel("");
        lblNewLabel_6.setIcon(new ImageIcon(Dashboard.class.getResource("/Resources/SidePanelBG.png")));
        lblNewLabel_6.setBounds(0, 0, 301, 551);
        SidePanel.add(lblNewLabel_6);

        JPanel panel_3 = new JPanel();
        panel_3.setBackground(new Color(194, 192, 192));
        panel_3.setBounds(0, 107, 1286, 23);
        panel.add(panel_3);

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(5, 59, 67));
        panel_1.setBounds(396, 239, 284, 121);
        panel.add(panel_1);
        panel_1.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(Dashboard.class.getResource("/Resources/Personicon.png")));
        lblNewLabel.setBounds(-264, 10, 395, 162);
        panel_1.add(lblNewLabel);
        
        JLabel lblNewLabel_4 = new JLabel("PATIENTS TODAY");
        lblNewLabel_4.setForeground(new Color(194, 192, 192));
        lblNewLabel_4.setFont(new Font("Segoe UI", Font.BOLD, 23));
        lblNewLabel_4.setBackground(new Color(194, 192, 192));
        lblNewLabel_4.setBounds(77, 10, 197, 26);
        panel_1.add(lblNewLabel_4);
        
        textField = new JTextField();
        textField.setBounds(123, 46, 96, 53);
        panel_1.add(textField);
        textField.setColumns(10);

        JPanel panel_1_1 = new JPanel();
        panel_1_1.setBackground(new Color(5, 59, 67));
        panel_1_1.setBounds(798, 239, 284, 121);
        panel.add(panel_1_1);
        panel_1_1.setLayout(null);
        
        JLabel lblNewLabel_3 = new JLabel("");
        lblNewLabel_3.setBounds(-260, 20, 375, 148);
        panel_1_1.add(lblNewLabel_3);
        lblNewLabel_3.setIcon(new ImageIcon(Dashboard.class.getResource("/Resources/Personicon.png")));
        
        JLabel lblNewLabel_4_1 = new JLabel("TOTAL PATIENTS");
        lblNewLabel_4_1.setForeground(new Color(194, 192, 192));
        lblNewLabel_4_1.setFont(new Font("Segoe UI", Font.BOLD, 23));
        lblNewLabel_4_1.setBackground(new Color(194, 192, 192));
        lblNewLabel_4_1.setBounds(77, 10, 197, 26);
        panel_1_1.add(lblNewLabel_4_1);
        
        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(125, 46, 96, 53);
        panel_1_1.add(textField_1);

        JPanel panel_2 = new JPanel();
        panel_2.setBackground(new Color(5, 59, 67));
        panel_2.setBounds(227, 663, 1059, 50);
        panel.add(panel_2);
        panel_2.setLayout(null);

        // Add time label to panel_2
        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
        timeLabel.setForeground(Color.WHITE);
        timeLabel.setBounds(648, 10, 401, 30);
        panel_2.add(timeLabel);

        // Set up timer to update the time label every second
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Update the label with the current date and time
                timeLabel.setText(getCurrentDateTime());
            }
        });
        timer.start();

        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon(Dashboard.class.getResource("/Resources/Background (2).png")));
        lblNewLabel_1.setBounds(10, 72, 1286, 743);
        panel.add(lblNewLabel_1);
    
        textField.setText(String.valueOf(getPatientsToday())); 
        textField_1.setText(String.valueOf(getTotalPatients())); 

    }

    // Method to get the current date and time with day and full month name
    private String getCurrentDateTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("EEEE, MMMM dd, yyyy HH:mm:ss");
        return formatter.format(new Date());
    }

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		if(e.getSource() == Patientsbtn)
		{
			dispose();
			new Patients();
		}
		else if(e.getSource() == Appointmentsbtn)
		{
			dispose();
			new Appointments();
		}
		else if(e.getSource() == Productbtn)
		{
			System.out.println("click");
		}
		else if(e.getSource() == Billingbtn )
		{
			System.out.println("click");
		}
		else if(e.getSource() == ProductSalesbtn )
		{
			dispose();
			new SALES();
		}
		else if(e.getSource() == Logoutbtn)
		{
			dispose();
		}
		
	}
	// Method to get total number of patients from the database
	private int getTotalPatients() {
	    int totalPatients = 0;
	    try {
	        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dcfdentalclinicdb", "admin", "admin");
	        String query = "SELECT COUNT(*) AS patiendid FROM patientdata";
	        PreparedStatement pst = con.prepareStatement(query);
	        ResultSet rs = pst.executeQuery();
	        if (rs.next()) {
	            totalPatients = rs.getInt("patiendid");
	        }
	        con.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return totalPatients;
	}

	// Method to get today's patients from the database
	private int getPatientsToday() {
	    int patientsToday = 0;
	    try {
	        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dcfdentalclinicdb", "admin", "admin");
	        String query = "SELECT COUNT(*) AS patients_today FROM patientdata WHERE DATE(registrationdate) = CURDATE()";
	        PreparedStatement pst = con.prepareStatement(query);
	        ResultSet rs = pst.executeQuery();
	        if (rs.next()) {
	            patientsToday = rs.getInt("patients_today");
	        }
	        con.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return patientsToday;
	}

}
