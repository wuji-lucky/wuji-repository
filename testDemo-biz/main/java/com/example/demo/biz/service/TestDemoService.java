package com.example.demo.biz.service;

import com.example.demo.api.dto.UserInfoDto;
import org.springframework.data.domain.PageImpl;

public interface TestDemoService {

  /** 查询用户信息 */
  UserInfoDto queryUserInfo(String uuid);

  /** 分页查询用户信息 */
  PageImpl<UserInfoDto> pageQueryUserInfoByUserName(String userName, int pageNumber, int pageSize);

  /** 保存用户信息 */
  String saveUserInfo(UserInfoDto userInfoDto);
}
