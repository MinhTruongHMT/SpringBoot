package com.tranminhtruong.jwtspringsercurity.service;

import com.tranminhtruong.jwtspringsercurity.model.NhanVien;
import com.tranminhtruong.jwtspringsercurity.model.SanPham;
import com.tranminhtruong.jwtspringsercurity.repository.NguoiDungRepository;
import com.tranminhtruong.jwtspringsercurity.repository.SanPhamRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SanPhamServiceImpl implements SanPhamService{

    private SanPhamRepository productRepository;

    public SanPhamServiceImpl(SanPhamRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public SanPham saveEmployee(SanPham product) {
        return productRepository.save(product);
    }

    @Override
    public List<SanPham> getAllSanPham() {
        return productRepository.findAll();
    }

    @Override
    public SanPham getSanPhamById(String id) {
        return productRepository.findSanPhamsByName(id);
    }

    @Override
    public SanPham updateProduct(SanPham product, String id) {
        SanPham nDA = productRepository.findSanPhamsByName(id);
        nDA.setGia(Float.parseFloat(product.getGia()+""));
        nDA.setHsd(null);
        nDA.setName(product.getName());
        nDA.setDovitinh(product.getDovitinh());
        nDA.setMasp(product.getMasp());
        return productRepository.save(nDA);
    }

    @Override
    public void deleteProduct(String id) {
        productRepository.deleteById(id);
    }


}
