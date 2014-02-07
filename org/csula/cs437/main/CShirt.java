package org.csula.cs437.main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import java.io.File;

public class CShirt extends DataContainer
{
	private String name;
	private int brightness;
	private String color;
	private ArrayList<Image> images = new ArrayList<Image>();

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
	}

	@Override
	public String toString()
	{
		return "cShirt\nName: " +
				this.name + "\nBrightness: " +
				this.brightness + "\nColor: " +
				this.color + "\n";
	}
	
	public static String makeCShirtFile(CShirt cShirt)
	{
		Gson gson = new Gson();
		return gson.toJson(cShirt);
	}
	
	public static CShirt makeCShirtObject(String cShirtJson) throws JsonSyntaxException
	{
		Gson gson = new Gson();
		return gson.fromJson(cShirtJson, CShirt.class);
	}
	
	public void saveCShirt() throws IOException
	{
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		String url = classLoader.getResource(".").getPath();
		PrintWriter writer = new PrintWriter((url + "/CShirts/" + this.name + ".cShirt").replace("%20", " "));
		writer.write(makeCShirtFile(this));
		writer.close();
	}
	
	public static CShirt loadCShirt(String cShirtName) throws IOException, JsonSyntaxException
	{
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		String url = classLoader.getResource(".").getPath();
		BufferedReader reader = new BufferedReader( new FileReader((url + "/CShirts/" + cShirtName + ".cShirt").replace("%20", " ")));
		String nextLine;
		String cShirtJson = "";
		while((nextLine = reader.readLine()) != null )
		{
			cShirtJson += nextLine;
		}
		reader.close();
		
		return makeCShirtObject(cShirtJson);
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
	
	//Testing main
	public static void main(String[] args)
	{
		CShirt cShirt = new CShirt("test", 55, "#FF4C7B");
		cShirt.addImage(new Image("This is some path", "and this is a name"));
		cShirt.addImage(new Image("This is the second path", "and yet another name"));
		
		try {
			cShirt.saveCShirt();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try{
			System.out.println(CShirt.loadCShirt("test").toString());
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	
	
}