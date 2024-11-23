package Main;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import backend.POS_backend;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.RowFilter;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.TableRowSorter;

public class ProductSales extends JFrame implements ActionListener{

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;
    private JButton btnBack;
    private JButton btnRefresh;
    private JComboBox<String> comboBoxFilter;
    private JComboBox<String> comboBoxSort;
    private TableRowSorter<DefaultTableModel> sorter;
    private JButton btnGenerateReport;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ProductSales frame = new ProductSales();
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
            new Object[][] {
                {null, null, null, null, null, null},
            },
            new String[] {
                "PRODUCT ID", "PRODUCT NAME", "DATE", "QUANTITY", "PRICE", "TOTAL"
            }
        ));
        
        table.setRowHeight(30);
        scrollPane.setViewportView(table);
        
        JLabel lblNewLabel = new JLabel("PRODUCT SALES");
        lblNewLabel.setForeground(new Color(194, 192, 192));
        lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 40));
        lblNewLabel.setBounds(426, 10, 328, 49);
        panel.add(lblNewLabel);
        
        btnBack= new JButton("BACK");
        btnBack.addActionListener(this);
        btnBack.setBackground(new Color(194, 192, 192));
        btnBack.setFont(new Font("Segoe UI", Font.BOLD, 20));
        btnBack.setBounds(883, 555, 175, 45);
        panel.add(btnBack);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(5, 59, 67));
        panel_1.setBounds(77, 96, 981, 431);
        panel.add(panel_1);
        
        btnRefresh = new JButton("REFRESH");
        btnRefresh.addActionListener(this);
        btnRefresh.setFont(new Font("Segoe UI", Font.BOLD, 20));
        btnRefresh.setBackground(new Color(194, 192, 192));
        btnRefresh.setBounds(519, 555, 175, 45);
        panel.add(btnRefresh);

        // Filter ComboBox
        comboBoxFilter = new JComboBox<>(new String[] {"All", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"});
        comboBoxFilter.setBounds(746, 67, 150, 30);
        comboBoxFilter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                filterTableByMonth(comboBoxFilter.getSelectedItem().toString());
            }
        });
        panel.add(comboBoxFilter);

        // Sort ComboBox
        comboBoxSort = new JComboBox<>(new String[] {"Sort By", "Date Ascending", "Date Descending"});
        comboBoxSort.setBounds(906, 67, 150, 30);
        comboBoxSort.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selection = comboBoxSort.getSelectedItem().toString();
                if (selection.equals("Date Ascending")) {
                    sorter.setSortKeys(List.of(new RowSorter.SortKey(2, SortOrder.ASCENDING)));
                } else if (selection.equals("Date Descending")) {
                    sorter.setSortKeys(List.of(new RowSorter.SortKey(2, SortOrder.DESCENDING)));
                }
            }
        });
        panel.add(comboBoxSort);
        
        btnGenerateReport = new JButton("GENERATE REPORT");
        btnGenerateReport.setFont(new Font("Segoe UI", Font.BOLD, 20));
        btnGenerateReport.setBackground(new Color(194, 192, 192));
        btnGenerateReport.setBounds(77, 555, 271, 45);
        panel.add(btnGenerateReport);
        
                JLabel lblNewLabel_1 = new JLabel("");
                lblNewLabel_1.setIcon(new ImageIcon(ProductSales.class.getResource("/Resources/Background (2).png")));
                lblNewLabel_1.setBounds(0, 0, 1136, 615);
                panel.add(lblNewLabel_1);

        loadProductBillData();
        addSortingCapability();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnBack) {
            dispose();
            new SALES();
        } else if (e.getSource() == btnRefresh) {
            dispose();
            new ProductSales();
        }
    }

    private void loadProductBillData() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); // Clear existing data
       
        POS_backend backend = new POS_backend();
        List<String[]> ProductBillData = backend.getProductBillData();

        if (ProductBillData.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No product data found.");
            return;
        }

        for (String[] row : ProductBillData) {
            model.addRow(row);
        }
    }

    private void filterTableByMonth(String month) {
        if (sorter == null) return;
        if (month.equals("All")) {
            sorter.setRowFilter(null); // No filter
        } else {
            sorter.setRowFilter(RowFilter.regexFilter(month, 2)); // Filter by "DATE" column
        }
    }

    private void addSortingCapability() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        sorter = new TableRowSorter<>(model);
        table.setRowSorter(sorter);
    }
}
