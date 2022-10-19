package com.example.cloudmember.domains.adepter;

import com.example.cloudmember.domains.dto.RequestMember;
import com.example.cloudmember.domains.dto.SelectContact;
import com.example.cloudmember.domains.entity.MemberContact;

public class MemberContactAdepter {
    public static SelectContact memberContactToDto(MemberContact contact) {
        return SelectContact.builder()
            .cel(contact.getCel())
            .email(contact.getEmail())
            .build();
    }

    public static MemberContact dtoToMemberContact(RequestMember requestMember) {
        return MemberContact.builder()
            .cel(requestMember.getCel())
            .email(requestMember.getEmail())
            .build();
    }
}
