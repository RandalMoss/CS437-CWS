package org.csula.cs437.main;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;

import org.csula.cs437.util.CShirtFileFilter;
import org.csula.cs437.util.RotatingQueue;

import com.google.gson.JsonSyntaxException;

public class CShirtController extends DataContainer {
	
	private RotatingQueue<File> cShirtFiles;
	private int currentCShirtIndex;
	private CShirt currentCShirt;
	
	public RotatingQueue<File> getcShirtFiles() {
		return cShirtFiles;
	}

	public void setcShirtFiles(RotatingQueue<File> cShirtFiles) {
		this.cShirtFiles = cShirtFiles;
	}

	public int getCurrentCShirtIndex() {
		return currentCShirtIndex;
	}

	public void setCurrentCShirtIndex(int currentCShirtIndex) {
		this.currentCShirtIndex = currentCShirtIndex;
	}

	public CShirt getCurrentCShirt() {
		return currentCShirt;
	}

	public void setCurrentCShirt(CShirt currentCShirt) {
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
		currentCShirtIndex = 0;
		currentCShirt = loadHeadFile();
		//Set default if no shirts exist
		if(currentCShirt == null)
		{
			CShirt shirt = new CShirt("Default", 100, "255.255.255");
			shirt.add("taco");
			shirt.saveCShirt(getPathToFiles());
			cShirtFiles = getCShirtFiles();
			currentCShirtIndex = 0;
			currentCShirt = CShirt.loadCShirt(cShirtFiles.get(0).getAbsolutePath());
		}
	}
	
	private CShirt loadHeadFile() throws JsonSyntaxException, IOException
	{
		return CShirt.loadCShirt(cShirtFiles.get(0).getAbsolutePath());
	}
	
	private RotatingQueue<File> getCShirtFiles()
	{
		File folder = new File(getPathToFiles());
		return new RotatingQueue<File>(new LinkedList<File>(Arrays.asList(folder.listFiles(new CShirtFileFilter()))));
	}
	
	private String getPathToFiles()
	{
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		System.out.println(classLoader.getResource(".").getPath().replace("%20", " ").substring(1).replace("/", "\\") + "CShirts\\");
		return classLoader.getResource(".").getPath().replace("%20", " ").substring(1).replace("/", "\\") + "CShirts\\";
	}
	
	@Override
	public void add(String imageName) {
		// TODO Auto-generated method stub

	}

	@Override
	public void brighten() {
		// TODO Auto-generated method stub

	}

	@Override
	public void backgroundColor(String newColor) {
		// TODO Auto-generated method stub

	}

	@Override
	public void darken() {
		// TODO Auto-generated method stub

	}

	@Override
	public void enlarge(String imagePath, double amount) {
		// TODO Auto-generated method stub

	}

	@Override
	public void moveUp(String imagePath, int distance) {
		// TODO Auto-generated method stub

	}

	@Override
	public void moveDown(String imagePath, int distance) {
		// TODO Auto-generated method stub

	}

	@Override
	public void moveLeft(String imageName, int distance) {
		// TODO Auto-generated method stub

	}

	@Override
	public void moveRight(String imageName, int distance) {
		// TODO Auto-generated method stub

	}

	@Override
	public void pushBackward(String imageName) {
		// TODO Auto-generated method stub

	}

	@Override
	public void pushForward(String imageName) {
		// TODO Auto-generated method stub

	}

	@Override
	public void redo() {
		// TODO Auto-generated method stub

	}

	@Override
	public void remove(String imageName) {
		// TODO Auto-generated method stub

	}

	@Override
	public void rotateClockwise(String imagePath, double degrees) {
		// TODO Auto-generated method stub

	}

	@Override
	public void rotateCounterclockwise(String imageName, double degrees) {
		// TODO Auto-generated method stub

	}

	@Override
	public void rotateToward(String imagePath, double degrees) {
		// TODO Auto-generated method stub

	}

	@Override
	public void sendBack(String imageName) {
		// TODO Auto-generated method stub

	}

	@Override
	public void sendFront(String imageName) {
		// TODO Auto-generated method stub

	}

	@Override
	public void shrink(String imagePath, double amount) {
		// TODO Auto-generated method stub

	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub

	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub

	}

	@Override
	public void viewBack() {
		// TODO Auto-generated method stub

	}

	@Override
	public void viewFront() {
		// TODO Auto-generated method stub

	}

	@Override
	public void changeNext() throws JsonSyntaxException, IOException {
		cShirtFiles.rotateForward();
		currentCShirt = loadHeadFile();
	}

	@Override
	public void changePrev() throws JsonSyntaxException, IOException {
		cShirtFiles.rotateBackward();
		currentCShirt = loadHeadFile();
	}
	
	/**
	 * 
	 * @param cShirt - name of shirt to be changed to
	 * @return False if the shirt does not exist
	 * @throws JsonSyntaxException
	 * @throws IOException
	 */
	@Override
	public boolean changeTo(String cShirt) throws JsonSyntaxException, IOException {
		cShirtFiles.rotateForward();
		CShirt temp;
		boolean found = (temp = loadHeadFile()).getName().equals(cShirt);
		boolean checkedAll = currentCShirt.getName().equals(cShirt);
		
		while(!found && !checkedAll)
		{
			cShirtFiles.rotateForward();
			found = (temp = loadHeadFile()).getName().equals(cShirt);
			checkedAll = currentCShirt.getName().equals(cShirt);
		}
		
		if(found)
		{
			currentCShirt = temp;
		}
		
		return found;
	}

	@Override
	public void clear() throws JsonSyntaxException, IOException {
		// TODO Auto-generated method stub
		changeTo("deafult");
	}
	
	/**
	 * 
	 * @param cShirt - name of shirt to be deleted
	 * @return false if shirt is not found
	 * @throws JsonSyntaxException
	 * @throws IOException
	 */
	@Override
	public boolean delete(String cShirt) throws JsonSyntaxException, IOException {
		// TODO Auto-generated method stub
		boolean found = false;
		
		if(currentCShirt.getName().equals(cShirt))
		{
			File fileToDelete = cShirtFiles.pop();
			fileToDelete.delete();
			clear();
			found = true;
		}
		else
		{
			File fileToDelete;
			for(int i = 1; i < cShirtFiles.size(); i++)
			{
				if(cShirtFiles.get(i).getName().equals(cShirt))
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
	public void saveAs(String cShirt) throws IOException {
		currentCShirt.saveCShirt(cShirt, getPathToFiles());
		cShirtFiles = getCShirtFiles();
		changeTo(cShirt);
	}

	@Override
	public void saveCShirt() throws IOException {
		currentCShirt.saveCShirt(getPathToFiles());
		
	}

	public static void main(String[] args)
	{

//		try {
//		CShirt shirt = new CShirt("test", 100, "#FFFFFF");
//		shirt.add("sample.jpg");

		try {	

		
		CShirtController controller = new CShirtController();
		
		System.out.println(controller.getCurrentCShirt().toString());
		controller.changeNext();
		System.out.println(controller.getCurrentCShirt().toString());
		
		} catch (Exception e){
			e.printStackTrace();
		}
	}
}
