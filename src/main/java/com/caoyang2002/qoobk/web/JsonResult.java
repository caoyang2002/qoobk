package com.caoyang2002.qoobk.web;

import com.caoyang2002.qoobk.ex.ServiceExcption;
import lombok.Data;
import org.springframework.web.servlet.handler.UserRoleAuthorizationInterceptor;

import java.io.Serializable;

@Data
public class JsonResult<T> implements Serializable {
    /**
     * 状态码
     */
    private Integer state;
    /**
     * 操作失败时返回的描述文本
     */
    private String message;
    /**
     * 操作成功时响应的数据
     */
    private T data;
    public JsonResult(){};

    /**
     * 返回对象
     * @param data
     * @return
     * @param <T>
     */
    public static<T> JsonResult<T> ok(T data){
        JsonResult<T> jsonResult = new JsonResult<>();
        jsonResult.state = ServiceCode.OK.getValue();
        jsonResult.data = data;
        return jsonResult;
    }

    public static JsonResult<Void> ok(){
        return ok(null);
    }
    public static JsonResult fail(ServiceCode serviceCode,String message){
        JsonResult jsonResult = new JsonResult();
        jsonResult.state = serviceCode.getValue();
        jsonResult.message = message;
        return jsonResult;
    }

    public static JsonResult fail(ServiceExcption e){
        return fail(e.getServiceCode(),ok().getMessage());
    }
}
