package com.aston.compScis.model;

public interface StackADT<T> {
	
	//Adds one element to the top of the stack.
	public void push(T element);
	
	//Removes and returns the top element from the stack
	public T pop();
	
	//Returns the top element of the stack without removing it
	public T peek();
	
	//Returns true if the stack contains no elements and false otherwise 
	public boolean isEmpty();
	
	//Returns the number of elements in the stack
	public int size();
	
	
}
