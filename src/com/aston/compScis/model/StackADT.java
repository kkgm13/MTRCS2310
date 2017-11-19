package com.aston.compScis.model;

/**
 * <h1>StackADT</h1>
 * <br>
 * This data structure will represent Getting the distance between two stations.
 * @author Team CompSci's
 *
 * @param <T>
 */
public interface StackADT<T> {
	
	
	/**
	 * Adds one element to the top of the stack.
	 * @param element
	 */
	public void push(T element);
	
	/**
	 * Removes the top element from the stack
	 * @return element Element that is 
	 */
	public T pop();
	
	
	/**
	 * View the information of the Top Element of the Stack 
	 * @return element Current Top element of the stack
	 */
	public T peek();
	 
	/**
	 * Check if Stack is Empty or Not
	 * @return true Stack contains no elements<br> false Stack contains elements
	 */
	public boolean isEmpty();
	
	/**
	 * Current Number of elements in the Stack
	 * @return size Current Stack Size
	 */
	public int size();
	
	
}
