package GUI.panels;

import javax.swing.*;
import Model.*;

import java.awt.*;

public class MenuPanel extends JPanel {
    private Model model;
    private JTextField loginField;
    private JPasswordField passwordField;
    private JLabel labellogin,labelpassword;
    public MenuPanel(Model model){
        this.model = model;
        setLayout(new GridLayout(3,2,10,10));
        labellogin = new JLabel("Login");
        loginField = new JTextField();
        passwordField = new JPasswordField();
        labelpassword = new JLabel("Password");

    }
}
