package org.csula.cs437.display;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import org.csula.cs437.main.CShirt;
import org.csula.cs437.main.Image;

public class ImageCanvas {
	private BufferedImage bi = null;
	private Graphics g = null;
	private MyCanvas c1 = new MyCanvas();
	private MyCanvas2 c2 = new MyCanvas2();
	static CShirt shirt;
	
	
	public ImageCanvas(int width, int height, CShirt shirt){
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
	
	public void addImage(Image image){
		try {
			BufferedImage bi = ImageIO.read(new File(image.getPath()));
			g.drawImage(bi, image.getxCoord(), image.getyCoord(), null);
			c1.repaint();
			c2.repaint();
		} catch (IOException e) {
			e.printStackTrace();
		}
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
			
			ArrayList<Image> images = new ArrayList<Image>();
			images = shirt.getImages();
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
		}
	}
}
