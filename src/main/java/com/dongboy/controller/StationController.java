//package com.dongboy.controller;
//
//import com.dongboy.common.Result;
//import com.dongboy.entity.Station;
//import com.dongboy.service.StationService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import javax.annotation.Resource;
//import java.util.Date;
//
///**
// * @Author dongboy
// * @what time    2023/1/16 16:14
// */
//@RestController("station")
//public class StationController {
//
//    @Resource
//    private StationService stationService;
//
//    // 进入
//    @PostMapping("input")
//    public Result input(Station station) {
//        return stationService.input(station);
//    }
//
//    @PostMapping("output")
//    public Result output(Station station) {
//        return stationService.output(station);
//    }
//
//    @GetMapping("allList")
//    public Result allList() {
//        return stationService.allList();
//    }
//
//    @GetMapping("getByNumber/{number}")
//    public Result getByNumber(@PathVariable String number) {
//        return stationService.getByNumber(number);
//    }
//
//    @GetMapping("getByTime")
//    public Result getByTIme(@RequestParam("st") Date st, @RequestParam("et") Date et) {
//        return stationService.getByTime(st, et);
//    }
//
//
//}
