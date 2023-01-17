package Project.OOP; 
public class Person {
    //Variables
    private String name,age;

    //Default Constructor
    public Person(){
        name="";
        age="";
    } 
    //paramitarized Constructor
    public Person(String name,String age){
        this.name=name;
        this.age=age;
    }

    //getters
    public String getname() {return name;}
    public String getage() {return age;}

    //setters
    public void setname(String name) {this.name=name;}
    public void setage(String age) {this.age=age;}

    //priting
    public String print_person() {return "name:"+this.name+"\nage:"+this.age;}
}
