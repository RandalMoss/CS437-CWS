package org.csula.cs437.main;


import org.csula.cs437.gui.cwsGUI;
import java.io.IOException;

import org.csula.cs437.main.DataContainer;
import org.csula.cs437.util.StringHandler;

public class ActionContainer {
String action = "";
	
	public ActionContainer() {

	}

	public String getActions() {
		return action;
	}
	
	public void setActions(String action){
		this.action = action;
	}
	public void perform(DataContainer dc, cwsGUI gui) {
			String imageName = "";
			if(action.equalsIgnoreCase("Add " + imageName)){
				dc.add(imageName);
				System.out.println("Add: " + imageName);
			}
			else if(action.equalsIgnoreCase("Brighten")){
				dc.brighten();
				System.out.println("Brighten");
			}
			else if(action.startsWith("Change Background")){
				String newColor = StringHandler.getCol(action, 2);
				dc.backgroundColor(newColor);
				System.out.println("Change background" );
			}
			else if(action.equalsIgnoreCase("Darken")){
				dc.darken();
				System.out.println("Darken");
			}
			else if(action.equalsIgnoreCase("Enlarge")){
				String imagePath = gui.getPath();
				int amount = cwsGUI.Enlarge();
				dc.enlarge(imagePath, amount);
				System.out.println("Enlarge");
			}
			else if(action.equalsIgnoreCase("Move Up")){
				String imagePath = gui.getPath();
				int distance = cwsGUI.Move();
				dc.moveUp(imagePath, distance);
				System.out.println("Move up");
			}
			else if(action.equalsIgnoreCase("Move Down")){
				String imagePath = gui.getPath();
				int distance = cwsGUI.Move();
				dc.moveDown(imagePath, distance);
				System.out.println("Move down");
			}
			else if(action.equalsIgnoreCase("Move Left")){
				String imagePath = gui.getPath();
				int distance = cwsGUI.Move();
				dc.moveLeft(imagePath, distance);
				System.out.println("Move left");
			}
			else if(action.equalsIgnoreCase("Move Right")){
				String imagePath = gui.getPath();
				int distance = cwsGUI.Move();
				dc.moveRight(imagePath, distance);
				System.out.println("Move right");
			}
			else if(action.equalsIgnoreCase("Push Backward")){
				String imagePath = gui.getPath();
				dc.pushBackward(imagePath);
				System.out.println("Push backward");
			}
			else if(action.equalsIgnoreCase("Push Foward")){
				String imagePath = gui.getPath();
				dc.pushForward(imagePath);
				System.out.println("Push forward");
			}
			else if(action.equalsIgnoreCase("Redo")){
				dc.redo();
				System.out.println("Redo");
			}
			else if(action.equalsIgnoreCase("Remove")){
				String imagePath = gui.getPath();
				dc.remove(imagePath);
				System.out.println("Remove");
			}
			else if(action.equalsIgnoreCase("Rotate Clockwise")){
				String imagePath = gui.getPath();
				int degrees = cwsGUI.Rotate();
				dc.rotateClockwise(imagePath, degrees);
				System.out.println("Rotate Clockwise");
			}
			else if(action.equalsIgnoreCase("Rotate Counterclockwise")){
				String imagePath = gui.getPath();
				int degrees = cwsGUI.Rotate();
				dc.rotateCounterclockwise(imagePath, degrees);
				System.out.println("Rotate Counterclockwise");
			}
			else if(action.equalsIgnoreCase("Rotate Toward")){
				double degrees = gui.Rotate();
				String imagePath = gui.getPath();
				dc.rotateToward(imagePath, degrees);
				System.out.println("Rotate toward");
			}
			else if(action.equalsIgnoreCase("Select")){
				String imagePath = gui.getPath();
				dc.select(imagePath);
				System.out.println("Select");
			}
			else if(action.equalsIgnoreCase("Send to Back")){
				String imagePath = gui.getPath();
				dc.sendBack(imagePath);
				System.out.println("Send to back");
			}
			else if(action.equalsIgnoreCase("Send to Front")){
				String imagePath = gui.getPath();
				dc.sendFront(imagePath);
				System.out.println("Send to front");
			}
			else if(action.equalsIgnoreCase("Shrink")){
				String imagePath = gui.getPath();
				int amount = cwsGUI.Shrink();
				dc.shrink(imagePath, amount);
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
			
			//change
			else if(action.equalsIgnoreCase("Change Next cShirt")){
				dc.changeNext();
				System.out.println("Change next cShirt");
			}
			else if(action.equalsIgnoreCase("Change Previous cShirt")){
				dc.changePrev();
				System.out.println("Change previous cShirt");
			}
			else if(action.equalsIgnoreCase("Change to")){
				String cShirt = "";
				dc.changeTo(cShirt);
				System.out.println("Change to");
			}
			else if(action.equalsIgnoreCase("Clear")){
				dc.clear();
				System.out.println("Clear");
			}
				
			//save
			else if(action.equalsIgnoreCase("Save as ")){
				try {
					String cShirt = "";
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
				String cShirt = "";
				dc.delete(cShirt);
				System.out.println("Delete");
			}
			else {
				System.out.println("Invalid save command");
			}
		}
	}