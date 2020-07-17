package com.practice.backtracking;
/*
Leetcode#1079. Letter Tile Possibilities
You have a set of tiles, where each tile has one letter tiles[i] printed on it.  
Return the number of possible non-empty sequences of letters you can make.
*/
public class LetterTile {
	public int numTilePossibilities(String tiles) {
		int[] frequency = new int[26];
		for(char ch : tiles.toCharArray()) {
			frequency[ch - 'A']++;
		}
		
		return possibilities(frequency);
    }
	
	private int possibilities(int[] frequency) {
		int count = 0;
		for(int i = 0; i < 26; i++) {
			if(frequency[i] == 0)
				continue;
			
			count++;
			frequency[i]--;
			
			count = count + possibilities(frequency);
			frequency[i]++;
		}
		
		return count;	
	}
	
	public static void main(String[] s) {
		LetterTile tile = new LetterTile();
		System.out.println(tile.numTilePossibilities("AAABBC"));
	}

}
