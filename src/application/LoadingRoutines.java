package application;

import java.io.File;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import application.model.Photo;
import application.model.Photographe;

public class LoadingRoutines {
	
	private ObservableList<Photo> photoList;
	private ObservableList<Photographe> photographeList;

	public LoadingRoutines() {
		// TODO Auto-generated constructor stub
	}

	public ObservableList<Photographe> loadImagesRoutine(String directory) throws Exception {		
		File[] files;
		File dir = new File(directory);
		File subdir;
		String[] photographes = dir.list();
		StringProperty photo = new SimpleStringProperty();
		IntegerProperty number = new SimpleIntegerProperty();
		
		for(String s : photographes) {
			number.setValue(Integer.parseInt(s));
			photographeList.add(new Photographe(number));
			subdir = new File(directory + "\\" + s);
			files = subdir.listFiles();
			for(File f : files) {
				if(f.getName().matches("^(.*?)")){
					photo.setValue(f.getAbsolutePath());
					photoList.add(new Photo(photo, number));
				}
			}
			photographeList.get(photographeList.size()-1).setPhotoList(photoList);
		}
		return photographeList;   
	}
}
