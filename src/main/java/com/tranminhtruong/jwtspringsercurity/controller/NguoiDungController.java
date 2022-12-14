package com.tranminhtruong.jwtspringsercurity.controller;

import java.util.List;

import com.tranminhtruong.jwtspringsercurity.config.JwtTokenUtil;
import com.tranminhtruong.jwtspringsercurity.model.JwtRequest;
import com.tranminhtruong.jwtspringsercurity.model.NhanVien;
import com.tranminhtruong.jwtspringsercurity.model.NhanVienResponse;
import com.tranminhtruong.jwtspringsercurity.service.JwtUserDetailsService;
import com.tranminhtruong.jwtspringsercurity.service.NguoiDungService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.authentication.AuthenticationManager;


@CrossOrigin
@RestController
public class NguoiDungController {
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUserDetailsService jwtUserDetailsService;
    private NguoiDungService employeeService;
    @Autowired
    private JwtUserDetailsService userDetailsService;

    @PostMapping("/authenticate")
    public String generateToken(@RequestBody JwtRequest authRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
            );
        } catch (Exception ex) {
            throw new Exception("inavalid username/password");
        }
        return jwtTokenUtil.generateToken(jwtUserDetailsService.loadUserByUsername(authRequest.getUsername()));
    }


    public NguoiDungController(NguoiDungService employeeService) {
        super();
        this.employeeService = employeeService;
    }

    // build create employee REST API
    @PostMapping("/register")
    public ResponseEntity<?> saveUser(@RequestBody NhanVien user) throws Exception {
        return ResponseEntity.ok(userDetailsService.save(user));
    }


    // build get all employees REST API
    @GetMapping("/admin/users")
    public List<NhanVien> getAllEmployees() {
        return employeeService.getAllNguoiDung();
    }

    // build get employee by id REST API
    // http://localhost:8080/api/employees/1
    @GetMapping("{id}")
    public ResponseEntity<NhanVienResponse> getNguoiDungById(@PathVariable("id") long employeeId) {


        return new ResponseEntity<NhanVienResponse>(new NhanVienResponse(employeeService.getNguoiDungById(employeeId)) , HttpStatus.OK);
    }

    // build update employee REST API
    // http://localhost:8080/api/employees/1
    @PutMapping("/admin/{id}")
    public ResponseEntity<NhanVien> updateEmployee(@PathVariable("id") long id
            , @RequestBody NhanVien employee) {
        return new ResponseEntity<NhanVien>(employeeService.updateEmployee(employee, id), HttpStatus.OK);
    }

    // build delete employee REST API
    // http://localhost:8080/api/employees/1
    @DeleteMapping("/admin/{id}")
    @Transactional
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id) {

        // delete employee from DB
        employeeService.deleteEmployee(id);
        return new ResponseEntity<String>("Employee deleted successfully!.", HttpStatus.OK);
    }


}