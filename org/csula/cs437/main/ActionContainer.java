package org.csula.cs437.main;

import org.csula.cs437.gui.cwsGUI;
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

	public void perform(CShirt dc, cwsGUI gui) {
				if(action.equalsIgnoreCase("Add")){
					String imagePath = cwsGUI.Add();
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
					String imageName = gui.getName();
					double amount = cwsGUI.Enlarge();
					dc.enlarge(imageName, amount);
					System.out.println("Enlarge");
				}
				else if(action.equalsIgnoreCase("Move Up")){
					String imageName = gui.getName();
					int distance = cwsGUI.Move();
					dc.moveUp(imageName, distance);
					System.out.println("Move up");
				}
				else if(action.equalsIgnoreCase("Move Down")){
					String imageName = gui.getName();
					int distance = cwsGUI.Move();
					dc.moveDown(imageName, distance);
					System.out.println("Move down");
				}
				else if(action.equalsIgnoreCase("Move Left")){
					String imageName = gui.getName();
					int distance = cwsGUI.Move();
					dc.moveLeft(imageName, distance);
					System.out.println("Move left");
				}
				else if(action.equalsIgnoreCase("Move Right")){
					String imageName = gui.getName();
					int distance = cwsGUI.Move();
					dc.moveRight(imageName, distance);
					System.out.println("Move right");
				}
				else if(action.equalsIgnoreCase("Push Backward")){
					String imageName = gui.getName();
					dc.pushBackward(imageName);
					System.out.println("Push backward");
				}
				else if(action.equalsIgnoreCase("Push Foward")){
					String imageName = gui.getName();
					dc.pushForward(imageName);
					System.out.println("Push forward");
				}
				else if(action.equalsIgnoreCase("Redo")){
					dc.redo();
					System.out.println("Redo");
				}
				else if(action.equalsIgnoreCase("Remove")){
					String imageName = gui.getName();
					dc.remove(imageName);
					System.out.println("Remove");
				}
				else if(action.equalsIgnoreCase("Rotate Clockwise")){
					String imageName = gui.getName();
					double degrees = cwsGUI.Rotate();
					dc.rotateClockwise(imageName, degrees);
					System.out.println("Rotate Clockwise");
				}
				else if(action.equalsIgnoreCase("Rotate Counterclockwise")){
					String imageName = gui.getName();
					double degrees = cwsGUI.Rotate();
					dc.rotateCounterclockwise(imageName, degrees);
					System.out.println("Rotate Counterclockwise");
				}
				else if(action.equalsIgnoreCase("Rotate Toward")){
					String imageName = gui.getName();
					dc.rotateToward(imageName);
					System.out.println("Rotate toward");
				}
				/*
				else if(action.equalsIgnoreCase("Select")){
					String imageName = gui.getName();
					dc.select(imageName);
					System.out.println("Select");
				} */
				else if(action.equalsIgnoreCase("Send to Back")){
					String imageName = gui.getName();
					dc.sendBack(imageName);
					System.out.println("Send to back");
				}
				else if(action.equalsIgnoreCase("Send to Front")){
					String imageName = gui.getName();
					dc.sendFront(imageName);
					System.out.println("Send to front");
				}
				else if(action.equalsIgnoreCase("Shrink")){
					String imageName = gui.getName();
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

				else if(action.equalsIgnoreCase("Save as")){
					String cShirt = "";
					dc.saveAs(cShirt);
					System.out.println("Save as");
				}
				else if(action.equalsIgnoreCase("Save cShirt")){
					String cShirt = "";
					dc.saveCShirt(cShirt);
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