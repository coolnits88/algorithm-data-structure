package com.java.utils.ds;

import java.util.Iterator;

import com.java.utils.UserExceptions.InvalidFunctionCallException;
import com.java.utils.UserExceptions.StackEmptyException;

/**
 * This class is implements sTACK using linked list data structure. The class in using generics and can be
 * used for any system or user defined data types. 
 * Class implements Comparable interface and provides terator to use "for each item in " loop syntax in java
 * @author Nitin
 * @param <Item>
 */
public class LinkedStack<Item> implements Iterable<Item> {

	private int size;
	private Node head;
	private Node oldHead;
	private Item retVal;
	
	/**
	 * Private Class Node for storage
	 * @author kumarni1
	 *
	 */
	private class Node{
		Item value=null;
		Node next = null;
		
		/**
		 * Takes item as argument and initialises node with item passed
		 * @param it
		 */
		public Node(Item it){this.value=it; next = null;}
		@SuppressWarnings("unused")
		public Node(){};
	}
	/**
	 * default Constructor for linked stack initialises stack with 0 size
	 */
	public LinkedStack() {
		head = null;
		size = 0;
	}
	
	/**
	 * Returns no of items present in stack
	 * @return Integer
	 */
	public int size(){
		return size;
		}
	 /**
	   * Methods returns true if the queue is empty false otherwise
	   * @return boolean
	   */
	public boolean isEmpty(){
		return head == null || size == 0;
	}
	/**
	 *  Takes an Item as argument and Inserts the passed item to stack
	 * @param items
	 */
	public void push(Item items){
		Node node = new Node(items);
		node.next=head;
		head = node;
		size++;

	}
	/**
	 * Returns and remove the last available item in stack
	 * @return Item
	 * @throws StackEmptyException
	 */
	public Item pop() throws StackEmptyException{
		if (isEmpty()){throw new StackEmptyException("Stack Empty");}
		oldHead=head;
		head = oldHead.next;
		retVal =oldHead.value;
		oldHead = null;
		size--;
		return retVal;
	}
	/**
	   * This method returns an instance of Iterator class to iterate over stack items in for each loop
	   * @return Iterator<Item>
	   */
	@Override
	public Iterator<Item> iterator() {
		
		return new LinkedStackIterator();
	}
	/**
	   * Private inner class implementing the Iterator interface and overrides the default methods to
	   * iterate over Queue in loop.
	   * @author Nitin
	   */
	private class LinkedStackIterator implements Iterator<Item>{
		
		private Node tmp=head ;
		private Item values;
		/**
	     * returns true if more elements are present in queue to read.
	     * @return boolean
	     */
		@Override
		public boolean hasNext() {
			return tmp != null ;
		}
		/**
	     * Returns next available item from queue.
	     * @return <Item>
	     */
		@Override
		public Item next() {
			values = tmp.value;
			tmp=tmp.next;
		
			return values;
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
