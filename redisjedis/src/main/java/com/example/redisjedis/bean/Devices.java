package com.example.redisjedis.bean;

/**
 * @Author:wrq
 * @Date:2020/12/23 16:00
 */
public class Devices {
    private String screen;
    private String controller;
    private String cpu;
    private String memory;
    private String shapeCard;

    public Devices() {
    }

    public Devices(String screen, String controller, String cpu, String memory, String shapeCard) {
        this.screen = screen;
        this.controller = controller;
        this.cpu = cpu;
        this.memory = memory;
        this.shapeCard = shapeCard;
    }

    public String getScreen() {
        return screen;
    }

    public void setScreen(String screen) {
        this.screen = screen;
    }

    public String getController() {
        return controller;
    }

    public void setController(String controller) {
        this.controller = controller;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
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
        return "Devices{" +
                "screen='" + screen + '\'' +
                ", controller='" + controller + '\'' +
                ", cpu='" + cpu + '\'' +
                ", memory='" + memory + '\'' +
                ", shapeCard='" + shapeCard + '\'' +
                '}';
    }
}
