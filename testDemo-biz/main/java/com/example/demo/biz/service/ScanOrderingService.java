package com.example.demo.biz.service;

import com.example.demo.api.res.OrderingMenuRes;

/** 扫码点餐小程序接口服务 */
public interface ScanOrderingService {

  /** 扫码查询进入小程序菜单主页 */
  OrderingMenuRes getOrderingMenu(String tableId);
}
