package org.csula.cs437.main;

import java.io.File;
import java.util.ArrayList;

public class CShirt extends DataContainer
{
	private String name;
	private int brightness;
	private String color;
	private ArrayList<Image> images;

	public String getName() {
		return name;
	}

	public int getBrightness() {
		return brightness;
	}

	public String getColor() {
		return color;
	}

	public ArrayList<Image> getImages() {
		return images;
	}

	public CShirt()
	{
		this.name = "untitled";
		this.brightness = 100;
		this.color = "FFFFFF";
		images = new ArrayList<Image>();
	}

	public CShirt(String name, int brightness, String color)
	{
		this.name = name;
		this.brightness = brightness;
		this.color = color;
		images = new ArrayList<Image>();
	}

	@Override
	public String toString()
	{
		return "cShirt\nName: " +
				this.name + "\nBrightness: " +
				this.brightness + "\nColor: " +
				this.color + "\n";
	}

	//This is the in-construction zone
	//Begin contruction zone
	private Image createNewImage(String path, String name)
	{
		
		return null;
	}
	
	public ArrayList<Image> addImage(Image image)
	{
		images.add(image);
		
		return images;
	}
	
	public void removeImage(String name)
	{
		for(int i = 0; i < images.size(); i++)
		{
			
		}
	}

	@Override
	public void add(String imageName) {
		//dummy file path
		String dummyFilePath = "img1.jpg";
		Image image = new Image(dummyFilePath, imageName);
		addImage(image);
		//
	}

	@Override
	public void brighten() {
		
	}

	@Override
	public void backgroundColor() {
		
	}

	@Override
	public void darken() {
		
	}

	@Override
	public void enlarge(String imageName) {
		
	}

	@Override
	public void enlargeAmount(String imageName, int amount) {
		
	}

	@Override
	public void moveUp(String imageName) {
		
		
	}

	@Override
	public void moveUpDistance(String imageName, int distance) {
		
		
	}

	@Override
	public void moveDown(String imageName) {
		
		
	}

	@Override
	public void moveDownDistance(String imageName, int distance) {
		
		
	}

	@Override
	public void moveLeft(String imageName) {
		
		
	}

	@Override
	public void moveLeftDistance(String imageName, int distance) {
		
		
	}

	@Override
	public void moveRight(String imageName) {
		
		
	}

	@Override
	public void moveRightDistance(String imageName, int distance) {
		
		
	}

	@Override
	public void pushBackward(String imageName) {
		
		
	}

	@Override
	public void pushForward(String imageName) {
		
		
	}

	@Override
	public void redo() {
		
		
	}

	@Override
	public void remove(String imageName) {
		
		
	}

	@Override
	public void rotateClockwise(String imageName) {
		
		
	}

	@Override
	public void rotateClockwiseDegrees(String imageName, int degrees) {
		
		
	}

	@Override
	public void rotateCounterclockwise(String imageName) {
		
		
	}

	@Override
	public void rotateCounterclockwiseDegrees(String imageName, int degrees) {
		
		
	}

	@Override
	public void rotateToward(int degrees) {
		
		
	}

	@Override
	public void select(String imageName) {
		
		
	}

	@Override
	public void sendBack(String imageName) {
		
		
	}

	@Override
	public void sendFront(String imageName) {
		
		
	}

	@Override
	public void shrink(String imageName) {
		
		
	}

	@Override
	public void shrinkAmount(String imageName, int amount) {
		
		
	}

	@Override
	public void stop() {
		
		
	}

	@Override
	public void undo() {
		
		
	}

	@Override
	public void viewBack() {
		
		
	}

	@Override
	public void viewFront() {
		
		
	}

	@Override
	public void changeNext() {
		
		
	}

	@Override
	public void changePrev() {
		
		
	}

	@Override
	public void changeTo(String cShirt) {
		
		
	}

	@Override
	public void clear() {
		
		
	}

	@Override
	public void delete(String cShirt) {
		
		
	}

	@Override
	public void saveAs(String cShirt) {
		
		
	}

	@Override
	public void saveCShirt(String cShirt) {
		
		
	}
	
	//End construction zone
	
}