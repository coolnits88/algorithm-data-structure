package com.java.utils.UserExceptions;

public class StackEmptyException extends RuntimeException {

  /**
   * For internal reference. System generated serial version UID
   */
  private static final long serialVersionUID = -8249606527378651618L;

  public static String DEFAULT_MSG = "There are no elements present in the current Stack instance";

  /**
   * Default constructor calls constructor with default arguments
   */

  public StackEmptyException() {
    this(DEFAULT_MSG);
  }

  /**
   * Constructor calls constructor of super class RuntimeException with default arguments or
   * arguments passed
   */
  public StackEmptyException(String msg) {
    super(msg == DEFAULT_MSG ? DEFAULT_MSG : msg + "\n" + DEFAULT_MSG);

  }

}
