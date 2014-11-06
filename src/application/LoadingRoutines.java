package application;

import java.io.File;
import java.util.ArrayList;

import application.model.Photo;
import application.model.Photographe;

public class LoadingRoutines {
	
	private ArrayList<Photo> photoList;
	private ArrayList<Photographe> photographeList;

	public LoadingRoutines() {
		// TODO Auto-generated constructor stub
	}

	public ArrayList<Photographe> loadImagesRoutine(String directory){		
		File[] files;
		File dir = new File(directory);
		File subdir;
		String[] photographes = dir.list();
		
		for(String s : photographes) {
			photographeList.add(new Photographe(Integer.parseInt(s)));
			subdir = new File(directory + "\\" + s);
			files = subdir.listFiles();
			for(File f : files) {
				photoList.add(new Photo(f.getName(), Integer.parseInt(s)));
			}
			photographeList.get(photographeList.size()-1).setPhotoList(photoList);
		}
		return photographeList;   
	}
}
