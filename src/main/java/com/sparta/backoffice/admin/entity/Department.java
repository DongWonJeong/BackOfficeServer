package com.sparta.backoffice.admin.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Department {

    DEV("개발"),
    CURRICULUM("커리큘럼"),
    MARKETING("마케팅");

    private final String department;
}
