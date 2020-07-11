package com.practice.matrix;
/*
Leetcode#1337. The K Weakest Rows in a Matrix
Given a m * n matrix mat of ones (representing soldiers) and zeros (representing civilians), return the indexes of the k weakest rows in the 
matrix ordered from the weakest to the strongest.
A row i is weaker than row j, if the number of soldiers in row i is less than the number of soldiers in row j, 
or they have the same number of soldiers but i is less than j. Soldiers are always stand in the frontier of a row, that is, always ones may appear first and then zeros.
*/
import java.util.LinkedList;
import java.util.List;

public class WeakestRows {
	public int[] kWeakestRows(int[][] mat, int k) {
		List<Integer> list = new LinkedList<>();
		int[] soldiers = new int[mat.length];
		for(int i = 0; i < mat.length; i++) {
			int count = 0;
			for(int j = 0; j < mat[0].length; j++) {
				if(mat[i][j] == 1) {
					count++;
				}
			}
			soldiers[i] = count;
			
			int p = 0;
			while((p < list.size()) && (p <= k) && (soldiers[list.get(p)] <= soldiers[i]))
				p++;
			
			if(p < k)
				list.add(p, i); 
		}
		
		int[] result = new int[k];
		for(int x = 0; x < k; x++)
			result[x] = list.get(x);
		
		return result;

    }
	
	public static void main(String[] s) {
		WeakestRows weakest = new WeakestRows();
		int[][] mat = 
				{{1,1,0,0,0},
				 {1,1,1,1,0},
				 {1,0,0,0,0},
				 {1,1,0,0,0},
				 {1,1,1,1,1}};
		System.out.println(weakest.kWeakestRows(mat, 3));
	}

}
