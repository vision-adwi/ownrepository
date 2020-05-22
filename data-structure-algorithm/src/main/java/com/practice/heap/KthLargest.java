package com.practice.heap;

public class KthLargest {
    MaxHeap heap;
    int[] cache;
    int kTh;
    //int lastKthLargest;
    boolean started;

    public KthLargest(int k, int[] nums) {
        heap = new MaxHeap(1024 * 1024);
        kTh = k;
        cache = new int[k];
        initializeHeap(nums);
    }
    
    public int add(int val) {
        heap.insert(val);
        if(started && cache[kTh - 1] > val) {
        	return cache[kTh - 1];
        }
        started = true;
        for(int i = 0; i < kTh; i++) {
            cache[i] = heap.extract();
        }

        for(int num:cache) {
            heap.insert(num);
        }
        
        return cache[kTh - 1];
    }
    
    private void initializeHeap( int[] theNums) {
        for(int num:theNums) {
            heap.insert(num);
        }
    }
}


/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
