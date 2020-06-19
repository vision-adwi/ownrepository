package com.practice.queue;
/*
Leetcode#933. Number of Recent Calls
Write a class RecentCounter to count recent requests.
It has only one method: ping(int t), where t represents some time in milliseconds.
Return the number of pings that have been made from 3000 milliseconds ago until now.
Any ping with time in [t - 3000, t] will count, including the current ping.
It is guaranteed that every call to ping uses a strictly larger value of t than before.
*/
import java.util.ArrayDeque;
import java.util.Queue;

public class RecentCounter {
	Queue<Integer> queue;
    public RecentCounter() {
        queue = new ArrayDeque<>();
    }
    
    public int ping(int t) {
    	queue.add(t);
    	
    	while(!queue.isEmpty() && 
    			(t - queue.peek()) > 3000) {
    		queue.poll();
    	}
        
    	return queue.size();
    }

}
