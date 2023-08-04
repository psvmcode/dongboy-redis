package com.dongboy.controller;

import com.dongboy.common.Result;
import com.dongboy.entity.HTable;
import com.dongboy.service.HTableService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author dongboy
 * @what time    2023/4/9 16:46
 */
@RestController
@RequestMapping("h")
@Api(tags = "增删改查接口")
public class HTableController {
    @Resource
    private HTableService hTableService;

    @PostMapping("insert")
    @ApiOperation(value = "添加接口")
    public Result insert(@RequestBody HTable hTable) {
        return hTableService.insert(hTable);
    }

    @PostMapping("delete")
    @ApiOperation(value = "删除接口")
    public Result delete(@PathVariable(value = "hId") Integer hId) {
        return hTableService.delete(hId);
    }

    @PostMapping("update")
    @ApiOperation(value = "修改接口")
    public Result update(@RequestBody HTable hTable) {
        return hTableService.update(hTable);
    }

    @PostMapping("search")
    @ApiOperation(value = "查询接口")
    public Result search() {
        return hTableService.search();
    }
}
