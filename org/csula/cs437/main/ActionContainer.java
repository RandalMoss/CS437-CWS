package org.csula.cs437.main;

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

	public void perform(DataContainer dc) {
			//Edit 10 20 10
			String imageName = StringHandler.getCol(action, 1);
			int amount = 10;
			int degrees = 20;
			int distance = 30;
				if(action.equalsIgnoreCase("Add " + imageName)){
					dc.editAdd(imageName);
					System.out.println("Add: " + imageName);
				}
				else if(action.equalsIgnoreCase("Brighten")){
					dc.editBrighten();
					System.out.println("Brighten");
				}
				else if(action.startsWith("Change Background")){
					dc.editBackgroundColor();
					System.out.println("Change background: " );
				}
				else if(action.equalsIgnoreCase("Darken")){
					dc.editDarken();
					System.out.println("Darken");
				}
				else if(action.equalsIgnoreCase("Enlarge " + imageName)){
					dc.editEnlarge(imageName);
					System.out.println("Enlarge: " + imageName);
				}
				else if(action.equalsIgnoreCase("Enlarge " + imageName + " " + amount)){
					dc.editEnlargeAmount(imageName, amount);
					System.out.println("Enlarge: " + imageName + " by " + amount);
				}
				else if(action.equalsIgnoreCase("Move " + imageName + " Up")){
					dc.editMoveUp(imageName);
					System.out.println("Move: " + imageName + " up");
				}
				else if(action.equalsIgnoreCase("Move " + imageName + " Up " + distance)){
					dc.editMoveUpDistance(imageName, distance);
					System.out.println("Move: " + imageName + " up " + distance);
				}
				else if(action.equalsIgnoreCase("Move " + imageName + " Down")){
					dc.editMoveDown(imageName);
					System.out.println("Move: " + imageName + " down");
				}
				else if(action.equalsIgnoreCase("Move " + imageName + " Down " + distance)){
					dc.editMoveDownDistance(imageName, distance);
					System.out.println("Move: " + imageName + " down " + distance);
				}
				else if(action.equalsIgnoreCase("Move " + imageName + " Left")){
					dc.editMoveLeft(imageName);
					System.out.println("Move: " + imageName + " left");
				}
				else if(action.equalsIgnoreCase("Move " + imageName + " Left " + distance)){
					dc.editMoveLeftDistance(imageName, distance);
					System.out.println("Move: " + imageName + " left " + distance);
				}
				else if(action.equalsIgnoreCase("Move " + imageName + " Right")){
					dc.editMoveRight(imageName);
					System.out.println("Move: " + imageName + " right");
				}
				else if(action.equalsIgnoreCase("Move " + imageName + " Right " + distance)){
					dc.editMoveRightDistance(imageName, distance);
					System.out.println("Move: " + imageName + " right " + distance);
				}
				else if(action.equalsIgnoreCase("Push " + imageName + " Backward")){
					dc.editPushBackward(imageName);
					System.out.println("Push: " + imageName + " backward");
				}
				else if(action.equalsIgnoreCase("Push " + imageName + " Foward")){
					dc.editPushForward(imageName);
					System.out.println("Push: " + imageName + " fackward");
				}
				else if(action.equalsIgnoreCase("Redo")){
					dc.editRedo();
					System.out.println("Redo");
				}
				else if(action.equalsIgnoreCase("Remove " + imageName)){
					dc.editRemove(imageName);
					System.out.println("Remove: " + imageName);
				}
				else if(action.equalsIgnoreCase("Rotate " + imageName + " Clockwise")){
					dc.editRotateClockwise(imageName);
					System.out.println("Rotate: " + imageName + "Clockwise");
				}
				else if(action.equalsIgnoreCase("Rotate " + imageName + " Clockwise " + degrees)){
					dc.editRotateClockwiseDegrees(imageName, degrees);
					System.out.println("Rotate: " + imageName + "Clockwise " + degrees + "degrees");
				}
				else if(action.equalsIgnoreCase("Rotate " + imageName + " Counterclockwise")){
					dc.editRotateCounterclockwise(imageName);
					System.out.println("Rotate: " + imageName + "Counterclockwise");
				}
				else if(action.equalsIgnoreCase("Rotate " + imageName + " Counterclockwise " + degrees)){
					dc.editRotateCounterclockwiseDegrees(imageName, degrees);
					System.out.println("Rotate: " + imageName + "Counterclockwise " + degrees + "degrees");
				}
				else if(action.equalsIgnoreCase("Rotate Toward " + degrees)){
					dc.editRotateToward(degrees);
					System.out.println("Rotate toward " + degrees + " degrees");
				}
				else if(action.equalsIgnoreCase("Select " + imageName)){
					dc.editSelect(imageName);
					System.out.println("Select: " + imageName);
				}
				else if(action.equalsIgnoreCase("Send " + imageName + " to Back")){
					dc.editSendBack(imageName);
					System.out.println("Send: " + imageName + "to back");
				}
				else if(action.equalsIgnoreCase("Send " + imageName + " to Front")){
					dc.editSendFront(imageName);
					System.out.println("Send: " + imageName + "to front");
				}
				else if(action.equalsIgnoreCase("Shrink " + imageName)){
					dc.editShrink(imageName);
					System.out.println("Shrink: " + imageName);
				}
				else if(action.equalsIgnoreCase("Shrink " + imageName + " " + amount)){
					dc.editShrinkAmount(imageName, amount);
					System.out.println("Shrink: " + imageName + " by " + amount);
				}
				else if(action.equalsIgnoreCase("Stop")){
					dc.editStop();
					System.out.println("Stop");
				}
				else if(action.equalsIgnoreCase("Undo")){
					dc.editUndo();
					System.out.println("Undo");
				}
				else if(action.equalsIgnoreCase("View Back")){
					dc.editViewBack();
					System.out.println("View Back");
				}
				else if(action.equalsIgnoreCase("View Front")){
					dc.editViewFront();
					System.out.println("View Front");
				}
				else {
					System.out.println("Invalid edit command");
				}
				
				//change
				String cShirt = StringHandler.getCol(action, 1);
				if(action.equalsIgnoreCase("Change Next cShirt")){
					dc.changeNext();
					System.out.println("Change next cShirt");
				}
				else if(action.equalsIgnoreCase("Change Previous cShirt")){
					dc.changePrev();
					System.out.println("Change previous cShirt");
				}
				else if(action.equalsIgnoreCase("Change to " + cShirt)){
					dc.changeTo(cShirt);
					System.out.println("Change to " + cShirt);
				}
				else if(action.equalsIgnoreCase("Clear")){
					dc.clear();
					System.out.println("Clear");
				}
				else {
					System.out.println("Invalid change command");
				}
				
				//save

				if(action.equalsIgnoreCase("Save as " + cShirt)){
					dc.saveAs(cShirt);
					System.out.println("Save as");
				}
				else if(action.equalsIgnoreCase("Save cShirt")){
					dc.saveCShirt(cShirt);
					System.out.println("Save cShirt");
				}
				else if(action.equalsIgnoreCase("Delete " + cShirt)){
					dc.delete(cShirt);
					System.out.println("Delete: " + cShirt);
				}
				else {
					System.out.println("Invalid save command");
				}
		}
	}