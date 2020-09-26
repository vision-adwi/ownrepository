package com.practice.linkedlist;

import java.util.HashMap;
import java.util.Map;

import com.practice.util.DLLNode;
/*
Leetcode#146. LRU Cache
*/
public class LRUCache {
	DLLNode front = null;
	DLLNode rear = null;
	Map<Integer, DLLNode> cache;

	int size;
	int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.size = 0;
    }
    
    public int get(int key) {
    	DLLNode node = cache.get(key);
    	if(node != null) {
			if (node != front) {
				node.previous.next = node.next;
				if(node == rear) {
					rear = node.previous;
				}
				else {
					node.next.previous = node.previous;
				}

				front.previous = node;
				node.previous = null;
				node.next = front;
				front = node;
			}

    		return node.val;
    	}
    	else {
    		return -1;
    	}      
    }
    
	public void put(int key, int value) {
		if(get(key) != -1) {
			front.val = value;
			return;
		}
		if (size >= capacity) {
			cache.remove(rear.key);
			rear = rear.previous;
			if(rear == null) { //If the capacity of cache is 1
				front = null;
			}
			else {
				rear.next = null;
			}

			size--;
		}
		
		DLLNode node = new DLLNode(key, value, front, null);
		if(front == null) {
			rear = node;
		}
		else {
			front.previous = node;
		}		
		front = node;

		cache.put(key, node);
		size++;
	}
	
	public static void main(String[] s) {
		LRUCache cache = new LRUCache(3);
		cache.put(1, 1);
		cache.put(2, 2);
		cache.put(3, 3);
		cache.put(4, 4);
		System.out.println(cache.get(4));
		System.out.println(cache.get(3));
		System.out.println(cache.get(2));
		System.out.println(cache.get(1));
		cache.put(5, 5);
		System.out.println(cache.get(2));
		/*System.out.println(cache.get(1));
		cache.put(1, 5);
		cache.put(1, 2);
		System.out.println(cache.get(1));
		System.out.println(cache.get(2));*/
	}
}


