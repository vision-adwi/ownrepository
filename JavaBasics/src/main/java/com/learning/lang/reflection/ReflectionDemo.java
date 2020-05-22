package com.learning.lang.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionDemo {

	public static void main(String[] args) {
		Class clazz = SubjectClass.class;
		try {
			Constructor<SubjectClass> constructor = clazz.getDeclaredConstructor(null);
			constructor.setAccessible(true);
			
			SubjectClass obj = constructor.newInstance(null);
			
			Method method = clazz.getDeclaredMethod("setMessage", new Class[]{String.class});
			method.invoke(obj, new Object[]{"Reflection"});
			
			method = clazz.getDeclaredMethod("getMessage", null);
			System.out.println(method.invoke(obj, null));
			
			constructor = clazz.getDeclaredConstructor(new Class[]{String.class});
			constructor.setAccessible(true);
			
			obj = constructor.newInstance(new Object[]{"Reflection1"});
			
			method = clazz.getDeclaredMethod("getMessage", null);
			System.out.println(method.invoke(obj, null));
		} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
