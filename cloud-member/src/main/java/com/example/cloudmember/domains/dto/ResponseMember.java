package com.example.cloudmember.domains.dto;

import com.example.cloudmember.domains.entity.MemberBasic;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class ResponseMember {
    private Long id;
    private MemberBasic basic;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    private SelectCredential credential;
    private SelectContact contact;
}
