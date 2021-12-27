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
 * @author Admin
 */
public class TableLichThi extends AbstractTableModel {

    private final String name[] = {"SOCMT", "HOTEN", "GIOITINH", "NGAYSINH", "DIACHI", "NGAYTHI"};
    private final Class classes[] = {String.class, String.class, String.class, Date.class, String.class, Date.class};
    ArrayList<ThiSinh> dsLT = new ArrayList<ThiSinh>();

    public TableLichThi(ArrayList<ThiSinh> dsLT) {
        this.dsLT = dsLT;
    }

    @Override
    public int getRowCount() {
        return dsLT.size();
    }

    @Override
    public int getColumnCount() {
        return name.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return dsLT.get(rowIndex).getSoCMT();
            case 1:
                return dsLT.get(rowIndex).getHoTen();
            case 2:
                return dsLT.get(rowIndex).getGioiTinh();
            case 3:
                return dsLT.get(rowIndex).getNgaySinh();
            case 4:
                return dsLT.get(rowIndex).getDiaChi();
            case 5:
                return dsLT.get(rowIndex).getNgaythi();

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
