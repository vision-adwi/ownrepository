package com.pattern.behavioral.visitor;

public interface Visitor {
	default float visit(Item item){ 
		System.out.println(item);
		return 0.0f;
	};

}
