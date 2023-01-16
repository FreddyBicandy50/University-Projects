package Project; 
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class add_records  { 
    //frame panel
    private static JPanel panel = new JPanel();
    private static JFrame frame = new JFrame("Hospital Management System"); 
    private static int count=0;
 
    public add_records() {
        //Window Frame
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(panel); 
        panel.setLayout(null);

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

        //@name Field label
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(10,50,80,25);
        panel.add(nameLabel);
        // name Field input box 
        JTextField nameField = new JTextField(20);
        nameField.setText("");
        nameField.setBounds(60, 50, 150, 25);
        panel.add(nameField);
        
        //@age Field label 
        JLabel ageLabel = new JLabel("Age:");
        ageLabel.setBounds(10,85,80,25);
        panel.add(ageLabel);
        //age Field input box 
        JTextField ageField = new JTextField(20);
        ageField.setBounds(60, 85, 150, 25);
        ageField.setText("");
        panel.add(ageField);

        //@id Field label
        JLabel idLabel = new JLabel("Id:");
        idLabel.setBounds(10,120,80,25);
        panel.add(idLabel);
        //id Field input box 
        JTextField idField = new JTextField(20);
        idField.setBounds(60, 120, 150, 25);
        idField.setText("");
        panel.add(idField);
        
        //@speciality Field Label
        JLabel specLabel = new JLabel("Speciality:");
        specLabel.setBounds(10,155,80,25);
        panel.add(specLabel); 
        //speciality Field input box 
        JTextField specField = new JTextField(20);
        specField.setBounds(90, 155, 150, 25);
        specField.setText("");
        panel.add(specField);  

        // Add doctor button
        JButton add_drbtn = new JButton("Add Doctor");
        add_drbtn.setBounds(20, 190, 120, 25);
        panel.add(add_drbtn);
        // error message label
        JLabel message = new JLabel("");
        message.setBounds(10, 230, 600, 25);
        panel.add(message); 
        
        // On click @add_dr_Button
        add_drbtn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) { 
                // if One of the textfileds are empty display an error message 
                if (
                    idField.getText().isEmpty() || 
                    nameField.getText().equals("") || 
                    ageField.getText().equals("") ||   
                    specField.getText().equals("")
                    ){
                        //display error message
                        message.setText("empty Fields");
                }else{ 
                        //get values from text fields
                        int id=Integer.parseInt(idField.getText());
                        String name = nameField.getText(), age = ageField.getText(), spec = specField.getText();

                        // Add the doctor to the array database 
                        Doctor add_dr = new Doctor(name, age, id, spec); 
                        login.db.add(add_dr);
                        count++;

                        // Display success message
                        message.setText("Added Successfully! "+count);
                }
                //reset all fileds
                nameField.setText("");
                ageField.setText("");
                idField.setText("");
                specField.setText("");
            }
        });
       


        JTextArea Displayarea = new JTextArea("Display Area");
        Displayarea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        Displayarea.setBounds(550,170,300,400);
        Displayarea.setEditable(false);
        panel.add(Displayarea);
       JButton displaydr = new JButton("Display Doctors");
        displaydr.setBounds(150, 190,150,25);
        panel.add(displaydr);
        displaydr.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                // Code for handling the add button event
                    boolean empty=true;
                    Displayarea.setText("");
                    for (Person person : login.db) {
                        if (person instanceof Doctor){
                            empty=false;
                            Doctor convert = (Doctor) person;
                            Displayarea.setText(Displayarea.getText() + convert.print_doctor()+"\n");
                        }
                    }
                    if (empty)
                        Displayarea.setText("No Records Found!");
                }
            });  

            frame.setVisible(true);
        
         
    }
}