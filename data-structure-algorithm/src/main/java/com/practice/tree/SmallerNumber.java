package com.practice.tree;
//#1365
public class SmallerNumber {
    public static void main(String[] s) {
    	int[] nums = {8,1,2,2,3};
        BST bst = new BST();
        for(int num:nums) {
        	System.out.print(num + " ");
            bst.insert(num);
        }
        System.out.println();
        for(int i = 0; i < nums.length; i++) {
        	System.out.print(bst.minCount(nums[i]) + " ");
        }
    }
}

class BST {
    private TreeNode root;
    
    public void insert(int theValue) {
        if(this.root == null) {
            this.root = new TreeNode(theValue, null);
        }
        else {
            insertInBST(this.root, theValue);
        }
    }
    
    private void insertInBST(TreeNode theNode, int theValue) {
        TreeNode next = null;
        if(theValue <= theNode.getValue()) {
            if((next = theNode.getLeft()) == null) {
                theNode.setLeft(new TreeNode(theValue, theNode));
                return;
            }
        }
        else {
            if((next = theNode.getRight()) == null) {
                theNode.setRight(new TreeNode(theValue, theNode));
                return;
            }
        }
        insertInBST(next, theValue);
    }
    
    public int minCount(int theValue) {
        return minCount(this.root, theValue, 0);
    }
    
    private int minCount(TreeNode theNode, int theValue, int count) {
		if(theNode != null) {
			count = minCount(theNode.getLeft(), theValue, count);
			if(theNode.getValue() < theValue) {
				count++;
				count = minCount(theNode.getRight(), theValue, count);
			}
		}
		return count;
	}
/*    
    public TreeNode search(int theValue) {
        if(this.root == null)
            return null;
        else
            return searchInBST(this.root, null, theValue, false);
    }
    
    private TreeNode searchInBST(TreeNode theNode, TreeNode parent, int theValue, boolean found) {
        if(theNode == null) {
            if(found)
                return parent;
            else
                return null;
        }

        int nodeValue = theNode.getValue();
        if(found && (nodeValue != theValue))
            return parent;
        
        if(nodeValue == theValue)
            found = true;
        
        TreeNode current = null;
        if(theValue <= nodeValue) {
            current = theNode.getLeft();
        }
        else {
            current = theNode.getRight();
        }
        
        return searchInBST(current, theNode, theValue, found);
    }
    */
}

class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;
    TreeNode parent;
    
    public TreeNode(int theValue, TreeNode theParent) {
        this.value = theValue;
        this.parent = theParent;
    }
    
    public TreeNode getLeft() {
        return this.left;
    }
    
    public void setLeft(TreeNode theNode) {
        this.left = theNode;
    }
    
     public TreeNode getRight() {
        return this.right;
    }
    
    public void setRight(TreeNode theNode) {
        this.right = theNode;
    }
    
    public TreeNode getParent() {
        return this.parent;
    }
    
    public int getValue() {
        return this.value;
    }
    
    public void setValue(int theValue) {
        this.value = theValue;
    }
    
}
