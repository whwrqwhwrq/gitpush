package com.example.redisjedis.bean;

import java.io.Serializable;

/**
 * @Author:wrq
 * @Date:2020/12/7 19:15
 */
public class Player implements Serializable {
    private String name;
    private String gender;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
