package com.example.demo.api.web;

import com.example.demo.api.dto.UserInfoDto;
import io.swagger.annotations.Api;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Api(value = "测试接口服务", tags = "UI:测试接口服务")
public interface TestDemoApi {

  @ResponseBody
  @GetMapping("/demoApi/queryUserInfo")
  UserInfoDto queryUserInfo(@RequestParam(value = "uuid") String uuid);

  @ResponseBody
  @PostMapping("/demoApi/saveUserInfo")
  String saveUserInfo(@RequestBody @Validated UserInfoDto userInfoDto);
}
