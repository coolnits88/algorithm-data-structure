package com.java.utils.ds;

import java.util.Iterator;

import com.java.utils.UserExceptions.InvalidFunctionCallException;
import com.java.utils.UserExceptions.InvalidIndexException;

/**
 * Generic implementation of single link. Provides functionality of adding item at end and at given
 * index. Also removing item and removing item by index The class implements Iterable interface for
 * for each loop syntax.
 * @author nitin
 * @param <Item>
 */
public class SingleLinkedList<Item> implements Iterable<Item> {
  Node<Item> head = null, tail = null, node, tmp;
  private int NUM_ITEMS = 0;

  /**
   * Default constructor initializes empty queue
   */

  public SingleLinkedList() {
    head = null;
    tail = null;
    NUM_ITEMS = 0;
  }

  /**
   * Parameterized constructor takes item as argument and initializes a queue with one item
   * @param item
   */

  public SingleLinkedList(Item item) {
    node = new Node<Item>(item);
    head = tail = node;
    NUM_ITEMS = 1;
  }

  /**
   * Returns number of items in linked list
   * @return
   */
  public int size() {
    return NUM_ITEMS;
  }

  /**
   * Adds passed item to the end of linked list
   * @param item
   * @throws InvalidFunctionCallException
   */
  public boolean add(Item item) throws InvalidFunctionCallException {
    if (item == null) {
      throw new InvalidFunctionCallException("Null Item passed as argument");
    }

    node = new Node<Item>(item);
    if (head == null) {
      head = node;
      tail = node;
      return true;
    } else {
      tail.next = node;
      tail = node;
      NUM_ITEMS++;
    }
    return true;
  }

  /**
   * Inserts node at the index passed as argument. If index if greater than NUM_ITEMS+1 then inserts
   * item at end of list
   * @param item
   * @param index
   * @throws InvalidFunctionCallException
   */
  public void add(Item item, int index) throws InvalidFunctionCallException {
    int i;
    node = new Node<Item>(item);

    if (item == null) {
      throw new InvalidFunctionCallException("Null Item passed as argument");
    }

    if (index < 1) {
      node = null;
      throw new InvalidIndexException("Invalid Index " + index + " passed as argument");
    }
    if (index >= size()) {
      tail.next = node;
      tail = node;

    } else if (index == 1) {
      node.next = head;
      head = node;
    } else {
      tmp = head;
      for (i = 1; i < index - 1; i++) {
        tmp = (Node<Item>) tmp.next;
      }
      node.next = tmp.next;
      tmp.next = node;
    }
    NUM_ITEMS++;
  }

  /**
   * Removes node at the index passed as argument. If index if greater than NUM_ITEMS+1 or less than
   * 1 then throws Exception.
   * @param index
   * @throws InavalidIndexException
   */
  public boolean remove(int index) throws InvalidIndexException {
    Node<Item> oldtmp;
    int i;
    if (index < 1 || index > size()) {
      throw new InvalidIndexException("Invalid Index " + index + " passed as argument");
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
    Item item = (Item) inItem;
    Node<Item> oldtmp;
    int i;

    if (item == null) {
      throw new InvalidFunctionCallException("Null Item passed as argument");
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
   * removes node passed as current argument. old should be node preceding the current node
   * @param current
   * @param old
   * @throws InvalidFunctionCallException
   */
  public void deleteNode(Node<Item> current, Node<Item> old) throws InvalidFunctionCallException {
    if (old == null || current == null) throw new InvalidFunctionCallException(
        "Null Item passed as argument");

    old.next = current.next;
    current.next = null;
    current = null;
  }

  /**
   * Returns iterator for item type for use in for each loop syntax
   * @return
   */
  public Iterator<Item> iterator() {
    return new SingleLinkedListIterator();

  }

  /**
   * Private iterator class for linked list
   * @author kumarni1
   */
  private class SingleLinkedListIterator implements Iterator<Item> {

    private Node<Item> tmp = head;
    private Item item;

    /**
     * returns true if more elements are present in linked list to read.
     * @return boolean
     */
    @Override
    public boolean hasNext() {
      return tmp != null;
    }

    /**
     * Returns next available item from linked list.
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
     * @throws
     */
    @Override
    public void remove() throws InvalidFunctionCallException {
      // TODO Auto-generated method stub
      throw new InvalidFunctionCallException("Calling Remove method from Iterator is not allowed");
    }

  }

}
