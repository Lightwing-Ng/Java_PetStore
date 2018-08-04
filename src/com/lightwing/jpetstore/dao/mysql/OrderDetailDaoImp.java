package com.lightwing.jpetstore.dao.mysql;

import com.lightwing.jpetstore.dao.OrderDetailDao;
import com.lightwing.jpetstore.domain.OrderDetail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

// ������ϸ���� DAO
public class OrderDetailDaoImp implements OrderDetailDao {
    @Override
    public List<OrderDetail> findAll() {
        return null;
    }

    @Override
    public OrderDetail findByPK(int orderid, String productid) {

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        OrderDetail orderDetail = null;

        try {
            // 2.�������ݿ�����
            conn = DBHelper.getConnection();
            // 3. ����������
            String sql = "SELECT orderid,productid,quantity,unitprice "
                    + "FROM ordersdetail WHERE orderid = ? AND productid = ?";
            pstmt = conn.prepareStatement(sql);
            // 4. �󶨲���
            pstmt.setInt(1, orderid);
            pstmt.setString(2, productid);
            // 5. ִ�в�ѯ��R��
            rs = pstmt.executeQuery();
            // 6. ���������
            if (rs.next()) {
                orderDetail = new OrderDetail();
                orderDetail.setOrderid(rs.getInt("orderid"));
                orderDetail.setProductid(rs.getString("productid"));
                orderDetail.setQuantity(rs.getInt("quantity"));
                orderDetail.setUnitcost(rs.getDouble("unitcost"));
                return orderDetail;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally { // �ͷ���Դ
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ignored) {
                }
            }
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException ignored) {
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ignored) {
                }
            }
        }
        return null;
    }

    @Override
    public int create(OrderDetail orderDetail) {
        try ( // 2.�������ݿ�����
              Connection conn = DBHelper.getConnection();
              // 3. ����������
              PreparedStatement pstmt = conn
                      .prepareStatement(
                              "INSERT INTO ordersdetail "
                                      + "( `orderid`, `productid`, `quantity`, `unitcost`) " +
                                      "VALUES (?, ?, ?, ?)")) {

            // 4. �󶨲���
            pstmt.setLong(1, orderDetail.getOrderid());
            pstmt.setString(2, orderDetail.getProductid());
            pstmt.setInt(3, orderDetail.getQuantity());
            pstmt.setDouble(4, orderDetail.getUnitcost());

            // 5. ִ���޸ģ�C��U��D��
            int affectedRows = pstmt.executeUpdate();
            System.out.printf("�ɹ����� %d �����ݡ�\n", affectedRows);
        } catch (SQLException e) {
            return -1;
        }
        return 0;
    }

    @Override
    public int modify(OrderDetail orderDetail) {
        return 0;
    }

    @Override
    public int remove(OrderDetail orderDetail) {
        return 0;
    }
}
