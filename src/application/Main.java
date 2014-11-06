package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

/**
 * Main class of the project
 * @author Martin
 *
 */
public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader(); //create a loader to load the GUI
            loader.setLocation(Main.class.getResource("view/MainInterface.fxml")); //find the GUI file
			AnchorPane root = loader.load(); //load the GUI in a AnchorPane
			Scene scene = new Scene(root); //create a scene with the GUI
			primaryStage.setScene(scene); //put the scene in a stage (window)
			primaryStage.setTitle("GALA printer Service by TN Studio"); //give a name to the window
			primaryStage.setFullScreen(true); //set the window in fullscreen mode
			primaryStage.show(); //display the window
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args); //invoke start method
	}
}
