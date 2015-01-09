package com.java.drivers;

import com.java.utils.ds.SingleLinkedList;

public class SingleLinkedListDriver {

  public SingleLinkedListDriver() {
    // TODO Auto-generated constructor stub
  }

  /**
   * @param args
   */
  public static void main(String[] args) {

    SingleLinkedList<String> l = new SingleLinkedList<String>();

    for (int i = 0; i < 10; i++) {
      l.add("-" + i + "-");

    }

    for (String s : l) {
      System.out.println("Itr: " + s);

    }
    System.out.println("----");
    l.remove("-0-");
    l.remove("-5-");
    l.remove(1);
    l.add("-99-");
    l.add("-9a-", 4);
    l.add("-9ab-", 5);
    l.add("head", 1);
    l.add("tail", l.size());
    l.add("past tail", l.size() + 5);
    l.add("two", 2);
    l.add("test");
    for (String s : l) {
      System.out.println("Itr: " + s);
    }

  }
}
