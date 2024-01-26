package com.example.demo.api.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @className: GoodsInfoDto
 * @author: 吴吉
 * @description: 商品信息对象类
 * @date: 2024/1/25 15:51
 * @version: 1.0
 */
public class GoodsInfoDto {
  /** 商品id */
  private String goodsId;

  /** 商品分类 */
  private String goodsCategory;

  /** 商品名称 */
  private String goodsName;

  /** 商品单价 */
  private BigDecimal goodsPrice;

  /** 商品图片id */
  private String goodsImgId;

  /** 商品存量状态：1-库存充足，0-已售罄 */
  private Integer goodsStatus;

  /** 商品已售数量 */
  private Integer goodsSalesNum;

  /** 菜品描述 */
  private String goodsComment;

  /** 创建时间 */
  private Date createTime;

  /** 创建者 */
  private String createBy;

  /** 最新更新时间 */
  private Date updateTime;

  /** 最新更新者 */
  private String updateBy;

  public String getGoodsId() {
    return goodsId;
  }

  public void setGoodsId(String goodsId) {
    this.goodsId = goodsId;
  }

  public String getGoodsCategory() {
    return goodsCategory;
  }

  public void setGoodsCategory(String goodsCategory) {
    this.goodsCategory = goodsCategory;
  }

  public String getGoodsName() {
    return goodsName;
  }

  public void setGoodsName(String goodsName) {
    this.goodsName = goodsName;
  }

  public BigDecimal getGoodsPrice() {
    return goodsPrice;
  }

  public void setGoodsPrice(BigDecimal goodsPrice) {
    this.goodsPrice = goodsPrice;
  }

  public String getGoodsImgId() {
    return goodsImgId;
  }

  public void setGoodsImgId(String goodsImgId) {
    this.goodsImgId = goodsImgId;
  }

  public Integer getGoodsStatus() {
    return goodsStatus;
  }

  public void setGoodsStatus(Integer goodsStatus) {
    this.goodsStatus = goodsStatus;
  }

  public Integer getGoodsSalesNum() {
    return goodsSalesNum;
  }

  public void setGoodsSalesNum(Integer goodsSalesNum) {
    this.goodsSalesNum = goodsSalesNum;
  }

  public String getGoodsComment() {
    return goodsComment;
  }

  public void setGoodsComment(String goodsComment) {
    this.goodsComment = goodsComment;
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
