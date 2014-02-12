package org.csula.cs437.main;

import java.io.File;
import java.util.ArrayList;
import org.csula.cs437.main.Image;

public class CShirt extends DataContainer
{
	private String name;
	private int brightness;
	private String color;
	private ArrayList<Image> images;
	boolean stop = false;

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
	}

	public CShirt(String name, int brightness, String color)
	{
		this.name = name;
		this.brightness = brightness;
		this.color = color;
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
		System.out.println("Image Added");
		return images;
	}
	
	public void removeImage(String imageName)
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
		while(stop != true){
			brightness += 5;
		}
	}

	@Override
	public void backgroundColor(String newColor) {
		color = newColor;
	}

	@Override
	public void darken() {
		while(stop != true){
			brightness -= 5;
		}
	}

	@Override
	public void enlarge(String imageName, double amount) {
		
		System.out.println("Image enlarged");
	}

	@Override
	public void moveUp(String imageName, int distance) {
		System.out.println("Image moved up");
		
	}

	@Override
	public void moveDown(String imageName, int distance) {
		System.out.println("Image moved down");
		
	}

	@Override
	public void moveLeft(String imageName, int distance) {
		System.out.println("Image moved left");
		
	}
	
	@Override
	public void moveRight(String imageName, int distance) {
		System.out.println("Image moved right");
		
	}
	
	@Override
	public void pushBackward(String imageName) {
		System.out.println("Image pushed backward");
		
	}

	@Override
	public void pushForward(String imageName) {
		
		System.out.println("Image pushed forward");
	}

	@Override
	public void redo() {
		
		System.out.println("Redo action");
	}

	@Override
	public void remove(String imageName) {
		
		System.out.println("Image removed");
	}

	@Override
	public void rotateClockwise(String imageName, double degrees) {
		System.out.println("Image rotated clockwise");
		
	}

	@Override
	public void rotateCounterclockwise(String imageName, double degrees) {
		
		System.out.println("Image rotate counterclockwise");
	}

	@Override
	public void rotateToward(String imageName, double degrees) {
		System.out.println("Image rotated toward");
		
	}

	/*
	@Override
	public void select(String imageName) {
		System.out.println("Image selected");
		
	} */

	@Override
	public void sendBack(String imageName) {
		System.out.println("Image sent to back");
		
	}

	@Override
	public void sendFront(String imageName) {
		
		System.out.println("Image sent to front");
	}

	@Override
	public void shrink(String imageName, double amount) {
		
		System.out.println("Image shrunk");
	}

	@Override
	public void stop() {
		stop = true;
		System.out.println("Action stopped");
	}

	@Override
	public void undo() {
		
		System.out.println("Undo action");
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