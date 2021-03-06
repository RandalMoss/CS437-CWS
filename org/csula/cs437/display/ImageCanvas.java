package org.csula.cs437.display;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Path2D;
import java.awt.geom.Rectangle2D;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import org.csula.cs437.main.CShirt;
import org.csula.cs437.main.CShirtController;
import org.csula.cs437.main.Image;

public class ImageCanvas
{
	private BufferedImage bi = null;
	private Graphics g = null;
	private MyCanvas c1 = new MyCanvas();
	static CShirtController shirt;
	public ImageCanvas(int width, int height, CShirtController shirt)
	{
		bi = new BufferedImage(width, height, 1);
		g = bi.getGraphics();
		this.shirt = shirt;
	}

	public MyCanvas getMyCanvas()
	{
		return c1;
	}

	public static class MyCanvas extends Canvas
	{

		public MyCanvas()
		{
			setBackground(Color.WHITE);
			setPreferredSize(new Dimension(500, 450));
		}

		public void paint(Graphics g)
		{
			Graphics2D g2;
			g2 = (Graphics2D) g;
			String[] colorString = shirt.getCurrentCShirt().getColor().split("\\.");
			int r = Integer.parseInt(colorString[0]);
			int gg = Integer.parseInt(colorString[1]);
			int b = Integer.parseInt(colorString[2]);
			Color color = new Color(r, gg, b);
			g2.setColor(color);
			g2.fillRect(0, 0, 1050, 500);
//			g2.drawString("custom canvas area 1", 70, 70);
//			g2.drawLine(5, 50, 180, 5);
//			g2.drawLine(5, 50, 30, 145);
//			g2.drawLine(30, 145, 105, 147);
//			g2.drawLine(105, 147, 105, 386);
//			g2.drawLine(105, 386, 367, 386);
//			g2.drawLine(367, 386, 367, 147);
//			g2.drawLine(367, 147, 445, 145);
//			g2.drawLine(445, 145, 470, 50);
//			g2.drawLine(470, 50, 295, 5);
//			g2.drawArc(180, -20, 115, 50, 180, 180);
//			g2.drawArc(180, -44, 115, 100, 180, 180);			
//			Ellipse2D ellipse = new Ellipse2D.Float();
//			Rectangle2D rect = new Rectangle2D.Float();
//			ellipse.setFrame(0, 0, 40, 50);
//			g2.setClip(ellipse);
//			rect.setRect(0+5, 0+5, 40-10, 50-10);
//			g2.clip(rect);
			int frameWidth = 1050;
			int frameHeight = 500;
			ArrayList<Image> images = new ArrayList<Image>();
			images = shirt.getCurrentCShirt().getImages();
			try {
				BufferedImage bi;
				for(Image image : images){
						String imagePath = shirt.getImagePath(image.getPath());
						System.out.println(imagePath);
						bi = ImageIO.read(new File(imagePath));
						
					if (image.getRotation() > 0) {
						System.out.println("Rotating");
						System.out.println("Rotating the original Image By: "+image.getRotation()+" degrees");
						BufferedImage processedImage=rotateMyImage(bi, image.getRotation());
						System.out.println("...Done\n");
						 
						//System.out.println("Writing the rotated image to: "+ "images/sample1.png");
						//writeImage(processedImage, "images/sample1.png", "png");
						bi = processedImage;
						//System.out.println("...Done");
					}
						int newWidth = (int)(bi.getWidth() * image.getScale());
						if(newWidth <= 0)
						{
							newWidth = 1;
						}
						int newHeight = (int)(bi.getHeight() * image.getScale());
						if(newHeight <= 0)
						{
							newHeight = 1;
						}
						BufferedImage resized = new BufferedImage(newWidth,
								newHeight,
								bi.getType());
					    //g2 = resized.createGraphics();
					    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
					    g2.drawImage(bi,
					    		frameWidth / 2 + image.getxCoord() - (newWidth / 2),
					    		frameHeight / 2 + image.getyCoord() - (newHeight / 2),
					    		frameWidth / 2 + newWidth + image.getxCoord() - (newWidth / 2),
					    		frameHeight / 2 + newHeight + image.getyCoord() - (newHeight / 2), 0, 0, bi.getWidth(), bi.getHeight(), null);
					    //g2.dispose();
						//g2.drawImage(bi, image.getxCoord(), image.getyCoord(), null);
				}
				bi = ImageIO.read(new File("images/tshirt.png"));
				g2.drawImage(bi, 0, 0, null);
			} catch (IOException e) {
				e.printStackTrace();
			}			
		}
	}
	
	public static BufferedImage rotateMyImage(BufferedImage img, double angle) {
		int w = img.getWidth();
		int h = img.getHeight();
		BufferedImage dimg =new BufferedImage(w, h, img.getType());
		Graphics2D g = dimg.createGraphics();
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, // Anti-alias!
		RenderingHints.VALUE_ANTIALIAS_ON);
		 
		g.rotate(Math.toRadians(angle), w/2, h/2);
		 
		g.drawImage(img, null, 0, 0);
		return dimg;
		}
	
}
