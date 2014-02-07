package org.csula.cs437.main;

public abstract class DataContainer {
	int id;
	protected DataContainer() {
		this(-1); // default id is -1
	}
	
	DataContainer(int id) {
		this.id = id;
	}
	
	// commands
	public abstract void add(String imagePath);
	public abstract void brighten();
	public abstract void backgroundColor(String newColor);
	public abstract void darken();
	public abstract void enlarge(String imagePath, int amount);
	public abstract void moveUp(String imagePath, int distance);
	public abstract void moveDown(String imagePath, int distance);
	public abstract void moveLeft(String imagePath, int distance);
	public abstract void moveRight(String imagePath, int distance);
	public abstract void pushBackward(String imagePath);
	public abstract void pushForward(String imagePath);
	public abstract void redo();
	public abstract void remove(String imagePath);
	public abstract void rotateClockwise(String imagePath, int degrees);
	public abstract void rotateCounterclockwise(String imagePath, int degrees);
	public abstract void rotateToward(String imagePath);
	public abstract void select(String imagePath);
	public abstract void sendBack(String imagePath);
	public abstract void sendFront(String imagePath);
	public abstract void shrink(String imagePath, int amount);
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
	public abstract void saveAs(String cShirt);
	public abstract void saveCShirt(String cShirt);
	
}
