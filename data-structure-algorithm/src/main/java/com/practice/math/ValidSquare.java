package com.practice.math;

import java.util.Arrays;

public class ValidSquare {
	
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[][] p = {p1, p2, p3, p4};
        Arrays.sort(p, (e1, e2) -> (e1[0] == e2[0] ? e1[1] - e2[1] : e1[0] - e2[0]));

        return dist(p[0], p[1]) != 0 && dist(p[0], p[1]) == dist(p[1], p[3]) && dist(p[1], p[3]) == dist(p[3], p[2]) && dist(p[3], p[2]) == dist(p[2], p[0])   
        		&& dist(p[0],p[3])==dist(p[1],p[2]);
    }
    
    private int dist(int[]o1, int[]o2) {
    	return ((o1[0] - o2[0]) * (o1[0] - o2[0]) + (o1[1] - o2[1]) * (o1[1] - o2[1])); //(x*x) + (y*y)
    }

}
