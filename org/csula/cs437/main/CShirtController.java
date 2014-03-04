package org.csula.cs437.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;

import org.csula.cs437.util.CShirtFileFilter;
import org.csula.cs437.util.RotatingQueue;

import com.google.gson.JsonSyntaxException;

public class CShirtController extends DataContainer
{

	private RotatingQueue<File> cShirtFiles;
	private int currentCShirtIndex;
	private CShirt currentCShirt;
	
	public String currentImage;

	public String getCurrentImage(){
		return currentImage;
	}
	
	public RotatingQueue<File> getcShirtFiles() {
		return cShirtFiles;
	}

	public void setcShirtFiles(RotatingQueue<File> cShirtFiles)
	{
		this.cShirtFiles = cShirtFiles;
	}

	public int getCurrentCShirtIndex()
	{
		return currentCShirtIndex;
	}

	public void setCurrentCShirtIndex(int currentCShirtIndex)
	{
		this.currentCShirtIndex = currentCShirtIndex;
	}

	public CShirt getCurrentCShirt()
	{
		return currentCShirt;
	}

	public void setCurrentCShirt(CShirt currentCShirt)
	{
		this.currentCShirt = currentCShirt;
	}

	/**
	 * Creates a default shirt if none exist.
	 * 
	 * @throws JsonSyntaxException
	 * @throws IOException
	 */
	CShirtController() throws JsonSyntaxException, IOException
	{
		cShirtFiles = getCShirtFiles();
		// Set default if no shirts exist
		if(cShirtFiles.size() == 0)
		{
			CShirt shirt = new CShirt("Default", 100, "#FFFFFF");
			shirt.add("taco");
			shirt.saveCShirt(getPathToFiles());
			cShirtFiles = getCShirtFiles();
			currentCShirtIndex = 0;
			currentCShirt = CShirt.loadCShirt(cShirtFiles.get(0)
					.getAbsolutePath());
		}
		currentCShirtIndex = 0;
		currentCShirt = loadHeadFile();
		// Set default if head cShirt is empty
		if (currentCShirt == null)

		System.out.println("This is the current CShirt" + currentCShirt.toString());

		{
			CShirt shirt = new CShirt("Default", 100, "255.255.255");
			shirt.add("taco");
			shirt.saveCShirt(getPathToFiles());
			cShirtFiles = getCShirtFiles();
			currentCShirtIndex = 0;
			currentCShirt = CShirt.loadCShirt(cShirtFiles.get(0)
					.getAbsolutePath());
		}
	}

	private CShirt loadHeadFile() throws JsonSyntaxException, IOException
	{
		System.out.println(cShirtFiles.get(0).getAbsolutePath());
		return CShirt.loadCShirt(cShirtFiles.get(0).getAbsolutePath());
	}

	private RotatingQueue<File> getCShirtFiles()
	{
		File folder = new File(getPathToFiles());
		return new RotatingQueue<File>(new LinkedList<File>(
				Arrays.asList(folder.listFiles(new CShirtFileFilter()))));
	}

	private String getPathToFiles()
	{
//		ClassLoader classLoader = Thread.currentThread()
//				.getContextClassLoader();
//		 System.out.println(classLoader.getResource(".").getPath().replace("%20",
//		 " ").substring(1).replace("/", "\\") + "CShirts\\");
//		return classLoader.getResource(".").getPath().replace("%20", " ")
//				.substring(1).replace("/", "\\")
//				+ "CShirts\\";
		if(System.getProperty("os.name").equals("Linux")){
			return "CShirts/";
		}
		
		return "CShirts\\";

//		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
//		//System.out.println(classLoader.getResource(".").getPath().replace("%20", " ").substring(1).replace("/", "\\") + "CShirts\\");
//		return classLoader.getResource(".").getPath().replace("%20", " ").substring(1).replace("/", "\\") + "CShirts\\";
	}
	
	private String getPathToImages()
	{
		if(System.getProperty("os.name").equals("Linux")){
			return "images/";
		}
		return "images\\";
	}
	
	public String getImagePath(String imageName) throws FileNotFoundException
	{
		File[] imageFolder = new File(getPathToImages()).listFiles();
		String fileName = "";
		for(File f : imageFolder)
		{
			fileName = f.getName().split("\\.")[0].toLowerCase();
			if(imageName.toLowerCase().equals(fileName))
			{
				return f.getPath();
			}
		}
		
		throw new FileNotFoundException("Image does not exist or imageName does not match file.");
	}

	@Override
	public void add(String imageName)
	{
		currentCShirt.add(imageName);
	}

	@Override
	public void brighten()
	{
		System.out.println("You have brightened the shirt by: 10 units");

	}

	@Override
	public void backgroundColor(String newColor)
	{
		currentCShirt.setColor(newColor);
	}

	@Override
	public void darken()
	{
		System.out.println("You have darkened the shirt by: 10 units");

	}

	@Override
	public void enlarge(String imagePath, double amount)
	{
		currentCShirt.enlarge(imagePath, amount);
	}

	@Override
	public void moveUp(String imagePath, int distance)
	{
		currentCShirt.moveUp(imagePath, distance);
	}

