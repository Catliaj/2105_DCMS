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
    private JComboBox<String> yearComboBox; // For year filter
    private TableRowSorter<DefaultTableModel> sorter;

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

        // Year ComboBox
        yearComboBox = new JComboBox<>(new String[] { "All" });
        yearComboBox.setFont(new Font("Segoe UI", Font.BOLD, 15));
        yearComboBox.setBounds(550, 75, 150, 25);
        yearComboBox.addActionListener(e -> filterTable());
        panel.add(yearComboBox);

        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon(ServiceSales.class.getResource("/Resources/Background (2).png")));
        lblNewLabel_1.setBounds(0, 0, 1136, 615);
        panel.add(lblNewLabel_1);

        loadServiceBillData();
        loadYearsIntoComboBox();
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

    private void loadYearsIntoComboBox() {
        POS_backend backend = new POS_backend();
        List<String[]> serviceData = backend.getServiceBillData();
        Set<String> years = new HashSet<>();

        for (String[] row : serviceData) {
            String date = row[2]; // Assuming date is in the 3rd column (index 2)
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date parsedDate = dateFormat.parse(date);
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(parsedDate);
                years.add(String.valueOf(calendar.get(Calendar.YEAR)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // Clear existing items and add "All" followed by sorted years
        yearComboBox.removeAllItems();
        yearComboBox.addItem("All");
        years.stream().sorted().forEach(yearComboBox::addItem);
    }

    private void filterTable() {
        String selectedMonth = (String) monthComboBox.getSelectedItem();
        String selectedYear = (String) yearComboBox.getSelectedItem();

        RowFilter<DefaultTableModel, Integer> combinedFilter = null;

        if ((selectedMonth != null && !"All".equals(selectedMonth)) || (selectedYear != null && !"All".equals(selectedYear))) {
            combinedFilter = new RowFilter<DefaultTableModel, Integer>() {
                @Override
                public boolean include(Entry<? extends DefaultTableModel, ? extends Integer> entry) {
                    String date = entry.getStringValue(2); // Assuming the date column is at index 2
                    try {
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                        Date parsedDate = dateFormat.parse(date);
                        Calendar calendar = Calendar.getInstance();
                        calendar.setTime(parsedDate);

                        boolean matchesMonth = true;
                        boolean matchesYear = true;

                        if (selectedMonth != null && !"All".equals(selectedMonth)) {
                            String rowMonth = calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH);
                            matchesMonth = rowMonth.equals(selectedMonth);
                        }

                        if (selectedYear != null && !"All".equals(selectedYear)) {
                            matchesYear = String.valueOf(calendar.get(Calendar.YEAR)).equals(selectedYear);
                        }

                        return matchesMonth && matchesYear;
                    } catch (Exception e) {
                        e.printStackTrace();
                        return false; // Exclude invalid dates
                    }
                }
            };
        }

        sorter.setRowFilter(combinedFilter);
    }

    private void sortTable() {
        int columnIndex = sortComboBox.getSelectedIndex();
        sorter.toggleSortOrder(columnIndex); // Sort based on selected column
        filterTable(); // Reapply the filter after sorting
    }
}
