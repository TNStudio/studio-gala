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
 
 public void transform(String originalFile, String thumbnailFile, int thumbWidth, int thumbHeight, int quality) throws Exception 
 {
   Image image = new Image(originalFile, thumbWidth, thumbHeight, true, true, true);
     
//     double thumbRatio = (double)thumbWidth / (double)thumbHeight;
//     int imageWidth    = (int) image.getWidth();
//     int imageHeight   = (int) image.getHeight();
//     double imageRatio = (double)imageWidth / (double)imageHeight;
//     if (thumbRatio < imageRatio) 
//     {
//       thumbHeight = (int)(thumbWidth / imageRatio);
//     } 
//     else 
//     {
//         thumbWidth = (int)(thumbHeight * imageRatio);
//     }
//     
//   if(imageWidth < thumbWidth && imageHeight < thumbHeight)
//   {
//     thumbWidth = imageWidth;
//     thumbHeight = imageHeight;
//   }
//   else if(imageWidth < thumbWidth)
//     thumbWidth = imageWidth;
//   else if(imageHeight < thumbHeight)
//     thumbHeight = imageHeight;

//     WritableImage thumbImage = new WritableImage(thumbWidth, thumbHeight);
//     GraphicsContext graphics2D = thumbImage.createGraphics();
//     graphics2D.setBackground(Color.WHITE);
//     graphics2D.setPaint(Color.WHITE); 
//     graphics2D.fillRect(0, 0, thumbWidth, thumbHeight);
//     graphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
//     graphics2D.drawImage(image, 0, 0, thumbWidth, thumbHeight, null);
     
     File outFileImage = new File(thumbnailFile);

     try {
         ImageIO.write(SwingFXUtils.fromFXImage(image, null), ".png", outFileImage);
     } catch (Exception e) {
         System.err.println("Erreur de génération de la miniature "+originalFile);
     }
 }
}