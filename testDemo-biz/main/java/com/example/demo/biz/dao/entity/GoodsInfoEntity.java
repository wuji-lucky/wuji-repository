package com.example.demo.biz.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @className: GoodsInfoEntity
 * @author: 吴吉
 * @description: 商品信息实体类
 * @date: 2024/1/25 14:43
 * @version: 1.0
 */
@Entity
public class GoodsInfoEntity {

  /** 商品id */
  @Id
  @Column(name = "goods_id")
  private String goodsId;

  /** 商品分类 */
  @Column(name = "goods_category")
  private String goodsCategory;

  /** 商品名称 */
  @Column(name = "goods_name")
  private String goodsName;

  /** 商品单价 */
  @Column(name = "goods_price")
  private BigDecimal goodsPrice;

  /** 商品图片id */
  @Column(name = "goods_img_id")
  private String goodsImgId;

  /** 商品存量状态：1-库存充足，0-已售罄 */
  @Column(name = "goods_status")
  private Integer goodsStatus;

  /** 商品已售数量 */
  @Column(name = "goods_sales_num")
  private Integer goodsSalesNum;

  /** 菜品描述 */
  @Column(name = "goods_comment")
  private String goodsComment;

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
