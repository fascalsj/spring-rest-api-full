package com.github.fascalsj.restapifull.authentication_module.controller;


import com.github.fascalsj.restapifull.authentication_module.dto.AuthenticationRequestDto;
import com.github.fascalsj.restapifull.authentication_module.dto.AuthenticationResponseDto;
import com.github.fascalsj.restapifull.authentication_module.service.AuthenticationService;
import com.github.fascalsj.restapifull.response.ResponseSuccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;

@Controller
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/authenticate")
    public ResponseEntity<ResponseSuccess<Object>> generateToken(@RequestBody AuthenticationRequestDto authenticationRequestDto) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequestDto.getUsername(), authenticationRequestDto.getPassword()));
        String token = authenticationService.generateToken(authenticationRequestDto);
        return ResponseEntity.ok(ResponseSuccess.builder()
                .result("SUCCESS")
                .timestamp(new Date(System.currentTimeMillis()))
                .message("Authentication Success")
                .data(AuthenticationResponseDto.builder().token(token).build())
                .build());
    }
}