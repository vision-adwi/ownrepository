package com.thoughtwork.actors;

public class Bank {
	int treasury;
	
	private Bank() {
		treasury = 5000;
	}
	
	private static class Holder {
		private static final Bank INSTANCE = new Bank();
	}
	
	public static Bank getInstance() {
		return Holder.INSTANCE;
	}

	public void transact(Player player, int amount) {
		synchronized(this) {
			int old_treasury = treasury;
			int old_player_amt = player.getAmount();
			try {
				treasury = treasury - amount;
				player.setAmount(old_player_amt + amount);
			}
			catch(Exception e) {
				treasury = old_treasury;
				player.setAmount(old_player_amt);
			}
		}
	}
	
	public int getTreasury() {
		return treasury;
	}
}
