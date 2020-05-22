package com.pattern.structural.composite;

public class AbsoluteFile implements File {
	private String name;
	
	public AbsoluteFile(String theName) {
		name = theName;
	}

	@Override
	public void add(File theFile) {
	}

	@Override
	public boolean remove(File theFile) {
		return false;
	}

	@Override
	public void show(String current) {
		String path = current + name;
		System.out.println(path);

	}

	@Override
	public String name() {
		return name;
	}

}
