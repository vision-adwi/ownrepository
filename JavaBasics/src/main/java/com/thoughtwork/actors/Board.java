package com.thoughtwork.actors;

public class Board {
	char[] cells;
	public Board(char[] theCells) {
		this.cells = theCells;
	}

	public char getCell(int index) {
		return cells[index];
	}
	
	public int size() {
		return cells.length;
	}
}
