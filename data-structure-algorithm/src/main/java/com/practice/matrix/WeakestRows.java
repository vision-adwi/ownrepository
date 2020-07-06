package com.practice.matrix;

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
			while((p < list.size()) && (soldiers[list.get(p)] < soldiers[i]))
				p++;
			
			if(p < k)
				list.add(p, i);
		}
		
		int[] result = new int[k];
		for(Integer )

    }

}
