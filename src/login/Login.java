package login;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import utils.MyIcon;

import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.awt.Cursor;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

public class Login extends JFrame {

    private JPanel contentPane;
    private JLabel txtGymManagementSystem;
    private JTextField textField;
    private JPasswordField textField_1;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Login frame = new Login();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Login() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 430);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        panel.setBackground(new Color(0, 0, 255));
        panel.setBounds(0, 0, 386, 69);
        contentPane.add(panel);
        panel.setLayout(null);

        txtGymManagementSystem = new JLabel();
        txtGymManagementSystem.setForeground(new Color(255, 255, 255));
        txtGymManagementSystem.setHorizontalAlignment(SwingConstants.CENTER);
        txtGymManagementSystem.setFont(new Font("Monospaced", Font.BOLD, 30));
        txtGymManagementSystem.setText("GymPro Vision");
        txtGymManagementSystem.setBounds(10, 0, 366, 80);
        panel.add(txtGymManagementSystem);

        
        
        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new EmptyBorder(0, 0, 0, 0));
        panel_1.setBackground(new Color(153, 153, 0)); // Slightly different shade of blue
        panel_1.setBounds(122, 113, 146, 42);
        contentPane.add(panel_1);
        panel_1.setLayout(null);

        


        JLabel lblNewLabel = new JLabel("Login");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 24));
        lblNewLabel.setBounds(42, 11, 76, 26);
        panel_1.add(lblNewLabel);

        JPanel panel_2 = new JPanel();
        panel_2.setBackground(new Color(0,0,0,0));
        panel_2.setBounds(51, 166, 300, 130);
        contentPane.add(panel_2);
        panel_2.setLayout(null);

        JLabel lblNewLabel_1 = new JLabel("User Name:");
        lblNewLabel_1.setFont(new Font("SansSerif", Font.BOLD, 16));
        lblNewLabel_1.setBounds(10, 28, 96, 28);
        panel_2.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("Password:");
        lblNewLabel_2.setFont(new Font("SansSerif", Font.BOLD, 16));
        lblNewLabel_2.setBounds(10, 82, 96, 14);
        panel_2.add(lblNewLabel_2);

        textField = new JTextField();
        textField.setFont(new Font("SansSerif", Font.PLAIN, 14));
        textField.setBounds(116, 35, 119, 20);
        panel_2.add(textField);
        textField.setColumns(10);
        textField.setDocument(new JTextFieldLimit(10)); // Limit User Name to 10 characters

        textField_1 = new JPasswordField();
        textField_1.setFont(new Font("SansSerif", Font.PLAIN, 14));
        textField_1.setBounds(116, 82, 119, 20);
        panel_2.add(textField_1);
        textField_1.setColumns(10);
        textField_1.setDocument(new JTextFieldLimit(8)); // Limit Password to 8 characters

        char bulletChar = '\u2022';

        JCheckBox chckbxNewCheckBox = new JCheckBox("Show Password");
        chckbxNewCheckBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (chckbxNewCheckBox.isSelected()) {
                    textField_1.setEchoChar((char) 0); // Display the password as plain text
                } else {
                    textField_1.setEchoChar(bulletChar); // Hide the password
                }
            }
        });
        chckbxNewCheckBox.setFont(new Font("SansSerif", Font.PLAIN, 12));
        chckbxNewCheckBox.setBounds(116, 109, 119, 23);
        panel_2.add(chckbxNewCheckBox);

        JPanel panel_3 = new JPanel();
        panel_3.setBackground(new Color(0, 0, 0, 0)); // Transparent background
        panel_3.setBounds(96, 307, 179, 65);
        contentPane.add(panel_3);
        panel_3.setLayout(null);

        JButton btnNewButton = new JButton("Login");
        btnNewButton.setIcon(new ImageIcon("D:\\JavaDocuments\\GymSystem\\pictures\\Login.png"));
        btnNewButton.setBackground(new Color(191, 247, 245));
        btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
        btnNewButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Add a hand cursor
        btnNewButton.setFont(new Font("SansSerif", Font.PLAIN, 16));
        btnNewButton.setBounds(22, 11, 133, 43);
        panel_3.add(btnNewButton);
        setResizable(false);

        
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = textField.getText();
                char[] password = textField_1.getPassword();

                if (username.isEmpty()) {
                    JOptionPane.showMessageDialog(contentPane, "Username cannot be empty", "Invalid Username", JOptionPane.ERROR_MESSAGE);
                } else if (password.length != 8) {
                    JOptionPane.showMessageDialog(contentPane, "Password must be 8 characters long", "Invalid Password", JOptionPane.ERROR_MESSAGE);
                } else {
                    // Perform login action
                    // Replace this with your login logic
                }
            }
        });

        JPanel panel_4 = new JPanel();
        panel_4.setBorder(new EmptyBorder(0, 0, 0, 0));
        panel_4.setBackground(new Color(240, 240, 240)); 
        panel_4.setBounds(0, 67, 386, 326);
        contentPane.add(panel_4);
        panel_4.setLayout(null);
        
        JLabel backgroundLabel = new JLabel();
        backgroundLabel.setIcon(new MyIcon(new ImageIcon("D:\\\\JavaDocuments\\\\GymSystem\\\\pictures\\\\login.jpeg").getImage(),400,400));
        
        backgroundLabel.setBounds(-14, -14, 400, 340);
        panel_4.add(backgroundLabel);
        //assdsd
    }
}
