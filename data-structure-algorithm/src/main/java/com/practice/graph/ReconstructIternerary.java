package com.practice.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//Leetcode#332. Reconstruct Itinerary
public class ReconstructIternerary {
    public List<String> findItinerary(List<List<String>> tickets) {
    	int ticketCount = tickets.size();
    	Map<String, List<String>> ticketMap = new HashMap<>();
    	for(List<String> ticket : tickets) {
    		ticketMap.putIfAbsent(ticket.get(0), new ArrayList<>());
    		ticketMap.get(ticket.get(0)).add(ticket.get(1));
    	}
    	
        for(String key : ticketMap.keySet()) {
    		Collections.sort(ticketMap.get(key));
    	}
    	
    	List<List<String>> result = new ArrayList<>();
    	List<String> path = new ArrayList<>();
    	path.add("JFK");
    	exploreItenarary(ticketMap, path, result, ticketCount);
    	
        return result.size() > 0 ? result.get(0) : new ArrayList<>();
    }
    
	private List<List<String>> exploreItenarary(Map<String, List<String>> ticketMap, List<String> itenarary, List<List<String>> result, int ticketCount) {
		if (itenarary.size() == ticketCount + 1) {
			result.add(new ArrayList<>(itenarary));
			return result;
		}

		List<String> destinations = ticketMap.get(itenarary.get(itenarary.size() - 1));
		if (destinations == null) {
			return result;
		}

		for (int i = 0; i < destinations.size(); i++) {
			itenarary.add(destinations.remove(i));
			exploreItenarary(ticketMap, itenarary, result, ticketCount);
			if (result.size() > 0)
				return result;
			destinations.add(i, itenarary.remove(itenarary.size() - 1));
		}

		return result;

	}
    
    public static void main(String[] s) {
    	
    	List<List<String>> tickets = new ArrayList<>();
    	tickets.add(new ArrayList<>(Arrays.asList("JFK","SFO")));
    	tickets.add(new ArrayList<>(Arrays.asList("JFK","ATL")));
    	tickets.add(new ArrayList<>(Arrays.asList("SFO","ATL")));
    	tickets.add(new ArrayList<>(Arrays.asList("ATL","JFK")));
    	tickets.add(new ArrayList<>(Arrays.asList("ATL","SFO")));
    	
    	
    	/*List<String> ticket = new ArrayList<>();
    	ticket.add("JFK");
    	ticket.add("SFO");
    	tickets.add(ticket);
    	
    	ticket = new ArrayList<>();
    	ticket.add("JFK");
    	ticket.add("ATL");
    	tickets.add(ticket);
    	
    	ticket = new ArrayList<>();
    	ticket.add("SFO");
    	ticket.add("ATL");
    	tickets.add(ticket);
    	
    	ticket = new ArrayList<>();
    	ticket.add("ATL");
    	ticket.add("JFK");
    	tickets.add(ticket);
    	
    	ticket = new ArrayList<>();
    	ticket.add("ATL");
    	ticket.add("SFO");
    	tickets.add(ticket);*/
    	
    	/*tickets.add(new ArrayList<>(Arrays.asList("EZE","AXA")));
    	tickets.add(new ArrayList<>(Arrays.asList("TIA","ANU")));
    	tickets.add(new ArrayList<>(Arrays.asList("ANU","JFK")));
    	tickets.add(new ArrayList<>(Arrays.asList("JFK","ANU")));
    	tickets.add(new ArrayList<>(Arrays.asList("ANU","EZE")));
    	tickets.add(new ArrayList<>(Arrays.asList("TIA","ANU")));
    	tickets.add(new ArrayList<>(Arrays.asList("AXA","TIA")));
    	tickets.add(new ArrayList<>(Arrays.asList("TIA","JFK")));
    	tickets.add(new ArrayList<>(Arrays.asList("ANU","TIA")));
    	tickets.add(new ArrayList<>(Arrays.asList("JFK","TIA")));*/
    	ReconstructIternerary reconstruct = new ReconstructIternerary();
    	System.out.println(reconstruct.findItinerary(tickets));
    	
    	//[["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
    	//[["EZE","AXA"],["TIA","ANU"],["ANU","JFK"],["JFK","ANU"],["ANU","EZE"],["TIA","ANU"],["AXA","TIA"],["TIA","JFK"],["ANU","TIA"],["JFK","TIA"]]
    	//[["EZE","TIA"],["EZE","HBA"],["AXA","TIA"],["JFK","AXA"],["ANU","JFK"],["ADL","ANU"],["TIA","AUA"],["ANU","AUA"],["ADL","EZE"],["ADL","EZE"],
    	//["EZE","ADL"],["AXA","EZE"],["AUA","AXA"],["JFK","AXA"],["AXA","AUA"],["AUA","ADL"],["ANU","EZE"],["TIA","ADL"],["EZE","ANU"],["AUA","ANU"]]
    }
    
}
