package org.csula.cs437.gui;


import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.*;

import org.csula.cs437.display.ImageCanvas;
import org.csula.cs437.main.CShirt;
import org.csula.cs437.main.CShirtController;
import org.csula.cs437.main.Image;

//options panel: add, enlarge, move, push, remove, rotate, select, send, shrink
//add = file opener
//enlarge = amount
//move distance
//rotate degree
// shrink amount

public class cwsGUI {
	
	private String path;

	public String getPath(){
		return path;
	}

	public void setPath(String path){
		path = this.path;
	}


	private static CShirtController shirt;


	public String getName(){
		return filename;
	}

	// static JMenuItem open = new JMenuItem("Open");
	// static JMenuItem save = new JMenuItem("Save");

	static JFileChooser FileChooser = new JFileChooser(new File("."));
	static String filename = new String();
	static Panel panel;
	static JFrame frame = new JFrame("Chameleon Wear Shirt");
	public static int mouseX;
	public static int mouseY;
	public static ImageCanvas ic;
	
	//Buttons
	/*
	static JLabel option = new JLabel("Options Menu");
	static JButton Add = new JButton("Add");
	static JButton Enlarge = new JButton("Enlarge");
	static JButton Move = new JButton("Move");
	static JButton Push = new JButton("Push");
	static JButton Remove = new JButton("Remove");
	static JButton Rotate = new JButton("Rotate");
	static JButton Select = new JButton("Select");
	static JButton Send = new JButton("Send");
	static JButton Shrink = new JButton("Shrink");
	 */
	
	public ImageCanvas getImageCanvas(){
		return ic;
	}
	
	public cwsGUI (CShirtController shirt){
		this.shirt = shirt;
	}

	public CShirtController getShirt(){
		return shirt;
	}

	//MenuBar not using
	/*
	 * public static JMenuBar createMenuBar() { JMenuBar menuBar;
	 * 
	 * // Create the menu bar. menuBar = new JMenuBar();
	 * 
	 * // Build the first menu. JMenu jMenu1 = new JMenu("File");
	 * 
	 * jMenu1.add(open); jMenu1.add(save);
	 * 
	 * JMenu jMenu2 = new JMenu("Edit");
	 * 
	 * JMenuBar jMenuBar1 = new JMenuBar(); jMenuBar1.add(jMenu1);
	 * jMenuBar1.add(jMenu2);
	 * 
	 * menuBar.add(jMenu1); menuBar.add(jMenu2);
	 * 
	 * return menuBar;
	 * 
	 * }
	 */
	
	public static String Select(){
		JComboBox<String> jcb = new JComboBox<String>(shirt.getCurrentCShirt().imagesArray());
		jcb.setEditable(true);
		JOptionPane.showMessageDialog( null, jcb, "Select a image to modify", JOptionPane.QUESTION_MESSAGE);
		System.out.println(jcb.getSelectedItem()+ " is selected");
		shirt.currentImage = (String) jcb.getSelectedItem();
		System.out.println(shirt.currentImage + " is saved as current image");
		return jcb.getSelectedItem().toString();
	}
	
	public static String SelectCShirt(){
		JComboBox<String> jcb = new JComboBox<String>(shirt.getCurrentCShirt().imagesArray());
		jcb.setEditable(true);
		JOptionPane.showMessageDialog( null, jcb, "Select a image to modify", JOptionPane.QUESTION_MESSAGE);
		System.out.println(jcb.getSelectedItem()+ " is selected");
		shirt.currentImage = (String) jcb.getSelectedItem();
		System.out.println(shirt.currentImage + " is saved as current image");
		return jcb.getSelectedItem().toString();
	}
	
	public static double Enlarge(){
		
		String enlarge = JOptionPane
				.showInputDialog("Enter the amount to enlarge");
		if(enlarge == ""){
			double enlargeAmt = 1.0;
			return enlargeAmt;
		} else {
			double enlargeAmt = Double.parseDouble( enlarge );
			return enlargeAmt;
		}
	}
	
	public static String getImageName(){
		
		String enlarge = JOptionPane
				.showInputDialog("Enter the image name to add");
		return enlarge;
	}

	public static int Move(){
		String move = JOptionPane
				.showInputDialog("Enter the amount to move");
		if(move == ""){
			int moveAmt = 5;
			return moveAmt;
		} else {
			int moveAmt = Integer.parseInt( move );
			return moveAmt;
		}
	}

	public static double Rotate(){
		String rotate = JOptionPane
				.showInputDialog("Enter the amount to rotate");
		if(rotate == ""){
			double rotateAmt = 5.0;
			return rotateAmt;
		} else {
			double rotateAmt = Double.parseDouble( rotate );
			return rotateAmt;
		}
	}

	public static double Shrink(){
		String shrink = JOptionPane
				.showInputDialog("Enter the amount to shrink");
		if(shrink == ""){
			double shrinkAmt = 0.5;
			return shrinkAmt;
		} else {
			double shrinkAmt = Double.parseDouble( shrink );
			return shrinkAmt;
		}
	}

	//Button panel, for testing

	/*public static Panel optionButton() {
		Panel optionButton;

		optionButton = new Panel(new GridLayout(6, 1));

		optionButton.add(option);
		optionButton.add(Add);
		optionButton.add(Enlarge);
		optionButton.add(Move);
		//optionButton.add(Push);
		//optionButton.add(Remove);
		optionButton.add(Rotate);
		//optionButton.add(Select);
		//optionButton.add(Send);
		optionButton.add(Shrink);
		return optionButton;

	}
	 */
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

	public static void createAndShowUI() {
		JFrame frame = new JFrame("Chameleon Wear Shirt");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);

		ic = new ImageCanvas(1100, 500, shirt);
		JPanel panel = new JPanel(new BorderLayout(5, 5));
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		panel.add(ic.getMyCanvas(), BorderLayout.CENTER);
		//panel.add(optionButton(), BorderLayout.EAST);
		//panel.add(optionPanel(), BorderLayout.SOUTH);

		// panel = new Panel();
		frame.add(panel);
		frame.setSize(1050, 550);

		/**
		 * If mouselistener is used imagecanvas needs  
		 * to extend panel instead of canvas
		 */
//		panel.addMouseListener(new MouseAdapter() {
//		
//			public void mouseClicked(MouseEvent e) {
//				boolean isSelected;
//				Point clicked = e.getPoint();
//				Rectangle bounds = new Rectangle(0,0, 
//						ImageCanvas.newWidth, ImageCanvas.newHeight);
//				if (bounds.contains(clicked)) {
//					isSelected = true;
//					System.out.print("Image is selected");
//					// target image was clicked
//				}else{
//					isSelected = false;
//				}
//					
//			}
//			
//		});
		
	}

			public static void main(String[] args) {
				java.awt.EventQueue.invokeLater(new Runnable() {
					public void run() {
						createAndShowUI();

					}
				});
			}

			public String getColor() {
					
				String color = JOptionPane
							.showInputDialog("Enter color in format \"rrr.ggg.bbb\"");
				return color;
			}
		}
