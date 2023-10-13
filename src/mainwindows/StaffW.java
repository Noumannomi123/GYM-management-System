package mainwindows;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;

import database.Database;
import gymClasses.Enrollment;
import utils.MenuMaker;

public class StaffW extends UserW {

	private Database database; 
	private JLabel Header;
	private JTextField textField;
	private JPanel panelAE;
	private int y = 20;

	public StaffW(Database database) {
		super();
		this.database = database;
		setTitle("Staff");
		panel_2.setBounds(0, 73, 203, 325);
		String[] buttonLabels = {
				"Home Page",
				"Equipment",
				"Fitness Classes",
				"Training Sessions",
				"",""
		};

		panelW = new JPanel[buttonLabels.length+2];

		for (int i = 0; i < buttonLabels.length + 2; i++) {
			panelW[i] = new JPanel();
			panelW[i].setBounds(203, 73, 968, 670);
			panelW[i].setBackground(backgroundColor);
			contentPane.add(panelW[i]);
			panelW[i].setLayout(null);
			panelW[i].setVisible(false);
		}
		// panelW[5] -> Rmmove Enrollment
		panelW[0].setVisible(true);
		newButtons = new JButton[buttonLabels.length];
		MenuMaker.makeMenu(buttonLabels, panel_2, titleLabel, panelW, newButtons);
		
		// panelW[i] shows the panel corresponding to buttonLabels[i]
		// panelW[3] ->Training sessions
		int widthW = panel_2.getWidth();
		int heightW = panel.getHeight() + 1;
		JPanel panel_3 = panelW[3];
		JPanel selectMPanel = new JPanel();
		selectMPanel.setBounds(76, 50, 365, 127);
		selectMPanel.setBackground(foregroundColor);
		panel_3.add(selectMPanel);
		selectMPanel.setLayout(null);

		JLabel selectMLabel = new JLabel("Select a Member:");
		selectMLabel.setBounds(30, 10, 311, 45);
		selectMLabel.setForeground(Color.WHITE);
		selectMLabel.setHorizontalAlignment(JLabel.CENTER);
		selectMLabel.setFont(new Font("Open Sans", Font.BOLD, 24));
		selectMPanel.add(selectMLabel);

		JComboBox<String> comboBox = new JComboBox<>();
		comboBox.setFont(new Font("Serif", Font.PLAIN, 18));
		comboBox.setBounds(102, 67, 157, 32);
		selectMPanel.add(comboBox);

		updateComboBox(comboBox);// adds the memberList to the box

		JPanel reviewGPanel = new JPanel();
		reviewGPanel.setBounds(522, 141, 365, 123);
		reviewGPanel.setBackground(foregroundColor);
		panel_3.add(reviewGPanel);
		reviewGPanel.setLayout(null);

		JButton btnNewButton = new JButton("Review Fitness Goals?");
		btnNewButton.setBounds(10, 10, 345, 103);
		btnNewButton.setForeground(foregroundColor);
		btnNewButton.setFont(new Font("Open Sans", Font.BOLD, 26));
		btnNewButton.setHorizontalAlignment(JButton.CENTER);
		reviewGPanel.add(btnNewButton);

		JPanel selectTSlot = new JPanel();
		selectTSlot.setBounds(76, 235, 359, 280);
		selectTSlot.setBackground(foregroundColor);
		panel_3.add(selectTSlot);
		selectTSlot.setLayout(null);

		JComboBox<String> comboBox_1 = new JComboBox<>();
		comboBox_1.setFont(new Font("Serif", Font.PLAIN, 18));
		comboBox_1.setBounds(111, 226, 167, 32);
		selectTSlot.add(comboBox_1);

		JLabel selectSLabel = new JLabel("Time: ");
		selectSLabel.setBounds(10, 223, 91, 33);
		selectSLabel.setForeground(Color.WHITE);
		selectSLabel.setHorizontalAlignment(JLabel.CENTER);
		selectSLabel.setFont(new Font("Open Sans", Font.BOLD, 24));
		selectTSlot.add(selectSLabel);

		JLabel selectSLabel_1 = new JLabel("Select Date: ");
		selectSLabel_1.setHorizontalAlignment(JLabel.CENTER);
		selectSLabel_1.setForeground(Color.WHITE);
		selectSLabel_1.setFont(new Font("Open Sans", Font.BOLD, 24));
		selectSLabel_1.setBounds(96, 22, 173, 19);
		selectTSlot.add(selectSLabel_1);

		Calendar calendar = Calendar.getInstance();

		SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM yyyy");

		JLabel monthLabel = new JLabel(dateFormat.format(calendar.getTime()));
		monthLabel.setHorizontalAlignment(JLabel.CENTER);
		selectTSlot.add(monthLabel);

		String[] columnNames = { "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat" };
		String[][] data = new String[6][7]; // Assuming a maximum of 6 rows

		int startDay = calendar.get(Calendar.DAY_OF_WEEK) - calendar.getFirstDayOfWeek();
		int maxDays = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		for (int day = 1, row = 0, col = startDay; day <= maxDays; day++, col++) {
			data[row][col % 7] = String.valueOf(day);
			if (col % 7 == 6) {
				row++;
			}
		}

		JTable table = new JTable(data, columnNames);
		table.setBounds(57, 51, 254, 146);
		table.setFont(new Font("Open Sans", Font.PLAIN, 16));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		DefaultTableCellRenderer cellRenderer = updateDateTable();
		deisgnTable(table, cellRenderer);

		selectTSlot.add(table.getTableHeader());
		selectTSlot.add(table);

		JButton btnNewButton_1 = new JButton("Scheulde?");
		btnNewButton_1.setFont(new Font("Open Sans", Font.PLAIN, 24));
		btnNewButton_1.setBounds(345, 548, 194, 40);
		panel_3.add(btnNewButton_1);

		// panel[2] ->Fitness Classes
		// Header
		JPanel panel_4 = panelW[2];
		panel_4.setVisible(false);
		// panel_1 = panel_4]
		JPanel panel_1H = new JPanel();
		panel_1H.setBounds(257, 27, 418, 56);
		panel_1H.setBackground(foregroundColor);
		panel_4.add(panel_1H);
		panel_1H.setLayout(null);

		JLabel Header = new JLabel();
		Header.setBounds(43, 13, 343, 24);
		Header.setForeground(new Color(255, 255, 255));
		Header.setHorizontalAlignment(JLabel.CENTER);
		Header.setText("Fitness Class Enrollment");
		Header.setBackground(foregroundColor);
		Header.setForeground(Color.WHITE);
		Header.setFont(new Font("Open Sans", Font.BOLD, 24));
		panel_1H.add(Header);

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(foregroundColor);
		panel_1_1.setBounds(64, 121, 827, 56);
		panel_4.add(panel_1_1);

		JLabel SelectClass = new JLabel();
		SelectClass.setText("Select the class to check the enrollments");
		SelectClass.setHorizontalAlignment(JLabel.CENTER);
		SelectClass.setForeground(Color.WHITE);
		SelectClass.setFont(new Font("Dialog", Font.BOLD, 20));
		SelectClass.setBackground(new Color(108, 130, 206));
		SelectClass.setBounds(25, 19, 416, 17);
		panel_1_1.add(SelectClass);

		JButton btnNewButtonH = new JButton("Done");
		btnNewButtonH.setFont(new Font("Dialog", Font.BOLD, 15));
		btnNewButtonH.setBounds(687, 17, 94, 25);
		panel_1_1.add(btnNewButtonH);

		// Drop Down(Combo box)
		JComboBox<String> comboBoxH = new JComboBox<>();
		comboBoxH.setBounds(449, 15, 210, 32);
		panel_1_1.add(comboBoxH);

		// Adding five options to the combo box
		comboBoxH.addItem("Select");
		comboBoxH.addItem("Weight Loss Class");
		comboBoxH.addItem("Muscle Building Class");
		comboBoxH.addItem("Functional Fitness Class");

		JPanel listofEnrollments = new JPanel();
		listofEnrollments.setLayout(null);
		listofEnrollments.setBackground(foregroundColor);
		listofEnrollments.setBounds(64, 197, 827, 356);
		panel_4.add(listofEnrollments);

		JLabel lblSelectTheClass_1 = new JLabel();
		lblSelectTheClass_1.setText("Following are the enrollments");
		lblSelectTheClass_1.setHorizontalAlignment(JLabel.CENTER);
		lblSelectTheClass_1.setForeground(Color.WHITE);
		lblSelectTheClass_1.setFont(new Font("Dialog", Font.BOLD, 20));
		lblSelectTheClass_1.setBackground(new Color(108, 130, 206));
		lblSelectTheClass_1.setBounds(20, 8, 322, 43);
		listofEnrollments.add(lblSelectTheClass_1);

		JLabel lableName = new JLabel("Member Name");
		lableName.setBounds(60, 40, 80, 80);
		lableName.setForeground(Color.WHITE);
		listofEnrollments.add(lableName);
		JLabel lableTime = new JLabel("Time of Day");
		lableTime.setBounds(220, 40, 80, 80);
		lableTime.setForeground(Color.WHITE);
		listofEnrollments.add(lableTime);
		JLabel lableDay = new JLabel("Day of Week");
		lableDay.setBounds(420, 40, 80, 80);
		lableDay.setForeground(Color.WHITE);
		listofEnrollments.add(lableDay);

		// new panel for enrollments list
		JPanel[] showMembers = new JPanel[3];
		for (int i = 0; i < 3; i++) {
			showMembers[i] = new JPanel();
			showMembers[i].setBounds(40, 50, 530, 280);
			showMembers[i].setBackground(backgroundColor);
			showMembers[i].setLayout(null);
			listofEnrollments.add(showMembers[i]);
			showMembers[i].setVisible(false);
		}

		// select item from comboBoxH
		List<List<Enrollment>> enrollmentsList = new ArrayList<>();
		String[] classes = {"Weight Loss Class", "Muscle Building Class", "Functional Fitness Class"};

		for (int i = 0; i < 3; i++) {
		    String selectedClass = classes[i];
		    List<Enrollment> enrollments = new ArrayList<>();
		    database.getEnrollments(enrollments, selectedClass);
		    enrollmentsList.add(enrollments);

		    y = 20;
		    for (Enrollment enroll : enrollments) {
		        JLabel lbl = new JLabel(enroll.getMemberName());
		        lbl.setBounds(20, y, 150, 80);
		        lbl.setForeground(Color.WHITE);
		        showMembers[i].add(lbl);

		        JLabel lb2 = new JLabel(enroll.getTimeOfDay());
		        lb2.setBounds(183, y, 150, 80);
		        lb2.setForeground(Color.WHITE);
		        showMembers[i].add(lb2);

		        JLabel lb3 = new JLabel(enroll.getDayOfWeek());
		        lb3.setBounds(380, y, 150, 80);
		        lb3.setForeground(Color.WHITE);
		        showMembers[i].add(lb3);

		        y = y + 30;
		    }
		}
		
		// enrollments.add()
		btnNewButtonH.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        Object selectedItem = comboBoxH.getSelectedItem();

		        if (selectedItem != null && !selectedItem.equals("Select")) {
		            // Find the index of the selected class in the classes array
		            int idxOfClass = -1;
		            for (int i = 0; i < classes.length; i++) {
		                if (selectedItem.equals(classes[i])) {
		                    idxOfClass = i;
		                    break;
		                }
		            }

		            if (idxOfClass != -1) {
		                // Hide all panels
		                for (int i = 0; i < showMembers.length; i++) {
		                    showMembers[i].setVisible(false);
		                }

		                // Show the panel corresponding to the selected class
		                showMembers[idxOfClass].setVisible(true);
		            } else {
		                System.out.println("Class not found in the array.");
		            }
		        } else {
		            System.out.println("No item selected");
		        }
		    }
		});

		// panel for Add Enrollment
		panelAE = new JPanel();
		panelW[4] = panelAE;
		panelAE.setBounds(203, 73, 968, 670);
		panelAE.setBackground(backgroundColor);
		contentPane.add(panelAE);
		panelAE.setLayout(null);
		panelAE.setVisible(false);
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(259, 46, 418, 64);
		panel_1.setBackground(new Color(108,130,206));
		panelAE.add(panel_1);
		panel_1.setLayout(null);
		
		Header = new JLabel();
		Header.setBounds(37, 15, 343, 29);
		panel_1.add(Header);
		Header.setForeground(new Color(255, 255, 255));
		Header.setHorizontalAlignment(JLabel.CENTER);
		Header.setText("Add Enrollment");
		Header.setBackground(new Color(108,130,206));
		Header.setForeground(Color.WHITE);
		Header.setFont(new Font("Open Sans", Font.BOLD, 24));
		
		JPanel panel_1_1h2 = new JPanel();
		panel_1_1h2.setBackground(new Color(108, 130, 206));
		panel_1_1h2.setBounds(87, 174, 472, 237);
		panelAE.add(panel_1_1h2);
		panel_1_1h2.setLayout(null);
		
		JLabel Header_1 = new JLabel();
		Header_1.setBounds(37, 24, 186, 32);
		Header_1.setText("Select Member:");
		Header_1.setHorizontalAlignment(JLabel.LEFT);
		Header_1.setForeground(Color.WHITE);
		Header_1.setFont(new Font("Dialog", Font.BOLD, 24));
		Header_1.setBackground(new Color(108, 130, 206));
		panel_1_1h2.add(Header_1);
		

		JComboBox<String> comboBox_4h2 = new JComboBox<>();
		List<String> members = database.getMemberList();
		for(String member: members) {
			comboBox_4h2.addItem(member);
		}
		comboBox_4h2.setBounds(231, 24, 191, 32);
		panel_1_1h2.add(comboBox_4h2);
		
		JLabel Header_1_1h2 = new JLabel();
		Header_1_1h2.setBounds(37, 74, 186, 32);
		Header_1_1h2.setText("Fitness Class:");
		Header_1_1h2.setHorizontalAlignment(JLabel.LEFT);
		Header_1_1h2.setForeground(Color.WHITE);
		Header_1_1h2.setFont(new Font("Dialog", Font.BOLD, 24));
		Header_1_1h2.setBackground(new Color(108, 130, 206));
		panel_1_1h2.add(Header_1_1h2);
		
		JComboBox<String> comboBoxh2 = new JComboBox<>();
		comboBoxh2.setBounds(231, 74, 191, 31);
		panel_1_1h2.add(comboBoxh2);
		// Adding three options to the combo box
		comboBoxh2.addItem("Select");
		comboBoxh2.addItem("Weight Loss Class");
		comboBoxh2.addItem("Muscle Building Class");
		comboBoxh2.addItem("Functional Fitness Class");
		
	
		
		JLabel Header_1_1_1h2 = new JLabel();
		Header_1_1_1h2.setBounds(37, 124, 230, 32);
		Header_1_1_1h2.setText("Class Time:");
		Header_1_1_1h2.setHorizontalAlignment(JLabel.LEFT);
		Header_1_1_1h2.setForeground(Color.WHITE);
		Header_1_1_1h2.setFont(new Font("Dialog", Font.BOLD, 24));
		Header_1_1_1h2.setBackground(new Color(108, 130, 206));
		panel_1_1h2.add(Header_1_1_1h2);
		
		JComboBox<String> comboBox_2h2 = new JComboBox<String>();
		comboBox_2h2.setBounds(231, 124, 191, 32);
		panel_1_1h2.add(comboBox_2h2);
		// Adding two options to the combo box
		comboBox_2h2.addItem("Select");
		comboBox_2h2.addItem("8:00 AM - 11:00 AM");
		comboBox_2h2.addItem("4:00 PM - 07:00 PM");
		comboBox_2h2.addItem("8:00 PM - 11:00 PM");
		
		
		
		
		JLabel Header_1_1_1_1h2 = new JLabel();
		Header_1_1_1_1h2.setBounds(37, 174, 179, 32);
		Header_1_1_1_1h2.setText("Class Day:");
		Header_1_1_1_1h2.setHorizontalAlignment(JLabel.LEFT);
		Header_1_1_1_1h2.setForeground(Color.WHITE);
		Header_1_1_1_1h2.setFont(new Font("Dialog", Font.BOLD, 24));
		Header_1_1_1_1h2.setBackground(new Color(108, 130, 206));
		panel_1_1h2.add(Header_1_1_1_1h2);
		
		JComboBox<Object> comboBox_3h2 = new JComboBox<Object>();
		comboBox_3h2.setBounds(231, 174, 191, 32);
		panel_1_1h2.add(comboBox_3h2);
		// Adding five options to the combo box
		comboBox_3h2.addItem(" Select");
	    comboBox_3h2.addItem(" Monday");
		comboBox_3h2.addItem(" Tuesday");
		comboBox_3h2.addItem(" Wednesday");
		comboBox_3h2.addItem(" Thursday");
		comboBox_3h2.addItem(" Friday");
		
		
		//SuccessfullyAdd
		JButton btnNewButtonh2 = new JButton("Add");
	
        // Add ActionListener to the button
        btnNewButtonh2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Retrieve data from components
                String personNameh2 = (String) comboBox_4h2.getSelectedItem();
                String fitnessClassh2 = (String) comboBoxh2.getSelectedItem();
                String classTimeh2 = (String) comboBox_2h2.getSelectedItem();
                String classDayh2 = (String) comboBox_3h2.getSelectedItem();

                
                System.out.println("Person Name: " + personNameh2);
                System.out.println("Fitness Class: " + fitnessClassh2);
                System.out.println("Class Time: " + classTimeh2);
                System.out.println("Class Day: " + classDayh2);
                Enrollment newAdded = database.enrollMember(personNameh2,fitnessClassh2,classTimeh2,classDayh2);
                Object selectedItem = comboBoxH.getSelectedItem();
                int idxOfClass = -1;
		        if (selectedItem != null && !selectedItem.equals("Select")) {
		            // Find the index of the selected class in the classes array
		            
		            for (int i = 0; i < classes.length; i++) {
		                if (selectedItem.equals(classes[i])) {
		                    idxOfClass = i;
		                    break;
		                }
		            }   
	            }
		        
                if (newAdded != null) {
                    JOptionPane.showMessageDialog(null, "Enrollment added successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                    List<Enrollment> enrolled = enrollmentsList.get(idxOfClass);
                    enrolled.add(newAdded);
                    Enrollment enroll = newAdded;
                    JLabel lbl = new JLabel(enroll.getMemberName());
    		        lbl.setBounds(20, y, 150, 80);
    		        lbl.setForeground(Color.WHITE);
    		        showMembers[idxOfClass].add(lbl);

    		        JLabel lb2 = new JLabel(enroll.getTimeOfDay());
    		        lb2.setBounds(183, y, 150, 80);
    		        lb2.setForeground(Color.WHITE);
    		        showMembers[idxOfClass].add(lb2);

    		        JLabel lb3 = new JLabel(enroll.getDayOfWeek());
    		        lb3.setBounds(380, y, 150, 80);
    		        lb3.setForeground(Color.WHITE);
    		        showMembers[idxOfClass].add(lb3);

    		        y = y + 30;
                    
                } else {
                    JOptionPane.showMessageDialog(null, "Enrollment not added", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
		btnNewButtonh2.setFont(new Font("Dialog", Font.BOLD, 20));
		btnNewButtonh2.setBounds(686, 225, 131, 97);
		btnNewButtonh2.setBackground(new Color(108,130,206));
		panelAE.add(btnNewButtonh2);
		
		
		JButton AddButton = new JButton("Add");
		AddButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelW[2].setVisible(false);
				panelAE.setVisible(true);
			}
		});
		AddButton.setFont(new Font("Dialog", Font.BOLD, 15));
		AddButton.setBounds(582, 18, 98, 27);
		listofEnrollments.add(AddButton);

		JButton RemoveButton = new JButton("Remove");
		RemoveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelW[2].setVisible(false);
				panelW[5].setVisible(true);
			}
		});
		RemoveButton.setFont(new Font("Dialog", Font.BOLD, 15));
		RemoveButton.setBounds(703, 18, 98, 27);
		listofEnrollments.add(RemoveButton);
		
		
		
		// panelW[5] -> RemoveEnrollment
		RemoveEnrollment frameE = new RemoveEnrollment();
		Container contentPane2 = frameE.getContentPane();
		
		panelW[5].add(frameE.getContentPane());
		for (Component component : contentPane2.getComponents()) {
            panelW[5].add(component);
        }
		frameE.getmembers(database);
		frameE.removemember(database,showMembers);
		//constrcutor end
	}

	private void updateComboBox(JComboBox<String> comboBox) {
		List<String> memberNames = database.getMemberList();

		// Clear the existing items in the combo box
		comboBox.removeAllItems();

		// Add the retrieved member names to the combo box
		for (String memberName : memberNames) {
			comboBox.addItem(memberName);
		}
	}

	private DefaultTableCellRenderer updateDateTable() {
		DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer() {
			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
					boolean hasFocus, int row, int column) {
				Component comp = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

				// Check if the cell is selected
				if (isSelected) {
					comp.setBackground(Color.WHITE); // You can use any color you prefer
				} else {
					comp.setBackground(table.getBackground());
				}

				return comp;
			}
		};
		return cellRenderer;
	}

	private void deisgnTable(JTable table, DefaultTableCellRenderer cellRenderer) {
		// Apply the custom cell renderer only to the selected cell
		table.setDefaultRenderer(Object.class, cellRenderer);

		table.setRowHeight(25);
		table.setRowMargin(5);
		table.setGridColor(Color.WHITE);
		table.setShowGrid(true);
		table.setShowVerticalLines(true);
		table.setShowHorizontalLines(true);
		table.setIntercellSpacing(new java.awt.Dimension(0, 0));
		table.setColumnSelectionAllowed(false);
		table.setCellSelectionEnabled(false);
		table.setFillsViewportHeight(true);
		table.setDragEnabled(false);
		table.setRowSelectionAllowed(true);
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setRowSelectionAllowed(true);
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setRowSelectionAllowed(true);
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setRowSelectionAllowed(true);
		table.setColumnSelectionAllowed(true);
		// Add a ListSelectionListener to capture the selected value
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					// Get the selected row and column
					int selectedRow = table.getSelectedRow();
					int selectedColumn = table.getSelectedColumn();

					// Get the value from the selected cell
					Object selectedValue = table.getValueAt(selectedRow, selectedColumn);

					// Display or use the selected value as needed
					System.out.println("Selected Value: " + selectedValue);
				}
			}
		});
	}


}
