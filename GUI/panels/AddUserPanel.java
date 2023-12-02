package GUI.panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Model.*;

public class AddUserPanel extends JPanel implements ActionListener {

    JLabel firstNameLabel,lastNameLabel,position;
    JTextField firstNameField,lastNameField,positionField;
    JButton saveButton = new JButton("Save");
    private Model model;
    public AddUserPanel(Model model){
        this.model = model;
        setBackground(Color.CYAN);
        setLayout(new GridLayout(4,2,10,10));

        firstNameLabel = new JLabel("Enter first name: ");
        firstNameField = new JTextField();

        lastNameLabel = new JLabel("Enter last name: ");
        lastNameField = new JTextField();

        position = new JLabel("Enter position: ");
        positionField = new JTextField();

        saveButton.addActionListener(this);
        add(firstNameLabel);
        add(firstNameField);
        add(lastNameLabel);
        add(lastNameField);
        add(position);
        add(positionField);
        add(new JLabel());
        add(saveButton);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String first_name = firstNameField.getText();
        String last_name = lastNameField.getText();
        String position = positionField.getText();

        User user = model.add(first_name,last_name,position);
        if (user != null){
            JOptionPane.showMessageDialog(saveButton,"Saved");
        }

        firstNameField.setText("");
        lastNameField.setText("");
        positionField.setText("");

    }
}
