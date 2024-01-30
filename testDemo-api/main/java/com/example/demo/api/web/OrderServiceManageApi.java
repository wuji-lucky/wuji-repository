package com.example.demo.api.web;

import com.example.demo.api.dto.GoodsInfoDto;
import com.example.demo.api.res.ResponseDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Api(value = "点餐服务管理接口服务", tags = "UI:点餐服务管理接口服务")
public interface OrderServiceManageApi {

  @ApiOperation(value = "菜品添加或更新接口", notes = "菜品添加或更新接口")
  @ResponseBody
  @PostMapping("/OrderServiceManageApi/goodsAddOrUpdate")
  ResponseDto<?> goodsAddOrUpdate(@RequestBody @Validated GoodsInfoDto goodsInfoDto);
}
