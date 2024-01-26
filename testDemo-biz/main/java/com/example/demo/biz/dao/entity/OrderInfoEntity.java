package com.example.demo.biz.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @className: OrderInfoEntity
 * @author: 吴吉
 * @description: 订单信息实体类
 * @date: 2024/1/25 16:01
 * @version: 1.0
 */
@Entity
public class OrderInfoEntity {
  /** 订单id */
  @Id
  @Column(name = "order_id")
  private String orderId;

  /** 桌号 */
  @Column(name = "table_id")
  private String tableId;

  /** 就餐人数 */
  @Column(name = "customer_num")
  private Integer customerNum;

  /** 订单总金额 */
  @Column(name = "total_amount")
  private BigDecimal totalAmount;

  /** 订单是否结束 */
  @Column(name = "end_flag")
  private Integer endFlag;

  /** 订单结账支付时间 */
  @Column(name = "pay_time")
  private Date payTime;

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
