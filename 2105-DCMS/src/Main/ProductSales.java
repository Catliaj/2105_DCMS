package Main;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.*;

import backend.POS_backend;

public class ProductSales extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;
    private JButton btnBack;
    private JButton btnRefresh;
    private JComboBox<String> comboBoxFilter;
    private JComboBox<String> comboBoxSort;
    private JComboBox<String> comboBoxYear;
    private TableRowSorter<DefaultTableModel> sorter;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                ProductSales frame = new ProductSales();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public ProductSales() {
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

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(88, 110, 959, 406);
        panel.add(scrollPane);

        table = new JTable();
        table.setBackground(new Color(218, 216, 216));
        table.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        table.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{"PRODUCT ID", "PRODUCT NAME", "DATE", "QUANTITY", "PRICE", "TOTAL"}
        ));
        table.setRowHeight(30);
        scrollPane.setViewportView(table);

        JLabel lblNewLabel = new JLabel("PRODUCT SALES");
        lblNewLabel.setForeground(new Color(194, 192, 192));
        lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 40));
        lblNewLabel.setBounds(426, 10, 328, 49);
        panel.add(lblNewLabel);

        btnBack = new JButton("BACK");
        btnBack.addActionListener(this);
        btnBack.setBackground(new Color(194, 192, 192));
        btnBack.setFont(new Font("Segoe UI", Font.BOLD, 20));
        btnBack.setBounds(883, 555, 175, 45);
        panel.add(btnBack);

        btnRefresh = new JButton("REFRESH");
        btnRefresh.addActionListener(this);
        btnRefresh.setFont(new Font("Segoe UI", Font.BOLD, 20));
        btnRefresh.setBackground(new Color(194, 192, 192));
        btnRefresh.setBounds(519, 555, 175, 45);
        panel.add(btnRefresh);

        comboBoxFilter = new JComboBox<>(new String[]{"All", "January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"});
        comboBoxFilter.setBounds(746, 67, 150, 30);
        comboBoxFilter.addActionListener(e -> applyFilters());
        panel.add(comboBoxFilter);

        comboBoxSort = new JComboBox<>(new String[]{"Sort By", "Date Ascending", "Date Descending"});
        comboBoxSort.setBounds(906, 67, 150, 30);
        comboBoxSort.addActionListener(e -> {
            String selection = (String) comboBoxSort.getSelectedItem();
            if ("Date Ascending".equals(selection)) {
                sorter.setSortKeys(List.of(new RowSorter.SortKey(2, SortOrder.ASCENDING)));
            } else if ("Date Descending".equals(selection)) {
                sorter.setSortKeys(List.of(new RowSorter.SortKey(2, SortOrder.DESCENDING)));
            }
        });
        panel.add(comboBoxSort);

        comboBoxYear = new JComboBox<>(new String[]{"All"});
        comboBoxYear.setBounds(586, 67, 150, 30);
        comboBoxYear.addActionListener(e -> applyFilters());
        panel.add(comboBoxYear);

        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon(ProductSales.class.getResource("/Resources/Background (2).png")));
        lblNewLabel_1.setBounds(0, 0, 1136, 615);
        panel.add(lblNewLabel_1);

        loadProductBillData();
        populateYearComboBox();
        addSortingCapability();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnBack) {
            dispose();
            new SALES();
        } else if (e.getSource() == btnRefresh) {
            dispose();
            new ProductSales();
        }
    }

    private void loadProductBillData() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        POS_backend backend = new POS_backend();
        List<String[]> productBillData = backend.getProductBillData();

        if (productBillData.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No product data found.");
            return;
        }

        for (String[] row : productBillData) {
            model.addRow(row);
        }
    }

    private void populateYearComboBox() {
        Set<String> years = new HashSet<>();
        DefaultTableModel model = (DefaultTableModel) table.getModel();

        for (int i = 0; i < model.getRowCount(); i++) {
            String date = (String) model.getValueAt(i, 2);
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

        List<String> sortedYears = new ArrayList<>(years);
        sortedYears.sort(Comparator.naturalOrder());

        for (String year : sortedYears) {
            comboBoxYear.addItem(year);
        }
    }

    private void applyFilters() {
        String selectedMonth = (String) comboBoxFilter.getSelectedItem();
        String selectedYear = (String) comboBoxYear.getSelectedItem();

        RowFilter<DefaultTableModel, Integer> combinedFilter = null;

        if ((selectedMonth != null && !"All".equals(selectedMonth)) ||
                (selectedYear != null && !"All".equals(selectedYear))) {
            combinedFilter = new RowFilter<DefaultTableModel, Integer>() {
                @Override
                public boolean include(Entry<? extends DefaultTableModel, ? extends Integer> entry) {
                    String date = entry.getStringValue(2);
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
                            int rowYear = calendar.get(Calendar.YEAR);
                            matchesYear = String.valueOf(rowYear).equals(selectedYear);
                        }

                        return matchesMonth && matchesYear;
                    } catch (Exception e) {
                        e.printStackTrace();
                        return false;
                    }
                }
            };
        }

        sorter.setRowFilter(combinedFilter);
    }

    private void addSortingCapability() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        sorter = new TableRowSorter<>(model);
        table.setRowSorter(sorter);
    }
}
