package com.lightwing.jpetstore.ui;

import com.lightwing.jpetstore.domain.Product;

import javax.swing.table.AbstractTableModel;
import java.util.List;

// ��Ʒ�б���ģ��
public class ProductTableModel extends AbstractTableModel {
    // ������� columnNames
    private String[] columnNames = {
            "Product ID",
            "Category",
            "Chinese Name",
            "English Name"
    };

    // ����е��������ݱ����� List ������
    private List<Product> data;

    public ProductTableModel(List<Product> data) {
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
        return data.size();
    }

    // ���ĳ��ĳ�е����ݣ������ݱ����ڶ�������data��
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        // ÿһ�о���һ�� Product ��Ʒ����
        Product p = data.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return p.getProductid();    // ��һ����Ʒ���
            case 1:
                return p.getCategory();     // �ڶ�����Ʒ���
            case 2:
                return p.getCname();        // ��Ʒ������
            default:
                return p.getEname();        // ��ƷӢ����
        }
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }
}
