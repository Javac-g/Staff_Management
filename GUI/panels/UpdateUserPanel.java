package GUI.panels;

import Model.*;
import View.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.UUID;

public class UpdateUserPanel extends JPanel implements ActionListener {
    private Model model;
    private View view;

    JLabel newFirstNameLabel,newLastNameLabel,newUuidLabel,newRoleLabel,newPosition;
    JTextField firstNameField,lastNameField,uuidField,positionField;
    JComboBox<Role>  roleJComboBox;
    JButton updateButton = new JButton("Update");

    JTextArea result = new JTextArea();
    public UpdateUserPanel(Model model){
        this.model = model;
        setLayout(new GridLayout(6,2,10,10));
        newUuidLabel = new JLabel("Enter  UUID: ");
        uuidField = new JTextField();

        newFirstNameLabel = new JLabel("Enter new first name: ");
        firstNameField = new JTextField();

        newLastNameLabel = new JLabel("Enter new last name: ");
        lastNameField = new JTextField();

        newPosition = new JLabel("Enter new position");
        positionField = new JTextField();

        newRoleLabel = new JLabel("Choose role");
        roleJComboBox  = new JComboBox<>();
        roleJComboBox.addItem(Role.COMMON_USER);
        roleJComboBox.addItem(Role.ADMIN);
        roleJComboBox.addItem(Role.VIP);
        roleJComboBox.addItem(Role.FRAUD);
        roleJComboBox.addItem(Role.SUSPENDED);
        roleJComboBox.addItem(Role.COMMON_USER);

        result.setOpaque(true);
        result.setForeground(Color.green);

        updateButton.addActionListener(this);

        add(newUuidLabel);
        add(uuidField);
        add(newFirstNameLabel);
        add(firstNameField);
        add(newLastNameLabel);
        add(lastNameField);
        add(newPosition);
        add(positionField);
        add(newRoleLabel);
        add(roleJComboBox);
        add(result);
        add(updateButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String neFName = firstNameField.getText();
        String neLName = lastNameField.getText();
        String position = positionField.getText();
        Role role = (Role)roleJComboBox.getSelectedItem();

        UUID uuid = UUID.fromString( uuidField.getText());

        User user = model.update(uuid,neFName,neLName,position,role);
        JOptionPane.showMessageDialog(result,user);


    }
}
