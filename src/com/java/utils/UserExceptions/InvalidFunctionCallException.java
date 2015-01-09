package com.java.utils.UserExceptions;

public class InvalidFunctionCallException extends RuntimeException {

  /**
   * For internal reference. System generated serial version UID
   */
  private static final long serialVersionUID = -8144235166909589577L;

  public static String DEFAULT_MSG = "This an invalid function call for this instance";

  /**
   * Default constructor calls constructor with default arguments
   */
  public InvalidFunctionCallException() {
    this(DEFAULT_MSG);
  }

  /**
   * Constructor calls constructor of super class RuntimeException with default arguments or
   * arguments passed
   */
  public InvalidFunctionCallException(String msg) {
    super(msg == DEFAULT_MSG ? DEFAULT_MSG : msg + "\n" + DEFAULT_MSG);

  }

}
