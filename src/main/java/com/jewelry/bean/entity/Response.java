package com.jewelry.bean.entity;

public class Response {
    private Integer code;
    private String msg;
    private Object data;
    private Object en_data;

    public Response() {
    }

    public Response(Integer code, String msg, Object data, Object en_data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.en_data = en_data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Object getEn_data() {
        return en_data;
    }

    public void setEn_data(Object en_data) {
        this.en_data = en_data;
    }
}
