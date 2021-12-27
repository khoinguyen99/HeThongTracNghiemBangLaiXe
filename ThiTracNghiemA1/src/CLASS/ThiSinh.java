/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CLASS;

import java.util.Date;

/**
 *
 * @author Dell
 */
public class ThiSinh {

    private String soCMT, hoTen, gioiTinh, diaChi, sdt, ketqua;
    private Date ngaySinh,ngaythi;
    private int diem;

     public ThiSinh() {
        this.soCMT = "";
        this.hoTen = "";
        this.gioiTinh = "";
        this.diaChi = "";
        this.sdt = "";
        this.ketqua = "";
        this.ngaySinh = null;
        this.diem = 0;
    }

    public ThiSinh(String soCMT, String hoTen, String gioiTinh, Date ngaySinh,String diaChi, String sdt,int diem,String ketqua,Date ngaythi) {
        this.soCMT = soCMT;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.ketqua = ketqua;
        this.ngaySinh = ngaySinh;
        this.ngaythi = ngaythi;
        this.diem = diem;
    }

    public Date getNgaythi() {
        return ngaythi;
    }

    public void setNgaythi(Date ngaythi) {
        this.ngaythi = ngaythi;
    }
   

    public String getSoCMT() {
        return soCMT;
    }

    public void setSoCMT(String soCMT) {
        this.soCMT = soCMT;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getKetqua() {
        return ketqua;
    }

    public void setKetqua(String ketqua) {
        this.ketqua = ketqua;
    }

   

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public int getDiem() {
        return diem;
    }

    public void setDiem(int diem) {
        this.diem = diem;
    }

}
