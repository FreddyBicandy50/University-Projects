package Project.OOP; 
public class Person {
    //Variables
    private String name,age;
    public int id;

    //Default Constructor
    public Person(){
        name="";
        age="";
        id=0;
    } 
    //paramitarized Constructor
    public Person(String name,String age,int id){
        this.name=name;
        this.age=age;
        this.id=id;
    }

    //getters
    public String getname() {return name;}
    public String getage() {return age;}

    //setters
    public void setname(String name) {this.name=name;}
    public void setage(String age) {this.age=age;}

    //priting
    public String print_person() {return "name:"+this.name+"\nage:"+this.age+"\nid:"+this.id;}
}
