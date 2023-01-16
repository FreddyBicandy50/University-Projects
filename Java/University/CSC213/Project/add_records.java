package Project; 
import javax.swing.*; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class add_records  { 
    //frame panel
    private static JPanel panel = new JPanel();
    private static JFrame frame = new JFrame("Hospital Management System"); 
    private static int count=0;
 
    public add_records() {
        //Window Frame
        frame.setSize(1000, 600);
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

        //ADD A DOCTOR 
        //@name Field label
        JLabel drnameLabel = new JLabel("Name:");
        drnameLabel.setBounds(10,50,80,25);
        panel.add(drnameLabel);
        // name Field input box 
        JTextField drnameField = new JTextField(20);
        drnameField.setText("");
        drnameField.setBounds(60, 50, 150, 25);
        panel.add(drnameField);
        
        //@age Field label 
        JLabel drageLabel = new JLabel("Age:");
        drageLabel.setBounds(10,85,80,25);
        panel.add(drageLabel);
        //age Field input box 
        JTextField drageField = new JTextField(20);
        drageField.setBounds(60, 85, 150, 25);
        drageField.setText("");
        panel.add(drageField);

        //@id Field label
        JLabel dridLabel = new JLabel("Id:");
        dridLabel.setBounds(10,120,80,25);
        panel.add(dridLabel);
        //id Field input box 
        JTextField dridField = new JTextField(20);
        dridField.setBounds(60, 120, 150, 25);
        dridField.setText("");
        panel.add(dridField);
 
        //@speciality Field Label
        JLabel drspecLabel = new JLabel("Speciality:");
        drspecLabel.setBounds(10,155,80,25);
        panel.add(drspecLabel); 
        //speciality Field input box 
        JTextField drspecField = new JTextField(20);
        drspecField.setBounds(90, 155, 150, 25);
        drspecField.setText("");
        panel.add(drspecField);  

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
                    dridField.getText().isEmpty() || 
                    drnameField.getText().equals("") || 
                    drageField.getText().equals("") ||   
                    drspecField.getText().equals("")
                    ){
                        //display error message
                        message.setBounds(10, 230, 600, 25);
                        message.setText("empty Fields");
                }else{ 
                        //get values from text fields
                        int id=Integer.parseInt(dridField.getText());
                        String name = drnameField.getText(), age = drageField.getText(), spec = drspecField.getText();

                        // Add the doctor to the array database 
                        Doctor add_dr = new Doctor(name, age, id, spec); 
                        login.db.add(add_dr);
                        count++;

                        // Display success message
                        message.setText("Added Successfully! "+count);
                }
                //reset all fileds
                drnameField.setText("");
                drageField.setText("");
                dridField.setText("");
                drspecField.setText("");
            }
        });


        //ADD A NURSE
        //@name Field label
        JLabel nurse_nameLabel = new JLabel("Name:");
        nurse_nameLabel.setBounds(600,50,80,25);
        panel.add(nurse_nameLabel);
        // name Field input box 
        JTextField nurse_nameField = new JTextField(20);
        nurse_nameField.setText("");
        nurse_nameField.setBounds(620, 50, 150, 25);
        panel.add(nurse_nameField);
        
        //@age Field label 
        JLabel nurse_ageLabel = new JLabel("Age:");
        nurse_ageLabel.setBounds(600,85,80,25);
        panel.add(nurse_ageLabel);
        //age Field input box 
        JTextField nurse_ageField = new JTextField(20);
        nurse_ageField.setBounds(620, 85, 150, 25);
        nurse_ageField.setText("");
        panel.add(nurse_ageField);

        //@id Field label
        JLabel nurse_idLabel = new JLabel("Id:");
        nurse_idLabel.setBounds(600,120,80,25);
        panel.add(nurse_idLabel);
        //id Field input box 
        JTextField nurse_idField = new JTextField(20);
        nurse_idField.setBounds(60, 120, 150, 25);
        nurse_idField.setText("");
        panel.add(nurse_idField);
        
        //@speciality Field Label
        JLabel nurse_specLabel = new JLabel("Speciality:");
        nurse_specLabel.setBounds(600,155,80,25);
        panel.add(nurse_specLabel); 
        //speciality Field input box 
        JTextField specField = new JTextField(20);
        specField.setBounds(90, 155, 150, 25);
        specField.setText("");
        panel.add(specField);  

        // Add doctor button
        JButton add_nrbtn = new JButton("Add Doctor");
        add_nrbtn.setBounds(20, 190, 120, 25);
        panel.add(add_nrbtn);  

        // On click @add_dr_Button
        /*add_nrbtn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) { 
                // if One of the textfileds are empty display an error message 
                if (
                    nurse_nameLabel.getText().isEmpty() || 
                    nurse_idField.getText().equals("") || 
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
        });*/
       


            frame.setVisible(true);
        
         
    }
}