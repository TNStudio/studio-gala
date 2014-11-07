package application;


import java.io.File;

	
import java.io.IOException;
import java.util.ArrayList;

import observerPattern.MyObserver;
import application.model.Photo;
import application.model.Photographe;
import application.view.MainInterfaceController;
import application.view.SettingsInterfaceController;
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
	private String folder ="file:\\E:\\Pictures\\pitimo.jpg";
	private Stage primaryStage;
	
	private FXMLLoader loaderMain;
	private FXMLLoader loaderSettings;
	private SettingsInterfaceController settingsInterfaceController;
	private MainInterfaceController mainInterfaceController;
	private AnchorPane rootMain;
	private AnchorPane rootSettings;
	private Scene sceneMain;
	private Scene sceneSettings;
	
	public Main(){

		photographeList = new ArrayList<Photographe>();
		for(int i=0; i<nb_photographe;i++){
			photographeList.add(new Photographe(i));
		}
	}

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage=primaryStage;
		try {
			loaderMain = new FXMLLoader();
			loaderSettings = new FXMLLoader();
			loaderSettings.setLocation(Main.class.getResource("view/SettingsInterface.fxml")); //find the GUI file
			loaderMain.setLocation(Main.class.getResource("view/MainInterface.fxml")); //find the GUI file
			rootSettings = loaderSettings.load();
			rootMain = loaderMain.load(); //load the GUI in a AnchorPane
			settingsInterfaceController = loaderSettings.getController();
			mainInterfaceController = loaderMain.getController();
			settingsInterfaceController.setMain(this);
			mainInterfaceController.setMain(this);
			sceneMain = new Scene(rootMain); //create a scene with the GUI
			sceneSettings = new Scene(rootSettings); //create a scene with the GUI
			this.loadInterface(loaderSettings, settingsInterfaceController, sceneSettings);
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
	
	
	
	

	public AnchorPane getRootMain() {
		return rootMain;
	}

	public void setRootMain(AnchorPane rootMain) {
		this.rootMain = rootMain;
	}

	public AnchorPane getRootSettings() {
		return rootSettings;
	}

	public void setRootSettings(AnchorPane rootSettings) {
		this.rootSettings = rootSettings;
	}

	public FXMLLoader getLoaderMain() {
		return loaderMain;
	}

	public void setLoaderMain(FXMLLoader loaderMain) {
		this.loaderMain = loaderMain;
	}

	public FXMLLoader getLoaderSettings() {
		return loaderSettings;
	}

	public void setLoaderSettings(FXMLLoader loaderSettings) {
		this.loaderSettings = loaderSettings;
	}

	public SettingsInterfaceController getSettingsInterfaceController() {
		return settingsInterfaceController;
	}

	public void setSettingsInterfaceController(
			SettingsInterfaceController settingsInterfaceController) {
		this.settingsInterfaceController = settingsInterfaceController;
	}

	public MainInterfaceController getMainInterfaceController() {
		return mainInterfaceController;
	}

	public void setMainInterfaceController(
			MainInterfaceController mainInterfaceController) {
		this.mainInterfaceController = mainInterfaceController;
	}
	
	

	public Scene getSceneMain() {
		return sceneMain;
	}

	public void setSceneMain(Scene sceneMain) {
		this.sceneMain = sceneMain;
	}

	public Scene getSceneSettings() {
		return sceneSettings;
	}

	public void setSceneSettings(Scene sceneSettings) {
		this.sceneSettings = sceneSettings;
	}

	public void loadInterface(FXMLLoader loader, MyObserver obs, Scene scene){
		primaryStage.setScene(scene); //put the scene in a stage (window)
		primaryStage.setTitle("GALA printer Service by TN Studio"); //give a name to the window
		primaryStage.setFullScreen(true); //set the window in fullscreen mode
		obs.update();
	}
}
