package com.jk.jtms.entity;
/**
 * 车辆实体类
 */
public class Car {
    /**
     * 行驶证号
     */
    private String xsCode;
    /**
     * 用户id
     */
    private String userId;
    /**
     * 被扣分数
     */
    private String bkScore;
    /**
     * 车牌号码
     */
    private String carCode;
    /**
     * 车主信息
     */
    private User user;

    public String getXsCode() {
        return xsCode;
    }

    public void setXsCode(String xsCode) {
        this.xsCode = xsCode;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBkScore() {
        return bkScore;
    }

    public void setBkScore(String bkScore) {
        this.bkScore = bkScore;
    }

    public String getCarCode() {
        return carCode;
    }

    public void setCarCode(String carCode) {
        this.carCode = carCode;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Car{" +
                "xsCode='" + xsCode + '\'' +
                ", userId='" + userId + '\'' +
                ", bkScore='" + bkScore + '\'' +
                ", carCode='" + carCode + '\'' +
                ", user=" + user +
                '}';
    }
}
