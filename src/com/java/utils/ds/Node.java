package com.java.utils.ds;

/**
 * Private Class Node for storage
 * @author kumarni1
 */
public class Node<Item> {
  Item value = null;
  Node<Item> next = null;

  /**
   * Takes item as argument and initialises node with item passed
   * @param it
   */

  public Node(Item it) {
    this.value = it;
    next = null;
  }

  public Node() {
  };
}
