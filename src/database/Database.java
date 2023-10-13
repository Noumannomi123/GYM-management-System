package database;

import java.security.SecureRandom;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import gymClasses.Appointment;
import gymClasses.Enrollment;
import gymClasses.HealthCarePro;
import gymClasses.Staff;


public class Database {
	Connection connection = null;
	
	public Database() {
		connectDB();
	}
	
	private void connectDB() {
		String URL = "jdbc:mysql://localhost:3306/gym";
		String username = "nouman";
		String password ="123";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(URL,username,password);
			System.out.println("Connection established.");
		}
		catch(Exception e) {
			System.out.println(e);
			System.out.println("Please try again.");
		}
	}
	
	public boolean verifyLogin(String username, String usertype, char[] pass) {
	    String password = new String(pass);
	    try {
	        String query = "SELECT * FROM UserLogin WHERE UserName = ? AND UserType = ?";
	        PreparedStatement preparedStatement = connection.prepareStatement(query);
	        preparedStatement.setString(1, username);
	        preparedStatement.setString(2, usertype);
	        ResultSet rs = preparedStatement.executeQuery();

	        if (rs.next()) {
	            String storedPassword = rs.getString("Password");
	            if (password.equals(storedPassword)) {
	                return true;
	            }
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	        System.out.println("Connection Failed. Check if Apache and MySql features are opened in Xampp Control Panel."
	        		+ "\nRestart the application after starting the services.");
	    }
	    return false;
	}
	public List<String> getMemberList() {
        List<String> memberNames = new ArrayList<>();

        try {
            String query = "SELECT UserName FROM Member";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String userName = rs.getString("UserName");
                memberNames.add(userName);
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Connection Failed. Check if Apache and MySql features are opened in Xampp Control Panel."
                    + "\nRestart the application after starting the services.");
        }

        return memberNames;
    }
	
	
	
	
	
	public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	public boolean updateStaff(String oldUserName, String newUserName, String newEmail, String newName) {
	    int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to update this staff member?", "Confirmation", JOptionPane.YES_NO_OPTION);
	    
	    if (option == JOptionPane.YES_OPTION) {
	        try {
	            // Update userlogin table first
	            String userLoginUpdateQuery = "UPDATE userlogin SET UserName = ? WHERE UserName = ? AND UserType = 'Staff'";
	            PreparedStatement userLoginPreparedStatement = connection.prepareStatement(userLoginUpdateQuery);

	            // Set the parameters for the userlogin update query
	            userLoginPreparedStatement.setString(1, newUserName);
	            userLoginPreparedStatement.setString(2, oldUserName);

	            // Execute the userlogin update query
	            int userLoginRowsUpdated = userLoginPreparedStatement.executeUpdate();

	            if (userLoginRowsUpdated > 0) {
	                // Update Staff table for Email and Name
	                String staffUpdateQuery = "UPDATE Staff SET Email = ?, Name = ? WHERE UserName = ?";
	                PreparedStatement staffPreparedStatement = connection.prepareStatement(staffUpdateQuery);

	                // Set the parameters for the Staff update query
	                staffPreparedStatement.setString(1, newEmail);
	                staffPreparedStatement.setString(2, newName);
	                staffPreparedStatement.setString(3, newUserName);

	                // Execute the Staff update query
	                int staffRowsUpdated = staffPreparedStatement.executeUpdate();

	                if (staffRowsUpdated > 0) {
	                    JOptionPane.showMessageDialog(null, "Staff updated successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
	                    return true;
	                } else {
	                    JOptionPane.showMessageDialog(null, "Staff update failed. No matching record found in the Staff table.", "Error", JOptionPane.ERROR_MESSAGE);
	                }
	            } else {
	                JOptionPane.showMessageDialog(null, "Staff update failed. No matching record found in the userlogin table.", "Error", JOptionPane.ERROR_MESSAGE);
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	            JOptionPane.showMessageDialog(null, "Error updating staff. Check your SQL query.", "Error", JOptionPane.ERROR_MESSAGE);
	        }
	    } else {
	        JOptionPane.showMessageDialog(null, "Update canceled by user.", "Canceled", JOptionPane.INFORMATION_MESSAGE);
	    }
	    return false;
	}

	public boolean addNewStaff(String userName, String email, String name) {
		String password = generateRandomPassword(8);
	    // Insert into userlogin table
		if (insertIntoUserLogin(userName, password)) {
		    // If successful, update the Staff table
		    if (updateStaffTable(userName, email,name)) {
		        JOptionPane.showMessageDialog(null, "Staff member added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
		        return true;
		    }
		}

		// If not successful, show an error dialogue box
		JOptionPane.showMessageDialog(null, "Failed to add staff member. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
		return false;
	}

	private boolean insertIntoUserLogin(String userName, String password) {
	    String query = "INSERT INTO userlogin VALUES (?, 'Staff', ?)";
	    try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	        System.out.println(userName + " " + password);
	        preparedStatement.setString(1, userName);
	        preparedStatement.setString(2, password);

	        int rowsAffected = preparedStatement.executeUpdate();

	        if (rowsAffected > 0) {
	            System.out.println("Inserted into userlogin successfully.");
	            return true;
	        } else {
	            System.out.println("Failed to insert into userlogin. No rows affected.");
	            return false;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        System.out.println("SQLException: " + e.getMessage());
	        return false;
	    }
	}


	private boolean updateStaffTable(String userName, String email, String name) {
	    String query = "UPDATE Staff SET Email = ?, Name = ? WHERE UserName = ?";
	    try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	        preparedStatement.setString(1, email);
	        preparedStatement.setString(2, name);
	        preparedStatement.setString(3, userName);
	        int rowsAffected = preparedStatement.executeUpdate();

	        if (rowsAffected > 0) {
	            System.out.println("Updated Staff table successfully.");
	            return true;
	        } else {
	            System.out.println("Failed to update Staff table. No rows affected.");
	            return false;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        System.out.println("SQLException: " + e.getMessage());
	        return false;
	    }
	}

	public static String generateRandomPassword(int length) {
        String allowedChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        SecureRandom random = new SecureRandom();

        StringBuilder password = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(allowedChars.length());
            char randomChar = allowedChars.charAt(randomIndex);
            password.append(randomChar);
        }

        return password.toString();
    }
	
	public boolean addRemoveStaff(String userName) {
	    int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to remove this staff member?", "Confirmation", JOptionPane.YES_NO_OPTION);

	    if (option == JOptionPane.YES_OPTION) {
	        try {
	            // Delete from the Staff table
	            String staffDeleteQuery = "DELETE FROM userlogin WHERE UserName = ?";
	            PreparedStatement staffDeletePreparedStatement = connection.prepareStatement(staffDeleteQuery);

	            // Set the parameter for the delete query
	            staffDeletePreparedStatement.setString(1, userName);

	            // Execute the delete query
	            int staffRowsDeleted = staffDeletePreparedStatement.executeUpdate();

	            if (staffRowsDeleted > 0) {
	                // Display a dialog box with the "Removed successfully" message
	                JOptionPane.showMessageDialog(null, "Staff removed successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
	                return true;
	            } else {
	                JOptionPane.showMessageDialog(null, "Staff removal failed. No matching record found in the Staff table.", "Error", JOptionPane.ERROR_MESSAGE);
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	            JOptionPane.showMessageDialog(null, "Error removing staff. Check your SQL query.", "Error", JOptionPane.ERROR_MESSAGE);
	        }
	    } else {
	        JOptionPane.showMessageDialog(null, "Removal canceled by user.", "Canceled", JOptionPane.INFORMATION_MESSAGE);
	    }
	    return false;
	}
	
	public int getMemberID(String memberUserName) {	
	    int memberID = -1;

	    try {
	        String query = "SELECT MemberID FROM Member WHERE UserName = ?";
	        
	        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	            preparedStatement.setString(1, memberUserName);

	            try (ResultSet resultSet = preparedStatement.executeQuery()) {
	                if (resultSet.next()) {
	                    memberID = resultSet.getInt("MemberID");
	                }
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return memberID;
	}

	public List<Appointment> getAppointmentsList(String memberUserName) {
	    List<Appointment> appointmentsList = new ArrayList<>();
	    int memberID = getMemberID(memberUserName);

	    try {
	        String query = "SELECT * FROM Appointments WHERE memberID = ?";

	        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	            preparedStatement.setInt(1, memberID);

	            try (ResultSet resultSet = preparedStatement.executeQuery()) {
	                while (resultSet.next()) {
	                    int hcid = resultSet.getInt("HCID");
	                    String date = resultSet.getString("Date");
	                    String time = resultSet.getString("Time");

	                    // Fetch Healthcare Professional details using the getHealthCarePro function
	                    HealthCarePro professional = getHealthCarePro(hcid);

	                    // Create an Appointment object with the fetched healthcare professional
	                    Appointment appointment = new Appointment(hcid, date, time, professional);
	                    appointmentsList.add(appointment);
	                }
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return appointmentsList;
	}

	// Function to fetch Healthcare Professional details based on ID
	private HealthCarePro getHealthCarePro(int professionalID) {
	    HealthCarePro professional = null;
	    try {
	        String query = "SELECT * FROM healthcarepro WHERE ID = ?";
	        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	            preparedStatement.setInt(1, professionalID);

	            try (ResultSet resultSet = preparedStatement.executeQuery()) {
	                if (resultSet.next()) {
	                    // Assuming HealthCarePro has a constructor
	                    professional = new HealthCarePro(
	                            resultSet.getInt("ID"),
	                            resultSet.getString("Name"),
	                            resultSet.getString("Email")
	                    );
	                }
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return professional;
	}

	public List<HealthCarePro> getHealthCareProList() {
	    List<HealthCarePro> pros = new ArrayList<>();

	    try {
	        String query = "SELECT * FROM healthcarepro";
	        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
	             ResultSet resultSet = preparedStatement.executeQuery()) {
	            while (resultSet.next()) {
	                int id = resultSet.getInt("ID");
	                String name = resultSet.getString("Name");
	                String email = resultSet.getString("Email");

	                // Assuming you have a constructor for the HealthCarePro class
	                HealthCarePro pro = new HealthCarePro(id, name, email);
	                pros.add(pro);
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return pros;
	}
	public boolean setAppointment(String userName, HealthCarePro selectedPro, String date, String time) {
        int memberID = getMemberID(userName);
        int hcID = selectedPro.getID();
        date = "2023-"+"11-" + date;
        try {
            String query = "INSERT INTO appointments (HCID, memberID, Time, Date) VALUES (?, ?, ?, ?)";
            
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, hcID);
                preparedStatement.setInt(2, memberID);
                preparedStatement.setString(3, time);
                preparedStatement.setString(4, date);

                // Execute the query
                int rowsAffected = preparedStatement.executeUpdate();

                // Check if the appointment was successfully added
                return rowsAffected > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your needs
        }

        // Return false in case of any exception or failure
        return false;
    }
	
	public int getHCID(String name) {
        int ID = -1;
        String query = "SELECT ID FROM healthcarepro WHERE Name = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, name);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    ID = resultSet.getInt("ID");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception in a way that makes sense for your application
        }

        return ID;
    }
	
	public boolean removeAppointment(String userName, String selectedPro) {
        int hcID = getHCID(selectedPro);
        int memberID = getMemberID(userName);

        // Ask the user for confirmation
        int confirmDialogResult = JOptionPane.showConfirmDialog(null,
                "Are you sure you want to remove the appointment?",
                "Confirm Appointment Removal",
                JOptionPane.YES_NO_OPTION);

        if (confirmDialogResult != JOptionPane.YES_OPTION) {
            // User chose not to remove the appointment
            return false;
        }

        try {
            String query = "DELETE FROM appointments WHERE HCID = ? AND memberID = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, hcID);
                preparedStatement.setInt(2, memberID);

                // Execute the DELETE query
                int affectedRows = preparedStatement.executeUpdate();

                // Check if any rows were affected
                return affectedRows > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception in a way that makes sense for your application
            return false; // Indicate that the removal was not successful
        }
    }
	
	public boolean setGoal(String userName, String goal) {
        int memberID = getMemberID(userName);
        try {
            String query = "UPDATE fitnessgoals SET GoalName = ? WHERE MemberID = ?";
            
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, goal);
                preparedStatement.setInt(2, memberID);

                // Execute the update
                int rowsAffected = preparedStatement.executeUpdate();

                // Check if the update was successful
                return rowsAffected > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle or log the exception as needed
            return false; // Return false to indicate failure
        }
    }
	public List<String> getStaffList() {
        List<String> staffUserNames = new ArrayList<>();

        try {
            String query = "SELECT UserName FROM Staff";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String userName = rs.getString("UserName");
                staffUserNames.add(userName);
            }

            // Don't close the connection here if you plan to use it elsewhere in your application.
            // connection.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Connection Failed. Check if Apache and MySql features are opened in Xampp Control Panel."
                    + "\nRestart the application after starting the services.");
        }

        return staffUserNames;
    }
	
	public String[] getStaffDetails(String userName) {
        String[] details = new String[2]; // Array to store email and phone

        try {
            String query = "SELECT Name, Email FROM Staff WHERE UserName = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, userName);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                details[0] = rs.getString("Name");
                details[1] = rs.getString("Email");
            }

            // Don't close the connection here if you plan to use it elsewhere in your application.
            // connection.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Connection Failed. Check if Apache and MySql features are opened in Xampp Control Panel."
                    + "\nRestart the application after starting the services.");
        }

        return details;
    }
	public void getEnrollments(List<Enrollment> enrollments, String className) {
	        try {
	            // Step 1: Get classID based on className
	            String classIDQuery = "SELECT ID FROM class WHERE Name = ?";
	            PreparedStatement classIDStatement = connection.prepareStatement(classIDQuery);
	            classIDStatement.setString(1, className);
	            ResultSet classIDResult = classIDStatement.executeQuery();

	            if (classIDResult.next()) {
	                int classID = classIDResult.getInt("ID");

	                // Step 2: Get enrollments based on classID
	                String enrollmentsQuery = "SELECT member.Name, enrollment.timeOfDay, enrollment.dayOfWeek " +
	                        "FROM member " +
	                        "INNER JOIN enrollment ON member.MemberID = enrollment.memberID " +
	                        "INNER JOIN class ON class.ID = enrollment.classID " +
	                        "WHERE class.ID = ?";
	                
	                PreparedStatement enrollmentsStatement = connection.prepareStatement(enrollmentsQuery);
	                enrollmentsStatement.setInt(1, classID);

	                ResultSet rs = enrollmentsStatement.executeQuery();

	                while (rs.next()) {
	                    String memberName = rs.getString("Name");
	                    String timeOfDay = rs.getString("timeOfDay");
	                    String dayOfWeek = rs.getString("dayOfWeek");

	                    Enrollment enrollment = new Enrollment(classID, memberName, timeOfDay, dayOfWeek);
	                    enrollments.add(enrollment);
	                }
	            } else {
	                System.out.println("Class not found for className: " + className);
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	            System.out.println("Error retrieving enrollments: " + e.getMessage());
	        }
	    }
	
	 public Enrollment enrollMember(String name, String className, String time, String day) {
	        // Step 1: Get memberID from the member table
	        int memberID = getMemberID(name);
	        
	        if (memberID == -1) {
	            // Member not found
	        	return null;
	        }

	        // Step 2: Get classID from the class table
	        int classID = getClassID(className);

	        if (classID == -1) {
	            // Class not found
	            return null;
	        }
	        // Step 3: Insert enrollment record into the enrollment table
	        if(insertEnrollmentRecord(classID, memberID, day, time));
	        	return new Enrollment(classID,name,time,day);
	    }
	 
	 public boolean unenrollMember(String name, String className, String time, String day) {
	        // Step 1: Get memberID from the member table
	        int memberID = getMemberID(name);
//	        System.out.println(classID  + " " + memberID + " " + day + " " + time);
	        if (memberID == -1) {
	        	System.out.println("In database" + name);
	            // Member not found
	        	return false;
	        }

	        // Step 2: Get classID from the class table
	        int classID = getClassID(className);

	        if (classID == -1) {
	            // Class not found
	            return false;
	        }
	        // Step 3: remove enrollment record from the enrollment table
	        if(deleteEnrollmentRecord(classID, memberID));
	        	return true;
	    }

		private int getClassID(String className) {
		    try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT ID FROM Class WHERE Name = ?")) {
		        preparedStatement.setString(1, className);

		        try (ResultSet resultSet = preparedStatement.executeQuery()) {
		            if (resultSet.next()) {
		                return resultSet.getInt("ID");
		            }
		        }

		    } catch (SQLException e) {
		        e.printStackTrace();
		    }

		    return -1; // Return -1 if class not found or an error occurs
		}


	    private boolean insertEnrollmentRecord(int classID, int memberID, String day, String time) {
	        try (PreparedStatement preparedStatement = connection.prepareStatement(
	                "INSERT INTO Enrollment (classID, memberID, dayOfWeek, timeOfDay) VALUES (?, ?, ?, ?)")) {

	            preparedStatement.setInt(1, classID);
	            preparedStatement.setInt(2, memberID);
	            preparedStatement.setString(3, day);
	            preparedStatement.setString(4, time);

	            int rowsAffected = preparedStatement.executeUpdate();
	            return rowsAffected > 0; // Return true if at least one row is affected

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return false; // Return false if an error occurs
	    }
	    private boolean deleteEnrollmentRecord(int classID, int memberID) {
	        try (PreparedStatement preparedStatement = connection.prepareStatement(
	                "DELETE FROM Enrollment where classID = ? AND memberID = ?")) {

	            preparedStatement.setInt(1, classID);
	            preparedStatement.setInt(2, memberID);

	            int rowsAffected = preparedStatement.executeUpdate();
	            return rowsAffected > 0; // Return true if at least one row is affected

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return false; // Return false if an error occurs
	    }
	    public List<Staff> getStaffList2() {
	        List<Staff> staffList = new ArrayList<>();

	        try {
	            String query = "SELECT StaffID, UserName, Name, Email FROM Staff";
	            PreparedStatement preparedStatement = connection.prepareStatement(query);
	            ResultSet rs = preparedStatement.executeQuery();

	            while (rs.next()) {
	                int staffID = rs.getInt("StaffID");
	                String userName = rs.getString("UserName");
	                String email = rs.getString("Email");
	                String name = rs.getString("Name");
	                
	                // Create a Staff object and add it to the list
	                Staff staff = new Staff(staffID, userName, email,name);
	                staffList.add(staff);
	            }

	            // Don't close the connection here if you plan to use it elsewhere in your application.
	            // connection.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	            System.out.println("Connection Failed. Check if Apache and MySql features are opened in Xampp Control Panel."
	                    + "\nRestart the application after starting the services.");
	        }

	        return staffList;
	    }
}

