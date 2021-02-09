package com.example.springcloudapi.beans;

import java.io.Serializable;

/**
 * @Author:wrq
 * @Date:2020/10/30 14:24
 */
public class Dept implements Serializable {
    private Long deptno;
    private String dname;
    private String dbSource;

    public Dept(String dname) {
        this.dname = dname;
    }

    public Dept() {
    }

    public Long getDeptno() {
        return deptno;
    }

    public void setDeptno(Long deptno) {
        this.deptno = deptno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getDbSource() {
        return dbSource;
    }



    public void setDbSource(String dbSource) {
        this.dbSource = dbSource;
    }
    @Override
    public String toString() {
        return "Dept{" +
                "deptno=" + deptno +
                ", dname='" + dname + '\'' +
                ", dbSource='" + dbSource + '\'' +
                '}';
    }
}
