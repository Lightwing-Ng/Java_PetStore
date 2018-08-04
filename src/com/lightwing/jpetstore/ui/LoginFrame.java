package com.lightwing.jpetstore.ui;

import com.lightwing.jpetstore.dao.AccountDao;
import com.lightwing.jpetstore.dao.mysql.AccountDaoImp;
import com.lightwing.jpetstore.domain.Account;

import javax.swing.*;
import java.awt.*;

// �û���¼����
public class LoginFrame extends MyFrame {

    private JTextField txtAccountId;
    private JPasswordField txtPassword;

    public LoginFrame() {
        super("User Login", 400, 230);
        // ���ò��ֹ���Ϊ���Բ���
        getContentPane().setLayout(null);
        JLabel label1 = new JLabel();
        label1.setHorizontalAlignment(SwingConstants.RIGHT);
        label1.setBounds(51, 33, 83, 30);
        getContentPane().add(label1);
        label1.setText("Account: ");
        label1.setFont(new Font("CamingoCode", Font.PLAIN, 15));

        txtAccountId = new JTextField(10);
        txtAccountId.setText("j2ee");
        txtAccountId.setBounds(158, 33, 157, 30);
        txtAccountId.setFont(new Font("CamingoCode", Font.PLAIN, 15));
        getContentPane().add(txtAccountId);

        JLabel label2 = new JLabel();
        label2.setText("Password: ");
        label2.setFont(new Font("CamingoCode", Font.PLAIN, 15));
        label2.setHorizontalAlignment(SwingConstants.RIGHT);
        label2.setBounds(51, 85, 83, 30);
        getContentPane().add(label2);

        txtPassword = new JPasswordField(10);
        txtPassword.setText("j2ee");
        txtPassword.setBounds(158, 85, 157, 30);
        getContentPane().add(txtPassword);

        JButton btnOk = new JButton();
        btnOk.setText("Confirm");
        btnOk.setFont(new Font("CamingoCode", Font.PLAIN, 15));
        btnOk.setBounds(61, 140, 100, 30);
        getContentPane().add(btnOk);

        JButton btnCancel = new JButton();
        btnCancel.setText("Cancel");
        btnCancel.setFont(new Font("CamingoCode", Font.PLAIN, 15));
        btnCancel.setBounds(225, 140, 100, 30);
        getContentPane().add(btnCancel);

        // ע�� btnOk �� ActionEvent �¼�������
        btnOk.addActionListener(e -> {
            AccountDao accountDao = new AccountDaoImp();
            Account account = accountDao.findById(txtAccountId.getText());
            String passwordText = new String(txtPassword.getPassword());
            if (account != null && passwordText.equals(account.getPassword())) {
                System.out.println("��¼�ɹ���");
                ProductListFrame form = new ProductListFrame();
                form.setVisible(true);
                setVisible(false);
                //�û���¼�ɹ��󣬽��û���Ϣ���浽 MainApp.account ��̬������
                MainApp.account = account;
            } else {
                JLabel label = new JLabel("Your password or username may be wrong!");
                label.setFont(new Font("CamingoCode", Font.PLAIN, 15));
                JOptionPane.showMessageDialog(null, label,
                        "Error!", JOptionPane.ERROR_MESSAGE);
            }

        });

        // ע�� btnCancel �� ActionEvent �¼�������
        btnCancel.addActionListener(e -> {
            // �˳�ϵͳ
            System.exit(0);
        });
    }
}
