package gymClasses;

public class HealthCarePro {
    int ID;
    String name;
    String email;

    public HealthCarePro(int ID, String name, String email) {
        this.ID = ID;
        this.name = name;
        this.email = email;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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
        System.out.println("Healthcare Professional Details:");
        System.out.println("ID: " + this.ID);
        System.out.println("Name: " + this.name);
        System.out.println("Email: " + this.email);
    }
}

