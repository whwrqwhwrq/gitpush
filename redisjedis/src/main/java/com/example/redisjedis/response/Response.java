package com.example.redisjedis.response;

import java.io.Serializable;

/**
 * @Author:wrq
 * @Date:2020/12/4 16:43
 */
public class  Response implements Serializable {
    private Integer returnCode;
    private String returnMessage;
    private Object bean;

    public static Response buildFailureResponse(String returnMessage) {
        Response response = new Response();
        response.setReturnCode(-1);
        response.setReturnMessage(returnMessage);
        return response;
    }
    public static Response buildSuccessResponse(String returnMessage) {
        Response response = new Response();
        response.setReturnCode(-1);
        response.setReturnMessage(returnMessage);
        return response;
    }
    public static <T> Response buildSuccessResponse(String returnMessage, T obj) {
        Response response = new Response();
        response.setReturnCode(0);
        response.setReturnMessage(returnMessage);
        response.setBean(obj);
        return response;
    }
    public Integer getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(Integer returnCode) {
        this.returnCode = returnCode;
    }

    public String getReturnMessage() {
        return returnMessage;
    }

    public void setReturnMessage(String returnMessage) {
        this.returnMessage = returnMessage;
    }

    public Object getBean() {
        return bean;
    }

    public void setBean(Object bean) {
        this.bean = bean;
    }

    @Override
    public String toString() {
        return "Response{" +
                "returnCode=" + returnCode +
                ", returnMessage='" + returnMessage + '\'' +
                ", bean=" + bean +
                '}';
    }
}
