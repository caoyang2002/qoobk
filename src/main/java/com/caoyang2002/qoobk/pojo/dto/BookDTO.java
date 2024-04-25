package com.caoyang2002.qoobk.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class BookDTO {
    @ApiModelProperty(value = "书籍名称",required = true)
    private String title;
    @ApiModelProperty(value = "书籍 URL",required = true)
    private String url;
}
