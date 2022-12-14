package com.tranminhtruong.jwtspringsercurity.service;


import java.util.List;
import com.tranminhtruong.jwtspringsercurity.model.NhanVien;
import com.tranminhtruong.jwtspringsercurity.repository.NguoiDungRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;



@Service
public class NguoiDungServiceImpl implements NguoiDungService {

    private NguoiDungRepository employeeRepository;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    public NguoiDungServiceImpl(NguoiDungRepository employeeRepository) {
        super();
        this.employeeRepository = employeeRepository;
    }

    @Override
    public NhanVien saveEmployee(NhanVien employee) {
        // TODO Auto-generated method stub
        return employeeRepository.save(employee);
    }

    @Override
    public List<NhanVien> getAllNguoiDung() {
        // TODO Auto-generated method stub
        return employeeRepository.findAll();

    }

    @Override
    public NhanVien getNguoiDungById(long id) {
        return employeeRepository.findById(id);
    }


    @Override
    public void deleteEmployee(long id) {
        employeeRepository.deleteById(id);

    }

    @Override
    public NhanVien updateEmployee(NhanVien oDA, long id) {
        // TODO Auto-generated method stub
        NhanVien nDA = employeeRepository.findById(id);
        nDA.setPassword(oDA.getPassword());
        nDA.setUsername(oDA.getUsername());
        nDA.setPassword(bcryptEncoder.encode(oDA.getPassword()));
        nDA.setAuthorities(oDA.getAuthorities());
        return employeeRepository.save(nDA);
    }

    @Override
    public NhanVien findByUsername(String userName) {
        // TODO Auto-generated method stub
        return employeeRepository.findNhanVienByUsername(userName);
    }



}