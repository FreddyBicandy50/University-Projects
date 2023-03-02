package Project.OOP;
public class Patient extends Person{
    //Variables 
    private String date,time;
    
    //Default Constructor
    public Patient() {
        super();
        date="";
        time=""; 
    }

    //paramitarized Constructor
    public Patient(String name, String age,int id,String date,String time) {
        super(name,age,id); 
        this.date=date;
        this.time=time;
    }

    //getters
    public String getdate() {return date;} 
    public String gettime() {return time;}

    //setters
    public void setdate(String date) {this.date=date;}
    public void settime(String time) {this.time=time;}

    // printing
    public String print_patient() {
        return super.print_person()+"\ndate:"+this.date+"\ntime:"+this.time;
    }
}
