package application;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import application.model.Photo;
import application.model.Photographe;

public class LoadingRoutines {

	private ObservableList<Photo> photoList;
	private ObservableList<Photographe> photographeList;
	private WatchDir watchDir;
	private Task<Void> backgroundFolderScan;
	private ThumbnailGenerator thumbGen;
	private BackgroundThread bgThread;
	
	
	public LoadingRoutines() {
		thumbGen = new ThumbnailGenerator();
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
//						thumbGen.transform(f.getAbsolutePath(), , thumbWidth, thumbHeight, quality);
						photoList.add(new Photo(photo));
						System.out.println(photoList.get(photoList.size()-1));
					}
				}
				photographeList.get(photographeList.size()-1).setPhotoList(photoList);
			}
		}
		startWatchDir(directory);
		return photographeList;   
	}
	
	public void startWatchDir(String dir) {
		try {
			watchDir = new WatchDir(Paths.get(dir), true);
		} catch (IOException e) {
			System.err.println("Dossier Introuvable !\n" + dir);
			e.printStackTrace();
		}
		backgroundFolderScan = new Task<Void>() {

			@Override
			protected Void call() throws Exception {
				watchDir.processEvents();
				return null;
			}
		};
		bgThread = new BackgroundThread(backgroundFolderScan);
		bgThread.run();		
	}
}
