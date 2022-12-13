package com.tranminhtruong.jwtspringsercurity.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Table(name = "sanpham")
public class SanPham {
    @Id
    @Column(name = "masp")
    @NotBlank(message ="masp thiếu" )
    private String masp;
    @Column(name = "dovitinh")
    @NotBlank(message ="dovitinh thiếu" )
    private String dovitinh;
    @Column(name = "name")
    private String name;
    @Column(name = "gia")
    private float gia;
    @Column(name = "hsd")
    private Date hsd;

    public String getMasp() {
        return masp;
    }

    public void setMasp(String masp) {
        this.masp = masp;
    }

    public String getDovitinh() {
        return dovitinh;
    }

    public void setDovitinh(String dovitinh) {
        this.dovitinh = dovitinh;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getGia() {
        return gia;
    }

    public void setGia(float gia) {
        this.gia = gia;
    }

    public Date getHsd() {
        return hsd;
    }

    public void setHsd(Date hsd) {
        this.hsd = hsd;
    }
}
