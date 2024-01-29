package com.example.demo.api.dto;

import java.util.Date;

/**
 * @className: TableInfoDto
 * @author: 吴吉
 * @description: 餐桌管理信息表对象类
 * @date: 2024/1/26 15:10
 * @version: 1.0
 */
public class TableInfoDto {
  /** 桌号 */
  private String tableId;

  /** 二维码id */
  private String code;

  /** 座位数 */
  private Integer seatsNum;

  /** 是否处在服务中：1-服务中，0-空闲中 */
  private Integer inService;

  /** 创建时间 */
  private Date createTime;

  /** 创建者 */
  private String createBy;

  /** 最新更新时间 */
  private Date updateTime;

  /** 最新更新者 */
  private String updateBy;

  public String getTableId() {
    return tableId;
  }

  public void setTableId(String tableId) {
    this.tableId = tableId;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public Integer getSeatsNum() {
    return seatsNum;
  }

  public void setSeatsNum(Integer seatsNum) {
    this.seatsNum = seatsNum;
  }

  public Integer getInService() {
    return inService;
  }

  public void setInService(Integer inService) {
    this.inService = inService;
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
