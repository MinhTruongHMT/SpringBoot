package com.tranminhtruong.jwtspringsercurity.service;

import java.util.ArrayList;
import java.util.List;

import com.tranminhtruong.jwtspringsercurity.model.NhanVien;
import com.tranminhtruong.jwtspringsercurity.repository.NguoiDungRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;



@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private NguoiDungRepository userRepository;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        NhanVien user = userRepository.findNhanVienByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
        GrantedAuthority authority = new SimpleGrantedAuthority(user.getAuthorities());
        System.out.println("phan nay la quyen "+authority);
        grantList.add(authority);
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                grantList);
    }

    public NhanVien save(NhanVien user) {

        NhanVien newUser = new NhanVien();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
        newUser.setAuthorities(user.getAuthorities());
        newUser.setEmail(user.getEmail());
        return userRepository.save(newUser);

    }
}