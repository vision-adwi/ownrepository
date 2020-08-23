package com.practice.diviceandconquer;
/*
Leetcode#887. Super Egg Drop
*/
public class EggDrop {
	public int superEggDrop_dp(int K, int N) {
		int[][] mem = new int[K + 1][N + 1];
		for(int j = 1; j <= N; j++)
			mem[1][j] = j;
		
		for(int i = 1; i <= K; i++)
			mem[i][1] = 1;
		
		for(int i = 2; i <= K; i++) {
			for(int j = 2; j <= N; j++) {
				int min = Integer.MAX_VALUE;
				for(int p = 1; p < j; p++) {
					int floorCount = Math.max(mem[i - 1][p - 1], mem[i][j - p]);
					min = Math.min(min, floorCount);
				}
				mem[i][j] = min + 1;
			}
		}
		
		return mem[K][N];
	}
	
    public int superEggDrop(int K, int N) {
        return dropEgg(K, N);
    }
    
	private int dropEgg(int eggs, int floors) {
		if (eggs == 1)
			return floors;

		if (floors == 0 || floors == 1)
			return floors;

		int min = Integer.MAX_VALUE;
		for (int i = 1; i <= floors; i++) {
			int o1 = dropEgg(eggs, floors - i);
			int o2 = dropEgg(eggs - 1, i - 1);

			min = Math.min(min, Math.max(o1, o2));
		}
		
		return min + 1;
	}

}
