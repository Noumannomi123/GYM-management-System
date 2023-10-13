package mainwindows;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import database.Database;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.border.CompoundBorder;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionEvent;

public class MemberChecksFitnessGoalsPlan extends JFrame {

    private Map<String, DefaultTableModel> fitnessGoalsPlans = new HashMap<>();

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Database database;
	

	/**
	 * Create the frame.
	 */
	public MemberChecksFitnessGoalsPlan(Database database) {
		this.database = database;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 30, 968, 670);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(32,57,122));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setResizable(false);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		//Profile Details
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBounds(234, 106, 484, 71);
		panel.setBackground(new Color(62, 85, 145));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblName = new JLabel();
		lblName.setBounds(26, 28, 185, 17);
		panel.add(lblName);
		lblName.setText("Person Name:");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("Dialog", Font.BOLD, 24));
		lblName.setBackground(new Color(108, 130, 206));
		
		JComboBox<String> comboBox_1 = new JComboBox<>();
		comboBox_1.setBounds(236, 30, 194, 22);
		panel.add(comboBox_1);
		
		
		List<String> memberNames = database.getMemberList();
		for(String mem: memberNames) {
			comboBox_1.addItem(mem);
		}
		
		
		//Select Fitness Goals
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(new Color(62, 85, 145));
		panel_1_1.setBounds(172, 197, 614, 71);
		contentPane.add(panel_1_1);
		panel_1_1.setLayout(null);
		
		JLabel lblSelectFitness = new JLabel();
		lblSelectFitness.setBounds(8, 8, 239, 24);
		lblSelectFitness.setText("Select Fitness");
		lblSelectFitness.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectFitness.setForeground(Color.WHITE);
		lblSelectFitness.setFont(new Font("Dialog", Font.BOLD, 24));
		lblSelectFitness.setBackground(new Color(108, 130, 206));
		panel_1_1.add(lblSelectFitness);
		
		JLabel lblGoals = new JLabel();
		lblGoals.setBounds(8, 40, 239, 24);
		lblGoals.setText("Goal");
		lblGoals.setHorizontalAlignment(SwingConstants.CENTER);
		lblGoals.setForeground(Color.WHITE);
		lblGoals.setFont(new Font("Dialog", Font.BOLD, 24));
		lblGoals.setBackground(new Color(108, 130, 206));
		panel_1_1.add(lblGoals);
		
		//Drop Down(Combo box)
		// for fitness goals
		JComboBox<String> comboBox = new JComboBox<>();
		comboBox.setBounds(245, 19, 189, 32);
		panel_1_1.add(comboBox);
		
		String [] fitnessGoals = {"Weight Loss", "Muscle Gain"};
		for(String goal: fitnessGoals) {
			comboBox.addItem(goal);
		}
		
		
//		JButton doneButton = new JButton("Done");
//		doneButton.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				String userName =comboBox_1.getSelectedItem().toString(); 
//				String goal = comboBox.getSelectedItem().toString();
//				boolean goalSet = database.setGoal(userName,goal);
//				if (goalSet) {
//	                // Display a success message
//	                JOptionPane.showMessageDialog(null, "Goal set successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
//	            } else {
//	                // Display an error message if the goal was not set
//	                JOptionPane.showMessageDialog(null, "Failed to set goal. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
//	            }
//			}
//		});
//		doneButton.setFont(new Font("Dialog", Font.BOLD, 15));
//		doneButton.setBounds(475, 23, 94, 25);
//		panel_1_1.add(doneButton);
		
		// Weekdays List
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(null);
		panel_2.setBackground(new Color(62, 85, 145));
		panel_2.setBounds(32, 289, 893, 302);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 11, 873, 280);
        panel_2.add(scrollPane);

        // Create a JTable with a default table model
        JTable table = new JTable();
        scrollPane.setViewportView(table);

        // Create a default table model and set it to the table
        Object[][] weightLossExercisesData = {
        	    {"Running", "Monday", 3, 30},
        	    {"Jumping Jacks", "Tuesday", 4, 20},
        	    {"Cycling", "Wednesday", 3, 25},
        	    {"Plank", "Thursday", 3, 45},
        	    {"High Knees", "Friday", 4, 15}
        	};
        DefaultTableModel weightLossModel = new DefaultTableModel(
        		weightLossExercisesData,
                new String[]{"Exercise", "Week Days", "Sets", "Reps"}
        );
        table.setModel(weightLossModel);

        Object[][] muscleGainExercisesData = {
        	    {"Weighted Squats", "Monday", 4, 12},
        	    {"Bench Press", "Tuesday", 3, 10},
        	    {"Deadlifts", "Wednesday", 4, 8},
        	    {"Pull-Ups", "Thursday", 3, 15},
        	    {"Barbell Rows", "Friday", 4, 12},
        	    // Add more real exercises as needed
        	};

        	// Create a default table model with real Muscle Gain exercise data
        	DefaultTableModel muscleGainModel = new DefaultTableModel(
        	        muscleGainExercisesData,
        	        new String[]{"Exercise", "Week Days", "Sets", "Reps"}
        	);
        
        // Store the default table model in the data structure for the selected fitness goal
        fitnessGoalsPlans.put("Weight Loss", weightLossModel);
        fitnessGoalsPlans.put("Muscle Gain", muscleGainModel);

        JButton doneButton = new JButton("Done");
        doneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get selected user and fitness goal
                String userName = comboBox_1.getSelectedItem().toString();
                String goal = comboBox.getSelectedItem().toString();

                // Retrieve the predefined plan for the selected fitness goal
               
                boolean goalSet = database.setGoal(userName, goal);
                if (goalSet) {
                    // Display a success message
                    JOptionPane.showMessageDialog(null, "Goal set successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    // Display an error message if the goal was not set
                    JOptionPane.showMessageDialog(null, "Failed to set goal. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        doneButton.setFont(new Font("Dialog", Font.BOLD, 15));
        doneButton.setBounds(475, 23, 94, 25);
        panel_1_1.add(doneButton);
        
        comboBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
                String goal = comboBox.getSelectedItem().toString();
				 DefaultTableModel selectedPlan = fitnessGoalsPlans.get(goal);
	             table.setModel(selectedPlan);
			}
        	
        });
		
	}
	
	
}
