/**
 * 
 */
package application.view;

import observerPattern.MyObserver;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import application.Main;
import application.model.MyImage;
import application.model.Photographe;

/**
 * A class that give the ids of the GUI components and implements their behaviors
 * @author Martin
 *
 */
public class MainInterfaceController implements MyObserver, EventHandler<MouseEvent>{

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
	Photographe selectedPhotograph;

	

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

				main.loadInterface(main.getLoaderSettings(), main.getSettingsInterfaceController(), main.getSceneSettings());
			}
		});


		refresh.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				update();
			}
		});
		
		listPhotographe.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				//ListView<Photographe> list = (ListView<Photographe>) arg0.getSource();
				update();
			}
		});


	}

	public void setMain(Main main){
		this.main=main;
		


	}
	
	public void updatePhotographerList(){
		listPhotographe.setItems(main.getPhotographeList());
	}

	@Override
	public void update() { //re-build the view
		System.out.println("in update");
		selectedPhotograph = listPhotographe.getSelectionModel().getSelectedItem();
		try {
			System.out.println( listPhotographe.getSelectionModel().getSelectedItem().getName().getValue());
		} catch (NullPointerException e) {
			listPhotographe.getSelectionModel().select(0);
			selectedPhotograph = listPhotographe.getSelectionModel().getSelectedItem();
		}
		//Photographe selectedPhotograph = main.getPhotographeList().get(0);
		
		for(int i = 0; i<main.getPhotographeList().size(); i++){
			System.out.println("Photographe "+main.getPhotographeList().get(i).getNumero().getValue());
			for(int j=0; j<main.getPhotographeList().get(i).getPhotoList().size();j++){
				System.out.println("photo "+main.getPhotographeList().get(i).getPhotoList().get(j).getPath().getValue());
			}
		}

		photoGridPane.getChildren().clear();
		
		int nb_ligne = selectedPhotograph.getPhotoList().size()/main.getNb_photo();
		for(int i = 0; i<nb_ligne; i++){ //create all the imageviews with the picture inside
			for(int j = 0; j<main.getNb_photo(); j++){
				MyImage image = new MyImage("file:\\"+selectedPhotograph.getPhotoList().get(i*main.getNb_photo()+j).getPath().getValue());
				//System.out.println(selectedPhotograph.getPhotoList().get(i+j).getPath().getValue());
				ImageView imageView = new ImageView(image);
				imageView.setFitWidth(main.getLargeur_photo()); //set the width of the pictures
				imageView.setFitHeight(main.getLargeur_photo()); //set the height of the pictures
				imageView.setPreserveRatio(true);
				imageView.setOnMouseClicked(this);
				imageView.setCursor(Cursor.HAND); //change the cursor appearance
				photoGridPane.add(imageView, j, i); //add the imageView to the GUI
			}
		}
		int last_ligne = selectedPhotograph.getPhotoList().size()%main.getNb_photo();
		if(nb_ligne ==0){
			for(int i=0;i<selectedPhotograph.getPhotoList().size();i++){
				MyImage image = new MyImage("file:\\"+selectedPhotograph.getPhotoList().get(i).getPath().getValue());
				ImageView imageView = new ImageView(image);
				imageView.setFitWidth(main.getLargeur_photo()); //set the width of the pictures
				imageView.setFitHeight(main.getLargeur_photo()); //set the height of the pictures
				imageView.setPreserveRatio(true);
				imageView.setOnMouseClicked(this);
				imageView.setCursor(Cursor.HAND); //change the cursor appearance
				photoGridPane.add(imageView, i, 0); //add the imageView to the GUI
			}
		} else {
			for(int i=0;i<last_ligne;i++){
				MyImage image = new MyImage("file:\\"+selectedPhotograph.getPhotoList().get(i+nb_ligne*main.getNb_photo()).getPath().getValue());
				ImageView imageView = new ImageView(image);
				imageView.setFitWidth(main.getLargeur_photo()); //set the width of the pictures
				imageView.setFitHeight(main.getLargeur_photo()); //set the height of the pictures
				imageView.setPreserveRatio(true);
				imageView.setOnMouseClicked(this);
				imageView.setCursor(Cursor.HAND); //change the cursor appearance
				photoGridPane.add(imageView, i, nb_ligne); //add the imageView to the GUI
			}
		}
	}

	@Override
	public void handle(MouseEvent arg0) {
		int indice = 0;
		ImageView toDisplay = (ImageView) arg0.getSource();
		MyImage imgToDiplay = (MyImage) toDisplay.getImage();
		System.out.println(imgToDiplay.getURL());
		for(int i=0;i<selectedPhotograph.getPhotoList().size();i++){
			System.out.println("file:\\"+selectedPhotograph.getPhotoList().get(i).getPath().getValue());
			if(imgToDiplay.getURL().equals("file:\\"+selectedPhotograph.getPhotoList().get(i).getPath().getValue())){
				indice = i;
				break;
			}
		}
		main.getImageInterfaceController().setImageToDisplay(selectedPhotograph, indice);
		main.getImageInterfaceController().update();
		main.loadInterface(main.getLoaderImage(), main.getImageInterfaceController(), main.getSceneImage());
	}
	
	

}
