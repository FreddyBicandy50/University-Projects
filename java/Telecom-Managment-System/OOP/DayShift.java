package Project.OOP;

public class DayShift extends Nurse{
    // Variables
    private String Shift, Time;

    // Default Constructor
    public DayShift() {
        super();
        Time="";
        Shift="";
    }

    // paramitarized Constructor
    public DayShift(String name, String age, int id, String Department, String Time, String Date) {
        super(name, age, id, Department);
        this.Shift = Date;
        this.Time = Time;
    }

    // getters
    public String getTime() {return this.Time;}
    public String getDate() {return this.Shift;}

    // setters
    public void setTime(String Time) {this.Time = Time;} 
    public void setDate(String Date) {this.Shift = Date;}

    // priting
    public String print_dayshift() {
        return super.print_nurse() + "\nShift:" + this.Shift + "\nTime:" + this.Time;
    }

}
