package application;

import java.io.File;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import application.model.Photo;
import application.model.Photographe;

public class LoadingRoutines {

	private ObservableList<Photo> photoList;
	private ObservableList<Photographe> photographeList;
	
	public LoadingRoutines() {
		
	}

	public ObservableList<Photographe> loadImagesRoutine(String directory) throws Exception {		
		File[] files;
		File dir = new File(directory);
		System.out.println(dir.isDirectory());
		File subdir;
		String[] photographes = dir.list();
		StringProperty photo = new SimpleStringProperty();
		IntegerProperty number = new SimpleIntegerProperty();
		photographeList = FXCollections.observableArrayList();

		for(String s : photographes) {
			System.out.println(s);
			if(!s.contains(".")) {
				number = new SimpleIntegerProperty();
				number.setValue(Integer.parseInt(s));
				photographeList.add(new Photographe(number));
				subdir = new File(directory + "\\" + s);
				files = subdir.listFiles();
				photoList = FXCollections.observableArrayList();
				for(File f : files) {
					if(f.getName().matches("^(.*?)")){
						photo = new SimpleStringProperty();
						photo.setValue(f.getAbsolutePath());
						photoList.add(new Photo(photo));
						System.out.println(photoList.get(photoList.size()-1));
					}
				}
				photographeList.get(photographeList.size()-1).setPhotoList(photoList);
			}
		}
		return photographeList;   
	}
}
