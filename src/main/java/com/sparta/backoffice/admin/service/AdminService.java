package com.sparta.backoffice.admin.service;

import com.sparta.backoffice.admin.dto.SignUpRequestDto;
import com.sparta.backoffice.admin.dto.SignUpResponseDto;
import com.sparta.backoffice.admin.entity.Admin;
import com.sparta.backoffice.admin.entity.Role;
import com.sparta.backoffice.admin.repository.AdminRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminService {

    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;

    public AdminService(AdminRepository adminRepository, PasswordEncoder passwordEncoder){
        this.adminRepository = adminRepository;
        this.passwordEncoder = passwordEncoder;
    }

    //관리자 가입 기능
    public SignUpResponseDto signup(SignUpRequestDto requestDto) {
        String email = requestDto.getEmail();
        String password = passwordEncoder.encode(requestDto.getPassword());
        String department = requestDto.getDepartment();

        // email 중복확인
        Optional<Admin> checkEmail = adminRepository.findByEmail(email);
        if (checkEmail.isPresent()) {
            throw new IllegalArgumentException("중복된 Email 입니다.");
        }

        // 권한 확인
        Role role;
        if(department.equals("커리큘럼") || department.equals("개발")){
            role = Role.MANAGER;
        } else {
            role = Role.STAFF;
        }

        // 등록
        Admin admin = new Admin(email, password, department, role);
        adminRepository.save(admin);
        return new SignUpResponseDto(admin);
    }
}
