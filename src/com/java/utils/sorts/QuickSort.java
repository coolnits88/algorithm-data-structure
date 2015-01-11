package com.java.utils.sorts;

import com.java.utils.SortUtils;
import com.java.utils.ds.Shuffle;

public class QuickSort extends SortUtils {

  public static void sort(Comparable[] array) {
    // Shuffle to gurantee optimized performance
    Shuffle.shuffle(array);

    // Call internal sort method for whole array
    sort(array, 0, array.length - 1);
  }

  private static void sort(Comparable[] array, int lo, int hi) {
    if (hi <= lo) return;
    // get the partition point
    int j = partition(array, lo, hi);

    // recursive calls for two sub arrays separated by partition index
    sort(array, lo, j - 1);
    sort(array, j + 1, hi);
  }

  private static int partition(Comparable[] array, int lo, int hi) {
    int i = lo, j = hi + 1;
    while (true) { // wide loop to iterate till true

      // Loop to iterate from left of array till items are less than array[lo]
      // break when item at index i is greater than or equal to array[lo]
      while (isLess(array[++i], array[lo]))
        if (i == hi) break;

      // Loop to iterate from right of array till items are greater than array[lo]
      // break when item at index j is less than or equal to array[lo]
      while (isLess(array[lo], array[--j]))
        if (j == lo) break;

      // Break from outer wide loop if the indexes have crossed each other
      if (i >= j) break;

      // else swap the two items which are out of place.
      // ie. array[i] and array[j] as former value is greater than array[lo] and latter is less than
      // [array[lo]]
      swap(array, i, j);
    }

    // final partition point for array. swap array[lo] and array[j] ie final partition point of
    // array where
    // itmes to left are all smaller than array[lo] and all items to right are greater than
    // array[lo]
    swap(array, lo, j);

    // return partition index
    return j;

  }

  public static void iSort(Comparable[] array) {

    // Call internal sort method for whole array
    sort(array, 0, array.length - 1);
  }

  private static void iSort(Comparable[] array, int lo, int hi) {
    if (hi <= lo) return;

    int pivot_index = lo;
    int pivot_new_index;

    // get the partition point
    pivot_new_index = partition(array, lo, hi, pivot_index);

    // recursive calls for two sub arrays separated by partition index
    sort(array, lo, pivot_new_index - 1);
    sort(array, pivot_new_index + 1, hi);
  }

  @SuppressWarnings("rawtypes")
  private static int partition(Comparable[] array, int lo, int hi, int pivot_index) {
    Comparable pivot_value = array[pivot_index];
    int store_index = lo;
    int i;

    swap(array, pivot_index, hi);
    for (i = lo; i < hi; i++)
      if (!isLess(pivot_value, array[i])) {
        swap(array, i, store_index);
        ++store_index;
      }
    swap(array, store_index, hi);
    return store_index;
  }

}
