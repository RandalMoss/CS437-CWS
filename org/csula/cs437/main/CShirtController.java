package org.csula.cs437.main;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream.GetField;

import org.csula.cs437.util.CShirtFileFilter;

import com.google.gson.JsonSyntaxException;

public class CShirtController extends DataContainer {
	
	private File[] cShirtFiles;
	private int currentCShirtIndex;
	private CShirt currentCShirt;
	
	boolean stop = false;
	
	public File[] getcShirtFiles() {
		return cShirtFiles;
	}

	public void setcShirtFiles(File[] cShirtFiles) {
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

	CShirtController() throws JsonSyntaxException, IOException
	{
		cShirtFiles = getCShirtFiles();
		currentCShirtIndex = 0;
		currentCShirt = CShirt.loadCShirt(cShirtFiles[0].getAbsolutePath());
	}
	
	private File[] getCShirtFiles()
	{
		File folder = new File(getPathToFiles());
		return folder.listFiles(new CShirtFileFilter());
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
		int brightness = currentCShirt.getBrightness();
		while(stop == false){
		brightness += 5;
		currentCShirt.setBrightness(brightness);
		}
		stop = false;

	}

	@Override
	public void backgroundColor(String newColor) {
		currentCShirt.setColor(newColor);
	}

	@Override
	public void darken() {
		int brightness = currentCShirt.getBrightness();
		while(stop == false){
			brightness -= 5;
			currentCShirt.setBrightness(brightness);
		}
		stop = false;
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
		stop = true;
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
	public void changeNext() {
		// TODO Auto-generated method stub

	}

	@Override
	public void changePrev() {
		// TODO Auto-generated method stub

	}

	@Override
	public void changeTo(String cShirt) {
		// TODO Auto-generated method stub

	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(String cShirt) {
		// TODO Auto-generated method stub

	}

	@Override
	public void saveAs(String cShirt) {
		// TODO Auto-generated method stub

	}

	@Override
	public void saveCShirt() throws IOException {
		currentCShirt.saveCShirt(getPathToFiles());
	}

	public static void main(String[] args)
	{
		try {
		
		CShirtController controller = new CShirtController();
		controller.add("and this is a name");
		controller.add("and yet another name");
		
		controller.saveCShirt();
		
		System.out.println(CShirt.loadCShirt(controller.getPathToFiles() + "test.cShirt").toString());
		} catch (Exception e){
			e.printStackTrace();
		}
	}
}
