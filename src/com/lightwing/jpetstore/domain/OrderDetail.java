package com.lightwing.jpetstore.domain;

// Order Detail
public class OrderDetail {
    private long orderid;       // Order ID
    private String productid;   // Product ID
    private int quantity;       // Product Quantity
    private double unitcost;    // Unit Cost

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
