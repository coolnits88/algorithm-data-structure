package com.java.utils.ds;

import java.util.Random;

import com.java.utils.SortUtils;

/**
 * This class implements shuffle functionality. Given an array shuffles it in place. Uses a random
 * function to randomly swap the items in array.
 * @author nitin
 */
public class Shuffle extends SortUtils {

  public Shuffle() {
    // TODO Auto-generated constructor stub
  }

  /**
   * This class implements shuffle functionality. Given an array shuffles it in place. Uses a random
   * function to randomly swap the items in array.
   * @param a
   */

  @SuppressWarnings("rawtypes")
  public static void shuffle(Comparable[] a) {
    Random rand = new Random();
    int i, j, N = a.length;
    for (i = 1; i <= N; i++) {

      j = rand.nextInt(i);
      swap(a, i - 1, j);
    }
  }

}
