package com.example.cloudmember.domains.entity;

import com.example.cloudmember.domains.enums.Grant;

import javax.persistence.*;

@Entity
@Table()
public class MemberRole {
    @Id
    @GeneratedValue
    @Column(name = "role_id")
    private Long id;
    private String role;
    private Grant grant;
}
