package com.java.utils;

public class SortUtils {

  /**
   * This Static method compares the two Comparable objects passed as arguments and returns true if
   * first argument passed is less than second argument
   */
  @SuppressWarnings({ "rawtypes", "unchecked" })
  public static boolean isLess(Comparable v, Comparable w) {
    return v.compareTo(w) < 0;
  }

  /**
   * This Static method takes as argument a comparable array and two indexes to swap it swaps the
   * items in the indexes passes as arguments in the aray itself.
   */
  @SuppressWarnings({ "rawtypes" })
  public static void swap(Comparable[] s, int i, int j) {

    Comparable swap = s[i];
    s[i] = s[j];
    s[j] = swap;
  }

  /**
   * This static method takes a comparable array as input and checks if the items in the array are
   * sorted in the natural order or as defined by the compareTo method. Returns true if items are
   * sorted and false otherwise.
   */
  @SuppressWarnings({ "rawtypes" })
  public static boolean isSorted(Comparable[] a) {
    for (int i = 1; i < a.length; i++) {
      if (isLess(a[i], a[i - 1])) return false;
    }
    return true;
  }

  /**
   * This static method takes a comparable array as input and checks if the items in the array are
   * sorted in the reverse natural order or as defined by the compareTo method. Returns true if
   * items are reverse sorted and false otherwise. This functions exactly opposite to isSorted
   * method
   */
  @SuppressWarnings({ "rawtypes" })
  public static boolean isReverseSorted(Comparable[] a) {
    for (int i = 1; i < a.length; i++) {
      if (isLess(a[i - 1], a[i])) return false;
    }
    return true;
  }

}
