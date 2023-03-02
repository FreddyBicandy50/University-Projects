package Project.OOP;

public class SurgeryP extends Patient implements Hospital{
    //Variables 
    private String Surgerytype;

    //Default Constructor
    public SurgeryP() {
        super(); 
        Surgerytype="";
    }
    //paramitarized Constructor
    public SurgeryP(String name, String age,int id,String date,String time,String Surgerytype) {
        super(name,age,id,date,time);
        this.Surgerytype=Surgerytype; 
    }

    //getters
    public String getSurgerytype() {return Surgerytype;}  
    //setters
    public void setSurgerytype(String Surgerytype) {this.Surgerytype=Surgerytype;}  
    
    //Return medication by  surgery type
    @Override
    public String getMedication() {
        if (Surgerytype.equals("orthopedic")) return "fentanyl";
        else if (Surgerytype.equals("appendectomy")) return "Antibiotics";
        else if (Surgerytype.equals("hip")) return "Blood thinners";
        else if (Surgerytype.equals("anesthesia")) return "Anti-nausea";
        else if (Surgerytype.equals("gallbladder") || Surgerytype.equals("bowel")) return "Vitamin K"; 
        else return "Nothing";
    }

    //printing
    public String print_surgery() {return super.print_patient()+"\nSurgerytype:"+ this.Surgerytype;}
}
