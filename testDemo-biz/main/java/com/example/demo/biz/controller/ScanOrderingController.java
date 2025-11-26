package com.example.demo.biz.controller;

import com.example.demo.api.req.PerGoodReq;
import com.example.demo.api.res.OrderingMenuRes;
import com.example.demo.api.res.ResponseDto;
import com.example.demo.api.web.ScanOrderingApi;
import com.example.demo.biz.service.ScanOrderingService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @className: ScanOrderingController
 * @author: 吴吉
 * @description: 扫码点餐小程序接口服务控制层
 * @date: 2024/1/26 14:28
 * @version: 1.0
 */
@RestController
@RequestMapping("/myDemo")
public class ScanOrderingController implements ScanOrderingApi {

    private final ScanOrderingService scanOrderingService;

    public ScanOrderingController(ScanOrderingService scanOrderingService) {
        this.scanOrderingService = scanOrderingService;
    }

    /**
     * 扫码查询进入小程序菜单主页
     */
    @Override
    public ResponseDto<OrderingMenuRes> getOrderingMenu(String tableId) {
        OrderingMenuRes orderingMenuRes = scanOrderingService.getOrderingMenu(tableId);
        if (null != orderingMenuRes) {
            return ResponseDto.success(orderingMenuRes);
        }
        return (ResponseDto<OrderingMenuRes>) ResponseDto.fail("查询发生错误");
    }

    /**
     * 添加菜品到当前购物车
     */
    @Override
    public ResponseDto<String> addToShopCart(PerGoodReq perGoodReq) {
        if (null == perGoodReq) {
            return (ResponseDto<String>) ResponseDto.fail("不能将空对象添加进购物车");
        }
        return new ResponseDto<String>().setResult(scanOrderingService.addToShopCart(perGoodReq));
    }
}
