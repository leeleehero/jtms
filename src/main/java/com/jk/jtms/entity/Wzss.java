package com.jk.jtms.entity;

/**
 *
 * 违章申诉信息
 *
 */
public class Wzss {
    private String id;
    private String carcode;
    private String status;
    private String msg;
    private String sfcode;

    public String getSfcode() {
        return sfcode;
    }

    public void setSfcode(String sfcode) {
        this.sfcode = sfcode;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCarcode() {
        return carcode;
    }

    public void setCarcode(String carcode) {
        this.carcode = carcode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}


    