package com.pattern.behavioral.visitor;

public interface Item {
	default float accept(Visitor visitor) {
		return visitor.visit(this);
	};

}
