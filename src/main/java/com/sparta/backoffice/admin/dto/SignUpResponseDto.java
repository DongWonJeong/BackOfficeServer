package com.sparta.backoffice.admin.dto;

import com.sparta.backoffice.admin.entity.Admin;
import com.sparta.backoffice.admin.entity.Department;
import com.sparta.backoffice.admin.entity.Role;
import lombok.Getter;

@Getter
public class SignUpResponseDto {

    private final String email;
    private final Department department;
    private final Role role;

    public SignUpResponseDto(Admin admin) {
        this.email = admin.getEmail();
        this.department = admin.getDepartment();
        this.role = admin.getRole();
    }
}
