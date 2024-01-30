package com.example.demo.api.web;

import com.example.demo.api.res.OrderingMenuRes;
import com.example.demo.api.res.ResponseDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.constraints.NotBlank;

@Api(value = "扫码点餐小程序接口服务", tags = "UI:扫码点餐小程序接口服务")
public interface ScanOrderingApi {

  @ApiOperation(value = "扫码查询进入小程序菜单主页", notes = "扫码查询进入小程序菜单主页")
  @ResponseBody
  @GetMapping("/scanOrderingApi/getOrderingMenu")
  ResponseDto<OrderingMenuRes> getOrderingMenu(
      @RequestParam(value = "tableId", required = true) @ApiParam(value = "桌号") @NotBlank
          String tableId);
}
