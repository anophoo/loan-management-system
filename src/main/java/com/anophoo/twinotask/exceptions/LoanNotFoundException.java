package com.anophoo.twinotask.exceptions;

public class LoanNotFoundException extends RuntimeException {
  public LoanNotFoundException(String message, Throwable cause) {
    super(message, cause);
  }
}
