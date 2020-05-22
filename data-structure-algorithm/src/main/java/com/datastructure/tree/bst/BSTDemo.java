package com.datastructure.tree.bst;

import com.datastructure.tree.common.TraverseType;

public class BSTDemo {

	public static void main(String[] args) {
		BinarySearchTree<Integer> theTree = new BinarySearchTree<>(55);
		
		theTree.insert(40);
		theTree.insert(35);
		theTree.insert(25);
		theTree.insert(15);
		theTree.insert(10);
		theTree.insert(50);
		theTree.insert(60);
		theTree.insert(70);
		
		theTree.traverse(TraverseType.IN_ORDER);

		System.out.println();
		System.out.println("Search(12) :" + theTree.search(12));
		System.out.println("Search(15) :" + theTree.search(15));
		System.out.println("Difference :" + theTree.diff());
	}

}
