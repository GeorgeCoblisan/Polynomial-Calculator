package MainProgram;

import Controller.Controller;
import DataModels.Model;
import GraphicalUserInterface.View;

public class Main {

    public static void main(String[] args) {
        Model model = new Model();
        View view = new View(model);
        Controller controller = new Controller(model, view);
    }
}
