package com.tranminhtruong.jwtspringsercurity.repository;

import com.tranminhtruong.jwtspringsercurity.model.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


@Repository
public interface NguoiDungRepository extends JpaRepository<NhanVien, Long> {

    NhanVien findNhanVienByUsername(String manv);
    NhanVien findById(long id);
    void deleteById(long id);


}