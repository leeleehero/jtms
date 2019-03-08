package com.jk.jtms.entity;

/**
 * 违章信息
 */
public class WzInfo {
    private String carCode;
    private String area;
    private String type;
    private String fileUrl;

    public String getCarCode() {
        return carCode;
    }

    public void setCarCode(String carCode) {
        this.carCode = carCode;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    @Override
    public String toString() {
        return "WzInfo{" +
                "carCode='" + carCode + '\'' +
                ", area='" + area + '\'' +
                ", type='" + type + '\'' +
                ", fileUrl='" + fileUrl + '\'' +
                '}';
    }
}
