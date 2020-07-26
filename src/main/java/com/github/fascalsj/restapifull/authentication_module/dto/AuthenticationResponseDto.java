package com.github.fascalsj.restapifull.authentication_module.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class AuthenticationResponseDto {
    private String token;
}
