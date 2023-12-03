package GUI.panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.UUID;

import Model.*;
import View.View;

public class FindUserPanel extends JPanel implements ActionListener {
    private Model model;
    private View view;

    JLabel searchNameLabel,searchLastNameLabel,uuidLabel;
    JTextField firstNameField,lastNameField,uuidField;
    JButton searchButton = new JButton("Search");
    JCheckBox checkBox = new JCheckBox("Return all match");
    JTextArea result = new JTextArea();
    private boolean isAllCheck = checkBox.isSelected();
    public FindUserPanel(Model model){
        this.model = model;
        setLayout(new GridLayout(5,2,10,10));
        searchNameLabel = new JLabel("Enter first name: ");
        firstNameField = new JTextField();

        searchLastNameLabel = new JLabel("Enter last name: ");
        lastNameField = new JTextField();

        uuidLabel = new JLabel("Enter UUID: ");
        uuidField = new JTextField();

        checkBox.addActionListener(this);


        if (isAllCheck){
            firstNameField.setEnabled(true);
            lastNameField.setEnabled(true);
            uuidField.setEnabled(false);
        }else{
            firstNameField.setEnabled(false);
            lastNameField.setEnabled(false);
            uuidField.setEnabled(true);
        }

        searchButton.addActionListener(this);

        add(searchNameLabel);
        add(firstNameField);

        add(searchLastNameLabel);
        add(lastNameField);

        add(uuidLabel);
        add(uuidField);
        add(checkBox);
        add(new JLabel());
        add(searchButton);
        add(result);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == checkBox){
            if (checkBox.isSelected()){
                firstNameField.setEnabled(true);
                lastNameField.setEnabled(true);
                uuidField.setEnabled(false);
            }else{
                firstNameField.setEnabled(false);
                lastNameField.setEnabled(false);
                uuidField.setEnabled(true);
            }
        }
        if (e.getSource() == searchButton) {



            if (checkBox.isSelected()) {
                String first_name = firstNameField.getText();
                String last_name = lastNameField.getText();
                allMatchSearch(first_name, last_name);
            } else {
                UUID uuid = UUID.fromString(uuidField.getText());
                IdSearch(uuid);
            }


            firstNameField.setText("");
            lastNameField.setText("");
            uuidField.setText("");
        }

    }
    private void IdSearch(UUID uuid){
         User user = model.find(uuid);
        JOptionPane.showMessageDialog(result,
                "\nFirst name: " + user.getFirst_name() +
                "\nLast name: " + user.getLast_name() +
                "\nID: " + user.getId() +
                "\nPosition: " + user.getPosition());
    }
    public void allMatchSearch(String x, String y){
        List<User> users =  model.findMatch(x,y);
        JOptionPane.showMessageDialog(result,users);
    }

}
