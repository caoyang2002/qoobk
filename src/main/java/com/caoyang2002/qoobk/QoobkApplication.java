package com.caoyang2002.qoobk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan // 扫描当前包以及子包中的过滤器
@SpringBootApplication
public class QoobkApplication {
    public static void main(String[] args) {
        SpringApplication.run(QoobkApplication.class, args);
    }
}
