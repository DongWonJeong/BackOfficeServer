package com.sparta.backoffice.admin.controller;

import com.sparta.backoffice.admin.dto.SignUpRequestDto;
import com.sparta.backoffice.admin.dto.SignUpResponseDto;
import com.sparta.backoffice.admin.service.AdminService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admins")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    // 관리자 가입 기능
    @PostMapping("/signup")
    public ResponseEntity<SignUpResponseDto> signup(@RequestBody @Valid SignUpRequestDto requestDto) {
        SignUpResponseDto signUpResponseDto = adminService.signup(requestDto);

        // 가입 성공 했을 때 Signup successful 반환
        return ResponseEntity.status(HttpStatus.OK).body(signUpResponseDto);

    }
}
