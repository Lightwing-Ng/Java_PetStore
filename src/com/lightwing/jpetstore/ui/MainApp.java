package com.lightwing.jpetstore.ui;

import com.lightwing.jpetstore.domain.Account;

// ������
public class MainApp {
    // �û���¼�ɹ��󣬱��浱ǰ�û���Ϣ
    static Account account;

    public static void main(String[] args) {
        LoginFrame frame = new LoginFrame();
        frame.setVisible(true);
    }
}
