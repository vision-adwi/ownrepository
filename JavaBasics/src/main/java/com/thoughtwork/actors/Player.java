package com.thoughtwork.actors;

import java.util.HashMap;
import java.util.Map;

public class Player {
	int id;
	int amount;
	int boardPosition;
	int asset;
	Board board;
	Hotel accomodation;
	Hotel owner;
	
	public Map<Integer, Hotel> hotels;
	
	public Player(int theId, int theAmt, Board theBoard) {
		id = theId;
		amount = theAmt;
		asset = 0;
		boardPosition = -1;
		board = theBoard;
		hotels = new HashMap<>();
	}
	
	public void play(int point) {
		boardPosition = (boardPosition + point) % board.size();
		
		char cell = board.getCell(boardPosition);
		RulesEngine.getInstance().apply(this, cell, boardPosition);
	}

	public Integer getId() {
		return id;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public void setAmount(int theAmount) {
		amount = theAmount;
	}
	
	public Hotel getAccomodation() {
		return accomodation;
	}
	
	public void setAccomodation(Hotel hotel) {
		accomodation = hotel;
	}
	
	public void setOwnership(Hotel hotel) {
		owner = hotel;
	}
	
	public Hotel getOwnership() {
		return owner;
	}
	
	public void transact(Player from, int rent) {
		amount = amount + rent;
		from.setAmount(from.getAmount() - rent);
	}
}
