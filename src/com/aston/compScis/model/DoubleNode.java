package com.aston.compScis.model;

public class DoubleNode<T> {

	private DoubleNode<T> next;
	private DoubleNode<T> previous;
	private T element;

	public DoubleNode() {

		next = null;
		previous = null;
		element = null;
	}

	public DoubleNode(T elem) {
		next = null;
		previous = null;
		element = elem;
	}

	public DoubleNode<T> getNext() {
		return next;
	}

	public void setNext(DoubleNode<T> dnode) {
		this.next = dnode;
	}

	public DoubleNode<T> getPrevious() {
		return previous;
	}

	public void setPrevious(DoubleNode<T> dnode) {
		this.previous = dnode;
	}

	public T getElement() {
		return element;
	}

	public void setElement(T element) {
		this.element = element;
	}

}