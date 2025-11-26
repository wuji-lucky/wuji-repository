package com.example.demo.biz.service.impl;

import com.alibaba.fastjson.JSON;
import com.example.demo.api.dto.GoodsInfoDto;
import com.example.demo.api.dto.ShopCartDto;
import com.example.demo.api.exception.BusinessException;
import com.example.demo.api.req.PerGoodReq;
import com.example.demo.api.res.OrderingMenuRes;
import com.example.demo.biz.dao.GoodsInfoRepository;
import com.example.demo.biz.dao.ShopCartInfoRepository;
import com.example.demo.biz.dao.entity.GoodsInfoEntity;
import com.example.demo.biz.service.ScanOrderingService;
import com.example.demo.biz.utils.RedisUtil;
import com.example.demo.biz.validation.annotation.ClearAndReloadCache;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @className: ScanOrderingServiceImpl
 * @author: 吴吉
 * @description: 扫码点餐小程序接口服务
 * @date: 2024/1/26 15:41
 * @version: 1.0
 */
@Service
public class ScanOrderingServiceImpl implements ScanOrderingService {
  private static final Logger logger = LogManager.getLogger("ScanOrderingServiceImplLog");

  @Autowired GoodsInfoRepository goodsInfoRepository;
  @Autowired ShopCartInfoRepository shopCartInfoRepository;
  @Autowired RedisUtil redisUtil;

  /** 功能：扫码查询进入小程序菜单主页（可能存在多人同时扫码并进行添加菜品或删减菜品） */
  @Override
  public OrderingMenuRes getOrderingMenu(String tableId) {
    System.out.println("*****开始执行扫码查询进入小程序菜单主页 代码程序*****");
    if (StringUtils.isBlank(tableId)) {
      throw new BusinessException("餐桌号不能为空");
    }

    // 查询所有菜品清单
    OrderingMenuRes orderingMenuRes = new OrderingMenuRes();
    // 1、如果有缓存先读取缓存
    try {
      String orderingMenuResStr = redisUtil.get(tableId);
      if (StringUtils.isNotBlank(orderingMenuResStr)) {
        orderingMenuRes = JSON.parseObject(orderingMenuResStr, OrderingMenuRes.class);
      } else {
        // 2、没有缓存则查询数据库
        List<GoodsInfoDto> goodsInfoDtoList = new ArrayList<>();
        Optional.ofNullable(goodsInfoRepository.findAll())
                .orElseGet(ArrayList::new)
                .forEach(
                        (GoodsInfoEntity goodsInfoEntity) -> {
                          GoodsInfoDto goodsInfoDto = new GoodsInfoDto();
                          BeanUtils.copyProperties(goodsInfoEntity, goodsInfoDto);
                          goodsInfoDtoList.add(goodsInfoDto);
                        });

        // 查询当前购物车菜品数量
        Integer shopCartGoodsNum =
                Optional.ofNullable(shopCartInfoRepository.getTotalNumByTableId(tableId)).orElse(0);

        orderingMenuRes.setGoodsInfoDtos(goodsInfoDtoList);
        orderingMenuRes.setShopCartGoodsNum(shopCartGoodsNum);
      }
    } catch (Exception e) {
      logger.error("进入小程序菜单发生错误",e);
    }

    return orderingMenuRes;
  }

  /** 添加菜品到当前购物车 */
  @Override
  @ClearAndReloadCache(delayMillisSecond = 50000) // 延时双删
  public String addToShopCart(PerGoodReq perGoodReq) {
    String tableId = perGoodReq.getTableId();
    // 1、查询购物车缓存最新的记录，缓存查不到则查询数据库;
    String shopCartDtoStr = redisUtil.get(tableId);
    if (StringUtils.isNotBlank(shopCartDtoStr)) {
      // 表里面还没有这个数据结构，后续应该用这个数据结构并删除shopCartInfo那个结构
      ShopCartDto shopCartDto = JSON.parseObject(shopCartDtoStr, ShopCartDto.class);
    } else {

    }

    String goodsId = perGoodReq.getGoodsId();
    return "";
  }
}
