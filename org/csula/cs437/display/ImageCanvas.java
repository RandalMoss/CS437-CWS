package org.csula.cs437.display;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.csula.cs437.main.Image;

public class ImageCanvas {
	private BufferedImage bi = null;
	private Graphics g = null;
	
	
	public ImageCanvas(int imageWidth, int imageHeight){
		bi = new BufferedImage(imageWidth, imageHeight, 1);
		g = bi.getGraphics();
	}
	
	public void addImage(Image image){
		try {
			BufferedImage bi = ImageIO.read(new File(image.getPath()));
			g.drawImage(bi, image.getxCoord(), image.getyCoord(), null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
