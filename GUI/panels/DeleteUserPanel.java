package GUI.panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.UUID;

import Model.*;

public class DeleteUserPanel extends JPanel implements ActionListener {
    private Model model;
    private JTextArea textArea;
    private JButton submit;
    public DeleteUserPanel(Model model){
        this.model = model;
        setLayout(new FlowLayout() );
        textArea  = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setOpaque(true);
        textArea.setForeground(Color.RED);
        textArea.setWrapStyleWord(true);
        textArea.setPreferredSize(new Dimension(120,40));
        submit = new JButton("Delete user");
        submit.addActionListener(this);
        submit.setPreferredSize(new Dimension(120,40));

        add(textArea);
        add(submit);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        UUID todelete = UUID.fromString(textArea.getText());
        Integer index = model.delete(todelete);
        if (index != -1){
            JOptionPane.showMessageDialog(this,"Was deleted user N: " + index);
        }
    }
}
