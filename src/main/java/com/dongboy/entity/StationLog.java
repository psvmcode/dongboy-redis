package com.dongboy.entity;


import java.util.Date;

/**
 * @Author dongboy
 * @what time    2023/1/16 16:17
 */
public class StationLog {
    private Station station;
    private Date time;
    private Integer status;

    public StationLog() {
    }

    public StationLog(Station station, Date time, Integer status) {
        this.station = station;
        this.time = time;
        this.status = status;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        String flag = "";
        if (status == 0) {
            flag = "进入";
        } else {
            flag = "出来";
        }
        return "StationLog{" +
                "station=" + station +
                ", time=" + time +
                ", status=" + flag +
                '}';
    }
}
