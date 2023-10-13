package mainwindows;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import database.Database;
import utils.ButtonAction;
import utils.ButtonsCompoundBorder;
import utils.MenuMaker;
import utils.MyIcon;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RegistrationManagerW extends UserW {

    private Database database;

    public RegistrationManagerW(Database database) {
        super();
        this.database = database;

        setTitle("Registration Manager");
        panel_2.setBounds(0, 73, 203, 325);
        String[] buttonLabels = {
                "Home Page", // lets just create for now
                "Register Member"
        };
        
        panelW = new JPanel[buttonLabels.length];
        
        for (int i = 0; i < buttonLabels.length; i++) {
            panelW[i] = new JPanel();
            panelW[i].setBounds(203, 73, 968, 670);
            panelW[i].setBackground(new Color(32, 57, 122));
            contentPane.add(panelW[i]);
            panelW[i].setLayout(null);
            panelW[i].setVisible(false);
        }
        panelW[0].setVisible(true);
        JPanel panel = new JPanel();
        panel.setBounds(115, 40, 741, 559);
        panel.setBackground(new Color(62, 85, 145));
        panelW[0].add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("Welcome");
        lblNewLabel.setFont(new Font("Open Sans", Font.BOLD, 42));
        lblNewLabel.setForeground(Color.WHITE);
        lblNewLabel.setBounds(247, 11, 206, 67);
        panel.add(lblNewLabel);

        JLabel lblNewLabel2 = new JLabel();
        lblNewLabel2.setBounds(293, 74, 100, 100);
        lblNewLabel2.setIcon(new ImageIcon("D:\\JavaDocuments\\GymSystem\\pictures\\Manager.png"));
        panel.add(lblNewLabel2);

        JPanel panel_3 = new JPanel();
        panel_3.setBounds(70, 206, 259, 166);
        panel_3.setBackground(panel.getBackground());
        panel.add(panel_3);
        panel_3.setLayout(null);

        JLabel addMember = new JLabel("Add New Member");
        addMember.setFont(new Font("Open Sans", Font.PLAIN, 22));
        addMember.setBounds(new Rectangle(31, 5, 197, 39));
        addMember.setForeground(Color.WHITE);
        addMember.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panel_3.add(addMember);

        JLabel memberPic = new JLabel();
        memberPic.setBounds(new Rectangle(71, 43, 100, 100));
        ImageIcon imageIcon = new ImageIcon("D:\\\\JavaDocuments\\\\GymSystem\\\\pictures\\\\Add.png");
        memberPic.setIcon(new MyIcon(imageIcon.getImage(), 100, 100));
        memberPic.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panel_3.add(memberPic);
        
        newButtons = new JButton[buttonLabels.length];
        MenuMaker.makeMenu(buttonLabels, panel_2, titleLabel,panelW,newButtons);
        MouseAdapter registerMember = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JButton currentButton = newButtons[1];
                if (currentButton != null) {
                	ButtonAction.performAction(currentButton,false,titleLabel,buttonLabels[1],buttonLabels,panelW);
                	ButtonsCompoundBorder.setButtonBorder(currentButton, true);
                	// all other buttons to false
                	for(JButton button: newButtons) {
                		if(button != currentButton)
                			ButtonsCompoundBorder.setButtonBorder(button, false);
                	}
                }
                
            	
            }
        };
        addMember.addMouseListener(registerMember);
        memberPic.addMouseListener(registerMember);
    }
}
