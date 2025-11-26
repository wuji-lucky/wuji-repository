package com.example.demo.biz.service.impl;

import com.example.demo.api.dto.GoodsInfoDto;
import com.example.demo.biz.dao.GoodsInfoRepository;
import com.example.demo.biz.dao.entity.GoodsInfoEntity;
import com.example.demo.biz.service.OrderServiceManageService;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @className: OrderServiceManageServiceImpl
 * @author: 吴吉
 * @description: 点餐服务管理接口服务实现层
 * @date: 2024/1/29 10:56
 * @version: 1.0
 */
@Service
public class OrderServiceManageServiceImpl implements OrderServiceManageService {
  private static final Logger logger = LogManager.getLogger("OrderServiceManageServiceImplLog");

  private final GoodsInfoRepository goodsInfoRepository;

  public OrderServiceManageServiceImpl(GoodsInfoRepository goodsInfoRepository) {
    this.goodsInfoRepository = goodsInfoRepository;
  }

    /**
   * @description: 菜品添加或更新
   * @author: wuji
   * @date: 2024/1/29 11:08
   * @param: [goodsInfoDto]
   * @return: String
   */
  @Override
  public String goodsAddOrUpdate(GoodsInfoDto goodsInfoDto) {
    if (null == goodsInfoDto) {
      return "入参不允许为空！";
    }

    String goodsId = goodsInfoDto.getGoodsId();
    GoodsInfoEntity goodsInfoEntity = new GoodsInfoEntity();
    if (StringUtils.isNotBlank(goodsId)) { // 主键不为空则还需进一步判断是否是数据更新
      // 先判断该条商品是否存在，存在即更新，不存在即新增
      GoodsInfoEntity goodsInfoEntityTmp = goodsInfoRepository.findByGoodsId(goodsId);
      if (null == goodsInfoEntityTmp) {
        goodsInfoDto.setGoodsId(UUID.randomUUID().toString().replace("-", ""));
      }
    } else {
      goodsInfoDto.setGoodsId(UUID.randomUUID().toString().replace("-", ""));
    }

    BeanUtils.copyProperties(goodsInfoDto, goodsInfoEntity);
    goodsInfoRepository.save(goodsInfoEntity);
    return "200";
  }
}
