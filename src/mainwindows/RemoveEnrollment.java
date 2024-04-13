package mainwindows;

import java.awt.EventQueue;
import database.Database;
import gymClasses.Enrollment;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class RemoveEnrollment extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel Header;
    private JComboBox<String> comboBox_4h3 = new JComboBox<>();
    private JButton btnNewButton;
    private JComboBox<String> comboBoxh3;
    private JComboBox<String> comboBox_2h3;
    private JComboBox<String> comboBox_3h3;
    
//	private Database database = new Database();
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					RemoveEnrollment frame = new RemoveEnrollment();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	
	public RemoveEnrollment() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 30, 968, 670);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(32,57,122));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setResizable(false);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		//Header
		JPanel panel_1h3 = new JPanel();
		panel_1h3.setBounds(259, 46, 418, 64);
		panel_1h3.setBackground(new Color(108,130,206));
		contentPane.add(panel_1h3);
		panel_1h3.setLayout(null);
		
		Header = new JLabel();
		Header.setBounds(37, 15, 343, 29);
		panel_1h3.add(Header);
		Header.setForeground(new Color(255, 255, 255));
		Header.setHorizontalAlignment(SwingConstants.CENTER);
		Header.setText("Remove Enrollment");
		Header.setBackground(new Color(108,130,206));
		Header.setForeground(Color.WHITE);
		Header.setFont(new Font("Open Sans", Font.BOLD, 24));
		
		JPanel panel_1_1h3 = new JPanel();
		panel_1_1h3.setBackground(new Color(108, 130, 206));
		panel_1_1h3.setBounds(87, 174, 472, 237);
		contentPane.add(panel_1_1h3);
		panel_1_1h3.setLayout(null);
		
		JLabel Header_1h3 = new JLabel();
		Header_1h3.setBounds(37, 24, 186, 32);
		Header_1h3.setText("Select Member:");
		Header_1h3.setHorizontalAlignment(SwingConstants.LEFT);
		Header_1h3.setForeground(Color.WHITE);
		Header_1h3.setFont(new Font("Dialog", Font.BOLD, 24));
		Header_1h3.setBackground(new Color(108, 130, 206));
		panel_1_1h3.add(Header_1h3);
		
		

		comboBox_4h3.setBounds(231, 24, 191, 32);
		panel_1_1h3.add(comboBox_4h3);
		
		JLabel Header_1_1h3 = new JLabel();
		Header_1_1h3.setBounds(37, 74, 186, 32);
		Header_1_1h3.setText("Fitness Class:");
		Header_1_1h3.setHorizontalAlignment(SwingConstants.LEFT);
		Header_1_1h3.setForeground(Color.WHITE);
		Header_1_1h3.setFont(new Font("Dialog", Font.BOLD, 24));
		Header_1_1h3.setBackground(new Color(108, 130, 206));
		panel_1_1h3.add(Header_1_1h3);
		
		comboBoxh3 = new JComboBox<>();
		comboBoxh3.setBounds(231, 74, 191, 31);
		panel_1_1h3.add(comboBoxh3);
		// Adding classes options to the combo box
		comboBoxh3.addItem("Select");
		comboBoxh3.addItem("Weight Loss Class");
		comboBoxh3.addItem("Muscle Building Class");
		comboBoxh3.addItem("Functional Fitness Class");
		
		
		JLabel Header_1_1_1h3 = new JLabel();
		Header_1_1_1h3.setBounds(37, 124, 230, 32);
		Header_1_1_1h3.setText("Class Time:");
		Header_1_1_1h3.setHorizontalAlignment(SwingConstants.LEFT);
		Header_1_1_1h3.setForeground(Color.WHITE);
		Header_1_1_1h3.setFont(new Font("Dialog", Font.BOLD, 24));
		Header_1_1_1h3.setBackground(new Color(108, 130, 206));
		panel_1_1h3.add(Header_1_1_1h3);
		
	    comboBox_2h3 = new JComboBox<String>();
		comboBox_2h3.setBounds(231, 124, 191, 32);
		panel_1_1h3.add(comboBox_2h3);
		// Adding two options to the combo box
		comboBox_2h3.addItem(" Select");
		comboBox_2h3.addItem(" 8:00 AM - 11:00 AM");
		comboBox_2h3.addItem(" 4:00 PM - 07:00 PM");
		comboBox_2h3.addItem(" 8:00 PM - 11:00 PM");
		
		
		JLabel Header_1_1_1_1h3 = new JLabel();
		Header_1_1_1_1h3.setBounds(37, 174, 179, 32);
		Header_1_1_1_1h3.setText("Class Day:");
		Header_1_1_1_1h3.setHorizontalAlignment(SwingConstants.LEFT);
		Header_1_1_1_1h3.setForeground(Color.WHITE);
		Header_1_1_1_1h3.setFont(new Font("Dialog", Font.BOLD, 24));
		Header_1_1_1_1h3.setBackground(new Color(108, 130, 206));
		panel_1_1h3.add(Header_1_1_1_1h3);
		
		comboBox_3h3 = new JComboBox<>();
		comboBox_3h3.setBounds(231, 179, 191, 32);
		panel_1_1h3.add(comboBox_3h3);
		// Adding five options to the combo box
		comboBox_3h3.addItem(" Select");
	    comboBox_3h3.addItem(" Monday");
		comboBox_3h3.addItem(" Tuesday");
		comboBox_3h3.addItem(" Wednesday");
		comboBox_3h3.addItem(" Thursday");
		comboBox_3h3.addItem(" Friday");
		
		
		//SuccessfullyRemove
		btnNewButton = new JButton("Remove");
		
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 20));
		btnNewButton.setBounds(686, 225, 131, 97);
		btnNewButton.setBackground(new Color(108,130,206));
		contentPane.add(btnNewButton);
		
	}
	public JPanel getPane() {
		return contentPane;
	}
	public void getmembers(Database database) {
		List<String> members = database.getMemberList();
		for(String member: members) {
			comboBox_4h3.addItem(member);
		}
	}
	public void removemember(Database database, JPanel[] showMembers) {
	    btnNewButton.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            // Retrieve data from components
	            String personNameh3 = (String) comboBox_4h3.getSelectedItem();
	            String fitnessClassh3 = (String) comboBoxh3.getSelectedItem();
	            String classTimeh3 = (String) comboBox_2h3.getSelectedItem();
	            String classDayh3 = (String) comboBox_3h3.getSelectedItem();

	            System.out.println("Person Name: " + personNameh3);
	            System.out.println("Fitness Class: " + fitnessClassh3);
	            System.out.println("Class Time: " + classTimeh3);
	            System.out.println("Class Day: " + classDayh3);

	            boolean newRemoved = database.unenrollMember(personNameh3, fitnessClassh3, classTimeh3, classDayh3);

	            // Remove JLabel components from each panel in showMembers
	            String[] classes = {"Weight Loss Class", "Muscle Building Class", "Functional Fitness Class"};

	            int idxOfClass = -1;
	            for (int i = 0; i < classes.length; i++) {
	                if (fitnessClassh3.equals(classes[i])) {
	                    idxOfClass = i;
	                    break;
	                }
	            }

	            if (newRemoved && idxOfClass != -1) {
	                JPanel panel = showMembers[idxOfClass]; // Access the specific panel
	                
	                Component[] components = panel.getComponents();
	                List<Component> componentsToRemove = new ArrayList<>();

	                for (Component component : components) {
	                    if (component instanceof JLabel) {
	                        JLabel label = (JLabel) component;
	                        if (label.getText().equals(classDayh3) ||
	                                label.getText().equals(classTimeh3) ||
	                                label.getText().equals(personNameh3)) {
	                            componentsToRemove.add(label); // Add components to remove to a list
	                        }
	                    }
	                }

	                for (Component componentToRemove : componentsToRemove) {
	                    panel.remove(componentToRemove); // Remove specific components
	                }

	                panel.revalidate(); // Revalidate the panel
	                panel.repaint(); // Repaint the panel

	                JOptionPane.showMessageDialog(null, "Enrollment record successfully deleted.", "Success", JOptionPane.INFORMATION_MESSAGE);
	            }
 else {
	                JOptionPane.showMessageDialog(null, "Could not remove enrollment record.", "Error", JOptionPane.ERROR_MESSAGE);
	            }
	        }
	    });

		}
	}


