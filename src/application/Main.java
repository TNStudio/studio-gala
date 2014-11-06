package application;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

import application.model.Photo;
import application.model.Photographe;
import application.view.MainInterfaceController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
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
	private ArrayList<Photo> photoList;

	public Main(){


	}

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
			MainInterfaceController mainInterfaceController = loader.getController();
			mainInterfaceController.setMain(this);
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

	public void loadingImagesRoutine(String directory){		
		File[] files;
		File dir = new File(directory);
		File subdir;
		String[] photographes = dir.list();
		
		for(String s : photographes) {
			photographeList.add(new Photographe(Integer.parseInt(s)));
			subdir = new File(directory + "\\" + s);
			files = subdir.listFiles();
			for(File f : files) {
				photoList.add(new Photo(f.getName(), Integer.parseInt(s)));
			}
		}   
		setNb_photographe(photographeList.size());
		setNb_photo(photoList.size());
	}
}
