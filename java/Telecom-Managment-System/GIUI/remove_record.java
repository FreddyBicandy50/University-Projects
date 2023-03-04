package Project.GIUI; 
import javax.swing.*; 
import Project.OOP.Person; 

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class remove_record {
    // frame panel
    private static JPanel panel = new JPanel();
    private static JFrame frame = new JFrame("Hospital Management System");
    private static JLabel message = new JLabel("");
    private static JTextField remove_byid = new JTextField(20);

    public remove_record() {
        // Window Frame
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.setLayout(null);
        message.setText("");
        remove_byid.setText("\tEnter Record ID");
        remove_byid.setBounds(100, 110, 300, 25);
        panel.add(remove_byid);
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

        remove();  
        
        frame.setVisible(true);

    }

    public void remove() { 
        // @id Field label  
        remove_byid.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (remove_byid.getText().equals("\tEnter Record ID")) {
                    remove_byid.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (remove_byid.getText().equals(""))
                    remove_byid.setText("");

            }
        });

        // delete record button
        JButton delete = new JButton("Delete Record");
        delete.setBounds(135, 170, 230, 25);
        panel.add(delete);

        // On click @add_dr_Button
        delete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { 
                if (remove_byid.getText().equals("\tEnter Record ID") ||  remove_byid.getText()
                        .equals("") || remove_byid.getText().equals(" ") ){
                        // display error message
                        message.setBounds(200, 210, 600, 25);
                        message.setText("id field is empty");
                } else if (remove_byid.getText().matches("^[a-zA-Z]*$")) {
                        message.setBounds(200, 210, 600, 25);
                        message.setText("id field has to be a number");
                }else{ 
                    // Add the doctor to the array database 
                    boolean found=false;
                    int getid=Integer.parseInt(remove_byid.getText());
                    for (Person person : login.db) {
                        if (person.id==getid) {
                            found=true;
                            login.db.remove(person); 
                            break;  
                        }
                        // reset all fileds
                        remove_byid.setText("\tEnter Record ID"); 
                    }  
                    if (found) message.setText("Record deleted Successfully"); 
                    else message.setText("Record not found!"); 
                }

            }
        });
    }


}
