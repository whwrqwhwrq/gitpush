package com.example.redisjedis.bean;

/**
 * @Author:wrq
 * @Date:2020/12/23 16:03
 */
public class Device2 {
    private String memory;
    private String shapeCard;

    public Device2() {
    }

    public Device2(String memory, String shapeCard) {
        this.memory = memory;
        this.shapeCard = shapeCard;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getShapeCard() {
        return shapeCard;
    }

    public void setShapeCard(String shapeCard) {
        this.shapeCard = shapeCard;
    }

    @Override
    public String toString() {
        return "Device2{" +
                "memory='" + memory + '\'' +
                ", shapeCard='" + shapeCard + '\'' +
                '}';
    }
}
