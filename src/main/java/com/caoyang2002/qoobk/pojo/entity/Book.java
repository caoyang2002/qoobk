package com.caoyang2002.qoobk.pojo.entity;

import lombok.Data;
import org.springframework.stereotype.Repository;

@Data // 自动生成 Getter and Setter
@Repository
public class Book {
    private Integer id;
    private String title;
    private String url;
}
