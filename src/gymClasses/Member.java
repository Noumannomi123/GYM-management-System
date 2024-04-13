package gymClasses;

public class Member extends User{
    private String medicalCondition;

    public Member(int ID, String userName, String email, String name, String medicalCondition) {
        this.userID = ID;
        this.userName = userName;
        this.email = email;
        this.name = name;
        this.medicalCondition = medicalCondition;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
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

    public String getMedicalCondition() {
        return medicalCondition;
    }

    public void setMedicalCondition(String medicalCondition) {
        this.medicalCondition = medicalCondition;
    }

    public void print() {
        System.out.println("Member Details:");
        System.out.println("User ID: " + this.userID);
        System.out.println("Username: " + this.userName);
        System.out.println("Name: " + this.name);
        System.out.println("Email: " + this.email);
        System.out.println("Medical Condition: " + this.medicalCondition);
    }
}

