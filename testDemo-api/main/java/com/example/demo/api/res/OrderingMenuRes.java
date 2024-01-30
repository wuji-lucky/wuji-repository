package com.example.demo.api.res;

import com.example.demo.api.dto.GoodsInfoDto;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @className: OrderingMenuRes
 * @author: 吴吉
 * @description: 扫码进入点餐主页返回对象
 * @date: 2024/1/26 15:49
 * @version: 1.0
 */
public class OrderingMenuRes {

  /** 菜品清单 */
  @ApiModelProperty(name = "goodsInfoDtos", value = "菜品清单")
  private List<GoodsInfoDto> goodsInfoDtos;

  /** 当前购物车菜品数量 */
  @ApiModelProperty(name = "shopCartGoodsNum", value = "当前购物车菜品数量")
  private Integer shopCartGoodsNum;

  public List<GoodsInfoDto> getGoodsInfoDtos() {
    return goodsInfoDtos;
  }

  public void setGoodsInfoDtos(List<GoodsInfoDto> goodsInfoDtos) {
    this.goodsInfoDtos = goodsInfoDtos;
  }

  public Integer getShopCartGoodsNum() {
    return shopCartGoodsNum;
  }

  public void setShopCartGoodsNum(Integer shopCartGoodsNum) {
    this.shopCartGoodsNum = shopCartGoodsNum;
  }
}
