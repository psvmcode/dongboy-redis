package com.dongboy.controller;

import com.dongboy.annotation.IpLimit;
import com.dongboy.common.Result;
import com.dongboy.entity.SeckillCommodity;
import com.dongboy.entity.query.CommodityQuery;
import com.dongboy.entity.vo.CommodityVo;
import com.dongboy.enums.IpLimitType;
import com.dongboy.service.CommodityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author dong boy
 * @date 2022年09月18日 19:20
 */
@RestController
@RequestMapping("commodity")
@Api(tags = "商品管理")
@CrossOrigin
public class CommodityController {

    @Resource
    private CommodityService commodityService;

    @GetMapping("list")
    @ApiOperation(value = "商品列表")
    public Result list(CommodityQuery query) {
        List<CommodityVo> list = commodityService.list(query);
        return Result.success(list);
    }

    @ApiOperation(value = "添加商品")
    @PostMapping("add")
    public Result add(@RequestBody SeckillCommodity seckillCommodity) {
        boolean flag = commodityService.addCommodity(seckillCommodity);
        return flag ? Result.success(seckillCommodity, "添加成功") : Result.failed("添加失败");
    }

    @ApiOperation(value = "修改商品信息")
    @PostMapping("update")
    public Result update(@RequestBody CommodityVo commodityVo) {
        int row = commodityService.update(commodityVo);
        return row > 0 ? Result.success(commodityVo, "修改成功") : Result.failed("修改失败");
    }

    @IpLimit(key = "testLimitIP", period = 10, count = 3, limitType = IpLimitType.IP)
    @ApiOperation(value = "查询商品")
    @GetMapping("search/{commodityId}")
    public Result search(@PathVariable(value = "commodityId") Long commodityId) {
        return commodityService.getCommodityById(commodityId);
    }

}
