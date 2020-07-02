package com.practice.string;
/*
Leetcode#383. Ransom Note
Given an arbitrary ransom note string and another string containing letters from all the magazines, 
write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.

Each letter in the magazine string can only be used once in your ransom note. 
*/
public class RansomNote {
	public boolean canConstruct(String ransomNote, String magazine) {
        char[] noteChars = ransomNote.toCharArray();
        char[] magChars = magazine.toCharArray();
        
        for(int i = 0; i < noteChars.length; i++) {
            boolean flag = false;
            for(int j = 0; j < magChars.length; j++) {
                if(noteChars[i] == magChars[j]) {
                    magChars[j] = ' ';
                    flag = true;
                    break;
                }
            }
            if(!flag)
                return false;
        }
        
        return true;
    }
	
	public static void main(String[] s) {
		RansomNote note = new RansomNote();
		System.out.println(note.canConstruct("a", "b"));
	}
}
