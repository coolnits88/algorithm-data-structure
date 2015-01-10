package com.java.utils.sorts;

import com.java.utils.SortUtils;

/**
 * Java implementation for Merge sort
 * @author nitin
 */
public class MergeSort extends SortUtils {

  private static int DEFAULT_CUTOFF = 70;

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

    for (int k = lo; k <= hi; k++)
      aux[k] = a[k];

    int i = lo, j = mid + 1;

    for (int k = lo; k <= hi; k++) {

      if (i > mid) {
        a[k] = aux[j++];
      } else if (j > hi) {
        a[k] = aux[i++];
      } else if (isLess(aux[j], aux[i])) {
        a[k] = aux[j++];
      } else {
        a[k] = aux[i++];
      }

    }
  }

  /**
   * Sort function implementing sorting for merger Sort algorithm. This is a recursive method which
   * sorts the provided array using divide and conquer method by splitting given array into two sub
   * arrays to sort them and finally merging the two sub arrays. Current code does not uses array
   * switching during recursive calls to save on array copy.
   * @param a
   * @param aux
   * @param lo
   * @param hi
   * @param CUTOFF
   */
  @SuppressWarnings("rawtypes")
  private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi, int CUTOFF) {

    if (hi <= lo) return; // Return in case of single item . No need to sort.

    // if (hi <= lo + CUTOFF - 1) InsertionSort.sort(a, lo, hi);

    int mid = lo + (hi - lo) / 2;

    sort(a, aux, lo, mid, CUTOFF);
    sort(a, aux, mid + 1, hi, CUTOFF);

    /*
     * return if last item in lower sub array is less than lowest element of higher sub array. No
     * need for merge complete array is already sorted
     */
    // if (!isLess(a[mid + 1], a[mid])) {
    // return;
    // }

    // else merge
    merge(a, aux, lo, mid, hi);

  }

  /**
   * Default sort method to sort complete array using merge sort. Only takes one argument of array
   * to be sorted. Uses default cutoff of 7 items to switch to insertion sort algorithm
   * @param array
   */
  @SuppressWarnings("rawtypes")
  public static void sort(Comparable[] array) {
    sort(array, DEFAULT_CUTOFF);

  }

  /**
   * Default sort method to sort complete array using merge sort.Takes two arguments the array to be
   * sorted and cutoff to switch to insertion sort for smaller sub arrays
   * @param array
   * @param cutoff
   */
  @SuppressWarnings("rawtypes")
  public static void sort(Comparable[] array, int cutoff) {
    int N = array.length;
    Comparable[] aux = new Comparable[N];
    sort(array, aux, 0, N - 1, cutoff);

  }

}
