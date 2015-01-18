package com.java.drivers;

import java.util.Random;

import com.java.utils.ds.BST;

public class BSTDriver {

  public BSTDriver() {
    // TODO Auto-generated constructor stub
  }

  public static void main(String args) {

    BST<String, Integer> bst = new BST<String, Integer>();
    int LIM = 100;
    Random rand = new Random();
    int randint;
    for (int i = 0; i < LIM; i++) {
      randint = rand.nextInt(LIM);
      bst.put("__" + randint + "__", randint);
    }

    for (int i = 0; i < LIM; i++) {
      randint = rand.nextInt(LIM);
      bst.get("__" + randint + "__");

    }
  }

}
