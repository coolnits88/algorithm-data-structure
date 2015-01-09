package com.java.drivers;

import com.java.utils.UserExceptions.InvalidFunctionCallException;
import com.java.utils.ds.Queue;

public class QueueDriver {

  public QueueDriver() {
    // TODO Auto-generated constructor stub
  }

  public static void main(String[] args) throws Exception {
    Queue<Integer> s = new Queue<Integer>();
    s.enqueue(1);
    s.enqueue(2);

    s.enqueue(3);
    // System.out.println(" Capacity " + s.Capacity + " size " + s.size());
    s.enqueue(4);
    System.out.println(s.dequeue());
    System.out.println(s.dequeue());
    // System.out.println(" Capacity " + s.Capacity + " size " + s.size());
    s.enqueue(5);
    // System.out.println(" Main Thread First " + s.First + "Last " + s.Last);
    s.enqueue(6);
    for (int si : s) {
      System.out.println("Iterator1: " + si);
    }

    s.enqueue(7);
    s.enqueue(8);
    // System.out.println(" Capacity " + s.Capacity + " size " + s.size());
    s.enqueue(9);
    System.out.println(s.dequeue());
    System.out.println(s.dequeue());
    System.out.println(s.dequeue());
    s.enqueue(10);
    s.enqueue(11);
    s.enqueue(12);
    s.enqueue(13);
    s.enqueue(14);
    // System.out.println(" Capacity " + s.Capacity + " size " + s.size());
    // System.out.println(s.dequeue());
    // System.out.println(s.dequeue());
    // System.out.println(s.dequeue());
    // System.out.println(s.dequeue());
    // System.out.println(s.dequeue());
    // System.out.println(s.dequeue());
    // System.out.println(s.dequeue());
    // System.out.println(s.dequeue());
    // System.out.println(" Capacity " + s.Capacity + " size " + s.size());
    // System.out.println(s.dequeue());
    // System.out.println(" Capacity " + s.Capacity + " size " + s.size());
    for (int si : s) {
      System.out.println("Iterator2: " + si);
    }
    try {
      s.iterator().remove();
    } catch (InvalidFunctionCallException e) {

      System.out.print("[Main Thread] Caught Exception: ");
      System.out.println(e.getMessage());
    }
  }

}
