package GUI.panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Model.*;

public class AddUserPanel extends JPanel implements ActionListener {

    JLabel firstNameLabel,lastNameLabel,position;
    JTextField firstNameField,lastNameField,positionField;
    JTextArea textArea;

    JButton saveButton = new JButton("Save");
    private Model model;
    public AddUserPanel(Model model){
        this.model = model;

        setLayout(new GridLayout(5,2,10,10));

        textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setOpaque(true);
        firstNameLabel = new JLabel("First name: ");
        firstNameField = new JTextField();
        firstNameField.setOpaque(true);
        firstNameField.setForeground(Color.GREEN);
        textArea.setForeground(Color.GREEN);
        textArea.setWrapStyleWord(true);
        textArea.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
       

        lastNameLabel = new JLabel("Last name: ");
        lastNameField = new JTextField();
        lastNameField.setOpaque(true);
        lastNameField.setForeground(Color.GREEN);

        position = new JLabel("Position: ");
        positionField = new JTextField();
        positionField.setOpaque(true);
        positionField.setForeground(Color.GREEN);

        saveButton.addActionListener(this);

        add(firstNameLabel);
        add(firstNameField);
        add(lastNameLabel);
        add(lastNameField);
        add(position);
        add(positionField);
        add(new JLabel());
        add(saveButton);
        add(textArea);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String first_name = firstNameField.getText();
        String last_name = lastNameField.getText();
        String position = positionField.getText();

        User user = model.add(first_name,last_name,position);

        if (user != null){
            textArea.setText("" + user.getId());
            JOptionPane.showMessageDialog(this,"Saved: " + user.getId(),"User id", JOptionPane.INFORMATION_MESSAGE);
        }else{

            JOptionPane.showMessageDialog(saveButton,"ERROR");
        }

        firstNameField.setText("");
        lastNameField.setText("");
        positionField.setText("");

    }
}
