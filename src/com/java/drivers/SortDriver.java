package com.java.drivers;

import com.java.utils.SortUtils;
import com.java.utils.sorts.QuickSort;

/**
 * This is a driver class for running the different sorts implemented. From the stats seen below
 * Merge sort provides best time based performance , but it uses double space when compared to other
 * sort methods (not optimal space wise). Quick sort using sort() does not uses any extra space and
 * provides Comparable performance. shuffles the array before sort to guarantee performance benefit
 * even in case of reverse sorted array (worst case). iSort() method takes the lowest time and does
 * not uses any extra space as well (Sorts array in place) but with the caveat that the run time
 * will be Quadratic in worst case (Reverse sorted array). Test machine for running tests <Machine>
 * MacBook Pro Ram: 4 GB 1600 MHz DDR3 Processor: 2.5 GHz Intel Core i5 <Machine> All stats are in
 * Milliseconds
 * @author nitin
 */
public class SortDriver extends SortUtils {

  public SortDriver() {
    // TODO Auto-generated constructor stub
  }

  public static void main(String[] args) {

    int LIM = 10000000; // Change value to increase items in array

    /*
     * Array initialization for best case testing. Initialized to sorted
     */

    // Integer[] as = new Integer[LIM];
    // for (int i = 0; i < LIM; i++) {
    // as[i] = (LIM - i);
    // }

    /*
     * Random array initialization for normal case testing
     */
    // Double[] as = new Double[LIM];
    // Random rand = new Random();
    // for (int i = 0; i < LIM; i++)
    // as[i] = rand.nextDouble();

    /*
     * Array initialization for worst case testing. Initialized to reverse sorted
     */
    Integer[] as = new Integer[LIM];
    for (int i = 0; i < LIM; i++) {
      as[i] = (LIM - i);
    }

    System.out.println("Array Sorted before sort : " + isSorted(as));

    // Sort items
    long st = System.currentTimeMillis();
    // BottomUpMergeSort.sort(as);
    // MergeSort.sort(as);
    QuickSort.sort(as);
    // QuickSort.iSort(as);
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
