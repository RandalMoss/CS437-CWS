package org.csula.cs437.util;

public class StringHandler {
	public static String getCol(String line, int col) {
		String[] array = line.split("\\s+");
		return array[col];
	}
	
	public static int getIntFromCol(String line, int col) {
		String[] array = line.split("\\s+");
		return Integer.parseInt(array[col]);
	}

	public static int countColumn(String line) {
		String[] array = line.split("\\s+");
		return array.length;
	}

	public static double getDoubleFromCol(String line, int col) {
		String[] array = line.split("\\s+");
		return Double.parseDouble(array[col]);
	}
}
