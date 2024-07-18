package com.sparta.backoffice.dto;

import com.sparta.backoffice.entity.Admin;
import com.sparta.backoffice.entity.Role;
import lombok.Getter;

@Getter
public class SignUpResponseDto {

    private final String email;
    private final String department;
    private final Role role;

    public SignUpResponseDto(Admin admin) {
        this.email = admin.getEmail();
        this.department = admin.getDepartment();
        this.role = admin.getRole();
    }
}
