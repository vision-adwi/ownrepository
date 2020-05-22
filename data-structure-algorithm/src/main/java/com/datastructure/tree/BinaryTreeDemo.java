package com.datastructure.tree;

import com.datastructure.tree.common.SearchType;
import com.datastructure.tree.common.TraverseType;

public class BinaryTreeDemo {

	public static void main(String[] args) {
		BinaryTree<Integer> theTree = new BinaryTree<>(55);

		theTree.insert(32);
		theTree.insert(44);
		theTree.insert(78);
		theTree.insert(12);
		theTree.insert(29);
		theTree.insert(39);
		theTree.insert(49);

		theTree.traverse(TraverseType.IN_ORDER);
		System.out.println();
		System.out.println("Searched: " + theTree.search(29, SearchType.BFS));
		System.out.println("Depth of the tree: " + theTree.heightOfTheTree());
	}

}
