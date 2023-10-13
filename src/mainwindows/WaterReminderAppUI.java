package mainwindows;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.prefs.Preferences;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class WaterReminderAppUI extends JFrame {
    private static final long serialVersionUID = 6659052360964315165L;

    private Preferences preferences;
    private final int DEFAULT_GOAL = 64;
    private JTextField txtEnterYourWater;
    private JTextField txtYourDailyWater;
    private JTextField textField;
    private JLabel lblNewLabel;

    public WaterReminderAppUI() {
        setPreferences(Preferences.userNodeForPackage(WaterReminderAppUI.class));

        setTitle("Water Reminder App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 0, 978, 670);
        JPanel contentPane = new JPanel();
        contentPane.setForeground(new Color(0, 128, 255));
        contentPane.setBackground(new Color(0, 128, 255));
        contentPane.setLayout(null);
        setContentPane(contentPane);

        txtEnterYourWater = new JTextField();
        txtEnterYourWater.setFont(new Font("Serif", Font.PLAIN, 26));
        txtEnterYourWater.setText("Enter your water intake ");
        txtEnterYourWater.setBounds(518, 113, 271, 47);
        contentPane.add(txtEnterYourWater);
        txtEnterYourWater.setColumns(10);

        txtYourDailyWater = new JTextField();
        txtYourDailyWater.setFont(new Font("Serif", Font.BOLD, 25));
        txtYourDailyWater.setText("  Your Daily Water Intake Goal Is");
        txtYourDailyWater.setBounds(28, 107, 377, 60);
        contentPane.add(txtYourDailyWater);
        txtYourDailyWater.setColumns(10);

        textField = new JTextField();
        textField.setBounds(604, 194, 109, 25);
        contentPane.add(textField);
        textField.setColumns(10);

        JButton btnNewButton = new JButton("calculate ");
        btnNewButton.setFont(new Font("Serif", Font.PLAIN, 18));
        btnNewButton.setBounds(604, 248, 126, 23);
        contentPane.add(btnNewButton);

        lblNewLabel = new JLabel("  64");
        lblNewLabel.setBackground(new Color(255, 255, 255));
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setFont(new Font("Serif", Font.BOLD, 53));
        lblNewLabel.setBounds(141, 178, 118, 68);
        contentPane.add(lblNewLabel);

        // Add action listener to the button
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get the user-entered water intake from the text field
                String userInput = textField.getText();

                // Validate and parse the user input
                try {
                    int userIntake = Integer.parseInt(userInput);

                    // Calculate and display the result
                    int goal = getPreferences().getInt("dailyWaterGoal", DEFAULT_GOAL);
                    int remaining = goal - userIntake;

                    if (remaining > 0) {
                        String message = "Your remaining water intake to reach the goal is: " + remaining + " ounces";
                        JOptionPane.showMessageDialog(WaterReminderAppUI.this, message, "Water Intake Result", JOptionPane.INFORMATION_MESSAGE);
                    } else if (remaining == 0) {
                        String message = "Congratulations! You have achieved your daily water intake goal. Hurray!";
                        JOptionPane.showMessageDialog(WaterReminderAppUI.this, message, "Goal Achieved", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        String message = "You have exceeded your daily water intake goal. Great job!";
                        JOptionPane.showMessageDialog(WaterReminderAppUI.this, message, "Goal Exceeded", JOptionPane.INFORMATION_MESSAGE);
                    }

                } catch (NumberFormatException ex) {
                    // Handle the case where the user input is not a valid integer
                    JOptionPane.showMessageDialog(WaterReminderAppUI.this, "Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    

    public Preferences getPreferences() {
        return preferences;
    }

    public void setPreferences(Preferences preferences) {
        this.preferences = preferences;
    }
}
