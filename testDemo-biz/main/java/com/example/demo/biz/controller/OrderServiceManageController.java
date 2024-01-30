package com.example.demo.biz.controller;

import com.example.demo.api.dto.GoodsInfoDto;
import com.example.demo.api.res.ResponseDto;
import com.example.demo.api.web.OrderServiceManageApi;
import com.example.demo.biz.service.OrderServiceManageService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @className: OrderServiceManageController
 * @author: 吴吉
 * @description: 点餐服务管理接口服务控制层
 * @date: 2024/1/29 10:42
 * @version: 1.0
 */
@RestController
@RequestMapping("/myDemo")
public class OrderServiceManageController implements OrderServiceManageApi {

  @Autowired private OrderServiceManageService orderServiceManageService;

  /**
   * @description: 菜品添加或更新接口
   * @author: wuji
   * @date: 2024/1/29 11:05
   * @param: [goodsInfoDto]
   * @return: void
   */
  @Override
  public ResponseDto<?> goodsAddOrUpdate(GoodsInfoDto goodsInfoDto) {
    String result = orderServiceManageService.goodsAddOrUpdate(goodsInfoDto);
    if (StringUtils.isNotBlank(result)
        && result.equals(String.valueOf(ResponseDto.Type.SUCCESS.getValue()))) {
      return ResponseDto.success("数据更新成功");
    } else {
      return ResponseDto.fail("数据更新失败");
    }
  }
}
