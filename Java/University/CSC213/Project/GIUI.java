package Project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GIUI {
    /**
     * @param args
     */
    public static void main(String[] args) {
        //Window Frame
        JFrame frame = new JFrame("Hospital Management System");
        frame.setSize(1300, 800);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        //frame panel
        JPanel panel = new JPanel();
        frame.add(panel, BorderLayout.LINE_START);
        
        //input label
        JLabel nameLabel = new JLabel("Name:");
        //input size
        JTextField nameField = new JTextField(20);
        JLabel ageLabel = new JLabel("Age:");
        JTextField ageField = new JTextField(20);
        
        //input button
        JButton addButton = new JButton("Add Doctor");
        addButton.addActionListener((ActionListener) new ActionListener() {
            public void actionPerformed(Action e) {
                // Code for handling the add button event
                String name = nameField.getText();
                String age = ageField.getText();
                Person person = new Person(name, age);
                int nextIndex;
                Person[] people;
                // Add the person to the people array
                people[nextIndex] = person;
                nextIndex++;
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                
            }
        });
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(ageLabel);
        panel.add(ageField);
        panel.add(addButton);
        
    }   
}