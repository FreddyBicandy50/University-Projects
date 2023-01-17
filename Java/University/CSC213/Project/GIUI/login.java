package Project.GIUI;

import javax.swing.*;

import Project.OOP.DayShift;
import Project.OOP.Doctor;
import Project.OOP.NightShift;
import Project.OOP.Person;
import Project.OOP.SurgeryP;
import Project.OOP.TreatmentP;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList; 

public class login  { 
    //frame panel
    private static JPanel panel = new JPanel();
    private static JFrame frame = new JFrame("Hospital Management System");  
    public static ArrayList<Person> db = new ArrayList<Person>();
    public login() {

        //Window Frame 
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(panel); 
        panel.setLayout(null); 
        
        //user label
        JLabel usernameLabel = new JLabel("username:");
        usernameLabel.setBounds(150,55,80,25);
        panel.add(usernameLabel);
        // user input
        JTextField getusername = new JTextField(20);
        getusername.setBounds(230, 55, 150, 25);
        getusername.setText("");
        panel.add(getusername);
        
        //pass label
        JLabel passwordLabel = new JLabel("password:");
        passwordLabel.setBounds(150, 85, 150, 25);
        panel.add(passwordLabel);
        // password input
        JPasswordField passwordField = new JPasswordField();
        passwordField.setText("");
        passwordField.setBounds(230, 85, 150, 25);
        panel.add(passwordField);

        //login button        
        JButton loginbtn = new JButton("Login");
        loginbtn.setBounds(230,115,120,25);
        panel.add(loginbtn); 
        //login message
        JLabel message = new JLabel("");
        message.setBounds(190, 150, 600, 25);
        panel.add(message);

        //On login click
        loginbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {  
                if(getusername.getText().equals("admin") 
                    && new String(passwordField.getPassword()).equals("123")){      
                    record();
                    frame.dispose();
                    new admin_panel();
                }else{
                    getusername.setText("");
                    passwordField.setText("");
                    message.setText("invalid Username or password");        
                }
            }
        }); 
        frame.setVisible(true);
    } 
    public void record(){
        db.add(new Doctor("Ahmad", "40", 4050, "orthopedic"));
        db.add(new Doctor("Adnan", "45", 4100, "cardiology"));
        db.add(new Doctor("Ibrahim", "39", 4300, "oncology"));
        
        // Nurse's
        db.add(new NightShift("Rony", "19", 1011, "Mar Roukoz", "10:00PM", "Wed-Tue-Fri"));
        db.add(new DayShift("Charlie", "35", 1041, "Mar Doumit","8:00AM", "Mon-Thu-Sa"));
        
        // Treatment's
        db.add(new TreatmentP("David", "40", 325, "Nov-15-2023", "12:00AM", "Antidepressants"));
        db.add(new TreatmentP("Emily", "60", 315, "Nov-10-2023", "1:00PM", "Sugar"));
        
        // Surgery's
        db.add(new SurgeryP("Henry", "50", 615, "jan-24-2023", "8:50PM", "orthopedic"));
        db.add(new SurgeryP("Isabella", "12", 675, "Nov-10-2023", "1:00PM", "appendectomy")); 
        db.add(new SurgeryP("Grace", "55", 685, "Feb-14-2023", "9:58PM", "anesthesia"));
    }
}