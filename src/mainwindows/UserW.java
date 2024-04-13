package mainwindows;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import login.Login;
import utils.Look;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class UserW extends JFrame {

    protected JPanel contentPane;
    protected JPanel panel = new JPanel();
    protected JLabel titleLabel;
    protected JPanel panel_2;
    protected JButton[] newButtons;
    protected Color backgroundColor = new Color(32, 57, 122);
    protected Color foregroundColor = new Color(62, 85, 145);

    JPanel[] panelW;


    public UserW() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(50, 0, 1185, 670+72);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        setResizable(false);
        contentPane.setLayout(null);
        panel.setBackground(new Color(32, 57, 122));
        panel.setBounds(0, 0, 1171, 72);
        contentPane.add(panel);
        panel.setLayout(null);

        titleLabel = new JLabel("Home Page");
        titleLabel.setForeground(new Color(255, 255, 255));
        titleLabel.setFont(new Font("Monospaced", Font.BOLD, 40));
        titleLabel.setBounds(304, 11, 573, 50);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        panel.add(titleLabel);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBounds(0, 571, 203, 100);
        panel_1.setBackground(new Color (0,0,0,0));
        contentPane.add(panel_1);
        panel_1.setLayout(null);
 
        JButton btnNewButton_1 = new JButton("Logout");
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		logout();
        	}
        });
        btnNewButton_1.setForeground(new Color(255, 255, 255));
        btnNewButton_1.setFocusPainted(false);
        btnNewButton_1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnNewButton_1.setFont(new Font("Serif", Font.PLAIN, 18));
        btnNewButton_1.setBackground(new Color (231, 78, 64));;
        btnNewButton_1.setBounds(58, 11, 89, 37);
        panel_1.add(btnNewButton_1);
        
        
        
        panel_2 = new JPanel();
        panel_2.setBackground(new Color(255, 255, 255));
        contentPane.add(panel_2);
        panel_2.setLayout(null);
    }
    
    public void logout() {
    	 Login log = new Login();
    	 log.setVisible(true);
    	 dispose();
    }

}
