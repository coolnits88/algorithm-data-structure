package com.java.utils.ds;

import com.java.utils.UserExceptions.QueueEmptyException;
import com.java.utils.UserExceptions.QueueFullException;

public class BinaryHeapPriorityQueue<Key extends Comparable<Key>> {

  private Key[] pq;
  private int N;
  private static int DEFAULT_CAPACITY = 5;
  private int Capacity;
  private boolean resizable = false;

  @SuppressWarnings("unchecked")
  public BinaryHeapPriorityQueue() {
    pq = (Key[]) new Comparable[DEFAULT_CAPACITY + 1];
    N = 0;
    Capacity = DEFAULT_CAPACITY + 1;
    resizable = true;
  }

  @SuppressWarnings("unchecked")
  public BinaryHeapPriorityQueue(int Capacity) {
    pq = (Key[]) new Comparable[Capacity + 1];
    N = 0;
    this.Capacity = Capacity + 1;
    resizable = false;
  }

  public boolean isEmpty() {
    return N == 0;
  }

  public boolean isLess(int i, int j) {
    return pq[i].compareTo(pq[j]) < 0;
  }

  private void swap(int i, int j) {
    Key swap = pq[i];
    pq[i] = pq[j];
    pq[j] = swap;

  }

  private void sink(int k) {
    while (2 * k <= N) {
      int j = 2 * k;
      if (j < N && isLess(j, j + 1)) j++;
      if (!isLess(k, j)) break;
      swap(k, j);
      k = j;
    }
  }

  private void swim(int k) {
    while (k > 1 && isLess(k / 2, k)) {
      swap(k / 2, k);
      k = k / 2;

    }

  }

  private void resize(int newCap) {

    Key[] clonepq = (Key[]) new Comparable[newCap];
    for (int i = 1; i <= N; i++) {
      clonepq[i] = pq[i];
    }
    pq = clonepq;
    Capacity = newCap;
  }

  public void insert(Key k) throws QueueFullException {
    if (N == Capacity - 1 && !resizable) throw new QueueFullException();
    else if (N == Capacity - 1 && resizable) resize(Capacity * 2);
    else {
      pq[++N] = k;
      swim(N);
    }
  }

  public Key delete() throws QueueEmptyException {
    if (isEmpty()) throw new QueueEmptyException("No itme left in priority Queue");
    if (N <= Capacity / 4 && resizable) resize(Capacity / 2);
    Key max = pq[1];
    swap(1, N--);
    sink(1);
    pq[N + 1] = null;
    return max;

  }

  public void traverse() {
    for (int i = 1; i <= N; i++) {
      System.out.print(" " + pq[i]);

    }
    System.out.println("\n------");
  }

  public int capacity() {
    return Capacity;
  }

  public int size() {
    return N;
  }

  public static void main(String[] args) {
    BinaryHeapPriorityQueue<Integer> PQ = new BinaryHeapPriorityQueue<Integer>();

    PQ.insert(1);
    System.out.println("Capacity: " + PQ.capacity() + " Size: " + PQ.size());
    PQ.traverse();
    PQ.insert(5);
    System.out.println("Capacity: " + PQ.capacity() + " Size: " + PQ.size());
    PQ.traverse();
    PQ.insert(3);
    System.out.println("Capacity: " + PQ.capacity() + " Size: " + PQ.size());
    PQ.traverse();
    PQ.insert(7);
    System.out.println("Capacity: " + PQ.capacity() + " Size: " + PQ.size());
    PQ.traverse();
    PQ.delete();
    System.out.println("Capacity: " + PQ.capacity() + " Size: " + PQ.size());
    PQ.traverse();
    PQ.insert(9);
    System.out.println("Capacity: " + PQ.capacity() + " Size: " + PQ.size());
    PQ.traverse();
    PQ.insert(2);
    System.out.println("Capacity: " + PQ.capacity() + " Size: " + PQ.size());
    PQ.traverse();
    PQ.insert(4);
    System.out.println("Capacity: " + PQ.capacity() + " Size: " + PQ.size());
    PQ.traverse();
    PQ.insert(12);
    System.out.println("Capacity: " + PQ.capacity() + " Size: " + PQ.size());
    PQ.traverse();
    PQ.insert(14);
    System.out.println("Capacity: " + PQ.capacity() + " Size: " + PQ.size());
    PQ.traverse();
    PQ.insert(5);
    System.out.println("Capacity: " + PQ.capacity() + " Size: " + PQ.size());
    PQ.traverse();
    PQ.delete();
    PQ.delete();
    PQ.delete();
    PQ.delete();
    PQ.delete();
    PQ.delete();
    System.out.println("Capacity: " + PQ.capacity() + " Size: " + PQ.size());
    PQ.traverse();
  }

}
