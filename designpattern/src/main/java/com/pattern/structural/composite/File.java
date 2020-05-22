package com.pattern.structural.composite;

public interface File {
	void add(File theFile);
	boolean remove(File theFile);
	void show(String current);
	String name();

}
