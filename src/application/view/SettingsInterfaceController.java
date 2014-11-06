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
	private Button quit;
	
	@FXML
	private TextField folderField;
	
	private Main main;
	
	@FXML
	private void initialize(){
		
		
		
		quit.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				main.loadMainInterface();
			}
		});
		
		validateFolder.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				main.setFolder(folderField.getText());
			}
		});
		
	}
	
	public void setMain(Main main){
		this.main=main;
	}

	@Override
	public void update() {
		folderField.setText(main.getFolder());
		
	}

}
