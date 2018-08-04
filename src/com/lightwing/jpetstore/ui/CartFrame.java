package com.lightwing.jpetstore.ui;

import com.lightwing.jpetstore.dao.OrderDao;
import com.lightwing.jpetstore.dao.OrderDetailDao;
import com.lightwing.jpetstore.dao.ProductDao;
import com.lightwing.jpetstore.dao.mysql.OrderDaoImp;
import com.lightwing.jpetstore.dao.mysql.OrderDetailDaoImp;
import com.lightwing.jpetstore.dao.mysql.ProductDaoImp;
import com.lightwing.jpetstore.domain.Order;
import com.lightwing.jpetstore.domain.OrderDetail;
import com.lightwing.jpetstore.domain.Product;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;
import java.util.Date;
import java.util.Map;
import java.util.Set;

//��Ʒ���ﳵ����
public class CartFrame extends MyFrame {
    private JTable table;
    // ���ﳵ����
    private Object[][] data = null;
    // ������ƷDao����
    private ProductDao dao = new ProductDaoImp();
    // ���ﳵ������ѡ�����ƷId��ֵ����Ʒ������
    private Map<String, Integer> cart;
    // ���õ��ϼ�Frame��ProductListFrame��
    private ProductListFrame productListFrame;

    public CartFrame(Map<String, Integer> cart, ProductListFrame productListFrame) {
        super("��Ʒ���ﳵ", 1000, 700);
        this.cart = cart;
        this.productListFrame = productListFrame;
        JPanel topPanel = new JPanel();
        FlowLayout fl_topPanel = (FlowLayout) topPanel.getLayout();
        fl_topPanel.setVgap(10);
        fl_topPanel.setHgap(20);
        getContentPane().add(topPanel, BorderLayout.NORTH);
        JButton btnReturn = new JButton("������Ʒ�б�");
        btnReturn.setFont(new Font("΢���ź�", Font.PLAIN, 15));
        topPanel.add(btnReturn);
        JButton btuSubmit = new JButton("�ύ����");
        topPanel.add(btuSubmit);
        btuSubmit.setFont(new Font("΢���ź�", Font.PLAIN, 15));
        JScrollPane scrollPane = new JScrollPane();
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        scrollPane.setViewportView(getTable());
        // ע�ᡸ�ύ��������ť�� ActionEvent �¼�������
        btuSubmit.addActionListener(e -> {
            // ���ɶ���
            generateOrders();
            JLabel label = new JLabel("�����Ѿ����ɣ��ȴ����");
            label.setFont(new Font("΢���ź�", Font.PLAIN, 15));
            if (JOptionPane.showConfirmDialog(this, label, "��Ϣ", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                // TODO ����
                System.exit(0);
            } else
                System.exit(0);
        });
        // ע�ᡸ������Ʒ�б���ť�� ActionEvent �¼�������
        btnReturn.addActionListener(e -> {
            // ���¹��ﳵ
            for (Object[] aData : data) {
                // ��Ʒ���
                String productid = (String)
                        aData[0];
                // ����
                Integer quantity = (Integer) aData[3];
                cart.put(productid, quantity);
            }
            this.productListFrame.setVisible(true);
            setVisible(false);
        });
    }

    // ��ʼ���������еı��ؼ�
    private JTable getTable() {
        // ׼����������
        data = new Object[cart.size()][5];
        Set<String> keys = this.cart.keySet();
        int indx = 0;

        for (String productid : keys) {
            Product p = dao.findById(productid);
            data[indx][0] = p.getProductid();// ��Ʒ���
            data[indx][1] = p.getCname();// ��Ʒ��
            data[indx][2] = p.getUnitcost();// ��Ʒ����
            data[indx][3] = cart.get(productid);// ����
            // ������ƷӦ�����
            double amount = (double) data[indx][2] * (int) data[indx][3];
            data[indx][4] = amount;
            indx++;
        }

        // ����������ģ��
        TableModel model = new CartTableModel(data);
        if (table == null) {
            // ������
            table = new JTable(model);
            // ���ñ�����������
            table.setFont(new Font("΢���ź�", Font.PLAIN, 16));
            // ���ñ��б�������
            table.getTableHeader().setFont(new Font("΢���ź�", Font.BOLD, 16));
            // ���ñ��и�
            table.setRowHeight(51);
            table.setRowSelectionAllowed(false);
        } else
            table.setModel(model);
        return table;
    }

    // ���ɶ���
    private void generateOrders() {
        OrderDao orderDao = new OrderDaoImp();
        OrderDetailDao orderDetailDao = new OrderDetailDaoImp();
        Order order = new Order();
        order.setUserid(MainApp.account.getUserid());
        // 0������
        order.setStatus(0);
        // ����Id�ǵ�ǰʱ��
        Date now = new Date();
        long orderId = now.getTime();
        order.setOrderid(orderId);
        order.setOrderdate(now);
        order.setAmount(getOrderTotalAmount());
        // �¶���ʱ�������ݿ��Զ����ɲ�������
        // ��������
        orderDao.create(order);
        for (Object[] aData : data) {
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setOrderid(orderId);
            orderDetail.setProductid((String) aData[0]);
            orderDetail.setQuantity((int) aData[3]);
            orderDetail.setUnitcost((double) aData[2]);
            // ����������ϸ
            orderDetailDao.create(orderDetail);
        }
    }

    // ���㶩��Ӧ���ܽ��
    private double getOrderTotalAmount() {
        double totalAmount = 0.0;
        for (Object[] aData : data) {
            // ������ƷӦ�����
            totalAmount += (Double) aData[4];
        }
        return totalAmount;
    }
}
