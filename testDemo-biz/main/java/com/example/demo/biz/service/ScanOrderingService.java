package com.example.demo.biz.service;

import com.example.demo.api.req.PerGoodReq;
import com.example.demo.api.res.OrderingMenuRes;

/** 扫码点餐小程序接口服务 */
public interface ScanOrderingService {

  /** 扫码查询进入小程序菜单主页 */
  OrderingMenuRes getOrderingMenu(String tableId);

  /** 添加菜品到当前购物车 */
  String addToShopCart(PerGoodReq perGoodReq);
}
