package mainwindows;

import java.awt.Color;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.Iterator;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.AbstractDocument;

import database.Database;

import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import gymClasses.Staff;
import utils.JTextFieldLimit;
import utils.NoSpaceDocumentFilter;
//import utils.NoSpaceDocumentFilter;
//import utils.Look;
public class AdminStaffInfo extends JFrame {

	List<Staff> staffList;
	private JPanel contentPane;
	private Database database;
	/**
	 * Launch the application.
	 */
	 private Color backgroundColor = new Color(32, 57, 122);
	 private Color foregroundColor = new Color(62, 85, 145);
	/**
	 * Create the frame.
	 */
	public AdminStaffInfo(Database database) {
		setConnection(database);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(203, 73, 968, 670);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        setResizable(false);
        contentPane.setLayout(null);
        
        JPanel panel_3 = new JPanel();
        panel_3.setBounds(0, 0, 968, 670);
        panel_3.setBackground(backgroundColor);
        contentPane.add(panel_3);
        panel_3.setLayout(null);
		
		JPanel reviewGPanel = new JPanel();
        reviewGPanel.setBounds(86,141,776,295);
        reviewGPanel.setBackground(foregroundColor);
        panel_3.add(reviewGPanel);
        reviewGPanel.setLayout(null);
        
        JButton addButton = new JButton("Add");

        addButton.setForeground(new Color(0, 0, 0));
        addButton.setFont(new Font("Open Sans", Font.BOLD, 20));
        addButton.setBounds(121, 205, 91, 46);
        reviewGPanel.add(addButton);
        
        JButton removeButton = new JButton("Remove");
        removeButton.setForeground(Color.BLACK);
        removeButton.setFont(new Font("Open Sans", Font.BOLD, 20));
        removeButton.setBounds(570, 205, 118, 46);
        reviewGPanel.add(removeButton);
        
        JLabel lblNewLabel_1_2 = new JLabel("User Name");
        lblNewLabel_1_2.setForeground(new Color(255, 255, 255));
        lblNewLabel_1_2.setFont(new Font("Open Sans", Font.BOLD, 20));
        lblNewLabel_1_2.setBounds(107, 84, 114, 46);
        reviewGPanel.add(lblNewLabel_1_2);
        
        JLabel lblNewLabel_1_2_1 = new JLabel("Email");
        lblNewLabel_1_2_1.setForeground(Color.WHITE);
        lblNewLabel_1_2_1.setFont(new Font("Open Sans", Font.BOLD, 20));
        lblNewLabel_1_2_1.setBounds(367, 84, 75, 46);
        reviewGPanel.add(lblNewLabel_1_2_1);
        
//        List<Staff> staffMembers = new ArrayList<>();
        
        JButton editButton = new JButton("Edit");
        editButton.setForeground(Color.BLACK);
        editButton.setFont(new Font("Open Sans", Font.BOLD, 20));
        editButton.setBounds(351, 205, 91, 46);
        reviewGPanel.add(editButton);
        
        JComboBox<String> comboBoxN = new JComboBox<>();
        comboBoxN.setBounds(298, 51, 183, 22);
        reviewGPanel.add(comboBoxN);
        comboBoxN.addItem("Select / Add New:");
        //Select / Add New:
        staffList = database.getStaffList2();
//        staffList.get(0).print();
        updateComboBox(comboBoxN, staffList);

        JTextField lblNewLabel = new JTextField();
        lblNewLabel.setForeground(new Color(0, 0, 0));
        lblNewLabel.setFont(new Font("Open Sans", Font.PLAIN, 16));
        lblNewLabel.setBounds(78, 140, 183, 35);
        lblNewLabel.setDocument(new JTextFieldLimit(10));  // Set JTextFieldLimit as the document
        ((AbstractDocument) lblNewLabel.getDocument()).setDocumentFilter(new NoSpaceDocumentFilter());
        reviewGPanel.add(lblNewLabel);

        JTextField emailTextField = new JTextField();
        emailTextField.setForeground(new Color(0, 0, 0));
        emailTextField.setFont(new Font("Open Sans", Font.PLAIN, 16));
        emailTextField.setBounds(324, 140, 183, 35);
        emailTextField.setDocument(new JTextFieldLimit(20));
        ((AbstractDocument) emailTextField.getDocument()).setDocumentFilter(new NoSpaceDocumentFilter());
        reviewGPanel.add(emailTextField);

        JTextField nameTextField = new JTextField();
        nameTextField.setForeground(new Color(0, 0, 0));
        nameTextField.setFont(new Font("Open Sans", Font.PLAIN, 16));
        nameTextField.setBounds(333+230, 141, 183, 35);
        nameTextField.setDocument(new JTextFieldLimit(20));  // Set JTextFieldLimit as the document

        reviewGPanel.add(nameTextField);
        comboBoxN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	// comboBoxN holds the userName of the Staff
                // Get the selected staff member's username
                String selectedUserName = comboBoxN.getSelectedItem().toString();
                // Find the selected Staff object from the list
                // userName is unique
                Staff selectedStaff = findStaffByUsername(staffList, selectedUserName);

                // Update the text fields with the selected staff member's details
                if (selectedStaff != null) {
                	// lblNewLabel is userName
                    lblNewLabel.setText(selectedStaff.getUserName());
                    emailTextField.setText(selectedStaff.getEmail());
                    nameTextField.setText(selectedStaff.getName());
                }
                else {
                    lblNewLabel.setText("");
                    emailTextField.setText("");
                    nameTextField.setText("");
                }
            }
        });

 
        JLabel lblNewLabel_1_2_1_1 = new JLabel("Select Staff Member:");
        lblNewLabel_1_2_1_1.setForeground(Color.WHITE);
        lblNewLabel_1_2_1_1.setFont(new Font("Open Sans", Font.BOLD, 20));
        lblNewLabel_1_2_1_1.setBounds(282, 11, 234, 35);
        reviewGPanel.add(lblNewLabel_1_2_1_1);
        
        JLabel lblNewLabel_1_2_1_2 = new JLabel("Name");
        lblNewLabel_1_2_1_2.setForeground(Color.WHITE);
        lblNewLabel_1_2_1_2.setFont(new Font("Open Sans", Font.BOLD, 20));
        lblNewLabel_1_2_1_2.setBounds(624, 84, 64, 46);
        reviewGPanel.add(lblNewLabel_1_2_1_2);
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedUserName = lblNewLabel.getText();
                String selectedEmail = emailTextField.getText();
                String selectedName = nameTextField.getText();
                String oldUserName = comboBoxN.getSelectedItem().toString();

                // Update the database first
                boolean databaseUpdateSuccess = database.updateStaff(oldUserName, selectedUserName, selectedEmail, selectedName);

                if (databaseUpdateSuccess) {
                    // If the database update is successful, retrieve the updated staff from the database
                	System.out.println("selec" + selectedName);
                    Staff updatedStaff = findStaffByUsername(staffList, oldUserName);
                    updatedStaff.setUserName(selectedUserName);
                    updatedStaff.setEmail(selectedEmail);
                    updatedStaff.setName(selectedName);

                    // Update the current fields
                    lblNewLabel.setText(updatedStaff.getUserName());
                    emailTextField.setText(updatedStaff.getEmail());
                    nameTextField.setText(updatedStaff.getName());
                } else {
                    // Handle database update failure, show an error message or take appropriate action
                    JOptionPane.showMessageDialog(null, "Failed to update staff information in the database.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        ///////////////............./////////
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userName = lblNewLabel.getText();
                String email = emailTextField.getText();
                String name = nameTextField.getText();
                // Check if a staff member is selected in the comboBox
                if(userName.length() < 10) {
                	if (!userName.isEmpty() && !email.isEmpty() && !name.isEmpty() && comboBoxN.getSelectedItem() == "Select / Add New:") {
                        // Existing staff member is selected, try to update
                        boolean updated = database.addNewStaff(userName, email,name);

                        // Check if the update was successful
                        if (updated) {
                            // Show a success dialogue box
                        	staffList.clear();
                        	staffList = database.getStaffList2();
                        	comboBoxN.addItem(userName);
                            JOptionPane.showMessageDialog(null, "Staff member updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            // Show an error dialogue box
                            JOptionPane.showMessageDialog(null, "Failed to update staff member. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        // Show an error dialogue box for empty fields
                        JOptionPane.showMessageDialog(null, "Name, Email, and Username fields cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null, "UserName length exceeds 10. Cant add.", "Error", JOptionPane.ERROR_MESSAGE);
                }
                
           }
        });
        //////..........................//////////
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userName = lblNewLabel.getText();
                String email = emailTextField.getText();
                String name = nameTextField.getText();
                boolean deleted = database.addRemoveStaff(userName);

                // Check if the update was successful
                if (deleted) {
                    // Show a success dialogue box
                	removeByUserName(staffList,userName);
                	comboBoxN.removeItem(userName);
                    JOptionPane.showMessageDialog(null, "Staff member removed successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    // Show an error dialogue box
                    JOptionPane.showMessageDialog(null, "Failed to remove staff member. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
                }
           }
        });
	}
	
	private void updateComboBox(JComboBox<String> comboBox,List<Staff> staffNames) {
        // Add the retrieved member names to the combo box
        for (Staff staffName : staffNames) {
            comboBox.addItem(staffName.getUserName());
        }
    }
	
	private Staff findStaffByUsername(List<Staff> staffList, String username) {
	    for (Staff staff : staffList) {
	    	if (staff.getUserName().equals(username)) {
	            return staff;
	        }
	    }
	    return null;
	}
	private void removeByUserName(List<Staff> staffList, String userName) {
	    Iterator<Staff> iterator = staffList.iterator();
	    while (iterator.hasNext()) {
	        Staff staff = iterator.next();
	        if (staff.getUserName().equals(userName)) {
	            iterator.remove();
	            break;  // Assuming there's only one staff member with the same userName
	        }
	    }
	}
	public void setConnection(Database database) {
		this.database = database;
	}
}
