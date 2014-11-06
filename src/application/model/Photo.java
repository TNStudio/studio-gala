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
	private int photograhe;
	
	public Photo(String path, int photographe){
		this.path = path;
		this.photograhe = photographe;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public int getPhotograhe() {
		return photograhe;
	}

	public void setPhotograhe(int photograhe) {
		this.photograhe = photograhe;
	}

	
}
