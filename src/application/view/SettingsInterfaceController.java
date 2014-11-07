package application.view;


import java.io.IOException;

import application.Main;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import observerPattern.MyObserver;

public class SettingsInterfaceController implements MyObserver{
	
	@FXML
	private Button validateFolder;
	
	@FXML
	private Button validateWidth;
	
	@FXML
	private Button validateNBPhoto;
	
	@FXML
	private Button quit;
	
	@FXML
	private TextField folderField;
	
	@FXML
	private TextField nb_photoField;
	
	@FXML
	private TextField width_photoField;
	
	
	
	private Main main;
	
	@FXML
	private void initialize(){
		
		
		
		quit.setOnMouseClicked(new EventHandler<MouseEvent>() { //go to the main scene

			@Override
			public void handle(MouseEvent event) {
				main.loadInterface(main.getLoaderMain(), main.getMainInterfaceController(), main.getSceneMain());
			}
		});
		
		validateFolder.setOnMouseClicked(new EventHandler<MouseEvent>() { //save settings to the data model

			@Override
			public void handle(MouseEvent event) {
				main.setFolder(folderField.getText());
			}
		});
		
		validateWidth.setOnMouseClicked(new EventHandler<MouseEvent>() { //save settings to the data model

			@Override
			public void handle(MouseEvent event) {
				main.setLargeur_photo(Integer.valueOf(width_photoField.getText()));
			}
		});
		
		validateNBPhoto.setOnMouseClicked(new EventHandler<MouseEvent>() { //save settings to the data model

			@Override
			public void handle(MouseEvent event) {
				main.setNb_photo(Integer.valueOf(nb_photoField.getText()));
			}
		});
	}
	
	public void setMain(Main main){
		this.main=main;
	}

	@Override
	public void update() {
		folderField.setText(main.getFolder());
		nb_photoField.setText(String.valueOf(main.getNb_photo()));
		width_photoField.setText(String.valueOf(main.getLargeur_photo()));
	}

}
