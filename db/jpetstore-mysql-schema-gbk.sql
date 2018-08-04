/* �������ݿ� */
CREATE DATABASE IF NOT EXISTS petstore;

USE petstore;

/* �û��� */
CREATE TABLE IF NOT EXISTS account (
    userid VARCHAR(80) NOT NULL, /* �û�Id  */
    password VARCHAR(25) NOT NULL, /* �û����� */
    email VARCHAR(80) NOT NULL, /* �û�Email */
    name VARCHAR(80) NOT NULL, /* �û��� */
    addr VARCHAR(80) NOT NULL, /* ��ַ */
    city VARCHAR(80) NOT NULL, /*  ���ڳ��� */
    country VARCHAR(20) NOT NULL, /*  ���� */
    phone VARCHAR(80) NOT NULL, /*  �绰���� */
    PRIMARY KEY (userid)
);

/* ��Ʒ�� */
CREATE TABLE IF NOT EXISTS product (
    productid VARCHAR(10) NOT NULL, /* ��ƷId */
    category VARCHAR(10) NOT NULL, /* ��Ʒ��� */
    cname VARCHAR(80) NULL, /* ��Ʒ������ */
    ename VARCHAR(80) NULL, /* ��ƷӢ���� */
    image VARCHAR(20) NULL, /* ��ƷͼƬ */
    descn VARCHAR(255) NULL, /* ��Ʒ���� */
    listprice DECIMAL(10, 2) NULL, /* ��Ʒ�г��� */
    unitcost DECIMAL(10, 2) NULL, /* ��Ʒ���� */
    PRIMARY KEY (productid)
);

/* ������ */
CREATE TABLE IF NOT EXISTS orders (
    orderid BIGINT NOT NULL, /* ����Id */
    userid VARCHAR(80) NOT NULL, /* �¶������û�Id */
    orderdate DATETIME NOT NULL, /* �¶���ʱ�� */
    status INT NOT NULL DEFAULT 0, /* ��������״̬  0������  1�Ѹ��� */
    amount DECIMAL(10, 2) NOT NULL, /* ����Ӧ����� */
    PRIMARY KEY (orderid)
);

/* ������ϸ�� */
CREATE TABLE IF NOT EXISTS ordersdetail (
    orderid BIGINT NOT NULL, /* ����Id */
    productid VARCHAR(10) NOT NULL, /* ��ƷId */
    quantity INT NOT NULL, /* ��Ʒ���� */
    unitcost DECIMAL(10, 2) NULL, /* ��Ʒ���� */
    PRIMARY KEY (orderid, productid)
);