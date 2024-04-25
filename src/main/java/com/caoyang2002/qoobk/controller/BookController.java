package com.caoyang2002.qoobk.controller;

import com.caoyang2002.qoobk.pojo.vo.BookListItemVO;
import com.caoyang2002.qoobk.service.IBookService;
import com.caoyang2002.qoobk.web.JsonResult;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "01. 书籍查询模块")
@Slf4j
@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired  // 不要忘记自动装配
    private IBookService bookService;

    public BookController() {
        log.debug("创建控制器对象: BookController");
    }
    /**
     * 根据关键词查询书籍
     */
    @ApiOperation("根据关键词查询数据")
    @ApiOperationSupport(order = 100)
    @GetMapping("/query/title")
    public String getTitleByKey(@RequestParam String key){
        log.debug("开始处理 [通过关键词查询数据] 的请求, 参数是 {}", key);
        return "ok";
    }
    /**
     * 查询所有书籍
     * @return
     */
    @ApiOperation("查询所有书籍")
    @ApiOperationSupport(order = 200)
    @GetMapping("")
    public JsonResult<List<BookListItemVO>> list(){
        log.debug("开始处理 [获取所有书籍] 的请求, 无参数");
        List<BookListItemVO> list = bookService.list();
        return JsonResult.ok(list);
    }
}
