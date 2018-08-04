package com.lightwing.jpetstore.ui;

import com.lightwing.jpetstore.domain.Product;

import javax.swing.table.AbstractTableModel;
import java.util.List;

// 商品列表表格模型
public class ProductTableModel extends AbstractTableModel {
    // 表格列名 columnNames
    private String[] columnNames = {
            "Product ID",
            "Category",
            "Chinese Name",
            "English Name"
    };

    // 表格中的数据内容保存在 List 集合中
    private List<Product> data;

    public ProductTableModel(List<Product> data) {
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
        return data.size();
    }

    // 获得某行某列的数据，而数据保存在对象数组data中
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        // 每一行就是一个 Product 商品对象
        Product p = data.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return p.getProductid();    // 第一列商品编号
            case 1:
                return p.getCategory();     // 第二列商品类别
            case 2:
                return p.getCname();        // 商品中文名
            default:
                return p.getEname();        // 商品英文名
        }
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }
}
