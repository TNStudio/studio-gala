package application;


import java.io.File;

	
import java.io.IOException;
import java.util.ArrayList;
import application.model.Photo;
import application.model.Photographe;
import application.view.MainInterfaceController;
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

	private int nb_photographe = 3;
	private int largeur_photo = 350;
	private int nb_photo = 5;
	private ArrayList<Photographe> photographeList;
	private String folder ="file:\\E:\\Pictures\\pitimoi.jpg";
	private Stage primaryStage;
	
	public Main(){

<<<<<<< HEAD
		photographeList = new ArrayList<Photographe>();
		for(int i=0; i<nb_photogrpahe;i++){
			photographeList.add(new Photographe(i));
		}
		
=======

>>>>>>> 5d5a023284b735393b7aaffb9f754755183d1207
	}

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage=primaryStage;
		try {
			this.loadMainInterface();
			primaryStage.show(); //display the window
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		launch(args); //invoke start method
	}

	public int getNb_photographe() {
		return nb_photographe;
	}

	public void setNb_photographe(int nb_photographe) {
		this.nb_photographe = nb_photographe;
	}

	public int getLargeur_photo() {
		return largeur_photo;
	}

	public void setLargeur_photo(int largeur_photo) {
		this.largeur_photo = largeur_photo;
	}

	public int getNb_photo() {
		return nb_photo;
	}

	public void setNb_photo(int nb_photo) {
		this.nb_photo = nb_photo;
	}

	public ArrayList<Photographe> getPhotographeList() {
		return photographeList;
	}

	public void setPhotographeList(ArrayList<Photographe> photographeList) {
		this.photographeList = photographeList;
	}

	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	

	public String getFolder() {
		return folder;
	}

	public void setFolder(String folder) {
		this.folder = folder;
	}

	public void loadMainInterface(){
		try {
			FXMLLoader loader = new FXMLLoader(); //create a loader to load the GUI
			loader.setLocation(Main.class.getResource("view/MainInterface.fxml")); //find the GUI file
			AnchorPane root = loader.load(); //load the GUI in a AnchorPane
			Scene scene = new Scene(root); //create a scene with the GUI
			primaryStage.setScene(scene); //put the scene in a stage (window)
			primaryStage.setTitle("GALA printer Service by TN Studio"); //give a name to the window
			primaryStage.setFullScreen(true); //set the window in fullscreen mode
			MainInterfaceController mainInterfaceController = loader.getController();
			mainInterfaceController.setMain(this);
			mainInterfaceController.update();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
