package mainwindows;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.LayoutManager;

public class DietPlan extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JPanel dietPanel;
    private JPanel hydrationPanel;

    public DietPlan() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 0, 968, 670);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(032, 57, 122));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JComboBox<String> comboBox1 = new JComboBox<>();
        comboBox1.setBounds(302, 49, 226, 37);
        contentPane.add(comboBox1);

        JLabel lblNewLabel = new JLabel("Select Diet Plan");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setFont(new Font("Serif", Font.BOLD, 28));
        lblNewLabel.setBounds(342, 11, 250, 30);
        contentPane.add(lblNewLabel);

        comboBox1.addItem("Weight lose");
        comboBox1.addItem("Muscle building");
        comboBox1.addItem("Functional fitness");

        dietPanel = new JPanel();
        dietPanel.setForeground(new Color(255, 255, 255));
        dietPanel.setBackground(new Color(62, 85, 145));
        dietPanel.setBounds(41, 155, 832, 200);
        contentPane.add(dietPanel);
        dietPanel.setLayout(new BoxLayout(dietPanel, BoxLayout.Y_AXIS));

        hydrationPanel = new JPanel();
        hydrationPanel.setForeground(new Color(255, 255, 255));
        hydrationPanel.setBackground(new Color(62, 85, 145));
        hydrationPanel.setBounds(41, 370, 832, 200);
        contentPane.add(hydrationPanel);
        hydrationPanel.setLayout(new BoxLayout(hydrationPanel, BoxLayout.Y_AXIS));

        // Adding ActionListener to the combo box
        comboBox1.addActionListener(e -> {
            String selectedItem = (String) comboBox1.getSelectedItem();
            displayDietPlan(selectedItem);
        });
    }

    private void displayDietPlan(String selectedItem) {
        dietPanel.removeAll();
        hydrationPanel.removeAll();

        JLabel dietHeadingLabel = new JLabel("Menu of " + selectedItem);
        dietHeadingLabel.setForeground(new Color(255, 255, 255));
        dietHeadingLabel.setFont(new Font("Serif", Font.BOLD, 28));
        dietPanel.add(dietHeadingLabel);

        JLabel hydrationHeadingLabel = new JLabel("Hydration for " + selectedItem);
        hydrationHeadingLabel.setForeground(new Color(255, 255, 255));
        hydrationHeadingLabel.setFont(new Font("Serif", Font.BOLD, 28));
        hydrationPanel.add(hydrationHeadingLabel);

        String[] dietItems;
        String[] hydrationItems;

        switch (selectedItem) {
            case "Weight lose":
                dietItems = new String[]{"Grilled Chicken", "Quinoa", "Mixed Vegetables"};
                hydrationItems = new String[]{"Water", "Herbal Tea"};
                break;
            case "Muscle building":
                dietItems = new String[]{"Salmon", "Sweet Potatoes", "Greek Yogurt"};
                hydrationItems = new String[]{"Lemonade", "Milk"};
                break;
            case "Functional fitness":
                dietItems = new String[]{"Oats", "Avocado", "Berries"};
                hydrationItems = new String[]{"Green Tea", "Watermelon"};
                break;
            default:
                dietItems = new String[]{"Invalid selection"};
                hydrationItems = new String[]{"Invalid selection"};
                break;
        }

        for (String item : dietItems) {
            JLabel itemLabel = new JLabel(item);
            itemLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            itemLabel.setForeground(new Color(255, 255, 255));
            itemLabel.setFont(new Font("Serif", Font.PLAIN, 28));
            dietPanel.add(itemLabel);
        }

        for (String item : hydrationItems) {
            JLabel itemLabel = new JLabel(item);
            itemLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            itemLabel.setForeground(new Color(255, 255, 255));
            itemLabel.setFont(new Font("Serif", Font.PLAIN, 28));
            hydrationPanel.add(itemLabel);
        }

        dietPanel.revalidate();
        dietPanel.repaint();

        hydrationPanel.revalidate();
        hydrationPanel.repaint();
    }
}
