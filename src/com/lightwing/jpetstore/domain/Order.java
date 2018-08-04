package com.lightwing.jpetstore.domain;

import java.util.Date;

public class Order {
    private long orderid;   // Order ID
    private String userid;  // User ID who takes the order
    private Date orderdate; // Time
    private int status;     // Order Status: 0 - Pending, 1 - Paid
    private double amount;  // Amount

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public long getOrderid() {
        return orderid;
    }

    public void setOrderid(long orderid) {
        this.orderid = orderid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public Date getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(Date orderdate) {
        this.orderdate = orderdate;
    }
}
