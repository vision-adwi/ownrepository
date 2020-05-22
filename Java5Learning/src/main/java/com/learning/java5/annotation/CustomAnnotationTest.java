package com.learning.java5.annotation;

import java.lang.reflect.Method;

import com.learning.java5.annotation.custom.AnotherAnnotation;

class Hello {
	@AnotherAnnotation(value=1, value1="Hi")
	public void sayHello() {
		System.out.println("Custom annotation test");
	}
}
public class CustomAnnotationTest {

	public static void main(String[] args) {
		Hello hello = new Hello();
		
		try {
			Method method = hello.getClass().getMethod("sayHello");
			AnotherAnnotation customAnnotation = method.getAnnotation(AnotherAnnotation.class);
			System.out.println("Annotation value - " + customAnnotation.value());
			System.out.println("Annotation value1 - " + customAnnotation.value1());
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}

	}

}
