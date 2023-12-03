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
        textArea.setForeground(Color.GREEN);
        textArea.setWrapStyleWord(true);
        textArea.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
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
