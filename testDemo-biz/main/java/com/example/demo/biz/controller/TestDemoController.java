package com.example.demo.biz.controller;

import com.example.demo.api.dto.UserInfoDto;
import com.example.demo.api.web.TestDemoApi;
import com.example.demo.biz.service.TestDemoService;
import org.springframework.data.domain.PageImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/myDemo")
public class TestDemoController implements TestDemoApi {
    private final TestDemoService testDemoService;

    public TestDemoController(TestDemoService testDemoService) {
        this.testDemoService = testDemoService;
    }

    @Override
    public UserInfoDto queryUserInfo(String uuid) {
        return testDemoService.queryUserInfo(uuid);
    }

    @Override
    public PageImpl<UserInfoDto> pageQueryUserInfoByUserName(
            String userName, int pageNumber, int pageSize) {
        return testDemoService.pageQueryUserInfoByUserName(userName, pageNumber, pageSize);
    }

    @Override
    public String saveUserInfo(UserInfoDto userInfoDto) {
        return testDemoService.saveUserInfo(userInfoDto);
    }
}
