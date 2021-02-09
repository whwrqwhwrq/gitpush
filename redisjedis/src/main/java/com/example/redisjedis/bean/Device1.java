package com.example.redisjedis.bean;

/**
 * @Author:wrq
 * @Date:2020/12/23 16:02
 */
public class Device1 {

    private String screen;
    private String controller;
    private String cpu;

    public Device1() {
    }

    public Device1(String screen, String controller, String cpu) {
        this.screen = screen;
        this.controller = controller;
        this.cpu = cpu;
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

    @Override
    public String toString() {
        return "Device1{" +
                "screen='" + screen + '\'' +
                ", controller='" + controller + '\'' +
                ", cpu='" + cpu + '\'' +
                '}';
    }
}
