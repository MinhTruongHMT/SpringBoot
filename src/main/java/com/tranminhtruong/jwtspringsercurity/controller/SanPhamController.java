package com.tranminhtruong.jwtspringsercurity.controller;

import com.tranminhtruong.jwtspringsercurity.model.NhanVien;
import com.tranminhtruong.jwtspringsercurity.model.SanPham;
import com.tranminhtruong.jwtspringsercurity.service.SanPhamService;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/user")
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

    @GetMapping("/sanpham/{id}")
    public ResponseEntity<SanPham> getNguoiDungById(@PathVariable("id") String employeeId) {
        return new ResponseEntity<SanPham>(sanPhamService.getSanPhamById(employeeId), HttpStatus.OK);
    }
    @PutMapping("/sanpham/{id}")
    public ResponseEntity<SanPham> updateEmployee(@PathVariable("id") String id
            , @RequestBody SanPham employee) {
        return new ResponseEntity<SanPham>(sanPhamService.updateProduct(employee, id), HttpStatus.OK);
    }

    // build delete employee REST API
    // http://localhost:8080/api/employees/1
    @DeleteMapping("/sanpham/{id}")
    @Transactional
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") String id) {

        // delete employee from DB
        sanPhamService.deleteProduct(id);
        return new ResponseEntity<String>("Employee deleted successfully!.", HttpStatus.OK);
    }
}
