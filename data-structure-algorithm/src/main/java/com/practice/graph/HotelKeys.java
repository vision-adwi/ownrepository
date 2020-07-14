package com.practice.graph;

import java.util.List;
/*
Leetcode#841. Keys and Rooms
There are N rooms and you start in room 0.  Each room has a distinct number in 0, 1, 2, ..., N-1, and each room may have some keys to access the next room. 
Formally, each room i has a list of keys rooms[i], and each key rooms[i][j] is an integer in [0, 1, ..., N-1] where N = rooms.length.  A key rooms[i][j] = v opens the room with number v.
Initially, all the rooms start locked (except for room 0). 
You can walk back and forth between rooms freely.
Return true if and only if you can enter every room.
*/
public class HotelKeys {
	public boolean canVisitAllRooms(List<List<Integer>> rooms) {
		boolean[] found = new boolean[rooms.size()];
		dfs(rooms, 0, found);
        for(boolean isFound : found) {
        	if(!isFound)
        		return false;
        }
        return true;
    }
	
	private void dfs(List<List<Integer>> rooms, int index, boolean[] found) {
		found[index] = true;
		List<Integer> room = rooms.get(index);
		
		for (int i = 0; i < room.size(); i++) {
			Integer key = room.get(i);
			if (!found[key]) {
				dfs(rooms, key, found);
			}
		}
	}

}
