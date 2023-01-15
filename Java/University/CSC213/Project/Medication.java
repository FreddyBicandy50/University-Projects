package Project; 
import java.util.Scanner;
public class Medication {
    public static Person people[]=new Person[10];  
    public static void main(String[] args){ 
        // Dr's
        people[0] = new Doctor("Ahmad", "40", 4050, "orthopedic");
        people[1] = new Doctor("Adnan", "45", 4100, "cardiology");
        people[2] = new Doctor("Ibrahim", "39", 4300, "oncology");

        // Nurse's
        people[3] = new NightShift("Rony", "19", 1011, "Mar Roukoz", "10:00PM", "Wed-Tue-Fri");
        people[4] = new DayShift("Charlie", "35", 1041, "Mar Doumit", "8:00AM", "Mon-Thu-Sa");

        // Treatment's
        people[5] = new TreatmentP("David", "40", 325, "Nov-15-2023", "12:00AM", "Antidepressants");
        people[6] = new TreatmentP("Emily", "60", 315, "Nov-10-2023", "1:00PM", "Sugar");

        // Surgery's
        people[7] = new SurgeryP("Henry", "50", 615, "jan-24-2023", "8:50PM", "orthopedic");
        people[8] = new SurgeryP("Isabella", "12", 675, "Nov-10-2023", "1:00PM", "appendectomy");
        people[9] = new SurgeryP("Grace", "55", 685, "Feb-14-2023", "9:58PM", "anesthesia");

        Scanner input=new Scanner(System.in);
        int choice=1;
        while (choice!=-1){
            System.out.println(
                // Display the array by type
                "Choose Display Options:\n1.Hospital Doctor's\n2.Hospital Nurse's\n4.Hospital Patients \n-1.exit");
            choice=input.nextInt(); 
            print(choice);
        }  
        input.close();  
    }
 
    public static void print(int choice){
        boolean title=true;
        for (int i = 0; i < people.length; i++) {  
            switch (choice){
                case 1:
                    if (people[i] instanceof Doctor){
                        if (title) {
                            System.out.println("\nAll Hospital Doctor's: ");
                            title=false;
                        }
                        Doctor convert=(Doctor) people[i];
                        System.out.println(convert.print_doctor()+"\n");
                    } 
                    break;
                case 2:
                    if (people[i] instanceof NightShift) {
                        NightShift convert = (NightShift) people[i];
                        System.out.println("NightShift Nurses: " + convert.print_nightshift());
                    }
                    if (people[i] instanceof DayShift) {
                        DayShift convert = (DayShift) people[i];
                        System.out.println("DayShift Nurses: " + convert.print_dayshift());
                    }
                    break;  
                case 3:
                    if (people[i] instanceof TreatmentP) {
                            TreatmentP convert = (TreatmentP) people[i];
                            System.out.println("Treatments Patients: " + convert.print_treatment());
                        }
                    if (people[i] instanceof SurgeryP) {
                            SurgeryP convert = (SurgeryP) people[i];
                            System.out.println("Surgery Patients: " + convert.print_surgery());
                        }
                    break; 
                default : 
                    break; 
            }
        }
    }
    
 
    public static void print_all(int choice){
        boolean title=true;
        for (int i = 0; i < people.length; i++) {  
            switch (choice){
                case 1:
                    if (people[i] instanceof Doctor){
                        if (title) {
                            System.out.println("\nAll Hospital Doctor's: ");
                            title=false;
                        }
                        Doctor convert=(Doctor) people[i];
                        System.out.println(convert.print_doctor()+"\n");
                    } 
                    break;
                case 2:
                    if (people[i] instanceof NightShift) {
                        NightShift convert = (NightShift) people[i];
                        System.out.println("NightShift Nurses: " + convert.print_nightshift());
                    }
                    if (people[i] instanceof DayShift) {
                        DayShift convert = (DayShift) people[i];
                        System.out.println("DayShift Nurses: " + convert.print_dayshift());
                    }
                    break;  
                case 3:
                    if (people[i] instanceof TreatmentP) {
                            TreatmentP convert = (TreatmentP) people[i];
                            System.out.println("Treatments Patients: " + convert.print_treatment());
                        }
                    if (people[i] instanceof SurgeryP) {
                            SurgeryP convert = (SurgeryP) people[i];
                            System.out.println("Surgery Patients: " + convert.print_surgery());
                        }
                    break; 
                default : 
                    break; 
            }
        }
    }

}
 

