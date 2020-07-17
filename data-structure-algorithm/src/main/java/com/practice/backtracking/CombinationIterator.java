package com.practice.backtracking;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/*
Leetcode#1286. Iterator for Combination
Design an Iterator class, which has:

-A constructor that takes a string characters of sorted distinct lowercase English letters and a number combinationLength as arguments.
-A function next() that returns the next combination of length combinationLength in lexicographical order.
-A function hasNext() that returns True if and only if there exists a next combination.
*/
public class CombinationIterator {
	List<String> lists;
	Iterator<String> iterator;
    public CombinationIterator(String characters, int combinationLength) {
        lists = new ArrayList<>();
        combination(characters.toCharArray(), combinationLength, 0, new StringBuilder());
        iterator = lists.iterator(); 
    }
    
    public String next() {
        return iterator.next();
    }
    
    public boolean hasNext() {
        return iterator.hasNext();
    }
    
    private void combination(char[] chars, int combinationLength, int next, StringBuilder current) {
    	if(current.length() == combinationLength) {
    		lists.add(current.toString());
    	}
    	
    	for(int i = next; i < chars.length; i++) {
    		current.append(chars[i]); 
    		combination(chars, combinationLength, (i + 1),current);
    		current.setLength(current.length() - 1); 
    	}
    }

}
