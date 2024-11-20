package Main;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class UpdatePatient extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField FirstNameTxtField;
    private JTextField LastNameTxtField;
    private JTextField AgeTxtField;
    private JTextField ContactTxtField;
    private JTextField EmailTxtField;
    private JTextField AddressTxtField;
    private JTextField MITxtField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UpdatePatient frame = new UpdatePatient();
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
    public UpdatePatient() {
        setBackground(new Color(128, 128, 128));
        setForeground(new Color(0, 0, 0));
        setTitle("UPDATE PATIENT");
        setFont(new Font("Arial", Font.BOLD, 12));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 671, 556);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(194, 192, 192));
        panel.setBounds(0, 0, 657, 519);
        contentPane.add(panel);
        panel.setLayout(null);
        
        JLabel UPRLabel = new JLabel("UPDATE PATIENT RECORD");
        UPRLabel.setForeground(new Color(0, 0, 0));
        UPRLabel.setFont(new Font("Segoe UI", Font.BOLD, 30));
        UPRLabel.setBounds(135, 28, 394, 49);
        panel.add(UPRLabel);
        
        FirstNameTxtField = new JTextField();
        FirstNameTxtField.setBounds(48, 120, 195, 29);
        panel.add(FirstNameTxtField);
        FirstNameTxtField.setColumns(10);
        
        LastNameTxtField = new JTextField();
        LastNameTxtField.setColumns(10);
        LastNameTxtField.setBounds(411, 120, 195, 29);
        panel.add(LastNameTxtField);
        
        AgeTxtField = new JTextField();
        AgeTxtField.setColumns(10);
        AgeTxtField.setBounds(48, 203, 57, 29);
        panel.add(AgeTxtField);
        
        ContactTxtField = new JTextField();
        ContactTxtField.setColumns(10);
        ContactTxtField.setBounds(411, 203, 195, 29);
        panel.add(ContactTxtField);
        
        JLabel AgeLabel = new JLabel("AGE");
        AgeLabel.setFont(new Font("Segoe UI", Font.BOLD, 15));
        AgeLabel.setBounds(48, 180, 97, 13);
        panel.add(AgeLabel);
        
        JLabel LastNameLabel = new JLabel("LAST NAME");
        LastNameLabel.setFont(new Font("Segoe UI", Font.BOLD, 15));
        LastNameLabel.setBounds(411, 99, 128, 13);
        panel.add(LastNameLabel);
        
        JLabel FirstNameLabel = new JLabel("FIRST NAME");
        FirstNameLabel.setFont(new Font("Segoe UI", Font.BOLD, 15));
        FirstNameLabel.setBounds(49, 99, 97, 13);
        panel.add(FirstNameLabel);
        
        JLabel GenderLabel = new JLabel("GENDER");
        GenderLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        GenderLabel.setBounds(167, 181, 97, 13);
        panel.add(GenderLabel);
        
        JLabel ContactLabel = new JLabel("CONTACT NO.");
        ContactLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        ContactLabel.setBounds(429, 181, 108, 13);
        panel.add(ContactLabel);
        
        JDateChooser dateChooser = new JDateChooser();
        dateChooser.getCalendarButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        dateChooser.setBounds(167, 277, 314, 29);
        panel.add(dateChooser);
        
        EmailTxtField = new JTextField();
        EmailTxtField.setColumns(10);
        EmailTxtField.setBounds(92, 339, 480, 29);
        panel.add(EmailTxtField);
        
        AddressTxtField = new JTextField();
        AddressTxtField.setColumns(10);
        AddressTxtField.setBounds(92, 409, 480, 29);
        panel.add(AddressTxtField);
        
        JLabel BirthLabel = new JLabel("DATE OF BIRTH");
        BirthLabel.setFont(new Font("Segoe UI", Font.BOLD, 15));
        BirthLabel.setBounds(167, 254, 128, 13);
        panel.add(BirthLabel);
        
        JLabel EmailLabel = new JLabel("EMAIL");
        EmailLabel.setFont(new Font("Segoe UI", Font.BOLD, 15));
        EmailLabel.setBounds(92, 316, 128, 13);
        panel.add(EmailLabel);
        
        JLabel AddressLabel = new JLabel("ADDRESS");
        AddressLabel.setFont(new Font("Segoe UI", Font.BOLD, 15));
        AddressLabel.setBounds(92, 386, 128, 13);
        panel.add(AddressLabel);
        
        JLabel MILabel = new JLabel("M.I");
        MILabel.setFont(new Font("Segoe UI", Font.BOLD, 15));
        MILabel.setBounds(296, 99, 34, 13);
        panel.add(MILabel);
        
        MITxtField = new JTextField();
        MITxtField.setColumns(10);
        MITxtField.setBounds(295, 120, 49, 29);
        panel.add(MITxtField);
        
        JRadioButton MaleRdBtn = new JRadioButton("MALE");
        MaleRdBtn.setFont(new Font("Segoe UI", Font.BOLD, 15));
        MaleRdBtn.setBounds(167, 200, 79, 29);
        panel.add(MaleRdBtn);
        
        JRadioButton FemaleRdBtn = new JRadioButton("FEMALE");
        FemaleRdBtn.setFont(new Font("Segoe UI", Font.BOLD, 15));
        FemaleRdBtn.setBounds(264, 200, 97, 29);
        panel.add(FemaleRdBtn);
        
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(MaleRdBtn);
        genderGroup.add(FemaleRdBtn);
        
        JButton CancelBtn = new JButton("CANCEL");
        CancelBtn.setForeground(new Color(194, 192, 192));
        CancelBtn.setBackground(new Color(5, 59, 67));
        CancelBtn.setFont(new Font("Segoe UI", Font.BOLD, 20));
        CancelBtn.setBounds(135, 455, 154, 38);
        panel.add(CancelBtn);
        
        JButton SaveBtn = new JButton("SAVE");
        SaveBtn.setForeground(new Color(194, 192, 192));
        SaveBtn.setBackground(new Color(5, 59, 67));
        SaveBtn.setFont(new Font("Segoe UI", Font.BOLD, 20));
        SaveBtn.setBounds(361, 455, 154, 38);
        panel.add(SaveBtn);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(NewPatient.class.getResource("/Resources/PopupBackg.png")));
        lblNewLabel.setBounds(0, 0, 657, 519);
        panel.add(lblNewLabel);
    }
}