	@Override
	public void moveDown(String imagePath, int distance)
	{
		currentCShirt.moveDown(imagePath, distance);
	}

	@Override
	public void moveLeft(String imageName, int distance)
	{
		currentCShirt.moveLeft(imageName, distance);
	}

	@Override
	public void moveRight(String imageName, int distance)
	{
		currentCShirt.moveRight(imageName, distance);
	}

	@Override
	public void pushBackward(String imageName)
	{
		currentCShirt.pushBackward(imageName);
	}

	@Override
	public void pushForward(String imageName)
	{
		currentCShirt.pushForward(imageName);
	}

	@Override
	public void redo()
	{
		// TODO Auto-generated method stub
		// unimplemented method (ran out of time)
	}

	@Override
	public void remove(String imageName)
	{
		currentCShirt.remove(imageName);
	}

	@Override
	public void rotateClockwise(String imagePath, double degrees)
	{
		currentCShirt.rotateClockwise(imagePath, degrees);
	}

	@Override
	public void rotateCounterclockwise(String imageName, double degrees)
	{
		currentCShirt.rotateCounterClockwise(imageName, degrees);
	}

	@Override
	public void rotateToward(String imagePath, double degrees)
	{
		currentCShirt.rotateToward(imagePath, degrees);
	}

	@Override
	public void sendBack(String imageName)
	{
		currentCShirt.sendBack(imageName);
	}

	@Override
	public void sendFront(String imageName)
	{
		currentCShirt.sendFront(imageName);
	}

	@Override
	public void shrink(String imagePath, double amount)
	{
		currentCShirt.shrink(imagePath, amount);
	}

	@Override
	public void stop()
	{
		// TODO Auto-generated method stub
		// unimplemented method (ran out of time)
	}

	@Override
	public void undo()
	{
		// TODO Auto-generated method stub
		// unimplemented method (ran out of time)
	}

	@Override
	public void viewBack()
	{
		// TODO Auto-generated method stub
		// unimplemented method (ran out of time)
	}

	@Override
	public void viewFront()
	{
		// TODO Auto-generated method stub
		// unimplemented method (ran out of time)
	}

	@Override
	public void changeNext() throws JsonSyntaxException, IOException
	{
		cShirtFiles.rotateForward();
		currentCShirt = loadHeadFile();
	}

	@Override
	public void changePrev() throws JsonSyntaxException, IOException
	{
		cShirtFiles.rotateBackward();
		currentCShirt = loadHeadFile();
	}

	/**
	 * 
	 * @param cShirt
	 *            - name of shirt to be changed to
	 * @return False if the shirt does not exist
	 * @throws JsonSyntaxException
	 * @throws IOException
	 */
	@Override
	public boolean changeTo(String cShirt) throws JsonSyntaxException,
			IOException
	{
		cShirtFiles.rotateForward();
		CShirt temp;
		boolean found = (temp = loadHeadFile()).getName().equals(cShirt);
		boolean checkedAll = currentCShirt.getName().equals(cShirt);

		while (!found && !checkedAll)
		{
			cShirtFiles.rotateForward();
			found = (temp = loadHeadFile()).getName().equals(cShirt);
			checkedAll = currentCShirt.getName().equals(temp.getName());
		}

		if (found)
		{
			currentCShirt = temp;
		}

		return found;
	}

	@Override
	public void clear() throws JsonSyntaxException, IOException
	{
		changeTo("deafult");
	}

	/**
	 * 
	 * @param cShirt
	 *            - name of shirt to be deleted
	 * @return false if shirt is not found
	 * @throws JsonSyntaxException
	 * @throws IOException
	 */
	@Override
	public boolean delete(String cShirt) throws JsonSyntaxException,
			IOException
	{
		boolean found = false;

		if (currentCShirt.getName().equals(cShirt))
		{
			File fileToDelete = cShirtFiles.pop();
			fileToDelete.delete();
			clear();
			found = true;
		}
		else
		{
			File fileToDelete;
			for (int i = 1; i < cShirtFiles.size(); i++)
			{
				if (cShirtFiles.get(i).getName().equals(cShirt))
				{
					fileToDelete = cShirtFiles.remove(i);
					fileToDelete.delete();
					cShirtFiles = getCShirtFiles();
					found = true;
				}
			}
		}

		return found;
	}

	@Override
	public void saveAs(String cShirt) throws IOException
	{
		currentCShirt.saveCShirt(cShirt, getPathToFiles());
		cShirtFiles = getCShirtFiles();
		changeTo(cShirt);
	}

	@Override
	public void saveCShirt() throws IOException
	{
		currentCShirt.saveCShirt(getPathToFiles());
		
	}

	public static void main(String[] args)
	{
		try
		{

			CShirtController controller = new CShirtController();
			controller.changeNext();
			controller.currentCShirt.add("number one");
			controller.currentCShirt.add("number two");
			controller.currentCShirt.add("number three");
			controller.remove("number three");
			controller.pushForward("number two");
			controller.pushBackward("number one");
			controller.sendFront("number three");
			controller.sendBack("number two");
			for (Image i : controller.currentCShirt.getImages())
			{
				System.out.println(i.getName());
			}
			System.out.println(controller.getCurrentCShirt().toString());

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
