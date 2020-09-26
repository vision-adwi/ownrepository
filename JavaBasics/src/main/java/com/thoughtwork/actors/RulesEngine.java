package com.thoughtwork.actors;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RulesEngine {
	Map<Integer, Player> occupancy = new HashMap<>();
	private final int JAIL_FINE = -100;
	private final int LOTTERY_BONUS = 150;
	
	private RulesEngine() {
		
	}
	
	private static class Holder {
		private static final RulesEngine INSTANCE = new RulesEngine();
	}
	
	public static RulesEngine getInstance() {
		return Holder.INSTANCE;
	}

	public void apply(Player player, char cell, int boardPosition) {
		switch(cell) {
		case 'J':
			Bank.getInstance().transact(player, JAIL_FINE);
			break;
		case 'L':
			Bank.getInstance().transact(player, LOTTERY_BONUS);
			break;
		case 'H':
			hotelService(player, boardPosition);
		}
		
	}
	
	private void hotelService(Player player, int boardPosition) {
		Player owner = occupancy.get(boardPosition);
		
		if(owner == null) {
			if(player.getAmount() >= Hotel.SILVER.getValue()) {
				int cost = Hotel.SILVER.getValue();
				Bank.getInstance().transact(player, -cost);
				player.hotels.putIfAbsent(boardPosition, Hotel.SILVER);
				occupancy.put(boardPosition, player);
			}
		}
		else if (owner == player) { // self
			Hotel hotel = player.hotels.get(boardPosition);

			Hotel upgrade = Hotel.SILVER;
			switch (hotel) {
			case SILVER:
				upgrade = Hotel.GOLD;
				break;
			case GOLD:
				upgrade = Hotel.PLATINUM;
			}
			
			int cost = upgrade.getValue() - hotel.getValue();
			Bank.getInstance().transact(player, -cost);
			player.hotels.put(boardPosition, upgrade);
		}
		else {
			int rent = owner.hotels.get(boardPosition).getRent();
			//pay rent
			owner.transact(player, rent);
			
		}
		/*
		Hotel hotel = player.getAccomodation();
		
		Hotel upgrade = Hotel.SILVER;
		if(hotel != null) {//Go for upgrade
			switch (hotel) {
			case SILVER:
				upgrade = Hotel.GOLD;
				break;
			case GOLD:
				upgrade = Hotel.PLATINUM;
			}
		}
		
		player.setAccomodation(upgrade);
		if(hotel != Hotel.PLATINUM)
			availability(player);
		*/
	}
	
	private void availability(Player player) {
		/*Player currentOwner = occupancy.get(player.getAccomodation());
		if(currentOwner == null) {
			int cost = player.getAccomodation().getValue();
			if(player.getAccomodation() != Hotel.SILVER) {
				cost = cost - player.getAccomodation().getValue();
			}
			//buy it
			if(cost < player.getAmount()) {
				Bank.getInstance().transact(player, -cost);
				player.setOwnership(player.getAccomodation());
				occupancy.put(player.getAccomodation(), player);
			}
		}
		else {
			//pay rent
			currentOwner.transact(player, player.getAccomodation().getRent());
		}*/
	}
}
