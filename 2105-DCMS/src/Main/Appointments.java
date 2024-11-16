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

public class Appointments extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;
    private JTable table_1;
    private JTable table_2;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Appointments frame = new Appointments();
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
    public Appointments() {
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
                lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\ARAVHEIYL FELICISIMO\\Downloads\\ClinicLogo.png"));
                
                JLabel lblNewLabel_4 = new JLabel("");
                lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\ARAVHEIYL FELICISIMO\\Downloads\\DCF DENTAL CLINIC Your Convenient, Accommodating, and Affordable Dental Partner. (2)\\HeaderPanelBG.png"));
                lblNewLabel_4.setBounds(0, 0, 1314, 107);
                HeaderPanel.add(lblNewLabel_4);

        JPanel SidePanel = new JPanel();
        SidePanel.setBackground(new Color(5, 59, 67));
        SidePanel.setBounds(0, 126, 229, 587);
        panel.add(SidePanel);
        SidePanel.setLayout(null);

        JButton Dashboardbtn = new JButton("DASHBOARD");
        Dashboardbtn.setBackground(new Color(194, 192, 192));
        Dashboardbtn.setFont(new Font("Segoe UI", Font.BOLD, 25));
        Dashboardbtn.setBounds(0, 85, 228, 57);
        SidePanel.add(Dashboardbtn);

        JButton Patientsbtn = new JButton("PATIENTS");
        Patientsbtn.setFont(new Font("Segoe UI", Font.BOLD, 25));
        Patientsbtn.setBackground(new Color(194, 192, 192));
        Patientsbtn.setBounds(0, 145, 228, 57);
        SidePanel.add(Patientsbtn);

        JButton Appointmentsbtn = new JButton("APPOINTMENTS");
        Appointmentsbtn.setBackground(new Color(194, 192, 192));
        Appointmentsbtn.setFont(new Font("Segoe UI", Font.BOLD, 25));
        Appointmentsbtn.setBounds(0, 205, 228, 57);
        SidePanel.add(Appointmentsbtn);

        JButton Productbtn = new JButton("PRODUCT");
        Productbtn.setFont(new Font("Segoe UI", Font.BOLD, 25));
        Productbtn.setBackground(new Color(194, 192, 192));
        Productbtn.setBounds(0, 265, 228, 57);
        SidePanel.add(Productbtn);

        JButton Billingbtn = new JButton("POS");
        Billingbtn.setBackground(new Color(194, 192, 192));
        Billingbtn.setFont(new Font("Segoe UI", Font.BOLD, 25));
        Billingbtn.setBounds(0, 386, 228, 57);
        SidePanel.add(Billingbtn);

        JButton Logoutbtn = new JButton("LOG OUT");
        Logoutbtn.setFont(new Font("Segoe UI", Font.BOLD, 25));
        Logoutbtn.setBackground(new Color(194, 192, 192));
        Logoutbtn.setBounds(0, 529, 228, 57);
        SidePanel.add(Logoutbtn);

        JButton ProductSalesbtn = new JButton("SALES");
        ProductSalesbtn.setFont(new Font("Segoe UI", Font.BOLD, 25));
        ProductSalesbtn.setBackground(new Color(194, 192, 192));
        ProductSalesbtn.setBounds(0, 325, 228, 57);
        SidePanel.add(ProductSalesbtn);
        
        JLabel lblNewLabel_5 = new JLabel("");
        lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\ARAVHEIYL FELICISIMO\\Downloads\\DCF DENTAL CLINIC Your Convenient, Accommodating, and Affordable Dental Partner. (2)\\SidePanelBG.png"));
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
        
        JLabel lblNewLabel = new JLabel("SCHEDULED APPOINTMENTS");
        lblNewLabel.setForeground(new Color(194, 192, 192));
        lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 25));
        lblNewLabel.setBounds(128, 10, 388, 34);
        panel_1.add(lblNewLabel);
                
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(262, 212, 992, 390);
        panel.add(scrollPane);

        scrollPane.setViewportView(table);
     

        
        scrollPane.setViewportView(table);
        
        table_2 = new JTable();
        table_2.setBackground(new Color(207, 205, 205));
        table_2.setModel(new DefaultTableModel(
        	new Object[][] {
        		{null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null},
        	},
        	new String[] {
        		"PATIENT ID", "NAME", "DATE", "TIME", "SERVICE", "CONTACT NO. ", "EMAIL", "PRICE", "STATUS"
        	}
        ));
        table_2.getColumnModel().getColumn(0).setPreferredWidth(70);
        table_2.getColumnModel().getColumn(1).setPreferredWidth(100);
        table_2.getColumnModel().getColumn(2).setPreferredWidth(100);
        table_2.getColumnModel().getColumn(3).setPreferredWidth(100);
        table_2.getColumnModel().getColumn(4).setPreferredWidth(100);
        table_2.getColumnModel().getColumn(5).setPreferredWidth(100);
        table_2.getColumnModel().getColumn(6).setPreferredWidth(100);
        table_2.getColumnModel().getColumn(7).setPreferredWidth(50);
        table_2.getColumnModel().getColumn(8).setPreferredWidth(100);
        
        table_2.setRowHeight(30);
        
        scrollPane.setViewportView(table_2);
                        
        JButton btnNewButton = new JButton("BOOK NEW APPOINTMENT");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnNewButton.setBackground(new Color(194, 192, 192));
        btnNewButton.setForeground(new Color(0, 0, 0));
        btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 20));
        btnNewButton.setBounds(561, 628, 442, 50);
        panel.add(btnNewButton);
                                
        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\ARAVHEIYL FELICISIMO\\Downloads\\backG.png"));
        lblNewLabel_1.setBounds(10, 72, 1286, 743);
        panel.add(lblNewLabel_1);
        
        JLabel lblNewLabel_3 = new JLabel("New label");
        lblNewLabel_3.setBounds(294, 351, 45, 13);
        panel.add(lblNewLabel_3);
    }

    // Method to get the current date and time with day and full month name
    private String getCurrentDateTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("EEEE, MMMM dd, yyyy HH:mm:ss");
        return formatter.format(new Date());
    }
}
