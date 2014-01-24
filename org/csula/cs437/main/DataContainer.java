package org.csula.cs437.main;

public abstract class DataContainer {
	int id;
	protected DataContainer() {
		this(-1); // default id is -1
	}
	
	DataContainer(int id) {
		this.id = id;
	}
	
	//Edit commands
	public abstract void editAdd(String imageName);
	public abstract void editBrighten();
	public abstract void editBackgroundColor();
	public abstract void editDarken();
	public abstract void editEnlarge(String imageName);
	public abstract void editEnlargeAmount(String imageName, int amount);
	public abstract void editMoveUp(String imageName);
	public abstract void editMoveUpDistance(String imageName, int distance);
	public abstract void editMoveDown(String imageName);
	public abstract void editMoveDownDistance(String imageName, int distance);
	public abstract void editMoveLeft(String imageName);
	public abstract void editMoveLeftDistance(String imageName, int distance);
	public abstract void editMoveRight(String imageName);
	public abstract void editMoveRightDistance(String imageName, int distance);
	public abstract void editPushBackward(String imageName);
	public abstract void editPushForward(String imageName);
	public abstract void editRedo();
	public abstract void editRemove(String imageName);
	public abstract void editRotateClockwise(String imageName);
	public abstract void editRotateClockwiseDegrees(String imageName, int degrees);
	public abstract void editRotateCounterclockwise(String imageName);
	public abstract void editRotateCounterclockwiseDegrees(String imageName, int degrees);
	public abstract void editRotateToward(int degrees);
	public abstract void editSelect(String imageName);
	public abstract void editSendBack(String imageName);
	public abstract void editSendFront(String imageName);
	public abstract void editShrink(String imageName);
	public abstract void editShrinkAmount(String imageName, int amount);
	public abstract void editStop();
	public abstract void editUndo();
	public abstract void editViewBack();
	public abstract void editViewFront();
	
	//Change Commands
	public abstract void changeNext();
	public abstract void changePrev();
	public abstract void changeTo(String cShirt);
	public abstract void clear();
	
	//Save Commands
	public abstract void delete(String cShirt);
	public abstract void saveAs(String cShirt);
	public abstract void saveCShirt(String cShirt);
	
}
