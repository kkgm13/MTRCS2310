package com.aston.compScis.model;

public class LinkedStack<T> implements StackADT<T> {

	// DoubleNode used to model top of linkedstack
	private DoubleNode<T> top;

	// Count shows elements in linkedstack
	private int count;

	// Creates an empty linkedstack
	public LinkedStack() {
		top = null;
		count = 0;
	}

	@Override
	/**
	 * Pushes element to the head of the linkedstack
	 * 
	 * @param element
	 */
	public void push(T element) {
		DoubleNode<T> tmp = new DoubleNode<T>(element);
		tmp.setNext(top);
		top = tmp;
		count++;
	}

	@Override
	/**
	 * Pops element off the head of the linkedstack
	 * 
	 * @return result
	 */
	public T pop() {

		if (isEmpty())
			throw new IllegalStateException("Stack empty in pop");
		T result = top.getElement();
		top = top.getNext();
		count--;
		return result;
	}

	@Override
	/**
	 * Returns the top of the linkedstack but does not remove it
	 * 
	 * @return top
	 */
	public T peek() {

		if (isEmpty())
			throw new IllegalStateException("Stack empty in peek");
		return top.getElement();
	}

	@Override
	/**
	 * Checks if the linkedstack is empty
	 * 
	 * @return top
	 */
	public boolean isEmpty() {

		return top == null;
	}

	@Override

	/**
	 * Returns the size of the linkedstack
	 * 
	 * @return count
	 */
	public int size() {

		return count;
	}

}
