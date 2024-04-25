package com.caoyang2002.qoobk.controller;

import com.caoyang2002.qoobk.mapper.BannerMapper;
import com.caoyang2002.qoobk.pojo.entity.Banner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.List;

@RestController
@RequestMapping("/banner")
public class BannerController {
    @Value("${dirPath}")
    private String dirPath;
    @Autowired(required = false)
    BannerMapper mapper;

    @RequestMapping("/select")
    public List<Banner> select() {
        return mapper.select();
    }

    @RequestMapping("/delete")
    public void delete(int id) {
        String url = mapper.selectUrlById(id);
        new File(dirPath + url).delete();
        mapper.deleteById(id);
    }

    @RequestMapping("/insert")
    public void insert(String url) {
        mapper.insert(url);
    }

    @RequestMapping("/update")
    public void update(@RequestBody Banner banner){
        System.out.println("banner = " + banner);
        mapper.update(banner);
    }

}

