package com.dongboy.service;

import com.dongboy.common.Result;
import com.dongboy.entity.HTable;

/**
 * @Author dongboy
 * @what time    2023/4/9 16:48
 */
public interface HTableService {
    // 添加
    Result insert(HTable hTable);

    // 删除
    Result delete(Integer hId);

    Result update(HTable hTable);

    Result search();
}
