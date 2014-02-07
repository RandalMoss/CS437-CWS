package org.csula.cs437.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.*;

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
	
	public String getName(){
		return filename;
	}

	// static JMenuItem open = new JMenuItem("Open");
	// static JMenuItem save = new JMenuItem("Save");
	static JFileChooser FileChooser = new JFileChooser(new File("."));
	static String filename = new String();
	static Panel panel;
	static JFrame frame = new JFrame("Chameleon Wear Shirt");
	
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

	public static String Add(){
		String path = new String();
		
		if (FileChooser.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
			File fin = FileChooser.getSelectedFile();
			filename = fin.getName();
			path = fin.getAbsolutePath();
			System.out.println(path);
		}
		
		return path;
		
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
		// frame.setJMenuBar(createMenuBar());

		JPanel panel = new JPanel(new BorderLayout(5, 5));
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		panel.add(new MyCanvas(), BorderLayout.WEST);
		panel.add(new MyCanvas2(), BorderLayout.EAST);
		//panel.add(optionButton(), BorderLayout.CENTER);

		// panel = new Panel();
		frame.add(panel);
		frame.setSize(1050, 450);
	}

	public static void main(String[] args) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				createAndShowUI();

			}
		});
	}
}