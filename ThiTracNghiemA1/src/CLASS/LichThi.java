/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CLASS;

import java.util.Date;



/**
 *
 * @author Admin
 */


public class LichThi {
     private String hoten,gioitinh,diachi,soCMT;
     private Date ngaysinh,ngaythi;

    public LichThi(String soCMT, String hoten, String gioitinh, Date ngaysinh,String diachi, Date ngaythi) {
        this.hoten = hoten;
        this.gioitinh = gioitinh;
        this.diachi = diachi;
        this.soCMT = soCMT;
        this.ngaysinh = ngaysinh;
        this.ngaythi = ngaythi;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getSoCMT() {
        return soCMT;
    }

    public void setSoCMT(String soCMT) {
        this.soCMT = soCMT;
    }

    public Date getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(Date ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public Date getNgaythi() {
        return ngaythi;
    }

    public void setNgaythi(Date ngaythi) {
        this.ngaythi = ngaythi;
    }

    
     
    
   
     
      
     
    
   

    
    
}
