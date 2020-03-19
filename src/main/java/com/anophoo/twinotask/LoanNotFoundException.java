package com.anophoo.twinotask;

public class LoanNotFoundException extends RuntimeException {
  public LoanNotFoundException(String message, Throwable cause) {
    super(message, cause);
  }
}
