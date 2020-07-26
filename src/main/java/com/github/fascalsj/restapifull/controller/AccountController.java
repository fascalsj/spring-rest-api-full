package com.github.fascalsj.restapifull.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class AccountController {

    @GetMapping()
    public ResponseEntity<String> test(){
        return ResponseEntity.ok("BISA DIAKSES DONG HAHALA");
    }

    @PostMapping()
    @PreAuthorize("ADMIN")
    public ResponseEntity<String> test1(){
        return ResponseEntity.ok("BISA DIAKSES DONG HAHALA");
    }


}
