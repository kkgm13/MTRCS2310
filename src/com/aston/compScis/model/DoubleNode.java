package com.aston.compScis.model;

public class DoubleNode<T> {
	private DoubleNode<T> previous; // reference to the previous node
	private DoubleNode<T> next; // reference to the next node
	private T element; // the element stored in this node

	public DoubleNode(T elem) {
		next = null;
		element = elem;
		previous = null;
	}

	public DoubleNode<T> getPrevious() {
		return previous;
	}

	public void setPrevious(DoubleNode<T> dnode) {
		previous = dnode;
	}

	public DoubleNode<T> getNext() {
		return next;
	}

	public void setNext(DoubleNode<T> next) {
		this.next = next;
	}

	public T getElement() {
		return element;
	}

	public void setElement(T element) {
		this.element = element;
	}
	
	
}
