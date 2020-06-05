package com.datastructure.tree.fenvick;

public class FenwickTree {
	private int[] bit;
	
	public void create(int[] original) {
		bit = new int[original.length + 1];
		for(int i = 0; i < original.length; i++) {
			int value = original[i];
			for(int j = i + 1; j < bit.length;) {
				bit[j] = bit[j] + value;
				
				//next index
				int twosComplement = ~j + 1;
				int andOperation = twosComplement & j;
				j = j + andOperation;
			}
		}
	}
	
	public void update(int difference, int index) {
		for(int j = index + 1; j < bit.length;) {
			bit[j] = bit[j] + difference;
			
			//next index
			int twosComplement = ~j + 1;
			int andOperation = twosComplement & j;
			j = j + andOperation;
		}
	}
	
	public int prefixSum(int toIndex) {
		int sum = 0;
		for(int j = toIndex + 1; j > 0;) {
			sum = sum + bit[j];
			
			//Parent index
			int twosComplement = ~j + 1;
			int andOperation = twosComplement & j;
			j = j - andOperation;
		}
		
		return sum;
	}
	
	public static void main(String[] s) {
		int[] original = {3, 5, 2, 6, 4, -1, 9, 2, 6, 8, 11};
		FenwickTree fTree = new FenwickTree();
		fTree.create(original);
	}

}
