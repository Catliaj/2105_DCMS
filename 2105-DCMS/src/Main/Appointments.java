package Main;
import java.awt.EventQueue;
import java.text.SimpleDateFormat;
import java.util.Arrays;
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
import java.util.Calendar;
import backend.ApointmentForm_backend;
import javax.swing.border.BevelBorder;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;

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
    private JButton btnRefresh;
    private JTextField Searchfield;
    private JButton btnViewAppointment;

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
        panel_1.setBounds(460, 126, 585, 44);
        panel.add(panel_1);
        panel_1.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("SCHEDULED APPOINTMENTS");
        lblNewLabel.setForeground(new Color(194, 192, 192));
        lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 25));
        lblNewLabel.setBounds(128, 5, 388, 34);
        panel_1.add(lblNewLabel);
                
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(262, 265, 992, 349);
        panel.add(scrollPane);

        scrollPane.setViewportView(table);
       
        
        table_2 = new JTable();
        table_2.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        table_2.setBackground(new Color(207, 205, 205));
        table_2.setModel(new DefaultTableModel(
        	new Object[][] {},
        	new String[] {
        		"APPOINTMENT ID", "NAME", "DATE", "TIME", "SERVICE", "CONTACT NO. ", "EMAIL" ,"STATUS"
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
    


        
        table_2.setRowHeight(30);
        
        scrollPane.setViewportView(table_2);
        
        JLabel lblNewLabel_3 = new JLabel("New label");
        lblNewLabel_3.setBounds(294, 351, 45, 13);
        panel.add(lblNewLabel_3);
        
        btnRefresh = new JButton("REFRESH");
        btnRefresh.setForeground(Color.BLACK);
        btnRefresh.setFont(new Font("Segoe UI", Font.BOLD, 20));
        btnRefresh.setBackground(new Color(194, 192, 192));
        btnRefresh.setBounds(989, 642, 265, 50);
        btnRefresh.addActionListener(this);
        panel.add(btnRefresh);
        
        btnViewAppointment = new JButton("VIEW APPOINTMENT");
        btnViewAppointment.setForeground(Color.BLACK);
        btnViewAppointment.setFont(new Font("Segoe UI", Font.BOLD, 20));
        btnViewAppointment.setBackground(new Color(194, 192, 192));
        btnViewAppointment.setBounds(282, 642, 265, 50);
        btnViewAppointment.addActionListener(this);
        panel.add(btnViewAppointment);
        
        JPanel panel_2 = new JPanel();
        panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        panel_2.setBackground(new Color(194, 192, 192));
        panel_2.setBounds(680, 190, 256, 50);
        panel.add(panel_2);
        panel_2.setLayout(null);
        
        Searchfield = new JTextField();
        Searchfield.setBounds(53, 10, 193, 30);
        panel_2.add(Searchfield);
        Searchfield.addActionListener(this);
        Searchfield.setColumns(10);
        
        JLabel lblNewLabel_6 = new JLabel("");
        lblNewLabel_6.setBounds(4, 2, 81, 44);
        panel_2.add(lblNewLabel_6);
        lblNewLabel_6.setIcon(new ImageIcon(Appointments.class.getResource("/Resources/people.png")));
        
        JComboBox<String> SortcomboBox = new JComboBox<>(new String[]{"ID","Name", "Date"});

        SortcomboBox.setBackground(new Color(194, 192, 192));
        SortcomboBox.setFont(new Font("Segoe UI", Font.BOLD, 15));
        SortcomboBox.setBounds(1128, 246, 126, 20);
        SortcomboBox.addActionListener(e -> {
            String selected = (String) SortcomboBox.getSelectedItem();
            sortTable(selected);  // Trigger the sorting based on selected item
        });

        panel.add(SortcomboBox);
        
        JLabel lblNewLabel_7 = new JLabel("SEARCH:");
        lblNewLabel_7.setForeground(new Color(194, 192, 192));
        lblNewLabel_7.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lblNewLabel_7.setBounds(580, 195, 102, 36);
        panel.add(lblNewLabel_7);
        
        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon(Appointments.class.getResource("/Resources/Background (2).png")));
        lblNewLabel_1.setBounds(0, 71, 1286, 743);
        panel.add(lblNewLabel_1);
        JComboBox<String> monthComboBox = new JComboBox<>(new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"});
        JComboBox<Integer> yearComboBox = new JComboBox<>(new Integer[]{2023, 2024, 2025});
        int selectedMonth = monthComboBox.getSelectedIndex() + 1; // Convert to 1-based index for SQL
        int selectedYear = (int) yearComboBox.getSelectedItem();
        JButton filterByMonthButton = new JButton("Filter by Month");
        filterByMonthButton.addActionListener(e -> {
            filterAppointmentsByMonth(selectedMonth, selectedYear);
        });
        
         
         
         JPanel filterPanel = new JPanel();
         filterPanel.setBounds(262, 236, 400, 30);
         panel.add(filterPanel);
         filterPanel.add(new JLabel("Month:"));
         filterPanel.add(monthComboBox);
         filterPanel.add(new JLabel("Year:"));
         filterPanel.add(yearComboBox);
         filterPanel.add(filterByMonthButton);
         


        loadAppointments();
       
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
			dispose();
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
		else if(e.getSource() ==  btnViewAppointment)
		{	  
			 int selectedRow = table_2.getSelectedRow(); // Get selected row index
		        if (selectedRow != -1) {
		            // Fetch details from the table
		            String appointmentID = table_2.getValueAt(selectedRow, 0).toString();
		            String name = table_2.getValueAt(selectedRow, 1).toString();
		            String date = table_2.getValueAt(selectedRow, 2).toString();
		            String time = table_2.getValueAt(selectedRow, 3).toString();
		            String reason = table_2.getValueAt(selectedRow, 4).toString();
		            String phone = table_2.getValueAt(selectedRow, 5).toString();
		            String email = table_2.getValueAt(selectedRow, 6).toString();
		            String status = table_2.getValueAt(selectedRow, 7).toString();

		            // Pass data to AppointmentRecord
		            new AppointmentRecord(appointmentID, name, date, time, reason, phone, email, status);
		        } else {
		            JOptionPane.showMessageDialog(this, "Please select an appointment from the table.");
		        }
		    }

		 else if (e.getSource() == Searchfield) { // Trigger search on Enter key in the text field
		        String query = Searchfield.getText().trim();
		        if (!query.isEmpty()) {
		            searchAppointments(query); // Perform the search
		        } else {
		            JOptionPane.showMessageDialog(this, "Please enter a search term.");
		        }
		    }
		
	}
	private void loadAppointments() {
	    DefaultTableModel model = (DefaultTableModel) table_2.getModel();
	    model.setRowCount(0); // Clear existing table data

	    // Backend call to fetch all appointments
	    ApointmentForm_backend backend = new ApointmentForm_backend();
	    List<String[]> appointments = backend.getAppointment(); // Backend method to fetch all appointments

	    // Populate the table with fetched data
	    for (String[] appointment : appointments) {
	        model.addRow(appointment);
	    }
	}

	private void loadAppointments(String keyword, String sortBy, String sortOrder) {
	    DefaultTableModel model = (DefaultTableModel) table_2.getModel();
	    model.setRowCount(0); // Clear existing data

	    ApointmentForm_backend backend = new ApointmentForm_backend();
	    List<String[]> appointments = backend.searchAppointments(keyword, sortBy, sortOrder);

	    for (String[] appointment : appointments) {
	        model.addRow(appointment);
	    }

	    if (appointments.isEmpty()) {
	        JOptionPane.showMessageDialog(this, "No appointments found for the given search and sort criteria.");
	    }
	}



	
	private void sortTable(String criterion) {
	    DefaultTableModel model = (DefaultTableModel) table_2.getModel();
	    model.setRowCount(0); // Clear the table

	    // Map sorting criterion to database column names
	    String sortBy = switch (criterion) {
	        case "Name" -> "Name";
	        case "AppointmentDate" -> "AppointmentDate";
	        case "ID"  -> "AppointmentID"; 
	        case "Reason" -> "Service";
	        case "Status" -> "Status";
	        default -> "Date"; // Default to Date
	    };

	    // Backend call to fetch sorted data
	    ApointmentForm_backend backend = new ApointmentForm_backend();
	    List<String[]> sortedData = backend.getAppointmentsSortedBy(sortBy);

	    // Populate the table with sorted data
	    for (String[] row : sortedData) {
	        model.addRow(row);
	    }
	}


	   
	private void searchAppointments(String query) {
	    DefaultTableModel model = (DefaultTableModel) table_2.getModel();
	    model.setRowCount(0); // Clear table rows

	    ApointmentForm_backend backend = new ApointmentForm_backend();
	    List<String[]> searchResults = backend.searchAppointments(query);

	    if (searchResults.isEmpty()) {
	        JOptionPane.showMessageDialog(this, "No results found for: " + query);
	        return;
	    }

	    for (String[] row : searchResults) {
	        model.addRow(row);
	    }
	}

	private void filterAppointmentsByMonth(int month, int year) {
	    DefaultTableModel model = (DefaultTableModel) table_2.getModel();
	    model.setRowCount(0); // Clear existing data

	    ApointmentForm_backend backend = new ApointmentForm_backend();
	    List<String[]> appointments = backend.getAppointmentsByMonth(month, year);

	    for (String[] appointment : appointments) {
	        model.addRow(appointment);
	    }

	    if (appointments.isEmpty()) {
	        JOptionPane.showMessageDialog(this, "No appointments found for the selected month and year.");
	    }
	}

	


}
