package com.practice.tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
    	List<String> paths = new ArrayList<>();
   		allPaths(root, paths, new ArrayList<>());
        
    	return paths;
    }
    
    private void allPaths(TreeNode theNode, List<String> result, List<Integer> current) {
    	if(theNode == null)
    		return;
    	
    	if(theNode.left == null && theNode.right == null) {
    		current.add(theNode.val);
    		result.add(buildString(current));
    		current.remove(current.size() - 1);
    		return;
    	}
    	
    	current.add(theNode.val);
    	allPaths(theNode.left, result, current);
    	allPaths(theNode.right, result, current);
    	current.remove(current.size() - 1);
    }
    
    private String buildString(List<Integer> paths) {
    	StringBuilder builder = new StringBuilder();
    	for(Integer path : paths) {
    		if(builder.length() != 0)
    			builder.append("->");
    		
    		builder.append(path);
    	}
    
    	return builder.toString();
    }
}
