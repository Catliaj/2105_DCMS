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
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import backend.newPatient_Backend;
import javax.swing.border.BevelBorder;
public class Patients extends JFrame implements ActionListener{

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel timeLabel;
    private JTable table;
    private JTable table_1;
    private JButton Dashboardbtn;
    private JButton Patientsbtn;
    private JButton Appointmentsbtn;
    private JButton Productbtn;
    private JButton Billingbtn;
    private JButton Logoutbtn;
    private JButton ProductSalesbtn;
    private JButton btnAddPatient;
    private JButton btnViewRecord;
    private JButton btnRefresh;
    private JComboBox<String> sortComboBox;
    private JPanel panel_4;
    private JTextField textField;
    private JLabel SearchIDlbl;
    private JLabel lblNewLabel_6;
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
        HeaderPanel.setBounds(0, 0, 1286, 100);
        panel.add(HeaderPanel);
        HeaderPanel.setLayout(null);
        
                JLabel lblNewLabel_2 = new JLabel("");
                lblNewLabel_2.setBounds(408, 28, 406, 50);
                HeaderPanel.add(lblNewLabel_2);
                lblNewLabel_2.setIcon(new ImageIcon(Patients.class.getResource("/Resources/ClinicLogo.png")));
                
                JLabel lblNewLabel_4 = new JLabel("");
                lblNewLabel_4.setIcon(new ImageIcon(Patients.class.getResource("/Resources/HeaderPanelBG.png")));
                lblNewLabel_4.setBounds(0, 0, 1314, 97);
                HeaderPanel.add(lblNewLabel_4);

        JPanel SidePanel = new JPanel();
        SidePanel.setBackground(new Color(5, 59, 67));
        SidePanel.setBounds(0, 117, 229, 596);
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
        Patientsbtn.setBackground(Color.white);
        Patientsbtn.setBounds(0, 145, 228, 57);
        SidePanel.add(Patientsbtn);

        Appointmentsbtn = new JButton("APPOINTMENTS");
        Appointmentsbtn.setBackground(new Color(194, 192, 192));
        Appointmentsbtn.setFont(new Font("Segoe UI", Font.BOLD, 25));
        Appointmentsbtn.setBounds(0, 205, 228, 57);
        Appointmentsbtn.addActionListener(this);
        SidePanel.add(Appointmentsbtn);

        sortComboBox = new JComboBox<>(new String[]{"SORT BY", "PATIENT ID", "FIRST NAME", "LAST NAME"});
        sortComboBox.setBackground(new Color(194, 192, 192));
        sortComboBox.setFont(new Font("Segoe UI", Font.BOLD, 15));
        sortComboBox.setBounds(1035, 237, 126, 20); // Adjust position and size as needed
        panel.add(sortComboBox);

