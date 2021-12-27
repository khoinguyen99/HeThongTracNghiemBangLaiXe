/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CLASS;

import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Dell
 */
public class TableThiSinh extends AbstractTableModel {

    private final String name[] = {"Số CMT", "Họ tên", "Giới tính", "Ngày sịnh", "Địa chỉ", "SDT"};
    private final Class classes[] = {String.class, String.class, String.class, Date.class, String.class, String.class};
    ArrayList<ThiSinh> dsTS = new ArrayList<>();

    public TableThiSinh(ArrayList<ThiSinh> dsTS) {
        this.dsTS = dsTS;
    }

    @Override
    public int getRowCount() {
        return dsTS.size();
    }

    @Override
    public int getColumnCount() {
        return name.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return dsTS.get(rowIndex).getSoCMT();
            case 1:
                return dsTS.get(rowIndex).getHoTen();
            case 2:
                return dsTS.get(rowIndex).getGioiTinh();
            case 3:
                return dsTS.get(rowIndex).getNgaySinh();
            case 4:
                return dsTS.get(rowIndex).getDiaChi();
            case 5:
                return dsTS.get(rowIndex).getSdt();
        }
        return null;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return classes[columnIndex]; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getColumnName(int column) {
        return name[column]; //To change body of generated methods, choose Tools | Templates.
    }

}
