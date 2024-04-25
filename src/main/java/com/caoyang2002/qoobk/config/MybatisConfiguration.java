package com.caoyang2002.qoobk.config;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
@Slf4j
@Configuration
@MapperScan("com.caoyang2002.qoobk.mapper")
public class MybatisConfiguration {
    public MybatisConfiguration() {
        log.debug("创建配置类对象: MybatisConfiguration");
    }
}
