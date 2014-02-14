package org.csula.cs437.display;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Path2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import org.csula.cs437.main.CShirt;
import org.csula.cs437.main.CShirtController;
import org.csula.cs437.main.Image;

public class ImageCanvas {
	private BufferedImage bi = null;
	private Graphics g = null;
	private MyCanvas c1 = new MyCanvas();
	private MyCanvas2 c2 = new MyCanvas2();
	static CShirtController shirt;
	
	
	public ImageCanvas(int width, int height, CShirtController shirt){
		bi = new BufferedImage(width, height, 1);
		g = bi.getGraphics();
		this.shirt = shirt;
	}
	
	public MyCanvas getMyCanvas(){
		return c1;
	}
	
	public MyCanvas2 getMyCanvas2(){
		return c2;
	}
	
	static class MyCanvas extends Canvas {

		public MyCanvas() {
			setBackground(Color.WHITE);
			setPreferredSize(new Dimension(500, 450));
		}

		public void paint(Graphics g) {
			Graphics2D g2;
			g2 = (Graphics2D) g;
			g2.drawString("custom canvas area 1", 70, 70);
			g2.drawLine(5, 50, 180, 5);
			g2.drawLine(5, 50, 30, 145);
			g2.drawLine(30, 145, 105, 147);
			g2.drawLine(105, 147, 105, 386);
			g2.drawLine(105, 386, 367, 386);
			g2.drawLine(367, 386, 367, 147);
			g2.drawLine(367, 147, 445, 145);
			g2.drawLine(445, 145, 470, 50);
			g2.drawLine(470, 50, 295, 5);
			g2.drawArc(180, -20, 115, 50, 180, 180);
			g2.drawArc(180, -44, 115, 100, 180, 180);
			
			
//			Ellipse2D ellipse = new Ellipse2D.Float();
//			Rectangle2D rect = new Rectangle2D.Float();
//			ellipse.setFrame(0, 0, 40, 50);
//			g2.setClip(ellipse);
//			rect.setRect(0+5, 0+5, 40-10, 50-10);
//			g2.clip(rect);
			
			ArrayList<Image> images = new ArrayList<Image>();
			images = shirt.getCurrentCShirt().getImages();
			for(Image image : images){
				BufferedImage bi;
				try {
					System.out.println("path to image " + image.getPath());
					bi = ImageIO.read(new File(image.getPath()));
					int newWidth = (int)(bi.getWidth() * image.getScale());
					int newHeight = (int)(bi.getHeight() * image.getScale());
					BufferedImage resized = new BufferedImage(newWidth,
							newHeight,
							bi.getType());
				    //g2 = resized.createGraphics();
				    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
				    g2.drawImage(bi, 0, 0, newWidth, newHeight, 0, 0, bi.getWidth(), bi.getHeight(), null);
				    g2.dispose();
					//g2.drawImage(bi, image.getxCoord(), image.getyCoord(), null);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			double width = 300;
			double height = 400;
			Path2D.Double path = new Path2D.Double();
			path.moveTo(5, 180);
			path.lineTo(50, 5);
			path.curveTo(width, 0.0, width, 8.0, width, 8.0);
			path.lineTo(width, height - 8.0);
			path.curveTo(width, height, width - 8.0, height, width - 8.0, height);
			path.lineTo(8.0, height);
			path.curveTo(0.0, height, 0.0, height - 8.0, 0, height - 8.0);
			path.closePath();
			g2.fill(path);
			
		}
	}
	
	static class MyCanvas2 extends Canvas {

		public MyCanvas2() {
			setBackground(Color.GRAY);
			setPreferredSize(new Dimension(500, 400));
		}

		public void paint(Graphics g) {
			Graphics2D g2;
			g2 = (Graphics2D) g;
			g2.drawString("custom canvas area 2", 70, 70);
			g2.drawLine(5, 50, 180, 5);
			g2.drawLine(5, 50, 30, 145);
			g2.drawLine(30, 145, 105, 147);
			g2.drawLine(105, 147, 105, 386);
			g2.drawLine(105, 386, 367, 386);
			g2.drawLine(367, 386, 367, 147);
			g2.drawLine(367, 147, 445, 145);
			g2.drawLine(445, 145, 470, 50);
			g2.drawLine(470, 50, 295, 5);
			g2.drawArc(180, -20, 115, 50, 180, 180);
			// g2.drawArc(180,-44, 115, 100, 180, 180);
			
			ArrayList<Image> images = new ArrayList<Image>();
			images = shirt.getCurrentCShirt().getImages();
			for(Image image : images){
				BufferedImage bi;
				try {
					bi = ImageIO.read(new File(image.getPath()));
					g.drawImage(bi, image.getxCoord(), image.getyCoord(), null);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
