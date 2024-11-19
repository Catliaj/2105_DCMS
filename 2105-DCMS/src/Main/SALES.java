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
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.SwingConstants;

public class SALES extends JFrame implements ActionListener{

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;
    private JTable table_1;
    private JButton Dashboardbtn;
    private JButton Patientsbtn;
    private JButton Appointmentsbtn;
    private JButton Productbtn;
    private JButton Billingbtn;
    private JButton Logoutbtn;
    private JButton ProductSalesbtn;
    private JButton btnServicesSales;
    private  JButton btnProductSales;
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SALES frame = new SALES();
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
    public SALES() {
    	setVisible(true);
        setTitle("DASHBOARD");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1300, 750);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

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
                lblNewLabel_2.setBounds(408, 28, 406, 50);
                HeaderPanel.add(lblNewLabel_2);
                lblNewLabel_2.setIcon(new ImageIcon(SALES.class.getResource("/Resources/ClinicLogo.png")));
                
                JLabel lblNewLabel_4 = new JLabel("");
                lblNewLabel_4.setIcon(new ImageIcon(SALES.class.getResource("/Resources/HeaderPanelBG.png")));
                lblNewLabel_4.setBounds(0, 0, 1314, 107);
                HeaderPanel.add(lblNewLabel_4);

        JPanel SidePanel = new JPanel();
        SidePanel.setBackground(new Color(5, 59, 67));
        SidePanel.setBounds(0, 126, 229, 587);
        panel.add(SidePanel);
        SidePanel.setLayout(null);

        Dashboardbtn = new JButton("DASHBOARD");
        Dashboardbtn.setBackground(new Color(194, 192, 192));
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
        ProductSalesbtn.setBackground( Color.white);
        ProductSalesbtn.setBounds(0, 325, 228, 57);
        ProductSalesbtn.addActionListener(this);
        SidePanel.add(ProductSalesbtn);
        
        JLabel lblNewLabel_5 = new JLabel("");
        lblNewLabel_5.setIcon(new ImageIcon(SALES.class.getResource("/Resources/SidePanelBG.png")));
        lblNewLabel_5.setBounds(0, 0, 228, 587);
        SidePanel.add(lblNewLabel_5);

        JPanel panel_3 = new JPanel();
        panel_3.setBackground(new Color(194, 192, 192));
        panel_3.setBounds(0, 107, 1286, 20);
        panel.add(panel_3);

        
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(5, 59, 67));
        panel_1.setBounds(460, 126, 585, 57);
        panel.add(panel_1);
        panel_1.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("OVERALL SALES");
        lblNewLabel.setForeground(new Color(194, 192, 192));
        lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 25));
        lblNewLabel.setBounds(207, 10, 198, 34);
        panel_1.add(lblNewLabel);
        
                         
         btnServicesSales = new JButton("SERVICE SALES");
         btnServicesSales.setIcon(new ImageIcon(SALES.class.getResource("/Resources/increase (2).png")));
         btnServicesSales.addActionListener(this);
         btnServicesSales.setBackground(new Color(194, 192, 192));
         btnServicesSales.setForeground(new Color(0, 0, 0));
         btnServicesSales.setFont(new Font("Segoe UI", Font.BOLD, 30));
         btnServicesSales.setBounds(329, 333, 415, 149);
         panel.add(btnServicesSales);
        
        btnProductSales = new JButton("PRODUCT SALES");
        btnProductSales.setIcon(new ImageIcon(SALES.class.getResource("/Resources/increase (2).png")));
        btnProductSales.setForeground(Color.BLACK);
        btnProductSales.setFont(new Font("Segoe UI", Font.BOLD, 30));
        btnProductSales.setBackground(new Color(194, 192, 192));
        btnProductSales.setBounds(777, 333, 415, 149);
        btnProductSales.addActionListener(this);
        panel.add(btnProductSales);
        
        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon(SALES.class.getResource("/Resources/Background (2).png")));
        lblNewLabel_1.setBounds(215, 58, 1286, 743);
        panel.add(lblNewLabel_1);
    }

    // Method to get the current date and time with day and full month name
    private String getCurrentDateTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("EEEE, MMMM dd, yyyy HH:mm:ss");
        return formatter.format(new Date());
    }

	@Override
	public void actionPerformed(ActionEvent e) {
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
		else if(e.getSource() ==  Dashboardbtn)
		{
			dispose();
			new Dashboard();
		}
		else if(e.getSource() == Logoutbtn)
		{
			dispose();
		}
		else if(e.getSource() == btnServicesSales)
		{
			dispose();
			new ServiceSales();
		}
		else if(e.getSource() == btnProductSales)
		{
			dispose();
			new ProductSales();
		}
		
	}
}
