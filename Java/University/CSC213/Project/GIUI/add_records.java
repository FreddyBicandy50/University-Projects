package Project.GIUI; 
import javax.swing.*;

import Project.OOP.DayShift;
import Project.OOP.Doctor;
import Project.OOP.NightShift;
import Project.OOP.TreatmentP;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class add_records  { 
    //frame panel
    private static JPanel panel = new JPanel();
    private static JFrame frame = new JFrame("Hospital Management System");  
    private static JLabel message = new JLabel("");;  
    private static JTextField ShiftField = new JTextField(20);

    public add_records() {
        //Window Frame
        frame.setSize(1000, 600);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(panel); 
        panel.setLayout(null); 
        message.setText("");
        ShiftField.setText("AM/PM");
        panel.add(message);

        // go back button
        JButton addbtn = new JButton("\u2190");
        addbtn.setBounds(10, 10, 60, 25);
        panel.add(addbtn); 
        addbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Code for handling the add button event
                frame.dispose();

                new admin_panel();  
            }          
        }); 
        
        ADD_Doctor();
        ADD_Nurse();
        ADD_Ptreatments();
       // ADD_Patient_Surgery();
        frame.setVisible(true);
        
         
    }
    public void ADD_Doctor(){
        // ADD A DOCTOR
        // @name Field label
        JLabel  nameLabel = new JLabel("Name:");
        nameLabel.setBounds(20, 50, 80, 25);
        panel.add(nameLabel);
        // name Field input box
         JTextField  nameField = new JTextField(20);
         nameField.setText("");
         nameField.setBounds(100, 50, 150, 25);
         panel.add( nameField);

        // @age Field label
        JLabel  ageLabel = new JLabel("Age:");
         ageLabel.setBounds(20, 80, 80, 25);
        panel.add( ageLabel);
        // age Field input box
        JTextField  ageField = new JTextField(20);
         ageField.setBounds(100, 80, 150, 25);
         ageField.setText("");
        panel.add( ageField);

        // @id Field label
        JLabel  idLabel = new JLabel("Id:");
         idLabel.setBounds(20, 110, 80, 25);
        panel.add( idLabel);
        // id Field input box
        JTextField  idField = new JTextField(20);
         idField.setBounds(100, 110, 150, 25);
         idField.setText("");
        panel.add( idField);

        // @speciality Field Label
        JLabel  specLabel = new JLabel("Speciality:");
         specLabel.setBounds(20, 140, 80, 25);
        panel.add( specLabel);
        // speciality Field input box
        JTextField  specField = new JTextField(20);
         specField.setBounds(100, 140, 150, 25);
         specField.setText("");
            panel.add( specField);

        // Add doctor button
        JButton add_btn = new JButton("Add Doctor");
        add_btn.setBounds(100, 180, 120, 25);
        panel.add(add_btn);

        // On click @add_dr_Button
        add_btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // if One of the textfileds are empty display an error message
                message.setBounds(100, 210, 600, 25);
                if ( idField.getText().isEmpty() ||
                         nameField.getText().equals("") ||
                         ageField.getText().equals("") ||
                         specField.getText().equals("")) {
                    // display error message 
                    message.setText("empty Fields");
                } else {
                    // get values from text fields
                    String name =  nameField.getText();
                    String age =  ageField.getText();
                    int id = Integer.parseInt( idField.getText());
                    String spec =  specField.getText();

                    // Add the doctor to the array database
                    login.db.add(new Doctor(name, age, id, spec));

                    // reset all fileds
                     nameField.setText("");
                     ageField.setText("");
                     idField.setText("");
                     specField.setText("");

                    // Display success message 
                    message.setText("Dr Added Successfully! " + name);

                }

            }
        });
    }
    public void ADD_Nurse(){
        // ADD A NURSE
        // @name Field label
        JLabel  nameLabel = new JLabel("Name:");
        nameLabel.setBounds(550, 20, 80, 25);
        panel.add(nameLabel);
        // name Field input box
        JTextField nameField = new JTextField(20);
        nameField.setText("");
        nameField.setBounds(660, 20, 150, 25);
        panel.add(nameField);

        // @age Field label
        JLabel ageLabel = new JLabel("Age:");
        ageLabel.setBounds(550, 50, 80, 25);
        panel.add(ageLabel);
        // age Field input box
        JTextField ageField = new JTextField(20);
        ageField.setBounds(660, 50, 150, 25);
        ageField.setText("");
        panel.add(ageField);

        // @id Field label
        JLabel  idLabel = new JLabel("Id:");
        idLabel.setBounds(550, 80, 80, 25);
        panel.add(idLabel);
        // id Field input box
        JTextField  idField = new JTextField(20);
        idField.setBounds(660, 80, 150, 25);
        idField.setText("");
        panel.add(idField);

        // @Department Field Label
        JLabel  DepartmentLabel = new JLabel("Department:");
        DepartmentLabel.setBounds(550, 110, 90, 25);
        panel.add(DepartmentLabel);
        // Department Field input box
        JTextField DepartmentField = new JTextField(20);
        DepartmentField.setBounds(660, 110, 150, 25);
        DepartmentField.setText("");
        panel.add(DepartmentField);

        // @time Field Label
        JLabel  timeLabel = new JLabel("Time:");
        timeLabel.setBounds(550, 140, 90, 25);
        panel.add(timeLabel);
        // time Field input box
        JTextField  timeField = new JTextField(20);
        timeField.setBounds(660, 140, 150, 25);
        timeField.setText("");
        panel.add(timeField);

        // @Shift Field Label
        JLabel  ShiftLabel = new JLabel("Shift:");
        ShiftLabel.setBounds(550, 170, 90, 25);
        panel.add(ShiftLabel);
        // Shift Field input box 
        ShiftField.setBounds(660, 170, 150, 25); 
        panel.add(ShiftField);
        ShiftField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (ShiftField.getText().equals("AM/PM")) {
                    ShiftField.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(ShiftField.getText().equals("")) ShiftField.setText("AM/PM");
                
            }
        });
        // Add nurse button
        JButton add_btn = new JButton("Add Nurse");
        add_btn.setBounds(600, 210, 120, 25);
        panel.add(add_btn);
        // On click @add_dr_Button
        add_btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                message.setBounds(600, 240, 600, 25);
                // if One of the textfileds are empty display an error message
                if (nameField.getText().isEmpty() ||
                        ageField.getText().equals("") ||
                        idField.getText().equals("") ||
                        DepartmentField.getText().equals("") ||
                        timeField.getText().equals("") ||
                        ShiftField.getText().equals("AM/PM")) {
                    // display error message 
                    message.setText("empty Fields");
                } else {
                    if( ShiftField.getText().equals("AM")|| ShiftField.getText().equals("PM")){
                        // get values from text fields
                        String name = nameField.getText();
                        String age = ageField.getText();
                        int id = Integer.parseInt(idField.getText());
                        String department = DepartmentField.getText();
                        String time = timeField.getText();
                        String shift = ShiftField.getText(); 
                        // Add the doctor to the array database
                        if (ShiftField.getText().equals("AM")) {
                            login.db.add(new DayShift(name, age, id, department, time, shift)); 
                        } else {
                            login.db.add(new NightShift(name, age, id, department, time, shift)); 
                           
                        }
                        // reset all fileds
                        nameField.setText("");
                        ageField.setText("");
                        idField.setText("");
                        DepartmentField.setText("");
                        timeField.setText("");
                        ShiftField.setText("AM/PM");
                        // Display success message 
                        message.setText("Nurse Added Successfully! " + name);
                        
                    }else{
                        message.setText("Shift has to be AM or PM! ");
                    }
                    
                }

            }
        });
    }
    public void ADD_Ptreatments(){
        // ADD Patients On treatments
        // @name Field label
        JLabel  nameLabel = new JLabel("Name:");
        nameLabel.setBounds(10, 255, 80, 25); 
        panel.add(nameLabel);
        // name Field input box
        JTextField nameField = new JTextField(20);
        nameField.setText("");
        nameField.setBounds(60, 255, 150, 25);
        panel.add(nameField);

        // @age Field label
        JLabel ageLabel = new JLabel("Age:");
        ageLabel.setBounds(10, 285, 80, 25);
        panel.add(ageLabel);
        // age Field input box
        JTextField ageField = new JTextField(20);
        ageField.setBounds(60, 285, 150, 25);
        ageField.setText("");
        panel.add(ageField);
       
        // @id Field label
        JLabel idLabel = new JLabel("Id:");
        idLabel.setBounds(10, 315, 80, 25);
        panel.add(idLabel);
        // id Field input box
        JTextField idField = new JTextField(20);
        idField.setBounds(60, 315, 150, 25);
        idField.setText("");
        panel.add(idField);
       
         // @Date Field Label
         JLabel Date = new JLabel("Date:");
         Date.setBounds(10, 345, 90, 25);
         panel.add(Date);
         // Date Field input box
         JTextField dateField = new JTextField(20);
         dateField.setBounds(60, 345, 150, 25);
         dateField.setText("");
         panel.add(dateField);
       
         // @time Field Label
         JLabel timeLabel = new JLabel("Time:");
         timeLabel.setBounds(10, 375, 90, 25);
         panel.add(timeLabel);
         // time Field input box
         JTextField timeField = new JTextField(20);
         timeField.setBounds(60, 375, 150, 25);
         timeField.setText("");
         panel.add(timeField);


         // @time Field Label
         JLabel TreatmentLabel = new JLabel("Treatment:");
         TreatmentLabel.setBounds(10, 405, 90, 25);
         panel.add(TreatmentLabel);
         // time Field input box
         JTextField treatmentField = new JTextField(20);
         treatmentField.setBounds(90, 405, 150, 25);
         treatmentField.setText(""); 
         panel.add(treatmentField); 
        
          // Add Patient button
          JButton add_btn = new JButton("Add PTreatment");
          add_btn.setBounds(50, 435, 200, 25);
          panel.add(add_btn);
          // On click @add_dr_Button
          add_btn.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
                    message.setBounds(50, 465, 600, 25);
                    // if One of the textfileds are empty display an error message
                    if (nameField.getText().isEmpty() || ageField.getText().equals("") ||
                        idField.getText().equals("") || dateField.getText().equals("") ||
                        timeField.getText().equals("") || treatmentField.getText().equals("")) {
                        // display error message
                        message.setText("empty Fields");
                    }else { 
                        // get values from text fields
                        String name = nameField.getText();
                        String age = ageField.getText();
                        int id = Integer.parseInt(idField.getText());
                        String date = dateField.getText();
                        String time = timeField.getText();
                        String treatment = treatmentField.getText();
                        // Add the doctor to the array database 
                        login.db.add(new TreatmentP(name, age, id, date, time, treatment)); 
                        // Display success message
                        message.setText("Patient Added Successfully! " + name);
                    }
                    // reset all fileds
                    nameField.setText("");
                    ageField.setText("");
                    idField.setText("");
                    dateField.setText("");
                    timeField.setText("");
                    treatmentField.setText(""); 
           
            }  
          }); 
    }

}
