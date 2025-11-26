package com.example.demo.biz.validation.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @description: 延时双删切面注解
 * @author: wuji
 * @date: 2024/2/1 11:07
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ClearAndReloadCache {
  String key() default "";

  int delayMillisSecond() default 1000;
}
