package com.example.redisjedis.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author:wrq
 * @Date:2020/12/9 11:07
 */
public class TestClassWithDate implements Serializable {
    private String url;
    private Date date;
    private Date date1;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate1() {
        return date1;
    }

    public void setDate1(Date date1) {
        this.date1 = date1;
    }

    @Override
    public String toString() {
        return "TestClassWithDate{" +
                "url='" + url + '\'' +
                ", date=" + date +
                ", date1=" + date1 +
                '}';
    }
}
