package com.example.to_khai_y_te.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;


@Entity
public class ToKhaiYTe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Họ và tên không được để trống")
    private String hoTen;

    private int namSinh;

    @NotBlank(message = "Giới tính không được để trống")
    private String gioiTinh;

    @NotBlank(message = "Quốc tịch không được để trống")
    private String quocTich;

    @NotBlank(message = "Số hộ chiếu hoặc CMND không được để trống")
    private String soHoChieu;

    private String phuongTien;
    private String soHieuPhuongTien;
    private String soGhe;
    private String ngayKhoiHanh;
    private String ngayKetThuc;

    private String diaChiTinh;
    private String diaChiHuyen;
    private String diaChiXa;
    private String diaChiNoiO;

    @NotBlank(message = "Số điện thoại không được để trống")
    private String dienThoai;

    private String email;

    private boolean trieuChungSot;
    private boolean trieuChungHo;
    private boolean trieuChungKhoTho;
    private boolean trieuChungDauHong;
    private boolean trieuChungNon;
    private boolean trieuChungTieuChay;

    private boolean lichSuChanNuoi;
    private boolean lichSuTiepXucCovid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isLichSuTiepXucCovid() {
        return lichSuTiepXucCovid;
    }

    public void setLichSuTiepXucCovid(boolean lichSuTiepXucCovid) {
        this.lichSuTiepXucCovid = lichSuTiepXucCovid;
    }

    public boolean isLichSuChanNuoi() {
        return lichSuChanNuoi;
    }

    public void setLichSuChanNuoi(boolean lichSuChanNuoi) {
        this.lichSuChanNuoi = lichSuChanNuoi;
    }

    public boolean isTrieuChungNon() {
        return trieuChungNon;
    }

    public void setTrieuChungNon(boolean trieuChungNon) {
        this.trieuChungNon = trieuChungNon;
    }

    public boolean isTrieuChungTieuChay() {
        return trieuChungTieuChay;
    }

    public void setTrieuChungTieuChay(boolean trieuChungTieuChay) {
        this.trieuChungTieuChay = trieuChungTieuChay;
    }

    public boolean isTrieuChungDauHong() {
        return trieuChungDauHong;
    }

    public void setTrieuChungDauHong(boolean trieuChungDauHong) {
        this.trieuChungDauHong = trieuChungDauHong;
    }

    public boolean isTrieuChungKhoTho() {
        return trieuChungKhoTho;
    }

    public void setTrieuChungKhoTho(boolean trieuChungKhoTho) {
        this.trieuChungKhoTho = trieuChungKhoTho;
    }

    public boolean isTrieuChungHo() {
        return trieuChungHo;
    }

    public void setTrieuChungHo(boolean trieuChungHo) {
        this.trieuChungHo = trieuChungHo;
    }

    public boolean isTrieuChungSot() {
        return trieuChungSot;
    }

    public void setTrieuChungSot(boolean trieuChungSot) {
        this.trieuChungSot = trieuChungSot;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDienThoai() {
        return dienThoai;
    }

    public void setDienThoai(String dienThoai) {
        this.dienThoai = dienThoai;
    }

    public String getDiaChiNoiO() {
        return diaChiNoiO;
    }

    public void setDiaChiNoiO(String diaChiNoiO) {
        this.diaChiNoiO = diaChiNoiO;
    }

    public String getDiaChiHuyen() {
        return diaChiHuyen;
    }

    public void setDiaChiHuyen(String diaChiHuyen) {
        this.diaChiHuyen = diaChiHuyen;
    }

    public String getDiaChiXa() {
        return diaChiXa;
    }

    public void setDiaChiXa(String diaChiXa) {
        this.diaChiXa = diaChiXa;
    }

    public String getDiaChiTinh() {
        return diaChiTinh;
    }

    public void setDiaChiTinh(String diaChiTinh) {
        this.diaChiTinh = diaChiTinh;
    }

    public String getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(String ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public String getNgayKhoiHanh() {
        return ngayKhoiHanh;
    }

    public void setNgayKhoiHanh(String ngayKhoiHanh) {
        this.ngayKhoiHanh = ngayKhoiHanh;
    }

    public String getSoGhe() {
        return soGhe;
    }

    public void setSoGhe(String soGhe) {
        this.soGhe = soGhe;
    }

    public String getSoHieuPhuongTien() {
        return soHieuPhuongTien;
    }

    public void setSoHieuPhuongTien(String soHieuPhuongTien) {
        this.soHieuPhuongTien = soHieuPhuongTien;
    }

    public String getPhuongTien() {
        return phuongTien;
    }

    public void setPhuongTien(String phuongTien) {
        this.phuongTien = phuongTien;
    }

    public String getSoHoChieu() {
        return soHoChieu;
    }

    public void setSoHoChieu(String soHoChieu) {
        this.soHoChieu = soHoChieu;
    }

    public String getQuocTich() {
        return quocTich;
    }

    public void setQuocTich(String quocTich) {
        this.quocTich = quocTich;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public int getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(int namSinh) {
        this.namSinh = namSinh;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }
}
