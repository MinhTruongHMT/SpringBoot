package com.tranminhtruong.jwtspringsercurity.service;

import java.util.List;

import com.tranminhtruong.jwtspringsercurity.model.NhanVien;

public interface NguoiDungService {

    NhanVien saveEmployee(NhanVien employee);

    List<NhanVien> getAllNguoiDung();

    NhanVien getNguoiDungById(long id);

    NhanVien updateEmployee(NhanVien employee, long id);

    void deleteEmployee(long id);

    NhanVien findByUsername(String userName);


}
