/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* �ض��� Created on:     2017/6/26 11:29:48                     */
/*==============================================================*/

USE petstore;

/* �û������� */
INSERT INTO account
VALUES ('j2ee', 'j2ee', 'yourname@yourdomain.com', '�ض���', '������̨��', '����', '�й�', '18811588888');
INSERT INTO account VALUES
    ('ACID', 'ACID', 'acid@yourdomain.com', 'Tony', '901 San Antonio Road', 'Palo Alto', 'USA',
     '555-555-5555');

/* ��Ʒ������ */
INSERT INTO product
VALUES ('FI-SW-01', '����', '������', 'Angelfish', 'fish1.jpg', '���԰Ĵ����ǵ���ˮ��', 650, 400);
INSERT INTO product
VALUES ('FI-SW-02', '����', '����', 'Tiger Shark', 'fish4.gif', '���԰Ĵ����ǵ���ˮ��', 850, 600);
INSERT INTO product VALUES ('FI-FW-01', '����', '����', 'Koi', 'fish3.gif', '�����ձ���ˮ��', 150, 120);
INSERT INTO product VALUES ('FI-FW-02', '����', '����', 'Goldfish', 'fish2.gif', '�����й��ĵ�ˮ��', 150, 120);
INSERT INTO product
VALUES ('K9-BD-01', '����', '��ţȮ', 'Bulldog', 'dog2.gif', '����Ӣ���Ѻõİ���Ȯ', 1500, 1200);
INSERT INTO product VALUES ('K9-PO-02', '����', 'ʨ�ӹ�', 'Poodle', 'dog6.gif', '���Է����ɰ�����', 1250, 1000);
INSERT INTO product
VALUES ('K9-DL-01', '����', '�ߵ㹷', 'Dalmation', 'dog5.gif', '�кܶ�ߵ�Ĺ���', 2150, 2000);
INSERT INTO product
VALUES ('K9-RT-01', '����', '��ë��Ȯ', 'Golden Retriever', 'dog1.gif', '�ܺõİ���Ȯ', 3800, 3400);
INSERT INTO product
VALUES ('K9-RT-02', '����', '��������Ȯ', 'Labrador Retriever', 'dog5.gif', '�ܺõ�����Ȯ', 3600, 3020);
INSERT INTO product VALUES ('K9-CW-01', '����', '������', 'Chihuahua', 'dog4.gif', '�Ը���˳�Ĺ���', 1500, 120);
INSERT INTO product
VALUES ('RP-SN-01', '������', '��β��', 'Rattlesnake', 'lizard3.gif', '������Σ�յĶ���', 150, 110);
INSERT INTO product
VALUES ('RP-LI-02', '������', '������', 'Iguana', 'lizard2.gif', '���滷��������ǿ���ı���ɫ', 1600, 1203);
INSERT INTO product
VALUES ('FL-DSH-01', 'è��', '�����è', 'Manx', 'cat3.gif', '������Ч�ؼ���������������кô�', 2503, 2120);
INSERT INTO product VALUES ('FL-DLH-02', 'è��', '��˹', 'Persian', 'cat1.gif', '�ǳ��õļ�è', 3150, 2620);
INSERT INTO product
VALUES ('AV-CB-01', '����', '����ѷ����', 'Amazon Parrot', 'bird4.gif', '��������75��Ĵ���', 3150, 3000);
INSERT INTO product VALUES ('AV-SB-02', '����', 'ȸ������', 'Finch', 'bird1.gif', '�ᳪ������', 150, 110);
