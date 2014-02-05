package org.csula.cs437.main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

public class CShirt
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
		this.color = "#FFFFFF";
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
		Writer writer = new BufferedWriter(new OutputStreamWriter(
		          new FileOutputStream("/../../CShirts/" + this.name + ".cShirt"), "utf-8"));;
		writer.write(makeCShirtFile(this));
		writer.close();
	}
	
	public static CShirt loadCShirt(String cShirtName) throws IOException, JsonSyntaxException
	{
		BufferedReader reader = new BufferedReader( new FileReader("/../../CShirts/" + cShirtName + ".cShirt"));
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
	//End construction zone
	
	/*
	//Testing main
	public static void main(String[] args)
	{
		CShirt cShirt = new CShirt("test", 55, "#FF4C7B");
		cShirt.addImage(new Image("This is some path", "and this is a name"));
		cShirt.addImage(new Image("This is the second path", "and yet another name"));
		
		System.out.println(CShirt.makeCShirtFile(cShirt));
	}
	*/
	
	
}