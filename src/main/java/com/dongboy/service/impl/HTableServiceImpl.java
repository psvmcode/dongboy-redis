package com.dongboy.service.impl;

import com.dongboy.common.Result;
import com.dongboy.entity.HTable;
import com.dongboy.mapper.HTableMapper;
import com.dongboy.service.HTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author dongboy
 * @what time    2023/4/9 16:51
 */
@Service
public class HTableServiceImpl implements HTableService {

    @Resource
    private HTableMapper hTableMapper;

    @Override
    public Result insert(HTable hTable) {
        int insert = hTableMapper.insert(hTable);
        return insert == -1 ? Result.failed("插入失败") : Result.success(hTable, "插入成功");
    }

    @Override
    public Result delete(Integer hId) {
        try {
            hTableMapper.delete(hId);
            return Result.success("删除成功");
        } catch (Exception e) {
            return Result.failed("删除失败");
        }
    }

    @Override
    public Result update(HTable hTable) {
        try {
            hTableMapper.update(hTable);
            return Result.success(hTable, "修改成功");
        } catch (Exception e) {
            return Result.failed("修改失败");
        }
    }

    @Override
    public Result search() {
        try {
            List<HTable> res = hTableMapper.search();
            return Result.success(res, "查询成功成功");
        } catch (Exception e) {
            return Result.failed("查询出现错误");
        }
    }
}
