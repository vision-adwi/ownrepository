package com.algorithm.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KnapsackAlgo {
	private static void solve(List<TreasureBox> theBoxes, int theCapacity) {
		Collections.sort(theBoxes, (p1, p2) -> p2.density().compareTo(p1.density()));
		
		int remaining = theCapacity;
		for (TreasureBox box : theBoxes) {
			if (remaining <= 0)
				break;

			int boxWeight = box.getWeight();
			if (remaining >= boxWeight) {
				remaining = remaining - boxWeight;
				System.out.println("1 Unit of " + boxWeight + " with value " + box.getValue());
			} else {
				float fraction = (float) remaining / boxWeight;
				remaining = 0;
				System.out.println(fraction + " Unit of " + boxWeight + " with value " + box.getValue());
			}
		}
	}
	public static void main(String[] s) {
		int sackCapacity = 50;
		List<TreasureBox> boxes = new ArrayList<>();
		boxes.add(new TreasureBox(20, 100));
		boxes.add(new TreasureBox(30, 120));
		boxes.add(new TreasureBox(10, 60));

		solve(boxes, sackCapacity);
	}
	
	private static class TreasureBox {
		int weight;
		int value;
		
		public TreasureBox(int theWeight, int theValue) {
			this.weight = theWeight;
			this.value = theValue;
		}
		
		public int getValue() {
			return this.value;
		}
		
		public int getWeight() {
			return this.weight;
		}
		
		public Double density() {
			return (double)value / (double)weight;
		}
	}
}
