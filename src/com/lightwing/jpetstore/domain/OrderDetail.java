package com.lightwing.jpetstore.domain;

// ������ϸ
public class OrderDetail {
    private long orderid;       // ����Id
    private String productid;   // ��ƷId
    private int quantity;       // ��Ʒ����
    private double unitcost;    // ����

    public long getOrderid() {
        return orderid;
    }

    public void setOrderid(long orderid) {
        this.orderid = orderid;
    }

    public double getUnitcost() {
        return unitcost;
    }

    public void setUnitcost(double unitcost) {
        this.unitcost = unitcost;
    }

    public String getProductid() {
        return productid;
    }

    public void setProductid(String productid) {
        this.productid = productid;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
