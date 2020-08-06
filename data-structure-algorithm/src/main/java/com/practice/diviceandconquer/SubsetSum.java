package com.practice.diviceandconquer;

public class SubsetSum {
	public static void main(String[] s) {
		int[] data = {7, 6, 9, 5, 19, 33, 104};
		
		SubsetSum subset = new SubsetSum();
		System.out.println("Is subset sum(105) - " + subset.isSubsetSum(data, 20));
	}
	private boolean subset(int[] set, int sum, int index, int check) {
		if(sum > check || index >= set.length)
			return false;
		
		if(sum == check)
			return true;

		if(subset(set, (sum + set[index]), index + 1, check)) {
			return true;
		}
		else {
			return subset(set, sum, index + 1, check);
		}
	}
	
	public boolean isSubsetSum(int[] set, int check) {
		return subset(set, 0, 0, check);
	}

}
