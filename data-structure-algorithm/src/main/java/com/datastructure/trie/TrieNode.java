package com.datastructure.trie;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
	public TrieNode parent;
	public Byte key;
	public boolean finished;
	public Map<Byte, TrieNode> trieMap;
	
	public TrieNode() {
		this(null, null);
	}

	public TrieNode(Byte theKey, TrieNode node) {
		trieMap = new HashMap<>();
		parent = node;
		key = theKey;
		finished = false;
	}

	public TrieNode insert(byte aChar) {
		TrieNode node;
		if ((node = trieMap.get(aChar)) == null) {
			node = new TrieNode(aChar, this);
			trieMap.put(aChar, node);
		}

		return node;
	}
}
