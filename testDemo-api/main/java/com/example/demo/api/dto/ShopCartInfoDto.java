package com.example.demo.api.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @className: ShopCartInfoDto
 * @author: 吴吉
 * @description: 购物车信息表对象类
 * @date: 2024/1/26 10:13
 * @version: 1.0
 */
public class ShopCartInfoDto {
  /** 购物车id */
  private String shopCartId;
  /** 桌号 */
  private String tableId;
  /** 商品id */
  private String goodsId;
  /** 商品数量 */
  private Integer goodsNum;
  /** 相同商品价格之和 */
  private BigDecimal goodsPrice;
  /** 是否提交：1-是，0-否 */
  private Integer submitFlag;
  /** 创建时间 */
  private Date createTime;
  /** 创建者 */
  private String createBy;
  /** 最新更新时间 */
  private Date updateTime;
  /** 最新更新者 */
  private String updateBy;

  public String getShopCartId() {
    return shopCartId;
  }

  public void setShopCartId(String shopCartId) {
    this.shopCartId = shopCartId;
  }

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

  public Integer getSubmitFlag() {
    return submitFlag;
  }

  public void setSubmitFlag(Integer submitFlag) {
    this.submitFlag = submitFlag;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public String getCreateBy() {
    return createBy;
  }

  public void setCreateBy(String createBy) {
    this.createBy = createBy;
  }

  public Date getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }

  public String getUpdateBy() {
    return updateBy;
  }

  public void setUpdateBy(String updateBy) {
    this.updateBy = updateBy;
  }
}
