package com.example.demo.api.dto;

import java.util.List;

/**
 * @className: ShopCartReq
 * @author: 吴吉
 * @description: 添加购物车大对象
 * @date: 2024/2/2 17:03
 * @version: 1.0
 */
public class ShopCartDto {

  /** 桌号 */
  private String tableId;

  /** 购物车中单个商品信息 */
  private List<PerGoodDto> perGoodDtoList;

  public String getTableId() {
    return tableId;
  }

  public void setTableId(String tableId) {
    this.tableId = tableId;
  }

  public List<PerGoodDto> getPerGoodDtoList() {
    return perGoodDtoList;
  }

  public void setPerGoodDtoList(List<PerGoodDto> perGoodDtoList) {
    this.perGoodDtoList = perGoodDtoList;
  }
}
