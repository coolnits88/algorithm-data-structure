package com.java.utils.sorts;

import com.java.utils.SortUtils;
import com.java.utils.UserExceptions.InvalidIndexException;
import com.java.utils.ds.Shuffle;

/**
 * Class to implements Quick sort algorithm and its applications
 * @author nitin
 */
public class QuickSort extends SortUtils {

  /**
   * Default sort method. Uses randomized default quick sort implementation. Takes only one argument
   * of array to sort. Guarantees performance by randomizing array before sort to prevent quadratic
   * run time in worst case.
   * @param array
   */
  @SuppressWarnings("rawtypes")
  public static void sort(Comparable[] array) {
    // Shuffle to guarantee optimized performance
    Shuffle.shuffle(array);
    int N = array.length - 1;
    // Call internal sort method for whole array
    sort(array, 0, N);
  }

  /**
   * This version of Sort method takes two arguments array to sort and a boolean argument stating if
   * the array has duplicates. When hasDuplicates is set to false it functions as default sort
   * method otherwise it uses randomized three way partitioned implementation of quick sort
   * algorithm.Guarantees performance by randomizing array before sort to prevent quadratic run time
   * in worst case.
   * @param array
   * @param hasDuplicates
   */
  @SuppressWarnings("rawtypes")
  public static void sort(Comparable[] array, boolean hasDuplicates) {
    // Shuffle to guarantee optimized performance
    Shuffle.shuffle(array);
    int N = array.length - 1;
    // Call internal sort method for whole array
    if (hasDuplicates) sortDuplicateKeysArray(array, 0, N);
    else sort(array, 0, N);
  }

  /**
   * Internal sort method to sort array using Quick sort implementation. Takes 3 arguments array to
   * sort , lower and upper bound of sub arrays to sort both indexes are inclusive in sort.
   * @param array
   * @param lo
   * @param hi
   */
  @SuppressWarnings("rawtypes")
  private static void sort(Comparable[] array, int lo, int hi) {
    if (hi <= lo) return;
    // get the partition point
    int j = partition(array, lo, hi);

    // recursive calls for two sub arrays separated by partition index
    sort(array, lo, j - 1);
    sort(array, j + 1, hi);
  }

  /**
   * Internal sort method implementing 3 way partitioned quick sort implementation.
   * @param array
   * @param lo
   * @param hi
   */
  @SuppressWarnings({ "rawtypes", "unchecked" })
  private static void sortDuplicateKeysArray(Comparable[] array, int lo, int hi) {
    if (hi <= lo) return;

    int i = lo, lt = lo, gt = hi, cmp = 0;
    Comparable value = array[lo];
    while (i <= gt) { // wide loop to iterate till true

      // break when index i is equal to index gt (all values to right of gt are greater than
      // partition key)
      cmp = array[i].compareTo(value);

      if (cmp < 0) swap(array, lt++, i++);
      else if (cmp > 0) swap(array, i, gt--);
      else i++;

    }
    sortDuplicateKeysArray(array, lo, lt - 1);
    sortDuplicateKeysArray(array, gt + 1, hi);

  }

  /**
   * Default partition method used by default quick sort implementation method. Returns an index(j)
   * which partitions the given array to two halves. values to left of index(j) are smaller than
   * array[j] and values to right are greater than array[j]. which are again partitioned and sorted
   * recursively.
   * @param array
   * @param lo
   * @param hi
   * @return j
   */
  @SuppressWarnings("rawtypes")
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

  /**
   * Default iSort method. Takes only one argument array to sort and sorts it completely. Uses
   * default text book quick sort implementation.
   * @param array
   */
  @SuppressWarnings("rawtypes")
  public static void iSort(Comparable[] array) {
    int N = array.length - 1;
    // Call internal sort method for whole array
    iSort(array, 0, N);
  }

  /**
   * Internal iSort method. Uses default text book quick sort implementation. Takes argument of
   * array to sort and upper and lower bound(both inclusive) of sub array to sort.
   * @param array
   */

  @SuppressWarnings({ "rawtypes" })
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

  /**
   * Default partition method used by default quick sort implementation method. Returns an index(j)
   * which partitions the given array to two halves. values to left of index(j) are smaller than
   * array[j] and values to right are greater than array[j]. which are again partitioned and sorted
   * recursively.
   * @param array
   * @param lo
   * @param hi
   * @param pivot_index
   * @return
   */
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

  /**
   * Default select method. Returns the Largest item in the array
   * @param array
   * @return
   */
  @SuppressWarnings("rawtypes")
  public static Comparable select(Comparable[] array) {
    int N = array.length - 1;
    return select(array, N);
  }

  /**
   * Select method implementation based on randomized Quick sort partitioning. Returns the kth
   * largest item from the array
   * @param array
   * @param k
   * @return
   * @throws InvalidIndexException
   */
  @SuppressWarnings("rawtypes")
  public static Comparable select(Comparable[] array, int k) throws InvalidIndexException {
    int N = array.length - 1;
    if (k < 0 || k > N) throw new InvalidIndexException("Index passed is out of bounds: " + k
        + " \nAllowed Indexes: " + 0 + " to " + N);

    return select(array, 0, N, k);

  }

  /**
   * INternal select method.Returns Kth largest item between index lo to hi both inclusive.
   * @param array
   * @param lo
   * @param hi
   * @param k
   * @return
   */
  @SuppressWarnings("rawtypes")
  private static Comparable select(Comparable[] array, int lo, int hi, int k) {
    int N = array.length - 1;

    if (k < 0 || k > N) throw new InvalidIndexException("Index passed is out of bounds: " + k
        + " \nAllowed Indexes: " + 0 + " to " + N);

    Shuffle.shuffle(array);
    while (hi > lo) {
      int j = partition(array, lo, hi);
      if (j < k) lo = j + 1;
      else if (j > k) hi = j - 1;
      else return array[k];
    }

    return array[k];
  }

}
