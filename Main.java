import Controllers.Controller;
import Controllers.GuiController;

public class Main {
    public static void main(String...args){
//        Controller controller = new Controller();
//        controller.initController();
        GuiController guiController = new GuiController();
        guiController.init_controller();
    }
}
