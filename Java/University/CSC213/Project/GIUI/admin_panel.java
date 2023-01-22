package Project.GIUI;

import javax.swing.*; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 

public class admin_panel { 
    // frame panel
    private static JPanel panel = new JPanel();
    private static JFrame frame = new JFrame("Hospital Management System"); 

    //buttons 
    private static JButton addbtn = new JButton("Add");
    private static JButton removebtn = new JButton("remove");
    private static JButton Modifybtn = new JButton("Modify");
    private static JButton Displaybtn = new JButton("Display"); 
    public admin_panel() {
        // Window Frame 
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(panel);   
        //adding buttons on frame
        panel.setLayout(null);
        panel.add(addbtn);
        panel.add(Modifybtn);
        panel.add(removebtn);
        panel.add(Displaybtn);

        //setting buttons on the frame 
        addbtn.setBounds(0, 0, 260, 160);
        Modifybtn.setBounds(260, 0, 265, 160);
        Displaybtn.setBounds(260, 160, 265, 160);
        removebtn.setBounds(0, 160, 260, 160);
        

        //Calling on click button Function 
        Add_func();
        Modify_func();
        Remove_func();
        Display_func(); 
        frame.setVisible(true);
}

 
public void Add_func(){
        addbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { 
                    frame.dispose();
                    new add_records();
            }
        });
    }    
public void Modify_func(){
            Modifybtn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    frame.dispose();
                    new modify();
                }
            });
        }
public void Remove_func(){
            removebtn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    frame.dispose();
                    new remove_record();
                }
            });
        }        
public void Display_func(){
        Displaybtn.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new Display();
            }
        }); 
    }

}