package com.practice.diviceandconquer;

public class DivisorGame {
    public boolean divisorGame(int N) {
        return nextMove(N, 0);
    }
    
    private boolean nextMove(int N, int moveCount) {
    	if(N == 1) {
    		if((moveCount % 2) == 0)
    			return false;
    		else
    			return true;
    	}
    	
    	for(int i = 1; i < N; i++) {
    		if((N % i) == 0) {
    			if(!nextMove(N - i, moveCount + 1)) {
    				return false;
    			}
    		}
    	}
    	
    	return true;
    }

}
