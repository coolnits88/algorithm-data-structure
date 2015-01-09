package com.java.drivers;

import com.java.utils.ds.Stack;

public class StackDriver {

  public static void main(String[] args) {
    Stack s = new Stack();
    System.out.println(s.isEmpty());
    s.push("test");
    s.push("te1");
    s.push("te1");
    s.push("te1");
    s.push("te1");
    s.push("te1");
    System.out.println(s.size());
    System.out.println(s.Capacity);
    System.out.println(s.pop());
    System.out.println(s.pop());
    System.out.println(s.pop());
    System.out.println(s.pop());
    System.out.println(s.Capacity);
    System.out.println(s.pop());
    System.out.println(s.Capacity);
    System.out.println(s.pop());
    System.out.println(s.Capacity);
    System.out.println(s.pop());
    System.out.println(s.pop());

  }

}
