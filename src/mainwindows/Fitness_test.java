package mainwindows;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class Fitness_test extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtWeight;
    private JTextField textField;
    private JLabel txtEnterSecondsFor;
    private JTextField textField_1;


    public Fitness_test() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 0, 968, 670);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(32, 57, 122));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(62, 85, 145));
        panel.setBounds(61, 125, 829, 340);
        contentPane.add(panel);
        panel.setLayout(null);

        JComboBox<String> comboBox = new JComboBox<>();
        comboBox.setBounds(280, 59, 194, 37);
        panel.add(comboBox);
        comboBox.addItem("BMI + Body Fat");
        comboBox.addItem("Body Balance");

        JLabel lblNewLabel = new JLabel("Select Test");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 24));
        lblNewLabel.setBounds(300, 11, 194, 37);
        panel.add(lblNewLabel);

        txtWeight = new JTextField();
        txtWeight.setForeground(new Color(0, 0, 0));
        txtWeight.setFont(new Font("Serif", Font.PLAIN, 18));
        txtWeight.setText("         ");
        txtWeight.setBounds(141, 225, 59, 37);
        panel.add(txtWeight);
        txtWeight.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("  Weight");
        lblNewLabel_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1.setFont(new Font("Serif", Font.PLAIN, 24));
        lblNewLabel_1.setBounds(31, 223, 100, 37);
        panel.add(lblNewLabel_1);

        JLabel lblNewLabel_1_1 = new JLabel("  Height");
        lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1_1.setFont(new Font("Serif", Font.PLAIN, 24));
        lblNewLabel_1_1.setBounds(41, 281, 100, 37);
        panel.add(lblNewLabel_1_1);

        textField = new JTextField();
        textField.setText("         ");
        textField.setForeground(Color.BLACK);
        textField.setFont(new Font("Serif", Font.PLAIN, 18));
        textField.setColumns(10);
        textField.setBounds(141, 283, 59, 37);
        panel.add(textField);

        JButton btnCalculateBMI = new JButton("Calculate BMI");
        btnCalculateBMI.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculateBMI();
            }
        });
        btnCalculateBMI.setForeground(new Color(0, 0, 0));
        btnCalculateBMI.setFont(new Font("Serif", Font.PLAIN, 20));
        btnCalculateBMI.setBounds(21, 109, 212, 37);
        panel.add(btnCalculateBMI);

        JButton btnCalculateBodyFat = new JButton("Calculate Body Fat");
        btnCalculateBodyFat.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculateBodyFatPercentage();
            }
        });

        btnCalculateBodyFat.setForeground(Color.BLACK);
        btnCalculateBodyFat.setFont(new Font("Serif", Font.PLAIN, 20));
        btnCalculateBodyFat.setBounds(21, 157, 212, 37);
        panel.add(btnCalculateBodyFat);

        txtEnterSecondsFor = new JLabel();
        txtEnterSecondsFor.setText("       enter seconds for Body Balance");
        txtEnterSecondsFor.setForeground(new Color(255, 255, 255));
        txtEnterSecondsFor.setFont(new Font("Serif", Font.BOLD, 24));
        txtEnterSecondsFor.setBounds(194, 119, 395, 58);
        panel.add(txtEnterSecondsFor);

        textField_1 = new JTextField();
        textField_1.setText("         ");
        textField_1.setForeground(Color.BLACK);
        textField_1.setFont(new Font("Serif", Font.PLAIN, 18));
        textField_1.setColumns(10);
        textField_1.setBounds(381, 179, 59, 37);

        textField_1.setVisible(false);
        txtEnterSecondsFor.setVisible(false);

        panel.add(textField_1);
        JButton btnCalculateBalance = new JButton("Calculate Balance");
        btnCalculateBalance.setForeground(Color.BLACK);
        btnCalculateBalance.setFont(new Font("Serif", Font.PLAIN, 20));
        btnCalculateBalance.setBounds(300, 238, 212, 37);
        panel.add(btnCalculateBalance);
        setResizable(false);

        btnCalculateBalance.setVisible(false);
        comboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (comboBox.getSelectedItem() == "Body Balance") {
                    btnCalculateBalance.setVisible(true);
                    textField_1.setVisible(true);
                    txtEnterSecondsFor.setVisible(true);

                    btnCalculateBMI.setVisible(false);
                    btnCalculateBodyFat.setVisible(false);
                    lblNewLabel_1.setVisible(false);
                    lblNewLabel_1_1.setVisible(false);
                    textField.setVisible(false);
                    txtWeight.setVisible(false);

                } else {

                    btnCalculateBalance.setVisible(false);
                    textField_1.setVisible(false);
                    txtEnterSecondsFor.setVisible(false);
                    btnCalculateBMI.setVisible(true);
                    btnCalculateBodyFat.setVisible(true);
                    lblNewLabel_1.setVisible(true);
                    lblNewLabel_1_1.setVisible(true);
                    textField.setVisible(true);
                    txtWeight.setVisible(true);

                }
            }
        });

        // ActionListener for the "Calculate Balance" button
        btnCalculateBalance.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateBalance(); // Call the method to calculate balance
            }
        });
    }

    private String getBMIMessage(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi >= 18.5 && bmi < 24.9) {
            return "Normal Weight";
        } else if (bmi >= 25 && bmi < 29.9) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    private void calculateBMI() {
        try {
            double weight = Double.parseDouble(txtWeight.getText());
            double height = Double.parseDouble(textField.getText()) / 100.0; // Convert height to meters
            double bmi = weight / (height * height);

            String bmiMessage = getBMIMessage(bmi);

            JOptionPane.showMessageDialog(this,
                    "Your BMI is: " + String.format("%.2f", bmi) + "\n" + bmiMessage, "BMI Result",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "Invalid input. Please enter valid numeric values for weight and height.", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void calculateBodyFatPercentage() {
        try {
            double weight = Double.parseDouble(txtWeight.getText());
            double height = Double.parseDouble(textField.getText()) / 100.0; // Convert height to meters

            // Body Fat Percentage calculation logic
            // Replace this line with your actual Body Fat Percentage calculation
            double bodyFatPercentage = weight / (height * height);

            JOptionPane.showMessageDialog(this,
                    "Your Body Fat Percentage is: " + String.format("%.2f", bodyFatPercentage) + "%",
                    "Body Fat % Result", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "Invalid input. Please enter valid numeric values for weight and height.", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }


private void calculateBalance() {
    try {
        String inputText = textField_1.getText().trim(); // Trim leading and trailing whitespaces
        if (!inputText.isEmpty()) {
            int seconds = Integer.parseInt(inputText);

            // Calculate balance based on seconds (replace this with your actual logic)
            double balance = seconds / 2.0; // Just an example, you can replace it with your own formula
            System.out.println("try");

            // Display the balance result
            JOptionPane.showMessageDialog(this, "Balance calculated using " + seconds + " seconds is: " + balance,
                    "Balance Result", JOptionPane.INFORMATION_MESSAGE);
        } else {
            throw new NumberFormatException(); // Trigger exception for empty input
        }
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(this, "Invalid input. Please enter a valid numeric value for seconds.",
                "Error", JOptionPane.ERROR_MESSAGE);
    }
}

}

