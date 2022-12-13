package com.tranminhtruong.jwtspringsercurity.controller;

import com.tranminhtruong.jwtspringsercurity.model.NhanVien;
import com.tranminhtruong.jwtspringsercurity.model.SanPham;
import com.tranminhtruong.jwtspringsercurity.service.SanPhamService;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Valid
@CrossOrigin
@RestController
public class SanPhamController {

    private SanPhamService sanPhamService;

    public SanPhamController(SanPhamService sanPhamService) {
        super();
        this.sanPhamService = sanPhamService;
    }

    @GetMapping("/sanphams")
    public List<SanPham> getAllEmployees(){
        return sanPhamService.getAllSanPham();
    }
    @PostMapping("/sanpham")
        public ResponseEntity<?> saveProduct(@RequestBody SanPham product) throws Exception {
        return ResponseEntity.ok(sanPhamService.saveEmployee(product));
    }
}
