package com.example.redisjedis.bean;

/**
 * @Author:wrq
 * @Date:2020/12/23 16:20
 */
public class A {
    public String same;
    public String a;
    public String b;
    public String c;
    public String d;

    public String getSame() {
        return same;
    }

    public void setSame(String same) {
        this.same = same;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }

    @Override
    public String toString() {
        return "A{" +
                "same='" + same + '\'' +
                ", a='" + a + '\'' +
                ", b='" + b + '\'' +
                ", c='" + c + '\'' +
                ", d='" + d + '\'' +
                '}';
    }
}
