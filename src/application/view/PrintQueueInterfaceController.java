package application.view;

import application.Main;
import application.model.Photo;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import observerPattern.MyObserver;

public class PrintQueueInterfaceController implements MyObserver {
	@FXML
	private TableView<Photo> printQueueTable;
	@FXML
	private TableColumn<Photo, String> firstNameColumn;
	@FXML
	private TableColumn<Photo, String> lastNameColumn;
	
	private Main main;
	public PrintQueueInterfaceController() {

	}

	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 */
	@FXML
	private void initialize() {
		// Initialize the person table with the two columns.
		//firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().getPath());
//		lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

	public Main getMain() {
		return main;
	}

	public void setMain(Main main) {
		this.main = main;
	}
	
	

}
