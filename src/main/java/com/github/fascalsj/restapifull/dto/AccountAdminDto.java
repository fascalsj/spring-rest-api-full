package com.github.fascalsj.restapifull.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Setter
@Getter
public class AccountAdminDto {
    private Integer id;
    private String username;
    private String password;
}
