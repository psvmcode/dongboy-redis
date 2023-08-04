package com.dongboy.service;

import com.dongboy.common.Result;
import com.dongboy.entity.Station;

import java.util.Date;

/**
 * @Author dongboy
 * @what time    2023/1/16 16:20
 */
public interface StationService {

    Result input(Station station);

    Result output(Station station);

    Result allList();

    Result getByNumber(String number);

    Result getByTime(Date st, Date et);
}
