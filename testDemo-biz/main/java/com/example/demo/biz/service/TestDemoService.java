package com.example.demo.biz.service;

import com.example.demo.api.dto.UserInfoDto;

public interface TestDemoService {

    /**
     * 查询用户信息
    * */
    UserInfoDto queryUserInfo(String uuid);


    /**
     * 保存用户信息
     * */
    String saveUserInfo(UserInfoDto userInfoDto);
}
