package com.example.demo.api.validation;

import com.example.demo.api.exception.ValidateException;
import com.example.demo.api.validation.annotation.CheckMobileNo;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/** 自定义校验器 */
public class MobileNoValidator implements ConstraintValidator<CheckMobileNo, String> {
  // 是否强制校验
  private boolean required;

  @Override
  public void initialize(CheckMobileNo constraintAnnotation) {
    // 初始化校验器
    this.required = constraintAnnotation.required();
  }

  @Override
  public boolean isValid(String mobileNo, ConstraintValidatorContext constraintValidatorContext) {
    // 执行校验逻辑
    if (StringUtils.isBlank(mobileNo)) {
      return true;
    }

    if (required) {
      if (Pattern.matches("^1([38]\\d|5[0-35-9]|7[3678])\\d{8}$", mobileNo)) {
        return true;
      } else {
        List<String> errorMessages = new ArrayList<>();
        errorMessages.add(
            constraintValidatorContext
                .getDefaultConstraintMessageTemplate()); // 将自定义报错提示信息赋值给异常提示信息
        throw new ValidateException(errorMessages);
      }
    }
    return true;
  }
}
