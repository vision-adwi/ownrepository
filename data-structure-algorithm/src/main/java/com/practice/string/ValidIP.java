package com.practice.string;

import java.util.ArrayList;
import java.util.List;
//468. Validate IP Address
public class ValidIP {
	public String validIPAddress(String IP) {
		boolean ipV4 = false, ipV6 = false;
		List<String> tokens = tokenizeIP(IP, '.');
		if (tokens.size() == 4) {
			ipV4 = true;
		} else {
			tokens = tokenizeIP(IP, ':');
			if (tokens.size() == 8)
				ipV6 = true;
		}

		if (!ipV4 && !ipV6)
			return "Neither";

		for(String token : tokens) {
			int octet = 0;
			try {
				if (ipV4) {
					octet = Integer.parseInt(token);
					if(octet < 0 || octet > 0xFF || (token.startsWith("0") && token.length() > 1))
						throw new NumberFormatException();
				} else {
					octet = Integer.parseInt(token, 16);
					if(octet < 0 || octet > 0xFFFF || (octet == 0 && token.length() > 4))
						throw new NumberFormatException();
				}
			} catch (NumberFormatException e) {
				return "Neither";
			}
		}

		return ipV4 ? "IPv4" : "IPv6";
	}
	
	private List<String> tokenizeIP_(String s, char delim) {
		List<String> octets = new ArrayList<>();
		int j = 0, i = 0;
		for(; i < s.length(); i++) {
			if(s.charAt(i) == delim) {
				octets.add(s.substring(j, i));
				j = i + 1;
			}
		}
		if(j > 0 && j < s.length()) {
			octets.add(s.substring(j, i));
		}
		if(j == s.length()) {
			octets.add("invalid");
		}
		
		return octets;
	}
	
	private List<String> tokenizeIP(String s, char delim) {
		List<String> octets = new ArrayList<>();
		int j = 0, i = 0;
		while(j < s.length()) {
			if(s.charAt(j) == delim) {
				if(i == j) { //to check if there is no consecutive delim
					octets.add("Invalid");
					return octets;
				}				
				octets.add(s.substring(i, j));
				i = j + 1;
			}			
			j++;
		}
		
		if(i == s.length()) { //to check if last char is not a delim
			octets.add("invalid");
		}
		else {
			octets.add(s.substring(i, j));
		}
		
		return octets;
	}
	
	public static void main(String[] s) {
		ValidIP ip = new ValidIP();
		System.out.println(ip.validIPAddress("172.16.254.1"));
	}
}
