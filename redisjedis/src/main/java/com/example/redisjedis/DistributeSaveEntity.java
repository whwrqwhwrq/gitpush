package com.example.redisjedis;

import java.io.Serializable;

/**
 * @Author:wrq
 * @Date:2020/12/3 17:00
 */
public class DistributeSaveEntity implements Serializable {
    private Integer id;
    private String name;
    private String desc;
    private int type;
    private String typeDesc;
    private String data;
    private Integer status;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTypeDesc() {
        return typeDesc;
    }

    public void setTypeDesc(String typeDesc) {
        this.typeDesc = typeDesc;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "DistributeSaveEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", type=" + type +
                ", typeDesc='" + typeDesc + '\'' +
                ", data='" + data + '\'' +
                ", status=" + status +
                '}';
    }
}
