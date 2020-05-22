package com.learning.java5.annotation;

import java.util.ArrayList;
import java.util.List;

/*
1. Never put @SuppressWarnings("unchecked) or other options, at the class level, this would potentially mask critical warnings.
2. Don't use @SuppressWarnings("all"), it will suppress all warnings, which can mask potential warnings which could lead to RuntimeException 
when you run the program.
3. While using @SuppressWarnings("unchecked"), add a comment to explain about "why a particular portion of code is type-safe" before suppressing this warning. 
Every unchecked warning is an indication of potential ClassCastException at runtime, so don't ignore them.
4. Use @SuppressWarnings at the smallest scope. Which means if the warning can be removed by putting @SuppressWarnings at a local variable then use that instead of annotating whole method. 
It's also worth knowing that suppress warnings annotation can be applied to class, field, method, parameter, constructor and local variables.
Type of Warnings - all, cast, deprecation, divzero, empty, unchecked, fallthrough, path, serial, finally, overrides
*/

class ParentA {
	
	@SuppressWarnings({ "rawtypes", "unchecked" })  
	void calcA()
	{
		List list = new ArrayList();
		
		list.add(1);
	}

}
