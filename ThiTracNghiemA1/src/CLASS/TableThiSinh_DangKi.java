/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CLASS;

import java.util.ArrayList;
import java.util.Date;
import java.util.EventListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author NguyenVanBac
 */
public class TableThiSinh_DangKi extends AbstractTableModel {

    private final String name[] = {"Họ tên", "Địa Chỉ", "Giới Tính", "Khóa Học", "Email", "SĐT", "Ngày Sinh"};
    private final Class classes[] = {String.class, String.class, String.class, String.class, String.class, String.class, Date.class};
    ArrayList<ThiSinh_DangKi> dsTSDK = new ArrayList<>();

    public TableThiSinh_DangKi(ArrayList<ThiSinh_DangKi> dsTSDK) {
        this.dsTSDK = dsTSDK;
    }

    @Override
    public int getRowCount() {
        return dsTSDK.size();
    }

    @Override
    public int getColumnCount() {
        return name.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return dsTSDK.get(rowIndex).getHoTen();
            case 1:
                return dsTSDK.get(rowIndex).getDiaChi();
            case 2:
                return dsTSDK.get(rowIndex).getGioiTinh();
            case 3:
                return dsTSDK.get(rowIndex).getKhoaHoc();
            case 4:
                return dsTSDK.get(rowIndex).getEmail();
            case 5:
                return dsTSDK.get(rowIndex).getSdt();
            case 6:
                return dsTSDK.get(rowIndex).getNgaySinh();
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
