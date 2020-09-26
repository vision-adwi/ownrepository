package com.practice.matrix.dfs;

/*
#733. Flood Fill
An image is represented by a 2-D array of integers, each integer representing the pixel value of the image (from 0 to 65535).
Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill, and a pixel value newColor, "flood fill" the image.
To perform a "flood fill", consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, 
plus any pixels connected 4-directionally to those pixels (also with the same color as the starting pixel), and so on. 
Replace the color of all of the aforementioned pixels with the newColor.

At the end, return the modified image.
*/		
public class FloodFill {
	public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		int color = image[sr][sc];
		if(color != newColor) {
			floodFillColor(image, sr, sc, color, newColor);
		}
		
		return image;		
    }

	private static void floodFillColor(int[][] image, int i, int j, int color, int newColor) {
		if (i < 0 || j < 0 || i >= image.length || j >= image[0].length || image[i][j] != color) {
			return;
		}

		image[i][j] = newColor; 

		floodFillColor(image, i - 1, j, color, newColor);
		floodFillColor(image, i + 1, j, color, newColor);
		floodFillColor(image, i, j - 1, color, newColor);
		floodFillColor(image, i, j + 1, color, newColor);
		
		return;
	}
	
	public static void main(String[] args) {
		int[][] input = {{0, 0, 0},{0, 1, 1}};
				/*{ 	{ 1, 1, 0, 1, 0 }, 
							{ 1, 1, 0, 1, 0 }, 
							{ 1, 1, 0, 0, 0 }, 
							{ 0, 0, 0, 0, 0 }, 
							{ 0, 0, 1, 0, 1 },
							{ 1, 1, 1, 0, 0 } };*/

		print(floodFill(input, 1, 1, 1));
	}
	
	private static void print(int[][] items) {
		for(int i = 0; i < items.length; i++) {
			for(int j = 0; j < items[0].length; j++) {
				System.out.print(items[i][j] + " ");
			}
			System.out.println();
		}
	}

}
