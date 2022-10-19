package com.example.cloudmember.domains.dto;

import com.example.cloudmember.domains.entity.MemberContact;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SelectContact {
    private String cel;
    private String email;
}
