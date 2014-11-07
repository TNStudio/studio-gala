/**
 * 
 */
package application.model;

import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableIntegerValue;

/**
 * A class that represent the photos in the data model
 * @author Martin
 *
 */
public class Photo {

	private StringProperty path;
	private ObservableIntegerValue photographe;

	public Photo(StringProperty path, ObservableIntegerValue photographe){
		this.path = path;
		this.photographe = photographe;
	}

	public StringProperty getPath() {
		return path;
	}

	public void setPath(StringProperty path) {
		this.path = path;
	}

	public ObservableIntegerValue getPhotograhe() {
		return photographe;
	}

	public void setPhotograhe(ObservableIntegerValue photographe) {
		this.photographe = photographe;
	}
}
