package com.datastructure.list;

public class NodeDLL {
	public String nodeValue;
	public NodeDLL previousNode = null;
	public NodeDLL nextNode = null;

	public NodeDLL() {
	}
	
	public NodeDLL(String theNodeValue) {
		nodeValue = theNodeValue;
	}

}
