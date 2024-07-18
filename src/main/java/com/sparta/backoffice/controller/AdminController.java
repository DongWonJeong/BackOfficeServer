package com.sparta.backoffice.controller;

import com.sparta.backoffice.dto.SignUpRequestDto;
import com.sparta.backoffice.dto.SignUpResponseDto;
import com.sparta.backoffice.service.AdminService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
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

        // 가입 성공
        return ResponseEntity.status(HttpStatus.OK).body(signUpResponseDto);
    }
}
