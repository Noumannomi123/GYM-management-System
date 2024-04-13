package mainwindows;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import database.Database;
import utils.Look;
import utils.MenuMaker;

public class AdminW extends UserW {

	private Database database ;
	
	public AdminW(Database database) {
		super();
        this.database = database;

		setTitle("Admin");
        panel_2.setBounds(0, 73, 203, 325);
        
        String[] buttonLabels = {
				"Home Page",
				"Manage Staff"
		};
		
		panelW = new JPanel[buttonLabels.length];
        
        for (int i = 0; i < buttonLabels.length; i++) {
            panelW[i] = new JPanel();
            panelW[i].setBounds(203, 73, 968, 670);
            panelW[i].setBackground(backgroundColor);
            contentPane.add(panelW[i]);
            panelW[i].setLayout(null);
            panelW[i].setVisible(false);
        }
        panelW[0].setVisible(true);
        newButtons = new JButton[buttonLabels.length];
		MenuMaker.makeMenu(buttonLabels, panel_2,titleLabel,panelW,newButtons);
		
		AdminStaffInfo manageStaff = new AdminStaffInfo(database);
		Container contentPane2 = manageStaff.getContentPane();
		panelW[1].add(manageStaff.getContentPane());
		for (Component component : contentPane2.getComponents()) {
            panelW[1].add(component);
        }
		manageStaff.dispose();
	}

}
