/**
 * 
 */
package application.model;

/**
 * A class that represent the photos in the data model
 * @author Martin
 *
 */
public class Photo {
	
	private String path;
	private int photographe;
	
	public Photo(String path, int photographe){
		this.path = path;
		this.photographe = photographe;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public int getPhotograhe() {
		return photographe;
	}

	public void setPhotograhe(int photograhe) {
		this.photographe = photograhe;
	}

	
}
