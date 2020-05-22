package com.datastructure.trie;

public class TrieDemo {

	public static void main(String[] args) {
		Trie theTrie = new Trie();
		
		theTrie.insert("thermal");
		//theTrie.insert("the");
		//theTrie.insert("this");
		//theTrie.insert("thick");
		
		System.out.println("Search: thermal - " + theTrie.search("thermal"));
		System.out.println("Search: the - " + theTrie.search("the"));
		System.out.println("Search: this - " + theTrie.search("this"));
		System.out.println("Search: thick - " + theTrie.search("thick"));
		System.out.println("Search: thic - " + theTrie.search("thic"));
		System.out.println("Search: thicks - " + theTrie.search("thicks"));
		System.out.println();
		
		theTrie.delete("thermal");
		
		System.out.println("Search: thermal - " + theTrie.search("thermal"));
		System.out.println("Search: the - " + theTrie.search("the"));
		System.out.println("Search: this - " + theTrie.search("this"));
		System.out.println("Search: thick - " + theTrie.search("thick"));
		System.out.println("Search: thic - " + theTrie.search("thic"));
		System.out.println("Search: thicks - " + theTrie.search("thicks"));

	}

}
