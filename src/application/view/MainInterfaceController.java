/**
 * 
 */
package application.view;

import javax.swing.GroupLayout.Alignment;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import application.Main;
import application.model.Photo;

/**
 * A class that give the ids of the GUI components and implements their behaviors
 * @author Martin
 *
 */
public class MainInterfaceController {
	
	@FXML
	private ScrollPane photoScroll;
	
	@FXML
	private Button button;
	
	private Main main;
	private GridPane photoGridPane;
	
	@FXML
	private void initialize(){
		
	}
	
	public void setMain(Main main){
		this.main=main;
		/**
		 * for test
		 */
		photoGridPane = new GridPane();
		photoGridPane.setVgap(10);
		photoGridPane.setHgap(10);
		photoScroll.setContent(photoGridPane);
		System.out.println("in setMain controller");
		
		Image image = new Image(main.getClass().getResourceAsStream("lolo thales.gif"));
		for(int i = 0; i<100; i++){
			for(int j = 0; j<5; j++){
				ImageView imageView = new ImageView(image);
				imageView.setFitWidth(350);
				imageView.setPreserveRatio(true);
				imageView.setCursor(Cursor.HAND);
				photoGridPane.add(imageView, j, i);
				System.out.println("i = "+i+" j= "+j);
			}
		}
		
		
	}

}
