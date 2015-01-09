package com.java.drivers;

import com.java.utils.SortUtils;
import com.java.utils.sorts.ShellSort;

public class SortDriver extends SortUtils {

  public SortDriver() {
    // TODO Auto-generated constructor stub
  }

  public static void main(String[] args) {
    // SelectionSort s = new SelectionSort();
    // InsertionSort s = new InsertionSort();
    ShellSort s = new ShellSort();

    int i = 0;

    Double[] a = new Double[20];
    // Generate random doubles and populate array
    for (i = 0; i < a.length; i++) {
      a[i] = Math.random();
    }
    String[] as = { "a", "f", "as", "sd", "b", "tr", "ew", "be", "e" };

    System.out.println("Array Sorted before sort : " + isSorted(a));
    // Sort items
    s.sort(a);
    System.out.println("Array Sorted after sort : " + isSorted(a));

    System.out.println("Array Sorted before sort : " + isSorted(as));
    // Sort items
    s.sort(as);
    System.out.println("Array Sorted after sort : " + isSorted(as));

    // print data
    System.out.println("After Sort:");
    for (double j : a) {
      System.out.println("Item: " + j);
    }
    // print data
    System.out.println("After Sort:");
    for (String j : as) {
      System.out.println("Item: " + j);
    }

  }
}
