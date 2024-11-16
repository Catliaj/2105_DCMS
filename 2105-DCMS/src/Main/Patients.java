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

public class Patients extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel timeLabel;
    private JTable table;
    private JTable table_1;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Patients frame = new Patients();
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
    public Patients() {
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

        JPanel panel_2 = new JPanel();
        panel_2.setBackground(new Color(5, 59, 67));
        panel_2.setBounds(227, 670, 1059, 43);
        panel.add(panel_2);
        panel_2.setLayout(null);

        // Add time label to panel_2
        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
        timeLabel.setForeground(Color.WHITE);
        timeLabel.setBounds(675, 10, 374, 30);
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
        
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(5, 59, 67));
        panel_1.setBounds(460, 126, 585, 57);
        panel.add(panel_1);
        panel_1.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("PATIENT LISTS");
        lblNewLabel.setForeground(new Color(194, 192, 192));
        lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 25));
        lblNewLabel.setBounds(220, 10, 198, 34);
        panel_1.add(lblNewLabel);
                
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(349, 203, 813, 353);
        panel.add(scrollPane);

        scrollPane.setViewportView(table);
        
        table_1 = new JTable();
        table_1.setBackground(new Color(207, 205, 205));
        table_1.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        table_1.setModel(new DefaultTableModel(
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
        	},
        	new String[] {
        		"Patient ID", "First Name", "M.I", "Last Name"
        	}
        ));
        
        // Set row height and column widths
        table_1.setRowHeight(30); // Set to a larger value as needed
        table_1.getColumnModel().getColumn(0).setPreferredWidth(100); // Patient ID
        table_1.getColumnModel().getColumn(1).setPreferredWidth(150); // First Name
        table_1.getColumnModel().getColumn(2).setPreferredWidth(50);  // M.I
        table_1.getColumnModel().getColumn(3).setPreferredWidth(150); // Last Name

        
        scrollPane.setViewportView(table_1);
                        
        JButton btnNewButton = new JButton("ADD PATIENT");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnNewButton.setBackground(new Color(194, 192, 192));
        btnNewButton.setForeground(new Color(0, 0, 0));
        btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 20));
        btnNewButton.setBounds(488, 580, 217, 50);
        panel.add(btnNewButton);
                                
        JButton btnViewRecord = new JButton("VIEW RECORD");
        btnViewRecord.setForeground(Color.BLACK);
        btnViewRecord.setFont(new Font("Segoe UI", Font.BOLD, 20));
        btnViewRecord.setBackground(new Color(194, 192, 192));
        btnViewRecord.setBounds(814, 580, 217, 50);
        panel.add(btnViewRecord);
                                
        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\ARAVHEIYL FELICISIMO\\Downloads\\backG.png"));
        lblNewLabel_1.setBounds(10, 72, 1286, 743);
        panel.add(lblNewLabel_1);
    }

    // Method to get the current date and time with day and full month name
    private String getCurrentDateTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("EEEE, MMMM dd, yyyy HH:mm:ss");
        return formatter.format(new Date());
    }
}
