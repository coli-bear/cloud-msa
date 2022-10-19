package com.example.cloudmember.domains.dto;

import lombok.Data;

@Data
public class RequestMember {
    private String username;
    private String account;
    private String password;
    private String cel;
    private String email;
}
