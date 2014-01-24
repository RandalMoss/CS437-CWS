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
  private static BufferedImage image = null;
  
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
         setSize(300, 300);
         try {
			image = ImageIO.read(new FileInputStream("picture.jpg"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      }

      public void paint (Graphics g) {
         Graphics2D g2;
         g2 = (Graphics2D) g;
         g.drawImage(image, 30, 30, this);
         //g2.drawString ("custom canvas area 1", 70, 70);
      }
   }
   
   static class MyCanvas2 extends Canvas {

       public MyCanvas2 () {
          setBackground (Color.GRAY);
          setSize(300, 300);
       }

       public void paint (Graphics g) {
          Graphics2D g2;
          g2 = (Graphics2D) g;
          g2.drawString ("custom canvas area 2", 70, 70);
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
     
    /*JLabel label = new JLabel("Canvas", JLabel.CENTER);
    Dimension labelSize = new Dimension(300, 300);
    label.setPreferredSize(labelSize );
    label.setBorder(BorderFactory.createLineBorder(Color.black));
     */
    JPanel panel = new JPanel(new BorderLayout(5, 5));
    int eb = 10;
    panel.setBorder(BorderFactory.createEmptyBorder(eb , eb, eb, eb));
   // panel.add(label, BorderLayout.CENTER);
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
    //frame.setSize(1000, 500);
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
        //
      
    });
  }
}