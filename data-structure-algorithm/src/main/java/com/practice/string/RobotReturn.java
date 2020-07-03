package com.practice.string;

//657. Robot Return to Origin

public class RobotReturn {
	public boolean judgeCircle(String moves) {
        int[] position = new int[2];
        for(char ch : moves.toCharArray()) {
            switch(ch) {
                case 'U' : {
                    position[0]++;
                    break; 
                }
                case 'D' : {
                    position[0]--;
                    break; 
                }
                case 'R' : {
                    position[1]++;
                    break;
                }
                case 'L' : {
                    position[1]--;
                }
                    
            }
        }
        
        return (position[0] == 0) && (position[1] == 0);        
    }
}
