package com.example.demo.api.validation.annotation;

import com.example.demo.api.validation.MobileNoValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME) // 运行时有效
@Target({ElementType.METHOD, ElementType.FIELD}) // 只能运用在方法以及属性上
@Constraint(validatedBy = MobileNoValidator.class) // 添加校验器,主要校验逻辑写在校验器中
@Documented // 是一个元注解,可以被 javadoc 等工具识别生成相应的文档信息,当外部工具调用时可以展示该自定义注解的基本信息
public @interface CheckMobileNo {
  // 是否强制校验，默认是
  boolean required() default true;

  // 该方法是注解的默认成员方法，这里指定默认的校验不通过的返回消息，如果想自定义返回消息，可以用@CheckMobileNo(message="")来指定自定义返回消息;
  String message() default "请输入正确的手机号!!!";

  // 将validator进行分类，不同的类group中会执行不同的validator操作;返回的是validator的分类类型
  Class<?>[] groups() default {};

  // 主要是针对bean，很少使用;返回的是负载
  Class<? extends Payload>[] payload() default {};
}
