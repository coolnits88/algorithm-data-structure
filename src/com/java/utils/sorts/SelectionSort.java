package com.java.utils.sorts;

import com.java.utils.SortUtils;

public class SelectionSort extends SortUtils implements Sort {
  public static int DEFAULT_SIZE = 10;

  /**
   * Function override for default method sort declared in Sort interface
   */
  @Override
  @SuppressWarnings({ "rawtypes" })
  public void sort(Comparable[] array) {
    int N = array.length;
    int j, min;
    for (int i = 0; i < N; i++) {

      min = i;
      for (j = i + 1; j < N; j++) {
        if (isLess(array[j], array[min])) {
          min = j;
        }
      }

      swap(array, i, min);
    }

  }

}
