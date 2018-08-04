package com.lightwing.jpetstore.dao;

import com.lightwing.jpetstore.domain.Order;

import java.util.List;

// 订单管理 DAO
public interface OrderDao {
    // 查询所有的订单信息
    List<Order> findAll();

    // 根据主键查询订单信息
    Order findById(int orderid);

    // 创建订单信息
    int create(Order order);

    // 修改订单信息
    int modify(Order order);

    // 删除订单信息
    int remove(Order order);
}
