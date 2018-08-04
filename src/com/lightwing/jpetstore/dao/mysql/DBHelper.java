package com.lightwing.jpetstore.dao.mysql;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

// ���ݿ⸨����
class DBHelper {
    // �������ݿ�url
    private static String url;
    // ����Properties����
    private static Properties info = new Properties();

    // 1.�����������
    static {
        // ��������ļ�������
        InputStream input = DBHelper.class.getClassLoader()
                .getResourceAsStream("com/lightwing/jpetstore/dao/mysql/config.properties");
        try {
            // ���������ļ����ݵ� Properties ����
            info.load(input);
            // �������ļ���ȡ�� URL
            url = info.getProperty("url");
            // �������ļ���ȡ��driver
            String driverClassName = info.getProperty("driver");
            Class.forName(driverClassName);
            System.out.println("����������سɹ�...");
        } catch (ClassNotFoundException e) {
            System.out.println("�����������ʧ��...");
        } catch (IOException e) {
            System.out.println("���������ļ�ʧ��...");
        }
    }

    // ������ݿ�����
    static Connection getConnection() throws SQLException {
        // �������ݿ�����
        Connection conn = DriverManager.getConnection(url, info);
        return conn;
    }
}
