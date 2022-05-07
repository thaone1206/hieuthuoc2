/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hieuthuoc1;

import java.util.Date;




/**
 *
 * @author ADMIN
 */
public class NhanVien {

    private String MaNV;
    private String HoTen;
    private Date ngaySinh;
    private String gioiTinh;
    private String SDT;
    private String Gmail;
    private int luong;

    public NhanVien(String MaNV, String HoTen, Date ngaySinh, String gioiTinh, String SDT, String Gmail, int luong) {
        this.MaNV = MaNV;
        this.HoTen = HoTen;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.SDT = SDT;
        this.Gmail = Gmail;
        this.luong = luong;
    }

    public NhanVien() {
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getGmail() {
        return Gmail;
    }

    public void setGmail(String Gmail) {
        this.Gmail = Gmail;
    }

    public int getLuong() {
        return luong;
    }

    public void setLuong(int luong) {
        this.luong = luong;
    }

}
