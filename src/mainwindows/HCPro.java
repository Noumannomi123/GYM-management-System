package mainwindows;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import database.Database;
import gymClasses.Appointment;
import gymClasses.HealthCarePro;

import javax.swing.JButton;
import javax.swing.JComboBox;

public class HCPro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Database database;
	private List<Appointment> appointments;
	private List<HealthCarePro> hcpros;
	private JTable appointmentsTable;
    private DefaultTableModel tableModel;
    private Color backgroundColor = new Color(32, 57, 122);
	private Color foregroundColor = new Color(62, 85, 145);
	private JComboBox<String> timeComboBox = new JComboBox<>();
    private JComboBox<Integer> dateComboBox = new JComboBox<>();
    private Object selectedPro = null;
	

	public HCPro(Database database) {
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
        reviewGPanel.setBounds(36,44,877,504);
        reviewGPanel.setBackground(foregroundColor);
        panel_3.add(reviewGPanel);
        reviewGPanel.setLayout(null);
        
        JButton addButton = new JButton("Add");
        addButton.setForeground(new Color(0, 0, 0));
        addButton.setFont(new Font("Open Sans", Font.BOLD, 20));
        addButton.setBounds(537, 100, 91, 46);
        reviewGPanel.add(addButton);
        
        JButton removeButton = new JButton("Remove");
        removeButton.setForeground(Color.BLACK);
        removeButton.setFont(new Font("Open Sans", Font.BOLD, 20));
        removeButton.setBounds(721, 100, 118, 46);
        reviewGPanel.add(removeButton);
        
        JLabel lblAppointmentsList = new JLabel("Appointments List");
        lblAppointmentsList.setForeground(Color.WHITE);
        lblAppointmentsList.setFont(new Font("Open Sans", Font.BOLD, 32));
        lblAppointmentsList.setBounds(23, 11, 328, 46);
        reviewGPanel.add(lblAppointmentsList);
        
        
        JLabel lblSelectMember = new JLabel("Select member:");
        lblSelectMember.setForeground(Color.WHITE);
        lblSelectMember.setFont(new Font("Open Sans", Font.BOLD, 22));
        lblSelectMember.setBounds(361, 22, 174, 46);
        reviewGPanel.add(lblSelectMember);
        
        JComboBox<String> comboBox = new JComboBox<>();
        comboBox.setBounds(545, 33, 148, 22);
        reviewGPanel.add(comboBox);
        
        String select = "Select:";
        comboBox.addItem(select);
        
        List<String> memberUserNames = database.getMemberList();
        for(String member: memberUserNames) {
        	comboBox.addItem(member);
        }
        
        // Initialize the table and table model
        initializeTable();

        // Add the table to your panel
        JScrollPane scrollPane = new JScrollPane(appointmentsTable);
        scrollPane.setBounds(10, 100, 500, 346); // Adjust the bounds accordingly
        reviewGPanel.add(scrollPane);
        
        // get appointements list
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	String userName = comboBox.getSelectedItem().toString();
            	appointments = database.getAppointmentsList(userName);
            	updateAppointmentsTable(appointments);
            }
        });
        hcpros = database.getHealthCareProList();
        LocalDateTime currentDate = LocalDateTime.now();
        int dayOfMonth = currentDate.getDayOfMonth();
        
        for(int i = dayOfMonth; i < 30; i++)
        	dateComboBox.addItem(i);
        
        String[]times = {"10:00 AM", "01:00 PM", "04:00 PM"};
        for(String time: times)
        	timeComboBox.addItem(time);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userName = comboBox.getSelectedItem().toString();

                // Create an array of HealthCarePro names for the dropdown
                String[] proNames = hcpros.stream().map(HealthCarePro::getName).toArray(String[]::new);

                // Show a dialog with a dropdown to select a HealthCarePro
                String selectedProName = (String) JOptionPane.showInputDialog(
                        HCPro.this,
                        "Select a HealthCarePro:",
                        "Choose HealthCarePro",
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        proNames,
                        proNames[0] // Default selection
                );
                if (userName != select) {
                int date = JOptionPane.showOptionDialog(
                		HCPro.this,
                        dateComboBox,
                        "Select Date:",
                        JOptionPane.OK_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        null,
                        null);
                int time = JOptionPane.showOptionDialog(
                		HCPro.this,
                        timeComboBox,
                        "Select Time:",
                        JOptionPane.OK_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        null,
                        null);
                
                
                
                    if (selectedProName != null) {
                        // Find the selected HealthCarePro based on the name
                        HealthCarePro selectedPro = hcpros.stream()
                                .filter(pro -> pro.getName().equals(selectedProName))
                                .findFirst()
                                .orElse(null);

                        if (selectedPro != null) {
                            // Get selected date from date combo box
                            String selectedDate = dateComboBox.getSelectedItem().toString();

                            // Get selected time from combo box
                            String selectedTime = timeComboBox.getSelectedItem().toString();

                            // Call database to set the appointment
                            boolean added = database.setAppointment(userName, selectedPro, selectedDate, selectedTime);
                            if(added) {
                                JOptionPane.showMessageDialog(null, "Appointed successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                            }
                            else {
                                JOptionPane.showMessageDialog(null, "Failed to appoint.", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                            // Update the appointmentsTable or perform any other necessary actions
                            // (You might need to fetch the updated appointments list and refresh the table)
                            appointments = database.getAppointmentsList(userName);
                            updateAppointmentsTable(appointments);
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Select a valid member first!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
//        removeButton.
        
        appointmentsTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent event) {
                // Check if the selection is not adjusting (to avoid firing the event twice)
                if (!event.getValueIsAdjusting()) {
                    // Get the selected row and column index
                    int selectedRow = appointmentsTable.getSelectedRow();
                    int nameColumnIndex = getColumnIndexByName("Name");

                    // Ensure that a valid row is selected
                    if (selectedRow != -1) {
                        // Get the data from the "Name" column in the selected row
                        selectedPro = appointmentsTable.getValueAt(selectedRow, nameColumnIndex);
                        
                        System.out.println(selectedPro);
                        
                    }
                }
            }
        });
       
        removeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
		        if(selectedPro != null) {            		
		    		String userName = comboBox.getSelectedItem().toString();
		    		boolean removed = database.removeAppointment(userName,selectedPro.toString());
		    		if (removed) {
		    			// Removal was successful
		    			Runnable updateTableCallback = () -> {
		                    for (int i = 0; i < tableModel.getRowCount(); i++) {
		                        if (selectedPro.equals(tableModel.getValueAt(i, 0))) {
		                            tableModel.removeRow(i);
		                            break;
		                        }
		                    }
		                };
	                    updateTableCallback.run();
		    			JOptionPane.showMessageDialog(null, "Appointment removed successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
		    		} else {
		    			// Removal failed
		    			JOptionPane.showMessageDialog(null, "Failed to remove appointment.", "Error", JOptionPane.ERROR_MESSAGE);
		    		}
		    	}
		    	else {
		            JOptionPane.showMessageDialog(null, "Select a valid appointment from the table first!", "Error", JOptionPane.ERROR_MESSAGE);
		    	}
			}
        	
        });

	}
	 private void initializeTable() {
		 String[] columnNames = {"Name", "Date", "Time"};
    	tableModel = new DefaultTableModel(columnNames, 0);
    	appointmentsTable = new JTable(tableModel);
	 }

private void updateAppointmentsTable(List<Appointment> appointments) {
    // Clear the existing rows in the table
    tableModel.setRowCount(0);
    ((DefaultTableCellRenderer) appointmentsTable.getDefaultRenderer(Object.class)).setOpaque(false);

    // Iterate through the appointments and add rows to the table
    for (Appointment appointment : appointments) {
        Object[] rowData = {
                appointment.getProfessional().getName(),
                appointment.getDate(),
                appointment.getTime()
        };
        tableModel.addRow(rowData);
    }
}
private int getColumnIndexByName(String columnName) {
    for (int i = 0; i < appointmentsTable.getColumnCount(); i++) {
        if (columnName.equals(appointmentsTable.getColumnName(i))) {
            return i;
        }
    }
    return -1; // Return -1 if the column is not found
}
	public void setConnection(Database database) {
		this.database = database;
	}
}
