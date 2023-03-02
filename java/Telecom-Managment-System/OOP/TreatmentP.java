package Project.OOP;

public class TreatmentP extends Patient implements Hospital{
    // Variables
    private String Treatmenttype;

    // Default Constructor
    public TreatmentP() {
        super();
        Treatmenttype="";
    }

    // paramitarized Constructor
    public TreatmentP(String name, String age, int id, String date, String time, String Treatmenttype) {
        super(name, age, id, date, time);
        this.Treatmenttype=Treatmenttype;
    }

    // getters
    public String getTreatmenttype() {return Treatmenttype;}

    // setters
    public void setTreatmenttype(String Treatmenttype) {this.Treatmenttype = Treatmenttype;}
    
    
    // return mediaction by Treatment type
    @Override
    public String getMedication() {
        if (Treatmenttype.equals("Antidepressants")) return "serotonin";
        else if (Treatmenttype.equals("Anti-inflammatory")) return "aspirin";
        else if (Treatmenttype.equals("Sugar")) return "insulin";
        else if (Treatmenttype.equals("Cholesterol")) return "statins";
        else if (Treatmenttype.equals("Cancer")) return "chemotherapy";
        else return "Nothing";
    }

    // printing
    public String print_treatment() {return super.print_patient()+"\nTreatment type:"+this.Treatmenttype;}
}