        // Add an action listener to handle sorting
        sortComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedSort = sortComboBox.getSelectedItem().toString();
                if (!selectedSort.equals("Sort By")) {
                    loadPatientData(selectedSort);
                }
            }
        });

        
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
        lblNewLabel_5.setIcon(new ImageIcon(Patients.class.getResource("/Resources/SidePanelBG.png")));
        lblNewLabel_5.setBounds(0, 0, 228, 587);
        SidePanel.add(lblNewLabel_5);

        JPanel panel_3 = new JPanel();
        panel_3.setBackground(new Color(194, 192, 192));
        panel_3.setBounds(0, 96, 1296, 20);
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
        timeLabel.setBounds(676, 10, 481, 30);
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
        panel_1.setBounds(456, 110, 585, 43);
        panel.add(panel_1);
        panel_1.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("PATIENT LISTS");
        lblNewLabel.setForeground(new Color(194, 192, 192));
        lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 25));
        lblNewLabel.setBounds(220, 4, 198, 34);
        panel_1.add(lblNewLabel);
                
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(348, 255, 813, 335);
        panel.add(scrollPane);

        scrollPane.setViewportView(table_1);
        
        table_1 = new JTable();
        table_1.setBackground(new Color(207, 205, 205));
        table_1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        table_1.setModel(new DefaultTableModel(
        	new Object[][] {},
        	new String[] {
        		"PatientID", "First Name", "M.I", "Last Name"
        	}
        ));
        
        // Set row height and column widths
        table_1.setRowHeight(30); // Set to a larger value as needed
        table_1.getColumnModel().getColumn(0).setPreferredWidth(100); // Patient ID
        table_1.getColumnModel().getColumn(1).setPreferredWidth(150); // First Name
        table_1.getColumnModel().getColumn(2).setPreferredWidth(50);  // M.I
        table_1.getColumnModel().getColumn(3).setPreferredWidth(150); // Last Name

        
        scrollPane.setViewportView(table_1);
                        
        btnAddPatient = new JButton("ADD PATIENT");
        btnAddPatient.addActionListener(this);
        btnAddPatient.setBackground(new Color(194, 192, 192));
        btnAddPatient.setForeground(new Color(0, 0, 0));
        btnAddPatient.setFont(new Font("Segoe UI", Font.BOLD, 20));
        btnAddPatient.setBounds(285, 610, 217, 50);
        panel.add(btnAddPatient);
                                
        btnViewRecord = new JButton("VIEW RECORD");
        btnViewRecord.setForeground(Color.BLACK);
        btnViewRecord.setFont(new Font("Segoe UI", Font.BOLD, 20));
        btnViewRecord.setBackground(new Color(194, 192, 192));
        btnViewRecord.setBounds(643, 610, 217, 50);
        btnViewRecord.addActionListener(this);
        panel.add(btnViewRecord);
        
        btnRefresh = new JButton("REFRESH");
        btnRefresh.setForeground(Color.BLACK);
        btnRefresh.setFont(new Font("Segoe UI", Font.BOLD, 20));
        btnRefresh.setBackground(new Color(194, 192, 192));
        btnRefresh.setBounds(1005, 610, 217, 50);
        btnRefresh.addActionListener(this);
        panel.add(btnRefresh);
        
        panel_4 = new JPanel();
        panel_4.setBackground(new Color(194, 192, 192));
        panel_4.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        panel_4.setBounds(666, 179, 238, 50);
        panel.add(panel_4);
        panel_4.setLayout(null);
        
        textField = new JTextField();
        textField.setBounds(53, 9, 173, 32);
        panel_4.add(textField);
        textField.setColumns(10);
        
        lblNewLabel_6 = new JLabel("");
        lblNewLabel_6.setBounds(6, 0, 59, 50);
        panel_4.add(lblNewLabel_6);
        lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\ARAVHEIYL FELICISIMO\\Downloads\\people (1).png"));
        
        SearchIDlbl = new JLabel("SEARCH: ");
        SearchIDlbl.setForeground(new Color(194, 192, 192));
        SearchIDlbl.setFont(new Font("Segoe UI", Font.BOLD, 20));
        SearchIDlbl.setBounds(568, 190, 117, 30);
        panel.add(SearchIDlbl);
        
        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon(Patients.class.getResource("/Resources/Background (2).png")));
        lblNewLabel_1.setBounds(10, 72, 1286, 743);
        panel.add(lblNewLabel_1);
        loadPatientData();
        
        btnViewRecord.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table_1.getSelectedRow();
                if (selectedRow != -1) { // Ensure a row is selected
                    String patientID = table_1.getValueAt(selectedRow, 0).toString();
                    new PatientRecord(patientID); // Pass patient ID to PatientRecord
                } else {
                    JOptionPane.showMessageDialog(null, "Please select a patient from the list.");
                }
            }
        });

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
		if(e.getSource() == Dashboardbtn)
		{
			dispose();
			new Dashboard();
		}
		else if(e.getSource() == Appointmentsbtn)
		{
			dispose();
			new Appointments();
		}
		else if(e.getSource() == Productbtn)
		{
			new ProductAdmin();
		}
		else if(e.getSource() == ProductSalesbtn )
		{
			dispose();
			new SALES();
		}
		else if(e.getSource() == btnAddPatient)
		{
			new NewPatient();
		}
		else if(e.getSource() == Billingbtn)
		{
			dispose();
			new POS();
		}
		else if (e.getSource() == btnRefresh) {
			dispose();
			new Patients();
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
	private void loadPatientData(String sortBy) {
	    DefaultTableModel model = (DefaultTableModel) table_1.getModel();
	    model.setRowCount(0); // Clear existing data

	    newPatient_Backend patientBackend = new newPatient_Backend();
	    List<String[]> patientData = patientBackend.getPatientData(); // Fetch patient data

	    // Sort the data based on the selected criteria
	    if (sortBy.equals("PatientID")) {
	        patientData.sort((a, b) -> {
	            try {
	                int id1 = Integer.parseInt(a[0]);
	                int id2 = Integer.parseInt(b[0]);
	                return Integer.compare(id1, id2);
	            } catch (NumberFormatException e) {
	                return a[0].compareTo(b[0]); // Fallback to string comparison
	            }
	        });
	    }
	    else if (sortBy.equals("First Name")) {
	        patientData.sort((a, b) -> a[1].compareToIgnoreCase(b[1])); // Sort by First Name
	    } else if (sortBy.equals("Last Name")) {
	        patientData.sort((a, b) -> a[3].compareToIgnoreCase(b[3])); // Sort by Last Name
	    }

	    // Loop through the sorted list and add rows to the table
	    for (String[] row : patientData) {
	        model.addRow(row);
	    }
	}

	// Overload to load data without sorting (default)
	private void loadPatientData() {
	    loadPatientData("PatientID"); // Default sorting by PatientID
	}

	
	
}