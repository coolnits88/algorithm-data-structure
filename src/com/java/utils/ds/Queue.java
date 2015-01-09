package com.java.utils.ds;

import java.util.Iterator;

import com.java.utils.UserExceptions.InvalidFunctionCallException;
import com.java.utils.UserExceptions.QueueEmptyException;

/**
 * This class is implements Queue using Array data structure. The class in using generics and can be
 * used for any system or user defined data types. The class uses resizing for efficient use of
 * Storage. It resizes to double once the queue becomes full and resizes to half when no of items is
 * less than or equal to 1/4 of total capacity Class implements Comparable interface and provides
 * iterator to use "for each item in " loop syntax in java
 * @author Nitin
 * @param <Item>
 */
public class Queue<Item> implements Iterable<Item> {

  private Item[] s;
  public int First = 0, Last = 0, Capacity = 0;
  private int itemCount = 0;
  private Item item;
  private static int DEFAULT_CAPACITY=10;

/**
 * Default constructor initializes a queue with default capacity size.
 */
  public Queue(){
	  this(DEFAULT_CAPACITY);
  }
  
/**
 * constructor initialises a queue with capacity size passed as argument.
 * @param cap
 */
  @SuppressWarnings({ "unchecked" })
  public Queue(int cap) {
    s = (Item[]) new Object[cap];
    Capacity=cap;
  }

  /**
   * Methods returns true if the queue is empty false otherwise
   * @return boolean
   */
  public boolean isEmpty() {
    if (First == Last) {
      First = Last = 0;
      resize(Capacity / 2);
      return true;
    }

    return false;

  }

  /**
   * Returns true if Queue is Full false otherwise
   * @return boolean
   */
  public boolean isFull() {
    return (Last == Capacity && First == 0) || (First == Last + 1);
  }

  /**
   * Methods removes the first item in the queue and returns to the invoking thread.
   * @return <Item>
   * @throws QueueEmptyException
   */
  public Item dequeue() throws QueueEmptyException {
    if (isEmpty()) {
      throw new QueueEmptyException();
    }
    if (size() <= Capacity / 4) {
      resize(Capacity / 2);
    }
    if (First == Capacity) {
      First = 0;
    }

    item = s[First++];
    s[First - 1] = null;
    itemCount--;
    return item;
  }

  /**
   * Takes an Item as argument and puts in the queue in the last available location.
   * @param <Item>
   */
  public void enqueue(Item item) {
    if (isFull()) {
      resize(Capacity * 2);
    }
    if (Last == Capacity && First != 0) {
      Last = 0;
      s[Last] = item;
      Last++;
    } else {
      s[Last++] = item;
    }
    itemCount++;
  }

  /**
   * Takes integer argument newCapacity as input. Resizes the Queue to new capacity. Creates a new
   * array of newCapacity size and copies items to new array. Returns the new array with reference
   * to old array pointing to new one
   * @param int
   */
  @SuppressWarnings({ "unchecked" })
  private void resize(int newCapacity) {

    Item[] st = (Item[]) new Object[newCapacity];
    int i, j = 0;
    for (i = First; j < size(); i++) {
      if (i == Capacity && Last < First) {
        i = 0;
      }
      st[j] = s[i];
      j++;
    }
    s = st;
    Capacity = newCapacity;
    First = 0;
    Last = size();
  }

  /**
   * Returns the no of items currently present in the queue
   * @return integer
   */
  public int size() {
    return itemCount;
  }

  /**
   * This method returns an instance of Iterator class to iterate of queue items in for each loop
   * @return Iterator<Item>
   */
  @Override
  public Iterator<Item> iterator() {
    return new QueueIterator();
  }

  /**
   * Private inner class implementing the Iterator interface and overrides the default methods to
   * iterate over Queue in loop.
   * @author Nitin
   */
  private class QueueIterator implements Iterator<Item> {

    private int i = First;
    private Item items;

    /**
     * returns true if more elements are present in queue to read.
     * @return boolean
     */
    @Override
    public boolean hasNext() {
      return i != Last;
    }

    /**
     * Returns next available item from queue.
     * @return <Item>
     */
    @Override
    public Item next() {
    	items = s[i];
    if (i == Capacity-1 && Last < First) {
        i = 0;
      } else {
        i++;
      }
      
      return items;
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
