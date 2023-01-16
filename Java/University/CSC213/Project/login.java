package Project;

import javax.swing.*; 
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
}