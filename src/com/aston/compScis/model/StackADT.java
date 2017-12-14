package com.aston.compScis.model;

public interface StackADT<T> {

	/**
	 * Adds one element to the top of the stack.
	 * 
	 * @param the element to be added to the stack
	 */
	public void push(T element);

	/**
	 * Removes and returns the top element from the stack.
	 * 
	 * @return the element at the top of the stack
	 */
	public T pop();

	/**
	 * Returns the top element of the stack without removing it.
	 * 
	 * @return the element at the top of the stack
	 */
	public T peek();

	/**
	 * Returns true if the stack contains no elements and false otherwise.
	 * 
	 * @return true if the stack contains no elements
	 */
	public boolean isEmpty();

	/**
	 * Returns the number of elements in the stack.
	 * 
	 * @return the number of elements in the stack
	 */
	public int size();
}