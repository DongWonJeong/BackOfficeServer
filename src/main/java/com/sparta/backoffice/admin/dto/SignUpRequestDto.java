package com.sparta.backoffice.admin.dto;

import com.sparta.backoffice.admin.entity.Department;
import com.sparta.backoffice.admin.entity.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class SignUpRequestDto {

    @NotBlank
    @Email(message = "올바른 이메일 형식으로 작성하세요")
    @Pattern(regexp = "[a-zA-z0-9]+@[a-zA-z]+[.]+[a-zA-z.]+")
    private String email;

    @Size(min=8, max=15, message = "비밀번호는 최소 8자 이상, 최대 15자 이하이어야 합니다." )
    @Pattern(regexp = "^[a-zA-Z0-9!@#$%^&*()_+{}:\"<>?,.\\\\/]{8,15}$",
            message = " 알파벳 대소문자(a~z)(A~Z), 숫자(0~9), 특수문자를 포함해야 합니다.")
    private String password;

    @NotBlank
    private Department department;

    @NotBlank
    private Role role;

}
