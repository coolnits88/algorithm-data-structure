package com.java.utils.ds;

import java.util.Iterator;

import com.java.utils.UserExceptions.InvalidFunctionCallException;
import com.java.utils.UserExceptions.StackEmptyException;

/**
 * This class is implements sTACK using Array data structure. The class in using generics and can be
 * used for any system or user defined data types. The class uses resizing for efficient use of
 * Storage. It resizes to double once the queue becomes full and resizes to half when no of items is
 * less than or equal to 1/4 of total capacity Class implements Comparable interface and provides
 * iterator to use "for each item in " loop syntax in java
 * @author Nitin
 * @param <Item>
 */
public class Stack<Item> implements Iterable<Item>{
	private Item Container[];
	private static int DEFAULT_SIZE = 1;
	public int Capacity = 0;
	private  int top = 0;

	/**
	 * Default constructor initialises a stack with default capacity size.
	 */
	public Stack() {
		this(DEFAULT_SIZE);
	}
	/**
	 * constructor initialises a stack with capacity size passed as argument.
	 * @param size
	 */
	@SuppressWarnings({ "unchecked" })
	public Stack(int size) {
		Container = (Item[])new Object[size];
		Capacity = size;
	}
	/**
	 * Returns no of items present in stack
	 * @return Integer
	 */
	public int size(){return top;}
	
	 /**
	   * Methods returns true if the queue is empty false otherwise
	   * @return boolean
	   */
	public boolean isEmpty() {
		return top == 0;
	}
/**
 * displays last item available for popping from stack
 * @return
 * @throws StackEmptyException
 */
	public Item peep() throws StackEmptyException {
		if(isEmpty()){throw new StackEmptyException("No Element");}
		return Container[top - 1];

	}
	
	  /**
	   * Takes integer argument newCapacity as input. Resizes the Stack to new capacity. Creates a new
	   * array of newCapacity size and copies items to new array. Returns the new array with reference
	   * to old array pointing to new one
	   * @param int
	   */
	@SuppressWarnings({ "unchecked" })
	private void resizeStack(int newCap) {
		
		Item[] cloneContainer = (Item[])new Object[newCap];
		for (int i = 0; i < top; i++) {
			cloneContainer[i] = Container[i];
		}
		Container = cloneContainer;
		Capacity=newCap;
	}
/**
 * Returns and remove the last available item in stack
 * @return Item
 * @throws StackEmptyException
 */
	public Item pop() throws StackEmptyException {
		if (isEmpty()) {
			throw new StackEmptyException("No items present in stack");
		}
		if (top > 0 &&  top == Capacity / 4) {
			resizeStack(Capacity / 2);
		}
		Item item = (Item) Container[--top];
		Container[top] = null;
		return item;
	}
/**
 *  Takes an Item as argument and Inserts the passed item to stack
 * @param items
 */
	public void push(Item items) {
		if (top == Capacity) {
			resizeStack(2 * Capacity);
		}
		Container[top++] = items;
	}
	
	
	  /**
	   * This method returns an instance of Iterator class to iterate over stack items in for each loop
	   * @return Iterator<Item>
	   */
	@Override
	public Iterator<Item> iterator() {
		return (Iterator<Item>) new StackIterator();
	}
	 /**
	   * Private inner class implementing the Iterator interface and overrides the default methods to
	   * iterate over Queue in loop.
	   * @author Nitin
	   */
	private class StackIterator implements Iterator<Item> {
		
		
		private int i = top;
		 /**
	     * returns true if more elements are present in queue to read.
	     * @return boolean
	     */
		@Override
		public boolean hasNext() {
			
			return i>0;
			
		}
		 /**
	     * Returns next available item from queue.
	     * @return <Item>
	     */
		@Override
		public Item next() {
			return Container[--i];
		}

	    /**
	     * This method throws exception if this method is called.
	     * @throws
	     */
	    @Override
	    public void remove() throws InvalidFunctionCallException {
	      // TODO Auto-generated method stub
	      throw new InvalidFunctionCallException("Calling Remove method from Iterator is not allowed");
	    }
		
		
	}
	
}
