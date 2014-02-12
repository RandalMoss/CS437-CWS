package org.csula.cs437.util;

import java.io.File;
import java.io.FilenameFilter;

import javax.swing.filechooser.FileFilter;

public class CShirtFileFilter extends FileFilter implements FilenameFilter{

	@Override
	public boolean accept(File f) {
		return f.getName().endsWith(".cShirt");
	}

	@Override
	public String getDescription() {
		return "Checks if the file in question is a cShirtFile.";
	}

	@Override
	public boolean accept(File dir, String name) {
		return name.endsWith(".cShirt");
	}

}
