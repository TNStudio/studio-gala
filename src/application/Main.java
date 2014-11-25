package application;


import observerPattern.MyObserver;
import application.model.Photographe;
import application.model.PrintRequest;
import application.view.ImageInterfaceController;
import application.view.MainInterfaceController;
import application.view.PrintQueueInterfaceController;
import application.view.SettingsInterfaceController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;
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
	private ObservableList<Photographe> photographeList;
	private ObservableList<PrintRequest> printRequest;
	private String folder ="D:\\Utilisateur\\Dropbox\\Gala2014";
	private Stage primaryStage;
	private Stage secondaryStage;
	private LoadingRoutines routine;

	private FXMLLoader loaderMain;
	private FXMLLoader loaderSettings;
	private FXMLLoader loaderImage;
	private FXMLLoader loaderPrinter;
	private SettingsInterfaceController settingsInterfaceController;
	private MainInterfaceController mainInterfaceController;
	private ImageInterfaceController imageInterfaceController;
	private PrintQueueInterfaceController printInterfaceController;
	private AnchorPane rootMain;
	private AnchorPane rootSettings;
	private AnchorPane rootImage;
	private AnchorPane rootPrint;
	private Scene sceneMain;
	private Scene sceneSettings;
	private Scene sceneImage;
	private Scene scenePrint;

	public Main(){
		setRoutine(new LoadingRoutines(largeur_photo));
		printRequest = FXCollections.observableArrayList();
		printRequest.add(new PrintRequest(0, "test"));
	}

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage=primaryStage;
		this.primaryStage.initStyle(StageStyle.UNDECORATED);
		Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
		primaryStage.setX(primaryScreenBounds.getMinX());
		primaryStage.setY(primaryScreenBounds.getMinY());
		primaryStage.setWidth(primaryScreenBounds.getWidth());
		primaryStage.setHeight(primaryScreenBounds.getHeight());
		primaryStage.setOnHiding(new EventHandler<WindowEvent>() {

			@Override
			public void handle(WindowEvent arg0) {
				primaryStage.show();

			}
		});
		secondaryStage = new Stage();
		try {
			loaderMain = new FXMLLoader();
			loaderSettings = new FXMLLoader();
			loaderImage = new FXMLLoader();
			loaderPrinter = new FXMLLoader();
			loaderSettings.setLocation(Main.class.getResource("view/SettingsInterface.fxml")); //find the GUI file
			loaderMain.setLocation(Main.class.getResource("view/MainInterface.fxml")); //find the GUI file
			loaderImage.setLocation(Main.class.getResource("view/ImageInterface.fxml")); //find the GUI file
			loaderPrinter.setLocation(Main.class.getResource("view/PrintQueueInterface.fxml"));
			rootSettings = loaderSettings.load();
			rootMain = loaderMain.load(); //load the GUI in a AnchorPane
			rootImage = loaderImage.load();
			rootPrint = loaderPrinter.load();
			settingsInterfaceController = loaderSettings.getController();
			mainInterfaceController = loaderMain.getController();
			imageInterfaceController = loaderImage.getController();
			printInterfaceController = loaderPrinter.getController();

			printInterfaceController.setList(printRequest);

			settingsInterfaceController.setMain(this);
			mainInterfaceController.setMain(this);
			imageInterfaceController.setMain(this);
			printInterfaceController.setMain(this);
			sceneMain = new Scene(rootMain); //create a scene with the GUI
			sceneSettings = new Scene(rootSettings); //create a scene with the GUI
			sceneImage = new Scene(rootImage);
			scenePrint = new Scene(rootPrint);
			this.loadInterface(loaderSettings, settingsInterfaceController, sceneSettings);
			primaryStage.show(); //display the window
			launchPrinterStage();
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

	public ObservableList<Photographe> getPhotographeList() {
		return photographeList;
	}

	public void setPhotographeList(ObservableList<Photographe> observableList) {
		this.photographeList = observableList;
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



	public FXMLLoader getLoaderImage() {
		return loaderImage;
	}

	public void setLoaderImage(FXMLLoader loaderImage) {
		this.loaderImage = loaderImage;
	}

	public ImageInterfaceController getImageInterfaceController() {
		return imageInterfaceController;
	}

	public void setImageInterfaceController(
			ImageInterfaceController imageInterfaceController) {
		this.imageInterfaceController = imageInterfaceController;
	}

	public AnchorPane getRootImage() {
		return rootImage;
	}

	public void setRootImage(AnchorPane rootImage) {
		this.rootImage = rootImage;
	}

	public Scene getSceneImage() {
		return sceneImage;
	}

	public void setSceneImage(Scene sceneImage) {
		this.sceneImage = sceneImage;
	}

	public void loadInterface(FXMLLoader loader, MyObserver obs, Scene scene){

		primaryStage.setScene(scene); //put the scene in a stage (window)
		primaryStage.setTitle("GALA printer Service by TN Studio"); //give a name to the window
		//		primaryStage.setFullScreen(true); //set the window in fullscreen mode
		//		primaryStage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
		primaryStage.toFront();
		obs.update();
	}

	public void launchPrinterStage(){
		secondaryStage.setScene(scenePrint);
		secondaryStage.setTitle("GALA printer Service by TN Studio"); //give a name to the window
		secondaryStage.show();
	}

	/**
	 * @return the routine
	 */
	public LoadingRoutines getRoutine() {
		return routine;
	}

	/**
	 * @param routine the routine to set
	 */
	public void setRoutine(LoadingRoutines routine) {
		this.routine = routine;
	}

	public ObservableList<PrintRequest> getPrintRequest() {
		return printRequest;
	}

	public void setPrintRequest(ObservableList<PrintRequest> printRequest) {
		this.printRequest = printRequest;
	}

	public PrintQueueInterfaceController getPrintInterfaceController() {
		return printInterfaceController;
	}

	public void setPrintInterfaceController(
			PrintQueueInterfaceController printInterfaceController) {
		this.printInterfaceController = printInterfaceController;
	}
	
	


}
