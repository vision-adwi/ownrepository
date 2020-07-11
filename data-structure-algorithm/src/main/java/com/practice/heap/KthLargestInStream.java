package com.practice.heap;

import java.util.PriorityQueue;
import java.util.Queue;
/*
Leetcode#703. Kth Largest Element in a Stream
Design a class to find the kth largest element in a stream. Note that it is the kth largest element in the sorted order, not the kth distinct element.
Your KthLargest class will have a constructor which accepts an integer k and an integer array nums, which contains initial elements from the stream. 
For each call to the method KthLargest.add, return the element representing the kth largest element in the stream.
*/
public class KthLargestInStream {
    Queue<Integer> elements = new PriorityQueue<Integer>();
    int k;

    public KthLargestInStream(int k, int[] nums) {
    	this.k = k;
    	for(int ele : nums) {
    		elements.offer(ele);
    		if(elements.size() > this.k)
    			elements.poll();
    	}

    }
    
    public int add(int val) {
    	if(elements.size() < this.k) {
    		elements.offer(val);
    	}
    	else if(val >= elements.peek()) {
    		elements.offer(val);
    		elements.poll();
    	}
    		
    	return elements.peek();
    }

}

