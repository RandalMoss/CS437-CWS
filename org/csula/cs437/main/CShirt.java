package org.csula.cs437.main;

import java.util.ArrayList;

class CShirt
{
	String name;
	int brightness;
	String color;
	ArrayList<Image> images;

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
	
	public void addImage(Image image)
	{
		images.add(image);
	}

	@Override
	public String toString()
	{
		return "cShirt\nName: " +
				this.name + "\nBrightness: " +
				this.brightness + "\nColor: " +
				this.color + "\n";
	}
}