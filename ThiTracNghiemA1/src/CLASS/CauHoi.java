/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package CLASS;

/**
 *
 * @author Dell
 */
public class CauHoi {
   private String maCauHoi,cauHoi,dapAn1,dapAn2,dapAn3,dapAn4,dapAnDung,hinhAnhCauHoi;

    public CauHoi(String maCauHoi, String cauHoi, String dapAn1, String dapAn2, String dapAn3, String dapAn4, String dapAnDung, String hinhAnhCauHoi) {
        this.maCauHoi = maCauHoi;
        this.cauHoi = cauHoi;
        this.dapAn1 = dapAn1;
        this.dapAn2 = dapAn2;
        this.dapAn3 = dapAn3;
        this.dapAn4 = dapAn4;
        this.dapAnDung = dapAnDung;
        this.hinhAnhCauHoi = hinhAnhCauHoi;
    }
  
   
   
   
    public String getMaCauHoi() {
        return maCauHoi;
    }

    public void setMaCauHoi(String maCauHoi) {
        this.maCauHoi = maCauHoi;
    }

    public String getCauHoi() {
        return cauHoi;
    }

    public void setCauHoi(String cauHoi) {
        this.cauHoi = cauHoi;
    }

    public String getDapAn1() {
        return dapAn1;
    }

    public void setDapAn1(String dapAn1) {
        this.dapAn1 = dapAn1;
    }

    public String getDapAn2() {
        return dapAn2;
    }

    public void setDapAn2(String dapAn2) {
        this.dapAn2 = dapAn2;
    }

    public String getDapAn3() {
        return dapAn3;
    }

    public void setDapAn3(String dapAn3) {
        this.dapAn3 = dapAn3;
    }

    public String getDapAn4() {
        return dapAn4;
    }

    public void setDapAn4(String dapAn4) {
        this.dapAn4 = dapAn4;
    }

    public String getDapAnDung() {
        return dapAnDung;
    }

    public void setDapAnDung(String dapAnDung) {
        this.dapAnDung = dapAnDung;
    }

    public String getHinhAnhCauHoi() {
        return hinhAnhCauHoi;
    }

    public void setHinhAnhCauHoi(String hinhAnhCauHoi) {
        this.hinhAnhCauHoi = hinhAnhCauHoi;
    }
   
}
