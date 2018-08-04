package com.lightwing.jpetstore.ui;

import javax.swing.table.AbstractTableModel;

// 购物车表格模型
public class CartTableModel extends AbstractTableModel {

    // 表格列名columnNames
    private String[] columnNames = {
            "商品编号", "商品名", "商品单价", "数量", "商品应付金额"
    };

    // 表格中数据保存在data二维数组中
    private Object[][] data;

    public CartTableModel(Object[][] data) {
        this.data = data;
    }

    // 返回列数
    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    // 返回行数
    @Override
    public int getRowCount() {
        return data.length;
    }

    // 获得某行某列的数据，而数据保存在对象数组data中
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
        // 数量列可以修改
        return columnIndex == 3;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        // 只允许修改数量列
        if (columnIndex != 3) {
            return;
        }
        try {
            // 从表中获得修改之后的商品数量，从表而来的数据都String类型
            int quantity = new Integer((String) aValue);
            // 商品数量不能小于0
            if (quantity < 0) {
                return;
            }
            // 更新数量列
            data[rowIndex][3] = quantity;
            // 计算商品应付金额
            double unitcost = (double) data[rowIndex][2];
            double totalPrice = unitcost * quantity;
            // 更新商品应付金额列
            data[rowIndex][4] = totalPrice;
        } catch (Exception ignored) {
        }
    }

}
