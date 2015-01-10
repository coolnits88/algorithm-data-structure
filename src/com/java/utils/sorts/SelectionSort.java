package com.java.utils.sorts;

import com.java.utils.SortUtils;

public class SelectionSort extends SortUtils {
  /**
   * Static function to implement Selection sort. It sorts the array passed as argument in place.
   * Only elements between indexes lo and hi (both inclusive) passed as arguments are sorted
   * @param array
   * @param lo
   * @param hi
   */
  @SuppressWarnings({ "rawtypes" })
  public static void sort(Comparable[] array, int lo, int hi) {

    int j, min;
    for (int i = lo; i <= hi; i++) {

      min = i;
      for (j = i + 1; j <= hi; j++) {
        if (isLess(array[j], array[min])) {
          min = j;
        }
      }

      swap(array, i, min);
    }

  }

  /**
   * Default sort function to sort complete array
   * @param array
   */
  @SuppressWarnings("rawtypes")
  public static void sort(Comparable[] array) {
    int N = array.length - 1;
    sort(array, 0, N);

  }
}
