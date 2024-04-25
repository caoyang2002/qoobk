package com.caoyang2002.qoobk.mapper;

import com.caoyang2002.qoobk.pojo.vo.BookListItemVO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 处理书籍数据的 mapper 接口
 * @author reggiesimons2cy@gmail.com
 * @version 0.0.1
 */
@Repository
public interface BookMapper {
    /**
     * 查询书籍列表
     * @return
     */
    List<BookListItemVO> list();


}
