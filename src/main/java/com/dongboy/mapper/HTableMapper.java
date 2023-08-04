package com.dongboy.mapper;

import com.dongboy.entity.HTable;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author dongboy
 * @what time    2023/4/9 16:51
 */
@Mapper
public interface HTableMapper {
    int insert(HTable hTable);

    void delete(Integer hId);

    void update(HTable hTable);

    List<HTable> search();
}
