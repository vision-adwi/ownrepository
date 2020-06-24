package com.practice.backtracking;

import java.util.ArrayList;
import java.util.List;

public class LetterTile {
	public int numTilePossibilities(String tiles) {
		possibilities(0, tiles.getBytes(), new ArrayList<>(), 0);
        return -1;
    }
	
	private void possibilities(int count, byte[] b, List<Byte> curr, int index) {
		if(index == b.length) {
			StringBuilder s = new StringBuilder("");
			for(byte by : curr) {
				s.append((char)by);
			}
			System.out.println(s);
			++count;
			return;
		}
		
		curr.add(b[index]);
		possibilities(count, b, curr, index + 1);
		curr.remove(curr.size() - 1);
		possibilities(count, b, curr, index + 1);
		
	}
	
	public static void main(String[] s) {
		LetterTile tile = new LetterTile();
		tile.numTilePossibilities("AAB");
	}

}
