package com.java.utils.sorts;

import com.java.utils.SortUtils;

public class InsertionSort extends SortUtils implements Sort {
  public static int DEFAULT_SIZE = 10;

  /**
   * Function override for default method sort declared in Sort interface
   */
  @Override
  @SuppressWarnings({ "rawtypes" })
  public void sort(Comparable[] a) {
    int i, j;

    for (i = 0; i < a.length; i++) {
      for (j = i; j > 0; j--) {
        if (isLess(a[j], a[j - 1])) swap(a, j, j - 1);
        else break;
      }

    }

  }
}
