package com.jk.jtms.entity;

public class CarDTO {
    private String carCode;
    private String username;
    private String xsCode;
    private String userid;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getCarCode() {
        return carCode;
    }

    public void setCarCode(String carCode) {
        this.carCode = carCode;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getXsCode() {
        return xsCode;
    }

    public void setXsCode(String xsCode) {
        this.xsCode = xsCode;
    }

    @Override
    public String toString() {
        return "CarDTO{" +
                "carCode='" + carCode + '\'' +
                ", username='" + username + '\'' +
                ", xsCode='" + xsCode + '\'' +
                '}';
    }
}
