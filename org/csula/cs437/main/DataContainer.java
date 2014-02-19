package org.csula.cs437.main;

import java.io.IOException;

import com.google.gson.JsonSyntaxException;

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
	public abstract void enlarge(String imagePath, double amount);
	public abstract void moveUp(String imagePath, int distance);
	public abstract void moveDown(String imagePath, int distance);
	public abstract void moveLeft(String imagePath, int distance);
	public abstract void moveRight(String imagePath, int distance);
	public abstract void pushBackward(String imagePath);
	public abstract void pushForward(String imagePath);
	public abstract void redo();
	public abstract void remove(String imagePath);
	public abstract void rotateClockwise(String imagePath, double degrees);
	public abstract void rotateCounterclockwise(String imagePath, double degrees);
	public abstract void rotateToward(String imagePath, double degrees);
	//public abstract void select(String imagePath);
	public abstract void sendBack(String imagePath);
	public abstract void sendFront(String imagePath);
	public abstract void shrink(String imagePath, double amount);
	public abstract void stop();
	public abstract void undo();
	public abstract void viewBack();
	public abstract void viewFront();
	
	//Change Commands
	public abstract void changeNext() throws JsonSyntaxException, IOException;
	public abstract void changePrev() throws JsonSyntaxException, IOException;
	public abstract boolean changeTo(String cShirt) throws JsonSyntaxException, IOException;
	public abstract void clear() throws JsonSyntaxException, IOException;
	
	//Save Commands
	public abstract boolean delete(String cShirt) throws JsonSyntaxException, IOException;
	public abstract void saveAs(String cShirt) throws IOException;
	public abstract void saveCShirt() throws IOException;
	
}
