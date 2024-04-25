package com.caoyang2002.qoobk.ex;


import com.caoyang2002.qoobk.web.ServiceCode;

/**
 * 业务异常类
 */
public class ServiceExcption extends RuntimeException{
    private ServiceCode serviceCode;
    // 自定义异常, 抛出异常的时候写
    public ServiceExcption(ServiceCode serviceCode,String message){
        super(message);
        this.serviceCode = serviceCode;
    }
    public ServiceCode getServiceCode(){
        return serviceCode;
    }
}
