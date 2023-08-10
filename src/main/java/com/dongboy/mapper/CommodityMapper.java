package com.dongboy.mapper;

import com.dongboy.entity.SeckillCommodity;
import com.dongboy.entity.query.CommodityQuery;
import com.dongboy.entity.vo.CommodityVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommodityMapper {

    List<CommodityVo> list(CommodityQuery query);

    Long addCommodity(SeckillCommodity seckillCommodity);

    int update(CommodityVo commodityVo);

    CommodityVo getCommodityById(Long commodityId);

}
