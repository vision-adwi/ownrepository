package com.learning.java5.annotation.custom;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

@Retention(RetentionPolicy.RUNTIME)  
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD,ElementType.CONSTRUCTOR})  
@Inherited
@Documented
public @interface AnotherAnnotation {
	int value();
	String value1();
}


/*
Other built-in annotations
@Inherited
By default, annotations are not inherited to subclasses. The @Inherited annotation marks the annotation to be inherited to subclasses.

@Documented
The @Documented Marks the annotation for inclusion in the documentation.
*/
