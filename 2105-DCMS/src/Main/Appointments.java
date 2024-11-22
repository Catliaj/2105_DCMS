package Main;
import java.awt.EventQueue;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.Timer;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import backend.ApointmentForm_backend;

public class Appointments extends JFrame implements ActionListener{

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;
    private JTable table_1;
    private JTable table_2;
    private JButton Dashboardbtn;
    private JButton Patientsbtn;
    private JButton Appointmentsbtn;
    private JButton Productbtn;
    private JButton Billingbtn;
    private JButton Logoutbtn;
    private JButton ProductSalesbtn;
    private JButton btnBookAppointment;
    private JButton btnRefresh;

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
    	setResizable(false);
    	setVisible(true);
        setTitle("DASHBOARD");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(150, 50, 1300, 750);
        setLocationRelativeTo(null);
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
                lblNewLabel_2.setBounds(408, 28, 406, 50);
                HeaderPanel.add(lblNewLabel_2);
                lblNewLabel_2.setIcon(new ImageIcon(Appointments.class.getResource("/Resources/ClinicLogo.png")));
                
                JLabel lblNewLabel_4 = new JLabel("");
                lblNewLabel_4.setIcon(new ImageIcon(Appointments.class.getResource("/Resources/HeaderPanelBG.png")));
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
        Appointmentsbtn.setBackground( Color.white);
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
        
        JLabel lblNewLabel_5 = new JLabel("");
        lblNewLabel_5.setIcon(new ImageIcon(Appointments.class.getResource("/Resources/SidePanelBG.png")));
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
        	new Object[][] {},
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
                        
        btnBookAppointment = new JButton("BOOK NEW APPOINTMENT");
        btnBookAppointment.addActionListener(this);
        btnBookAppointment.setBackground(new Color(194, 192, 192));
        btnBookAppointment.setForeground(new Color(0, 0, 0));
        btnBookAppointment.setFont(new Font("Segoe UI", Font.BOLD, 20));
        btnBookAppointment.setBounds(350, 628, 359, 50);
        panel.add(btnBookAppointment);
        
        JLabel lblNewLabel_3 = new JLabel("New label");
        lblNewLabel_3.setBounds(294, 351, 45, 13);
        panel.add(lblNewLabel_3);
        
        btnRefresh = new JButton("REFRESH");
        btnRefresh.setForeground(Color.BLACK);
        btnRefresh.setFont(new Font("Segoe UI", Font.BOLD, 20));
        btnRefresh.setBackground(new Color(194, 192, 192));
        btnRefresh.setBounds(809, 628, 359, 50);
        panel.add(btnRefresh);
        
        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon(Appointments.class.getResource("/Resources/Background (2).png")));
        lblNewLabel_1.setBounds(10, 72, 1286, 743);
        panel.add(lblNewLabel_1);
        loadAppointmentData();
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
		else if(e.getSource() == Dashboardbtn )
		{
			dispose();
			new Dashboard();
		}
		else if(e.getSource() == Productbtn)
		{
			new ProductAdmin();
		}
		else if(e.getSource() == Billingbtn)
		{
			new POS();
		}
		else if(e.getSource() == ProductSalesbtn )
		{
			dispose();
			new SALES();
		}
		else if(e.getSource() == Logoutbtn)
		{
			
			dispose();
			new LogInPage();
		}
		else if(e.getSource() == btnBookAppointment)
		{
			new AppointmentForm();
		}
		else if (e.getSource() == btnRefresh) {
			dispose();
			new Appointments();
		}
		else if(e.getSource() == Logoutbtn)
		{
		    int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit this page?", "Logout", JOptionPane.YES_NO_OPTION);
		    if (confirm == JOptionPane.YES_OPTION) {
		    	dispose();
		    	new LogInPage();
		    }
		}

		
	}
	
	private void loadAppointmentData() 
	{
		
	    DefaultTableModel model = (DefaultTableModel) table_2.getModel();
	    model.setRowCount(0); // Clear existing data
	   
	    ApointmentForm_backend backend = new ApointmentForm_backend();
	    List<String[]> appointmentData = backend.getAppointment();
	    // Check if there is any data to display
	    if (appointmentData.isEmpty()) {
	        JOptionPane.showMessageDialog(this, "No patient data found.");
	        return;
	    }
	    // Loop through the list and add rows to the table
	    for (String[] row : appointmentData) {
	        model.addRow(row);
	    }
	}

}
