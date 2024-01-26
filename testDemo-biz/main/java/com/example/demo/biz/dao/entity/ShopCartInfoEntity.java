package com.example.demo.biz.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * @className: ShopCartInfoEntity
 * @author: 吴吉
 * @description: 购物车信息表实体类
 * @date: 2024/1/26 9:31
 * @version: 1.0
 */
@Entity
public class ShopCartInfoEntity {
  /** 购物车id */
  @Id
  @Column(name = "shop_cart_id")
  private String shopCartId;

  /** 订单id */
  @Column(name = "order_id")
  private String orderId;

  /** 桌号 */
  @Column(name = "table_id")
  private String tableId;

  /** 商品id */
  @Column(name = "goods_id")
  private String goodsId;

  /** 商品数量 */
  @Column(name = "goods_num")
  private Integer goodsNum;

  /** 是否提交：1-是，0-否 */
  @Column(name = "submit_flag")
  private Integer submitFlag;

  /** 创建时间 */
  @Column(name = "create_time")
  private Date createTime;

  /** 创建者 */
  @Column(name = "create_by")
  private String createBy;

  /** 最新更新时间 */
  @Column(name = "update_time")
  private Date updateTime;

  /** 最新更新者 */
  @Column(name = "update_by")
  private String updateBy;

  public String getShopCartId() {
    return shopCartId;
  }

  public void setShopCartId(String shopCartId) {
    this.shopCartId = shopCartId;
  }

  public String getOrderId() {
    return orderId;
  }

  public void setOrderId(String orderId) {
    this.orderId = orderId;
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
