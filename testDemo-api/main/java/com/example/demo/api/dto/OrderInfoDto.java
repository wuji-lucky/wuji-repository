package com.example.demo.api.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @className: OrderInfoDto
 * @author: 吴吉
 * @description: 订单信息对象类
 * @date: 2024/1/25 16:08
 * @version: 1.0
 */
public class OrderInfoDto {
  /** 订单id */
  private String orderId;

  /** 桌号 */
  private String tableId;

  /** 就餐人数 */
  private Integer customerNum;

  /** 订单总金额 */
  private BigDecimal totalAmount;

  /** 订单是否结束 */
  private Integer endFlag;

  /** 订单结账支付时间 */
  private Date payTime;

  /** 创建时间 */
  private Date createTime;

  /** 创建者 */
  private String createBy;

  /** 最新更新时间 */
  private Date updateTime;

  /** 最新更新者 */
  private String updateBy;

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

  public Integer getCustomerNum() {
    return customerNum;
  }

  public void setCustomerNum(Integer customerNum) {
    this.customerNum = customerNum;
  }

  public BigDecimal getTotalAmount() {
    return totalAmount;
  }

  public void setTotalAmount(BigDecimal totalAmount) {
    this.totalAmount = totalAmount;
  }

  public Integer getEndFlag() {
    return endFlag;
  }

  public void setEndFlag(Integer endFlag) {
    this.endFlag = endFlag;
  }

  public Date getPayTime() {
    return payTime;
  }

  public void setPayTime(Date payTime) {
    this.payTime = payTime;
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
