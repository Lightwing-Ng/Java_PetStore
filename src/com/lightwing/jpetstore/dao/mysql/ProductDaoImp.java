package com.lightwing.jpetstore.dao.mysql;

import com.lightwing.jpetstore.dao.ProductDao;
import com.lightwing.jpetstore.domain.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// ��Ʒ���� DAO
public class ProductDaoImp implements ProductDao {
    @Override
    public List<Product> findAll() {
        String sql = "SELECT `productid`, `category`, `cname`, `ename`, `image`,"
                + "`listprice`, `unitcost`, `descn` " +
                "FROM `product`";
        List<Product> products = new ArrayList<Product>();
        try (// 2.�������ݿ�����
             Connection conn = DBHelper.getConnection();
             // 3. ����������
             PreparedStatement pstmt = conn.prepareStatement(sql);
             // 4. �󶨲���
             // 5. ִ�в�ѯ��R��
             ResultSet rs = pstmt.executeQuery()) {
            // 6. ���������
            while (rs.next()) {
                Product p = new Product();
                p.setProductid(rs.getString("productid"));
                p.setCategory(rs.getString("category"));
                p.setCname(rs.getString("cname"));
                p.setEname(rs.getString("ename"));
                p.setImage(rs.getString("image"));
                p.setListprice(rs.getDouble("listprice"));
                p.setUnitcost(rs.getDouble("unitcost"));
                p.setDescn(rs.getString("descn"));
                products.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public List<Product> findByCategory(String category) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Product> products = new ArrayList<Product>();

        try {
            // 2.�������ݿ�����
            conn = DBHelper.getConnection();
            // 3. ����������
            String sql = "SELECT " +
                    "`productid`, `category`, `cname`, `ename`, `image`, `listprice`, `unitcost`," +
                    " `descn` "
                    + "FROM `product` WHERE `category` = ?";
            pstmt = conn.prepareStatement(sql);
            // 4. �󶨲���
            pstmt.setString(1, category);
            // 5. ִ�в�ѯ��R��
            rs = pstmt.executeQuery();
            // 6. ���������
            while (rs.next()) {
                Product p = new Product();
                p.setProductid(rs.getString("productid"));
                p.setCategory(rs.getString("category"));
                p.setCname(rs.getString("cname"));
                p.setEname(rs.getString("ename"));
                p.setImage(rs.getString("image"));
                p.setListprice(rs.getDouble("listprice"));
                p.setUnitcost(rs.getDouble("unitcost"));
                p.setDescn(rs.getString("descn"));
                products.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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

        return products;
    }

    @Override
    public Product findById(String productid) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // 2.�������ݿ�����
            conn = DBHelper.getConnection();
            // 3. ����������
            String sql = "SELECT " +
                    "`productid`, `category`, `cname`, `ename`, `image`, `listprice`, `unitcost`," +
                    "`descn` "
                    + "FROM `product` WHERE `productid` = ?";
            pstmt = conn.prepareStatement(sql);
            // 4. �󶨲���
            pstmt.setString(1, productid);
            // 5. ִ�в�ѯ��R��
            rs = pstmt.executeQuery();

            // 6. ���������
            if (rs.next()) {
                Product p = new Product();
                p.setProductid(rs.getString("productid"));
                p.setCategory(rs.getString("category"));
                p.setCname(rs.getString("cname"));
                p.setEname(rs.getString("ename"));
                p.setImage(rs.getString("image"));
                p.setListprice(rs.getDouble("listprice"));
                p.setUnitcost(rs.getDouble("unitcost"));
                p.setDescn(rs.getString("descn"));
                return p;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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
    public int create(Product product) {
        return 0;
    }

    @Override
    public int modify(Product product) {
        return 0;
    }

    @Override
    public int remove(Product product) {
        return 0;
    }
}