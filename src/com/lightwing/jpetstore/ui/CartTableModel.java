package com.lightwing.jpetstore.ui;

import javax.swing.table.AbstractTableModel;

// ���ﳵ���ģ��
public class CartTableModel extends AbstractTableModel {

    // �������columnNames
    private String[] columnNames = {
            "��Ʒ���", "��Ʒ��", "��Ʒ����", "����", "��ƷӦ�����"
    };

    // ��������ݱ�����data��ά������
    private Object[][] data;

    public CartTableModel(Object[][] data) {
        this.data = data;
    }

    // ��������
    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    // ��������
    @Override
    public int getRowCount() {
        return data.length;
    }

    // ���ĳ��ĳ�е����ݣ������ݱ����ڶ�������data��
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data[rowIndex][columnIndex];
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        // �����п����޸�
        return columnIndex == 3;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        // ֻ�����޸�������
        if (columnIndex != 3) {
            return;
        }
        try {
            // �ӱ��л���޸�֮�����Ʒ�������ӱ���������ݶ�String����
            int quantity = new Integer((String) aValue);
            // ��Ʒ��������С��0
            if (quantity < 0) {
                return;
            }
            // ����������
            data[rowIndex][3] = quantity;
            // ������ƷӦ�����
            double unitcost = (double) data[rowIndex][2];
            double totalPrice = unitcost * quantity;
            // ������ƷӦ�������
            data[rowIndex][4] = totalPrice;
        } catch (Exception ignored) {
        }
    }

}
