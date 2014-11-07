/**
 * 
 */
package application.model;

import javafx.beans.property.StringProperty;

/**
 * A class that represent the photos in the data model
 * @author Martin
 *
 */
public class Photo {

	private StringProperty path;

	public Photo(StringProperty path){
		this.path = path;
	}

	public StringProperty getPath() {
		return path;
	}

	public void setPath(StringProperty path) {
		this.path = path;
	}
}
