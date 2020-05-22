package com.practice.heap;

import java.util.Scanner;

public class Innings {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in); 
		
	    int total = in.nextInt();
	    int[] innings = new int[total];
	    for(int i = 0; i < total; i++)
	    {
	        innings[i] = in.nextInt();
	    }
	    
	    sort(innings, 0, innings.length - 1);
	    
	    for(int i = 0; i < total; i++)
	    {
	    	System.out.println(innings[i]);
		}

	    int Qlines = in.nextInt();
	    int[] answer = new int[Qlines];
	    for(int i = 0; i < Qlines; i++)
	    {
	    	int tt = in.nextInt();
	    	String ls = in.next();
	    	if(ls.equalsIgnoreCase("S")) {
	    		answer[i] = innings[(tt - 1)];
	    	}
	    	else if(ls.equalsIgnoreCase("L")) {
	    		answer[i] = innings[innings.length - tt];
	    	}
		}
	    for(int i = 0; i < Qlines; i++)
	    {
	    	System.out.println(answer[i]);
		}

	    in.close();

	}
	
	private static void sort(int[] data, int start, int last) {
		if (start < last) {
			int i = start - 1;
			int pivot = data[last];

			int tmp;
			for (int j = start; j <= last; j++) {
				if (data[j] <= pivot) {
					tmp = data[++i];
					data[i] = data[j];
					data[j] = tmp;
				}
			}

			sort(data, start, (i - 1));
			sort(data, (i + 1), last);
		}
	}
	

}
