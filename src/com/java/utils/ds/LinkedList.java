package com.java.utils.ds;

import java.util.Collection;
import java.util.Iterator;

import com.java.utils.UserExceptions.InavalidIndexException;
import com.java.utils.UserExceptions.InvalidFunctionCallException;

public class LinkedList<Item> implements Iterable<Item>, Collection<Item> {
	Node<Item> head = null, tail = null, node, tmp;
	private int NUM_ITEMS = 0;
	
	/**
	 * Default constructor initialises empty queue
	 */

	public LinkedList() {
		head = null;
		tail = null;
		NUM_ITEMS = 0;
	}

	/**
	 * Parameterised constructor takes item as argument and initialises a queue
	 * with one item
	 * 
	 * @param item
	 */

	public LinkedList(Item item) {
		node = new Node<Item>(item);
		head = tail = node;
		NUM_ITEMS = 1;
	}

	/**
	 * Returns number of items in linked list
	 * 
	 * @return
	 */
	public int size() {
		return NUM_ITEMS;
	}

	/**
	 * Adds passed item to the end of linked list
	 * 
	 * @param item
	 * @throws InvalidFunctionCallException
	 */
	public boolean add(Item item) throws InvalidFunctionCallException {
		if (item == null) {
			throw new InvalidFunctionCallException(
					"Null Item passed as argument");
		}

		node = new Node<Item>(item);
		if(head==null){
			head=node;
			tail=node;
			return true;
		}
		else{
		tail.next = node;
		tail = node;
		NUM_ITEMS++;
		}
		return true;
	}

	/**
	 * Inserts node at the index passed as argument. If index if greater than
	 * NUM_ITEMS+1 then inserts item at end of list
	 * 
	 * @param item
	 * @param index
	 * @throws InvalidFunctionCallException
	 */
	@SuppressWarnings("unchecked")
	public void add(Item item, int index) throws InvalidFunctionCallException {
		int i;
		node = new Node<Item>(item);
		
		if (item == null) {
			throw new InvalidFunctionCallException(
					"Null Item passed as argument");
		}

		if (index < 1) {
			node = null;
			throw new InavalidIndexException("Invalid Index " + index
					+ " passed as argument");
		}
		if (index >= size()) {
			tail.next = node;
			tail = node;

		} else if (index == 1) {
			node.next = head;
			head = node;
		} else {
			tmp = head;
			for (i = 1; i < index-1; i++) {
				tmp = (Node<Item>) tmp.next;
			}
			node.next = tmp.next;
			tmp.next = node;
		}
		NUM_ITEMS++;
	}

	/**
	 * Removes node at the index passed as argument. If index if greater than
	 * NUM_ITEMS+1 or less than 1 then throws Exception.
	 * 
	 * @param index
	 * @throws InavalidIndexException
	 */
	@SuppressWarnings("unchecked")
	public boolean remove(int index) throws InavalidIndexException {
		Node<Item> oldtmp;
		int i, cnt = 0;
		if (index < 1 || index > size()) {
			throw new InavalidIndexException("Invalid Index " + index
					+ " passed as argument");
		}

		tmp = oldtmp = head;

		// removing head node
		if (index == 1) {
			head = head.next;
			tmp.next = null;
			tmp = null;
			NUM_ITEMS--;
			return true;
		}

		// for rest of nodes
		for (i = 1; i < index; i++) {
			oldtmp = tmp;
			tmp = tmp.next;
		}

		deleteNode(tmp, oldtmp);
		NUM_ITEMS--;
		return true;
	}
	
	@SuppressWarnings("unchecked")
	public boolean remove(Object inItem) throws InvalidFunctionCallException {
		Item item =(Item)inItem;
		Node<Item> oldtmp;
		int i, cnt = 0;

		if (item == null) {
			throw new InvalidFunctionCallException(
					"Null Item passed as argument");
		}

		tmp = oldtmp = head;

		// checking if item passed is head node
		if (tmp.value.equals(item)) {
			head = tmp.next;
			tmp.next = null;
			tmp = null;
			NUM_ITEMS--;
			return true;
		}

		// for rest of nodes
		for (i = 1; i < size(); i++) {
			oldtmp = tmp;
			tmp = tmp.next;
			if (tmp.value.equals(item)) {
				break;
			}
		}

		if (oldtmp == tail || tmp == null) {
			return false;
		}
		deleteNode(tmp, oldtmp);
		NUM_ITEMS--;
		return true;
	}

	/**
	 * removes node passed as current argument. old should be node preceding the
	 * current node
	 * 
	 * @param current
	 * @param old
	 * @throws InvalidFunctionCallException
	 */
	@SuppressWarnings("unchecked")
	public void deleteNode(Node current, Node old)
			throws InvalidFunctionCallException {
		if (old == null || current == null)
			throw new InvalidFunctionCallException(
					"Null Item passed as argument");

		old.next = current.next;
		current.next = null;
		current = null;
	}

	/**
	 * Returns iterator for item type for use in for each loop syntax
	 * 
	 * @return
	 */
	public Iterator<Item> iterator() {
		return new LinkedListIterator();

	}
	/**
	 * Private iterator class for linked list 
	 * 
	 * @author kumarni1
	 *
	 */
	private class LinkedListIterator implements Iterator<Item> {

		private Node<Item> tmp = head;
		private Item item;

		/**
		 * returns true if more elements are present in linked list to read.
		 * 
		 * @return boolean
		 */
		@Override
		public boolean hasNext() {
			return tmp != null;
		}

		/**
		 * Returns next available item from linked list.
		 * 
		 * @return <Item>
		 */
		@Override
		public Item next() {
			item = tmp.value;
			tmp = tmp.next;
			return item;
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
	// to implement
	public void remove(Item i ,boolean b ) {} // removes all occurences or not
	public void addAll(Collection<Item> col){} // adds all items from collection to linked list
	public void removeAll(Collection<Item> col){} // remove all items from collection
	public void removeAll(LinkedList<Item> col){} //  remove elements
	public void addAll(LinkedList<Item> col){} //  remove elements
	//public void copy constructor()
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		LinkedList<String> l = new LinkedList<String>();
		
		for (int i =0 ; i < 10; i++){
			l.add("-"+i+"-");
			
		}
		
		for(String s: l){
			System.out.println("Itr: "+s);
			
		}
		System.out.println("----");
		l.remove("-0-");
		l.remove("-5-");
		l.remove(1);
		l.add("-99-");
		l.add("-9a-",4);
		l.add("-9ab-",5);
		l.add("head",1);
		l.add("tail",l.size());
		l.add("past tail",l.size()+5);
		l.add("two",2);
		l.add("test");
		for(String s: l){
			System.out.println("Itr: "+s);
		}
		
	}

	@Override
	public boolean addAll(Collection<? extends Item> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

}
