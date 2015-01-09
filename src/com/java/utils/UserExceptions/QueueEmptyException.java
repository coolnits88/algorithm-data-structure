package com.java.utils.UserExceptions;

public class QueueEmptyException extends RuntimeException {

  /**
   * For internal reference. System generated serial version UID
   */
  private static final long serialVersionUID = -3521853243815539806L;
  public static String DEFAULT_MSG = "There are no elements present in the current Queue instance";

  /**
   * Default constructor calls constructor with default arguments
   */

  public QueueEmptyException() {
    this(DEFAULT_MSG);
  }

  /**
   * Constructor calls constructor of super class RuntimeException with default arguments or
   * arguments passed
   */
  public QueueEmptyException(String msg) {
    super(msg == DEFAULT_MSG ? DEFAULT_MSG : msg + "\n" + DEFAULT_MSG);

  }

}
