package GUI;
import com.formdev.flatlaf.FlatDarkLaf;
import GUI.panels.*;
import Model.Model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class MainFrame extends JFrame implements ActionListener {


    private final JPanel container;
    private JPanel buttons;
    private JButton add,find, update,delete,menu;
    private Map<String , Runnable>  actions ;
    private  Model model = new Model();

    public MainFrame(){
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (Exception ex) {
            System.err.println("Failed to initialize FlatLaf");
        }
        MenuPanel menuPanel = new MenuPanel();
        setPreferredSize(new Dimension(600,300));
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        container = new JPanel();
        container.setLayout(new BorderLayout());
        container.add(menuPanel,BorderLayout.CENTER);

        init_actions();
        init_buttons();

        add(container,BorderLayout.CENTER);
        add(buttons,BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        setTitle("Menu");
        setVisible(true);

    }
    private void init_buttons(){

        add = new JButton("Add user");
        find = new JButton("Find user");
        update = new JButton("Update user");
        delete = new JButton("Delete user");
        menu = new JButton("Menu");

        add.addActionListener(this::actionPerformed);
        find.addActionListener(this::actionPerformed);
        update.addActionListener(this::actionPerformed);
        delete.addActionListener(this::actionPerformed);
        menu.addActionListener(this::actionPerformed);

        buttons = new JPanel();

        buttons.add(add);
        buttons.add(find);
        buttons.add(update);
        buttons.add(delete);
    }
    public void init_actions(){
        actions = new HashMap<>();
        actions.put("Add user",() -> {change_panel(new AddUserPanel(model));});

        actions.put("Find user",() ->{change_panel(new FindUserPanel(model));});

        actions.put("Update user",() ->{ change_panel(new UpdateUserPanel(model));});

        actions.put("Delete user",() ->{change_panel(new DeleteUserPanel());});
    }

    public void change_panel(JPanel panel){
        container.removeAll();
        container.add(panel, BorderLayout.CENTER);
        container.validate();
        container.repaint();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton) e.getSource();
        Runnable action = actions.get(source.getText());
        if (action != null) {
            action.run();
        }
    }
}
