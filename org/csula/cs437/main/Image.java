package org.csula.cs437.main;

import org.csula.cs437.util.Section;

public class Image {
	
	private Section section;
	private String name;
	private String path;
	private int xCoord;
	private int yCoord;
	private double scale;
	private double rotation;
	
	public Section getSection() {
		return section;
	}

	public String getName() {
		return name;
	}

	public String getPath() {
		return path;
	}

	public int getxCoord() {
		return xCoord;
	}

	public int getyCoord() {
		return yCoord;
	}

	public double getScale() {
		return scale;
	}

	public double getRotation() {
		return rotation;
	}
	
	public Image()
	{
		section = Section.CHEST;
		name = "default image one";
		path = "defaultImage.png";
		xCoord = 0;
		yCoord = 0;
		scale = 1.0;
		rotation = 0.0;
	}
	
	public Image(String path, String name)
	{
		section = Section.CHEST;
		xCoord = 0;
		yCoord = 0;
		scale = 1.0;
		rotation = 0.0;
		
		this.name = name;
		this.path = path;
	}
	
	public int moveUp(int increment)
	{
		yCoord += increment;
		return yCoord;
	}
	
	public int moveDown(int increment)
	{
		yCoord -= increment;
		return yCoord;
	}
	
	public int moveLeft(int increment)
	{
		xCoord -= increment;
		return xCoord;
	}
	
	public int moveRight(int increment)
	{
		xCoord += increment;
		return xCoord;
	}
	
	public double rotateClockwise(double increment)
	{
		rotation = correctAngle(rotation + increment);
		return rotation;
	}
	
	public double rotateCounterClockwise(double increment)
	{
		rotation = correctAngle(rotation - increment);
		return rotation;
	}
	
	public void rotateToward(double angle)
	{
		rotation = correctAngle(angle);
	}
	
	private double correctAngle(double angle)
	{
		while(angle >= 360.0)
		{
			angle -= 360.0;
		}
		
		while(angle < 0.0)
		{
			angle += 360;
		}
		
		return angle;
	}
	
	public double enlarge(double increment)
	{
		scale += increment;
		return scale;
	}
	
	public double shrink(double increment)
	{
		if(scale - increment < 0.0)
		{
			scale = 0.0;
		}
		else
		{
			scale -= increment;
		}
		
		return scale;
	}

	
}
