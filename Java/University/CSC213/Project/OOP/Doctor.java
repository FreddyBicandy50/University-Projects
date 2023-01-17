package Project.OOP;

public class Doctor extends Person implements Hospital {
    // Variables
    private int id;
    private String Spec; 
    
    // Default Constructor
    public Doctor() {
        super();
        Spec="";
        id=0;
    } 
    // paramitarized Constructor
    public Doctor(String name,String age,int id,String Spec) {
        super(name, age);
        this.id=id;
        this.Spec=Spec;
    }

    // getters
    public int getid() { return this.id;}
    public String getSpec() { return this.Spec;}

    // setters
    public void setSurgerytype(int id) {this.id=id;}
    public void setSurgerytype(String Spec) {this.Spec=Spec;}

    // Implementation of the getMedication() method  
    @Override
    public String getMedication() {
        return "Medications for " + this.Spec + " are :" + getMedicationsBySpecialty(this.Spec);
    }
    
    //Returning Medications Type by Specialty
    private String getMedicationsBySpecialty(String Spec) {
        if (Spec.equals("orthopedic")) return "fentanyl, Naproxen, Ibuprofen";
        else if (Spec.equals("cardiology")) return "Aspirin, clopidogrel, warfarin";
        else if (Spec.equals("oncology")) return "Chemotherapy Drugs, Targeted Therapy drugs";
        else if (Spec.equals("anesthesia")) return "Midazolam, Fentanyl";
        else if (Spec.equals("nephrology")) return "ACE inhibitors, ARBs, diuretics";
        return " ";
    }

    // printing
    public String print_doctor() {return super.print_person()+"\nid:"+this.id+"\nSpeciality:"+this.Spec;}
}
