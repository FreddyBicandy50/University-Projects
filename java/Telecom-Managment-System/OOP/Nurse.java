package Project.OOP;

public class Nurse extends Person{
    // Variables 
    private String Department;

    // Default Constructor
    public Nurse() {
        super(); 
        Department="";
    }
    // paramitarized Constructor
    public Nurse(String name, String age,int id,String Department) {
        super(name,age,id); 
        this.Department=Department;
    }

    // getters 
    public String getDepartment() {return this.Department;}
    
    // setters 
    public void setDepartment(String Department) {this.Department=Department;}

    // priting
    public String print_nurse() {
        return super.print_person()+"\nDepartment:"+this.Department;}
}
