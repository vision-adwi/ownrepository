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
            this.root = new TreeNode(theValue);
        }
        else {
            insertInBST(this.root, theValue);
        }
    }
    
    private void insertInBST(TreeNode theNode, int theValue) {
        TreeNode next = null;
        if(theValue <= theNode.val) {
            if((next = theNode.left) == null) {
            	theNode.left = new TreeNode(theValue);
                return;
            }
        }
        else {
            if((next = theNode.right) == null) {
            	theNode.right = new TreeNode(theValue);
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
			count = minCount(theNode.left, theValue, count);
			if(theNode.val < theValue) {
				count++;
				count = minCount(theNode.right, theValue, count);
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

/*public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}*/
