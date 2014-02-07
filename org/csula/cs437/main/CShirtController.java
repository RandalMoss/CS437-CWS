package org.csula.cs437.main;

import java.io.File;
import java.io.IOException;

import org.csula.cs437.util.CShirtFileFilter;

import com.google.gson.JsonSyntaxException;

public class CShirtController extends DataContainer {
	
	private File[] cShirtFiles;
	private int currentCShirtIndex;
	private CShirt currentCShirt;
	
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
		currentCShirt = CShirt.loadCShirt(cShirtFiles[0].getAbsolutePath().replace("%20", " "));
	}
	
	private File[] getCShirtFiles()
	{
		File folder = new File(getPathToFiles());
		return folder.listFiles(new CShirtFileFilter());
	}
	
	private String getPathToFiles()
	{
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		return classLoader.getResource(".").getPath().replace("%20", " ");
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
	public void backgroundColor() {
		// TODO Auto-generated method stub

	}

	@Override
	public void darken() {
		// TODO Auto-generated method stub

	}

	@Override
	public void enlarge(String imageName) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enlargeAmount(String imageName, int amount) {
		// TODO Auto-generated method stub

	}

	@Override
	public void moveUp(String imageName) {
		// TODO Auto-generated method stub

	}

	@Override
	public void moveUpDistance(String imageName, int distance) {
		// TODO Auto-generated method stub

	}

	@Override
	public void moveDown(String imageName) {
		// TODO Auto-generated method stub

	}

	@Override
	public void moveDownDistance(String imageName, int distance) {
		// TODO Auto-generated method stub

	}

	@Override
	public void moveLeft(String imageName) {
		// TODO Auto-generated method stub

	}

	@Override
	public void moveLeftDistance(String imageName, int distance) {
		// TODO Auto-generated method stub

	}

	@Override
	public void moveRight(String imageName) {
		// TODO Auto-generated method stub

	}

	@Override
	public void moveRightDistance(String imageName, int distance) {
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
	public void rotateClockwise(String imageName) {
		// TODO Auto-generated method stub

	}

	@Override
	public void rotateClockwiseDegrees(String imageName, int degrees) {
		// TODO Auto-generated method stub

	}

	@Override
	public void rotateCounterclockwise(String imageName) {
		// TODO Auto-generated method stub

	}

	@Override
	public void rotateCounterclockwiseDegrees(String imageName, int degrees) {
		// TODO Auto-generated method stub

	}

	@Override
	public void rotateToward(int degrees) {
		// TODO Auto-generated method stub

	}

	@Override
	public void select(String imageName) {
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
	public void shrink(String imageName) {
		// TODO Auto-generated method stub

	}

	@Override
	public void shrinkAmount(String imageName, int amount) {
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

}
