package Controllers;

import Model.*;
import View.View;

import java.util.UUID;

public class Controller {
    public void initController(){
        Model model = new Model();
        View view = new View();

        Integer command;
        boolean control = false;
        while (!control){
            view.print_menu();
            command = view.getNum("menu");
            control = switch (command){
                case 1 ->{
                    view.print_msg("Lets create new user");
                    model.add(view.getStr("first name"), view.getStr("last name"), view.getStr("position"));
                    view.print_msg("User created");
                    yield false;
                }
                case 2 ->{
                    view.print_msg("Lets find user");
                    User user = model.find(view.getUUID());
                    if (user != null){
                        view.print_user(user);
                    }else {
                        view.print_msg("Nobody found");
                    }
                    yield false;
                }
                case 3 -> {
                    view.print_msg("Lets update user");
                    User user = model.update(view.getUUID(),
                            view.getStr("New first name"),
                            view.getStr("New last name"),
                            view.getStr("New position"),
                            Role.valueOf(view.getStr("Role")) );
                    if (user != null){
                        view.print_user(user);
                    }else {
                        view.print_msg("Nobody updated");
                    }
                    yield false;
                }
                case 4 ->{
                    view.print_msg("DELETING AREA");
                    Integer deleted = model.delete( (UUID.fromString(view.getStr("USER ID") ) ) );
                    if (deleted != -1){
                        view.print_msg("Was deleted user №: " + deleted);
                    }else {
                        view.print_msg("Nobody deleted");
                    }
                    yield false;
                }
                case 5 ->{
                    view.print_msg("Good bye");
                    yield true;
                }
                default ->{
                    view.print_msg("Wrong menu number");
                    yield false;
                }
            };
        }
    }
}
