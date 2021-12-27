/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CLASS;

import CLASS.CauHoi;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Dell
 */
public class CustomtableQuanLyCauHoi extends AbstractTableModel {

    private final String name[] = {"Mã Câu hỏi", "Câu hỏi", "Đáp án 1", "Đáp án 2", "Đáp án 3", "Đáp án 4", "Đáp án đúng", "Hình ảnh câu hỏi"};
    private final Class classes[] = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
    ArrayList<CauHoi> dsch = new ArrayList<>();

    public CustomtableQuanLyCauHoi(ArrayList<CauHoi> dsch) {
        this.dsch = dsch;
    }

    @Override
    public int getRowCount() {
        return dsch.size();
    }

    @Override
    public int getColumnCount() {
        return name.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return dsch.get(rowIndex).getMaCauHoi();
            case 1:
                return dsch.get(rowIndex).getCauHoi();
            case 2:
                return dsch.get(rowIndex).getDapAn1();
            case 3:
                return dsch.get(rowIndex).getDapAn2();
            case 4:
                return dsch.get(rowIndex).getDapAn3();
            case 5:
                return dsch.get(rowIndex).getDapAn4();
            case 6:
                return dsch.get(rowIndex).getDapAnDung();
            case 7:
                return dsch.get(rowIndex).getHinhAnhCauHoi();
            case 8:
                return dsch.get(rowIndex).getMaCauHoi();

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
