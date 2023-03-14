import Controller.Controller;

import Model.Program;
import View.View;
import javafx.application.*;
import javafx.stage.Stage;

public class Main extends Application{

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Program theModel = new Program();
		View theView = new View(primaryStage);
		Controller controller = new Controller(theModel, theView);
	}

}
