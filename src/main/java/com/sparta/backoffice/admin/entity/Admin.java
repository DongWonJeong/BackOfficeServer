package com.sparta.backoffice.admin.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "admin")
@NoArgsConstructor
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    //이메일
    @Column(nullable = false)
    private String email;

    //비밀번호
    @Column(nullable = false)
    private String password;

    //부서
    @Column(nullable = false)
    private String department;

    //권한
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    public Admin(String email, String password, String department, Role role) {
        this.email = email;
        this.password = password;
        this.department = department;
        this.role = role;
    }
}
