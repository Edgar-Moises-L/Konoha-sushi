package com.konoha.sushi.user.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {

    private Long id;
    private String userName;
    private String email;
    private String password;
    private Role role;

    public User() {
    }

}
