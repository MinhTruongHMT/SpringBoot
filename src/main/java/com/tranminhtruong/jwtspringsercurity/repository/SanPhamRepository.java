package com.tranminhtruong.jwtspringsercurity.repository;

import com.tranminhtruong.jwtspringsercurity.model.NhanVien;
import com.tranminhtruong.jwtspringsercurity.model.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SanPhamRepository extends JpaRepository<SanPham,String> {
    SanPham findSanPhamsByMasp(String manv);
}
