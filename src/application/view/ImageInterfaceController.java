package application.view;

import observerPattern.MyObserver;
import application.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Screen;

public class ImageInterfaceController implements MyObserver{
	
	@FXML
	private Button Print;
	
	@FXML
	private Button Quit;
	
	@FXML
	private ImageView imageView;
	
	private Main main;
	private Image imageToDisplay;
	
	@FXML
	private void initialize(){
		//imageView.setImage(imageToDisplay);
		
	}
	
	public void setMain(Main main){
		this.main=main;
	}

	public Image getImageToDisplay() {
		return imageToDisplay;
	}

	public void setImageToDisplay(Image imageToDisplay) {
		this.imageToDisplay = imageToDisplay;
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
