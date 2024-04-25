package com.caoyang2002.qoobk;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class Slf4jTests {
    @Test
    public void log(){
        log.trace("trace");
        log.debug("debug");
        log.info("info");
        log.warn("warn");
        log.error("error");
        int a = 3;
        int b = 4;
        log.info("{}+{}={},{}*{}={}",a,b,(a+b),a,b,(a*b));
    }
}
