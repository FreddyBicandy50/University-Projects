package Project.OOP;

public class Doctor extends Person implements Hospital {
    // Variables 
    private String Spec; 
    
    // Default Constructor
    public Doctor() {
        super();
        Spec=""; 
    } 
    // paramitarized Constructor
    public Doctor(String name,String age,int id,String Spec) {
        super(name, age,id); 
        this.Spec=Spec;
    }

    // getters 
    public String getSpec() { return this.Spec;}

    // setters 
    public void setSpec(String Spec) {this.Spec=Spec;}

    // return medications based on Dr Specialty
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
    public String print_doctor() {return super.print_person()+"\nSpeciality:"+this.Spec;}
}
