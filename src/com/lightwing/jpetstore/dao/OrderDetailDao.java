package com.lightwing.jpetstore.dao;

import com.lightwing.jpetstore.domain.OrderDetail;

import java.util.List;

// ������ϸ���� DAO
public interface OrderDetailDao {

    // ��ѯ���еĶ�����ϸ��Ϣ
    List<OrderDetail> findAll();

    // ����������ѯ������ϸ��Ϣ
    OrderDetail findByPK(int orderid, String productid);

    // ����������ϸ��Ϣ
    int create(OrderDetail orderDetail);

    // �޸Ķ�����ϸ��Ϣ
    int modify(OrderDetail orderDetail);

    // ɾ��������ϸ��Ϣ
    int remove(OrderDetail orderDetail);
}
