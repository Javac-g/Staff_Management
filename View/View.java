package View;

import Model.User;

import java.util.Scanner;
import java.util.UUID;

public class View {
    private static final Scanner scanner = new Scanner(System.in);

    public void print_menu(){
        System.out.println("__   M E N U   __");
        System.out.println("1 - add user");
        System.out.println("2 - find user");
        System.out.println("3 - update user");
        System.out.println("4 - delete user");
        System.out.println("5 - exit");
    }
    public void print_msg(String msg){
        System.out.println(msg);
    }
    public void print_user(User user){
        System.out.println("\nFirst name: " + user.getFirst_name());
        System.out.println("Last name: " + user.getLast_name());
        System.out.println("ID: " + user.getId());
        System.out.println("Position: " + user.getPosition());
    }
    public Integer getNum(String msg){
        System.out.println("Enter " + msg + ": ");
        return scanner.nextInt();
    }
    public String getStr(String msg){
        System.out.println("Enter " + msg + ": ");
        return scanner.next();
    }
    public UUID getUUID(){
        System.out.println("Enter UUID: ");
        return UUID.fromString( scanner.next());
    }

}
