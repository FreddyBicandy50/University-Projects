package Project;

public class DayShift extends Nurse{
    // Variables
    private String Date, Time;

    // Default Constructor
    public DayShift() {
        super();
        Time="";
        Date="";
    }

    // paramitarized Constructor
    public DayShift(String name, String age, int id, String Department, String Time, String Date) {
        super(name, age, id, Department);
        this.Date = Date;
        this.Time = Time;
    }

    // getters
    public String getTime() {return this.Time;}

    public String getDate() {return this.Date;}

    // setters
    public void setTime(String Time) {this.Time = Time;} 
    public void setDate(String Date) {this.Date = Date;}

    // priting
    public String print_dayshift() {
        return super.print_nurse() + "\nDate:" + this.Date + "\nTime:" + this.Time;
    }

}
