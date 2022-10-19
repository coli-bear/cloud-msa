package com.example.cloudmember.domains.adepter;

import com.example.cloudmember.domains.dto.RequestMember;
import com.example.cloudmember.domains.entity.MemberBasic;

public class MemberBasicAdepter {
    public static MemberBasic dtoToMemberBasic(RequestMember requestMember) {
        return MemberBasic.builder()
            .username(requestMember.getUsername())
            .disabled(false)
            .build();
    }
}
