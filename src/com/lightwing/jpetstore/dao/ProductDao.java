package com.lightwing.jpetstore.dao;

import com.lightwing.jpetstore.domain.Product;

import java.util.List;

// 商品管理 DAO
public interface ProductDao {
    // 查询所有的商品信息
    List<Product> findAll();

    // 根据主键查询商品信息
    Product findById(String productid);

    // 根据按照列表查询商品信息
    List<Product> findByCategory(String category);

    // 创建商品信息
    int create(Product product);

    // 修改商品信息
    int modify(Product product);

    // 删除商品信息
    int remove(Product product);
}
