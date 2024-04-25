package com.caoyang2002.qoobk.mapper;

import com.caoyang2002.qoobk.pojo.dto.ProductUpdateDTO;
import com.caoyang2002.qoobk.pojo.entity.Product;
import com.caoyang2002.qoobk.pojo.vo.*;

import java.util.List;

public interface ProductMapper {
    void insert(Product product);

    List<ProductAdminVO> selectAdmin();

    String selectUrlById(int id);

    void deleteById();

    List<ProductUpdateVO> selectByIdUpdate(int id);

    void update(ProductUpdateDTO productUpdateDTO);

    List<ProductTopVO> selectTop();

    List<ProductIndexVO> selectIndex();

    ProductDetailVO selectDetail(int id);

    void updateViewCount(int id);

    List<ProductIndexVO> selectByCid(int id);

    List<ProductIndexVO> selectByWd(String wd);
}
