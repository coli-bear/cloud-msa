package com.example.cloudmember.domains.adepter;

import com.example.cloudmember.domains.dto.RequestMember;
import com.example.cloudmember.domains.dto.SelectCredential;
import com.example.cloudmember.domains.entity.MemberCredential;

public class MemberCredentialAdepter {
    public static SelectCredential memberCredentialToDto(MemberCredential credential) {
        return SelectCredential.builder()
            .account(credential.getAccount())
            .failCount(credential.getFailCount())
            .build();
    }

    public static MemberCredential dtoToMemberCredential(RequestMember requestMember) {
        return MemberCredential.builder()
            .account(requestMember.getAccount())
            .password(requestMember.getPassword())
            .build();
    }
}
