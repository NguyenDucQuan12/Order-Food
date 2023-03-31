package com.example.dauhouse.DTO;

public class NhanVienDTO {

    static int MNV,CMND;
    static String TENDN;
    static String MATKHAU;
    static String GIOITINH;
    static String NGAYSINH;

    public static int getMNV() {
        return MNV;
    }

    public void setMNV(int MNV) {
        this.MNV = MNV;
    }

    public static int getCMND() {
        return CMND;
    }

    public void setCMND(int CMND) {
        this.CMND = CMND;
    }

    public static String getTENDN() {
        return TENDN;
    }

    public void setTENDN(String TENDN) {
        this.TENDN = TENDN;
    }

    public static String getMATKHAU() {
        return MATKHAU;
    }

    public void setMATKHAU(String MATKHAU) {
        this.MATKHAU = MATKHAU;
    }

    public static String getGIOITINH() {
        return GIOITINH;
    }

    public void setGIOITINH(String GIOITINH) {
        this.GIOITINH = GIOITINH;
    }

    public static String getNGAYSINH() {
        return NGAYSINH;
    }

    public void setNGAYSINH(String NGAYSINH) {
        this.NGAYSINH = NGAYSINH;
    }


}
