package com.java.utils.ds;

public class Stack {

  private String[] s;
  public int Size = 0, Capacity = 1;

  private String item;

  public Stack() {
    s = new String[Capacity];
  }

  public boolean isEmpty() {
    return Size == 0;

  }

  public boolean isFull() {
    return Size == Capacity;
  }

  public String pop() {
    if (Size > 0 && Size <= Capacity / 4) {
      resize((Capacity / 2));
    }
    if (isEmpty()) {
      return null;
    }
    System.out.println("popping " + Size);
    item = s[--Size];
    s[Size] = null;
    return item;
  }

  public void push(String item) {
    if (isFull()) {
      resize(2 * Capacity);
    }
    s[Size++] = item;
  }

  private void resize(int newCapacity) {

    String[] st = new String[newCapacity];
    for (int i = 0; i < Size; i++) {
      st[i] = s[i];
    }
    s = st;
    Capacity = newCapacity;
    System.out.println("new Capacity " + Capacity + " size " + Size);
  }

  public int size() {
    return Size;
  }

}
