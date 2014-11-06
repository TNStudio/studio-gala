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
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
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
	
	private Main main;
	private GridPane photoGridPane;
	
	private Image image;
	
	 public static final ObservableList names = FXCollections.observableArrayList();
	
	@FXML
	private void initialize(){

	}
	
	public void setMain(Main main){
		this.main=main;
		/**
		 * for test
		 */
		photoGridPane = new GridPane(); //create a grid pane to display the pictures
		photoGridPane.setVgap(10); //create gaps to separate pictures
		photoGridPane.setHgap(10); //idem
		photoScroll.setContent(photoGridPane); //put the grid pane into the scrollpane (xml generated)
		image = new Image("file:\\E:\\Pictures\\pitimoi.jpg"); //load a picture
		for(int i = 0; i<100; i++){ //create all the imageviews with the picture inside
			for(int j = 0; j<main.getNb_photo(); j++){
				ImageView imageView = new ImageView(image);
				imageView.setFitWidth(main.getLargeur_photo()); //set the width of the pictures
				imageView.setPreserveRatio(true);
				imageView.setCursor(Cursor.HAND); //change the cursor appearance
				photoGridPane.add(imageView, j, i); //add the imageView to the GUI
			}
		}
		
		
	}

	@Override
	public void update() {
	
		
	}

}
