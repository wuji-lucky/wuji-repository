package com.example.demo.api.dto;

import java.util.Date;

/**
 * @className: OrderDetailInfoDto
 * @author: 吴吉
 * @description: 订单详情表对象类
 * @date: 2024/1/26 9:17
 * @version: 1.0
 */
public class OrderDetailInfoDto {
  /** 订单详情id */
  private String orderDetailId;

  /** 订单id（订单表主键） */
  private String orderId;

  /** 订单序号 */
  private Integer serialNo;

  /** 商品id */
  private String goodsId;

  /** 商品数量 */
  private Integer goodsNum;

  /** 该次订单提交者 */
  private String submitUser;

  /** 创建时间 */
  private Date createTime;

  /** 创建者 */
  private String createBy;

  /** 最新更新时间 */
  private Date updateTime;

  /** 最新更新者 */
  private String updateBy;

  public String getOrderDetailId() {
    return orderDetailId;
  }

  public void setOrderDetailId(String orderDetailId) {
    this.orderDetailId = orderDetailId;
  }

  public String getOrderId() {
    return orderId;
  }

  public void setOrderId(String orderId) {
    this.orderId = orderId;
  }

  public Integer getSerialNo() {
    return serialNo;
  }

  public void setSerialNo(Integer serialNo) {
    this.serialNo = serialNo;
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

  public String getSubmitUser() {
    return submitUser;
  }

  public void setSubmitUser(String submitUser) {
    this.submitUser = submitUser;
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
