package Project.OOP;

public class Nurse extends Person{
    // Variables
    private int id;
    private String Department;

    // Default Constructor
    public Nurse() {
        super();
        id=0;
        Department="";
    }
    // paramitarized Constructor
    public Nurse(String name, String age,int id,String Department) {
        super(name,age);
        this.id=id;
        this.Department=Department;
    }

    // getters
    public int getid() {return this.id;}
    public String getDepartment() {return this.Department;}
 
    // setters
    public void setid(int id) {this.id=id;}
    public void setDepartment(String Department) {this.Department=Department;}

    // priting
    public String print_nurse() {
        return super.print_person()+"\nid:"+this.id+"\nDepartment:"+this.Department;}
}
