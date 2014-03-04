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

	boolean stop = false;

	private ArrayList<Image> images = new ArrayList<Image>();

	public boolean isStop()
	{
		return stop;
	}

	public void setStop(boolean stop)
	{
		this.stop = stop;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public void setBrightness(int brightness)
	{
		this.brightness = brightness;
	}

	public void setColor(String color)
	{
		this.color = color;
	}

	public void setImages(ArrayList<Image> images)
	{
		this.images = images;
	}

	public String getName()
	{
		return name;
	}

	public int getBrightness()
	{
		return brightness;
	}

	public String getColor()
	{
		return color;
	}

	public ArrayList<Image> getImages()
	{
		return images;
	}
	
	public String[] imagesArray(){
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
		return "cShirt\nName: " + this.name + "\nBrightness: "
				+ this.brightness + "\nColor: " + this.color + "\n";
	}

	public static String makeCShirtFile(CShirt cShirt)
	{
		Gson gson = new Gson();
		return gson.toJson(cShirt);
	}

	public static CShirt makeCShirtObject(String cShirtJson)
			throws JsonSyntaxException
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

	public static CShirt loadCShirt(String cShirtPath) throws IOException,
			JsonSyntaxException
	{
		BufferedReader reader = new BufferedReader(new FileReader(cShirtPath));
		String nextLine;
		String cShirtJson = "";
		while ((nextLine = reader.readLine()) != null)
		{
			cShirtJson += nextLine;
		}
		reader.close();

		return makeCShirtObject(cShirtJson);
	}

	public void addImage(Image image)
	{
		images.add(image);
		System.out.println("Image Added " + image.getName() + " " + image.getPath());
	}

	public void add(String imageName)
	{
		Image image = new Image(imageName, imageName);
		this.addImage(image);
	}

	private int getImageIndex(String imageName)
	{
		int index = 0;
		boolean found = false;
		while (index < images.size() && !found)
		{
			System.out.println(images.get(index).getName());
			System.out.println("image name is = " + imageName);
			if (images.get(index).getName().equals(imageName))
			{
				found = true;
			}
			else
			{
				index++;
			}
		}

		if (found)
		{
			return index;
		}

		return -1;

	}

	public void pushForward(String imageName)
	{
		int imageIndex;
		boolean pushed = false;
		if ((imageIndex = getImageIndex(imageName)) >= 0)
		{
			while (imageIndex > 0 && !pushed)
			{
				if (images.get(imageIndex).getSection() == images.get(
						imageIndex - 1).getSection())
				{
					pushed = true;
				}

				images.add(imageIndex, images.remove(imageIndex - 1));
				imageIndex--;
			}
		}
	}

	public void pushBackward(String imageName)
	{
		int imageIndex = getImageIndex(imageName);
		boolean pushed = false;
		if (imageIndex >= 0)
		{
			while (imageIndex < images.size() - 1 && !pushed)
			{
				if (images.get(imageIndex).getSection() == images.get(
						imageIndex + 1).getSection())
				{
					pushed = true;
				}

				images.add(imageIndex, images.remove(imageIndex + 1));
				imageIndex++;
			}
		}
	}

	public void sendFront(String imageName)
	{
		int imageIndex = getImageIndex(imageName);
		if (imageIndex > 0)
		{
			images.add(0, images.remove(imageIndex));
		}
	}

	public void sendBack(String imageName)
	{
		int imageIndex = getImageIndex(imageName);
		if (imageIndex >= 0 && imageIndex < images.size() - 1)
		{
			images.add(images.remove(imageIndex));
		}
	}

	public Image remove(String imageName)
	{
		int imageIndex = getImageIndex(imageName);
		if (imageIndex >= 0)
		{
			return images.remove(imageIndex);
		}

		return null;
	}

	public void rotateClockwise(String imageName, double increment)
	{

		images.get(getImageIndex(imageName)).rotateClockwise(increment);
	}

	public void rotateCounterClockwise(String imageName, double increment)
	{
		images.get(getImageIndex(imageName)).rotateCounterClockwise(increment);
	}

	public void rotateToward(String imageName, double degrees)
	{
		images.get(getImageIndex(imageName)).rotateToward(degrees);
	}

	public void shrink(String imageName, double increment)
	{
		images.get(getImageIndex(imageName)).shrink(increment);
	}

	public void enlarge(String imageName, double increment)
	{
		images.get(getImageIndex(imageName)).enlarge(increment);
	}

	public void moveUp(String imageName, int increment)
	{
		images.get(getImageIndex(imageName)).moveUp(increment);
	}

	public void moveDown(String imageName, int increment)
	{
		images.get(getImageIndex(imageName)).moveDown(increment);
	}

	public void moveRight(String imageName, int increment)
	{
		images.get(getImageIndex(imageName)).moveRight(increment);
	}

	public void moveLeft(String imageName, int increment)
	{
		images.get(getImageIndex(imageName)).moveLeft(increment);
	}
}
