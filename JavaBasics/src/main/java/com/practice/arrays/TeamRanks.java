package com.practice.arrays;

import java.util.ArrayList;
import java.util.List;
//#1366:Rank Teams by votes
public class TeamRanks {

	public static void main(String[] args) {
		String[] votes = {"ABCD"};
		int participants = votes[0].length();
		int[][] voteCounts = new int[participants][participants];
		char[] results = new char[participants];

		for(String vote:votes) {
			castVotes(vote, voteCounts);
		}
		
		List<Integer> allParticipants = new ArrayList<>();
		for(int i = 0; i < participants; i++)
			allParticipants.add(i);
		for(int positions = 0; positions < participants; positions++) {
			int max = 0;
			for(int row = 0; row < participants; row++) {
				if(voteCounts[row][positions] > max)
					max = voteCounts[row][positions];
			}
			
			List<Integer> rows = new ArrayList<>();
			for(int row = 0; row < participants; row++) {
				if(voteCounts[row][positions] == max)
					rows.add(row);
			}
			
			int resolveParticipantPosition = resolvePosition(voteCounts, rows, positions + 1);
			allParticipants.remove(resolveParticipantPosition);
			results[positions] = (char)(resolveParticipantPosition + 65);
		}
		

	}
	
	private static void castVotes(String vote, int[][] voteCounts) {
		for(int position = 0; position < vote.length(); position++) {
			char paticipant = vote.charAt(position);
			int pRow = paticipant - 65;
			voteCounts[pRow][position]++;
		}
	}
	
	private static int resolvePosition(int[][] voteCounts, List<Integer> rows, int position) {
		if (rows.size() == 1)
			return rows.get(0);
		if (position == voteCounts.length) {
			int min = Integer.MAX_VALUE;
			for (Integer row : rows) {
				min = Math.min(min, row);
			}
			return min;
		}

		int max = 0;
		for (Integer row : rows) {
			if (voteCounts[row][position] > max)
				max = voteCounts[row][position];
		}
		for (Integer row : rows) {
			if (voteCounts[row][position] != max)
				rows.remove(row);
		}

		return resolvePosition(voteCounts, rows, position + 1);

	}

}

