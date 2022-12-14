package com.tranminhtruong.jwtspringsercurity.model;

public class NhanVienResponse {
    private String fullname;
    private String email;
    private  String authorities;

    public NhanVienResponse(NhanVien nv) {
        this.fullname = nv.getFullname();
        this.email = nv.getEmail();
        this.authorities = nv.getAuthorities();
    }

    public String getUsername() {
        return fullname;
    }

    public void setUsername(String username) {
        this.fullname = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAuthorities() {
        return authorities;
    }

    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }
}
