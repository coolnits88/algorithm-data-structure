package com.java.utils.UserExceptions;

public class QueueFullException extends RuntimeException {
  /**
   * For internal reference. System generated serial version UID
   */
  private static final long serialVersionUID = 3331158004422861091L;

  public static String DEFAULT_MSG =
      "\nQueue Full: No elements can be added to the current Queue instance";

  /**
   * Default constructor calls constructor with default arguments
   */

  public QueueFullException() {
    this(DEFAULT_MSG);
  }

  /**
   * Constructor calls constructor of super class RuntimeException with default arguments or
   * arguments passed
   */
  public QueueFullException(String msg) {
    super(msg == DEFAULT_MSG ? DEFAULT_MSG : msg + "\n" + DEFAULT_MSG);

  }

}
