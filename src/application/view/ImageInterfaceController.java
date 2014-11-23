package application.view;

import observerPattern.MyObserver;
import application.Main;
import application.model.MyImage;
import application.model.Photographe;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Screen;

public class ImageInterfaceController implements MyObserver{
	
	@FXML
	private Button print;
	
	@FXML
	private Button quit;
	
	@FXML
	private ImageView imageView;
	
	private Main main;
	private Image imageToDisplay;
	private Photographe photographe;
	private int indice = 0;
	
	@FXML
	private void initialize(){
		//imageView.setImage(imageToDisplay);
		
		quit.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				main.loadInterface(main.getLoaderMain(), main.getMainInterfaceController(), main.getSceneMain());
				
			}
		});
		
	}
	
	public void setMain(Main main){
		this.main=main;
	}

	public Image getImageToDisplay() {
		return imageToDisplay;
	}

	public void setImageToDisplay(Photographe photographe, int indice) {
		this.photographe = photographe;
		this.indice = indice;
		imageToDisplay = new MyImage("file:\\"+photographe.getPhotoList().get(indice).getPath().getValue());
	}

	public Main getMain() {
		return main;
	}

	@Override
	public void update() {
		imageView.setImage(imageToDisplay);
		imageView.setFitHeight(Screen.getPrimary().getBounds().getHeight());
		
	}
	
	
	
}
