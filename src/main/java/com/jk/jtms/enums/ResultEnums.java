package com.jk.jtms.enums;

/**
 * @ClassName ResultEnums
 * @Description 定义返回结果的枚举,规定200为成功，其他的错误都只返回500
 * @Data 2018/7/17
 * @Author xiao liang
 */
public enum ResultEnums {


    /**
     * 成功
     */
    SUCCESS(200,"ok"),
    /**
     * 失败
     */
    ERROR(500,"error");

    private Integer code;
    private String msg;

     ResultEnums(Integer code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
