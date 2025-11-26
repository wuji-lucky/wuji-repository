package com.example.demo.api.res;

import com.example.demo.api.req.PerGoodReq;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @className: ShopCartRes
 * @author: 吴吉
 * @description: 添加购物车后回显所需要的反参大对象
 * @date: 2024/2/2 17:37
 * @version: 1.0
 */
public class ShopCartRes {

  @ApiModelProperty(name = "tableId", value = "桌号")
  private String tableId;

  @ApiModelProperty(name = "perGoodReqList", value = "购物车中单个商品信息")
  private List<PerGoodReq> perGoodReqList;

  public String getTableId() {
    return tableId;
  }

  public void setTableId(String tableId) {
    this.tableId = tableId;
  }

  public List<PerGoodReq> getPerGoodReqList() {
    return perGoodReqList;
  }

  public void setPerGoodReqList(List<PerGoodReq> perGoodReqList) {
    this.perGoodReqList = perGoodReqList;
  }
}
