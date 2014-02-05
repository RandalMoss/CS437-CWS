package org.csula.cs437.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.*;

//options panel: add, enlarge, move, push, remove, rotate, select, send, shrink
public class cwsGUI {

	static JMenuItem open = new JMenuItem("Open");
	static JMenuItem save = new JMenuItem("Save");
	static JFileChooser FileChooser = new JFileChooser(new File("."));
	static String filename = new String();
	static Panel panel;
	static JFrame frame = new JFrame("Chameleon Wear Shirt");
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
	
	public static JMenuBar createMenuBar() {
		JMenuBar menuBar;

		// Create the menu bar.
		menuBar = new JMenuBar();

		// Build the first menu.
		JMenu jMenu1 = new JMenu("File");

		jMenu1.add(open);
		jMenu1.add(save);

		JMenu jMenu2 = new JMenu("Edit");

		JMenuBar jMenuBar1 = new JMenuBar();
		jMenuBar1.add(jMenu1);
		jMenuBar1.add(jMenu2);

		menuBar.add(jMenu1);
		menuBar.add(jMenu2);

		return menuBar;

	}

	public static Panel optionButton() {
		Panel optionButton;

		optionButton = new Panel(new GridLayout(10, 1));

		optionButton.add(option);
		optionButton.add(Add);
		optionButton.add(Enlarge);
		optionButton.add(Move);
		optionButton.add(Push);
		optionButton.add(Remove);
		optionButton.add(Rotate);
		optionButton.add(Select);
		optionButton.add(Send);
		optionButton.add(Shrink);
		return optionButton;

	}
	
	public static Panel optionPanel() {
		final Panel optionPanel;
		optionPanel = new Panel();
		final JTextField tf = null;
		
		
		return optionPanel;
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
		frame.setJMenuBar(createMenuBar());

		JPanel panel = new JPanel(new BorderLayout(5, 5));
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		panel.add(new MyCanvas(), BorderLayout.WEST);
		panel.add(new MyCanvas2(), BorderLayout.CENTER);
		panel.add(optionButton(), BorderLayout.EAST);
		//panel.add(optionPanel(), BorderLayout.SOUTH);
		
		// panel = new Panel();
		frame.add(panel);
		frame.setSize(1100, 500);
	}

	public static void main(String[] args) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				createAndShowUI();

				// File Chooser
				open.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent ae) {
						if (FileChooser.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
							File fin = FileChooser.getSelectedFile();
							String path = new String();
							filename = fin.getName();
							path = fin.getAbsolutePath();
							System.out.println(path);
							panel.repaint();
						}

					}
				});
			}
		});
	}
}