package application;

import java.io.File;

import javax.imageio.ImageIO;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;

/*
 *
 * Part of the InfoGlue Content Management Platform (www.infoglue.org)
 *
 * 
 *
 *  Copyright (C)
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License version 2, as published by the
 * Free Software Foundation. See the file LICENSE.html for more information.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY, including the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, write to the Free Software Foundation, Inc. / 59 Temple
 * Place, Suite 330 / Boston, MA 02111-1307 / USA.
 *
 * 
 */


/**
 * Adaptation of the thumbnail generation class
 * @author Axel
 *
 */

public class ThumbnailGenerator {
	private int thumbWidth;

	public ThumbnailGenerator() {
	}
	
	public ThumbnailGenerator(int thumbWidth) {
		this.thumbWidth = thumbWidth;
	}
	
	public StringProperty transform(String originalFile, String thumbnailFile) throws Exception {
		return this.transform(originalFile, thumbnailFile, thumbWidth);
	}

	public StringProperty transform(String originalFile, String thumbnailFile, int thumbWidth) throws Exception {
		//Path of the thumb
		StringProperty path = new SimpleStringProperty(thumbnailFile+".png");

		//Create the output file
		File outFileImage = new File(path.getValue());
		outFileImage.getParentFile().mkdirs();

		//If thumb exist return path
		if(outFileImage.exists()) {
			return path;
		}

		//Load the image in required dimensions
		Image image = new Image("file:\\"+originalFile, thumbWidth, thumbWidth, true, true, false);

		//Write the thumb down
		try {
			ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", outFileImage);

			//If success return the thumbnail path
			return path;
		} catch (Exception e) {
			System.err.println("Thumb generation error for "+originalFile);
			e.printStackTrace();
		}
		return null;
	}
}