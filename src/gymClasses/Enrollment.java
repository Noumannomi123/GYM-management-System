package gymClasses;

public class Enrollment {
    private int classID;
    private String memberName; 
    private String timeOfDay;
    private String dayOfWeek;

    // Constructor
    public Enrollment(int classID, String memberName, String timeOfDay, String dayOfWeek) {
        this.classID = classID;
        this.memberName = memberName;
        this.timeOfDay = timeOfDay;
        this.dayOfWeek = dayOfWeek;
    }

    // Getters and Setters
    public int getClassID() {
        return classID;
    }

    public void setClassID(int classID) {
        this.classID = classID;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getTimeOfDay() {
        return timeOfDay;
    }

    public void setTimeOfDay(String timeOfDay) {
        this.timeOfDay = timeOfDay;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    @Override
    public String toString() {
        return "Enrollment{" +
                "classID=" + classID +
                ", memberName='" + memberName + '\'' +
                ", timeOfDay='" + timeOfDay + '\'' +
                ", dayOfWeek='" + dayOfWeek + '\'' +
                '}';
    }
}
