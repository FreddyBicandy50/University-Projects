package Project; 
import javax.swing.*; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class add_records  { 
    //frame panel
    private static JPanel panel = new JPanel();
    private static JFrame frame = new JFrame("Hospital Management System");  
    private static JLabel message = new JLabel("");;  
    private static JTextField nurse_ShiftField = new JTextField(20);

    public add_records() {
        //Window Frame
        frame.setSize(1000, 600);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(panel); 
        panel.setLayout(null); 
        message.setText("");
        nurse_ShiftField.setText("AM/PM");
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
        
        ADD_doctor();
        ADD_Nurse();
        frame.setVisible(true);
        
         
    }
    public void ADD_doctor(){
        // ADD A DOCTOR
        // @name Field label
        JLabel drnameLabel = new JLabel("Name:");
        drnameLabel.setBounds(10, 50, 80, 25);
        panel.add(drnameLabel);
        // name Field input box
        JTextField drnameField = new JTextField(20);
        drnameField.setText("");
        drnameField.setBounds(60, 50, 150, 25);
        panel.add(drnameField);

        // @age Field label
        JLabel drageLabel = new JLabel("Age:");
        drageLabel.setBounds(10, 85, 80, 25);
        panel.add(drageLabel);
        // age Field input box
        JTextField drageField = new JTextField(20);
        drageField.setBounds(60, 85, 150, 25);
        drageField.setText("");
        panel.add(drageField);

        // @id Field label
        JLabel dridLabel = new JLabel("Id:");
        dridLabel.setBounds(10, 120, 80, 25);
        panel.add(dridLabel);
        // id Field input box
        JTextField dridField = new JTextField(20);
        dridField.setBounds(60, 120, 150, 25);
        dridField.setText("");
        panel.add(dridField);

        // @speciality Field Label
        JLabel drspecLabel = new JLabel("Speciality:");
        drspecLabel.setBounds(10, 155, 80, 25);
        panel.add(drspecLabel);
        // speciality Field input box
        JTextField drspecField = new JTextField(20);
        drspecField.setBounds(90, 155, 150, 25);
        drspecField.setText("");
        panel.add(drspecField);

        // Add doctor button
        JButton add_drbtn = new JButton("Add Doctor");
        add_drbtn.setBounds(20, 190, 120, 25);
        panel.add(add_drbtn);

        // On click @add_dr_Button
        add_drbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // if One of the textfileds are empty display an error message
                if (dridField.getText().isEmpty() ||
                        drnameField.getText().equals("") ||
                        drageField.getText().equals("") ||
                        drspecField.getText().equals("")) {
                    // display error message
                    message.setBounds(10, 230, 600, 25);
                    message.setText("empty Fields");
                } else {
                    // get values from text fields
                    String name = drnameField.getText();
                    String age = drageField.getText();
                    int id = Integer.parseInt(dridField.getText());
                    String spec = drspecField.getText();

                    // Add the doctor to the array database
                    login.db.add(new Doctor(name, age, id, spec));

                    // reset all fileds
                    drnameField.setText("");
                    drageField.setText("");
                    dridField.setText("");
                    drspecField.setText("");

                    // Display success message
                    message.setBounds(10, 230, 600, 25);
                    message.setText("Dr Added Successfully! " + name);

                }

            }
        });
    }
    public void ADD_Nurse(){
        // ADD A NURSE
        // @name Field label
        JLabel nurse_nameLabel = new JLabel("Name:");
        nurse_nameLabel.setBounds(550, 50, 80, 25);
        panel.add(nurse_nameLabel);
        // name Field input box
        JTextField nurse_nameField = new JTextField(20);
        nurse_nameField.setText("");
        nurse_nameField.setBounds(620, 50, 150, 25);
        panel.add(nurse_nameField);

        // @age Field label
        JLabel nurse_ageLabel = new JLabel("Age:");
        nurse_ageLabel.setBounds(550, 85, 80, 25);
        panel.add(nurse_ageLabel);
        // age Field input box
        JTextField nurse_ageField = new JTextField(20);
        nurse_ageField.setBounds(620, 85, 150, 25);
        nurse_ageField.setText("");
        panel.add(nurse_ageField);

        // @id Field label
        JLabel nurse_idLabel = new JLabel("Id:");
        nurse_idLabel.setBounds(550, 120, 80, 25);
        panel.add(nurse_idLabel);
        // id Field input box
        JTextField nurse_idField = new JTextField(20);
        nurse_idField.setBounds(620, 120, 150, 25);
        nurse_idField.setText("");
        panel.add(nurse_idField);

        // @Department Field Label
        JLabel nurse_DepartmentLabel = new JLabel("Department:");
        nurse_DepartmentLabel.setBounds(530, 155, 90, 25);
        panel.add(nurse_DepartmentLabel);
        // Department Field input box
        JTextField DepartmentField = new JTextField(20);
        DepartmentField.setBounds(630, 155, 150, 25);
        DepartmentField.setText("");
        panel.add(DepartmentField);

        // @time Field Label
        JLabel nurse_timeLabel = new JLabel("Time:");
        nurse_timeLabel.setBounds(530, 190, 90, 25);
        panel.add(nurse_timeLabel);
        // time Field input box
        JTextField nurse_timeField = new JTextField(20);
        nurse_timeField.setBounds(630, 190, 150, 25);
        nurse_timeField.setText("");
        panel.add(nurse_timeField);

        // @Shift Field Label
        JLabel nurse_ShiftLabel = new JLabel("Shift:");
        nurse_ShiftLabel.setBounds(530, 230, 90, 25);
        panel.add(nurse_ShiftLabel);
        // Shift Field input box 
        nurse_ShiftField.setBounds(630, 230, 150, 25); 
        panel.add(nurse_ShiftField);
        nurse_ShiftField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (nurse_ShiftField.getText().equals("AM/PM")) {
                    nurse_ShiftField.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(nurse_ShiftField.getText().equals("")) nurse_ShiftField.setText("AM/PM");
                
            }
        });
        // Add nurse button
        JButton add_nrbtn = new JButton("Add Nurse");
        add_nrbtn.setBounds(600, 260, 120, 25);
        panel.add(add_nrbtn);
        // On click @add_dr_Button
        add_nrbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // if One of the textfileds are empty display an error message
                if (nurse_nameField.getText().isEmpty() ||
                        nurse_ageField.getText().equals("") ||
                        nurse_idField.getText().equals("") ||
                        DepartmentField.getText().equals("") ||
                        nurse_timeField.getText().equals("") ||
                        nurse_ShiftField.getText().equals("AM/PM")) {
                    // display error message
                    message.setBounds(600, 290, 600, 25);
                    message.setText("empty Fields");
                } else {
                    if(nurse_ShiftField.getText().equals("AM")||nurse_ShiftField.getText().equals("PM")){
                        // get values from text fields
                        String name = nurse_nameField.getText();
                        String age = nurse_ageField.getText();
                        int id = Integer.parseInt(nurse_idField.getText());
                        String department = DepartmentField.getText();
                        String time = nurse_timeField.getText();
                        String shift = nurse_ShiftField.getText(); 
                        // Add the doctor to the array database
                        if (nurse_ShiftField.getText().equals("AM")) {
                            login.db.add(new DayShift(name, age, id, department, time, shift)); 
                        } else {
                            login.db.add(new NightShift(name, age, id, department, time, shift)); 
                           
                        }
                        // reset all fileds
                        nurse_nameField.setText("");
                        nurse_ageField.setText("");
                        nurse_idField.setText("");
                        DepartmentField.setText("");
                        nurse_timeField.setText("");
                        nurse_ShiftField.setText("AM/PM");
                        // Display success message
                        message.setBounds(600, 290, 600, 25);
                        message.setText("Nurse Added Successfully! " + name);
                        
                    }else{
                        message.setText("Shift has to be AM or PM! ");
                    }
                    
                }

            }
        });
    }


}
