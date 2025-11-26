package com.example.demo.api.req;

import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

/**
 * @className: PerGoodReq
 * @author: 吴吉
 * @description: 单个商品信息入参对象
 * @date: 2024/2/2 16:58
 * @version: 1.0
 */
public class PerGoodReq {
  @ApiModelProperty(name = "tableId", value = "桌号")
  private String tableId;

  @ApiModelProperty(name = "goodsId", value = "商品id")
  private String goodsId;

  @ApiModelProperty(name = "goodsName", value = "商品名称")
  private String goodsName;

  @ApiModelProperty(name = "goodsNum", value = "商品添加数量,每次默认数量为+1或-1")
  private Integer goodsNum;

  @ApiModelProperty(name = "goodsPrice", value = "商品单价")
  private BigDecimal goodsPrice;

  public String getTableId() {
    return tableId;
  }

  public void setTableId(String tableId) {
    this.tableId = tableId;
  }

  public String getGoodsId() {
    return goodsId;
  }

  public void setGoodsId(String goodsId) {
    this.goodsId = goodsId;
  }

  public String getGoodsName() {
    return goodsName;
  }

  public void setGoodsName(String goodsName) {
    this.goodsName = goodsName;
  }

  public Integer getGoodsNum() {
    return goodsNum;
  }

  public void setGoodsNum(Integer goodsNum) {
    this.goodsNum = goodsNum;
  }

  public BigDecimal getGoodsPrice() {
    return goodsPrice;
  }

  public void setGoodsPrice(BigDecimal goodsPrice) {
    this.goodsPrice = goodsPrice;
  }
}
