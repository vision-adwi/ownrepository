package com.datastructure.trie;

public class Trie {
	TrieNode root;

	public void insert(String vocab) {
		if (root == null) {
			root = new TrieNode();
		}

		TrieNode current = root;
		for (byte aChar : vocab.getBytes()) {
			current = current.insert(aChar);
		}

		if (!current.finished) {
			current.finished = true;
		}
	}
	
	public boolean search(String vocab) {
		TrieNode found = findLast(vocab);
		if (found != null) {
			return found.finished;
		}

		return false;
	}
	
	
	public boolean delete(String vocab) {
		TrieNode found = findLast(vocab);
		if (found != null && found.finished) {
			deletePredecessors(found);
			return true;
		}
		
		return false;
	}
	
	private TrieNode findLast(String vocab) {
		if (root == null) {
			return null;
		}

		TrieNode current = root;
		for (byte aChar : vocab.getBytes()) {
			current = current.trieMap.get(aChar);
			if (current == null) {
				return null;
			}
		}

		return current;
	}
	
	private void deletePredecessors(TrieNode node) {
		node.finished = false;
		
		while (!node.finished && node.trieMap.isEmpty()) {
			Byte theKey = node.key;
			node = node.parent;
			if (node == null) {
				root = null;
				break;
			}
			else {
				node.trieMap.remove(theKey);
			}
		}
	}
}
