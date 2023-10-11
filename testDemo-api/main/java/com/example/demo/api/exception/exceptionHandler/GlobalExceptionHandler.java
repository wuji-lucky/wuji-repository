package com.example.demo.api.exception.exceptionHandler;

import com.example.demo.api.exception.ValidateException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(ValidateException.class)
  public ResponseEntity<String> handleValidationException(ValidateException ex) {
    List<String> errorMessages = ex.getErrorMessages();
    String errorMessage = String.join(", ", errorMessages);
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
  }
}
