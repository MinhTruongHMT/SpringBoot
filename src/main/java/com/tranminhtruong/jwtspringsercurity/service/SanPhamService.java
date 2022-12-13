package com.tranminhtruong.jwtspringsercurity.service;

import com.tranminhtruong.jwtspringsercurity.model.NhanVien;
import com.tranminhtruong.jwtspringsercurity.model.SanPham;

import java.util.List;

public interface SanPhamService {
    SanPham saveEmployee(SanPham product);

    List<SanPham> getAllSanPham();

    SanPham getSanPhamById(String id);

    SanPham updateProduct(SanPham product, String id);

    void deleteProduct(String id);


}
