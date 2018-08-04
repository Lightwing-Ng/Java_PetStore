package com.lightwing.jpetstore.dao;

import com.lightwing.jpetstore.domain.Account;

import java.util.List;

// 用户管理 DAO
public interface AccountDao {
    // 查询所有的用户信息
    List<Account> findAll();

    // 根据主键查询用户信息
    Account findById(String userid);

    // 创建用户信息
    int create(Account account);

    // 修改用户信息
    int modify(Account account);

    // 删除用户信息
    int remove(Account account);
}
