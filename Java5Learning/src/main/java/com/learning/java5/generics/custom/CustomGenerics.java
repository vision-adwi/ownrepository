package com.learning.java5.generics.custom;
/*
 * Possible declarations (class level)
 * 1. CustomGenerics<T>
 * 2. CustomGenerics<T extends Number>
*/

public class CustomGenerics<T>
{
	protected T theItem;
	
	public CustomGenerics() 
	{
	}
	public CustomGenerics(T item)
	{
		theItem = item;
	}
	public void setItem(T item)
	{
		theItem = item;
	}
	public T getItem()
	{
		return theItem;
	}
}
