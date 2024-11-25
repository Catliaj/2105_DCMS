package Main;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

import backend.POS_backend;

public class ServiceSales extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;
    private JButton btnBack;
    private JButton btnRefresh;
    private JComboBox<String> sortComboBox;
    private JComboBox<String> monthComboBox; // For month filter
    private TableRowSorter<DefaultTableModel> sorter;
    private JButton btnGenerateReport;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                ServiceSales frame = new ServiceSales();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public ServiceSales() {
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1150, 652);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setLocationRelativeTo(null);

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(5, 59, 67));
        panel.setBounds(0, 0, 1136, 615);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("SERVICE SALES");
        lblNewLabel.setForeground(new Color(194, 192, 192));
        lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 40));
        lblNewLabel.setBounds(426, 10, 328, 49);
        panel.add(lblNewLabel);

        btnBack = new JButton("BACK");
        btnBack.addActionListener(this);
        btnBack.setBackground(new Color(194, 192, 192));
        btnBack.setFont(new Font("Segoe UI", Font.BOLD, 20));
        btnBack.setBounds(883, 546, 175, 45);
        panel.add(btnBack);

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(5, 59, 67));
        panel_1.setBounds(77, 100, 981, 431);
        panel.add(panel_1);
        panel_1.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 10, 961, 411);
        panel_1.add(scrollPane);

        table = new JTable();
        table.setModel(new DefaultTableModel(
                new Object[][] {},
                new String[] { "SERVICE ID", "CUSTOMER NAME", "DATE", "SERVICE", "PRICE" }
        ));
        table.getColumnModel().getColumn(0).setPreferredWidth(30);
        table.getColumnModel().getColumn(1).setPreferredWidth(150);
        table.getColumnModel().getColumn(2).setPreferredWidth(50);
        table.getColumnModel().getColumn(3).setPreferredWidth(50);
        table.getColumnModel().getColumn(4).setPreferredWidth(50);
        table.setRowHeight(30);

        scrollPane.setViewportView(table);

        sorter = new TableRowSorter<>((DefaultTableModel) table.getModel());
        table.setRowSorter(sorter);

        btnRefresh = new JButton("REFRESH");
        btnRefresh.addActionListener(this);
        btnRefresh.setFont(new Font("Segoe UI", Font.BOLD, 20));
        btnRefresh.setBackground(new Color(194, 192, 192));
        btnRefresh.setBounds(497, 546, 175, 45);
        panel.add(btnRefresh);

        // Sort ComboBox
        sortComboBox = new JComboBox<>(new String[] { "SERVICE ID", "CUSTOMER NAME", "DATE", "SERVICE", "PRICE" });
        sortComboBox.setFont(new Font("Segoe UI", Font.BOLD, 15));
        sortComboBox.setBounds(908, 75, 150, 25);
        sortComboBox.addActionListener(e -> sortTable());
        panel.add(sortComboBox);

        // Month ComboBox
        monthComboBox = new JComboBox<>(new String[] {
            "All", "January", "February", "March", "April", "May", "June", 
            "July", "August", "September", "October", "November", "December"
        });
        monthComboBox.setFont(new Font("Segoe UI", Font.BOLD, 15));
        monthComboBox.setBounds(730, 75, 150, 25);
        monthComboBox.addActionListener(e -> filterTable());
        panel.add(monthComboBox);

        btnGenerateReport = new JButton("GENERATE REPORT");
        btnGenerateReport.setFont(new Font("Segoe UI", Font.BOLD, 20));
        btnGenerateReport.setBackground(new Color(194, 192, 192));
        btnGenerateReport.setBounds(75, 546, 272, 45);
        panel.add(btnGenerateReport);

        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon(ServiceSales.class.getResource("/Resources/Background (2).png")));
        lblNewLabel_1.setBounds(0, 0, 1136, 615);
        panel.add(lblNewLabel_1);

        loadServiceBillData();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnBack) {
            dispose();
            new SALES();
        } else if (e.getSource() == btnRefresh) {
            dispose();
            new ServiceSales();
        }
    }

    private void loadServiceBillData() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        POS_backend backend = new POS_backend();
        List<String[]> serviceData = backend.getServiceBillData();

        if (serviceData.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No service data found.");
            return;
        }

        for (String[] row : serviceData) {
            model.addRow(row);
        }
    }

    private void filterTable() {
        String selectedMonth = (String) monthComboBox.getSelectedItem();

        RowFilter<DefaultTableModel, Integer> monthFilter = null;

        // Create the month filter if a specific month is selected
        if (selectedMonth != null && !"All".equals(selectedMonth)) {
            monthFilter = new RowFilter<DefaultTableModel, Integer>() {
                @Override
                public boolean include(Entry<? extends DefaultTableModel, ? extends Integer> entry) {
                    String date = entry.getStringValue(2); // Assuming the date column is at index 2
                    try {
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // Adjust to your date format
                        Date parsedDate = dateFormat.parse(date);
                        Calendar calendar = Calendar.getInstance();
                        calendar.setTime(parsedDate);
                        String rowMonth = calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH);
                        return rowMonth.equals(selectedMonth);
                    } catch (Exception e) {
                        e.printStackTrace();
                        return false; // Exclude invalid dates
                    }
                }
            };
        }

        // Reset the filters and apply the new filter
        if (monthFilter != null) {
            sorter.setRowFilter(monthFilter);
        } else {
            sorter.setRowFilter(null); // Show all rows if "All" is selected
        }
    }


    private void sortTable() {
        int columnIndex = sortComboBox.getSelectedIndex();
        sorter.toggleSortOrder(columnIndex); // Sort based on selected column
        filterTable(); // Reapply the filter after sorting
    }
}
