package org.csula.cs437.util;

import org.csula.cs437.main.CShirt;
import org.csula.cs437.main.Image;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

class CShirtParser
{
	public CShirt parseCShirtFile(String path) throws IOException, FileNotFoundException
	{
		CShirt cShirt;
		ArrayList<Image> imageList = new ArrayList<Image>();
		String name;
		int brightness;
		String color;
		String fileCheck[] = path.split(".");
		
		if(!(fileCheck[fileCheck.length - 1].equalsIgnoreCase("cshirt")))
		{
			throw new FileNotFoundException("InvalidFileType");
		}
		
		BufferedReader reader = new BufferedReader(new FileReader(path));
		String line;
		boolean inShirt = false;
		boolean inImage = false;
		boolean inImageElement = false;
		
		while((line = reader.readLine()) != null)
		{
			String splitLine[] = line.split(" ");
			int splitLength = splitLine.length;
			
			
			if(inShirt)
			{
				if(inImage)
				{
					if(splitLine[0].charAt(0) == '<' && splitLine[splitLength - 1].charAt(splitLine[splitLength - 1].length() - 1) == '>')
					{
						
					}
				}
				else if(splitLine[0].charAt(0) == '<' && splitLine[splitLength - 1].charAt(splitLine[splitLength - 1].length() - 1) == '>')
				{
					if(splitLine[0].replace("<", "").equalsIgnoreCase("image"))
					{
						String imageName = "";
						String imagePath = "";
						
						for(String s : splitLine)
						{
							String split[] = s.split("\"");
							if(split.length > 1)
							{
								switch(split[0])
								{
								case "name": imageName = split[1].replace(">", "");
								break;
								case "path": imagePath = split[1].replace(">", "");
								break;
								}
							}
						}
						
						imageList.add(new Image(imagePath, imageName));
						inImage = true;
					}
				}
				else
				{
					continue;
				}
			}
			else if(!(splitLine[0].charAt(0) == '<' && splitLine[splitLength - 1].charAt(splitLine[splitLength - 1].length() - 1) == '>'))
			{
				if(splitLine[0].replace("<", "").equalsIgnoreCase("cshirt"))
				{
					
				}
			}
			else 
			{
				continue;
			}
			
			
		}
		
		
		
		return null;
	}
	
	private String[] removeEmptyStrings(String[] split)
	{
		ArrayList<String> newSplit = new ArrayList<String>();
		for(String s : split)
		{
			if(!(s.isEmpty()))
			{
				newSplit.add(s);
			}
		}
		
		return (String[]) newSplit.toArray();
	}
	
	private String[] splitOpenAndClose(String[] split)
	{
		ArrayList<String> newSplit = new ArrayList<String>();
		
		for(String s1 : split)
		{
			for(String s2 : s1.split(">"))
			{
				for(String s3 : s2.split("<"))
				{
					
				}
			}
		}
		
		return (String[]) newSplit.toArray();
	}
}