package com.sunclock.book.springbootMVC.config.auth.dto;

import com.sunclock.book.springbootMVC.domain.user.User;
import lombok.Getter;

import java.io.Serializable;

// Were not for SessionUser, error below occurs
// 'Failed to convert from type [java.lang.Object]
// to type [byte[]] for value 'com.sunclock.book.springboot.domain.user.User@ra43d6'
// For better performance, to prevent side effect, we use Serializable SessionUser!
@Getter
public class SessionUser implements Serializable {
    private String name;
    private String email;
    private String picture;

    public SessionUser(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
    }
}
