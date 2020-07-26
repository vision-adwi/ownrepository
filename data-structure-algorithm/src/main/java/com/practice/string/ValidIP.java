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

		int index = 0;
		while (index < tokens.size()) {
			int octet = 0;
			String token = tokens.get(index++);
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
	
	private List<String> tokenizeIP(String s, char delim) {
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
	
	public static void main(String[] s) {
		ValidIP ip = new ValidIP();
		System.out.println(ip.validIPAddress("256.256.256.256"));
	}
}
