package Project.GIUI;

// OOP Files
import Project.OOP.DayShift;
import Project.OOP.Doctor;
import Project.OOP.NightShift;
import Project.OOP.SurgeryP;
import Project.OOP.TreatmentP;

// Modules
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class init {
    // Variables 
        // Bounds X,y
    public static int x=350,xf=x+100;

        //buttons
    public static  JButton Goback_btn = new JButton("\u2190"); 
    public static  JButton Add_info   = new JButton("Add info");
        //labels
    public static JLabel message         = new JLabel("");;
    public static JLabel nameLabel       = new JLabel("Name:");
    public static JLabel ageLabel        = new JLabel("Age:");
    public static JLabel idLabel         = new JLabel("Id:");
    public static JLabel specLabel       = new JLabel("Speciality:"); 
    public static JLabel DepartmentLabel = new JLabel("Department:");
    public static JLabel timeLabel       = new JLabel("Time:");
    public static JLabel ShiftLabel      = new JLabel("Shift:");
    public static JLabel DateLabel       = new JLabel("Date:");
    public static JLabel TreatmentLabel  = new JLabel("Treatment:");
    public static JLabel SrugeryLabel    = new JLabel("Surgery Type:");
   
    
        //fields 
    public static JTextField nameField       = new JTextField(20);
    public static JTextField ageField        = new JTextField(20);
    public static JTextField idField         = new JTextField(20);
    public static JTextField specField       = new JTextField(20);
    public static JTextField DepartmentField = new JTextField(20);
    public static JTextField timeField       = new JTextField(20);
    public static JTextField ShiftField      = new JTextField(20);
    public static JTextField DateField       = new JTextField(20);
    public static JTextField treatmentField  = new JTextField(20);
    public static JTextField SrugeryField    = new JTextField(20);

    public init(){
        // Reseting Fields
        // General
        message         .setText(""); 
        nameField       .setText("");
        ageField        .setText("");
        idField         .setText("");
        // Doctor
        specField       .setText("");
        // Nurse
        DepartmentField .setText("");  
        timeField       .setText("");   
        ShiftField      .setText("AM/PM"); 
        
        // Patients
        DateField       .setText("");    
        treatmentField  .setText(""); 
        SrugeryField    .setText("");  

        
    }

    public static void add_panel (){
    // Add Essential Fields To Panel
    add_records.panel.setLayout(null);
        // Labels
        add_records.panel.add(message);
        add_records.panel.add(nameLabel);
        add_records.panel.add(ageLabel);
        add_records.panel.add(idLabel);
        add_records.panel.add(specLabel);
        add_records.panel.add(DepartmentLabel);
        add_records.panel.add(timeLabel);
        add_records.panel.add(ShiftLabel);
        add_records.panel.add(DateLabel);
        add_records.panel.add(TreatmentLabel); 
        add_records.panel.add(SrugeryLabel);

        // Fields
        add_records.panel.add(nameField);
        add_records.panel.add(ageField);
        add_records.panel.add(idField);
        add_records.panel.add(specField);
        add_records.panel.add(DepartmentField);
        add_records.panel.add(timeField);
        add_records.panel.add(ShiftField);
        add_records.panel.add(DateField);
        add_records.panel.add(treatmentField);
        add_records.panel.add(SrugeryField);

        // Buttons
        add_records.panel.add(Goback_btn); 
        add_records.panel.add(Add_info);
        
    // Component placement
    nameLabel.setBounds(x, 50, 80, 25);
    ageLabel.setBounds(x, 80, 80, 25);
    idLabel.setBounds(x, 110, 80, 25);
    nameField.setBounds(xf, 50, 150, 25);
    ageField.setBounds(xf, 80, 150, 25);
    idField.setBounds(xf, 110, 150, 25);

    // Dynamic Placeholder
    ShiftField.addFocusListener(new FocusListener() {
        @Override
        public void focusGained(FocusEvent e) {
            if (init.ShiftField.getText().equals("AM/PM")) {
                init.ShiftField.setText("");
            }
        }

        @Override
        public void focusLost(FocusEvent e) {
            if (init.ShiftField.getText().equals(""))
                init.ShiftField.setText("AM/PM");
        }
    });
    

}
    public static void goback_btn(){  
    Goback_btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                    add_records.add_frame.dispose();
                    new admin_panel();
            }
        });
}
    public static void Add_btn(int choice){  
    switch (choice) {
        case 1: 
            Add_info.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    message.setBounds(x + 20, 210, 600, 25);
                    // Check Fields !empty
                    if ( idField.getText().isEmpty()   || nameField.getText().equals("") ||
                         ageField.getText().equals("") || specField.getText().equals("")) 
                    { 
                         message.setText("empty Fields");

                    } else {

                        // Store info
                        String name = init.nameField.getText();
                        String age  = init.ageField.getText();
                        String spec = init.specField.getText();
                        int id      = Integer.parseInt(init.idField.getText());

                        //Add info to database
                        login.db.add(new Doctor(name, age, id, spec)); 

                        // Reset & Display Success Message
                        new init();  
                        message.setText("Dr Added Successfully! " + name);
                    } 
                }
            });
            break;
        case 2: 
            Add_info.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    message.setBounds(x+20, 250, 600, 25); 
                    // Check Fields !empty
                    if (nameField.getText().isEmpty()  || ageField.getText().equals("")         ||
                        idField.getText().equals("")   ||  DepartmentField.getText().equals("") ||
                        timeField.getText().equals("") || ShiftField.getText().equals("AM/PM")) 
                    { 
                        message.setText("empty Fields");
                    } else {
                        if ( ShiftField.getText().equals("AM") ||  ShiftField.getText().equals("PM")) 
                        { 
                            // Store info 
                            String name         =   nameField.getText();
                            String age          =   ageField.getText();
                            String department   =   DepartmentField.getText();
                            String time         =   timeField.getText();
                            String shift        =   ShiftField.getText();
                            int id              =   Integer.parseInt(idField.getText());

                            // Check Nurse Shift
                            if (ShiftField.getText().equals("AM"))
                                login.db.add(new DayShift(name, age, id, department, time, shift));
                            else
                                login.db.add(new NightShift(name, age, id, department, time, shift));

                            //Reset & Display Success Message
                            new init(); 
                            message.setText("Nurse Added Successfully! " + name); 

                        } else message.setText("Shift has to be AM or PM!");
                    }
                }
            });
            break; 
        case 3:
            Add_info.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) { 
                    init.message.setBounds(xf, 260, 600, 25);
                    // Check Fields !empty
                    if (nameField.getText().isEmpty()       || ageField.getText().equals("")  ||
                            idField.getText().equals("")    || DateField.getText().equals("") ||
                            timeField.getText().equals("")  || treatmentField.getText().equals("")) 
                    { 
                        message.setText("empty Fields");
                    } else {
                        // Store info
                        String name      = nameField.getText();
                        String age       = ageField.getText();
                        String date      = DateField.getText();
                        String time      = timeField.getText();
                        String treatment = treatmentField.getText();
                        int id           = Integer.parseInt(idField.getText());

                        // Add info to database
                        login.db.add(new TreatmentP(name, age, id, date, time, treatment));

                        // Reset & Display Success Message
                        new init();
                        init.message.setText("Patient Added Successfully! " + name); 
                    }
                }
            });
            break;
        case 4:
            Add_info.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    init.message.setBounds(xf, 290, 600, 25);
                    // Check Fields !empty
                    if ( nameField.getText().isEmpty()  || ageField.getText().equals("")  ||
                         idField.getText().equals("")   || DateField.getText().equals("") ||
                         timeField.getText().equals("") || SrugeryField.getText().equals("")) 
                    { 
                         message.setText("empty Fields");
                    }else { 
                            // Store info
                            String name     = nameField.getText();
                            String age      = ageField.getText();
                            String date     = DateField.getText();
                            String time     = timeField.getText();
                            String Surgery  = SrugeryField.getText();
                            int id          = Integer.parseInt(idField.getText());

                            // Add info to database
                            login.db.add(new SurgeryP(name, age, id, date, time, Surgery)); 

                            // Reset & Display Success Message
                            new init();
                            init.message.setText("Patient Added Successfully! " + name);
                             
                        } 
                }  
            });
            break; 
        } 
    }
}
