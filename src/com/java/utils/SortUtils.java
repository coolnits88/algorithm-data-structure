package com.java.utils;

public class SortUtils {

  /**
   * This Static method compares the two Comparable objects passed as arguments and returns true if
   * first argument passed is less than second argument
   * @param v
   * @param w
   * @return boolean
   */
  @SuppressWarnings({ "rawtypes", "unchecked" })
  public static boolean isLess(Comparable v, Comparable w) {
    return v.compareTo(w) < 0;
  }

  /**
   * This Static method takes as argument a comparable array and two indexes to swap it swaps the
   * items in the indexes passes as arguments in the aray itself.
   * @param array
   * @param i
   * @param j
   */
  @SuppressWarnings({ "rawtypes" })
  public static void swap(Comparable[] array, int i, int j) {

    Comparable swap = array[i];
    array[i] = array[j];
    array[j] = swap;
  }

  /**
   * This static method takes a comparable array as input and checks if the items in the array are
   * sorted in the natural order or as defined by the compareTo method. Returns true if items are
   * sorted and false otherwise.
   * @param array
   * @return boolean
   */
  @SuppressWarnings({ "rawtypes" })
  public static boolean isSorted(Comparable[] array) {
    for (int i = 1; i < array.length; i++) {
      if (isLess(array[i], array[i - 1])) return false;
    }
    return true;
  }

  /**
   * This static method takes a comparable array as input and checks if the items in the array
   * between the two passed indices are sorted in the natural order or as defined by the compareTo
   * method. Returns true if items are sorted and false otherwise.
   * @param array
   * @param lo
   * @param hi
   * @return boolean
   */
  @SuppressWarnings({ "rawtypes" })
  public static boolean isSorted(Comparable[] array, int lo, int hi) {
    for (int i = lo + 1; i <= hi; i++) {
      if (isLess(array[i], array[i - 1])) return false;
    }
    return true;
  }

  /**
   * This static method takes a comparable array as input and checks if the items in the array are
   * sorted in the reverse natural order or as defined by the compareTo method. Returns true if
   * items are reverse sorted and false otherwise. This functions exactly opposite to isSorted
   * method
   * @param array
   * @return boolean
   */
  @SuppressWarnings({ "rawtypes" })
  public static boolean isReverseSorted(Comparable[] array) {
    for (int i = 1; i < array.length; i++) {
      if (isLess(array[i - 1], array[i])) return false;
    }
    return true;
  }

  /**
   * This static method takes a comparable array as input and checks if the items between the given
   * indices as arguments in the array are sorted in the reverse natural order or as defined by the
   * compareTo method. Returns true if items are reverse sorted and false otherwise. This functions
   * exactly opposite to isSorted method
   * @param array
   * @param lo
   * @param hi
   * @return boolean
   */
  @SuppressWarnings({ "rawtypes" })
  public static boolean isReverseSorted(Comparable[] array, int lo, int hi) {
    for (int i = lo + 1; i <= hi; i++) {
      if (isLess(array[i - 1], array[i])) return false;
    }
    return true;
  }
}
