package com.example.Config;

public enum ProjectEumn {

    ConsumeType(1,"支出"),
    RefundType(2,"退款");


    //状态
    private Integer status;

    // 响应消息
    private String msg;

    ProjectEumn(Integer status,String msg){
        this.status = status;

        this.msg = msg;
    }
    public Integer status(){
        return status;
    }
    public String msg(){
        return msg;
    }
}
