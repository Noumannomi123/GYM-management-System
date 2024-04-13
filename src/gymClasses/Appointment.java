package gymClasses;

public class Appointment {
    int HCID;
    String date;
    String time;
    HealthCarePro professional;

    public Appointment(int HCID, String date, String time, HealthCarePro professional) {
        this.HCID = HCID;
        this.date = date;
        this.time = time;
        this.professional = professional;
    }

    public int getHCID() {
        return HCID;
    }

    public void setHCID(int HCID) {
        this.HCID = HCID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public HealthCarePro getProfessional() {
        return professional;
    }

    public void setProfessional(HealthCarePro professional) {
        this.professional = professional;
    }

    public void print() {
        System.out.println("Appointment Details:");
        System.out.println("Healthcare ID: " + this.HCID);
        System.out.println("Date: " + this.date);
        System.out.println("Time: " + this.time);
        System.out.println("Healthcare Professional Details:");
        if (professional != null) {
            professional.print();
        }
    }
}
