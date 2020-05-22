package com.learning.java5.annotation.custom;


//1) Marker Annotation
@interface MyMarkerAnnotation {
}

//2) Single-Value Annotation
@interface MySingleValueAnnotation {
	int value();
}

@interface MySingleValueAnnotation1 {
	int value() default 0;
}

//3) Multi-Value Annotation
@interface MyMultiValueAnnotation {
	int value() default 0;
	String value1();
}

/*
Points to be remembered.

1. Method should not have any throws clauses
2. Method should return one of the following: primitive data types, String, Class, enum or array of these data types.
3. Method should not have any parameter.
*/
