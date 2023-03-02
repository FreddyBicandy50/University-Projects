package Project.GIUI;

import javax.swing.*;

import Project.OOP.DayShift;
import Project.OOP.Doctor;
import Project.OOP.NightShift;
import Project.OOP.Person;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class modify  {
    // frame panel
    private static JPanel panel = new JPanel();
    private static JFrame frame = new JFrame("Hospital Management System");
    private static JLabel message = new JLabel("");
    private static JTextField modify_byid = new JTextField(20);
    private static JButton Modify = new JButton("Modify Record");
    public modify(){
        // Window Frame
        frame.setSize(1000, 600);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.setLayout(null);
        message.setText(""); 
        panel.add(message);

        // go back button
        JButton back = new JButton("\u2190");
        back.setBounds(10, 10, 60, 25);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Code for handling the add button event
                frame.dispose();
                new admin_panel();
            }
        });

        //NAME
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(250, 40, 80, 25);
        panel.add(nameLabel); 
        JTextField nameField = new JTextField(20);
        nameField.setText("");
        nameField.setBounds(300, 40, 300, 25);
        panel.add(nameField);

        // AGE
        JLabel ageLabel = new JLabel("Age:");
        ageLabel.setBounds(250, 70, 80, 25);
        panel.add(ageLabel); 
        JTextField ageField = new JTextField(20);
        ageField.setBounds(300, 70, 300, 25);
        ageField.setText("");
        panel.add(ageField);

        modify_byid.setText("\tEnter Record ID");
        modify_byid.setBounds(300, 110, 300, 25);
        panel.add(modify_byid);
         modify_byid.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (modify_byid.getText().equals("\tEnter Record ID")) {
                    modify_byid.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (modify_byid.getText().equals(""))
                    modify_byid.setText("\tEnter Record ID");

            }
        });

        // modify record button 
        Modify.setBounds(330, 150, 230, 25);
        panel.add(Modify);
        
        // DOCTOR 
        JLabel DoctorFields = new JLabel("\tModify Doctor");
        DoctorFields.setBounds(30, 50, 300, 25);
        panel.add(DoctorFields);
 
        JLabel specLabel = new JLabel("Speciality:");
        specLabel.setBounds(30, 80, 80, 25 );
        JTextField specField = new JTextField(20);
        specField.setBounds(30, 110, 150, 25);
        specField.setText("");
        panel.add(specField);
        
        //NURSE
        JLabel NurseFields = new JLabel("\tModify Nurse");
        NurseFields.setBounds(650, 50, 300, 25);
        panel.add(NurseFields); 
        JLabel DepartmentLabel = new JLabel("Department:");
        DepartmentLabel.setBounds(650, 100, 90, 25);
        panel.add(DepartmentLabel); 
        JTextField DepartmentField = new JTextField(20);
        DepartmentField.setBounds(750, 100, 150, 25);
        DepartmentField.setText("");
        panel.add(DepartmentField); 
        JLabel timeLabel = new JLabel("Time:");
        timeLabel.setBounds(650, 130, 90, 25);
        panel.add(timeLabel); 
        JTextField timeField = new JTextField(20);
        timeField.setBounds(750, 130, 150, 25);
        timeField.setText("");
        panel.add(timeField); 
        JLabel ShiftLabel = new JLabel("Shift:");
        ShiftLabel.setBounds(650, 160, 90, 25);
        panel.add(ShiftLabel); 
        JTextField ShiftField = new JTextField(20);
        ShiftField.setText("AM/PM");
        ShiftField.setBounds(750, 160, 150, 25);
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
                if (ShiftField.getText().equals(""))
                    ShiftField.setText("AM/PM");

            }
        });
        
        // On click @add_dr_Button
        Modify.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (modify_byid.getText().equals("\tEnter Record ID") || modify_byid.getText()
                        .equals("") || modify_byid.getText().equals(" ")) {
                    // display error message
                    message.setBounds(330, 200, 600, 25);
                    message.setText("id field is empty");
                } else if (modify_byid.getText().matches("^[a-zA-Z]*$")) {
                    message.setBounds(330, 200, 600, 25);
                    message.setText("id field has to be a number");
                } else { 
                     boolean found = false;
                     int getid = Integer.parseInt(modify_byid.getText());
                     for (Person person : login.db) {
                        if (person.id == getid) {
                            found = true;
                            if (person instanceof Doctor){ 
                                Doctor convert = (Doctor) person;
                                if (!nameField.equals("") || !nameField.equals(" ") )    
                                    convert.setname(nameField.getText()); 
                                else if (!ageField.equals("") || !ageField.equals(" "))
                                    convert.setage(ageField.getText());
                                else if (!specField.equals("") || !specField.equals(" ")) 
                                    convert.setSpec(ageField.getText());
                                break;
                            }else if (person instanceof DayShift || person instanceof NightShift){ 
                                if(ShiftField.getText().equals("AM")){
                                    DayShift convert = (DayShift) person;
                                    if (!nameField.equals("") || !nameField.equals(" "))
                                        convert.setname(nameField.getText());
                                    else if (!ageField.equals("") || !ageField.equals(" "))
                                        convert.setage(ageField.getText());
                                    else if (!DepartmentField.equals("") || !specField.equals(" "))
                                        convert.setDepartment(DepartmentField.getText());
                                }else{
                                    NightShift convert = (NightShift) person;
                                    if (!nameField.equals("") || !nameField.equals(" "))
                                        convert.setname(nameField.getText());
                                    else if (!ageField.equals("") || !ageField.equals(" "))
                                        convert.setage(ageField.getText());
                                    else if (!DepartmentField.equals("") || !specField.equals(" "))
                                        convert.setDepartment(DepartmentField.getText());
                                }
                                
                                break;
                            }
                        }
                        // reset all fileds
                        modify_byid.setText("\tEnter Record ID");
                     }
                        if (found) message.setText("Record modifiet Successfully");
                        else message.setText("Not found!");
                     
                     }
                }        
                });
          
        frame.setVisible(true);
    }
    

}