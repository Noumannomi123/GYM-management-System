package mainwindows;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;

public class DailyStep extends JFrame {
    private static final long serialVersionUID = 1013370217286689197L;
    private JTextField stepsTextField;

    private int totalSteps = 0;
    private int dailyGoal = 6000;
    private JLabel lblNewLabel;

    public DailyStep() {
        setTitle("Daily Steps Counter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 0, 978, 670);

        JPanel contentPane = new JPanel();
        contentPane.setBackground(new Color(0, 128, 192));
        contentPane.setLayout(null);

        stepsTextField = new JTextField();
        stepsTextField.setBounds(391, 147, 100, 25);
        contentPane.add(stepsTextField);

        JButton logStepsButton = new JButton("Calculate Steps");
        logStepsButton.setFont(new Font("Serif", Font.PLAIN, 25));
        logStepsButton.setBounds(323, 210, 209, 39);
        logStepsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                logSteps();
            }
        });
        contentPane.add(logStepsButton);

        setContentPane(contentPane);

        lblNewLabel = new JLabel("Daily Step Counter");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setFont(new Font("Serif", Font.BOLD, 35));
        lblNewLabel.setBounds(250, 43, 289, 39);
        contentPane.add(lblNewLabel);
        
        JLabel lblGoal = new JLabel("Goal: 6000");
        lblGoal.setForeground(Color.WHITE);
        lblGoal.setFont(new Font("Serif", Font.BOLD, 35));
        lblGoal.setBounds(663, 43, 165, 39);
        contentPane.add(lblGoal);
    }

    private void logSteps() {
        try {
            int stepsToday = Integer.parseInt(stepsTextField.getText());
            // Update total steps
            totalSteps += stepsToday;

            // Display a message based on goal achievement
            if (totalSteps == dailyGoal) {
                JOptionPane.showMessageDialog(this, "Great job! You've reached your daily steps goal.");
            } else if (totalSteps > dailyGoal) {
                JOptionPane.showMessageDialog(this, "Great job! You've reached your daily steps goal.");
            } else {
                JOptionPane.showMessageDialog(this, "Keep going! You're below your daily steps goal.");
            }

            stepsTextField.setText(""); // Clear the input field
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number for the steps.");
        }
    }
}
