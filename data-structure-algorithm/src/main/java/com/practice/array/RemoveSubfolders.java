package com.practice.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveSubfolders {
	public List<String> removeSubfolders(String[] folder) {
		List<String> result = new ArrayList<>();
		Arrays.sort(folder);
		for(int i = folder.length - 1; i > 0; i--) {
			if(!folder[i].startsWith(folder[i-1])) {
				result.add(folder[i]);
			}
			result.add(folder[0]);
		}
		
		return result;
	}
	
	public static void main(String[] s) {
		String[] input = {"/c/d","/a","/a/b","/c/d/e","/c/f"};
		RemoveSubfolders folders = new RemoveSubfolders();
		
		//Arrays.sort(input);
		System.out.println(input);
		
	}

}
