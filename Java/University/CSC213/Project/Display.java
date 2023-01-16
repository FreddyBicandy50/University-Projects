package Project; 
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 

public class Display {
    // frame panel
    private static JPanel panel = new JPanel();
    private static JFrame frame = new JFrame("Hospital Management System");

    public Display(){   

        //Window Frame 
        frame.setSize(1920, 1366);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(panel); 
        panel.setLayout(null);  

        // go back button
        JButton addbtn = new JButton("\u2190");
        addbtn.setBounds(0, 5, 60, 25);
        panel.add(addbtn);
        addbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Code for handling the add button event
                frame.dispose();
                new admin_panel();
            }
        });

        //Display area
        JTextArea Displayarea = new JTextArea("Display Area"); 
        Displayarea.setBounds(0,45, 1920, 850);
        Displayarea.setEditable(false); 
        panel.add(Displayarea);
        JButton displaydr = new JButton("Display Doctors");
        displaydr.setBounds(150, 890, 150, 25);
        panel.add(displaydr);
        displaydr.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Code for handling the add button event
                boolean empty = true;
                Displayarea.setText("");
                for (Person person : login.db) {
                    if (person instanceof Doctor) {
                        empty = false;
                        Doctor convert = (Doctor) person;
                        Displayarea.setText(Displayarea.getText() + convert.print_doctor() + "\n");
                    }
                }
                if (empty)
                    Displayarea.setText("No Records Found!");
            }
        });
        frame.setVisible(true);
    }
    
}
