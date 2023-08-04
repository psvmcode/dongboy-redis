package com.dongboy.entity;

import java.util.Date;

/**
 * @Author dongboy
 * @what time    2023/4/9 16:44
 */
public class HTable {

    private Integer hId;

    private String hName;

    private Integer hAge;

    private Date hBirthday;

    public HTable() {
    }

    public HTable(int hId, String hName, int hAge, Date hBirthday) {
        this.hId = hId;
        this.hName = hName;
        this.hAge = hAge;
        this.hBirthday = hBirthday;
    }

    public int gethId() {
        return hId;
    }

    public void sethId(int hId) {
        this.hId = hId;
    }

    public String gethName() {
        return hName;
    }

    public void sethName(String hName) {
        this.hName = hName;
    }

    public int gethAge() {
        return hAge;
    }

    public void sethAge(int hAge) {
        this.hAge = hAge;
    }

    public Date gethBirthday() {
        return hBirthday;
    }

    @Override
    public String toString() {
        return "HTable{" +
                "hId=" + hId +
                ", hName='" + hName + '\'' +
                ", hAge=" + hAge +
                ", hBirthday=" + hBirthday +
                '}';
    }

    public void sethBirthday(Date hBirthday) {
        this.hBirthday = hBirthday;
    }

}
