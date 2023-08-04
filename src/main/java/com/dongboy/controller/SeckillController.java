//package com.dongboy.controller;
//
//import com.dongboy.common.Result;
//import com.dongboy.entity.SeckillVoucher;
//import com.dongboy.service.SeckillVoucherService;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
///**
// * @author dong boy
// * @date 2022年09月13日 10:51
// */
//@RestController
//@RequestMapping("seckill")
//@Api(tags = "优惠券管理")
//public class SeckillController {
//
//    @Autowired
//    private SeckillVoucherService seckillVoucherService;
//
//    /**
//     * 新增秒杀券
//     *
//     * @param seckillVoucher 优惠券信息，包含秒杀信息
//     * @return 优惠券id
//     */
//    @ApiOperation(value = "新增秒杀券")
//    @PostMapping("add")
//    public Result addSeckillVoucher(@RequestBody SeckillVoucher seckillVoucher) {
//        boolean flag = seckillVoucherService.addSeckillVoucher(seckillVoucher);
//        return flag ? Result.success(seckillVoucher, "添加成功") : Result.failed("添加失败");
//    }
//
//    /**
//     * 查询优惠券列表
//     *
//     * @param vouchId 优惠券id
//     * @return 优惠券
//     */
//    @ApiOperation(value = "根据id查询优惠券")
//    @GetMapping("query/{vouchId}")
//    public Result queryVoucherOfShop(@PathVariable("vouchId") Long vouchId) {
//        return seckillVoucherService.querySeckillVoucherById(vouchId);
//    }
//
//
//    @ApiOperation(value = "抢购秒杀券")
//    @PostMapping("update/{id}")
//    public Result seckillVoucher(@PathVariable("id") Long voucherId) {
//        return seckillVoucherService.setkillVoucher(voucherId);
//    }
//
//
//}
