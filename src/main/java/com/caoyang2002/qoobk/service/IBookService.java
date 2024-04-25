package com.caoyang2002.qoobk.service;

import com.caoyang2002.qoobk.pojo.vo.BookListItemVO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IBookService {
    List<BookListItemVO> list();
}
