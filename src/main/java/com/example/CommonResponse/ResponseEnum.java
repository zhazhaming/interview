package com.example.CommonResponse;

public enum ResponseEnum {


    SUCCESS(200,true,"操作成功"),
    FAILED(500, false, "操作失败！"),

    USER_NOT_EXIT(510,false,"用户不存在"),
    NOT_ENOUGH_MONEY(511,false,"账号金额不足"),
    NUMBER_ERROR(512,false,"数值错误");

    // 响应业务状态
    private Integer status;
    // 调用是否成功
    private Boolean success;
    // 响应消息，可以为成功或者失败的消息
    private String msg;

    ResponseEnum(Integer status,Boolean success,String msg){
        this.status = status;
        this.success = success;
        this.msg = msg;
    }
    public Integer status(){
        return status;
    }
    public Boolean success(){
        return success;
    }
    public String msg(){
        return msg;
    }


}
