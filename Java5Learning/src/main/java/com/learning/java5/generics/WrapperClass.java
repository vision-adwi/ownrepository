package com.learning.java5.generics;

import com.learning.java5.generics.custom.Child;
import com.learning.java5.generics.custom.CustomGenerics;
import com.learning.java5.generics.custom.Parent;

public class WrapperClass {
	
	CustomGenerics<?> name;
	public void setObject(CustomGenerics<?> custom) {
		name = custom;
	}
	
	public void setParentObject(CustomGenerics<Parent> custom) {
		name = custom;
	}
	
	public CustomGenerics<? extends Parent> setParentTypeObject(CustomGenerics<? extends Parent> custom) {
		return custom;
	}
	
	public void setChildSuperObject(CustomGenerics<? super Child> custom) {

	}
	
	public <P, E> P setAnyObject(P obj, E ele) {
		return obj;
	}

}
