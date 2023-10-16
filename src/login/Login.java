package login;
import mainpage.Home;
import database.Database;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import utils.JTextFieldLimit;
import utils.MyIcon;

import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.awt.Cursor;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;


public class Login extends JFrame {

    private JPanel contentPane;
    private JLabel txtGymManagementSystem;
    private JTextField username_1;
    private JPasswordField password_1;

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
        setBounds(100, 100, 396, 487);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        panel.setBackground(new Color(0, 0, 255));
        panel.setBounds(0, 0, 406, 69);
        contentPane.add(panel);
        panel.setLayout(null);

        txtGymManagementSystem = new JLabel();
        txtGymManagementSystem.setForeground(new Color(255, 255, 255));
        txtGymManagementSystem.setHorizontalAlignment(SwingConstants.CENTER);
        txtGymManagementSystem.setFont(new Font("Monospaced", Font.BOLD, 40));
        txtGymManagementSystem.setText("GymPro Vision");
        txtGymManagementSystem.setBounds(10, 0, 366, 69);
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
        panel_2.setBounds(51, 208, 300, 147);
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

        username_1 = new JTextField();
        username_1.setFont(new Font("SansSerif", Font.PLAIN, 14));
        username_1.setBounds(116, 35, 119, 20);
        panel_2.add(username_1);
        username_1.setColumns(10);
        username_1.setDocument(new JTextFieldLimit(10)); // Limit User Name to 10 characters
        int borderWidth = 2;
        username_1.setBorder(new LineBorder(Color.GRAY, borderWidth, true)); // true for rounded border
        
        password_1 = new JPasswordField();
        password_1.setFont(new Font("SansSerif", Font.PLAIN, 14));
        password_1.setBounds(116, 82, 119, 20);
        panel_2.add(password_1);
        password_1.setColumns(10);
        password_1.setDocument(new JTextFieldLimit(8)); // Limit Password to 8 characters
        password_1.setBorder(new LineBorder(Color.GRAY, borderWidth, true)); // true for rounded border

        char bulletChar = '\u2022';

        JCheckBox chckbxNewCheckBox = new JCheckBox("Show Password");
        chckbxNewCheckBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (chckbxNewCheckBox.isSelected()) {
                    password_1.setEchoChar((char) 0); // Display the password as plain text
                } else {
                    password_1.setEchoChar(bulletChar); // Hide the password
                }
            }
        });
        chckbxNewCheckBox.setFont(new Font("SansSerif", Font.PLAIN, 12));
        chckbxNewCheckBox.setBounds(116, 109, 119, 23);
        panel_2.add(chckbxNewCheckBox);

        JPanel panel_3 = new JPanel();
        panel_3.setBorder(new EmptyBorder(0, 0, 0, 0));
        panel_3.setBackground(new Color(0, 0, 0, 0)); // Transparent background
        panel_3.setBounds(96, 355, 179, 69);
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

        JPanel panel_5 = new JPanel();
        panel_5.setBounds(88, 165, 213, 62);
        panel_5.setBackground(new Color(0,0,0,0));
        contentPane.add(panel_5);
   
        // Create a label for the combo box
        JLabel lblNewLabel_3 = new JLabel("User Type:");
        lblNewLabel_3.setToolTipText("Select the user type to login.");
        lblNewLabel_3.setFont(new Font("SansSerif", Font.BOLD, 16));
        lblNewLabel_3.setBounds(10, 11, 96, 20);
        lblNewLabel_3.setIcon(new ImageIcon("D:\\JavaDocuments\\GymSystem\\pictures\\UserType.png"));
        panel_5.add(lblNewLabel_3);
        
        // Create a combo box with user types
        String[] userTypes = {"Member", "Staff", "Admin", "Registration Manager"};
        JComboBox<String> usertype = new JComboBox<>(userTypes);
        usertype.setFont(new Font("SansSerif", Font.PLAIN, 14));
        usertype.setBounds(116, 11, 96, 20);
        panel_5.add(usertype);
        
        JPanel panel_4 = new JPanel();
        panel_4.setBorder(new EmptyBorder(0, 0, 0, 0));
        panel_4.setBackground(new Color(240, 240, 240)); 
        panel_4.setBounds(0, 67, 396, 458);
        contentPane.add(panel_4);
        panel_4.setLayout(null);
        
        JLabel backgroundLabel = new JLabel();
        backgroundLabel.setIcon(new MyIcon(new ImageIcon("D:\\\\JavaDocuments\\\\GymSystem\\\\pictures\\\\login.jpeg").getImage(),400,400));
        
        backgroundLabel.setBounds(-12, -14, 420, 430);
        panel_4.add(backgroundLabel);
        
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = username_1.getText();
                char[] password = password_1.getPassword();
                String uType = (String) usertype.getSelectedItem();
                if (username.isEmpty()) {
                    JOptionPane.showMessageDialog(contentPane, "Username cannot be empty", "Invalid Username", JOptionPane.ERROR_MESSAGE);
                } else if (password.length != 8) {
                    JOptionPane.showMessageDialog(contentPane, "Password must be 8 characters long", "Invalid Password", JOptionPane.ERROR_MESSAGE);
                } else {
                	Database db = new Database();
                    if (db.verifyLogin(username, uType, password)) {
                        // Successful login, close current JFrame
                        dispose();
                        Home newFrame = new Home();
                        newFrame.setVisible(true);
                        
                    } else {
                        // Show error dialog for incorrect username or password
                        JOptionPane.showMessageDialog(contentPane, "Incorrect username or password. Please try again.", "Login Error", JOptionPane.ERROR_MESSAGE);
                    }
                	
                }
            }
        });
    }
}
