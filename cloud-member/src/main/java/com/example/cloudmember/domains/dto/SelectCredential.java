package com.example.cloudmember.domains.dto;

import com.example.cloudmember.domains.entity.MemberCredential;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SelectCredential {

    private String account;
    private int failCount;
}
