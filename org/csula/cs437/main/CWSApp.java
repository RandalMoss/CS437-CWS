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
		gui.createAndShowUI();
		
		//get the voice command action = voce.getvoicestuff()
		//ac.setActions(action);
		//ac.perform(csContainer);
		
	}
}
