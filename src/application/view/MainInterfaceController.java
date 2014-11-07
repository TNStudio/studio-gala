/**
 * 
 */
package application.view;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout.Alignment;

import observerPattern.MyObserver;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;
import application.Main;
import application.model.Photo;
import application.model.Photographe;

/**
 * A class that give the ids of the GUI components and implements their behaviors
 * @author Martin
 *
 */
public class MainInterfaceController implements MyObserver{

	@FXML
	private ScrollPane photoScroll;

	@FXML
	private ListView<Photographe> listPhotographe;

	@FXML
	private Button settings;

	@FXML
	private Button refresh;

	private Main main;
	private GridPane photoGridPane;

	private Image image;

	//public static final ObservableList<String> names = FXCollections.observableArrayList();

	@FXML
	private void initialize(){

		photoGridPane = new GridPane(); //create a grid pane to display the pictures
		photoGridPane.setVgap(10); //create gaps to separate pictures
		photoGridPane.setHgap(10); //idem
		photoScroll.setContent(photoGridPane); //put the grid pane into the scrollpane (xml generated)

		settings.setOnMouseClicked(new EventHandler<MouseEvent>() { //load another scene

			@Override
			public void handle(MouseEvent event) {
				/*FXMLLoader loader = new FXMLLoader(); //create a loader to load the GUI
				loader.setLocation(Main.class.getResource("view/SettingsInterface.fxml")); //find the GUI file
				AnchorPane root = loader.load(); //load the GUI in a AnchorPane
				Scene scene = new Scene(root); //create a scene with the GUI
				main.getPrimaryStage().setScene(scene); //put the scene in a stage (window)
				main.getPrimaryStage().setFullScreen(true);
				main.getPrimaryStage().setTitle("GALA printer Service by TN Studio"); //give a name to the window
				SettingsInterfaceController settingsInterfaceController = loader.getController();
				settingsInterfaceController.setMain(main); //give the model to the scene's controller
				settingsInterfaceController.update();*/
				main.loadInterface(main.getLoaderSettings(), main.getSettingsInterfaceController(), main.getSceneSettings());
			}
		});


		refresh.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				update();
			}
		});


	}

	public void setMain(Main main){
		this.main=main;




	}

	@Override
	public void update() { //re-build the view

		ObservableList<Photographe> names = FXCollections.observableArrayList(main.getPhotographeList());
		
		listPhotographe.setItems(names);

		image = new Image(main.getFolder()); //load a picture
		for(int i = 0; i<100; i++){ //create all the imageviews with the picture inside
			for(int j = 0; j<main.getNb_photo(); j++){
				ImageView imageView = new ImageView(image);
				imageView.setFitWidth(main.getLargeur_photo()); //set the width of the pictures
				imageView.setPreserveRatio(true);
				imageView.setOnMouseClicked(new EventHandler<MouseEvent>() {

					@Override
					public void handle(MouseEvent event) {
						System.out.println("clicked");						
					}
				});
				imageView.setCursor(Cursor.HAND); //change the cursor appearance
				photoGridPane.add(imageView, j, i); //add the imageView to the GUI
			}
		}

	}

}
