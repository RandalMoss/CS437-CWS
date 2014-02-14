package org.csula.cs437.main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import org.csula.cs437.main.Image;


import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

public class CShirt
{
	private String name;
	private int brightness;
	private String color;

	private ArrayList<Image> images = new ArrayList<Image>();

	//boolean stop = false;


	public String getName() {
		return name;
	}

	public int getBrightness() {
		return brightness;
	}
	
	public void setBrightness(int brightness){
		this.brightness = brightness;
	}

	public String getColor() {
		return color;
	}
	
	public void setColor(String color){
		this.color = color;
	}

	public ArrayList<Image> getImages() {
		return images;
	}

	public CShirt()
	{
		this.name = "untitled";
		this.brightness = 100;
		this.color = "#FFFFFF";
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
	
	public void saveCShirt(String path) throws IOException
	{
		saveCShirt(this.name, path);
	}
	
	public void saveCShirt(String name, String path) throws IOException
	{
		PrintWriter writer = new PrintWriter((path + name + ".cShirt"));
		writer.write(makeCShirtFile(this));
		writer.close();
	}
	
	public static CShirt loadCShirt(String cShirtPath) throws IOException, JsonSyntaxException
	{
		BufferedReader reader = new BufferedReader(new FileReader(cShirtPath));
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
		System.out.println("Image Added");
		return images;
	}
	
	public void removeImage(String imageName)
	{
		for(int i = 0; i < images.size(); i++)
		{
			
		}
	}
	public void add(String imageName) {
		//dummy file path
		String dummyFilePath = "img1.jpg";
		Image image = new Image(dummyFilePath, imageName);
		addImage(image);
		//
	}

}