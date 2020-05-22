package com.algorithm.hashing;

public class Hashing {
	public static void main(String[] s) {
		char ch = 'c';
		//System.out.println(Integer.toBinaryString(ch));
		//System.out.println(Integer.toBinaryString(h0(ch,0)));
		
	}
	public static int h0(byte ch, int limit) {
		int x = ch << 2;
		
		return (x % limit);
	}
	
	public static int h1(byte ch, int limit) {
		int x = ch >> 2;
		
		return (x % limit);
	}
	
	public static int h2(byte ch, int limit) {
		long x = ch * ch;
		
		return (int)(x % limit);
	}
	
	public static int h3(byte ch, int limit) {
		Integer i = (int)ch;
		
		return i.hashCode() % limit;
	}

}
