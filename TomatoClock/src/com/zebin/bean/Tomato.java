package com.zebin.bean;

import java.sql.Date;

public class Tomato {
    private int id;
    private int workTime;//工作时间
    private Date date;//日期
    private int count;//个数
    private String remark;//备注

    public Tomato() {
    }

    public Tomato(int id, int workTime, Date date, int count, String remark) {
        this.id = id;
        this.workTime = workTime;
        this.date = date;
        this.count = count;
        this.remark = remark;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWorkTime() {
        return workTime;
    }

    public void setWorkTime(int workTime) {
        this.workTime = workTime;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "tomato{" +
                "id=" + id +
                ", workTime=" + workTime +
                ", date=" + date +
                ", count=" + count +
                ", remark='" + remark + '\'' +
                '}';
    }
}
