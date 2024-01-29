package com.example.demo.biz.controller;

import com.example.demo.api.res.OrderingMenuRes;
import com.example.demo.api.web.ScanOrderingApi;
import com.example.demo.biz.service.ScanOrderingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @className: ScanOrderingController
 * @author: 吴吉
 * @description: 扫码点餐小程序接口服务控制层
 * @date: 2024/1/26 14:28
 * @version: 1.0
 */
@RestController
@RequestMapping("/myDemo")
public class ScanOrderingController implements ScanOrderingApi {

  @Autowired private ScanOrderingService scanOrderingService;

  /** 扫码查询进入小程序菜单主页 */
  @Override
  public OrderingMenuRes getOrderingMenu(String tableId) {
    return scanOrderingService.getOrderingMenu(tableId);
  }
}
