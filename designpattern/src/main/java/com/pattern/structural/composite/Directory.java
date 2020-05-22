package com.pattern.structural.composite;

import java.util.ArrayList;
import java.util.List;

public class Directory implements File {
	private String name;
	List<File> folder = new ArrayList<>();
	
	public Directory(String theName) {
		name = theName;
	}

	@Override
	public void add(File theFile) {
		folder.add(theFile);

	}

	@Override
	public boolean remove(File theFile) {
		for (File file : folder) {
			if(file.name().equalsIgnoreCase(theFile.name())) {
				folder.remove(theFile);
				
				return true;
			}
		}
		return false;
	}

	@Override
	public void show(String current) {
		String path = current + name;
		for (File file : folder) {
			file.show(path + "/");
		}

	}

	@Override
	public String name() {
		return name;
	}

}
