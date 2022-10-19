package com.example.cloudmember.domains;

import lombok.Getter;

import javax.persistence.*;

@Getter
@MappedSuperclass
public class BaseEntity extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idx", nullable = false)
    private Long idx;
}