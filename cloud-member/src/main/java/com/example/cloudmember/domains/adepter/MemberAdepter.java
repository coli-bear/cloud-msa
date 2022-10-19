package com.example.cloudmember.domains.adepter;

import com.example.cloudmember.domains.dto.RequestMember;
import com.example.cloudmember.domains.dto.ResponseMember;
import com.example.cloudmember.domains.entity.Member;
import com.example.cloudmember.domains.entity.MemberBasic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public class MemberAdepter {

    public static Collection<ResponseMember> entitiesToCollection(Collection<Member> members) {
        return members.stream().map(MemberAdepter::entityToDto).collect(Collectors.toCollection(ArrayList::new));
    }

    private static ResponseMember entityToDto(Member member) {
        return ResponseMember.builder()
            .id(member.getIdx())
            .basic(member.getBasic())
            .createTime(member.getCreateTime())
            .build();
    }

    public static ResponseMember createDetail(Member member) {
        return ResponseMember.builder()
            .id(member.getIdx())
            .basic(member.getBasic())
            .createTime(member.getCreateTime())
            .updateTime(member.getUpdateTime())
            .credential(MemberCredentialAdepter.memberCredentialToDto(member.getCredential()))
            .contact(MemberContactAdepter.memberContactToDto(member.getContact()))
            .build();
    }

    public static Member dtoToEntity(RequestMember requestMember) {
        MemberBasic memberBasic = MemberBasicAdepter.dtoToMemberBasic(requestMember);
        return Member.builder()
            .basic(memberBasic)
            .credential(MemberCredentialAdepter.dtoToMemberCredential(requestMember))
            .build();
    }
}
