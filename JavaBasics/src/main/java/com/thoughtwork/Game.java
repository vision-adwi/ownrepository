package com.thoughtwork;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.thoughtwork.actors.Bank;
import com.thoughtwork.actors.Board;
import com.thoughtwork.actors.Dice;
import com.thoughtwork.actors.Player;

public class Game {
	int playerCount;
	Iterator<Integer> diceRoll;
	List<Player> players;
	Game(int playerCount, int[] diceOutput, char[] layout) {
		this.playerCount = playerCount;
		
		players = new ArrayList<>();
		Board board = new Board(layout);
		for(int i = 0; i < playerCount; i++) {
			players.add(new Player((i + 1), 1000, board)); //hardcoded initial amount
		}
		
		diceRoll = new Dice(diceOutput).iterator();		
	}
	
	public void play() {
		int i = 0;
		
		while(diceRoll.hasNext()) {
			int point = diceRoll.next();
			
			Player player = players.get((i++) % playerCount);
			player.play(point);
		}
	}
	
	public void showResult() {
		for(Player player : players) {
			//Player-1 has total money 1100 and asset of amount : 500
			System.out.print("Player-" + player.getId());
			System.out.print(" has total money " + player.getAmount());
			
			int asset = 0;
			for(Integer cell : player.hotels.keySet()) {
				asset += player.hotels.get(cell).getValue();
			}
			System.out.println(" and asset of amount : " + asset);
		}
		
		System.out.println("Balance at Bank : " + Bank.getInstance().getTreasury());
	}
	
	public static void main(String[] s) {
		int players = 3;
		int[] diceOutput = {2,2,1, 4,2,3, 4,1,3, 2,2,7, 4,7,2, 4,4,2, 2,2,2};//{2,2,1, 4,4,2, 4,4,2, 2,2,1, 4,4,2, 4,4,2, 2,2,1};//
		char[] layout = {'J', 'H', 'L', 'H', 'E', 'L', 'H', 'L', 'H', 'J'};
		
		Game game = new Game(players, diceOutput, layout);
		game.play();
		game.showResult();
		
	}
}