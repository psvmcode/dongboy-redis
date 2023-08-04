package com.dongboy.service.impl;

import com.dongboy.common.Result;
import com.dongboy.entity.Station;
import com.dongboy.entity.StationLog;
import com.dongboy.service.StationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author dongboy
 * @what time    2023/1/16 16:21
 */
@Service
public class StationServiceImpl implements StationService {

    @Resource(name = "myLog", type = List.class)
    private List<StationLog> logs;

    @Override
    public Result input(Station station) {
        StationLog stationLog = new StationLog();
        stationLog.setStation(station);
        stationLog.setTime(new Date());
        stationLog.setStatus(0);
        logs.add(stationLog);
        return Result.success("进入成功");
    }

    @Override
    public Result output(Station station) {
        StationLog stationLog = new StationLog();
        stationLog.setStation(station);
        stationLog.setTime(new Date());
        stationLog.setStatus(1);
        logs.add(stationLog);
        return Result.success("出来成功");
    }

    @Override
    public Result allList() {
        return Result.success(logs);
    }

    @Override
    public Result getByNumber(String number) {
        List<StationLog> res = logs.stream().
                filter(e -> e.getStation().getNumber().equals(number)).
                collect(Collectors.toList());
        return Result.success(res);
    }

    @Override
    public Result getByTime(Date st, Date et) {
        List<StationLog> res = logs.stream().
                filter(e -> e.getTime().compareTo(st) > 0 && e.getTime().compareTo(et) < 0).
                collect(Collectors.toList());
        return Result.success(res);
    }
}
