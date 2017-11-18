package com.aston.compScis.view;

public class LinearNode<T> {
		//Get Next Node
	private LinearNode<T> next;
		//Get Previous Node
	private LinearNode<T> previous;
		//Get Current Node
	private T element;
	
	public LinearNode() {
		element = null;
		next = null;
		previous = null;
	}
	
	public LinearNode(T element) {
		this.element = element;
		next = null;
		previous = null;
	}
	
	public LinearNode<T> getNext() {
		return next;
	}

	public void setNext(LinearNode<T> next) {
		this.next = next;
	}

	public LinearNode<T> getPrevious() {
		return previous;
	}

	public void setPrevious(LinearNode<T> previous) {
		this.previous = previous;
	}

	public T getElement() {
		return element;
	}

	public void setElement(T element) {
		this.element = element;
	}
	
}
