package com.practice.array;

import java.util.ArrayList;
import java.util.List;

public class RemoveSubfolders {
	public List<String> removeSubfolders(String[] folder) {
		char[][] folders = new char[folder.length][];
		for(int i = 0; i < folder.length; i++) {
			folders[i] = folder[i].toCharArray();
		}
		
		List<String> result = new ArrayList<>();
        for(int i = 0; i < folder.length; i++) {
            for(int j = 0; j < folder.length; j++) {
                if(i != j) {
                    if(folders[i].length > folders[j].length) {
                    	//folder[i].startsWith(folder[j] + "/"));

                    	break;
                    }
                }
                if(j == folder.length - 1)
                    result.add(folder[i]);
            }
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
