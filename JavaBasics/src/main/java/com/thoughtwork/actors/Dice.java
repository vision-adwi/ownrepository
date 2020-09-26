package com.thoughtwork.actors;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Dice {
	final List<Integer> dice; 
	public Dice(int[] output) {
		dice = IntStream.of(output).boxed()
				.collect(Collectors.toList());		
	}

	public Iterator<Integer> iterator() {
		return dice.iterator();
	}
}
