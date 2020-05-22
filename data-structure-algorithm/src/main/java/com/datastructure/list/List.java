package com.datastructure.list;

public interface List {
	void insert(String value);
	void insert(String value, int position);
	void delete(int position);
	void traverse();
	int search(String value);
	void kill();
	boolean exist();

}
