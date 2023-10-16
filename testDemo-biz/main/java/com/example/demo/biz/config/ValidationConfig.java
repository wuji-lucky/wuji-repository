package com.example.demo.biz.config;

import com.example.demo.api.validation.MobileNoValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // 表示这是一个配置类
public class ValidationConfig {
  @Bean // 定义为一个Bean,并由容器进行管理
  public MobileNoValidator mobileNoValidator() {
    return new MobileNoValidator();
  }
}
