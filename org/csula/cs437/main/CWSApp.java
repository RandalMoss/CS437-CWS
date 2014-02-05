package org.csula.cs437.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;

import org.csula.cs437.gui.cwsGUI;

public class CWSApp {
	static DataContainer csContainer;
	static ActionContainer ac;
	static cwsGUI gui;
	public static void main(String[] args){
		csContainer = new CShirt();
		ac = new ActionContainer();
		gui = new cwsGUI();
		java.awt.EventQueue.invokeLater(new Runnable() {
		      public void run() {
		        gui.createAndShowUI();
		        
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
