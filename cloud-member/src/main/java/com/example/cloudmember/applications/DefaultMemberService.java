package com.example.cloudmember.applications;


import com.example.cloudmember.domains.adepter.MemberAdepter;
import com.example.cloudmember.domains.adepter.MemberBasicAdepter;
import com.example.cloudmember.domains.adepter.MemberContactAdepter;
import com.example.cloudmember.domains.dto.RequestMember;
import com.example.cloudmember.domains.dto.ResponseMember;
import com.example.cloudmember.domains.entity.Member;
import com.example.cloudmember.domains.entity.MemberBasic;
import com.example.cloudmember.domains.entity.MemberContact;
import com.example.cloudmember.domains.enums.CommonCode;
import com.example.cloudmember.domains.repository.MemberRepository;
import com.example.cloudmember.exception.AreadyExistException;
import com.example.cloudmember.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Optional;


@Service(value = "defaultMemberService")
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class DefaultMemberService implements MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public ResponseMember saveMember(RequestMember requestMember) {

        Member member = MemberAdepter.dtoToEntity(requestMember);

        MemberContact contact = MemberContactAdepter.dtoToMemberContact(requestMember);
        member.changeContact(contact);

        try {
            memberRepository.save(member);
        } catch (Exception e) {
            throw new AreadyExistException(CommonCode.ALREADY_EXIST, "already exists member : " + requestMember.getAccount());
        }
        return MemberAdepter.createDetail(member);
    }

    public ResponseMember findById(Long id) {
        Optional<Member> findMember = memberRepository.findById(id);
        if (findMember.isPresent()) {
            return MemberAdepter.createDetail(findMember.get());
        }

        throw new NotFoundException(CommonCode.NOT_FOUND, "member not found : " + id);
    }

    public Collection<ResponseMember> findAll() {
        return MemberAdepter.entitiesToCollection(memberRepository.findAll());
    }

    @Transactional
    public void updateMember(Long id, RequestMember requestMember) {
        Optional<Member> findMember =  memberRepository.findById(id);

        if (findMember.isPresent()) {
            this.updateMember(findMember.get(), requestMember);
        }

        throw new AreadyExistException(CommonCode.NOT_FOUND, "member not found : " + id);
    }

    private void updateMember(Member before, RequestMember after) {
        MemberBasic afterMember = MemberBasicAdepter.dtoToMemberBasic(after);

        if (before.getBasic() != afterMember) {
            before.changeBasic(afterMember);
        }

        MemberContact afterContact = MemberContactAdepter.dtoToMemberContact(after);
        if (before.getContact() != afterContact) {
            before.changeContact(afterContact);
        }
    }
}
