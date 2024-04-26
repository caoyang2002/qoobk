package com.caoyang2002.qoobk.pojo.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserVO {
    /**
     * 用户id
     */
    @ApiModelProperty("用户 id")
    private Integer id;
    /**
     * 用户密码
     */
    @ApiModelProperty(value = "用户密码", required = true)
    private String password;
    /**
     * 用户昵称
     */
    @ApiModelProperty(value = "用户昵称", required = true)
    private String nickname;
}
