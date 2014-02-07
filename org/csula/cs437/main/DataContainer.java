package org.csula.cs437.main;

import java.io.IOException;

public abstract class DataContainer {
	int id;
	protected DataContainer() {
		this(-1); // default id is -1
	}
	
	DataContainer(int id) {
		this.id = id;
	}
	
	// commands
	public abstract void add(String imageName);
	public abstract void brighten();
	public abstract void backgroundColor();
	public abstract void darken();
	public abstract void enlarge(String imageName);
	public abstract void enlargeAmount(String imageName, int amount);
	public abstract void moveUp(String imageName);
	public abstract void moveUpDistance(String imageName, int distance);
	public abstract void moveDown(String imageName);
	public abstract void moveDownDistance(String imageName, int distance);
	public abstract void moveLeft(String imageName);
	public abstract void moveLeftDistance(String imageName, int distance);
	public abstract void moveRight(String imageName);
	public abstract void moveRightDistance(String imageName, int distance);
	public abstract void pushBackward(String imageName);
	public abstract void pushForward(String imageName);
	public abstract void redo();
	public abstract void remove(String imageName);
	public abstract void rotateClockwise(String imageName);
	public abstract void rotateClockwiseDegrees(String imageName, int degrees);
	public abstract void rotateCounterclockwise(String imageName);
	public abstract void rotateCounterclockwiseDegrees(String imageName, int degrees);
	public abstract void rotateToward(int degrees);
	public abstract void select(String imageName);
	public abstract void sendBack(String imageName);
	public abstract void sendFront(String imageName);
	public abstract void shrink(String imageName);
	public abstract void shrinkAmount(String imageName, int amount);
	public abstract void stop();
	public abstract void undo();
	public abstract void viewBack();
	public abstract void viewFront();
	
	//Change Commands
	public abstract void changeNext();
	public abstract void changePrev();
	public abstract void changeTo(String cShirt);
	public abstract void clear();
	
	//Save Commands
	public abstract void delete(String cShirt);
	public abstract void saveAs(String cShirt) throws IOException;
	public abstract void saveCShirt() throws IOException;
	
}
