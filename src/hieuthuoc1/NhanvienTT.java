/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hieuthuoc1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class NhanvienTT {

    SimpleDateFormat fm = new SimpleDateFormat("yyyy/MM/dd");

    public int add(NhanVien nv) {
        Connection conn = null;
        PreparedStatement sttm = null;
        try {
            String sql = "insert into Nhanvien values (?,?,?,?,?,?,?)";
            conn = databaseuntil.getDBConnect();
            sttm = conn.prepareStatement(sql);
            sttm.setString(1, nv.getMaNV());
            sttm.setString(2, nv.getHoTen());
            sttm.setString(3, fm.format(nv.getNgaySinh()));
            sttm.setString(4, nv.getGioiTinh());
            sttm.setString(5, nv.getSDT());
            sttm.setString(6, nv.getGmail());
            sttm.setInt(7, nv.getLuong());

            if (sttm.executeUpdate() > 0) {
                System.out.println("add thành công");
                return 1;
            }
        } catch (Exception e) {
            System.out.println("Error:" + e.toString());
        } finally {
            try {
                conn.close();
                sttm.close();
            } catch (Exception e) {
            }

        }
        return -1;
    }

    public int edit(NhanVien nv) {
        Connection conn = null;
        PreparedStatement sttm = null;
        try {
            String sql = "update  Nhanvien set [Họ tên]= ? , [Ngày sinh]= ? ,[Giới tính] = ? ,SDT = ? ,Gmail =? ,Lương =? Where MaNV = ?";
            conn = databaseuntil.getDBConnect();
            sttm = conn.prepareStatement(sql);

            sttm.setString(1, nv.getHoTen());
            sttm.setString(2, fm.format(nv.getNgaySinh()));
            sttm.setString(3, nv.getGioiTinh());
            sttm.setString(4, nv.getSDT());
            sttm.setString(5, nv.getGmail());
            sttm.setInt(6, nv.getLuong());
            sttm.setString(7, nv.getMaNV());

            if (sttm.executeUpdate() > 0) {
                System.out.println("edit thành công");
                return 1;
            }
        } catch (Exception e) {
            System.out.println("Error:" + e.toString());
        } finally {
            try {
                conn.close();
                sttm.close();
            } catch (Exception e) {
            }

        }
        return -1;
    }

    public int del(String maNV) {
        Connection conn = null;
        PreparedStatement sttm = null;
        try {
            String sql = "delete  Nhanvien  Where MaNV = ?";
            conn = databaseuntil.getDBConnect();
            sttm = conn.prepareStatement(sql);

            sttm.setString(1, maNV);

            if (sttm.executeUpdate() > 0) {
                System.out.println("xóa thành công");
                return 1;
            }
        } catch (Exception e) {
            System.out.println("Error:" + e.toString());
        } finally {
            try {
                conn.close();
                sttm.close();
            } catch (Exception e) {
            }

        }
        return -1;
    }

    ////////////////////////////////////////////
    public List<NhanVien> getAllnv() {
        List<NhanVien> lnv = new ArrayList<>();
        Connection conn = null;
        Statement sttm = null;
        ResultSet rs = null;
        try {
            String sql = "select MaNV,[Họ tên] , [Ngày sinh],[Giới tính] ,SDT  ,Gmail ,Lương from Nhanvien order by MaNV desc ";
            conn = databaseuntil.getDBConnect();
            sttm = conn.createStatement();
            rs = sttm.executeQuery(sql);
            while (rs.next()) {
                NhanVien nv = new NhanVien();

                nv.setMaNV(rs.getString(1));
                nv.setHoTen(rs.getString(2));
                SimpleDateFormat fa = new SimpleDateFormat("yyyy-MM-dd");
                nv.setNgaySinh(fa.parse(rs.getString(3)));
                nv.setGioiTinh(rs.getString(4));
                nv.setSDT(rs.getString(5));
                nv.setGmail(rs.getString(6));
                nv.setLuong(rs.getInt(7));
                lnv.add(nv);

            }
        } catch (Exception e) {
            System.out.println("error: " + e.toString());
        } finally {
            try {
                rs.close();
                sttm.close();
                conn.close();
            } catch (Exception e) {
            }
        }
        return lnv;
    }

    public NhanVien getNhanVienByID(String MaNV) {
        Connection conn = null;
        PreparedStatement sttm = null;
        ResultSet rs = null;
        NhanVien nv = new NhanVien();
        try {
            String sql = "select MaNV,[Họ tên] , [Ngày sinh],[Giới tính] ,SDT  ,Gmail ,Lương from Nhanvien where MaNV = ?";
            conn = databaseuntil.getDBConnect();
            sttm = conn.prepareStatement(sql);
            sttm.setString(1, MaNV);
            rs = sttm.executeQuery();

            while (rs.next()) {

                nv.setMaNV(rs.getString(1));
                nv.setHoTen(rs.getString(2));
                SimpleDateFormat fa = new SimpleDateFormat("yyyy-MM-dd");
                nv.setNgaySinh(fa.parse(rs.getString(3)));
                nv.setGioiTinh(rs.getString(4));
                nv.setSDT(rs.getString(5));
                nv.setGmail(rs.getString(6));
                nv.setLuong(rs.getInt(7));

                return nv;

            }
        } catch (Exception e) {
            System.out.println("error: " + e.toString());
        } finally {
            try {
                rs.close();
                sttm.close();
                conn.close();
            } catch (Exception e) {
            }
        }
        return null;
    }

    public static void main(String[] args) {

    }
}
