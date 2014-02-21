package org.csula.cs437.main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.Spring;

import org.csula.cs437.main.Image;


import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

public class CShirt
{
	private String name;
	private int brightness;
	private String color;
	
	
	private static ArrayList<Image> images = new ArrayList<Image>();
	
	boolean stop = false;
	public static String currentImage;

	public static String getCurrentImage(){
		return currentImage;
	}
	
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
	
	public static String[] imagesArray(){
        String[] imagesArray = new String[images.size()];
        int i=0;
        for(Image currentImage: images){
            imagesArray[i] = currentImage.getName();
            i++;
        }
        return imagesArray;
    }
	
	public CShirt()
	{
		this.name = "untitled";
		this.brightness = 100;
		this.color = "255.255.255";
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
		this.name = name;
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
		System.out.println("Image Added " + image.getName() + " " + image.getPath());
		return images;
	}
	
	public void removeImage(String imageName)
	{
		for(int i = 0; i < images.size(); i++)
		{
			
		}
	}
	public void add(String imageName) {
		StringBuilder imagePath = new StringBuilder("bin/images/");
		imagePath.append(imageName);
		Image image = new Image(imagePath.toString(), imageName);
		addImage(image);
	}

}