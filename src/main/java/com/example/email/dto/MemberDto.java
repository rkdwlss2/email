package com.example.email.dto;

import com.example.email.entity.RoleType;
import lombok.Getter;

@Getter
public class MemberDto {
    private String username;
    private String password;
    private RoleType roleType;
}
