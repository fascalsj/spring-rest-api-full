package com.github.fascalsj.restapifull.authentication_module.service;

import com.github.fascalsj.restapifull.authentication_module.dto.AuthenticationRequestDto;
import com.github.fascalsj.restapifull.authentication_module.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthenticationService implements UserDetailsService {
    @Autowired
    private JwtUtil jwtUtil;

    public UserDetails loadUserByUsername(String username) {

        List<GrantedAuthority> list = new ArrayList();
        list.add(new SimpleGrantedAuthority("ROLE_ADMIN"));

        return new User("foo", new BCryptPasswordEncoder().encode("foo"),list);
    }

    public String generateToken(AuthenticationRequestDto authenticationRequestDto) {
        return jwtUtil.generateToken(authenticationRequestDto.getUsername());
    }


}
