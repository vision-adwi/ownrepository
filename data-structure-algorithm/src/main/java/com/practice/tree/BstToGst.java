package com.practice.tree;
//#1038 leetcode
public class BstToGst {

	public static void main(String[] args) {
		BST bst = new BST();
		

	}
	
	private void insertion(BST bst) {
		bst.insert(4);
		bst.insert(1);
		bst.insert(6);
		bst.insert(0);
		bst.insert(2);
		bst.insert(5);
		bst.insert(7);
		
	}
	
	private int gstTraversal(TreeNode theNode, int value) {
		if(theNode == null)
			return value;
		
		int newRightValue = gstTraversal(theNode.getRight(), value);
		theNode.setValue(theNode.getValue() + newRightValue);
		
		int newLeftValue = gstTraversal(theNode.getLeft(), theNode.getValue());

		return theNode.getValue() + newLeftValue;
	}

}
