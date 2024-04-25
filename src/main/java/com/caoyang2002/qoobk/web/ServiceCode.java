package com.caoyang2002.qoobk.web;

/**
 * 业务状态码
 */
public enum ServiceCode {

    /**
     * 成功
     */
    OK(200),
    /**
     * 错误, 错误的请求
     */
    ERR_BAD_REQUEST(40000),
    /**
     * 错误,数据不存在
     */
    ERR_NOT_FOUND(40400),
    /**
     * 错误, 数据冲突
     */
    ERR_CONFLICT(40900);
    private Integer value;
    private ServiceCode(Integer value){
        this.value = value;
    }
    public Integer getValue(){
        return value;
    }
}
