package Project.GIUI;

import javax.swing.*; 

public class add_records  { 
    // Creating Frame and panel objects
    public static JFrame add_frame = new JFrame("Hospital Management System");  
    public static JPanel panel = new JPanel(); 

    public add_records() { 
        // Initialise Window Frame
        add_frame.setSize(1000, 600);
        add_frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        add_frame.add(panel); 
        new init();
        init.add_panel();
        

        // Call Functions
        Add_buttons(); 
        AddDoctor();
        //AddNurse();
        //AddPtreatments();
        //AddPSurgery(); 
  
        add_frame.setVisible(true); 
         
    }
    public void Add_buttons(){
        // Setting:
            // Buttons
            init.Goback_btn.setBounds(10, 10, 60, 25);
            init.Goback_btn.setVisible(true);
        //  Calling Button Function 
        init.goback_btn();
    }
    public void AddDoctor(){ 
        // Fields Position   
        init.specLabel.setBounds(init.x, 140, 80, 25);  
        init.specField.setBounds(init.xf, 140, 150, 25);  
        init.Add_info.setBounds(init.x+20, 170, 120, 25);
        // Add Button
        init.Add_btn(1);
    }
    public void AddNurse(){ 
        // Fields Position
        init.DepartmentLabel.setBounds(init.x, 140, 90, 25);
        init.timeLabel.setBounds(init.x, 170, 90, 25); 
        init.ShiftLabel.setBounds(init.x, 200, 90, 25);  
        init.DepartmentField.setBounds(init.xf, 140, 150, 25); 
        init.timeField.setBounds(init.xf, 170, 150, 25);   
        init.ShiftField.setBounds(init.xf, 200, 150, 25);  
        init.Add_info.setBounds(init.x + 20, 230, 120, 25); 
        // Add Button
        init.Add_btn(2);
    }
    public void AddPtreatments(){  
            // Fields Postions
            init.DateLabel.setBounds(init.x, 140, 90, 25);  
            init.timeLabel.setBounds(init.x, 170, 90, 25);  
            init.TreatmentLabel.setBounds(init.x, 200, 90, 25); 
            init.DateField.setBounds(init.xf, 140, 150, 25);  
            init.timeField.setBounds(init.xf, 170, 150, 25); 
            init.treatmentField.setBounds(init.xf, 200, 150, 25); 
            init.Add_info.setBounds(init.xf, 230, 120, 25);  
            // Add Button
            init.Add_btn(3);
    }
    public void AddPSurgery(){ 
            // Fields Positions
            init.DateLabel.setBounds(init.x, 140, 90, 25);
            init.timeLabel.setBounds(init.x, 170, 90, 25);
            init.TreatmentLabel.setBounds(init.x, 200, 90, 25);
            init.DateField.setBounds(init.xf, 140, 150, 25);
            init.timeField.setBounds(init.xf, 170, 150, 25);
            init.treatmentField.setBounds(init.xf, 200, 150, 25); 
            init.SrugeryLabel.setBounds(init.x, 230, 130, 25);   
            init.SrugeryField.setBounds(init.xf, 230, 150, 25);  
            init.Add_info.setBounds(init.xf, 260, 120, 25);  
            // Add Button
            init.Add_btn(4);

}
}