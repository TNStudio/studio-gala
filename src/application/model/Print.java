package application.model;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Print {

	private ObservableList<Photo> photoList;

	public Print() {
		photoList = FXCollections.observableArrayList();
	}

	public ObservableList<Photo> getPhotoList() {
		return photoList;
	}

	public void setPhotoList(ArrayList<Photo> photoList) {
		this.photoList = (ObservableList<Photo>) photoList;
	}
	
	public void addPhoto(Photo photo) {
		this.photoList.add(photo);
	}
}
