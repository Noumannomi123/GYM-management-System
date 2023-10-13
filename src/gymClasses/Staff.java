package gymClasses;

import java.util.List;
import database.Database;
public class Staff extends User{
    
    public Staff(int ID,String userName,String email,String name){
        this.userID = ID;
        this.userName = userName;
        this.email = email;
        this.name = name;
    }
    
    public int getStaffID() {
        return userID;
    }

    public void setStaffID(int staffID) {
        this.userID = staffID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public void print() {
        System.out.println("Staff Details:");
        System.out.println("Username: " + this.userName);
        System.out.println("Name: " + this.name);
        System.out.println("Email: " + this.email);
    }

}
