package com.java.utils.ds;

import java.util.Iterator;

public class BST<Key extends Comparable<Key>, Value> implements Iterable<Key> {
  private Entry root;

  public BST() {
    root = null;
  }

  public void put(Key key, Value value) {
    root = put(root, key, value);
  }

  private Entry put(Entry x, Key key, Value value) {
    if (x == null) return new Entry(key, value);
    int cmp = key.compareTo(x.key);

    if (cmp < 0) {
      x.left = put(x.left, key, value);
    } else if (cmp > 0) {
      x.right = put(x.right, key, value);

    } else x.value = value;
    return x;
  }

  public Value get(Key key) {
    Entry x = root;
    int cmp;
    while (x != null) {
      cmp = key.compareTo(x.key);
      if (cmp < 0) x = x.left;
      else if (cmp > 0) x = x.right;
      else return x.value;
    }
    return null;
  }

  public void delete(Key key) {

  }

  public Iterator<Key> iterator() {
    return new BSTIterator();
  }

  private class BSTIterator implements Iterator<Key> {

    @Override
    public boolean hasNext() {
      // TODO Auto-generated method stub
      return false;
    }

    @Override
    public Key next() {
      // TODO Auto-generated method stub
      return null;
    }

    @Override
    public void remove() {
      // TODO Auto-generated method stub

    }

  }

  private class Entry {
    Key key;
    Value value;

    private Entry left, right;

    public Entry(Key key, Value value) {
      this.key = key;
      this.value = value;

    }
  }

}
