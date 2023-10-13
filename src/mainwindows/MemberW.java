package mainwindows;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import database.Database;
import utils.ButtonsCompoundBorder;
import utils.MyIcon;
import utils.MenuMaker;
import utils.Look;
public class MemberW extends UserW {

	private Database database;
    

    public MemberW(Database database) {
        super(); // Call the constructor of UserHome to set up UI components
        this.database = database;
        setTitle("Member");
        panel_2.setBounds(0, 73, 203, 435);
        String[] buttonLabels = {
                "Home Page",//0
                "Health Care Pro",//3
                "Fitness Goals, Plans",//4
                "Fitness Tests",//5
                "Diet Plans",//6
                "Meditation Timer",//7
                "Water Intake",
                "Daily Step"
            };
        // for clickable things, secondary color that is light Blue.
        // for static things, no.
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
        newButtons = new JButton[buttonLabels.length];
        MenuMaker.makeMenu(buttonLabels, panel_2, titleLabel,panelW,newButtons);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBounds(900, 75, 553, 428);
        panel_1.setBackground(new Color (0,0,0,0));
        contentPane.add(panel_1);
        panel_1.setLayout(null);
        
        int widthW = panel_2.getWidth();
        int heightW = panel.getHeight() + 1;
        
//        hc pro
//        penel[3]
        HCPro hcPro = new HCPro(database);
		Container contentPane2 = hcPro.getContentPane();
		panelW[3-2].add(hcPro.getContentPane());
		for (Component component : contentPane2.getComponents()) {
            panelW[3-2].add(component);
        }
		hcPro.dispose();
		// fitness goals
		// panel[4]
		MemberChecksFitnessGoalsPlan fitnessGoals = new MemberChecksFitnessGoalsPlan(database);
		Container contentPane3 = fitnessGoals.getContentPane();
		panelW[4-2].add(fitnessGoals.getContentPane());
		for (Component component : contentPane3.getComponents()) {
            panelW[4-2].add(component);
        }
		fitnessGoals.dispose();
		Fitness_test fTest = new Fitness_test();
		Container contentPane4 = fTest.getContentPane();
		panelW[5-2].add(fTest.getContentPane());
		for (Component component : contentPane4.getComponents()) {
	        panelW[5-2].add(component);
	    }
		fTest.dispose();		
		
		DietPlan dPlan = new DietPlan();
		Container contentPane5 = dPlan.getContentPane();
		panelW[6-2].add(dPlan.getContentPane());
		for (Component component : contentPane5.getComponents()) {
	        panelW[6-2].add(component);
	    }
		dPlan.dispose();		
		
		MeditationTimer mTimer = new MeditationTimer();
		Container contentPane6 = mTimer.getContentPane();
		for (Component component : contentPane6.getComponents()) {
	        panelW[7-2].add(component);
	    }
		mTimer.dispose();	
		
		
		WaterReminderAppUI wR = new WaterReminderAppUI();
		Container contentPane7 = wR.getContentPane();
		for (Component component : contentPane7.getComponents()) {
	        panelW[8-2].add(component);
	    }
		wR.dispose();
		
		DailyStep dS = new DailyStep();
		Container contentPane8 = dS.getContentPane();
		for (Component component : contentPane8.getComponents()) {
	        panelW[9-2].add(component);
	    }
		dS.dispose();
		
    }
}
