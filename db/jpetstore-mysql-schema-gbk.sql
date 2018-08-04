/* 创建数据库 */
CREATE DATABASE IF NOT EXISTS petstore;

USE petstore;

/* 用户表 */
CREATE TABLE IF NOT EXISTS account (
    userid VARCHAR(80) NOT NULL, /* 用户Id  */
    password VARCHAR(25) NOT NULL, /* 用户密码 */
    email VARCHAR(80) NOT NULL, /* 用户Email */
    name VARCHAR(80) NOT NULL, /* 用户名 */
    addr VARCHAR(80) NOT NULL, /* 地址 */
    city VARCHAR(80) NOT NULL, /*  所在城市 */
    country VARCHAR(20) NOT NULL, /*  国家 */
    phone VARCHAR(80) NOT NULL, /*  电话号码 */
    PRIMARY KEY (userid)
);

/* 商品表 */
CREATE TABLE IF NOT EXISTS product (
    productid VARCHAR(10) NOT NULL, /* 商品Id */
    category VARCHAR(10) NOT NULL, /* 商品类别 */
    cname VARCHAR(80) NULL, /* 商品中文名 */
    ename VARCHAR(80) NULL, /* 商品英文名 */
    image VARCHAR(20) NULL, /* 商品图片 */
    descn VARCHAR(255) NULL, /* 商品描述 */
    listprice DECIMAL(10, 2) NULL, /* 商品市场价 */
    unitcost DECIMAL(10, 2) NULL, /* 商品单价 */
    PRIMARY KEY (productid)
);

/* 订单表 */
CREATE TABLE IF NOT EXISTS orders (
    orderid BIGINT NOT NULL, /* 订单Id */
    userid VARCHAR(80) NOT NULL, /* 下订单的用户Id */
    orderdate DATETIME NOT NULL, /* 下订单时间 */
    status INT NOT NULL DEFAULT 0, /* 订单付款状态  0待付款  1已付款 */
    amount DECIMAL(10, 2) NOT NULL, /* 订单应付金额 */
    PRIMARY KEY (orderid)
);

/* 订单明细表 */
CREATE TABLE IF NOT EXISTS ordersdetail (
    orderid BIGINT NOT NULL, /* 订单Id */
    productid VARCHAR(10) NOT NULL, /* 商品Id */
    quantity INT NOT NULL, /* 商品数量 */
    unitcost DECIMAL(10, 2) NULL, /* 商品单价 */
    PRIMARY KEY (orderid, productid)
);