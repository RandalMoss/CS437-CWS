package org.csula.cs437.util;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileHandler {
	
	public static int countLines(String fileName) {
		int count = 0;

		try {
			File fin = new File(fileName);
			Scanner scanner = new Scanner(fin);
		
			while (scanner.hasNext()) {
				count++;
				scanner.nextLine();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return count;	
	}
	
	public static int countColumns(String fileName) {
		try {
			String lines[] = readFile(fileName);
			return StringHandler.countColumn(lines[0]);
		} catch (IOException e) {
			System.out.println("ERROR *** " + e.getMessage() 
					+ "***");
			return -1;
		} catch (Exception e) {
			return 0;
		}
	}
	
	public static String[] readFile(String fileName) 
	throws IOException {
		int numberOfLines = countLines(fileName);
		
		if (numberOfLines == 0)
			return null;
		
		String arrayOfStrings[] = new String[numberOfLines];
		
		try {
			File fin = new File(fileName);
			Scanner scanner = new Scanner(fin);

			for (int i = 0; scanner.hasNext(); i++) {
				arrayOfStrings[i] = scanner.nextLine();
			}
			
			scanner.close();
			
		} catch (Exception e) {
			String msg = "File read error: filename=" + fileName;
			throw new IOException(msg);
		}

		return arrayOfStrings;
	}
	
	public static void writeFile(String fileName, String[]data) {
		File fout = new File(fileName);

		try {
			PrintWriter out = new PrintWriter(fout);
			for (String line : data) {
				out.println(line);
			}
			
			out.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
