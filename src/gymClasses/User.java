package gymClasses;

import database.Database;

public class User {
	protected int userID;
	protected String userName;
	protected String email;
	protected String name;
	public Boolean login(String username,String uType, char []password) {
    	Database db = new Database();
		return db.verifyLogin(username, uType, password);
	}
}
