package com.example.demo.api.dto;

import java.math.BigDecimal;

/**
 * @className: PerGoodDto
 * @author: 吴吉
 * @description: TODO
 * @date: 2024/5/15 9:14
 * @version: 1.0
 */
public class PerGoodDto {
  private String tableId;

  private String goodsId;

  private String goodsName;

  private Integer goodsNum;

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
