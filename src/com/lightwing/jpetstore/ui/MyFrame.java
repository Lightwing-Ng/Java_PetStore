package com.lightwing.jpetstore.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

// ����һ����Ļ���е��Զ��崰��
public class MyFrame extends JFrame {
    public MyFrame(String title, int width, int height) {
        super(title);
        // ���ô��ڴ�С
        setSize(width, height);
        // ���㴰��λ����Ļ���ĵ�����
        // ��õ�ǰ��Ļ�Ŀ�
        double screenWidth = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        int x = (int) (screenWidth - width) / 2;
        // ��õ�ǰ��Ļ�ĸ�
        double screenHeight = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        int y = (int) (screenHeight - height) / 2;
        // ���ô���λ����Ļ����
        setLocation(x, y);
        // ע�ᴰ���¼�
        addWindowListener(new WindowAdapter() {
            // �������ڹرհ�ťʱ����
            public void windowClosing(WindowEvent e) {
                // �˳�ϵͳ
                System.exit(0);
            }
        });
    }
}
