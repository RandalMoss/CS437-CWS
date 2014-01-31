package org.csula.cs437.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
 
public class cwsGUI {
  private JPanel mainPanel = new JPanel();
  static JMenuItem open = new JMenuItem("Open");
  static JMenuItem save = new JMenuItem("Save");
  static JFileChooser FileChooser = new JFileChooser(new File("."));
  static String filename = new String();
  static Panel panel;
  static JFrame frame = new JFrame("Chameleon Wear Shirt");
  
  public cwsGUI() {
    mainPanel.setLayout(new GridLayout(1, 0));
    mainPanel.add(createGridPanel(new String[] {"Button 1", "Button 2", "Button 3"}));
    //mainPanel.add(createGridPanel(new String[] {"Button 3"}));
  }
 
  public static JMenuBar createMenuBar() {
      JMenuBar menuBar;

      //Create the menu bar.
      menuBar = new JMenuBar();

      //Build the first menu.
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
  
  /*private static void showCanvasDemo(){
      panel.add(new MyCanvas());
      panel.add(new MyCanvas2());
   } 
*/
   static class MyCanvas extends Canvas {

      public MyCanvas () {
         setBackground (Color.WHITE);
         setPreferredSize(new Dimension(500,450));
      }

      public void paint (Graphics g) {
         Graphics2D g2;
         g2 = (Graphics2D) g;
         g2.drawString ("custom canvas area 1", 70, 70);
         g2.drawLine(5,50, 180,5);
         g2.drawLine(5,50, 30,145);
         g2.drawLine(30,145, 105,147);
         g2.drawLine(105,147, 105,386);
         g2.drawLine(105,386, 367,386);
         g2.drawLine(367,386, 367,147);
         g2.drawLine(367,147, 445,145);
         g2.drawLine(445,145, 470,50);
         g2.drawLine(470,50, 295,5);
         g2.drawArc(180,-20, 115, 50, 180, 180);
         g2.drawArc(180,-44, 115, 100, 180, 180);
      }
   }
   
   static class MyCanvas2 extends Canvas {

       public MyCanvas2 () {
          setBackground (Color.GRAY);
          setPreferredSize(new Dimension(500,400));
       }

       public void paint (Graphics g) {
          Graphics2D g2;
          g2 = (Graphics2D) g;
          g2.drawString ("custom canvas area 2", 70, 70);
          g2.drawLine(5,50, 180,5);
          g2.drawLine(5,50, 30,145);
          g2.drawLine(30,145, 105,147);
          g2.drawLine(105,147, 105,386);
          g2.drawLine(105,386, 367,386);
          g2.drawLine(367,386, 367,147);
          g2.drawLine(367,147, 445,145);
          g2.drawLine(445,145, 470,50);
          g2.drawLine(470,50, 295,5);
          g2.drawArc(180,-20, 115, 50, 180, 180);
          //g2.drawArc(180,-44, 115, 100, 180, 180);
       }
    }
   
  private JPanel createGridPanel(String[] buttonNames) {
    JPanel btnPanel = new JPanel(new GridLayout(1, 0));
    for (String btnName : buttonNames) {
      JButton btn = new JButton(btnName);
      JPanel tempPanel = new JPanel();
      tempPanel.add(btn);
      btnPanel.add(tempPanel);
    }
    
    JPanel panel = new JPanel(new BorderLayout(5,5));
    int eb = 10;
    panel.setBorder(BorderFactory.createEmptyBorder(eb , eb, eb, eb));
    panel.add(new MyCanvas(), BorderLayout.WEST);
    panel.add(new MyCanvas2(), BorderLayout.EAST);
    panel.add(btnPanel, BorderLayout.SOUTH);
    return panel;
  }
 
  public JPanel getMainPanel() {
    return mainPanel;
  }
 
  private static void createAndShowUI() {
    JFrame frame = new JFrame("Chameleon Wear Shirt");
    frame.getContentPane().add(new cwsGUI().getMainPanel());
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
    frame.setJMenuBar(createMenuBar());
    //panel = new Panel();
    //frame.add(panel);
    //frame.setSize(1000, 1000);
  }
 
  public static void main(String[] args) {
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        createAndShowUI();
        
        //File Chooser
        open.addActionListener( new ActionListener() {
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
		});}
    });
  }
}