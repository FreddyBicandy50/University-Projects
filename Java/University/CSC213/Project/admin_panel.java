package Project;

import javax.swing.*; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 

public class admin_panel { 
    // frame panel
    private static JPanel panel = new JPanel();
    private static JFrame frame = new JFrame("Hospital Management System"); 
    public admin_panel() {
        // Window Frame 
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(panel);   
        panel.setLayout(null);

        // add button
        JButton addbtn = new JButton("Add");
        addbtn.setBounds(0, 0, 260, 160);
        panel.add(addbtn);
        // On click on @addbtn
        addbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { 
                    frame.dispose();
                    new add_records();
            }
        });
        
        // Modify button
        JButton Modifybtn = new JButton("Modify");
        Modifybtn.setBounds(260, 0, 265, 160);
        panel.add(Modifybtn); 

        // remove button
        JButton removebtn = new JButton("remove");
        removebtn.setBounds(0, 160, 260, 160);
        panel.add(removebtn); 

        // Display button
        JButton Displaybtn = new JButton("Display");
        Displaybtn.setBounds(260, 160, 265, 160);
        panel.add(Displaybtn);
        // On click on @addbtn
        Displaybtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new Display();
            }
        });  
        frame.setVisible(true);
    }

    
}