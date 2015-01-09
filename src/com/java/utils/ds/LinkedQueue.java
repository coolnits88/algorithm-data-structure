package com.java.utils.ds;

import java.util.Iterator;

import com.java.utils.UserExceptions.InvalidFunctionCallException;
import com.java.utils.UserExceptions.QueueEmptyException;

/**
 * This class is implements Queue using Array data structure. The class in using
 * generics and can be used for any system or user defined data types. The class
 * uses resizing for efficient use of Storage. It resizes to double once the
 * queue becomes full and resizes to half when no of items is less than or equal
 * to 1/4 of total capacity Class implements Comparable interface and provides
 * iterator to use "for each item in " loop syntax in java
 * 
 * @author Nitin
 * @param <Item>
 */
public class LinkedQueue<Item> implements Iterable<Item> {

	public Node head, tail, oldHead;
	private int itemCount = 0;
	private Item item;

	/**
	 * Private Class Node for storage
	 * 
	 * @author kumarni1
	 * 
	 */
	private class Node {
		Item value = null;
		Node next = null;

		/**
		 * Takes item as argument and initialises node with item passed
		 * 
		 * @param it
		 */

		public Node(Item it) {
			this.value = it;
			next = null;
		}

		@SuppressWarnings("unused")
		public Node() {
		};
	}

	/**
	 * Default constructor initializes a queue with default capacity size.
	 */
	public LinkedQueue() {
		head = null;
		tail = null;
		itemCount = 0;
	}

	/**
	 * Methods returns true if the queue is empty false otherwise
	 * 
	 * @return boolean
	 */
	public boolean isEmpty() {
		return itemCount == 0 || head == null;
	}

	/**
	 * Methods removes the first item in the queue and returns to the invoking
	 * thread.
	 * 
	 * @return <Item>
	 * @throws QueueEmptyException
	 */
	public Item dequeue() throws QueueEmptyException {
		if (isEmpty()) {
			throw new QueueEmptyException();
		}
		oldHead = head;
		head = oldHead.next;
		item = oldHead.value;
		oldHead = null;
		itemCount--;
		return item;
	}

	/**
	 * Takes an Item as argument and puts in the queue in the last available
	 * location.
	 * 
	 * @param <Item>
	 */
	public void enqueue(Item item) {
		Node node = new Node(item);
		if (tail==null){tail=node;head=node;}
		else{
		tail.next=node;
		}
		tail = node;
		itemCount++;
	}


	/**
	 * Returns the no of items currently present in the queue
	 * 
	 * @return integer
	 */
	public int size() {
		return itemCount;
	}

	/**
	 * This method returns an instance of Iterator class to iterate of queue
	 * items in for each loop
	 * 
	 * @return Iterator<Item>
	 */
	@Override
	public Iterator<Item> iterator() {
		return new QueueIterator();
	}

	/**
	 * Private inner class implementing the Iterator interface and overrides the
	 * default methods to iterate over Queue in loop.
	 * 
	 * @author Nitin
	 */
	private class QueueIterator implements Iterator<Item> {
		
		private Node tmp=head ;
		private Item items;
		

		/**
		 * returns true if more elements are present in queue to read.
		 * 
		 * @return boolean
		 */
		@Override
		public boolean hasNext() {
			return tmp != null ;
		}

		/**
		 * Returns next available item from queue.
		 * 
		 * @return <Item>
		 */
		@Override
		public Item next() {
			items = tmp.value;
			tmp=tmp.next;
			

			return items;
		}

		/**
		 * This method throws exception if this method is called.
		 * 
		 * @throws
		 */
		@Override
		public void remove() throws InvalidFunctionCallException {
			// TODO Auto-generated method stub
			throw new InvalidFunctionCallException(
					"Calling Remove method from Iterator is not allowed");
		}

	}

}
