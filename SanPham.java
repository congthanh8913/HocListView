package model;

import java.io.Serializable;

public class SanPham implements Serializable {
    int hinh;
    String ten;
    int gia,SoLuongMua;

    public SanPham() {
    }

    public SanPham(int hinh, String ten, int gia) {
        this.hinh = hinh;
        this.ten = ten;
        this.gia = gia;


    }

    public int getHinh() {
        return hinh;
    }

    public void setHinh(int hinh) {
        this.hinh = hinh;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public int getSoLuongMua() {
        return SoLuongMua;
    }

    public void setSoLuongMua(int soLuongMua) {
        SoLuongMua = soLuongMua;
    }
}
