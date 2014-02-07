package org.csula.cs437.main;

import org.csula.cs437.gui.cwsGUI;
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

	public void perform(CShirt dc) {
		cwsGUI gui = new cwsGUI();
		
				if(action.equalsIgnoreCase("Add")){
					String imagePath =
					dc.add(imagePath);
					System.out.println("Add");
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
					dc.enlarge(imagePath);
					System.out.println("Enlarge");
				}
				else if(action.equalsIgnoreCase("Move Up")){
					dc.moveUp(imagePath, distance);
					System.out.println("Move up");
				}
				else if(action.equalsIgnoreCase("Move Down")){
					dc.moveDown(imagePath, distance);
					System.out.println("Move down");
				}
				else if(action.equalsIgnoreCase("Move Left")){
					dc.moveLeft(imagePath, distance);
					System.out.println("Move left");
				}
				else if(action.equalsIgnoreCase("Move Right")){
					dc.moveRight(imagePath, distance);
					System.out.println("Move right");
				}
				else if(action.equalsIgnoreCase("Push Backward")){
					dc.pushBackward(imagePath);
					System.out.println("Push backward");
				}
				else if(action.equalsIgnoreCase("Push Foward")){
					dc.pushForward(imagePath);
					System.out.println("Push forward");
				}
				else if(action.equalsIgnoreCase("Redo")){
					dc.redo();
					System.out.println("Redo");
				}
				else if(action.equalsIgnoreCase("Remove")){
					dc.remove(imagePath);
					System.out.println("Remove");
				}
				else if(action.equalsIgnoreCase("Rotate Clockwise")){
					dc.rotateClockwise(imagePath, degrees);
					System.out.println("Rotate Clockwise");
				}
				else if(action.equalsIgnoreCase("Rotate Counterclockwise")){
					dc.rotateCounterclockwise(imagePath, degrees);
					System.out.println("Rotate Counterclockwise");
				}
				else if(action.equalsIgnoreCase("Rotate Toward")){
					dc.rotateToward(imagePath);
					System.out.println("Rotate toward");
				}
				else if(action.equalsIgnoreCase("Select")){
					dc.select();
					System.out.println("Select");
				}
				else if(action.equalsIgnoreCase("Send to Back")){
					dc.sendBack(imagePath);
					System.out.println("Send to back");
				}
				else if(action.equalsIgnoreCase("Send to Front")){
					dc.sendFront(imagePath);
					System.out.println("Send to front");
				}
				else if(action.equalsIgnoreCase("Shrink")){
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
					dc.changeTo();
					System.out.println("Change to");
				}
				else if(action.equalsIgnoreCase("Clear")){
					dc.clear();
					System.out.println("Clear");
				}
				
				//save

				else if(action.equalsIgnoreCase("Save as")){
					dc.saveAs();
					System.out.println("Save as");
				}
				else if(action.equalsIgnoreCase("Save cShirt")){
					dc.saveCShirt();
					System.out.println("Save cShirt");
				}
				else if(action.equalsIgnoreCase("Delete")){
					dc.delete();
					System.out.println("Delete");
				}
				else {
					System.out.println("Invalid save command");
				}
		}
	}