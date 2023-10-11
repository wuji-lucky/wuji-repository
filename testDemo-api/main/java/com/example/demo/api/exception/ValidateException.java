package com.example.demo.api.exception;

import java.util.List;

/** 这是一个自定义异常类 */
public class ValidateException extends RuntimeException {
  private List<String> errorMessages;

  // 是一个构造方法，用于创建 ValidationException 类的实例。它接受一个 String 类型的 List 参数 errorMessages，并将其赋值给类的成员变量
  // this.errorMessages。通常，这个构造方法用于在创建 ValidationException 对象时传递错误消息列表。
  public ValidateException(List<String> errorMessages) {
    this.errorMessages = errorMessages;
  }

  public List<String> getErrorMessages() {
    return errorMessages;
  }
}
