package com.example.demo.api.exception;

/** 自定义异常-业务异常 */
public class BusinessException extends RuntimeException {
  private String errorMessage;

  public BusinessException(String errorMessage) {
    this.errorMessage = errorMessage;
  }

  public String getErrorMessage() {
    return errorMessage;
  }
}
