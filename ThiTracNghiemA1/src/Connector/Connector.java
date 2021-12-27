/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connector;

import CLASS.ThiSinh;
import CLASS.CauHoi;
import CLASS.LichThi;
import CLASS.ThiSinh_DangKi;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author admin
 */
public class Connector {

    Statement stm = null;
    ResultSet rs = null;
    Connection cnn = null;

    //kết nối đến database
    public void getConnectDB() {
        try {
            String url = "jdbc:derby://localhost:1527/ThiSinhDB";
            String user = "NguoiDung";
            String pass = "btl";
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            cnn = (Connection) DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Không thể kết nối database\n" + e);
        }
    }

    public Statement getStatement() {
        Statement stmt = null;
        try {
            stm = cnn.createStatement();
        } catch (SQLException ex) {
            System.out.println("Loi: khong tao duoc ket noi");
        }
        return stmt;
    }

    public ArrayList<ThiSinh> checkVehicleExist(String cmt) throws SQLException {

        ArrayList<ThiSinh> dsTS = new ArrayList<>();
        getConnectDB();
        try {
            stm = cnn.createStatement();
            String query = "select * from THISINH where SOCMT = '" + cmt + "'";
            rs = stm.executeQuery(query);
            while (rs.next()) {
                dsTS.add(new ThiSinh(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getString(8), rs.getDate(9)));
            }
            stm.close();
        } catch (SQLException ex) {
            Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsTS;

    }

    public ArrayList<ThiSinh> getDataThiSinh() {
        ArrayList<ThiSinh> dsTS = new ArrayList<>();
        getConnectDB();
        try {
            stm = cnn.createStatement();
            String query = "SELECT * FROM THISINH";
            rs = stm.executeQuery(query);
            while (rs.next()) {
                dsTS.add(new ThiSinh(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getString(8), rs.getDate(9)));
            }
            stm.close();
        } catch (SQLException ex) {
            Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsTS;
    }
      
    // get
    public ArrayList<CauHoi> getDataCauHoi() {
        ArrayList<CauHoi> dsCauHoi = new ArrayList<>();
        getConnectDB();
        try {
            stm = cnn.createStatement();
            String query = "SELECT * FROM CAU_HOI";
            rs = stm.executeQuery(query);
            while (rs.next()) {
                dsCauHoi.add(new CauHoi(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8)));
            }
            stm.close();
        } catch (SQLException ex) {
            ex.printStackTrace();

        }
        return dsCauHoi;
    }
   
    public ArrayList<ThiSinh> getDataLichThi() {
        ArrayList<ThiSinh> dsLT = new ArrayList<>();
        getConnectDB();
        try {
            stm = cnn.createStatement();
            String query = "SELECT * FROM THISINH";
            rs = stm.executeQuery(query);
            while (rs.next()) {
                dsLT.add(new ThiSinh(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getString(8), rs.getDate(9)));

            }
            stm.close();
        } catch (SQLException ex) {
            Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsLT;
    }

    public ArrayList<ThiSinh> getDataLichThiH() {
        ArrayList<ThiSinh> dsLT = new ArrayList<>();
        getConnectDB();
        try {
            stm = cnn.createStatement();
            String query = "select * from THISINH where SOCMT = '" + 123 + "'";;
            rs = stm.executeQuery(query);
            while (rs.next()) {
            //String soCMT, String hoTen, String gioiTinh, String diaChi, String sdt, Date ngaySinh,int diem,String ketqua,Date ngaythi
                   dsLT.add(new ThiSinh(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getString(8), rs.getDate(9)));
            }
            stm.close();
        } catch (SQLException ex) {
            Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsLT;
    }
     public ArrayList<ThiSinh_DangKi> getDataThiSinh_DangKi() {
        ArrayList<ThiSinh_DangKi> dsTSDK = new ArrayList<>();
        getConnectDB();
        try {
            stm = cnn.createStatement();
            String query = "SELECT * FROM THISINH_DANGKI";
            rs = stm.executeQuery(query);
            while (rs.next()) {
                dsTSDK.add(new ThiSinh_DangKi(rs.getString(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),rs.getDate(7)));
            }
            stm.close();
        } catch (SQLException ex) {
            Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsTSDK;
    }

    
    public ArrayList<ThiSinh> getOneThiSinh(String cmt) {
        ArrayList<ThiSinh> dsTS = new ArrayList<>();
      
        try {
            String query = "SELECT SOCMT FROM THISINH WHERE  = '" + cmt + "'";
            PreparedStatement pre = cnn.prepareStatement(query);
            rs = pre.executeQuery();
            while (rs.next()) {
          //      dsTS.add(new ThiSinh(rs.getString(1)));
            }
            stm.close();
        } catch (SQLException ex) {
            Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsTS;
    }
      public void doSQL(String sql)  {
        try {
            stm = cnn.createStatement();
            stm.executeUpdate(sql);
        } catch (SQLException ex) {
            System.out.println(" khong thuc hien dc cau lẹnh sql\n"+sql);
        }
     
 }
    //thuc hien cap nhat bang du lieu- them-sua -xoa
    public boolean UpdateData(String query) {
        getConnectDB();
        int row = 0;
        try {
            stm = (Statement) cnn.createStatement();
            row = stm.executeUpdate(query);
            if (row > 0) {
                return true;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        } finally {
            CloseConnect();
        }
        return false;
    }

    //đóng kết nối
    public void CloseConnect() {
        if (cnn != null) {
            try {
                cnn.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }
}
