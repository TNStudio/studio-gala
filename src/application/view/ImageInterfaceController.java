package application.view;

import application.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ImageInterfaceController {
	
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
		
		imageView.setImage(imageToDisplay);
		
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
	
	
	
}
