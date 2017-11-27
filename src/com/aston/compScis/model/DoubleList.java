package com.aston.compScis.model;

import java.util.Iterator;

public abstract class DoubleList<T> {

	protected DoubleNode<T> front; // the first node
	protected DoubleNode<T> rear; // the last node
	protected int count; // size of the list
	
	/** Constructor: Creates an empty list. */
	 protected DoubleList() {
		 	rear = null;
		 	front = null;
		 	count = 0;
	 }
	
}
