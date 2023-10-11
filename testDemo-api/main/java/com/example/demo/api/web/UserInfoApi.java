package com.example.demo.api.web;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "business.testDemo", url = "/testDemo")
public interface UserInfoApi {}
