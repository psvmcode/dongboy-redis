package com.dongboy.service;

import com.dongboy.common.Result;
import com.dongboy.entity.SeckillCommodity;
import com.dongboy.entity.query.CommodityQuery;
import com.dongboy.entity.vo.CommodityVo;

import java.util.List;

public interface CommodityService {

    List<CommodityVo> list(CommodityQuery query);

    boolean addCommodity(SeckillCommodity seckillCommodity);

    int update(CommodityVo commodityVo);

    Result getCommodityById(Long commodityId);

}
