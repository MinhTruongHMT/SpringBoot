package com.tranminhtruong.jwtspringsercurity.model;

import javax.persistence.*;

@Entity
@Table(name = "nhanvien")
public class NhanVien {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Manv;
    @Column
    private String username;
    @Column
    private String Email;
    @Column
    private String password;
    @Column
    private String authorities;

    public Long getManv() {
        return Manv;
    }

    public void setManv(Long manv) {
        Manv = manv;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAuthorities() {
        return authorities;
    }

    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }
}