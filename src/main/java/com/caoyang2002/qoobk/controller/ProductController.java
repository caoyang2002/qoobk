package com.caoyang2002.qoobk.controller;

import com.caoyang2002.qoobk.mapper.ProductMapper;
import com.caoyang2002.qoobk.pojo.dto.ProductDTO;
import com.caoyang2002.qoobk.pojo.dto.ProductUpdateDTO;
import com.caoyang2002.qoobk.pojo.entity.Product;
import com.caoyang2002.qoobk.pojo.vo.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Value("${dirPath}")
    private String dirPath;
    @Autowired(required = false)
    ProductMapper mapper;
    @RequestMapping("/insert")
    public void insert(@RequestBody ProductDTO productDTO){
        System.out.println("productDTO = " + productDTO);
        Product p = new Product();
        // 把DTO里面的数据复制到实体类中
        BeanUtils.copyProperties(productDTO,p);
        // 给属性赋值
        p.setCreated(new Date());
        p.setViewCount(0);
        mapper.insert(p);
    }


    @RequestMapping("/select/admin")
    public List<ProductAdminVO> select(){
        return mapper.selectAdmin();
    }

    @RequestMapping("/delete")
    public void delete(int id){
        // 删除文件
        String url = mapper.selectUrlById(id);
        new File(dirPath + url).delete();
        // 删除数据
        mapper.deleteById();
    }
    @RequestMapping("/selectById/update")
    public List<ProductUpdateVO> selectByIdUpdate(int id){
        return mapper.selectByIdUpdate(id);
    }

    @RequestMapping("/update")
    public void update(@RequestBody ProductUpdateDTO productUpdateDTO){
        System.out.println("productUpdateDTO = " + productUpdateDTO);
        mapper.update(productUpdateDTO);
    }

    @RequestMapping("/select/top")
    public List<ProductTopVO> selectTop(){
        return mapper.selectTop();
    }
    @RequestMapping("/select/index")
    public List<ProductIndexVO> selectIndex(){
        return mapper.selectIndex();
    }

    @RequestMapping("/selectById/detail")
    public ProductDetailVO selectDetail(int id, HttpSession session){
        //从会话对象中获取和当前商品id相关的信息, 第一次是获取不到的
        String info = (String) session.getAttribute("view"+id);
        // 如果info值为null说明是第一次浏览
        if(info==null){
            // 让浏览量+1
            mapper.updateViewCount(id);
            // 把当前商品id相关信息保存在Session中, 之后再次查询此商品时,此条件不会再满足, 因此info不会为null
            session.setAttribute("view"+id,"isVisited");
        }
        return mapper.selectDetail(id);
    }
    @RequestMapping("/selectByCid")
    public List<ProductIndexVO> selectByCid(int id){
        return mapper.selectByCid(id);
    }
    @RequestMapping("/selectByWd")
    public List<ProductIndexVO> selectByWd(String wd){
        return mapper.selectByWd(wd);
    }
}
