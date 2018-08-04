package com.lightwing.jpetstore.dao;

import com.lightwing.jpetstore.domain.Product;

import java.util.List;

// ��Ʒ���� DAO
public interface ProductDao {
    // ��ѯ���е���Ʒ��Ϣ
    List<Product> findAll();

    // ����������ѯ��Ʒ��Ϣ
    Product findById(String productid);

    // ���ݰ����б��ѯ��Ʒ��Ϣ
    List<Product> findByCategory(String category);

    // ������Ʒ��Ϣ
    int create(Product product);

    // �޸���Ʒ��Ϣ
    int modify(Product product);

    // ɾ����Ʒ��Ϣ
    int remove(Product product);
}
