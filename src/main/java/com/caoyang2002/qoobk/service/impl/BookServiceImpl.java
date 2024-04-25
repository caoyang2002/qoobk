package com.caoyang2002.qoobk.service.impl;

import com.caoyang2002.qoobk.mapper.BookMapper;
import com.caoyang2002.qoobk.pojo.vo.BookListItemVO;
import com.caoyang2002.qoobk.service.IBookService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 处理书籍业务的实现类
 */
@Slf4j
@Service
@Data
public class BookServiceImpl implements IBookService {
    @Autowired
    private BookMapper bookMapper;
    @Override
    public List<BookListItemVO> list(){
        // 查询数据
        log.debug("开始处理 [查询相册列表] 的业务, 无参数");
        return bookMapper.list();
    }
}
