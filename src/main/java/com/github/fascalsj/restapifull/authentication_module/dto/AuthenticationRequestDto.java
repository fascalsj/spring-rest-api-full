package com.github.fascalsj.restapifull.authentication_module.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AuthenticationRequestDto {
    private String username;
    private String password;
}
