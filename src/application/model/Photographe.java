package application.model;

import java.util.ArrayList;

public class Photographe {
	
	private ArrayList<Photo> photoList;
	
	private int numero;
	
	private String name;
	
	public Photographe(int numero){
		this.numero=numero;
		name = "Photographe numéro "+numero;
		photoList = new ArrayList<Photo>();
	}

	public ArrayList<Photo> getPhotoList() {
		return photoList;
	}

	public void setPhotoList(ArrayList<Photo> photoList) {
		this.photoList = photoList;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	
}
