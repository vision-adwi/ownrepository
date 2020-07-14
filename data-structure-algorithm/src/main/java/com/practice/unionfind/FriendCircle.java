package com.practice.unionfind;
/*
Leetcode#547. Friend Circles
There are N students in a class. Some of them are friends, while some are not. Their friendship is transitive in nature. 
For example, if A is a direct friend of B, and B is a direct friend of C, then A is an indirect friend of C. And we defined 
a friend circle is a group of students who are direct or indirect friends.

Given a N*N matrix M representing the friend relationship between students in the class. If M[i][j] = 1, then the ith and 
jth students are direct friends with each other, otherwise not. And you have to output the total number of friend circles among all the students.
*/
public class FriendCircle {
	public int findCircleNum(int[][] M) {
		UnionFind unionFind = new UnionFind(M.length);
        for(int row = 0; row < M.length; row++) {
        	for(int column = 0; column < M[0].length; column++) {
        		if(M[row][column] == 1) {
        			DisjointSet from = unionFind.find(row);
        			DisjointSet to = unionFind.find(column);
        			unionFind.union(from, to);
        		}
        		
        	}
        }
        
        return unionFind.size();
    }
	
	public static void main(String[] s) {
	
			int[][] M = {{1,1,0,0,0,0,0,1,0,0,0,0,0,0,0},
			 {1,1,0,0,0,0,0,0,0,0,0,0,0,0,0},
			 {0,0,1,0,0,0,0,0,0,0,0,0,0,0,0},
			 {0,0,0,1,0,1,1,0,0,0,0,0,0,0,0},
			 {0,0,0,0,1,0,0,0,0,1,1,0,0,0,0},
			 {0,0,0,1,0,1,0,0,0,0,1,0,0,0,0},
			 {0,0,0,1,0,0,1,0,1,0,0,0,0,1,0},
			 {1,0,0,0,0,0,0,1,1,0,0,0,0,0,0},
			 {0,0,0,0,0,0,1,1,1,0,0,0,0,1,0},
			 {0,0,0,0,1,0,0,0,0,1,0,1,0,0,1},
			 {0,0,0,0,1,1,0,0,0,0,1,1,0,0,0},
			 {0,0,0,0,0,0,0,0,0,1,1,1,0,0,0},
			 {0,0,0,0,0,0,0,0,0,0,0,0,1,0,0},
			 {0,0,0,0,0,0,1,0,1,0,0,0,0,1,0},
			 {0,0,0,0,0,0,0,0,0,1,0,0,0,0,1}};
			
			FriendCircle circle = new FriendCircle();
			
			System.out.println(circle.findCircleNum(M));
		
	 }

}
