package org.csula.cs437.main;


import org.csula.cs437.gui.cwsGUI;

import java.io.IOException;

import org.csula.cs437.main.DataContainer;
import org.csula.cs437.util.StringHandler;

import com.google.gson.JsonSyntaxException;

public class ActionContainer {
String action = "";
String imageName = "";
	
	public ActionContainer() {

	}

	public String getActions() {
		return action;
	}
	
	public void setActions(String action){
		this.action = action;
	}

	public void perform(DataContainer dc, cwsGUI gui) {
			if(action.equalsIgnoreCase("add")){
				imageName = gui.getImageName();
				dc.add(imageName);
				System.out.println("Add: " + imageName);
			}
			else if(action.equalsIgnoreCase("Brighten")){
				dc.brighten();
				System.out.println("Brighten");
			}
			else if(action.equalsIgnoreCase("Change Background")){
				String newColor = "";
				newColor = gui.getColor();
				dc.backgroundColor(newColor);
				System.out.println("Change background" );
			}
			else if(action.equalsIgnoreCase("Darken")){
				dc.darken();
				System.out.println("Darken");
			}
			else if(action.equalsIgnoreCase("Enlarge")){
				String imagePath = gui.getPath();
				double amount = cwsGUI.Enlarge();
				dc.enlarge(imageName, amount);
				System.out.println("Enlarge");
			}
			else if(action.equalsIgnoreCase("Move Up")){
				String imagePath = gui.getPath();
				int distance = cwsGUI.Move();
				dc.moveUp(imageName, distance);
				System.out.println("Move up");
			}
			else if(action.equalsIgnoreCase("Move Down")){
				String imagePath = gui.getPath();
				int distance = cwsGUI.Move();
				dc.moveDown(imageName, distance);
				System.out.println("Move down");
			}
			else if(action.equalsIgnoreCase("Move Left")){
				String imagePath = gui.getPath();
				int distance = cwsGUI.Move();
				dc.moveLeft(imageName, distance);
				System.out.println("Move left");
			}
			else if(action.equalsIgnoreCase("Move Right")){
				String imagePath = gui.getPath();
				int distance = cwsGUI.Move();
				dc.moveRight(imageName, distance);
				System.out.println("Move right");
			}
			else if(action.equalsIgnoreCase("Push Backward")){
				String imagePath = gui.getPath();
				dc.pushBackward(imageName);
				System.out.println("Push backward");
			}
			else if(action.equalsIgnoreCase("Push Foward")){
				String imagePath = gui.getPath();
				dc.pushForward(imageName);
				System.out.println("Push forward");
			}
			else if(action.equalsIgnoreCase("Redo")){
				dc.redo();
				System.out.println("Redo");
			}
			else if(action.equalsIgnoreCase("Remove")){
				String imagePath = gui.getPath();
				dc.remove(imageName);
				System.out.println("Remove");
			}
			else if(action.equalsIgnoreCase("Rotate Clockwise")){
				String imagePath = gui.getPath();
				double degrees = cwsGUI.Rotate();
				dc.rotateClockwise(imageName, degrees);
				System.out.println("Rotate Clockwise");
			}
			else if(action.equalsIgnoreCase("Rotate Counterclockwise")){
				String imagePath = gui.getPath();
				double degrees = cwsGUI.Rotate();
				dc.rotateCounterclockwise(imageName, degrees);
				System.out.println("Rotate Counterclockwise");
			}
			else if(action.equalsIgnoreCase("Rotate Toward")){
				double degrees = cwsGUI.Rotate();
				String imagePath = gui.getPath();
				dc.rotateToward(imageName, degrees);
				System.out.println("Rotate toward");
			}
			else if(action.equalsIgnoreCase("Send to Back")){
				String imagePath = gui.getPath();
				dc.sendBack(imageName);
				System.out.println("Send to back");
			}
			else if(action.equalsIgnoreCase("Send to Front")){
				String imagePath = gui.getPath();
				dc.sendFront(imageName);
				System.out.println("Send to front");
			}
			else if(action.equalsIgnoreCase("Shrink")){
				String imagePath = gui.getPath();
				double amount = cwsGUI.Shrink();
				dc.shrink(imageName, amount);
				System.out.println("Shrink");
			}
			else if(action.equalsIgnoreCase("Stop")){
				dc.stop();
				System.out.println("Stop");
			}
			else if(action.equalsIgnoreCase("Undo")){
				dc.undo();
				System.out.println("Undo");
			}
			else if(action.equalsIgnoreCase("View Back")){
				dc.viewBack();
				System.out.println("View Back");
			}
			else if(action.equalsIgnoreCase("View Front")){
				dc.viewFront();
				System.out.println("View Front");
			}
			else if(action.equalsIgnoreCase("Select")){
				imageName = gui.Select();
			}
			//change
			else if(action.equalsIgnoreCase("Change Next")){
				try {
					dc.changeNext();
				} catch (JsonSyntaxException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Change next");
			}
			else if(action.equalsIgnoreCase("Change Previous")){
				try {
					dc.changePrev();
				} catch (JsonSyntaxException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Change previous");
			}
			else if(action.equalsIgnoreCase("Change to")){
				String cShirt = gui.ChangeTo();
				try {
					dc.changeTo(cShirt);
				} catch (JsonSyntaxException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Change to");
			}
			else if(action.equalsIgnoreCase("Clear")){
				try {
					dc.clear();
				} catch (JsonSyntaxException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Clear");
			}
				
			//save
			else if(action.equalsIgnoreCase("Save as")){
				try {
					String cShirt = gui.Save();;
					dc.saveAs(cShirt);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Save as");
			}
			else if(action.equalsIgnoreCase("Save cShirt")){
				try {
					dc.saveCShirt();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Save cShirt");
			}
			else if(action.equalsIgnoreCase("Delete")){
				String cShirt = gui.Delete();
				try {
					dc.delete(cShirt);
				} catch (JsonSyntaxException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Delete");
			}
			else {
				System.out.println("Invalid save command");
			}
			gui.getImageCanvas().getMyCanvas().repaint();
		}
	}