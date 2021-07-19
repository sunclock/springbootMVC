package com.sunclock.book.springbootMVC.domain.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {
    // in spring security, prefix of key value should be "ROLE_"
    // ',' not ';' !!!!!!!!!!
    GUEST("ROLE_GUEST", "손님"),
    USER("ROLE_USER", "일반 사용자");

    private final String key;
    private final String title;

}
