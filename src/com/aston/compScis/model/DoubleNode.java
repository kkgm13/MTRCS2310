package com.aston.compScis.model;

public class DoubleNode<T> {

	//References the next DoubleNode
	private DoubleNode<T> next;

	//References the previous DoubleNode
	private DoubleNode<T> previous;

	//The element contained within a DoubleNode
	private T element;

	/**
	 * Constructor for DoubleNode
	 * 
	 * Constructs an empty DoubleNode
	 */

	public DoubleNode() {

		next = null;
		previous = null;
		element = null;
	}

	/**
	 * Constructs DoubleNode with a specific element
	 * 
	 * @param elem
	 */
	public DoubleNode(T elem) {
		next = null;
		previous = null;
		element = elem;
	}

	/**
	 * Returns the next DoubleNode
	 * 
	 * @return next
	 */

	public DoubleNode<T> getNext() {
		return next;
	}

	/**
	 * Sets the next DoubleNode
	 * 
	 * @param dnode
	 */

	public void setNext(DoubleNode<T> dnode) {
		this.next = dnode;
	}

	/**
	 * Gets the previous DoubleNode
	 * 
	 * @return previous
	 */

	public DoubleNode<T> getPrevious() {
		return previous;
	}

	/**
	 * Sets the previous DoubleNode
	 * 
	 * @param dnode
	 */

	public void setPrevious(DoubleNode<T> dnode) {
		this.previous = dnode;
	}

	/**
	 * Gets the element within a DoubleNode
	 * 
	 * @return element
	 */

	public T getElement() {
		return element;
	}

	/**
	 * Sets the element for a DoubleNode
	 * 
	 * @param element
	 */

	public void setElement(T element) {
		this.element = element;
	}

}