package com.java.utils.UserExceptions;

public class InvalidIndexException extends RuntimeException {

  /**
   * For internal reference. System generated serial version UID
   */
  private static final long serialVersionUID = -5010330693267944790L;

  public static String DEFAULT_MSG = "Index Argument out of bounds";

  /**
   * Default constructor calls constructor with default arguments
   */

  public InvalidIndexException() {
    this(DEFAULT_MSG);
  }

  /**
   * Constructor calls constructor of super class RuntimeException with default arguments or
   * arguments passed
   */
  public InvalidIndexException(String msg) {
    super(msg == DEFAULT_MSG ? DEFAULT_MSG : msg + "\n" + DEFAULT_MSG);

  }

}
