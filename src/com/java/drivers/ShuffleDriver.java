package com.java.drivers;

import com.java.utils.ds.Shuffle;

public class ShuffleDriver {

  public ShuffleDriver() {
    // TODO Auto-generated constructor stub
  }

  public static void main(String[] args) {

    int i, j, count = 0, NUM_DECK = 52;
    char[] SUIT = { 'D', 'C', 'S', 'H' };
    String[] DECK = new String[NUM_DECK];
    String CARD = null;

    for (i = 1; i <= 4; i++) {
      for (j = 1; j <= NUM_DECK / 4; j++) {

        CARD = j + "-" + SUIT[i - 1];

        DECK[count++] = CARD;
      }
    }
    Shuffle.shuffle(DECK);
    System.out.println("----");
    for (i = 0; i < NUM_DECK; i++)
      System.out.println(DECK[i]);

  }
}
