package database;

import java.sql.*;

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

	        connection.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	        System.out.println("Exception occurred");
	    }
	    return false;
	}

}

