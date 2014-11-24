package application;

import java.io.File;

import javax.imageio.ImageIO;

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




public class ThumbnailGenerator 
{
 public ThumbnailGenerator()
 {
 }
 
 public void transform(String originalFile, String thumbnailFile, int thumbWidth, int thumbHeight) throws Exception {
	 System.out.println("Je génère fougère !\nfile:\\"+originalFile);
	 Image image = new Image("file:\\"+originalFile, thumbWidth, thumbHeight, true, true, false);
     System.out.println(image.getHeight()+"   "+image.getWidth());
     Image testi = new Image("file:\\D:\\Utilisateur\\Dropbox\\Gala2014\\1\\IMG_5523.jpg", 150, 150, true, true, false);
     
     File outFileImage = new File(thumbnailFile);
     File test = new File("D:\\Utilisateur\\Dropbox\\Gala2014\\1\\test.jpg");

     try {
    	 System.out.println("J'écris le fichier gros : "+outFileImage.getAbsolutePath());
         ImageIO.write(SwingFXUtils.fromFXImage(image, null), ".jpg", outFileImage);
         ImageIO.write(SwingFXUtils.fromFXImage(testi, null), ".jpg", test);
         System.out.println("OK");
     } catch (Exception e) {
         System.err.println("Erreur de génération de la miniature "+originalFile);
         e.printStackTrace();
     }
 }
}