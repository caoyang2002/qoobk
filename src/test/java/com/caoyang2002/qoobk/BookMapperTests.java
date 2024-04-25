package com.caoyang2002.qoobk;

import com.caoyang2002.qoobk.mapper.BookMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.util.List;

@Slf4j
@SpringBootTest
public class BookMapperTests {
    @Autowired
    BookMapper mapper;

    @Test
    void list() {
        List<?> list = mapper.list();
        log.debug("列表中的数据有 {} 条", list.size());
        for (Object item : list) {
            log.debug("{}", item);

        }
    }
}
