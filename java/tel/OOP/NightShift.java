package Project.OOP;

public class NightShift extends Nurse {
    // Variables 
    private String Time,Shift;

    // Default Constructor
    public NightShift() {
        super(); 
        Time="";
        Shift="";
    }

    // paramitarized Constructor
    public NightShift(String name, String age, int id,String Department,String Time, String Shift) {
        super(name,age,id,Department);
        this.Shift=Shift;
        this.Time=Time;
    }

    // getters
    public String getTime() {return this.Time;}
    public String getShift() {return this.Shift;}

    // setters
    public void setTime(String Time) {this.Time=Time;}
    public void setShift(String Shift) {this.Shift=Shift;}

    // priting
    public String print_nightshift() {
        return super.print_nurse()+"\nShift:"+this.Shift+"\nTime:"+this.Time;
    }
}
