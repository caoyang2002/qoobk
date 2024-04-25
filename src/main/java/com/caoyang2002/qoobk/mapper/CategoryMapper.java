package com.caoyang2002.qoobk.mapper;

import com.caoyang2002.qoobk.pojo.entity.Category;

import java.util.List;

public interface CategoryMapper {
    List<Category> select(); // 两个字段都要用, 所以不用创建VO, 直接用实体类

    void deleteById(int id);

    void insert(String name);

    void update(Category category);
}
