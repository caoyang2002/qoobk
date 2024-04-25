package com.caoyang2002.qoobk.pojo.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class BookListItemVO implements Serializable {
    @ApiModelProperty("记录 id")
    private Integer id;
    @ApiModelProperty("书籍名称")
    private String title;
    @ApiModelProperty("书籍 URL")
    private String url;
}
