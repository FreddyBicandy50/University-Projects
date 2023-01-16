package Project; 
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 
import java.awt.Font; 

public class Display {
    // frame panel
    private static JPanel panel = new JPanel();
    private static JFrame frame = new JFrame("Hospital Management System");
    private static JTextArea Displayarea = new JTextArea("Display Area");

    public Display(){   
        
        //Window Frame  
        frame.setSize(1920, 1366);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(panel);  
        Displayarea.setFont(new Font("Arial", Font.BOLD, 18));
        panel.setLayout(null);  
        // go back button
        JButton addbtn = new JButton("\u2190");
        addbtn.setBounds(0, 5, 60, 25);
        panel.add(addbtn);
        addbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Code for handling the add button event
                frame.setVisible(false);
                new admin_panel();
            }
        });

        //Display area 
        Displayarea.setBounds(0,45, 1920, 850);
        Displayarea.setEditable(false); 
        panel.add(Displayarea);

        display_doctor();
        display_nurse();
        display_ptreatment();
        
        frame.setVisible(true);
    }
    public void display_doctor(){ 
        // Doctors
        JButton display = new JButton("Display Doctors");
        display.setBounds(30, 900, 150, 100);
        panel.add(display);
        display.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Code for handling the add button event
                boolean empty = true;
                Displayarea.setText("");
                for (Person person : login.db) {
                    if (person instanceof Doctor) {
                        empty = false;
                        Doctor convert = (Doctor) person;
                        Displayarea.setText(Displayarea.getText() + "\n" + convert.print_doctor() + "\n:"+convert.getMedication()+"\n");
                    }
                }
                if (empty) Displayarea.setText("No Records Found!");
            }
        });
    }
    public void display_nurse(){ 
        // Nurse
        JButton display= new JButton("Display Nurse");
        display.setBounds(230, 900, 150, 100);
        panel.add(display);
        display.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Code for handling the add button event
                boolean empty = true;
                Displayarea.setText("");
                for (Person person : login.db) {
                    if (person instanceof DayShift || person instanceof NightShift) {
                        empty = false; 
                        if(person instanceof DayShift) { 
                            DayShift convert = (DayShift) person;
                            Displayarea.setText(Displayarea.getText() + "\n" + convert.print_dayshift() + "\n");
                        }else{
                            NightShift convert = (NightShift) person;
                            Displayarea.setText(Displayarea.getText() + "\n" + convert.print_nightshift() + "\n");
                        }
                    }
                }
                if (empty) Displayarea.setText("No Records Found!");
            }
        });
    }
    public void display_ptreatment(){ 
        // Nurse
        JButton display = new JButton("Display Patients");
        display.setBounds(430, 900, 150, 100);
        panel.add(display);
        display.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Code for handling the add button event
                boolean empty = true;
                Displayarea.setText("");
                for (Person person : login.db) {
                    if (person instanceof TreatmentP || person instanceof SurgeryP) {
                        empty = false; 
                        if(person instanceof TreatmentP) { 
                            TreatmentP convert = (TreatmentP) person; 
                            Displayarea.setText(Displayarea.getText() + "\n" + convert.print_treatment() + "\nMedication:"+convert.getMedication()+"\n");
                        }else{
                            SurgeryP convert = (SurgeryP) person;
                            Displayarea.setText(Displayarea.getText() + "\n" + convert.print_surgery() + "\nMedication:"+convert.getMedication()+"\n");
                        }
                    }
                }
                if (empty) Displayarea.setText("No Records Found!");
            }
        });
    }
}
