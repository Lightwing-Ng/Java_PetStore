package com.lightwing.jpetstore.dao;

import com.lightwing.jpetstore.domain.Order;

import java.util.List;

// �������� DAO
public interface OrderDao {
    // ��ѯ���еĶ�����Ϣ
    List<Order> findAll();

    // ����������ѯ������Ϣ
    Order findById(int orderid);

    // ����������Ϣ
    int create(Order order);

    // �޸Ķ�����Ϣ
    int modify(Order order);

    // ɾ��������Ϣ
    int remove(Order order);
}
