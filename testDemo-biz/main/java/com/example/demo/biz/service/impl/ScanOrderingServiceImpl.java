package com.example.demo.biz.service.impl;

import com.example.demo.api.dto.GoodsInfoDto;
import com.example.demo.api.exception.BusinessException;
import com.example.demo.api.res.OrderingMenuRes;
import com.example.demo.biz.dao.GoodsInfoRepository;
import com.example.demo.biz.dao.ShopCartInfoRepository;
import com.example.demo.biz.dao.entity.GoodsInfoEntity;
import com.example.demo.biz.service.ScanOrderingService;
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

  @Autowired private GoodsInfoRepository goodsInfoRepository;
  @Autowired private ShopCartInfoRepository shopCartInfoRepository;

  /** 功能：扫码查询进入小程序菜单主页 */
  @Override
  public OrderingMenuRes getOrderingMenu(String tableId) {
    if (StringUtils.isBlank(tableId)) {
      throw new BusinessException("餐桌号不能为空");
    }

    // 查询所有菜品清单
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

    OrderingMenuRes orderingMenuRes = new OrderingMenuRes();
    orderingMenuRes.setGoodsInfoDtos(goodsInfoDtoList);
    orderingMenuRes.setShopCartGoodsNum(shopCartGoodsNum);

    return orderingMenuRes;
  }
}
