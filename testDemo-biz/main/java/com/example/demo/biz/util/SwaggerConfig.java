package com.example.demo.biz.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration // 表示这是一个配置类
@EnableSwagger2 // 用于启用Swagger支持。它会自动扫描并配置Swagger相关的Bean
public class SwaggerConfig implements WebMvcConfigurer {

  @Bean // 用于启用Swagger支持。它会自动扫描并配置Swagger相关的Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2)
        .select() // 选择要生成Api文档的接口
        .apis(
            RequestHandlerSelectors.basePackage(
                "com.example.demo.biz.controller")) // 指定扫描controller包,这就意味着只有该包及其子包下的控制器类才会被包含并生成在Api文档中
        .paths(PathSelectors.any()) // 匹配所有的Api路径
        .build() // 构建Docket对象
        .apiInfo(apiInfo()); // 设置Api文档的基本信息
  }

  private ApiInfo apiInfo() {
    return new ApiInfoBuilder()
        .title("Swagger接口文档")
        .description("TestDemo的Swagger接口文档")
        .version("1.1.0")
        .build();
  }
}
