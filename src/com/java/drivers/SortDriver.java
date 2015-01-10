package com.java.drivers;

import java.util.Random;

import com.java.utils.SortUtils;
import com.java.utils.sorts.BottomUpMergeSort;

public class SortDriver extends SortUtils {

  public SortDriver() {
    // TODO Auto-generated constructor stub
  }

  public static void main(String[] args) {

    // String[] as = { "a", "f", "as", "sd", "b", "tr", "ew", "be", "e" };
    int LIM = 10000000;
    Double[] as = new Double[LIM];
    Random rand = new Random();
    for (int i = 0; i < LIM; i++) {
      as[i] = rand.nextDouble();
    }

    System.out.println("Array Sorted before sort : " + isSorted(as));

    // Sort items
    long st = System.currentTimeMillis();
    BottomUpMergeSort.sort(as);
    // MergeSort.sort(as);
    // SelectionSort.sort(as);
    // InsertionSort.sort(as);
    // ShellSort.sort(as);
    long duration = System.currentTimeMillis() - st;
    System.out.println("Run time:" + duration);
    System.out.println("Array Sorted after sort : " + isSorted(as));

    // print data
    // System.out.println("After Sort:");
    // for (String j : as) {
    // System.out.println("Item: " + j);
    // }

  }
}
