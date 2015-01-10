package com.java.utils.sorts;

import com.java.utils.SortUtils;

public class BottomUpMergeSort extends SortUtils {

  /**
   * Merge function to merge two sorted sub arrays of the array "a" passed as argument. a : array to
   * be sorted. aux: internal copy array used for merging lo lower bound index, hi: high bound index
   * , mid: middle index to split array into two sub arrays
   * @param a
   * @param aux
   * @param lo
   * @param mid
   * @param hi
   */

  @SuppressWarnings("rawtypes")
  private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {

    assert isSorted(a, lo, mid);
    assert isSorted(a, mid + 1, hi);

    /*
     * comment below loop if arrays switching is used between recursive calls.
     */
    for (int k = lo; k <= hi; k++) {
      aux[k] = a[k]; // copy elements
    }

    int i = lo, j = mid + 1;
    for (int k = lo; k <= hi; k++) {

      if (i > mid) a[k] = aux[j++];
      else if (j > hi) a[k] = aux[i++];
      else if (isLess(aux[j], aux[i])) a[k] = aux[j++];
      else a[k] = aux[i++];

    }
    assert isSorted(a, lo, hi);
  }

  /**
   * Default sort method to sort complete array using merge sort.
   * @param array
   * @param cutoff
   */
  @SuppressWarnings("rawtypes")
  public static void sort(Comparable[] array) {
    int N = array.length;
    Comparable[] aux = new Comparable[N];
    for (int sz = 1; sz < N; sz += sz)
      for (int lo = 0; lo < N - sz; lo += sz + sz)
        merge(array, aux, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, N - 1));

  }

}
