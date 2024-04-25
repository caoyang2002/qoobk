package com.caoyang2002.qoobk.mapper;

import com.caoyang2002.qoobk.pojo.entity.Banner;

import java.util.List;

public interface BannerMapper {
    List<Banner> select();

    void deleteById(int id);

    void insert(String url);

    void update(Banner banner);


    String selectUrlById(int id);
}
