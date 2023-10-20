package com.example.demo.api.web;

import com.example.demo.api.dto.UserInfoDto;
import io.swagger.annotations.Api;
import org.springframework.data.domain.PageImpl;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Api(value = "测试接口服务", tags = "UI:测试接口服务")
public interface TestDemoApi {

  @ResponseBody
  @GetMapping("/demoApi/queryUserInfo")
  UserInfoDto queryUserInfo(@RequestParam(value = "uuid") String uuid);

  @ResponseBody
  @GetMapping("/demoApi/pageQueryUserInfoByUserName")
  PageImpl<UserInfoDto> pageQueryUserInfoByUserName(
      @RequestParam(value = "userName") String userName,
      @RequestParam(value = "pageNumber") int pageNumber,
      @RequestParam(value = "pageSize") int pageSize);

  @ResponseBody
  @PostMapping("/demoApi/saveUserInfo")
  String saveUserInfo(@RequestBody @Validated UserInfoDto userInfoDto);
}
