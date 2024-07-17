package com.sparta.backoffice.admin.entity;

import lombok.Getter;

@Getter
public enum Role {
    MANAGER(Authority.MANAGER),
    STAFF(Authority.STAFF);


    private final String authority;

    Role(String authority) {
        this.authority = authority;
    }

    public static class Authority {
        public static final String MANAGER = "ROLE_MANAGER";
        public static final String STAFF = "ROLE_STAFF";

    }
}