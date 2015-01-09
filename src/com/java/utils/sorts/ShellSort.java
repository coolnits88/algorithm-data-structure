package com.java.utils.sorts;

import com.java.utils.SortUtils;

public class ShellSort extends SortUtils {
  int N, h = 1;

  @SuppressWarnings("rawtypes")
  public void sort(Comparable[] a) {
    // TODO Auto-generated method stub
    N = a.length;

    while (h < N / 3)
      h = 3 * h + 1;

    while (h >= 1) {
      for (int i = h; i < N; i++) {
        for (int j = i; j >= h && isLess(a[j], a[j - h]); j -= h) {
          swap(a, j, j - h);
        }

      }
      h = h / 3;
    }
  }

}
