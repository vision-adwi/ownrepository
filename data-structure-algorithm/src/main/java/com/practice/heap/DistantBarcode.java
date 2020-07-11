package com.practice.heap;

public class DistantBarcode {
	public int[] rearrangeBarcodes(int[] barcodes) {
		int j;
		for(int i = 1; i < barcodes.length; i++) {
			j = i;
			if(barcodes[i] == barcodes[i - 1]) {
				while(barcodes[i] == barcodes[j])
					j++;
				
				int tmp = barcodes[j];
				barcodes[j] = barcodes[i];
				barcodes[i] = tmp;
			}
			
		}
        
		return barcodes;
    }
}
